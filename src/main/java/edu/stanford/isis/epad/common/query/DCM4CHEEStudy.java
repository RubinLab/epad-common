package edu.stanford.isis.epad.common.query;

import com.google.gson.Gson;

/**
 * Represents result returned by DCM4CHEE study search.
 * 
 * @author martin
 */
public class DCM4CHEEStudy
{
	public final String studyUID, patientName, patientID, examType, dateAcquired;
	public int studyStatus, seriesCount;
	public String firstSeriesUID, firstSeriesDateAcquired, studyAccessionNumber;
	public int imagesCount;
	public String studyID, studyDescription, physicianName, birthdate, sex;

	public DCM4CHEEStudy(String studyUID, String patientName, String patientID, String examType,
			String dateAcquired, int studyStatus, int seriesCount, String firstSeriesUID, String firstSeriesDateAcquired,
			String studyAccessionNumber, int imagesCount, String studyID, String studyDescription, String physicianName,
			String birthdate, String sex)
	{
		this.studyUID = studyUID;
		this.patientName = patientName;
		this.patientID = patientID;
		this.examType = examType;
		this.dateAcquired = dateAcquired;
		this.studyStatus = studyStatus;
		this.seriesCount = seriesCount;
		this.firstSeriesUID = firstSeriesUID;
		this.firstSeriesDateAcquired = firstSeriesDateAcquired;
		this.studyAccessionNumber = studyAccessionNumber;
		this.imagesCount = imagesCount;
		this.studyID = studyID;
		this.studyDescription = studyDescription;
		this.physicianName = physicianName;
		this.birthdate = birthdate;
		this.sex = sex;
	}

	public String toJSON()
	{
		Gson gson = new Gson();

		return gson.toJson(this);
	}
}