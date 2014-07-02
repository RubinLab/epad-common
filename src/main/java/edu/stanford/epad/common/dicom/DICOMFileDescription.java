package edu.stanford.epad.common.dicom;

public class DICOMFileDescription
{
	public final String studyUID, seriesUID, imageUID;
	public final int instanceNumber;
	public final String filePath;
	public final int fileSize;

	public DICOMFileDescription(String studyUID, String seriesUID, String imageUID, int instanceNumber, String filePath,
			int fileSize)
	{
		this.studyUID = studyUID;
		this.seriesUID = seriesUID;
		this.imageUID = imageUID;
		this.instanceNumber = instanceNumber;
		this.filePath = filePath;
		this.fileSize = fileSize;
	}
}
