package edu.stanford.isis.epad.common.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

public class EPADTools
{
	public static String serverProxy = EPADConfig.getInstance().getParam("serverProxy");
	public static String baseAnnotationDir = EPADConfig.getInstance().getParam("baseAnnotationDir");
	public static String dbpath = EPADConfig.getInstance().getParam("dbpath");
	public static String templatePath = EPADConfig.getInstance().getParam("baseTemplatesDir");
	public static String wadoProxy = EPADConfig.getInstance().getParam("wadoProxy");
	public static final String dicomServerPort = EPADConfig.getInstance().getParam("DicomServerPort");
	public static final String aeTitle = EPADConfig.getInstance().getParam("DicomServerAETitle");
	public static final String username = EPADConfig.getInstance().getParam("username");
	public static final String password = EPADConfig.getInstance().getParam("password");
	public static final String collection = EPADConfig.getInstance().getParam("defaultcontainer");
	public static final String aim3Namespace = EPADConfig.getInstance().getParam("namespace");
	public static final String existURI = EPADConfig.getInstance().getParam("serverUrlUpload");
	public static final String eventResourceURI = EPADConfig.getInstance().getParam("eventResourceURI");
	public static final String seriesOrderURI = EPADConfig.getInstance().getParam("seriesOrderURI");

	private static final EPADLogger logger = EPADLogger.getInstance();
	private static final EPADConfig config = EPADConfig.getInstance();

	public static int feedFileWithDICOMFromWADO(File file, Map<String, String> dicomImageFileDescription)
			throws IOException
	{
		String studyIDKey = dicomImageFileDescription.get("study_iuid");
		String seriesIDKey = dicomImageFileDescription.get("series_iuid");
		String imageIDKey = dicomImageFileDescription.get("sop_iuid");

		return feedFileWithDICOMFromWADO(file, studyIDKey, seriesIDKey, imageIDKey);
	}

	public static int feedFileWithDICOMFromWADO(File temp, String studyIdKey, String seriesIdKey, String imageIdKey)
			throws IOException
	{
		String host = config.getParam("NameServer");
		int port = config.getIntParam("DicomServerWadoPort");
		String base = config.getParam("WadoUrlExtension");

		WadoUrlBuilder wadoUrlBuilder = new WadoUrlBuilder(host, port, base, WadoUrlBuilder.ContentType.FILE);

		wadoUrlBuilder.setStudyUID(studyIdKey);
		wadoUrlBuilder.setSeriesUID(seriesIdKey);
		wadoUrlBuilder.setObjectUID(imageIdKey);

		String wadoUrl = wadoUrlBuilder.build();

		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod(wadoUrl);
		int statusCode = client.executeMethod(method);

		if (statusCode == HttpServletResponse.SC_OK) {
			InputStream wadoResponseStream = null;
			OutputStream outputStream = null;
			try {
				wadoResponseStream = method.getResponseBodyAsStream();
				outputStream = new FileOutputStream(temp);
				int read = 0;
				byte[] bytes = new byte[4096];
				while ((read = wadoResponseStream.read(bytes)) != -1) {
					outputStream.write(bytes, 0, read);
				}
			} finally {
				if (wadoResponseStream != null)
					wadoResponseStream.close();
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
			}
		}
		return statusCode;
	}

	public static ArrayList<String> getDicomSeries(String seriesUID) throws Exception
	{
		ArrayList<String> result = null;
		String url = seriesOrderURI + "?series_iuid=" + seriesUID;

		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod(url);
		int statusCode = client.executeMethod(method);
		if (statusCode != -1) {
			// Get the result as stream
			BufferedReader reader = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(), "UTF-8"));
			result = new ArrayList<String>();
			String line;
			while ((line = reader.readLine()) != null) {
				String[] cols = line.split(",");
				if (cols != null && cols.length > 1) {
					String imgIUD = cols[0];
					if (imgIUD.endsWith(".dcm")) {
						result.add(convertDicomNameToImageUID(imgIUD));
					}
				}
			}
		}
		return result;
	}

	public static void dcmsnd(String inputPathFile, boolean throwException) throws Exception
	{
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;

		try {
			String dcmServerTitlePort = aeTitle + "@localhost:" + dicomServerPort;
			dcmServerTitlePort = dcmServerTitlePort.trim();

			logger.info("Sending 1 file - command: ./dcmsnd " + dcmServerTitlePort + " " + inputPathFile);

			String[] command = { "./dcmsnd", dcmServerTitlePort, inputPathFile };

			ProcessBuilder pb = new ProcessBuilder(command);
			String dicomBinDirectoryPath = ResourceUtils.getEPADWebServerDICOMBinDir();
			logger.info("DICOM binary directory: " + dicomBinDirectoryPath);
			pb.directory(new File(dicomBinDirectoryPath));

			Process process = pb.start();
			process.getOutputStream();// get the output stream.
			// Read out dir output
			is = process.getInputStream();
			isr = new InputStreamReader(is);

			br = new BufferedReader(isr);
			String line;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}

			try { // Wait to get exit value
				@SuppressWarnings("unused")
				int exitValue = process.waitFor(); // keep.
				// long totalTime = System.currentTimeMillis() - startTime;
				// log.info("Tags exit value is: " + exitValue+" and took: "+totalTime+" ms");
			} catch (InterruptedException e) {
				logger.info("Didn't send DICOM files in: " + inputPathFile);
			}
			String cmdLineOutput = sb.toString();
			logger.info(cmdLineOutput);

			if (cmdLineOutput.toLowerCase().contains("error")) {
				throw new IllegalStateException("Failed for: " + cmdLineOutput);
			}
		} catch (Exception e) {
			if (e instanceof IllegalStateException && throwException) {
				throw e;
			}
			logger.warning("DicomHeadersTask failed to create DICOM tags file: " + e.getMessage());
			if (throwException) {
				throw new IllegalStateException("DicomHeadersTask failed to create DICcom tags file.", e);
			}
		} catch (OutOfMemoryError oome) {
			logger.warning("DicomHeadersTask OutOfMemoryError: ");
			if (throwException) {
				throw new IllegalStateException("DicomHeadersTask OutOfMemoryError: ", oome);
			}
		} finally {
			close(br);
			close(isr);
			close(is);
		}
	}

	public static int getPositionOfImageInSeries(String seriesUID, String imageIUD) throws Exception
	{
		@SuppressWarnings("unused")
		ArrayList<String> result = null;
		String url = seriesOrderURI + "?series_iuid=" + seriesUID;

		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod(url);
		logger.info("getPositionOfImageInSeries = " + url);

		// Execute the GET method
		int statusCode = client.executeMethod(method);
		int pos = -1;
		int nbImagesInSeries = 0;
		int indexPos = 1;

		if (statusCode != -1) { // Get the result as stream
			BufferedReader reader = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(), "UTF-8"));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] cols = line.split(",");
				if (cols != null && cols.length > 1) {
					String imgIUD = cols[0];
					if (imgIUD.endsWith(".dcm")) {
						nbImagesInSeries++;
						String currentUID = convertDicomNameToImageUID(imgIUD);
						if (imageIUD.equals(currentUID)) {
							pos = Integer.parseInt(cols[1]);
							indexPos = nbImagesInSeries;
						}
					}
				}
			}
		}
		if (pos > nbImagesInSeries) {
			pos = indexPos;
		}
		return pos;
	}

	public static boolean copyFile(File source, File destination)
	{
		boolean resultat = false;

		// Declaration des flux
		java.io.FileInputStream sourceFile = null;
		java.io.FileOutputStream destinationFile = null;
		try {
			// Création du fichier :
			destination.createNewFile();
			// Ouverture des flux
			sourceFile = new java.io.FileInputStream(source);
			destinationFile = new java.io.FileOutputStream(destination);
			// Lecture par segment de 0.5Mo
			byte buffer[] = new byte[512 * 1024];
			int nbLecture;
			while ((nbLecture = sourceFile.read(buffer)) != -1) {
				destinationFile.write(buffer, 0, nbLecture);
			}
			resultat = true; // Copie réussie
		} catch (java.io.FileNotFoundException f) {
			logger.info("FileTools.copyFile() = FileNotFoundException");
		} catch (java.io.IOException e) {
			logger.info("FileTools.copyFile() = IOException");
		} finally {
			// Quoi qu'il arrive, on ferme les flux
			try {
				sourceFile.close();
			} catch (Exception e) {
			}
			try {
				destinationFile.close();
			} catch (Exception e) {
			}
		}
		return (resultat);
	}

	private static String convertDicomNameToImageUID(String currFileName)
	{
		int lastDotIndex = currFileName.lastIndexOf('.');

		String uidPart = currFileName;
		if (lastDotIndex > 0) {
			uidPart = currFileName.substring(0, lastDotIndex);
		}
		uidPart = uidPart.replaceAll("_", ".");
		return uidPart;
	}

	private static void close(Reader reader)
	{
		try {
			if (reader != null) {
				reader.close();
				reader = null;
			}
		} catch (Exception e) {
			logger.info("Failed to close reader");
		}
	}

	private static void close(InputStream stream)
	{
		try {
			if (stream != null) {
				stream.close();
				stream = null;
			}
		} catch (Exception e) {
			logger.info("Failed to close stream");
		}
	}

}