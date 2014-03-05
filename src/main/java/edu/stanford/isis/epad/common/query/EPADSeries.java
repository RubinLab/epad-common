package edu.stanford.isis.epad.common.query;

import com.google.gson.Gson;

/**
 * A description of a series returned from an ePAD query. Designed to be JSON serializable.
 * 
 * @author martin
 */
public class EPADSeries
{
	public final String id, insertDate, seriesDate;

	public EPADSeries(String id, String seriesDate, String insertDate)
	{
		this.id = id;
		this.seriesDate = seriesDate;
		this.insertDate = insertDate;
	}

	public String toJSON()
	{
		Gson gson = new Gson();

		return gson.toJson(this);
	}
}