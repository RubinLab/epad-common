package edu.stanford.epad.common.plugins;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

import edu.stanford.epad.common.util.EPADConfig;
import edu.stanford.epad.common.util.EPADLogger;
import edu.stanford.epad.dtos.EPADDatabaseSeries;
import edu.stanford.hakan.aim3api.base.AimException;
import edu.stanford.hakan.aim3api.base.ImageAnnotation;

public class PluginDicomUtil
{
	private static final EPADLogger log = EPADLogger.getInstance();

	public static List<String> getDicomImageUIDsInSeries(String studyUID, String seriesUID, String sessionID, String username) throws IOException
	{
        String url = EPADConfig.getParamValue("serverProxy", "http://localhost:8080") 
        		+ EPADConfig.getParamValue("webserviceBase", "/epad") + "/v2" +
				"/studies/" + studyUID + "/series/" + seriesUID + "/images/?username=" + username;
		log.info("url for getDicomImageUIDsInSeries: " + url);
		
//		String url = "TODO" + "?series_iuid=" + seriesUID; // TODO Use new RESTful /images/ route.
		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod(url);
		InputStreamReader streamReader = null;
		BufferedReader bufferedReader = null;

		try {
			method.setRequestHeader("Cookie", "JSESSIONID=" + sessionID);
			int statusCode = client.executeMethod(method);
			if (statusCode == HttpServletResponse.SC_OK) { // Get the result as stream
				streamReader = new InputStreamReader(method.getResponseBodyAsStream(), "UTF-8");
				bufferedReader = new BufferedReader(streamReader);
				Gson gson = new Gson();
				EPADDatabaseSeries dicomSeriesDescriptionSearchResult = gson.fromJson(bufferedReader, EPADDatabaseSeries.class);
				return dicomSeriesDescriptionSearchResult.getImageUIDs();
			} else {
				log.warning("Error calling image search; statusCode=" + statusCode);
				return new ArrayList<String>();
			}
		} finally {
			IOUtils.closeQuietly(bufferedReader);
			IOUtils.closeQuietly(streamReader);
			method.releaseConnection();
		}
	}

	public static int getPositionOfImageInDicomSeries(String studyUID, String seriesUID, String imageUID, String sessionID, String username)
			throws Exception
	{ 		
		String url = EPADConfig.getParamValue("serverProxy", "http://localhost:8080") + EPADConfig.getParamValue("webserviceBase", "/epad") + "/v2" +
				"/studies/" + studyUID + "/series/" + seriesUID + "/images/?username=" + username;
		log.info("url for getPositionOfImageInDicomSeries: " + url);
		
		// TODO Use new RESTful /images/ route.
		//String url = "TODO" + "?series_iuid=" + seriesUID;
		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod(url);
		InputStreamReader streamReader = null;
		BufferedReader bufferedReader = null;

		method.setRequestHeader("Cookie", "JSESSIONID=" + sessionID);

		int statusCode = client.executeMethod(method);
		int positionOfImageInSeries = -1;

		try {
			if (statusCode == HttpServletResponse.SC_OK) {
				streamReader = new InputStreamReader(method.getResponseBodyAsStream(), "UTF-8");
				bufferedReader = new BufferedReader(streamReader);
				Gson gson = new Gson();
				EPADDatabaseSeries dicomSeriesDescriptionSearchResult = gson.fromJson(bufferedReader, EPADDatabaseSeries.class);
				positionOfImageInSeries = dicomSeriesDescriptionSearchResult.getImageIndex(imageUID);
				if (positionOfImageInSeries > dicomSeriesDescriptionSearchResult.getNumberOfImagesInSeries())
					positionOfImageInSeries = 1;
			} else {
				log.warning("Error calling series order route " + url + "; statusCode =" + statusCode);
			}
		} finally {
			IOUtils.closeQuietly(streamReader);
			IOUtils.closeQuietly(bufferedReader);
			method.releaseConnection();
		}
		return positionOfImageInSeries;
	}
}
