package edu.stanford.epad.common.plugins;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.pixelmed.dicom.Attribute;
import com.pixelmed.dicom.AttributeList;
import com.pixelmed.dicom.TagFromName;

import edu.stanford.epad.common.util.EPADLogger;
import edu.stanford.epad.common.util.EPADResources;
import edu.stanford.epad.common.util.EPADTools;
import edu.stanford.hakan.aim3api.base.AimException;
import edu.stanford.hakan.aim3api.base.DICOMImageReference;
import edu.stanford.hakan.aim3api.base.ImageAnnotation;
import edu.stanford.hakan.aim3api.base.ImageSeries;
import edu.stanford.hakan.aim3api.base.ImageStudy;
import edu.stanford.hakan.aim3api.base.Person;
import edu.stanford.hakan.aim3api.base.Segmentation;
import edu.stanford.hakan.aim3api.base.SegmentationCollection;
import edu.stanford.hakan.aim3api.base.User;
import edu.stanford.hakan.aim3api.usage.AnnotationBuilder;
import edu.stanford.hakan.aim3api.usage.AnnotationGetter;

public class PluginAIMUtil
{
	private static final EPADLogger log = EPADLogger.getInstance();

	/**
	 * Currently called by plugins after generating DSO.
	 * 
	 * {@link DicomSegmentationObjectPNGMaskGeneratorTask#generateAIMFileForDSO} for DSO AIM generation.
	 */
	public static ImageAnnotation generateAIMFileForDSO(ImageAnnotation templateImageAnnotation,
			AttributeList dsoDICOMAttributes, String sourceStudyUID, String sourceSeriesUID, String sourceImageUID)
			throws AimException
	{
		String patientID = Attribute.getSingleStringValueOrEmptyString(dsoDICOMAttributes, TagFromName.PatientID);
		String patientName = Attribute.getSingleStringValueOrEmptyString(dsoDICOMAttributes, TagFromName.PatientName);
		String sopClassUID = Attribute.getSingleStringValueOrEmptyString(dsoDICOMAttributes, TagFromName.SOPClassUID);
		String dsoStudyUID = Attribute.getSingleStringValueOrEmptyString(dsoDICOMAttributes, TagFromName.StudyInstanceUID);
		String dsoSeriesUID = Attribute
				.getSingleStringValueOrEmptyString(dsoDICOMAttributes, TagFromName.SeriesInstanceUID);
		String dsoImageUID = Attribute.getSingleStringValueOrEmptyString(dsoDICOMAttributes, TagFromName.SOPInstanceUID);

		String username = getOwnerFromImageAnnotation(templateImageAnnotation);
		// Person person = getPersonFromImageAnnotation(templateImageAnnotation);

		log.info("template AIM ID " + templateImageAnnotation.getUniqueIdentifier());

		log.info("patientID " + patientID);
		log.info("patientName " + patientName);
		log.info("DSO Study " + dsoStudyUID);
		log.info("DSO Series " + dsoSeriesUID);
		log.info("DSO Image " + dsoImageUID);
		log.info("User " + username);

		addSegmentToImageAnnotation(sopClassUID, dsoImageUID, templateImageAnnotation);
		addDICOMImageReferenceToImageAnnotation(dsoStudyUID, dsoSeriesUID, dsoImageUID, templateImageAnnotation);

		return templateImageAnnotation;
	}

	public static ImageAnnotation getImageAnnotationFromServer(String aimID) throws AimException
	{
		String namespace = EPADTools.aim3Namespace;
		String eXistServerUrl = EPADTools.eXistURI;
		String password = EPADTools.eXistPassword;
		String eXistCollection = EPADTools.eXistCollection;
		String username = EPADTools.eXistUsername;
		String aim3XSDFilePath = EPADResources.getEPADWebServerAIM3XSDFilePath();
		String validAIMFileName = aimID.toLowerCase();

		if (validAIMFileName.endsWith(".xml") || validAIMFileName.endsWith(".aim"))
			validAIMFileName = validAIMFileName.substring(0, validAIMFileName.lastIndexOf('.'));
		if (validAIMFileName.startsWith("aim_"))
			validAIMFileName = validAIMFileName.substring(validAIMFileName.lastIndexOf('_') + 1, validAIMFileName.length());

		ImageAnnotation aim = AnnotationGetter.getImageAnnotationFromServerByUniqueIdentifier(eXistServerUrl, namespace,
				eXistCollection, username, password, validAIMFileName, aim3XSDFilePath);

		if (aim == null)
			log.warning("Could not find AIM annotation on server with ID " + aimID);

		return aim;
	}

	public static void sendImageAnnotationToServer(ImageAnnotation imageAnnotation) throws AimException
	{
		String namespace = EPADTools.aim3Namespace;
		String serverUrl = EPADTools.eXistURI;
		String password = EPADTools.eXistPassword;
		String xsdFilePath = EPADResources.getEPADWebServerAIM3XSDFilePath();
		String collection = EPADTools.eXistCollection;
		String username = EPADTools.eXistUsername;

		AnnotationBuilder.saveToServer(imageAnnotation, serverUrl, namespace, collection, xsdFilePath, username, password);

		String result = AnnotationBuilder.getAimXMLsaveResult();
		log.info("AIM file aith ID " + imageAnnotation.getUniqueIdentifier() + " saved to server; result: " + result);
	}

	public static String getOwnerFromImageAnnotation(ImageAnnotation aim) throws AimException
	{
		if (aim.getListUser() != null) {
			if (!aim.getListUser().isEmpty())
				return aim.getListUser().get(0).getLoginName();
		}
		throw new AimException("No User in image annotation");
	}

	public static Person getPersonFromImageAnnotation(ImageAnnotation aim) throws AimException
	{
		if (aim.getListPerson() != null) {
			if (!aim.getListPerson().isEmpty())
				return aim.getListPerson().get(0);
		}
		throw new AimException("No Person in image annotation");
	}

	public static void setImageAnnotationUser(ImageAnnotation imageAnnotation, String username)
	{
		List<User> userList = new ArrayList<User>();
		User user = new User();
		user.setLoginName(username);
		imageAnnotation.setListUser(userList);
	}

	public static DICOMImageReference createDICOMImageReference(String dsoStudyInstanceUID, String dsoSeriesInstanceUID,
			String dsoSOPInstanceUID)
	{
		DICOMImageReference dicomImageReference = new DICOMImageReference();
		dicomImageReference.setCagridId(0);

		ImageStudy imageStudy = new ImageStudy();
		imageStudy.setCagridId(0);
		imageStudy.setInstanceUID(dsoStudyInstanceUID);
		imageStudy.setStartDate("2012-01-01T01:01:01"); // TODO
		imageStudy.setStartTime("12:00:00"); // TODO

		ImageSeries imageSeries = new ImageSeries();
		imageSeries.setCagridId(0);
		imageSeries.setInstanceUID(dsoSeriesInstanceUID);

		edu.stanford.hakan.aim3api.base.Image image = new edu.stanford.hakan.aim3api.base.Image();
		image.setCagridId(0);
		image.setSopClassUID(""); // TODO
		image.setSopInstanceUID(dsoSOPInstanceUID);

		imageSeries.addImage(image); // Add Image to ImageSeries
		imageStudy.setImageSeries(imageSeries); // Add ImageSeries to ImageStudy
		dicomImageReference.setImageStudy(imageStudy); // Add ImageStudy to ImageReference

		return dicomImageReference;
	}

	/**
	 * Get the canonical path if possible, otherwise get the absolute path.
	 * 
	 * @param file File
	 * @return String path of file. Concurrent path if possible.
	 */
	public static String getRealPath(File file)
	{
		try {
			return file.getCanonicalPath();
		} catch (IOException ioe) {
			return file.getAbsolutePath();
		}
	}

	public static String getAimFileContents(File aimFile) throws AimException
	{
		if (aimFile.exists()) {
			StringBuilder sb = new StringBuilder();
			try {
				BufferedReader in = new BufferedReader(new FileReader(aimFile));
				try {
					String line = null;
					while ((line = in.readLine()) != null) {
						sb.append(line);
						sb.append(System.getProperty("line.separator"));
					}
				} finally {
					in.close();
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			return sb.toString();
		} else {
			log.warning("AIM file " + aimFile.getAbsolutePath() + "does not exist");
			throw new AimException("input error - AIM.xml does not exist. file: " + aimFile.getAbsolutePath());
		}
	}

	public static String getStudyUIDFromAIM(String aimFileContents) throws PluginServletException
	{
		return getUIDFromAIM("Study", "instanceUID", aimFileContents);
	}

	public static String getSeriesUIDFromAIM(String aimFileContents) throws PluginServletException
	{
		return getUIDFromAIM("Series", "instanceUID", aimFileContents);
	}

	public static String getSOPInstanceUIDFromAIM(String aimFileContents) throws PluginServletException
	{
		return getUIDFromAIM("Image", "sopInstanceUID", aimFileContents);
	}

	private static String getUIDFromAIM(String tag, String attribute, String aimFileContents)
			throws PluginServletException
	{

		tag = tag.toLowerCase();
		attribute = attribute.toLowerCase();
		aimFileContents = aimFileContents.toLowerCase();

		int tagIndex = aimFileContents.indexOf(tag);
		if (tagIndex > 0) {
			int attribIndex = aimFileContents.indexOf(attribute, tagIndex);

			if (attribIndex > 0) {

				int start = aimFileContents.indexOf("\"", attribIndex);
				int end = aimFileContents.indexOf("\"", start + 1);

				String retVal = aimFileContents.substring(start, end + 1);
				retVal = retVal.replace('"', ' ').trim();
				return retVal;
			} else {
				throw new PluginServletException("input error", "Didn't find tag: " + tag);
			}
		} else {
			throw new PluginServletException("input error", "Didn't find attribute: " + attribute);
		}
	}

	private static void addSegmentToImageAnnotation(String sopClassUID, String dsoSOPInstanceUID,
			ImageAnnotation dsoImageAnnotation)
	{
		SegmentationCollection sc = new SegmentationCollection();
		sc.AddSegmentation(new Segmentation(0, "", sopClassUID, dsoSOPInstanceUID, 1));
		dsoImageAnnotation.setSegmentationCollection(sc);
	}

	private static void addDICOMImageReferenceToImageAnnotation(String studyInstanceUID, String seriesInstanceUID,
			String sopInstanceUID, ImageAnnotation imageAnnotation)
	{
		DICOMImageReference dicomImageReference = createDICOMImageReference(studyInstanceUID, seriesInstanceUID,
				sopInstanceUID);
		imageAnnotation.addImageReference(dicomImageReference);
	}
}
