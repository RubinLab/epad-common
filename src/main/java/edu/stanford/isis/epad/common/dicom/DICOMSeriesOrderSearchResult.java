package edu.stanford.isis.epad.common.dicom;

/**
 * Represents the result from an ePAD DICOM series order query.
 * 
 * @author martin
 */
public class DICOMSeriesOrderSearchResult
{
	public String fileName;
	public int instanceNumber;
	public String sliceLocation, contentTime;

	public DICOMSeriesOrderSearchResult(String fileName, int instanceNumber, String sliceLocation, String contentTime)
	{
		this.fileName = fileName;
		this.instanceNumber = instanceNumber;
		this.sliceLocation = sliceLocation;
		this.contentTime = contentTime;
	}
}
