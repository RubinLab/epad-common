package edu.stanford.isis.epad.common.query;

import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;

/**
 * Description of a list of studies returned from the DCM4CHEE database.
 * 
 * @author martin
 */
public class DCM4CHEEStudyList
{
	public final DCM4CHEEStudyResultSet ResultSet; // TODO Move to lower case but sync with front end call first

	public DCM4CHEEStudyList()
	{
		this.ResultSet = new DCM4CHEEStudyResultSet();
	}

	public DCM4CHEEStudyList(List<DCM4CHEEStudy> Result)
	{
		this.ResultSet = new DCM4CHEEStudyResultSet(Result);
	}

	public void addDICOMStudyDescription(DCM4CHEEStudy dicomStudyDescription)
	{
		ResultSet.Result.add(dicomStudyDescription);
	}

	public int getNumberOfStudies()
	{
		return this.ResultSet.totalRecords;
	}

	public class DCM4CHEEStudyResultSet
	{
		public final List<DCM4CHEEStudy> Result;
		public final int totalRecords;

		public DCM4CHEEStudyResultSet(List<DCM4CHEEStudy> Result)
		{
			this.Result = Collections.unmodifiableList(Result);
			this.totalRecords = Result.size();
		}

		public DCM4CHEEStudyResultSet()
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
