package edu.stanford.isis.epad.common.plugins;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import com.google.gson.Gson;

import edu.stanford.epad.dtos.EPADDatabaseSeries;
import edu.stanford.isis.epad.common.dicom.DicomFileUtil;
import edu.stanford.isis.epad.common.util.EPADLogger;
import edu.stanford.isis.epad.common.util.EPADTools;

public class PluginDicomUtil
{
	private static final EPADLogger log = EPADLogger.getInstance();

	public static String getDicomSeriesUIDFromImageUID(String imageUID)
	{
		// TODO Get from config file via EPADTools
		String url = "http://localhost:8080/epad/segmentationpath/" + "?image_iuid=" + imageUID;
		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod(url);
		InputStreamReader streamReader = null;
		BufferedReader reader = null;

		try {
			int statusCode = client.executeMethod(method);

			if (statusCode != -1) {
				streamReader = new InputStreamReader(method.getResponseBodyAsStream(), "UTF-8");
				reader = new BufferedReader(streamReader);
				String line;
				while ((line = reader.readLine()) != null) {
					String[] cols = line.split(",");
					if (cols != null && cols.length > 1) {
						String seriesUD = cols[1];
						if (!seriesUD.equals("SeriesUID")) {
							return DicomFileUtil.convertDicomFileNameToImageUID(seriesUD);
						}
					}
				}
			}
			log.warning("Could not find seriesUID for imageUID " + imageUID);
			return "";
		} catch (Exception e) {
			log.warning("Error getting seriesUID for imageUID " + imageUID, e);
			return "";
		} finally {
			if (streamReader != null)
				try {
					streamReader.close();
				} catch (IOException e) {
					log.warning("Error closing segmentation path stream", e);
				}
			if (reader != null)
				try {
					reader.close();
				} catch (IOException e) {
					log.warning("Error closing segmentation path reader", e);
				}
		}
	}

	public static List<String> getDicomImageUIDsInSeries(String seriesUID, String sessionID) throws Exception
	{
		String url = EPADTools.seriesOrderURI + "?series_iuid=" + seriesUID;
		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod(url);
		InputStreamReader streamReader = null;
		BufferedReader reader = null;

		try {
			method.setRequestHeader("Cookie", "JSESSIONID=" + sessionID);
			int statusCode = client.executeMethod(method);
			if (statusCode == HttpServletResponse.SC_OK) { // Get the result as stream
				streamReader = new InputStreamReader(method.getResponseBodyAsStream(), "UTF-8");
				reader = new BufferedReader(streamReader);
				Gson gson = new Gson();
				EPADDatabaseSeries dicomSeriesDescriptionSearchResult = gson.fromJson(reader, EPADDatabaseSeries.class);
				return dicomSeriesDescriptionSearchResult.getImageUIDs();
			} else {
				log.warning("Error calling image search; statusCode=" + statusCode);
				return new ArrayList<String>();
			}
		} finally {
			if (streamReader != null)
				try {
					streamReader.close();
				} catch (IOException e) {
					log.warning("Error closing segmentation path stream", e);
				}
			if (reader != null)
				try {
					reader.close();
				} catch (IOException e) {
					log.warning("Error closing segmentation path reader", e);
				}
		}
	}

	public static int getPositionOfImageInDicomSeries(String seriesUID, String imageUID, String sessionID)
			throws Exception
	{
		String url = EPADTools.seriesOrderURI + "?series_iuid=" + seriesUID;
		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod(url);
		InputStreamReader streamReader = null;
		BufferedReader reader = null;

		method.setRequestHeader("Cookie", "JSESSIONID=" + sessionID);

		int statusCode = client.executeMethod(method);
		int positionOfImageInSeries = -1;

		try {
			if (statusCode == HttpServletResponse.SC_OK) {
				streamReader = new InputStreamReader(method.getResponseBodyAsStream(), "UTF-8");
				reader = new BufferedReader(streamReader);
				Gson gson = new Gson();
				EPADDatabaseSeries dicomSeriesDescriptionSearchResult = gson.fromJson(reader, EPADDatabaseSeries.class);
				positionOfImageInSeries = dicomSeriesDescriptionSearchResult.getImageIndex(imageUID);
				if (positionOfImageInSeries > dicomSeriesDescriptionSearchResult.getNumberOfImagesInSeries())
					positionOfImageInSeries = 1;
			} else {
				log.warning("Error calling series order route; statusCode =" + statusCode);
			}
		} finally {
			if (streamReader != null)
				try {
					streamReader.close();
				} catch (IOException e) {
					log.warning("Error closing segmentation path stream", e);
				}
			if (reader != null)
				try {
					reader.close();
				} catch (IOException e) {
					log.warning("Error closing segmentation path reader", e);
				}
		}
		return positionOfImageInSeries;
	}
}
