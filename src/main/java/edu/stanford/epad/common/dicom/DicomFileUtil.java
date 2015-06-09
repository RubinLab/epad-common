/*
 * Copyright 2012 The Board of Trustees of the Leland Stanford Junior University.
 * Author: Daniel Rubin, Alan Snyder, Debra Willrett. All rights reserved. Possession
 * or use of this program is subject to the terms and conditions of the Academic
 * Software License Agreement available at:
 *   http://epad.stanford.edu/license/
 */
package edu.stanford.epad.common.dicom;

import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

import edu.stanford.epad.common.util.EPADConfig;
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
	
	/*
	 * Convert dicom to nifti file
	 */
	public static File[] convertDicomsToNifti(File dicomFolder) throws Exception
	{
		//dcm2nii.exe -g n -r n -f y -d n -p n -e n -o /outputfolder /inputfolder
		String command = EPADConfig.getEPADWebServerDICOMBinDir() + "dcm2nii -g n -r n -f y -d n -p n -e n " + dicomFolder.getAbsolutePath();
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			ProcessBuilder processBuilder = new ProcessBuilder(command);
			processBuilder.directory(new File(EPADConfig.getEPADWebServerDICOMBinDir()));
			processBuilder.redirectErrorStream(true);
			Process process = processBuilder.start();
			is = process.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
	
			String line;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
				log.debug("./dcm2nii output: " + line);
			}

			int exitValue = process.waitFor();
			log.info("DICOM convert exit value is: " + exitValue);
			class DirFilter implements FilenameFilter {
				public boolean accept(File dir, String name) {
					boolean regResult = name.endsWith(".nii");
					return regResult;
				}
			}

			FilenameFilter filter = new DirFilter();
			File[] niftis = dicomFolder.listFiles(filter);
			log.debug("Result files:" + niftis);
			return niftis;
		} catch (Exception e) {
			log.warning("Error converting dicoms", e);
			throw e;
		}
		
	}
}
