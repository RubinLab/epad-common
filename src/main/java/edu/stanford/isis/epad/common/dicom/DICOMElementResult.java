package edu.stanford.isis.epad.common.dicom;

public class DicomElementResult
{
	public final String tagCode, tagName, value;

	public DicomElementResult(String tagCode, String tagName, String value)
	{
		this.tagCode = tagCode;
		this.tagName = tagName;
		this.value = value;
	}
}
