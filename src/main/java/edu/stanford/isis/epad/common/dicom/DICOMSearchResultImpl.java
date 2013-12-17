/*
 * Copyright 2012 The Board of Trustees of the Leland Stanford Junior University.
 * Author: Daniel Rubin, Alan Snyder, Debra Willrett. All rights reserved. Possession
 * or use of this program is subject to the terms and conditions of the Academic
 * Software License Agreement available at:
 *   http://epad.stanford.edu/license/
 */
package edu.stanford.isis.epad.common.dicom;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.dcm4che2.data.Tag;

import edu.stanford.isis.epad.common.util.EPADLogger;
import edu.stanford.isis.epad.common.util.Node;
import edu.stanford.isis.epad.common.util.Tree;

/**
 * This tree has one Study at the root node, which contains 1 to n Series, which optionally contains 1 to n Images or
 * SOPInstances.
 * 
 * The SearchResult can be built up over time, using multiple queries.
 * 
 * @author amsnyder
 */
public class DICOMSearchResultImpl implements DicomSearchResult
{
	private final EPADLogger logger = EPADLogger.getInstance();
	/**
	 * List of tree structures with one tree structure for each study.
	 */
	private final Map<DicomStudyUID, Tree<DicomData>> searchResultMap;
	/**
	 * List of study instance UID values for studies contained in search results.
	 */
	private final List<DicomStudyUID> studyList;
	/**
	 * String indicating type of search that was used to locate the studies.
	 */
	private final DicomStudySearchType searchType;
	/**
	 * Value used in search for studies.
	 */
	private final String searchParam;

	private final DicomSearchMap searchMap;

	public DICOMSearchResultImpl(DicomStudySearchType type, String param)
	{
		searchResultMap = new ConcurrentHashMap<DicomStudyUID, Tree<DicomData>>();
		studyList = new ArrayList<DicomStudyUID>();

		searchType = type;
		this.searchParam = param;

		searchMap = DicomSearchMap.getInstance();
	}

	@Override
	public List<DicomStudyData> getStudies()
	{
		List<DicomStudyData> retVal = new ArrayList<DicomStudyData>();

		for (DicomStudyUID currID : studyList) {
			Tree<DicomData> studyTree = searchResultMap.get(currID);
			Node<DicomData> node = studyTree.getRootElement();
			retVal.add((DicomStudyData)node.getData());
		}
		return retVal;
	}

	@Override
	public List<DicomImageData> getSOPInstancesForSeriesId(String seriesID)
	{
		return null; // To change body of implemented methods use File | Settings | File Templates.
	}

	/**
	 * Add a series to the
	 * 
	 * @param data - Map<Tag,String> data
	 */
	public void addStudyResults(Map<DicomTag, String> data)
	{

		String studyInstanceId = data.get(DicomTag.forInt(Tag.StudyInstanceUID));
		DicomStudyUID studyUID = new DicomStudyUID(studyInstanceId);

		ResultStudyData studyData = ResultDataBuilder.createStudyData(data);

		Tree<DicomData> tree = new Tree<DicomData>();
		tree.setRootElement(new Node<DicomData>(studyData));
		searchResultMap.put(studyUID, tree);
		studyList.add(studyUID);

		logger.info("Add Study Results: studyUID=" + studyUID);
	}

	/**
	 * Add Series results to a study.
	 * 
	 * @param data - Map<Tag,String> data
	 */
	public void addSeriesToStudy(DicomStudyUID dicomStudyUID, Map<DicomTag, String> data)
	{

		logger.info("Add Series to Study: studyUID=" + dicomStudyUID);

		String seriesInstanceId = data.get(DicomTag.forInt(Tag.SeriesInstanceUID));
		DicomSeriesUID seriesUID = new DicomSeriesUID(seriesInstanceId);

		ResultSeriesData seriesData = ResultDataBuilder.createSeriesData(data, dicomStudyUID, seriesUID);

		Tree<DicomData> tree = searchResultMap.get(dicomStudyUID);
		if (tree == null) {
			throw new IllegalStateException("Could not find. studyUID=" + dicomStudyUID + ", " + printStateInfo());
		}

		Node<DicomData> studyNode = tree.getRootElement();
		studyNode.addChild(new Node<DicomData>(seriesData));

		searchMap.put(seriesUID, dicomStudyUID);
	}

	/**
	 * Add Image results to a series.
	 * 
	 * @param data - Map<Tag,String> data
	 */
	void addImagesToSeries(DicomSeriesUID seriesId, Map<DicomTag, String> data)
	{

	}

	/**
	 * Print the state of of this search result for debugging.
	 * 
	 * @return
	 */
	private String printStateInfo()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("searchType: ").append(searchType);
		sb.append(", searchParam: ").append(searchParam);
		sb.append(", searchResultMap: ").append(searchResultMap);
		sb.append(", studyList: ").append(studyList);

		return sb.toString();
	}

}
