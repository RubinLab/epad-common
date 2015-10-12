package edu.stanford.epad.common.dicom;

public class DCM4CHEEImageDescription
{
	public final String studyUID, seriesUID, imageUID;
	public final int instanceNumber;
	public final String sliceLocation, contentTime, updatedTime, createdTime, classUID;
	public boolean multiFrameImage = false;

	public DCM4CHEEImageDescription(String studyUID, String seriesUID, String imageUID, int instanceNumber,
			String sliceLocation, String contentTime, String updatedTime, String createdTime, String classUID)
	{
		this.studyUID = studyUID;
		this.seriesUID = seriesUID;
		this.imageUID = imageUID;
		this.instanceNumber = instanceNumber;
		this.sliceLocation = sliceLocation;
		this.contentTime = contentTime;
		this.updatedTime = updatedTime;
		this.createdTime = createdTime;
		this.classUID = classUID;
	}
}
