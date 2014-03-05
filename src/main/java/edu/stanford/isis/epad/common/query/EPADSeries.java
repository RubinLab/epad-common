package edu.stanford.isis.epad.common.query;

import com.google.gson.Gson;

/**
 * A description of a series returned from an ePAD query. Designed to be JSON serializable.
 * 
 * @author martin
 */
public class EPADSeries
{
	public final String seriesID, seriesDate, examType;
	public final int numberOfImages;
	public final int numberOfAnnotations;

	public EPADSeries(String seriesID, String seriesDate, String examType, int numberOfImages, int numberOfAnnotations)
	{
		this.seriesID = seriesID;
		this.seriesDate = seriesDate;
		this.examType = examType;
		this.numberOfImages = numberOfImages;
		this.numberOfAnnotations = numberOfAnnotations;
	}

	public String toJSON()
	{
		Gson gson = new Gson();

		return gson.toJson(this);
	}
}