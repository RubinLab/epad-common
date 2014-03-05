package edu.stanford.isis.epad.common.query;

import com.google.gson.Gson;

/**
 * @author martin
 */
public class EPADStudy
{
	public final String project, id, insert_date, label, date, uri;
	public final String examType, studyDescription, studyAccessionNumber;
	public final int numberOfSeries;
	public final int numberOfAnnotations;

	public EPADStudy(String project, String id, String insert_date, String label, String date, String uri,
			String examType, String studyDescription, String studyAccessionNumber, int numberOfSeries, int numberOfAnnotations)
	{
		this.project = project;
		this.id = id;
		this.insert_date = insert_date;
		this.label = label;
		this.date = date;
		this.uri = uri;
		this.examType = examType;
		this.studyDescription = studyDescription;
		this.studyAccessionNumber = studyAccessionNumber;
		this.numberOfSeries = numberOfSeries;
		this.numberOfAnnotations = numberOfAnnotations;
	}

	public String toJSON()
	{
		Gson gson = new Gson();

		return gson.toJson(this);
	}
}