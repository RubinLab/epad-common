package edu.stanford.epad.common.plugins;

import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractPluginServletHandler implements PluginServletHandler
{
	protected static final Logger logger = PluginLogger.getLogger();

	/**
	 * Plugin initialization
	 */
	@Override
	public abstract void init();

	/**
	 * Called when a plugin is destroyed
	 */
	@Override
	public abstract void destroy();

	/**
	 * Standard doGet handler that is forwarded from the ePAD server
	 * 
	 * @param req HttpServletRequest
	 * @param res HttpServletResponse
	 */
	@Override
	public abstract int doGet(HttpServletRequest req, HttpServletResponse res);

	/**
	 * Standard doPost handler that is forwarded from the ePAD server
	 * 
	 * @param req HttpServletRequest
	 * @param res HttpServletResponse
	 */
	@Override
	public abstract int doPost(HttpServletRequest req, HttpServletResponse res);

	/**
	 * Very short string to identify this version of the release.
	 */
	@Override
	public abstract String getVersion();

	/**
	 * Define a globally unique name to call this plugin. It should be only lower-case alpha characters [a-z]
	 * 
	 * @return String
	 */
	@Override
	public abstract String getName();

	/**
	 * Contact info for the author(s).
	 * 
	 * @return String
	 */
	@Override
	public abstract String getAuthorsContactInfo();

	/**
	 * Short description (less than 100 words) of what the plugin does.
	 * 
	 * @return String
	 */
	@Override
	public abstract String getDescription();

	protected void outputException(Throwable t, PrintWriter out)
	{
		out.println("  message: " + t.getMessage());
		out.println(" ");
		out.println(printStackTrace(t));

		logger.log(Level.WARNING, t.getMessage(), t);
	}

	protected String printStackTrace(Throwable throwable)
	{
		StringBuilder sb = new StringBuilder();

		StackTraceElement[] stackTraceElements = throwable.getStackTrace();
		for (StackTraceElement currElement : stackTraceElements) {
			sb.append(currElement.getClassName());
			sb.append(" : ");
			sb.append(currElement.getMethodName());
			sb.append(" line: ");
			sb.append(currElement.getLineNumber());
			sb.append("\n");
		}
		return sb.toString();
	}
}
