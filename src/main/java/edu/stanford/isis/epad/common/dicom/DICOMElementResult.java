package edu.stanford.isis.epad.common.dicom;

/**
 * Class representing a DICOM element returned from a query to ePAD.
 * 
 * @author martin
 */
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
