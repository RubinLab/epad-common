package edu.stanford.isis.epad.common.query;

import com.google.gson.Gson;

/**
 * A description of a project returned from ePAD. Designed to be JSON serializable.
 * 
 * @author martin
 */
public class EPADProject
{
	public final String secondaryID, piLastName, description, name, id, piFirstName, uri;
	public final int numberOfSubjects;
	public final int numberOfAnnotations;

	public EPADProject(String secondaryID, String piLastName, String description, String name, String id,
			String piFirstName, String uri, int numberOfSubjects, int numberOfAnnotations)
	{
		this.secondaryID = secondaryID;
		this.piLastName = piLastName;
		this.description = description;
		this.name = name;
		this.id = id;
		this.piFirstName = piFirstName;
		this.uri = uri;
		this.numberOfSubjects = numberOfSubjects;
		this.numberOfAnnotations = numberOfAnnotations;
	}

	public String toJSON()
	{
		Gson gson = new Gson();

		return gson.toJson(this);
	}
}