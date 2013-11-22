package edu.stanford.isis.epad.common.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;

public class PluginEventUtil
{
	private static final EPADLogger logger = EPADLogger.getInstance();

	public static void postEvent(String username, String event_status, String aimUid, String aimName, String patientID,
			String patientName, String templateID, String templateName, String pluginName, String sessionID)
	{
		try {
			String urlEncoded = EPADTools.eventResourceURI + "?" + "username=" + username + "&" + "event_status="
					+ java.net.URLEncoder.encode(event_status, "UTF-8") + "&" + "aim_uid="
					+ java.net.URLEncoder.encode(aimUid, "UTF-8") + "&" + "aim_name="
					+ java.net.URLEncoder.encode(aimName, "UTF-8") + "&" + "patient_id="
					+ java.net.URLEncoder.encode(patientID, "UTF-8") + "&" + "patient_name="
					+ java.net.URLEncoder.encode(patientName, "UTF-8") + "&" + "template_id="
					+ java.net.URLEncoder.encode(templateID, "UTF-8") + "&" + "template_name="
					+ java.net.URLEncoder.encode(templateName, "UTF-8") + "&" + "plugin_name="
					+ java.net.URLEncoder.encode(pluginName, "UTF-8");

			HttpClient client = new HttpClient();
			PostMethod method = new PostMethod(urlEncoded);
			method.setRequestHeader("Cookie", "JSESSIONID=" + sessionID);
			int statusCode = client.executeMethod(method);
			if (statusCode != HttpServletResponse.SC_OK)
				logger.info("tedSeg: unexpected status code returned from event service " + statusCode);
		} catch (UnsupportedEncodingException e1) {
			logger.warning("tedSeg: UnsupportedEncodingException", e1);
		} catch (HttpException e) {
			logger.warning("tedSeg: HttpException", e);
		} catch (IOException e) {
			logger.warning("tedSeg: IOException", e);
		}
	}
}
