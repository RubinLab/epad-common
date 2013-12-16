package edu.stanford.isis.epad.common.dicom;

/**
 * Represents an image description in the result from an ePAD DICOM series description query.
 * 
 * @author martin
 * 
 * @see DICOMSeriesDescriptionSearchResult
 */
public class DicomImageDescriptionSearchResult
{
	public String fileName;
	public int instanceNumber;
	public String sliceLocation, contentTime;

	public DicomImageDescriptionSearchResult(String fileName, int instanceNumber, String sliceLocation, String contentTime)
	{
		this.fileName = fileName;
		this.instanceNumber = instanceNumber;
		this.sliceLocation = sliceLocation;
		this.contentTime = contentTime;
	}

	public String getImageUID()
	{
		int lastDotIndex = fileName.lastIndexOf('.');

		String uidPart = fileName;
		if (lastDotIndex > 0) {
			uidPart = fileName.substring(0, lastDotIndex);
		}
		uidPart = uidPart.replaceAll("_", ".");
		return uidPart;
	}
}
