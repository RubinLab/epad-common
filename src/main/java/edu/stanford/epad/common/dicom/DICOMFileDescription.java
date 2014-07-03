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

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.filePath == null) ? 0 : this.filePath.hashCode());
		result = prime * result + this.fileSize;
		result = prime * result + ((this.imageUID == null) ? 0 : this.imageUID.hashCode());
		result = prime * result + this.instanceNumber;
		result = prime * result + ((this.seriesUID == null) ? 0 : this.seriesUID.hashCode());
		result = prime * result + ((this.studyUID == null) ? 0 : this.studyUID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DICOMFileDescription other = (DICOMFileDescription)obj;
		if (this.filePath == null) {
			if (other.filePath != null)
				return false;
		} else if (!this.filePath.equals(other.filePath))
			return false;
		if (this.fileSize != other.fileSize)
			return false;
		if (this.imageUID == null) {
			if (other.imageUID != null)
				return false;
		} else if (!this.imageUID.equals(other.imageUID))
			return false;
		if (this.instanceNumber != other.instanceNumber)
			return false;
		if (this.seriesUID == null) {
			if (other.seriesUID != null)
				return false;
		} else if (!this.seriesUID.equals(other.seriesUID))
			return false;
		if (this.studyUID == null) {
			if (other.studyUID != null)
				return false;
		} else if (!this.studyUID.equals(other.studyUID))
			return false;
		return true;
	}
}
