package edu.stanford.isis.epad.common.query;

import com.google.gson.Gson;

/**
 * 
 * @author martin
 */
public class EPADSubject
{
	public final String projectID, name, id, uri;
	public final EPADStudyList studies;

	public EPADSubject(String projectID, String name, String id, String uri)
	{
		this.projectID = projectID;
		this.name = name;
		this.id = id;
		this.uri = uri;
		this.studies = new EPADStudyList();
	}

	public String toJSON()
	{
		Gson gson = new Gson();

		return gson.toJson(this);
	}
}
