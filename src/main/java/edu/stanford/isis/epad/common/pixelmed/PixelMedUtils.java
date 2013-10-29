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

	private static DicomInputStream getDicomInputStream(String dicomFilePath) throws IOException
	{
		return new DicomInputStream(new FileInputStream(dicomFilePath));
	}

	public static AttributeList readAttributeListFromDicomFile(String dicomFilePath) throws IOException, DicomException
	{
		DicomInputStream dis = getDicomInputStream(dicomFilePath);
		AttributeList attributeList = new AttributeList();
		attributeList.read(dis);
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
