package edu.stanford.isis.epad.common.query;

import java.util.ArrayList;
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
	public final List<DCM4CHEEStudy> ResultSet; // TODO Move to lower case but sync with front end call first

	public DCM4CHEEStudyList()
	{
		this.ResultSet = new ArrayList<DCM4CHEEStudy>();
	}

	public DCM4CHEEStudyList(List<DCM4CHEEStudy> resultSet)
	{
		this.ResultSet = Collections.unmodifiableList(resultSet);
	}

	public void addDICOMStudyDescription(DCM4CHEEStudy dicomStudyDescription)
	{
		ResultSet.add(dicomStudyDescription);
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
