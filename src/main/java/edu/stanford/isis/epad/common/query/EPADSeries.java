package edu.stanford.isis.epad.common.query;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;

/**
 * Result returned from an ePAD series description query.
 * 
 * @author martin
 * @see DICOMSeriesOrderHandler
 */
public class EPADSeries
{
	public final EPADSeriesResultSet ResultSet; // TODO Move to lower case but sync with front end first

	public EPADSeries(List<EPADImage> Result)
	{
		this.ResultSet = new EPADSeriesResultSet(Result);
	}

	public int getNumberOfImagesInSeries()
	{
		return this.ResultSet.Result.size();
	}

	public List<String> getImageUIDs()
	{
		List<String> result = new ArrayList<String>();
		for (EPADImage imageDescription : ResultSet.Result) {
			result.add(imageDescription.getImageUID());
		}
		return result;
	}

	public class EPADSeriesResultSet
	{
		public final List<EPADImage> Result;
		public final int totalRecords;

		public EPADSeriesResultSet(List<EPADImage> Result)
		{
			this.Result = Collections.unmodifiableList(Result);
			this.totalRecords = Result.size();
		}

		public EPADSeriesResultSet()
		{
			this.Result = Collections.emptyList();
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
		for (EPADImage epadImage : ResultSet.Result) {
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
