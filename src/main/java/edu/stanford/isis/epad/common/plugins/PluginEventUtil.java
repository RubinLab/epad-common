package edu.stanford.isis.epad.common.plugins;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;

import edu.stanford.isis.epad.common.util.EPADLogger;
import edu.stanford.isis.epad.common.util.EPADTools;

public class PluginEventUtil
{
	private static final EPADLogger logger = EPADLogger.getInstance();

	public static void postEvent(String sessionID, String event_status, String aimUid, String aimName, String patientID,
			String patientName, String templateID, String templateName, String pluginName)
	{
		try {
			String urlEncoded = EPADTools.eventResourceURI + "?" + "username=" + sessionID + "&" + "event_status="
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

			logger.info("EVENT: " + urlEncoded);

			if (statusCode != HttpServletResponse.SC_OK)
				logger.info("Unexpected status code returned from event service " + statusCode);
		} catch (UnsupportedEncodingException e1) {
			logger.warning("event: UnsupportedEncodingException", e1);
		} catch (HttpException e) {
			logger.warning("event: HttpException", e);
		} catch (IOException e) {
			logger.warning("event: IOException", e);
		}
	}
}
