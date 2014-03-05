package edu.stanford.isis.epad.common.query;

import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;

/**
 * A description of an image list returned from ePAD. Designed to be JSON serializable.
 * 
 * 
 * @author martin
 */
public class EPADImageList
{
	public final EPADImageResultSet ResultSet;

	public EPADImageList(List<EPADImage> Result)
	{
		this.ResultSet = new EPADImageResultSet(Result);
	}

	public EPADImageList()
	{
		this.ResultSet = new EPADImageResultSet();
	}

	public static EPADImageList emptyImages()
	{
		return new EPADImageList();
	}

	public class EPADImageResultSet
	{
		public final List<EPADImage> Result;
		public final int totalRecords;

		public EPADImageResultSet(List<EPADImage> Result)
		{
			this.Result = Collections.unmodifiableList(Result);
			this.totalRecords = Result.size();
		}

		public EPADImageResultSet()
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
