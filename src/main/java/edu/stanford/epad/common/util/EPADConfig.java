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

/**
 * Read the "etc/proxy-config.properties" file on start-up and provides method to look up values.
 */
public class EPADConfig
{
	private static final EPADLogger log = EPADLogger.getInstance();
	private static final EPADConfig ourInstance = new EPADConfig();

	private Properties properties;

	public static EPADConfig getInstance()
	{
		return ourInstance;
	}

	private EPADConfig()
	{
		try {
			properties = new Properties();
			File configFile = getConfigurationFile();
			if (!configFile.exists())
				throw new IllegalStateException("Could not find configuration file: " + configFile.getAbsolutePath());

			FileInputStream fis = new FileInputStream(configFile);
			try {
				properties.load(fis);
				log.info("Using ePAD configuration file " + configFile.getAbsolutePath());
			} finally {
				fis.close();
			}
			readProxyLoggerDebugState();
		} catch (Exception e) {
			log.severe("Error reading configuration file", e);
		}
	}

	private File getConfigurationFile()
	{
		File configFile = new File(EPADResources.getEPADWebServerConfigFilePath());
		log.info("Configuration file: " + configFile.getAbsolutePath());

		return configFile;
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

	/**
	 * Returns the value of a parameter in proxy-config.properties as an integer.
	 * 
	 * @param name key
	 * @return the parameter value as an integer
	 * @throws IllegalArgumentException if the value is not an integer in the config file.
	 */
	public int getIntParam(String name)
	{
		String s = properties.getProperty(name);
		try {
			return Integer.parseInt(s);
		} catch (NumberFormatException nfe) {
			throw new IllegalArgumentException("The parameter in : " + name + " needs to be an integer. It was: " + s);
		}
	}

	/**
	 * 
	 * @param propertyName
	 * @return
	 * @throws IllegalArgumentException
	 */
	public String getStringPropertyValue(String propertyName)
	{
		String parameterValue = getParam(propertyName);

		if (parameterValue == null || parameterValue.length() == 0) {
			String errorMessage = "no value for parameter " + propertyName + " in configuration file";
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
			throw new IllegalArgumentException("The parameter in : " + propertyName + " needs to be an integer. It was: "
					+ parameterValue);
		}
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

	/**
	 * Read <code>LoggerDebugOn</code> to set the ProxyLogger debug state.
	 */
	private void readProxyLoggerDebugState()
	{
		String debugOn = getParam("LoggerDebugOn");
		if ("true".equalsIgnoreCase(debugOn)) {
			log.setDebug(true);
		}
	}
}
