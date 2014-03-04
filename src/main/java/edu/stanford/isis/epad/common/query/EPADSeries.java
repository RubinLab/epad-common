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
	public final List<EPADImage> ResultSet; // TODO Move to lower case but sync with front end first

	public EPADSeries(List<EPADImage> resultSet)
	{
		this.ResultSet = Collections.unmodifiableList(resultSet);
	}

	public int getNumberOfImagesInSeries()
	{
		return this.ResultSet.size();
	}

	public List<String> getImageUIDs()
	{
		List<String> result = new ArrayList<String>();
		for (EPADImage imageDescription : ResultSet) {
			result.add(imageDescription.getImageUID());
		}
		return result;
	}

	/**
	 * 
	 * @param imageUID
	 * @return Index on success; -1 on failure
	 */
	public int getImageIndex(String imageUID)
	{
		for (EPADImage imageDescription : ResultSet) {
			if (imageDescription.getImageUID().equals(imageUID)) {
				return imageDescription.instanceNumber;
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
