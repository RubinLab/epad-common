package edu.stanford.epad.common.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.IOUtils;

public class EPADTools
{
	public static String serverProxy = EPADConfig.getInstance().getStringPropertyValue("serverProxy");
	public static String baseAnnotationDir = EPADConfig.getInstance().getStringPropertyValue("baseAnnotationDir");
	public static String wadoProxy = EPADConfig.getInstance().getStringPropertyValue("wadoProxy");
	public static final String dicomServerPort = EPADConfig.getInstance().getStringPropertyValue("DicomServerPort");
	public static final String aeTitle = EPADConfig.getInstance().getStringPropertyValue("DicomServerAETitle");
	public static final String eXistUsername = EPADConfig.getInstance().getStringPropertyValue("username");
	public static final String eXistPassword = EPADConfig.getInstance().getStringPropertyValue("password");
	public static final String epadDatabaseUsername = EPADConfig.getInstance().getStringPropertyValue(
			"epadDatabaseUsername");
	public static final String epadDatabasePassword = EPADConfig.getInstance().getStringPropertyValue(
			"epadDatabasePassword");
	public static final String epadDatabaseURL = EPADConfig.getInstance().getStringPropertyValue("epadDatabaseURL");
	public static final String dcm4CheeDatabaseUsername = EPADConfig.getInstance().getStringPropertyValue(
			"dcm4CheeDatabaseUsername");
	public static final String dcm4CheeDatabasePassword = EPADConfig.getInstance().getStringPropertyValue(
			"dcm4CheeDatabasePassword");
	public static final String dcm4CheeDatabaseURL = EPADConfig.getInstance().getStringPropertyValue(
			"dcm4CheeDatabaseURL");
	public static final String eXistCollection = EPADConfig.getInstance().getStringPropertyValue("collection");
	public static final String aim3Namespace = EPADConfig.getInstance().getStringPropertyValue("namespace");
	public static final String eXistURI = EPADConfig.getInstance().getStringPropertyValue("serverUrlUpload");
	public static final String eventResourceURI = EPADConfig.getInstance().getStringPropertyValue("eventResourceURI");
	public static final String seriesOrderURI = EPADConfig.getInstance().getStringPropertyValue("seriesOrderURI");

	private static final EPADLogger log = EPADLogger.getInstance();
	private static final EPADConfig config = EPADConfig.getInstance();

	public static int feedFileWithDICOMFromWADO(File outputDICOMFile, Map<String, String> dicomImageFileDescription)
			throws IOException
	{
		String studyUID = dicomImageFileDescription.get("study_iuid");
		String seriesUID = dicomImageFileDescription.get("series_iuid");
		String imageUID = dicomImageFileDescription.get("sop_iuid");

		return downloadDICOMFileFromWADO(studyUID, seriesUID, imageUID, outputDICOMFile);
	}

	public static int downloadDICOMFileFromWADO(String studyUID, String seriesUID, String imageUID, File outputDicomFile)
			throws IOException
	{
		String wadoHost = config.getStringPropertyValue("NameServer");
		int wadoPort = config.getIntegerPropertyValue("DicomServerWadoPort");
		String wadoBaseURL = config.getStringPropertyValue("WadoUrlExtension");
		WadoUrlBuilder wadoUrlBuilder = new WadoUrlBuilder(wadoHost, wadoPort, wadoBaseURL, WadoUrlBuilder.ContentType.FILE);

		wadoUrlBuilder.setStudyUID(studyUID);
		wadoUrlBuilder.setSeriesUID(seriesUID);
		wadoUrlBuilder.setObjectUID(imageUID);

		String wadoUrl = wadoUrlBuilder.build();

		// log.info("WADO download query: " + wadoUrl);

		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod(wadoUrl);
		int statusCode = client.executeMethod(method);

		if (statusCode == HttpServletResponse.SC_OK) {
			OutputStream outputStream = null;
			try {
				outputStream = new FileOutputStream(outputDicomFile);
				InputStream is = method.getResponseBodyAsStream();
				int read = 0;
				byte[] bytes = new byte[4096];
				while ((read = is.read(bytes)) != -1) {
					outputStream.write(bytes, 0, read);
				}
			} finally {
				IOUtils.closeQuietly(outputStream);
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
			log.info("Sending file - command: ./dcmsnd " + dcmServerTitlePort + " " + inputPathFile);
			String[] command = { "./dcmsnd", dcmServerTitlePort, inputPathFile };
			ProcessBuilder pb = new ProcessBuilder(command);
			String dicomBinDirectoryPath = EPADResources.getEPADWebServerDICOMBinDir();
			log.info("DICOM binary directory: " + dicomBinDirectoryPath);
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
				log.info("./dcmsend output: " + line);
			}

			try {
				int exitValue = process.waitFor();
				log.info("dcmsend exit value is: " + exitValue);
			} catch (InterruptedException e) {
				log.warning("Error sending DICOM files in: " + inputPathFile, e);
			}
			String cmdLineOutput = sb.toString();

			if (cmdLineOutput.toLowerCase().contains("error")) {
				throw new IllegalStateException("Failed for: " + cmdLineOutput);
			}
		} catch (Exception e) {
			if (e instanceof IllegalStateException && throwException) {
				throw e;
			}
			log.warning("DicomHeadersTask failed to create DICOM tags file: " + e.getMessage());
			if (throwException) {
				throw new IllegalStateException("DicomHeadersTask failed to create DICcom tags file.", e);
			}
		} catch (OutOfMemoryError oome) {
			log.warning("DicomHeadersTask OutOfMemoryError: ");
			if (throwException) {
				throw new IllegalStateException("DicomHeadersTask OutOfMemoryError: ", oome);
			}
		} finally {
			IOUtils.closeQuietly(br);
			IOUtils.closeQuietly(isr);
		}
	}

	public static boolean copyFile(File source, File destination)
	{
		boolean result = false;

		FileInputStream sourceStream = null;
		FileOutputStream destinationStream = null;
		try {
			destination.createNewFile();
			sourceStream = new java.io.FileInputStream(source);
			destinationStream = new java.io.FileOutputStream(destination);
			byte buffer[] = new byte[512 * 1024];
			int nbLecture;
			while ((nbLecture = sourceStream.read(buffer)) != -1) {
				destinationStream.write(buffer, 0, nbLecture);
			}
			result = true;
		} catch (java.io.FileNotFoundException f) {
			log.warning("FileTools.copyFile() = FileNotFoundException");
		} catch (java.io.IOException e) {
			log.warning("FileTools.copyFile() = IOException");
		} finally {
			IOUtils.closeQuietly(destinationStream);
			IOUtils.closeQuietly(sourceStream);
		}
		return (result);
	}
}
