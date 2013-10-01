package edu.stanford.isis.epad.common.dicom;

/**
 * Represents result returned by ePAD series search.
 * 
 * @author martin
 */
public class DICOMSeriesSearchResult
{
	public final String seriesID, patientID, patientName, seriesDate, examType, thumbnailURL, seriesDescription;
	public final int numberOfSeriesRelatedInstances, imagesInSeries, seriesStatus;
	public final String bodyPart, institution, stationName, department, accessionNumber;

	public DICOMSeriesSearchResult(String seriesID, String patientID, String patientName, String seriesDate,
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
}
