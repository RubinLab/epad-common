package edu.stanford.isis.epad.common.dicom;

public class DICOMElementResult
{
	public final String tagCode, tagName, value;

	public DICOMElementResult(String tagCode, String tagName, String value)
	{
		this.tagCode = tagCode;
		this.tagName = tagName;
		this.value = value;
	}
}
