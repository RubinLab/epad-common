package edu.stanford.isis.epad.common.dicom;

/**
 * Represents the result from an ePAD DICOM series description query.
 * 
 * @author martin
 */
public class DICOMSeriesDescriptionSearchResult
{
	public String fileName;
	public int instanceNumber;
	public String sliceLocation, contentTime;

	public DICOMSeriesDescriptionSearchResult(String fileName, int instanceNumber, String sliceLocation,
			String contentTime)
	{
		this.fileName = fileName;
		this.instanceNumber = instanceNumber;
		this.sliceLocation = sliceLocation;
		this.contentTime = contentTime;
	}
}
