package edu.stanford.isis.epad.common.query;

import com.google.gson.Gson;

/**
 * 
 * @author martin
 */
public class EPADSubject
{
	public final String project, insert_user, id, insert_date, label, uri, src;
	public final int numberOfStudies;
	public final int numberOfAnnotations;

	// Set<String> examTypes;

	public EPADSubject(String project, String insert_user, String id, String insert_date, String label, String uri,
			String src, int numberOfStudies, int numberOfAnnotations)
	{
		this.project = project;
		this.insert_user = insert_user;
		this.id = id;
		this.insert_date = insert_date;
		this.label = label;
		this.uri = uri;
		this.src = src;
		this.numberOfStudies = numberOfStudies;
		this.numberOfAnnotations = numberOfAnnotations;
	}

	public String toJSON()
	{
		Gson gson = new Gson();

		return gson.toJson(this);
	}
}
