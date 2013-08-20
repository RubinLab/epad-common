/*
 * Copyright 2012 The Board of Trustees of the Leland Stanford Junior University.
 * Author: Daniel Rubin, Alan Snyder, Debra Willrett. All rights reserved. Possession
 * or use of this program is subject to the terms and conditions of the Academic
 * Software License Agreement available at:
 *   http://epad.stanford.edu/license/
 */
package edu.stanford.isis.epad.common.dicom;

import java.io.File;

import edu.stanford.isis.epad.common.ResourceUtils;

/**
 * Utility to formatUidToDir UID in directories.
 * 
 * @author amsnyder
 */
public class DicomFormatUtil
{
	private DicomFormatUtil()
	{
	}

	/**
	 * For a UID from 1.2.34.567 formatUidToDir into 1_2_34_567 formatUidToDir.
	 * 
	 * @param dicomUID String Expects UID in 1.2.34.567 format
	 * @return String UID in 1_2_34_567 format
	 */
	public static String formatUidToDir(String dicomUID)
	{
		return dicomUID.replace('.', '_');
	}

	public static String formatDirToUid(String dicomDir)
	{
		return dicomDir.replace('_', '.');
	}

	public static String createDicomDirPath(String studyUID)
	{
		String studyDir = formatUidToDir(studyUID);
		return ResourceUtils.getEPADWebServerDicomDir() + studyDir;
	}

	public static String createDicomDirPath(String studyUID, String seriesUID)
	{
		return createDicomDirPath(studyUID) + "/" + formatUidToDir(seriesUID);
	}

	public static String createOrderFilePath(String studyUID, String seriesUID)
	{
		return createDicomDirPath(studyUID) + "/series_" + formatUidToDir(seriesUID) + ".order";
	}

	public static boolean hasSeriesDir(String studyUID, String seriesUID)
	{
		String checkPath = ResourceUtils.getEPADWebServerDicomDir() + formatUidToDir(studyUID) + "/"
				+ formatUidToDir(seriesUID);
		File checkFile = new File(checkPath);

		return checkFile.exists();
	}

	/**
	 * Return a true if a file of this type exists.
	 * 
	 * @return boolean
	 */
	public static boolean hasFileWithExtension(String studyUID, String seriesUID, String sopInstanceUID, String extension)
	{
		if (!hasSeriesDir(studyUID, seriesUID)) {
			return false;
		}

		if (!extension.startsWith(".")) {
			extension = "." + extension;
		}

		String checkFilePath = ResourceUtils.getEPADWebServerDicomDir() + formatUidToDir(studyUID) + "/"
				+ formatUidToDir(seriesUID) + "/" + formatUidToDir(sopInstanceUID) + extension;
		File checkFile = new File(checkFilePath);

		return checkFile.exists();
	}
}
