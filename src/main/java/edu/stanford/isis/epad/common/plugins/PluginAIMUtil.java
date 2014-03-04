package edu.stanford.isis.epad.common.plugins;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.stanford.hakan.aim3api.base.AimException;
import edu.stanford.hakan.aim3api.base.DICOMImageReference;
import edu.stanford.hakan.aim3api.base.ImageAnnotation;
import edu.stanford.hakan.aim3api.base.ImageSeries;
import edu.stanford.hakan.aim3api.base.ImageStudy;
import edu.stanford.hakan.aim3api.base.Person;
import edu.stanford.hakan.aim3api.base.Polyline;
import edu.stanford.hakan.aim3api.base.Segmentation;
import edu.stanford.hakan.aim3api.base.SegmentationCollection;
import edu.stanford.hakan.aim3api.base.TwoDimensionSpatialCoordinate;
import edu.stanford.hakan.aim3api.base.User;
import edu.stanford.hakan.aim3api.usage.AnnotationBuilder;
import edu.stanford.hakan.aim3api.usage.AnnotationGetter;
import edu.stanford.isis.epad.common.dicom.DicomTagFileUtils;
import edu.stanford.isis.epad.common.util.EPADLogger;
import edu.stanford.isis.epad.common.util.EPADResources;
import edu.stanford.isis.epad.common.util.EPADTools;

public class PluginAIMUtil
{
	private static final EPADLogger log = EPADLogger.getInstance();

	public static ImageAnnotation generateDSOImageAnnotation(ImageAnnotation templateImageAnnotation,
			Map<String, String> dicomHeaders) throws AimException
	{
		String username = PluginAIMUtil.getOwnerFromImageAnnotation(templateImageAnnotation);
		Person person = PluginAIMUtil.getPersonFromImageAnnotation(templateImageAnnotation);
		String sopClassUID = dicomHeaders.get(DicomTagFileUtils.SOP_CLASS_UID);
		String dsoStudyInstanceUID = dicomHeaders.get(DicomTagFileUtils.STUDY_UID);
		String dsoSeriesInstanceUID = dicomHeaders.get(DicomTagFileUtils.SERIES_UID);
		String dsoSOPInstanceUID = dicomHeaders.get(DicomTagFileUtils.SOP_INST_UID);
		String sourceSOPInstanceUID = dicomHeaders.get(DicomTagFileUtils.REFERENCED_SOP_INSTANCE_UID);
		String sourceSeriesInstanceUID = PluginDicomUtil.getDicomSeriesUIDFromImageUID(sourceSOPInstanceUID);
		String sourceStudyInstanceUID = dsoStudyInstanceUID; // Will be same study as DSO

		// TODO Do header integrity checking here

		ImageAnnotation dsoImageAnnotation = new ImageAnnotation(0, "", "2000-10-17T10:22:40", "segmentation", "SEG",
				"SEG Only", "", "", "");

		PluginAIMUtil.setImageAnnotationUser(dsoImageAnnotation, username);

		PluginAIMUtil.addSegmentToImageAnnotation(sopClassUID, dsoSOPInstanceUID, dsoImageAnnotation);

		PluginAIMUtil.addDICOMImageReferenceToImageAnnotation(dsoStudyInstanceUID, dsoSeriesInstanceUID, dsoSOPInstanceUID,
				dsoImageAnnotation);
		PluginAIMUtil.addDICOMImageReferenceToImageAnnotation(sourceStudyInstanceUID, sourceSeriesInstanceUID,
				sourceSOPInstanceUID, dsoImageAnnotation);

		dsoImageAnnotation.addPerson(person);

		PluginAIMUtil.addPolylineToImageAnnotation(templateImageAnnotation);

		return dsoImageAnnotation;
	}

	public static ImageAnnotation getImageAnnotationFromServer(String aimID) throws AimException
	{
		String namespace = EPADTools.aim3Namespace;
		String eXistServerUrl = EPADTools.eXistURI;
		String password = EPADTools.eXistPassword;
		String eXistCollection = EPADTools.collection;
		String username = EPADTools.eXistUsername;
		String aim3XSDFilePath = EPADResources.getEPADWebServerAIM3XSDFilePath();
		String validAIMFileName = aimID.toLowerCase();

		if (validAIMFileName.endsWith(".xml") || validAIMFileName.endsWith(".aim"))
			validAIMFileName = validAIMFileName.substring(0, validAIMFileName.lastIndexOf('.'));
		if (validAIMFileName.startsWith("aim_"))
			validAIMFileName = validAIMFileName.substring(validAIMFileName.lastIndexOf('_') + 1, validAIMFileName.length());

		ImageAnnotation aim = AnnotationGetter.getImageAnnotationFromServerByUniqueIdentifier(eXistServerUrl, namespace,
				eXistCollection, username, password, validAIMFileName, aim3XSDFilePath);

		if (aim != null)
			log.info("Found AIM annotation on server with ID " + aimID);
		else
			log.warning("Could not find AIM annotation on server with ID " + aimID);

		return aim;
	}

	public static void sendImageAnnotationToServer(ImageAnnotation imageAnnotation) throws AimException
	{
		String namespace = EPADTools.aim3Namespace;
		String serverUrl = EPADTools.eXistURI;
		String password = EPADTools.eXistPassword;
		String xsdFilePath = EPADResources.getEPADWebServerAIM3XSDFilePath();
		String collection = EPADTools.collection;
		String username = EPADTools.eXistUsername;

		AnnotationBuilder.saveToServer(imageAnnotation, serverUrl, namespace, collection, xsdFilePath, username, password);

		String result = AnnotationBuilder.getAimXMLsaveResult();
		log.info("AnnotationBuilder.saveToServer result: " + result);
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

	public static void addSegmentToImageAnnotation(String sopClassUID, String dsoSOPInstanceUID,
			ImageAnnotation dsoImageAnnotation)
	{
		SegmentationCollection sc = new SegmentationCollection();
		sc.AddSegmentation(new Segmentation(0, "", sopClassUID, dsoSOPInstanceUID, 1));
		dsoImageAnnotation.setSegmentationCollection(sc);
	}

	public static void addDICOMImageReferenceToImageAnnotation(String studyInstanceUID, String seriesInstanceUID,
			String sopInstanceUID, ImageAnnotation imageAnnotation)
	{
		DICOMImageReference dicomImageReference = createDICOMImageReference(studyInstanceUID, seriesInstanceUID,
				sopInstanceUID);
		imageAnnotation.addImageReference(dicomImageReference);
	}

	public static void addPolylineToImageAnnotation(ImageAnnotation templateImageAnnotation)
	{
		Polyline polyline = new Polyline();
		polyline.setCagridId(0);
		polyline.setIncludeFlag(false);
		polyline.setShapeIdentifier(0);
		polyline.addSpatialCoordinate(new TwoDimensionSpatialCoordinate(0, 0, "0", 0, 2693.0, 1821.0));
		polyline.addSpatialCoordinate(new TwoDimensionSpatialCoordinate(0, 1, "0", 0, 3236.0, 1821.0));
		polyline.addSpatialCoordinate(new TwoDimensionSpatialCoordinate(0, 2, "0", 0, 3236.0, 2412.0));
		polyline.addSpatialCoordinate(new TwoDimensionSpatialCoordinate(0, 3, "0", 0, 2693.0, 2412.0));
		polyline.setLineStyle("lineStyle");
		templateImageAnnotation.addGeometricShape(polyline);
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
	 * Get the concurrent path if possible, otherwise get the absolute path.
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

	public static String getUIDFromAIM(String tag, String attribute, String aimFileContents)
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

}
