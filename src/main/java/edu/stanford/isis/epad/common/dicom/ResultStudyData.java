/*
 * Copyright 2012 The Board of Trustees of the Leland Stanford Junior University.
 * Author: Daniel Rubin, Alan Snyder, Debra Willrett. All rights reserved. Possession
 * or use of this program is subject to the terms and conditions of the Academic
 * Software License Agreement available at:
 *   http://epad.stanford.edu/license/
 */
package edu.stanford.isis.epad.common.dicom;

import java.util.Map;

import org.dcm4che2.data.Tag;

/**
 * DicomStudy
 * 
 * @author amsnyder
 */
public class ResultStudyData implements DicomStudyData
{
	private final Map<DicomTag, String> tagMap;

	public ResultStudyData(Map<DicomTag, String> map)
	{
		tagMap = map;
	}

	@Override
	public DicomStudyUID getStudyId()
	{
		return new DicomStudyUID(getTag(Tag.StudyInstanceUID));
	}

	@Override
	public boolean hasSeriesData()
	{
		return false; // To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public DicomQueryLevel getType()
	{
		return DicomQueryLevel.STUDY;
	}

	@Override
	public String getPatientId()
	{
		return getTag(Tag.PatientID);
	}

	@Override
	public String getPatientName()
	{
		return getTag(Tag.PatientName);
	}

	@Override
	public String getStudyDate()
	{
		return getTag(Tag.StudyDate);
	}

	@Override
	public String getExamType()
	{
		return getTag(Tag.ModalitiesInStudy);
	}

	/**
	 * utility method. This might go in an abstract class.
	 * 
	 * @param tagValue
	 * @return String
	 */
	private String getTag(int tagValue)
	{
		return tagMap.get(DicomTag.forInt(tagValue));
	}
}
