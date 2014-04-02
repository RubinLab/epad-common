/*
 * Copyright 2012 The Board of Trustees of the Leland Stanford Junior University.
 * Author: Daniel Rubin, Alan Snyder, Debra Willrett. All rights reserved. Possession
 * or use of this program is subject to the terms and conditions of the Academic
 * Software License Agreement available at:
 *   http://epad.stanford.edu/license/
 */
package edu.stanford.epad.common.util;

/**
 * Use this class as the logger for the ePAD web server, which logs the data in the ./log/epad-ws.log file.
 */
public class EPADLogger
{
	private final static EPADLogger ourInstance = new EPADLogger();

	private final org.apache.log4j.Logger log;

	public static EPADLogger getInstance()
	{
		return ourInstance;
	}

	private EPADLogger()
	{
		log = org.apache.log4j.Logger.getLogger(EPADLogger.class);
	}

	public void debug(String message)
	{
		debug(message);
	}

	public void info(String message)
	{
		log.info(message);
	}

	public void warning(String message, Throwable t)
	{
		log.warn(message + ":" + t.getClass().getCanonicalName() + ":" + t.getMessage(), t);
	}

	public void warning(String message)
	{
		log.warn(message);
	}

	public void severe(String message, Throwable t)
	{
		log.fatal(message, t);
	}
}
