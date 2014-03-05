package edu.stanford.isis.epad.common.query;

import com.google.gson.Gson;

/**
 * A description of a project returned from ePAD. Designed to be JSON serializable.
 * 
 * @author martin
 */
public class EPADProject
{
	public final String name, id, description, uri;
	public final EPADSubjectList subjects;

	public EPADProject(String name, String id, String description, String uri)
	{
		this.description = description;
		this.name = name;
		this.id = id;
		this.uri = uri;
		this.subjects = new EPADSubjectList();
	}

	public String toJSON()
	{
		Gson gson = new Gson();

		return gson.toJson(this);
	}
}