package edu.stanford.epad.common.pixelmed;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

import com.pixelmed.dicom.Attribute;
import com.pixelmed.dicom.AttributeList;
import com.pixelmed.dicom.AttributeTag;
import com.pixelmed.dicom.DicomDictionary;
import com.pixelmed.dicom.DicomException;
import com.pixelmed.dicom.DicomInputStream;
import com.pixelmed.dicom.SOPClass;
import com.pixelmed.dicom.TagFromName;

import edu.stanford.epad.common.util.EPADLogger;

public class PixelMedUtils
{
	private static final EPADLogger log = EPADLogger.getInstance();

	private static final DicomDictionary dicomDictionary = new DicomDictionary();

	public static final String WindowWidthTagCode = TagFromName.WindowWidth.toString();
	public static final String WindowWidthTagName = dicomDictionary.getFullNameFromTag(TagFromName.WindowWidth);
	public static final String WindowCenterTagCode = TagFromName.WindowCenter.toString();
	public static final String WindowCenterTagName = dicomDictionary.getFullNameFromTag(TagFromName.WindowCenter);
	public static final String RowsTagCode = TagFromName.Rows.toString();
	public static final String RowsTagName = dicomDictionary.getFullNameFromTag(TagFromName.Rows);
	public static final String ColumnsTagCode = TagFromName.Columns.toString();
	public static final String ColumnsTagName = dicomDictionary.getFullNameFromTag(TagFromName.Columns);
	public static final String StudyDateCode = TagFromName.StudyDate.toString();
	public static final String StudyDateTagName = dicomDictionary.getFullNameFromTag(TagFromName.StudyDate);
	public static final String StudyTimeCode = TagFromName.StudyTime.toString();
	public static final String StudyTimeTagName = dicomDictionary.getFullNameFromTag(TagFromName.StudyTime);
	public static final String RescaleSlopeCode = TagFromName.RescaleSlope.toString();
	public static final String RescaleSlopeTagName = dicomDictionary.getFullNameFromTag(TagFromName.RescaleSlope);
	public static final String RescaleInterceptCode = TagFromName.RescaleIntercept.toString();
	public static final String RescaleInterceptTagName = dicomDictionary.getFullNameFromTag(TagFromName.RescaleIntercept);
	public static final String PixelSpacingCode = TagFromName.PixelSpacing.toString();
	public static final String PixelSpacingTagName = dicomDictionary.getFullNameFromTag(TagFromName.PixelSpacing);
	public static final String PatientBirthDateCode = TagFromName.PatientBirthDate.toString();
	public static final String PatientBirthDateTagName = dicomDictionary.getFullNameFromTag(TagFromName.PatientBirthDate);

	private PixelMedUtils()
	{
	}

	public static AttributeList readDICOMAttributeList(File dicomFile)
	{
		AttributeList attributeList = new AttributeList();
		DicomInputStream dicomInputStream = null;

		try {
			dicomInputStream = new DicomInputStream(new FileInputStream(dicomFile.getAbsolutePath()));
			attributeList.read(dicomInputStream);
		} catch (FileNotFoundException e) {
			log.warning("Could not find DICOM tag file " + dicomFile.getAbsolutePath());
		} catch (IOException e) {
			log.warning("Exception reading DICOM tag file " + dicomFile.getAbsolutePath(), e);
		} catch (DicomException e) {
			log.warning("DICOM exception reading DICOM tag file " + dicomFile.getAbsolutePath(), e);
		} finally {
			IOUtils.closeQuietly(dicomInputStream);
		}

		return attributeList;
	}

	public static void logAttributesList(AttributeList attributeList)
	{
		DicomDictionary dd = new DicomDictionary();
		for (AttributeTag key : attributeList.keySet()) {
			log.info("key " + dd.getNameFromTag(key) + ", value " + attributeList.get(key));
		}
	}

	public static AttributeList readAttributeListFromDicomFile(String dicomFilePath) throws IOException, DicomException
	{
		AttributeList attributeList = new AttributeList();
		DicomInputStream dis = null;

		try {
			dis = new DicomInputStream(new FileInputStream(dicomFilePath));
			attributeList.read(dis);
		} finally {
			IOUtils.closeQuietly(dis);
		}
		return attributeList;
	}

	public static boolean isDicomSegmentationObject(String filePath)
	{
		try {
			AttributeList attributeList = readAttributeListFromDicomFile(filePath);
			String sopClassUID = Attribute.getSingleStringValueOrEmptyString(attributeList, TagFromName.SOPClassUID);

			return sopClassUID.equals(SOPClass.SegmentationStorage);
		} catch (Exception e) {
			log.warning("Error reading DICOM attribute list", e);
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
