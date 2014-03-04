package edu.stanford.isis.epad.common.dicom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Result returned from an ePAD series description query.
 * 
 * @author martin
 * @see DICOMSeriesOrderHandler
 */
public class DICOMSeriesDescription
{
	public final List<DicomImageDescription> ResultSet; // TODO Move to lower case but sync with front end
																																	// call first

	public DICOMSeriesDescription(List<DicomImageDescription> resultSet)
	{
		this.ResultSet = Collections.unmodifiableList(resultSet);
	}

	public int getNumberOfImagesInSeries()
	{
		return this.ResultSet.size();
	}

	public List<String> getImageUIDs()
	{
		List<String> result = new ArrayList<String>();
		for (DicomImageDescription imageDescription : ResultSet) {
			result.add(imageDescription.getImageUID());
		}
		return result;
	}

	/**
	 * 
	 * @param imageUID
	 * @return Index on success; -1 on failure
	 */
	public int getImageIndex(String imageUID)
	{
		for (DicomImageDescription imageDescription : ResultSet) {
			if (imageDescription.getImageUID().equals(imageUID)) {
				return imageDescription.instanceNumber;
			}
		}
		return -1;
	}
}
