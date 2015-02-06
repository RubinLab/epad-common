/*
 * Copyright 2012 The Board of Trustees of the Leland Stanford Junior University.
 * Author: Daniel Rubin, Alan Snyder, Debra Willrett. All rights reserved. Possession
 * or use of this program is subject to the terms and conditions of the Academic
 * Software License Agreement available at:
 *   http://epad.stanford.edu/license/
 */
package edu.stanford.epad.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.IOUtils;

/**
 * Read the "etc/proxy-config.properties" file on start up read all necessary configuration information.
 * <p>
 * All server configuration information is centralized here, i.e., the configuration file should not be read elsewhere.
 */
public class EPADConfig
{
	private static final EPADLogger log = EPADLogger.getInstance();
	private static final EPADConfig ourInstance = new EPADConfig();

	// The port that the ePAD server is sitting on
	public static final int epadPort = EPADConfig.getInstance().getIntegerPropertyValue("ePadClientPort");

	// dcm4chee configuration
	public static final String dcm4CheeServer = EPADConfig.getInstance().getStringPropertyValue("NameServer");
	public static final int dcm4cheeServerWadoPort = EPADConfig.getInstance().getIntegerPropertyValue(
			"DicomServerWadoPort");
	public static final String dcm4cheeDirRoot = EPADConfig.getInstance().getStringPropertyValue("dcm4cheeDirRoot");
	public static final String wadoURLExtension = EPADConfig.getInstance().getStringPropertyValue("WadoUrlExtension");
	public static final String dicomServerPort = EPADConfig.getInstance().getStringPropertyValue("DicomServerPort");
	public static final String dicomServerIP = EPADConfig.getInstance().getStringPropertyValue("DicomServerIP");
	public static final String aeTitle = EPADConfig.getInstance().getStringPropertyValue("DicomServerAETitle");

	// ePAD's MySQL database configuration
	public static final String epadDatabaseUsername = EPADConfig.getInstance().getStringPropertyValue(
			"epadDatabaseUsername");
	public static final String epadDatabasePassword = EPADConfig.getInstance().getStringPropertyValue(
			"epadDatabasePassword");
	public static final String epadDatabaseURL = EPADConfig.getInstance().getStringPropertyValue("epadDatabaseURL");

	// dcm4chee's MySQL database configuration
	public static final String dcm4CheeDatabaseUsername = EPADConfig.getInstance().getStringPropertyValue(
			"dcm4CheeDatabaseUsername");
	public static final String dcm4CheeDatabasePassword = EPADConfig.getInstance().getStringPropertyValue(
			"dcm4CheeDatabasePassword");
	public static final String dcm4CheeDatabaseURL = EPADConfig.getInstance().getStringPropertyValue(
			"dcm4CheeDatabaseURL");

	// AIM-related configuration
	public static final String eXistServerUrl = EPADConfig.getInstance().getStringPropertyValue("serverUrl");
	public static final String eXistURI = EPADConfig.getInstance().getStringPropertyValue("serverUrlUpload");
	public static final String eXistUsername = EPADConfig.getInstance().getStringPropertyValue("username");
	public static final String eXistPassword = EPADConfig.getInstance().getStringPropertyValue("password");
	public static final String eXistCollection = EPADConfig.getInstance().getStringPropertyValue("collection");
	public static final String aim3Namespace = EPADConfig.getInstance().getStringPropertyValue("namespace");
	public static final String xsdFile = EPADConfig.getInstance().getStringPropertyValue("xsdFile");
	public static final String xsdFilePath = EPADConfig.getInstance().getStringPropertyValue("baseSchemaDir") + xsdFile;
	public static final String useV4 = EPADConfig.getInstance().getStringPropertyValue("useV4");
	public static final String aim4Namespace = EPADConfig.getInstance().getStringPropertyValue("namespaceV4");
	public static final String eXistCollectionV4 = EPADConfig.getInstance().getStringPropertyValue("collectionV4");
	public static final String xsdFileV4 = EPADConfig.getInstance().getStringPropertyValue("xsdFileV4");
	public static final String xsdFilePathV4 = EPADConfig.getInstance().getStringPropertyValue("baseSchemaDir")
			+ xsdFileV4;
	public static final String baseAnnotationDir = EPADConfig.getInstance().getStringPropertyValue("baseAnnotationDir");
	public static final String templateXSDPath = EPADConfig.getInstance().getStringPropertyValue("baseSchemaDir") + EPADConfig.getInstance().getParamValue("templateSchema", "AIMTemplate_v2rvStanford.xsd");

	// The following three properties should disappear after a full RESTful conversion
	public static final String eventResourceURI = EPADConfig.getInstance().getStringPropertyValue("eventResourceURI");
	public static final String coordinationTermPrefix = EPADConfig.getInstance().getStringPropertyValue(
			"coordinationTermPrefix");

	public static final String xnatServer = EPADConfig.getInstance().getStringPropertyValue("XNATServer");
	public static final int xnatPort = EPADConfig.getInstance().getIntegerPropertyValue("XNATPort");
	public static final String xnatUploadProjectID = EPADConfig.getInstance().getStringPropertyValue(
			"XNATUploadProjectID");
	public static final String xnatUploadProjectUser = EPADConfig.getInstance().getStringPropertyValue(
			"XNATUploadProjectUser");
	public static final String xnatUploadProjectPassword = EPADConfig.getInstance().getStringPropertyValue(
			"XNATUploadProjectPassword");
	public static boolean UseEPADUsersProjects = EPADConfig.getInstance().getBooleanPropertyValue(
			"UseEPADUsersProjects", true);
	public static String mongoHostname = EPADConfig.getInstance().getParam("MongoHost");
	public static final int mongoPort = EPADConfig.getInstance().getIntegerPropertyValue("MongoPort", 27017);
	public static String mongoDB = EPADConfig.getInstance().getParamValue("MongoDB", "epaddb");
	public static String mongoUser = EPADConfig.getInstance().getParam("MongoUser");
	public static String mongoPassword = EPADConfig.getInstance().getParam("MongoPassword");
	
	private Properties properties;

	private static EPADConfig getInstance()
	{
		return ourInstance;
	}

	private EPADConfig()
	{
		try {
			properties = new Properties();
			File configFile = getConfigurationFile();
			if (!configFile.exists())
				throw new IllegalStateException("Could not find ePAD configuration file " + configFile.getAbsolutePath());

			FileInputStream fis = new FileInputStream(configFile);
			try {
				properties.load(fis);
				log.info("Using ePAD configuration file " + configFile.getAbsolutePath());
			} finally {
				IOUtils.closeQuietly(fis);
			}
		} catch (Exception e) {
			log.severe("Error reading ePAD configuration file", e);
		}
	}

	/**
	 * Get the base directory for the ePAD web server.
	 * <p>
	 * For the moment, we use ~/DicomProxy as the base directory for compatibility with older calls. Ultimately we will
	 * change location to something more general.
	 * 
	 * @return File Base directory for ePAD web server.
	 */
	public static String getEPADWebServerBaseDir()
	{
		return System.getProperty("user.home") + "/DicomProxy/";
	}

	public static String getEPADWebServerWebappsDir()
	{
		return getEPADWebServerBaseDir() + "webapps/";
	}

	public static String getEPADWebServerResourcesDir()
	{
		return getEPADWebServerBaseDir() + "resources/";
	}

	public static String getEPADWebServerEtcDir()
	{
		return getEPADWebServerBaseDir() + "etc/";
	}

	public static String getEPADWebServerDICOMScriptsDir()
	{
		return getEPADWebServerEtcDir() + "scripts/";
	}

	public static String getEPADWebServerDICOMBinDir()
	{
		return getEPADWebServerDICOMScriptsDir() + "tpl/bin/";
	}

	public static String getEPADWebServerIconsDir()
	{
		return getEPADWebServerEtcDir() + "icons/";
	}

	public static String getEPADWebServerMyScriptsDir()
	{
		return getEPADWebServerEtcDir() + "scripts/myscripts/bin/";
	}

	public static String getEPADWebServerMySQLScriptDir()
	{
		return getEPADWebServerEtcDir() + "db/mysql/";
	}

	public static String getEPADWebServerLoginDir()
	{
		return getEPADWebServerEtcDir() + "login/";
	}

	public static String getEPADWebServerUploadDir()
	{
		return getEPADWebServerResourcesDir() + "upload/";
	}

	public static String getEPADWebServerFileUploadDir()
	{
		return getEPADWebServerResourcesDir() + "fileupload/";
	}

	public static String getEPADWebServerRSNADir()
	{
		return getEPADWebServerResourcesDir() + "rsna/";
	}

	public static String getEPADWebServerAnnotationsDir()
	{
		return getEPADWebServerResourcesDir() + "annotations/";
	}

	public static String getEPADWebServerAnnotationsUploadDir()
	{
		return getEPADWebServerAnnotationsDir() + "upload/";
	}

	public static String getEPADWebServerSchemaDir()
	{
		return getEPADWebServerResourcesDir() + "schema/";
	}

	public static String getEPADWebServerAIM3XSDFilePath()
	{
		return getEPADWebServerSchemaDir() + "AIM_v3.xsd";
	}

	public static String getEPADWebServerLogDir()
	{
		return getEPADWebServerBaseDir() + "log/";
	}

	public static String getEPADWebServerPNGDir()
	{
		return getEPADWebServerResourcesDir() + "dicom/";
	}

	public static String getEPADWebServerDicomTagDir()
	{
		return getEPADWebServerResourcesDir() + "dicom/";
	}

	public static String getEPADWebServerDicomDir()
	{
		return getEPADWebServerResourcesDir() + "dicom/";
	}

	public static String getEPADWebServerPNGGridDir()
	{
		return getEPADWebServerResourcesDir() + "dicom_grid/";
	}

	public static String getEPADWebServerFilesDir()
	{
		return getEPADWebServerResourcesDir() + "files/";
	}

	public static String getEPADWebServerPluginConfigFilePath()
	{
		return getEPADWebServerEtcDir() + "plugin-config.txt";
	}

	public static String getEPADWebServerConfigFilePath()
	{
		return getEPADWebServerEtcDir() + "proxy-config.properties";
	}

	public static String getEPADWebServerLogFilePath()
	{
		return getEPADWebServerLogDir() + "dicom-proxy.log";
	}

	public static String getEPADWebServerJettyConfigFilePath()
	{
		return getEPADWebServerEtcDir() + "jetty-config.xml";
	}
	
	public static String getEPADWebServerJJVectorDataDir()
    {
		return System.getProperty("user.home") + "/tmp/jjvectorData";
    }
	
	public static String getEPADPluginDataDirectory()
    {
		return System.getProperty("user.home") + getParamValue("EPADPluginDataDirectory","/tmp");
    }

	private File getConfigurationFile()
	{
		File configFile = new File(EPADConfig.getEPADWebServerConfigFilePath());
		log.info("Found configuration file " + configFile.getAbsolutePath());

		return configFile;
	}

	public static String getEPADRemotePACsConfigFilePath()
	{
		return getEPADWebServerEtcDir() + "RemotePACsConfig.properties";
	}

	/**
	 * Returns the values of a property in ePAD's configuration file.
	 * 
	 * @param name key in config file.
	 * @return the value of that parameter.
	 */
	public String getParam(String name)
	{
		return properties.getProperty(name);
	}

	public static String getParamValue(String name)
	{
		return EPADConfig.getInstance().getParam(name);
	}

	public static String getParamValue(String name, String defaultValue)
	{
		String value =  getParamValue(name);
		if (value != null)
			return value;
		else
			return defaultValue;
	}
	
	/**
	 * 
	 * @param propertyName
	 * @return
	 * @throws IllegalArgumentException
	 */
	private String getStringPropertyValue(String propertyName)
	{
		String parameterValue = getParam(propertyName);

		if (parameterValue == null || parameterValue.length() == 0) {
			String errorMessage = "No value for parameter " + propertyName + " in configuration file";
			log.warning(errorMessage);
			throw new IllegalArgumentException(errorMessage);
		}
		return parameterValue;
	}

	/**
	 * 
	 * @param propertyName
	 * @return
	 * @throws IllegalArgumentException
	 */
	public int getIntegerPropertyValue(String propertyName)
	{
		String parameterValue = getStringPropertyValue(propertyName);
		try {
			return Integer.parseInt(parameterValue);
		} catch (NumberFormatException nfe) {
			throw new IllegalArgumentException("The parameter value for property " + propertyName
					+ " needs to be an integer. It value was " + parameterValue);
		}
	}

	public int getIntegerPropertyValue(String propertyName, int defaultValue)
	{
		String parameterValue = getParamValue(propertyName);
		if (parameterValue == null) return defaultValue;
		try {
			return Integer.parseInt(parameterValue);
		} catch (NumberFormatException nfe) {
			throw new IllegalArgumentException("The parameter value for property " + propertyName
					+ " needs to be an integer. It value was " + parameterValue);
		}
	}

	/**
	 * 
	 * @param propertyName
	 * @return
	 * 
	 */
	public boolean getBooleanPropertyValue(String propertyName)
	{
		String parameterValue = getParam(propertyName);
		if ("true".equalsIgnoreCase(parameterValue))
		{
			return true;
		}
		else if (!"false".equalsIgnoreCase(parameterValue))
		{
			log.warning("Invalid or missing property value for " + propertyName);
		}
		return false;
	}

	/**
	 * 
	 * @param propertyName
	 * @return
	 * 
	 */
	public boolean getBooleanPropertyValue(String propertyName, boolean defaultValue)
	{
		String parameterValue = getParam(propertyName);
		if (parameterValue == null)
			return defaultValue;
		if ("true".equalsIgnoreCase(parameterValue))
		{
			return true;
		}
		else if (!"false".equalsIgnoreCase(parameterValue))
		{
			log.warning("Invalid or missing property value for " + propertyName);
		}
		return false;
	}

	/**
	 * Get all the key,values as a Map of Strings.
	 * 
	 * @return Map of String keys to String values
	 */
	public Map<String, String> getAllPropertyValues()
	{
		Set<String> keys = properties.stringPropertyNames();
		Map<String, String> retVal = new HashMap<String, String>();

		for (String key : keys) {
			retVal.put(key, properties.getProperty(key));
		}
		return retVal;
	}
}
