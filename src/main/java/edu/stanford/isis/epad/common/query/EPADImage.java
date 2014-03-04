package edu.stanford.isis.epad.common.query;

/**
 * Represents an image in the result from aa query to the ePAD database.
 * 
 * @author martin
 * 
 * @see EPADSeries
 */
public class EPADImage
{
	public final String fileName;
	public final int instanceNumber;
	public final String sliceLocation, contentTime;

	public EPADImage(String fileName, int instanceNumber, String sliceLocation, String contentTime)
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
