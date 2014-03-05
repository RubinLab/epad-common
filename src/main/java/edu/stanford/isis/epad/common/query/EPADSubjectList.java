package edu.stanford.isis.epad.common.query;

import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;

public class EPADSubjectList
{
	public final EPADSubjectResultSet ResultSet;

	public EPADSubjectList(List<EPADSubject> Result)
	{
		this.ResultSet = new EPADSubjectResultSet(Result);
	}

	public EPADSubjectList()
	{
		this.ResultSet = new EPADSubjectResultSet();
	}

	public static EPADSubjectList emptySubjects()
	{
		return new EPADSubjectList();
	}

	public class EPADSubjectResultSet
	{
		public final List<EPADSubject> Result;
		public final int totalRecords;

		public EPADSubjectResultSet(List<EPADSubject> Result)
		{
			this.Result = Collections.unmodifiableList(Result);
			this.totalRecords = Result.size();
		}

		public EPADSubjectResultSet()
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
