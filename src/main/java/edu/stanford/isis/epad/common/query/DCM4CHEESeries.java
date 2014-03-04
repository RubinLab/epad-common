package edu.stanford.isis.epad.common.query;

import com.google.gson.Gson;

/**
 * Represents result returned by DCM4CHEE series search.
 * 
 * @author martin
 */
public class DCM4CHEESeries
{
	public final String seriesID, patientID, patientName, seriesDate, examType, thumbnailURL, seriesDescription;
	public final int numberOfSeriesRelatedInstances, imagesInSeries, seriesStatus;
	public final String bodyPart, institution, stationName, department, accessionNumber;

	public DCM4CHEESeries(String seriesID, String patientID, String patientName, String seriesDate,
			String examType, String thumbnailURL, String seriesDescription, int numberOfSeriesRelatedInstances,
			int imagesInSeries, int seriesStatus, String bodyPart, String institution, String stationName, String department,
			String accessionNumber)
	{
		this.seriesID = seriesID;
		this.patientID = patientID;
		this.patientName = patientName;
		this.seriesDate = seriesDate;
		this.examType = examType;
		this.thumbnailURL = thumbnailURL;
		this.seriesDescription = seriesDescription;
		this.numberOfSeriesRelatedInstances = numberOfSeriesRelatedInstances;
		this.imagesInSeries = imagesInSeries;
		this.seriesStatus = seriesStatus;
		this.bodyPart = bodyPart;
		this.institution = institution;
		this.stationName = stationName;
		this.department = department;
		this.accessionNumber = accessionNumber;
	}

	public String toJSON()
	{
		Gson gson = new Gson();

		return gson.toJson(this);
	}
}
