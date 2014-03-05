package edu.stanford.isis.epad.common.query;

import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;

/**
 * 
 * 
 * 
 * @author martin
 */
public class DCM4CHEESeriesList
{
	public final DCM4CHEESeriesResultSet ResultSet; // TODO Move to lower case but sync with front end call first

	public DCM4CHEESeriesList()
	{
		this.ResultSet = new DCM4CHEESeriesResultSet();
	}

	public DCM4CHEESeriesList(List<DCM4CHEESeries> Result)
	{
		this.ResultSet = new DCM4CHEESeriesResultSet(Result);
	}

	public void addDCM4CHEESeriesDescription(DCM4CHEESeries dicomSeriesDescription)
	{
		ResultSet.Result.add(dicomSeriesDescription);
	}

	public int getNumberOfStudies()
	{
		return this.ResultSet.totalRecords;
	}

	public class DCM4CHEESeriesResultSet
	{
		public final List<DCM4CHEESeries> Result;
		public final int totalRecords;

		public DCM4CHEESeriesResultSet(List<DCM4CHEESeries> Result)
		{
			this.Result = Collections.unmodifiableList(Result);
			this.totalRecords = Result.size();
		}

		public DCM4CHEESeriesResultSet()
		{
			this.Result = Collections.emptyList();
			this.totalRecords = 0;
		}
	}

	public String toJSON()
	{
		Gson gson = new Gson();

		return gson.toJson(this);
	}
}
