/*
 * Copyright 2012 The Board of Trustees of the Leland Stanford Junior University.
 * Author: Daniel Rubin, Alan Snyder, Debra Willrett. All rights reserved. Possession
 * or use of this program is subject to the terms and conditions of the Academic
 * Software License Agreement available at:
 *   http://epad.stanford.edu/license/
 */
package edu.stanford.isis.epad.common.dicom;

import java.util.Comparator;

/**
 * Sort DICOM images in a series based on their stack order
 * 
 * @author amsnyder
 */
public class DicomImageSorter implements Comparator<DicomImageData>
{
	@Override
	public int compare(DicomImageData dicomImageData, DicomImageData dicomImageData1)
	{
		return dicomImageData.getStackOrder() - dicomImageData1.getStackOrder();
	}
}
