package edu.stanford.isis.epad.common.plugins;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import com.google.gson.Gson;

import edu.stanford.isis.epad.common.dicom.DICOMSeriesDescriptionSearchResult;
import edu.stanford.isis.epad.common.util.EPADLogger;
import edu.stanford.isis.epad.common.util.EPADTools;

public class PluginDicomUtil
{
	private static final EPADLogger log = EPADLogger.getInstance();

	public static List<String> getDicomImageUIDsInSeries(String seriesUID, String sessionID) throws Exception
	{
		String url = EPADTools.seriesOrderURI + "?series_iuid=" + seriesUID;

		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod(url);
		method.setRequestHeader("Cookie", "JSESSIONID=" + sessionID);
		int statusCode = client.executeMethod(method);
		if (statusCode == HttpServletResponse.SC_OK) { // Get the result as stream
			BufferedReader reader = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(), "UTF-8"));
			Gson gson = new Gson();
			DICOMSeriesDescriptionSearchResult dicomSeriesDescriptionSearchResult = gson.fromJson(reader,
					DICOMSeriesDescriptionSearchResult.class);
			return dicomSeriesDescriptionSearchResult.getImageUIDs();
		} else {
			log.warning("Error calling image search; statusCode=" + statusCode);
			return new ArrayList<String>();
		}
	}

	public static int getPositionOfImageInDicomSeries(String seriesUID, String imageUID, String sessionID)
			throws Exception
	{
		String url = EPADTools.seriesOrderURI + "?series_iuid=" + seriesUID;
		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod(url);
		method.setRequestHeader("Cookie", "JSESSIONID=" + sessionID);
		int statusCode = client.executeMethod(method);
		int positionOfImageInSeries = -1;

		if (statusCode == HttpServletResponse.SC_OK) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(), "UTF-8"));
			Gson gson = new Gson();
			DICOMSeriesDescriptionSearchResult dicomSeriesDescriptionSearchResult = gson.fromJson(reader,
					DICOMSeriesDescriptionSearchResult.class);
			positionOfImageInSeries = dicomSeriesDescriptionSearchResult.getImageIndex(imageUID);
			if (positionOfImageInSeries > dicomSeriesDescriptionSearchResult.getNumberOfImagesInSeries())
				positionOfImageInSeries = 1;
		} else {
			log.warning("Error calling series order route; statusCode =" + statusCode);
		}
		return positionOfImageInSeries;
	}
}
