package edu.stanford.isis.epad.common.query;

import com.google.gson.Gson;

/**
 * @author martin
 */
public class EPADStudy
{
	public final String id, insertDate, date;
	public final EPADSeriesList series;

	public EPADStudy(String id, String insertDate, String label, String date)
	{
		this.id = id;
		this.insertDate = insertDate;
		this.date = date;
		this.series = new EPADSeriesList();
	}

	public String toJSON()
	{
		Gson gson = new Gson();

		return gson.toJson(this);
	}
}