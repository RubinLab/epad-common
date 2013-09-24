/*
 * Copyright 2012 The Board of Trustees of the Leland Stanford Junior University.
 * Author: Daniel Rubin, Alan Snyder, Debra Willrett. All rights reserved. Possession
 * or use of this program is subject to the terms and conditions of the Academic
 * Software License Agreement available at:
 *   http://epad.stanford.edu/license/
 */
package edu.stanford.isis.epad.common;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.stanford.isis.epad.common.util.LogFormatter;
import edu.stanford.isis.epad.common.util.ResourceUtils;

/**
 * Use this class as the logger for the ePAD web server, which logs the data in the ./log/dicom-proxy.log file.
 * 
 * @author amsnyder
 */
public class ProxyLogger
{
	private final static ProxyLogger ourInstance = new ProxyLogger();
	private final Logger log;
	private boolean useDebug = false;

	public static ProxyLogger getInstance()
	{
		return ourInstance;
	}

	private ProxyLogger()
	{
		log = Logger.getAnonymousLogger();

		try {
			FileHandler fh = new FileHandler(getLogFilePath());
			fh.setFormatter(new LogFormatter());
			log.addHandler(fh);
		} catch (Exception e) {
			System.err.println("Failed to setup logging!" + e.getMessage());
		}
	}

	private String getLogFilePath()
	{
		String logFilePath = ResourceUtils.getEPADWebServerLogFilePath();
		log.info("ePAD web service log file: " + logFilePath);

		return logFilePath;
	}

	/**
	 * Log a debug string.
	 * 
	 * @param message
	 */
	public void debug(String message)
	{
		if (useDebug)
			info(message);
	}

	/**
	 * To turn debugging on, set to true.
	 * 
	 * @param value true to turn on debug logging.
	 */
	public void setDebug(boolean value)
	{
		useDebug = value;
	}

	/**
	 * Log a standard INFO level message.
	 * 
	 * @param message
	 */
	public void info(String message)
	{
		log.info(message);
	}

	/**
	 * Log a warning with a message and the exception
	 * 
	 * @param message String to write to the log file.
	 * @param t Throwable
	 */
	public void warning(String message, Throwable t)
	{
		log.log(Level.WARNING, message, t);
	}

	public void warning(String message)
	{
		log.log(Level.WARNING, message);
	}

	/**
	 * Log a sever error with a message and a stack trace
	 * 
	 * @param message String to write to the log
	 * @param t Throwable exception with Stack Trace.
	 */
	public void sever(String message, Throwable t)
	{
		log.log(Level.SEVERE, message, t);
		if (t != null) {
			t.printStackTrace();
		}
	}
}
