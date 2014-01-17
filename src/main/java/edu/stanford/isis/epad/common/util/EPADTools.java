package edu.stanford.isis.epad.common.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

public class EPADTools
{
	public static String serverProxy = EPADConfig.getInstance().getStringPropertyValue("serverProxy");
	public static String baseAnnotationDir = EPADConfig.getInstance().getStringPropertyValue("baseAnnotationDir");
	public static String wadoProxy = EPADConfig.getInstance().getStringPropertyValue("wadoProxy");
	public static final String dicomServerPort = EPADConfig.getInstance().getStringPropertyValue("DicomServerPort");
	public static final String aeTitle = EPADConfig.getInstance().getStringPropertyValue("DicomServerAETitle");
	public static final String username = EPADConfig.getInstance().getStringPropertyValue("username");
	public static final String password = EPADConfig.getInstance().getStringPropertyValue("password");
	public static final String collection = EPADConfig.getInstance().getStringPropertyValue("collection"); // "defaultcontainer";
	public static final String aim3Namespace = EPADConfig.getInstance().getStringPropertyValue("namespace");
	public static final String existURI = EPADConfig.getInstance().getStringPropertyValue("serverUrlUpload");
	public static final String eventResourceURI = EPADConfig.getInstance().getStringPropertyValue("eventResourceURI");
	public static final String seriesOrderURI = EPADConfig.getInstance().getStringPropertyValue("seriesOrderURI");

	private static final EPADLogger logger = EPADLogger.getInstance();
	private static final EPADConfig config = EPADConfig.getInstance();

	public static int feedFileWithDICOMFromWADO(File file, Map<String, String> dicomImageFileDescription)
			throws IOException
	{
		String studyIDKey = dicomImageFileDescription.get("study_iuid");
		String seriesIDKey = dicomImageFileDescription.get("series_iuid");
		String imageIDKey = dicomImageFileDescription.get("sop_iuid");

		return downloadDICOMFileFromWADO(file, studyIDKey, seriesIDKey, imageIDKey);
	}

	public static int downloadDICOMFileFromWADO(File temp, String studyID, String seriesID, String imageID)
			throws IOException
	{
		String host = config.getStringPropertyValue("NameServer");
		int port = config.getIntegerPropertyValue("DicomServerWadoPort");
		String base = config.getStringPropertyValue("WadoUrlExtension");

		WadoUrlBuilder wadoUrlBuilder = new WadoUrlBuilder(host, port, base, WadoUrlBuilder.ContentType.FILE);

		wadoUrlBuilder.setStudyUID(studyID);
		wadoUrlBuilder.setSeriesUID(seriesID);
		wadoUrlBuilder.setObjectUID(imageID);

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

	public static void dcmsnd(String inputPathFile, boolean throwException) throws Exception
	{
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;

		try {
			String dcmServerTitlePort = aeTitle + "@localhost:" + dicomServerPort;
			dcmServerTitlePort = dcmServerTitlePort.trim();
			logger.info("Sending file - command: ./dcmsnd " + dcmServerTitlePort + " " + inputPathFile);
			String[] command = { "./dcmsnd", dcmServerTitlePort, inputPathFile };
			ProcessBuilder pb = new ProcessBuilder(command);
			String dicomBinDirectoryPath = EPADResources.getEPADWebServerDICOMBinDir();
			logger.info("DICOM binary directory: " + dicomBinDirectoryPath);
			pb.directory(new File(dicomBinDirectoryPath));
			Process process = pb.start();
			process.getOutputStream();// get the output stream.
			is = process.getInputStream();
			isr = new InputStreamReader(is);

			br = new BufferedReader(isr);
			String line;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
				logger.info("./dcmsend output: " + line);
			}

			try {
				int exitValue = process.waitFor();
				logger.info("dcmsend exit value is: " + exitValue);
			} catch (InterruptedException e) {
				logger.warning("Error sending DICOM files in: " + inputPathFile, e);
			}
			String cmdLineOutput = sb.toString();

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
