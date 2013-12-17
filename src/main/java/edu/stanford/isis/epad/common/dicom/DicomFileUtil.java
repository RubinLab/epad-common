/*
 * Copyright 2012 The Board of Trustees of the Leland Stanford Junior University.
 * Author: Daniel Rubin, Alan Snyder, Debra Willrett. All rights reserved. Possession
 * or use of this program is subject to the terms and conditions of the Academic
 * Software License Agreement available at:
 *   http://epad.stanford.edu/license/
 */
package edu.stanford.isis.epad.common.dicom;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import edu.stanford.isis.epad.common.util.EPADFileUtils;
import edu.stanford.isis.epad.common.util.EPADLogger;

public class DicomFileUtil
{
	static final EPADLogger log = EPADLogger.getInstance();
	private static final int MIN_DICOM_FILE_SIZE = 132;
	private static final String DICOM_MAGIC_WORD = "DICM";

	private DicomFileUtil()
	{
	}

	/**
	 * Has the magic word "DICM" at offset 128 in the file.
	 * 
	 * @param f File
	 * @return boolean
	 */
	public static boolean hasMagicWordInHeader(File f)
	{
		if (f.length() < MIN_DICOM_FILE_SIZE) {
			return false;
		}

		String mWord = null;
		try {
			RandomAccessFile in = new RandomAccessFile(f, "r");
			try {
				in.seek(128);
				byte[] magicWord = new byte[4];
				in.read(magicWord, 0, 4);
				mWord = new String(magicWord);
			} finally {
				in.close();
			}
		} catch (IOException e) {
			log.warning("Failed to read file: " + f.getAbsolutePath(), e);
		}
		return DICOM_MAGIC_WORD.equalsIgnoreCase(mWord);
	}

	/**
	 * Add DICOM extension to file.
	 * 
	 * @param f File
	 * @return File
	 */
	public static File addDcmExtensionToFile(File f)
	{
		File newName = new File(f.getAbsolutePath() + ".dcm");
		try {
			EPADFileUtils.checkAndMoveFile(f, newName);
		} catch (IOException ioe) {
			log.warning("Failed to rename file: " + f.getAbsolutePath(), ioe);
		}
		return newName;
	}
}
