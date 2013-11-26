/*
 * Copyright 2012 The Board of Trustees of the Leland Stanford Junior University.
 * Author: Daniel Rubin, Alan Snyder, Debra Willrett. All rights reserved. Possession
 * or use of this program is subject to the terms and conditions of the Academic
 * Software License Agreement available at:
 *   http://epad.stanford.edu/license/
 */
package edu.stanford.isis.epad.common.dicom;

import java.util.List;

public interface DicomQueryInterface
{
	/**
	 * Searches the DICOM data give a search-parameter.
	 * 
	 * @param searchType
	 * @param searchParam
	 * @return DicomSearchResult
	 */
	DicomSearchResult searchForStudies(DicomStudySearchType searchType, String searchParam);

	/**
	 * Get DICOM tag information about a series.
	 * 
	 * @param studyUID
	 * @param remoteAddr - IP address of client used for caching purposes
	 * @return DicomSearchResult
	 */
	DicomSearchResult searchForSeries(String studyUID, String remoteAddr);

	/**
	 * Get a list of all the Images associated with a series.
	 * 
	 * @param seriesUID
	 * @return List<DicomImageData>
	 */
	List<DicomImageData> getImagesForSeries(DicomSeriesUID seriesUID);
}
