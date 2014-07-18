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

	public static final String WindowWidthCode = getTagCode(TagFromName.WindowWidth);
	public static final String WindowWidthTagName = dicomDictionary.getFullNameFromTag(TagFromName.WindowWidth);
	public static final String WindowCenterCode = getTagCode(TagFromName.WindowCenter);
	public static final String WindowCenterTagName = dicomDictionary.getFullNameFromTag(TagFromName.WindowCenter);
	public static final String RowsCode = getTagCode(TagFromName.Rows);
	public static final String RowsTagName = dicomDictionary.getFullNameFromTag(TagFromName.Rows);
	public static final String ColumnsCode = getTagCode(TagFromName.Columns);
	public static final String ColumnsTagName = dicomDictionary.getFullNameFromTag(TagFromName.Columns);
	public static final String StudyDateCode = getTagCode(TagFromName.StudyDate);
	public static final String StudyDateTagName = dicomDictionary.getFullNameFromTag(TagFromName.StudyDate);
	public static final String StudyTimeCode = getTagCode(TagFromName.StudyTime);
	public static final String StudyTimeTagName = dicomDictionary.getFullNameFromTag(TagFromName.StudyTime);
	public static final String RescaleSlopeCode = getTagCode(TagFromName.RescaleSlope);
	public static final String RescaleSlopeTagName = dicomDictionary.getFullNameFromTag(TagFromName.RescaleSlope);
	public static final String RescaleInterceptCode = getTagCode(TagFromName.RescaleIntercept);
	public static final String RescaleInterceptTagName = dicomDictionary.getFullNameFromTag(TagFromName.RescaleIntercept);
	public static final String PixelSpacingCode = getTagCode(TagFromName.PixelSpacing);
	public static final String PixelSpacingTagName = dicomDictionary.getFullNameFromTag(TagFromName.PixelSpacing);
	public static final String PatientBirthDateCode = getTagCode(TagFromName.PatientBirthDate);
	public static final String PatientBirthDateTagName = dicomDictionary.getFullNameFromTag(TagFromName.PatientBirthDate);

	public static final String SliceThicknessCode = getTagCode(TagFromName.SliceThickness);
	public static final String SliceThicknessTagName = dicomDictionary.getFullNameFromTag(TagFromName.SliceThickness);
	public static final String SliceLocationCode = getTagCode(TagFromName.SliceLocation);
	public static final String SliceLocationTagName = dicomDictionary.getFullNameFromTag(TagFromName.SliceLocation);

	public static final String PatientNameCode = getTagCode(TagFromName.PatientName);
	public static final String PatientNameTagName = dicomDictionary.getFullNameFromTag(TagFromName.PatientName);
	public static final String PatientSexCode = getTagCode(TagFromName.PatientSex);
	public static final String PatientSexTagName = dicomDictionary.getFullNameFromTag(TagFromName.PatientSex);
	public static final String ModalityCode = getTagCode(TagFromName.Modality);
	public static final String ModalityTagName = dicomDictionary.getFullNameFromTag(TagFromName.Modality);
	public static final String SeriesDescriptionCode = getTagCode(TagFromName.SeriesDescription);
	public static final String SeriesDescriptionTagName = dicomDictionary
			.getFullNameFromTag(TagFromName.SeriesDescription);
	public static final String ManufacturerCode = getTagCode(TagFromName.Manufacturer);
	public static final String ManufacturerTagName = dicomDictionary.getFullNameFromTag(TagFromName.Manufacturer);
	public static final String ModelNameCode = getTagCode(TagFromName.ManufacturerModelName);
	public static final String ModelNameTagName = dicomDictionary.getFullNameFromTag(TagFromName.ManufacturerModelName);
	public static final String SoftwareVersionCode = getTagCode(TagFromName.SoftwareVersion);
	public static final String SoftwareVersionTagName = dicomDictionary.getFullNameFromTag(TagFromName.SoftwareVersion);

	public static final String BitsStoredCode = getTagCode(TagFromName.BitsStored);
	public static final String BitsStoredTagName = dicomDictionary.getFullNameFromTag(TagFromName.BitsStored);
	public static final String PixelRepresentationCode = getTagCode(TagFromName.PixelRepresentation);
	public static final String PixelRepresentationTagName = dicomDictionary
			.getFullNameFromTag(TagFromName.PixelRepresentation);
	public static final String NumberOfFramesCode = getTagCode(TagFromName.NumberOfFrames);
	public static final String NumberOfFramesTagName = dicomDictionary.getFullNameFromTag(TagFromName.NumberOfFrames);
	public static final String ReferencedSOPInstanceUIDCode = getTagCode(TagFromName.ReferencedSOPInstanceUID);
	public static final String ReferencedSOPInstanceUIDTagName = dicomDictionary
			.getFullNameFromTag(TagFromName.ReferencedSOPInstanceUID);

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

	private static String getTagCode(AttributeTag tag)
	{
		int group = tag.getGroup();
		int element = tag.getElement();
		StringBuffer str = new StringBuffer();
		str.append("(");
		String groupString = Integer.toHexString(group);
		for (int i = groupString.length(); i < 4; ++i)
			str.append("0");
		str.append(groupString);
		str.append(",");
		String elementString = Integer.toHexString(element);
		for (int i = elementString.length(); i < 4; ++i)
			str.append("0");
		str.append(elementString);
		str.append(")");
		return str.toString();
	}
}
