package edu.stanford.epad.common.plugins;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;

import edu.stanford.epad.common.plugins.impl.PluginAIMOptions;
import edu.stanford.epad.common.util.EPADConfig;
import edu.stanford.epad.common.util.EPADLogger;

public class PluginEventPoster
{
	private static final EPADLogger logger = EPADLogger.getInstance();

	public static void postPluginEvent(String event_status, PluginAIMOptions pluginAIMOptions)
	{
		try {
			String urlEncoded = EPADConfig.eventResourceURI + "?" + "username=" + pluginAIMOptions.sessionID + "&"
					+ "event_status=" + java.net.URLEncoder.encode(event_status, "UTF-8") + "&" + "aim_uid="
					+ java.net.URLEncoder.encode(pluginAIMOptions.aimUID, "UTF-8") + "&" + "aim_name="
					+ java.net.URLEncoder.encode(pluginAIMOptions.aimName, "UTF-8") + "&" + "patient_id="
					+ java.net.URLEncoder.encode(pluginAIMOptions.patientID, "UTF-8") + "&" + "patient_name="
					+ java.net.URLEncoder.encode(pluginAIMOptions.patientName, "UTF-8") + "&" + "template_id="
					+ java.net.URLEncoder.encode(pluginAIMOptions.templateID, "UTF-8") + "&" + "template_name="
					+ java.net.URLEncoder.encode(pluginAIMOptions.templateName, "UTF-8") + "&" + "plugin_name="
					+ java.net.URLEncoder.encode(pluginAIMOptions.pluginName, "UTF-8");

			HttpClient client = new HttpClient();
			PostMethod method = new PostMethod(urlEncoded);
			method.setRequestHeader("Cookie", "JSESSIONID=" + pluginAIMOptions.sessionID);

			try {
				int statusCode = client.executeMethod(method);
				logger.info("EVENT: " + urlEncoded);

				if (statusCode != HttpServletResponse.SC_OK)
					logger.warning("Unexpected status code returned from event service " + statusCode);
			} finally {
				method.releaseConnection();
			}

		} catch (UnsupportedEncodingException e) {
			logger.warning("UnsupportedEncodingException on plugin event call", e);
		} catch (HttpException e) {
			logger.warning("HttpException on plugin event call", e);
		} catch (IOException e) {
			logger.warning("IOException on plugin event call", e);
		}
	}
}
