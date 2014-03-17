package edu.stanford.isis.epad.common.pixelmed;

import java.io.FileInputStream;
import java.io.IOException;

import com.pixelmed.dicom.Attribute;
import com.pixelmed.dicom.AttributeList;
import com.pixelmed.dicom.DicomException;
import com.pixelmed.dicom.DicomInputStream;
import com.pixelmed.dicom.SOPClass;
import com.pixelmed.dicom.TagFromName;

/**
 * @author alansnyder
 */
public class PixelMedUtils
{
	private PixelMedUtils()
	{
	}

	public static AttributeList readAttributeListFromDicomFile(String dicomFilePath) throws IOException, DicomException
	{
		DicomInputStream dis = null;
		AttributeList attributeList = new AttributeList();

		try {
			dis = new DicomInputStream(new FileInputStream(dicomFilePath));
			attributeList.read(dis);
		} finally {
			if (dis != null)
				dis.close();
		}
		return attributeList;
	}

	public static boolean isDicomSegmentationObject(String filePath)
	{
		try {
			AttributeList list = readAttributeListFromDicomFile(filePath);
			String sopClassUID = Attribute.getSingleStringValueOrEmptyString(list, TagFromName.SOPClassUID);

			return sopClassUID.equals(SOPClass.SegmentationStorage);
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isMultiframedDicom(String filePath)
	{
		try {
			AttributeList list = readAttributeListFromDicomFile(filePath);
			int numberOfFrames = Attribute.getSingleIntegerValueOrDefault(list, TagFromName.NumberOfFrames, 1);

			return numberOfFrames > 1;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isEnhancedMultiframeImage(String filePath)
	{
		try {
			AttributeList list = readAttributeListFromDicomFile(filePath);
			String sopClassUID = Attribute.getSingleStringValueOrEmptyString(list, TagFromName.SOPClassUID);

			return SOPClass.isEnhancedMultiframeImageStorage(sopClassUID);
		} catch (Exception e) {
			return false;
		}
	}

}
