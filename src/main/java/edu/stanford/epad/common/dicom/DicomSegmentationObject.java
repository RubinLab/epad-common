package edu.stanford.epad.common.dicom;

import java.io.IOException;

import com.pixelmed.dicom.DicomException;
import com.pixelmed.display.SourceImage;

import edu.stanford.epad.common.util.EPADLogger;

/**
 * Represents a DICOM segmentation object
 * 
 */
public class DicomSegmentationObject
{
	private static final EPADLogger logger = EPADLogger.getInstance();

	public SourceImage convert(String filePath)
	{
		SourceImage source = null;
		try {
			source = new SourceImage(filePath);
		} catch (IOException e) {
			logger.warning("SourceImage failed: " + filePath, e);
		} catch (DicomException e) {
			logger.warning("SourceImage failed: " + filePath, e);
		}
		return source;
	}
}
