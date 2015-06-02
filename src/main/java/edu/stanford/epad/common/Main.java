package edu.stanford.epad.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.BindException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.IOUtils;
import org.eclipse.jetty.server.DispatcherType;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.xml.XmlConfiguration;
import org.xml.sax.SAXException;

import edu.stanford.epad.common.handlers.ResourceCheckHandler;
import edu.stanford.epad.common.handlers.ResourceFailureLogHandler;
import edu.stanford.epad.common.util.EPADConfig;
import edu.stanford.epad.common.util.EPADLogger;

/**
 * Class to run ePad GWT Client as a WebApp (independent of epadws) with embedded Jetty. 
 * This class will be used when the ePad client and Web Services are deployed as two separate web applications.
 * <p>
 * Start an embedded Jetty server and all the threads required for this application. The application listens on the port
 * indicated by the property <i>ePadClientPort</i> in proxy-config.properties.
 * <p>
 * NOTE: The current directory must be set to the ePAD bin subdirectory (~epad/DicomProxy/bin) before calling the start
 * scripts associated with this application. Code in the WAR file needs to be updated to remove this restriction.
 */
public class Main
{
	private static final EPADLogger log = EPADLogger.getInstance();

	public static void main(String[] args)
	{
		Server server = null;

		try {
			log.info("#####################################################");
			log.info("############# Starting ePAD GWT Front End ###########");
			log.info("#####################################################");

			int epadPort = EPADConfig.epadPort;
			server = new Server(epadPort);
			configureJettyServer(server);
			addHandlers(server);
			log.info("Starting Jetty on port " + epadPort);
			server.start();
			server.join();
		} catch (BindException be) {
			log.severe("Bind exception", be);
			Throwable t = be.getCause();
			log.warning("Bind exception cause: " + be.getMessage(), t);
		} catch (SocketException se) {
			log.severe("Cannot bind to all sockets", se);
		} catch (Exception e) {
			log.severe("Fatal Exception. Shutting down ePAD Web Service", e);
		} catch (Error err) {
			log.severe("Fatal Error. Shutting down ePAD Web Service", err);
		} finally {
			log.info("#####################################################");
			log.info("############# Shutting down ePAD GWT Front End ######");
			log.info("#####################################################");

			stopServer(server);
			try { // Wait just long enough for some messages to be printed out.
				TimeUnit.MILLISECONDS.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		log.info("#####################################################");
		log.info("################## Exit ePAD Front End  #############");
		log.info("#####################################################");
	}

	private static void configureJettyServer(Server server)
	{
		FileInputStream jettyConfigFileStream = null;
		try {
			String jettyConfigFilePath = EPADConfig.getEPADWebServerJettyConfigFilePath();
			jettyConfigFileStream = new FileInputStream(jettyConfigFilePath);
			XmlConfiguration configuration = new XmlConfiguration(jettyConfigFileStream);
			configuration.configure(server);
			log.info("Jetty server configured using configuration file " + jettyConfigFilePath);
		} catch (FileNotFoundException e) {
			log.warning("Could not find Jetty configuration file " + EPADConfig.getEPADWebServerJettyConfigFilePath());
		} catch (SAXException e) {
			log.warning("SAX error reading Jetty configuration file " + EPADConfig.getEPADWebServerJettyConfigFilePath(), e);
		} catch (IOException e) {
			log.warning("IO error reading Jetty configuration file " + EPADConfig.getEPADWebServerJettyConfigFilePath(), e);
		} catch (Exception e) {
			log.warning("Error processing Jetty configuration file " + EPADConfig.getEPADWebServerJettyConfigFilePath(), e);
		} finally {
			IOUtils.closeQuietly(jettyConfigFileStream);
		}
	}

	private static void addHandlers(Server server)
	{
		List<Handler> handlerList = new ArrayList<Handler>();

		String webAppPath = EPADConfig.getEPADWebServerWebappsDir() + "ePad.war";
		if (!new File(webAppPath).exists())
			webAppPath = EPADConfig.getEPADWebServerWebappsDir() + "epad-1.1.war";
		addWebAppAtContextPath(handlerList, webAppPath, "/epad");


		addHandlerAtContextPath(new ResourceCheckHandler(), "/epad/resources", handlerList);
		addFileServerAtContextPath(EPADConfig.getEPADWebServerResourcesDir(), handlerList, "/epad/resources");

		ContextHandlerCollection contexts = new ContextHandlerCollection();
		contexts.setHandlers(handlerList.toArray(new Handler[handlerList.size()]));
		server.setHandler(contexts);
		log.info("Done setting up restapi handlers");
	}

	private static void addHandlerAtContextPath(Handler handler, String contextPath, List<Handler> handlerList)
	{
		ContextHandler contextHandler = new ContextHandler(contextPath);

		contextHandler.setResourceBase(".");
		contextHandler.setClassLoader(Thread.currentThread().getContextClassLoader());
		contextHandler.setHandler(handler);
		handlerList.add(contextHandler);

		log.info("Added " + handler.getClass().getName() + " at context " + contextPath);
	}

	/**
	 * Adds a WAR file from the webapps directory at a context path.
	 * 
	 * @param handlerList List of handlers
	 * @param webAppPath String war file name, with or without extension (e.g., ePad.war)
	 * @param contextPath The context to add the war file (e.g., /epad)
	 */
	private static void addWebAppAtContextPath(List<Handler> handlerList, String webAppPath, String contextPath)
	{
		if (!contextPath.startsWith("/")) {
			contextPath = "/" + contextPath;
		}
		WebAppContext webAppContext = new WebAppContext(webAppPath, contextPath);
		String home = System.getProperty("user.home");
		webAppContext.setTempDirectory(new File(home + "/DicomProxy/jetty")); // TODO Read from config file
		webAppContext.setInitParameter("org.eclipse.jetty.servlet.Default.dirAllowed", "false");
		if (new File(EPADConfig.getEPADWebServerEtcDir()+"webdefault.xml").exists())
		{
			log.info("Adding webdefault.xml");
			webAppContext.setDefaultsDescriptor(EPADConfig.getEPADWebServerEtcDir()+"webdefault.xml");
		}
		log.info("WebAuthFilter:'" + EPADConfig.getParamValue("WebAuthFilter", null) + "'");
		if (EPADConfig.getParamValue("WebAuthFilter", null) != null)
		{
			try {
				Class filter = Class.forName(EPADConfig.getParamValue("WebAuthFilter"));
				webAppContext.addFilter(filter, "/*", EnumSet.of(DispatcherType.REQUEST,DispatcherType.ASYNC,DispatcherType.FORWARD));
			} catch (ClassNotFoundException e) {
				log.warning("WebAuth Authentication Filter " + EPADConfig.getParamValue("WebAuthFilter") + " not found");
			}
		}
		handlerList.add(webAppContext);
		log.info("Added WAR " + webAppPath + " at context path " + contextPath);
	}

	private static void addFileServerAtContextPath(String baseDirectory, List<Handler> handlerList, String contextPath)
	{
		ResourceHandler resourceHandler = new ResourceHandler();
		resourceHandler.setDirectoriesListed(false);
		resourceHandler.setWelcomeFiles(new String[] { "index.html" });
		resourceHandler.setResourceBase(baseDirectory);

		HandlerList handlers = new HandlerList();
		handlers.setHandlers(new Handler[] { resourceHandler, new ResourceFailureLogHandler(), new DefaultHandler() });

		addHandlerAtContextPath(handlers, contextPath, handlerList);

		log.info("Added file server for " + baseDirectory + " directory.");
	}

	private static void stopServer(Server server)
	{
		try {
			if (server != null) {
				log.info("#####################################################");
				log.info("############### Stopping Jetty server ###############");
				log.info("#####################################################");
				server.stop();
			}
		} catch (Exception e) {
			log.warning("Failed to stop the Jetty server", e);
		}
	}
}
