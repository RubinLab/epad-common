package edu.stanford.epad.common.dicom;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.IOUtils;

import edu.stanford.epad.common.util.EPADConfig;
import edu.stanford.epad.common.util.EPADLogger;
import edu.stanford.epad.common.util.WadoUrlBuilder;

public class DCM4CHEEUtil
{
	private static final String dicomServerPort = EPADConfig.dicomServerPort;
	private static final String aeTitle = EPADConfig.aeTitle;

	private static final EPADLogger log = EPADLogger.getInstance();

	public static int downloadDICOMFileFromWADO(DICOMFileDescription dicomFileDescription, File outputDicomFile)
			throws IOException
	{
		String studyUID = dicomFileDescription.studyUID;
		String seriesUID = dicomFileDescription.seriesUID;
		String imageUID = dicomFileDescription.imageUID;

		return downloadDICOMFileFromWADO(studyUID, seriesUID, imageUID, outputDicomFile);
	}

	public static int downloadDICOMFileFromWADO(String studyUID, String seriesUID, String imageUID, File outputDicomFile)
			throws IOException
	{
		String wadoHost = EPADConfig.dcm4CheeServer;
		int wadoPort = EPADConfig.dcm4cheeServerWadoPort;
		String wadoBaseURL = EPADConfig.wadoURLExtension;
		WadoUrlBuilder wadoUrlBuilder = new WadoUrlBuilder(wadoHost, wadoPort, wadoBaseURL, WadoUrlBuilder.ContentType.FILE);

		wadoUrlBuilder.setStudyUID(studyUID);
		wadoUrlBuilder.setSeriesUID(seriesUID);
		wadoUrlBuilder.setObjectUID(imageUID);
		String wadoUrl = wadoUrlBuilder.build();

		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod(wadoUrl);
		int statusCode = client.executeMethod(method);

		if (statusCode == HttpServletResponse.SC_OK) {
			OutputStream outputStream = null;
			try {
				outputStream = new FileOutputStream(outputDicomFile);
				InputStream inputStream = method.getResponseBodyAsStream();
				int read = 0;
				byte[] bytes = new byte[4096];
				while ((read = inputStream.read(bytes)) != -1) {
					outputStream.write(bytes, 0, read);
				}
			} finally {
				IOUtils.closeQuietly(outputStream);
				method.releaseConnection();
			}
		}
		else {
			log.warning("Wado URL:" + wadoUrl + " Status:" + statusCode);
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
			String dicomBinDirectoryPath = EPADConfig.getEPADWebServerDICOMBinDir();
			log.info("DICOM binary directory: " + dicomBinDirectoryPath);
			pb.directory(new File(dicomBinDirectoryPath));
			Process process = pb.start();
			process.getOutputStream();
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
				log.info("dcmsnd exit value is: " + exitValue);
				if (sb.toString().contains("Sent 0 objects"))
				{
					log.warning("Zero objects sent to dcm4che, some error has occurred");
					throw new Exception("Error sending files to dcm4che");
				}

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
			log.warning("dcmsnd failed: " + e.getMessage());
			if (throwException) {
				throw new IllegalStateException("dcmsnd failed", e);
			}
		} catch (OutOfMemoryError oome) {
			log.warning("dcmsnd ran out of memory", oome);
			if (throwException) {
				throw new IllegalStateException("dcmsnd ran out of memory", oome);
			}
		} finally {
			IOUtils.closeQuietly(br);
			IOUtils.closeQuietly(isr);
		}
	}
}
