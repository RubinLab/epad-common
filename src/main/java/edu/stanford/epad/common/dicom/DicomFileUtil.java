/*
 * Copyright 2012 The Board of Trustees of the Leland Stanford Junior University.
 * Author: Daniel Rubin, Alan Snyder, Debra Willrett. All rights reserved. Possession
 * or use of this program is subject to the terms and conditions of the Academic
 * Software License Agreement available at:
 *   http://epad.stanford.edu/license/
 */
package edu.stanford.epad.common.dicom;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import edu.stanford.epad.common.util.EPADFileUtils;
import edu.stanford.epad.common.util.EPADLogger;

public class DicomFileUtil
{
	private static final EPADLogger log = EPADLogger.getInstance();
	private static final int MIN_DICOM_FILE_SIZE = 132;
	private static final String DICOM_MAGIC_WORD = "DICM";

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

	public static File addDcmExtensionToFile(File file)
	{
		File newName = new File(file.getAbsolutePath() + ".dcm");
		try {
			EPADFileUtils.checkAndMoveFile(file, newName);
		} catch (IOException ioe) {
			log.warning("Failed to rename file: " + file.getAbsolutePath(), ioe);
		}
		return newName;
	}
}
