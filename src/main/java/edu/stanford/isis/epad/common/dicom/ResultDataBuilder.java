/*
 * Copyright 2012 The Board of Trustees of the Leland Stanford Junior University.
 * Author: Daniel Rubin, Alan Snyder, Debra Willrett. All rights reserved. Possession
 * or use of this program is subject to the terms and conditions of the Academic
 * Software License Agreement available at:
 *   http://epad.stanford.edu/license/
 */
package edu.stanford.isis.epad.common.dicom;

import java.util.Map;

import edu.stanford.isis.epad.common.util.EPADLogger;
import edu.stanford.isis.epad.common.util.EPADResources;

/**
 * 
 * @author amsnyder
 */
public class ResultDataBuilder
{
	private ResultDataBuilder()
	{
	}

	public static ResultStudyData createStudyData(Map<DicomTag, String> map)
	{
		// int[] required = {Tag.StudyInstanceUID, Tag.StudyDate, Tag.PatientID, Tag.PatientName, Tag.ModalitiesInStudy};

		// checkForRequiredTags(required,map);

		return new ResultStudyData(map);
	}

	public static ResultSeriesData createSeriesData(Map<DicomTag, String> map, DicomStudyUID studyUID, DicomSeriesUID seriesUID)
	{
		ResultSeriesData retVal = new ResultSeriesData(map);

		EPADLogger.getInstance().info("Making thumbnail for study=" + studyUID + ", series=" + seriesUID);
		retVal.setThumbnailURL(EPADResources.makeThumbnailFilePath(studyUID, seriesUID));
		return retVal;
	}

	public static ResultImageData createImageData(Map<DicomTag, String> map)
	{
		throw new UnsupportedOperationException("Create image data not implemented.");
	}

}
