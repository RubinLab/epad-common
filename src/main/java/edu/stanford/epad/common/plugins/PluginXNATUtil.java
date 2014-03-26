package edu.stanford.epad.common.plugins;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import edu.stanford.epad.common.util.EPADLogger;

public class PluginXNATUtil
{
	private static final EPADLogger log = EPADLogger.getInstance();

	public static String getJSessionIDFromRequest(HttpServletRequest servletRequest)
	{
		String jSessionID = null;

		Cookie[] cookies = servletRequest.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("JSESSIONID".equalsIgnoreCase(cookie.getName())) {
					jSessionID = cookie.getValue();
					break;
				}
			}
		}
		if (jSessionID == null)
			log.warning("No JSESESSIONID cookie present in session request");
		return jSessionID;
	}
}
