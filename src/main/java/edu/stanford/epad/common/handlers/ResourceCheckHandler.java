package edu.stanford.epad.common.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import edu.stanford.epad.common.util.EPADLogger;

/**
 * Provide access control.
 * <p>
 * Also allows CORS requests to support cross origin modification of retrieved resources.
 * 
 * @author martin
 * 
 */
public class ResourceCheckHandler extends AbstractHandler
{
	private final EPADLogger log = EPADLogger.getInstance();

	private static final String INTERNAL_ERROR_MESSAGE = "Internal server error on resource route";
	private static final String INVALID_SESSION_TOKEN_MESSAGE = "Session token is invalid on resource route";

	@Override
	public void handle(String base, Request request, HttpServletRequest httpRequest, HttpServletResponse httpResponse)
	{
		String origin = httpRequest.getHeader("Origin"); // CORS request should have Origin header
		int statusCode;

		// Origin header indicates a possible CORS requests, which we support to allow drawing on canvas in GWT Dev Mode.
		if (origin != null) {
			httpResponse.setHeader("Access-Control-Allow-Origin", origin);
			httpResponse.setHeader("Access-Control-Allow-Credentials", "true"); // Needed to allow cookies.
		} else {
			httpResponse.setHeader("Access-Control-Allow-Origin", "*");
		}

		try {
			// if (XNATOperations.hasValidXNATSessionID(httpRequest)) {
			if (dummy()) { // TODO Turn off authorization for the moment
				request.setHandled(false);
				statusCode = HttpServletResponse.SC_OK;
			} else {
				log.warning(INVALID_SESSION_TOKEN_MESSAGE);
				statusCode = HttpServletResponse.SC_UNAUTHORIZED;
				request.setHandled(true);
			}
		} catch (Throwable t) {
			log.warning(INTERNAL_ERROR_MESSAGE, t);
			statusCode = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
			request.setHandled(true);
		}
		httpResponse.setStatus(statusCode);
	}

	private boolean dummy()
	{
		return true;
	}
}
