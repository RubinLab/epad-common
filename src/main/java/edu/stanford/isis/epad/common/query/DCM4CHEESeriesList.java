package edu.stanford.isis.epad.common.query;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;

public class DCM4CHEESeriesList
{
	public final List<DCM4CHEESeries> ResultSet; // TODO Move to lower case but sync with front end call first

	public DCM4CHEESeriesList()
	{
		this.ResultSet = new ArrayList<DCM4CHEESeries>();
	}

	public DCM4CHEESeriesList(List<DCM4CHEESeries> resultSet)
	{
		this.ResultSet = Collections.unmodifiableList(resultSet);
	}

	public void addDCM4CHEESeriesDescription(DCM4CHEESeries dicomSeriesDescription)
	{
		ResultSet.add(dicomSeriesDescription);
	}

	public int getNumberOfStudies()
	{
		return this.ResultSet.size();
	}

	public String toJSON()
	{
		Gson gson = new Gson();

		return gson.toJson(this);
	}
}
