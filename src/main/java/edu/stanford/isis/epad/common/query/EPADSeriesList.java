package edu.stanford.isis.epad.common.query;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;

/**
 * A description of a series list returned from an ePAD query. Designed to be JSON serializable.
 * 
 * @author martin
 */
public class EPADSeriesList
{
	public final EPADSeriesResultSet ResultSet;

	public EPADSeriesList(List<EPADSeries> Result)
	{
		this.ResultSet = new EPADSeriesResultSet(Result);
	}

	public EPADSeriesList()
	{
		this.ResultSet = new EPADSeriesResultSet();
	}

	public static EPADSeriesList emptySeriess()
	{
		return new EPADSeriesList();
	}

	public class EPADSeriesResultSet
	{
		public final List<EPADSeries> Result;
		public final int totalRecords;

		public EPADSeriesResultSet(List<EPADSeries> Result)
		{
			this.Result = Collections.unmodifiableList(Result);
			this.totalRecords = Result.size();
		}

		public EPADSeriesResultSet()
		{
			this.Result = new ArrayList<EPADSeries>();
			this.totalRecords = 0;
		}
	}

	public String toJSON()
	{
		Gson gson = new Gson();

		return gson.toJson(this);
	}
}
