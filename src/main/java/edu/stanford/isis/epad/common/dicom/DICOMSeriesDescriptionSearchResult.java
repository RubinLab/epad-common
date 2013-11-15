package edu.stanford.isis.epad.common.dicom;

/**
 * Represents the result from an ePAD DICOM series description query.
 * 
 * @author martin
 */
public class DicomSeriesDescriptionSearchResult
{
	public String fileName;
	public int instanceNumber;
	public String sliceLocation, contentTime;

	public DicomSeriesDescriptionSearchResult(String fileName, int instanceNumber, String sliceLocation,
			String contentTime)
	{
		this.fileName = fileName;
		this.instanceNumber = instanceNumber;
		this.sliceLocation = sliceLocation;
		this.contentTime = contentTime;
	}
}
