/*
 * Copyright 2012 The Board of Trustees of the Leland Stanford Junior University.
 * Author: Daniel Rubin, Alan Snyder, Debra Willrett. All rights reserved. Possession
 * or use of this program is subject to the terms and conditions of the Academic
 * Software License Agreement available at:
 *   http://epad.stanford.edu/license/
 */
package edu.stanford.isis.epad.common;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import edu.stanford.isis.epad.common.dicom.DicomFormatUtil;
import edu.stanford.isis.epad.common.dicom.DicomSeriesUID;
import edu.stanford.isis.epad.common.dicom.DicomStudyUID;

/**
 * 
 * @author amsnyder
 */
public class ResourceUtils
{
	private static final ProxyLogger log = ProxyLogger.getInstance();

	private ResourceUtils()
	{
	}

	/**
	 * Write a JPG URL to a file
	 * 
	 * @param jpgUrl URL of a jpg image.
	 * @param file Filename to write this image
	 */
	public static void writeJpgUrlToFile(String jpgUrl, File file) throws MalformedURLException, IOException
	{
		URL url = new URL(jpgUrl);
		BufferedImage bi = ImageIO.read(url);
		ImageIO.write(bi, "jpg", file);
	}

	/**
	 * Create a file if it doesn't exist.
	 * 
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static File generateFile(String path) throws IOException
	{
		File f = new File(path);
		if (!f.exists()) {
			createAncestors(f.getParentFile());
			log.debug("Creating new file: " + f.getAbsolutePath());
			f.createNewFile();
		}
		return f;
	}

	/**
	 * Create this directory and all of it's ancestors. Throw an exception if this is an invalid file.
	 * 
	 * @param dir
	 */
	private static void createAncestors(File dir) throws IOException
	{
		if (!dir.exists()) {
			createAncestors(dir.getParentFile());
		}
		dir.mkdir();
	}

	/**
	 * Get the base directory for the ePAD web server as a File.
	 * <p>
	 * For the moment, we use ~/DicomProxy as the base directory for compatibility with pre-Restlet calls. Ultimately we
	 * will change location to something more general.
	 * 
	 * @return File - base directory for DicomProxy.
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

	public static String getEPADWebServerUploadDir()
	{
		return getEPADWebServerResourcesDir() + "upload/";
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

	public static String getAIM3Namespace()
	{
		return "gme://caCORE.caCORE/3.2/edu.northwestern.radiology.AIM";
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

	/**
	 * Make the file path to a thumbnail given it's studyID and seriesID. The study and series Id all have the '.'
	 * replaced with '_'.
	 * 
	 * @param studyUID
	 * @param seriesUID
	 * @return String - like: resources/dicom/<studyUID>/thumbnail_<seriesUID>.jpg
	 */
	public static String makeThumbnailFilePath(DicomStudyUID studyUID, DicomSeriesUID seriesUID)
	{
		String studyDir = DicomFormatUtil.formatUidToDir(studyUID.toString());
		String seriesName = DicomFormatUtil.formatUidToDir(seriesUID.toString());

		return getEPADWebServerResourcesDir() + "/dicom/" + studyDir + "/thumbnail_" + seriesName + ".jpg";
	}
}
