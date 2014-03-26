package edu.stanford.epad.common.plugins;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Any HTTP GET or POST calls with in the format /epad/plugin/[name] are forwarded on to this handler for a plugin
 * registered with [name].
 * 
 * These HttpServlet classes work the same as a standard J2EE HttpServlet with some abstract classes to define where
 * they fit in the plugin structure.
 */
public interface PluginServletHandler
{
	/**
	 * The J2EE equivalent of init
	 */
	void init();

	/**
	 * The J2EE equivalent of destroy.
	 */
	void destroy();

	/**
	 * Standard J2EE doGet handler that is forwarded from the DicomProxy
	 * 
	 * @param req HttpServletRequest
	 * @param res HttpServletResponse
	 */
	void doGet(HttpServletRequest req, HttpServletResponse res);

	/**
	 * Standard J2EE doPost handler that is forwarded from the DicomProxy
	 * 
	 * @param req HttpServletRequest
	 * @param res HttpServletResponse
	 */
	void doPost(HttpServletRequest req, HttpServletResponse res);

	/**
	 * Very short string to identify this version of the release.
	 * 
	 * @return String example "1.0.0 - Aug. 15, 2012"
	 */
	String getVersion();

	/**
	 * Define a globally unique name to call this plugin. It should be only lower-case alpha characters [a-z]
	 * 
	 * @return String
	 */
	String getName();

	/**
	 * Contact info for the author(s).
	 * 
	 * @return String
	 */
	String getAuthorsContactInfo();

	/**
	 * Short description (less than 100 words) of what the plugin does.
	 * 
	 * @return String
	 */
	String getDescription();
}
