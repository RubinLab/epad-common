package edu.stanford.isis.epad.common.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import edu.stanford.isis.epad.common.ProxyConfig;
import edu.stanford.isis.epad.common.ProxyLogger;

public class ProxyTools
{
	public static String serverProxy = ProxyConfig.getInstance().getParam("serverProxy");
	public static String baseAnnotationDir = ProxyConfig.getInstance().getParam("baseAnnotationDir");
	public static String dbpath = ProxyConfig.getInstance().getParam("dbpath");
	public static String templatePath = ProxyConfig.getInstance().getParam("baseTemplatesDir");
	public static String wadoProxy = ProxyConfig.getInstance().getParam("wadoProxy");
	public static final String dicomServerPort = ProxyConfig.getInstance().getParam("DicomServerPort");
	public static final String aeTitle = ProxyConfig.getInstance().getParam("DicomServerAETitle");
	public static final String username = ProxyConfig.getInstance().getParam("username");
	public static final String password = ProxyConfig.getInstance().getParam("password");
	public static final String collection = ProxyConfig.getInstance().getParam("defaultcontainer");
	public static final String aim3Namespace = ProxyConfig.getInstance().getParam("namespace");
	public static final String existURI = ProxyConfig.getInstance().getParam("serverUrlUpload");
	public static final String eventResourceURI = ProxyConfig.getInstance().getParam("eventResourceURI");
	public static final String seriesOrderURI = ProxyConfig.getInstance().getParam("seriesOrderURI");

	private static final ProxyLogger logger = ProxyLogger.getInstance();

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

	public static void feedFileWithDicomFromWado(File temp, String studyUID, String seriesUID, String imageId)
			throws Exception
	{
		ProxyConfig config = ProxyConfig.getInstance();
		String host = config.getParam("NameServer");
		int port = config.getIntParam("DicomServerWadoPort");
		String base = config.getParam("WadoUrlExtension");
		WadoUrlBuilder wadoUrlBuilder = new WadoUrlBuilder(host, port, base, WadoUrlBuilder.ContentType.FILE);

		// GET WADO call result.
		wadoUrlBuilder.setStudyUID(studyUID);
		wadoUrlBuilder.setSeriesUID(seriesUID);
		wadoUrlBuilder.setObjectUID(imageId);

		String wadoUrl = wadoUrlBuilder.build();

		// --Get the Dicom file from the server
		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod(wadoUrl);

		// Execute the GET method
		int statusCode = client.executeMethod(method);

		if (statusCode != -1) {
			// Get the result as stream
			InputStream res = method.getResponseBodyAsStream();
			// write the inputStream to a FileOutputStream
			OutputStream out = new FileOutputStream(temp);

			int read = 0;
			byte[] bytes = new byte[4096];

			while ((read = res.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			res.close();
			out.flush();
			out.close();
		}
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

			logger.info("Sending 1 files - command: ./dcmsnd " + dcmServerTitlePort + " " + inputPathFile);

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

	@SuppressWarnings("unused")
	private static void close(Writer writer)
	{
		try {
			if (writer != null) {
				writer.flush();
				writer.close();
				writer = null;
			}
		} catch (Exception e) {
			logger.info("Failed to close writer");
		}
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
}
