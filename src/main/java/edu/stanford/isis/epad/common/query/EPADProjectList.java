package edu.stanford.isis.epad.common.query;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;

/**
 * A description of a project list returned from ePAD. Designed to be JSON serializable.
 * 
 * @author martin
 */
public class EPADProjectList
{
	public final EPADProjectResultSet ResultSet;

	public EPADProjectList(List<EPADProject> Result)
	{
		this.ResultSet = new EPADProjectResultSet(Result);
	}

	public EPADProjectList()
	{
		this.ResultSet = new EPADProjectResultSet();
	}

	public static EPADProjectList emptyProjects()
	{
		return new EPADProjectList();
	}

	public class EPADProjectResultSet
	{
		public final List<EPADProject> Result;
		public final int totalRecords;

		public EPADProjectResultSet(List<EPADProject> Result)
		{
			this.Result = Collections.unmodifiableList(Result);
			this.totalRecords = Result.size();
		}

		public EPADProjectResultSet()
		{
			this.Result = new ArrayList<EPADProject>();
			this.totalRecords = 0;
		}
	}

	public String toJSON()
	{
		Gson gson = new Gson();

		return gson.toJson(this);
	}
}