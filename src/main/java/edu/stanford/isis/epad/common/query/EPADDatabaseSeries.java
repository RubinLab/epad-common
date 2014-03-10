package edu.stanford.isis.epad.common.query;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;

/**
 * Result returned from an ePAD database series query.
 * 
 * @author martin
 * @see DICOMSeriesOrderHandler
 */
public class EPADDatabaseSeries
{
	public final EPADDatabaseSeriesResultSet ResultSet; // TODO Move to lower case but sync with front end first

	public EPADDatabaseSeries(List<EPADDatabaseImage> Result)
	{
		this.ResultSet = new EPADDatabaseSeriesResultSet(Result);
	}

	public int getNumberOfImagesInSeries()
	{
		return this.ResultSet.Result.size();
	}

	public List<String> getImageUIDs()
	{
		List<String> result = new ArrayList<String>();
		for (EPADDatabaseImage epadImage : ResultSet.Result) {
			result.add(epadImage.getImageUID());
		}
		return result;
	}

	public class EPADDatabaseSeriesResultSet
	{
		public final List<EPADDatabaseImage> Result;
		public final int totalRecords;

		public EPADDatabaseSeriesResultSet(List<EPADDatabaseImage> Result)
		{
			this.Result = Collections.unmodifiableList(Result);
			this.totalRecords = Result.size();
		}

		public EPADDatabaseSeriesResultSet()
		{
			this.Result = new ArrayList<EPADDatabaseImage>();
			this.totalRecords = 0;
		}
	}

	/**
	 * 
	 * @param imageUID
	 * @return Index on success; -1 on failure
	 */
	public int getImageIndex(String imageUID)
	{
		for (EPADDatabaseImage epadImage : ResultSet.Result) {
			if (epadImage.getImageUID().equals(imageUID)) {
				return epadImage.instanceNumber;
			}
		}
		return -1;
	}

	public String toJSON()
	{
		Gson gson = new Gson();

		return gson.toJson(this);
	}
}
