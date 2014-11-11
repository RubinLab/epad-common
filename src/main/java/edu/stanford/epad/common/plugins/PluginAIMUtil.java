package edu.stanford.epad.common.plugins;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.pixelmed.dicom.Attribute;
import com.pixelmed.dicom.AttributeList;
import com.pixelmed.dicom.TagFromName;

import edu.stanford.epad.common.util.EPADConfig;
import edu.stanford.epad.common.util.EPADLogger;
import edu.stanford.hakan.aim3api.base.AimException;
import edu.stanford.hakan.aim3api.base.DICOMImageReference;
import edu.stanford.hakan.aim3api.base.GeometricShape;
import edu.stanford.hakan.aim3api.base.GeometricShapeCollection;
import edu.stanford.hakan.aim3api.base.ImageAnnotation;
import edu.stanford.hakan.aim3api.base.ImageSeries;
import edu.stanford.hakan.aim3api.base.ImageStudy;
import edu.stanford.hakan.aim3api.base.Person;
import edu.stanford.hakan.aim3api.base.Segmentation;
import edu.stanford.hakan.aim3api.base.SegmentationCollection;
import edu.stanford.hakan.aim3api.base.SpatialCoordinate;
import edu.stanford.hakan.aim3api.base.TwoDimensionSpatialCoordinate;
import edu.stanford.hakan.aim3api.usage.AnnotationBuilder;
import edu.stanford.hakan.aim3api.usage.AnnotationExtender;
import edu.stanford.hakan.aim3api.usage.AnnotationGetter;

public class PluginAIMUtil
{
	private static final EPADLogger log = EPADLogger.getInstance();

	private static final String aim3Namespace = EPADConfig.aim3Namespace;
	private static final String eXistServerUrl = EPADConfig.eXistURI;
	private static final String eXistPassword = EPADConfig.eXistPassword;
	private static final String eXistCollection = EPADConfig.eXistCollection;
	private static final String eXistUsername = EPADConfig.eXistUsername;
	private static final String aim3XSDFilePath = EPADConfig.getEPADWebServerAIM3XSDFilePath();
	private static final String eXistURI = EPADConfig.eXistURI;

	public static ImageAnnotation getImageAnnotationFromServer(String aimID) throws AimException
	{
		String validAIMFileName = aimID.toLowerCase();

		if (validAIMFileName.endsWith(".xml") || validAIMFileName.endsWith(".aim"))
			validAIMFileName = validAIMFileName.substring(0, validAIMFileName.lastIndexOf('.'));
		if (validAIMFileName.startsWith("aim_"))
			validAIMFileName = validAIMFileName.substring(validAIMFileName.lastIndexOf('_') + 1, validAIMFileName.length());

		ImageAnnotation aim = AnnotationGetter.getImageAnnotationFromServerByUniqueIdentifier(eXistServerUrl,
				aim3Namespace, eXistCollection, eXistUsername, eXistPassword, validAIMFileName, aim3XSDFilePath);

		if (aim == null)
			log.warning("Could not find AIM annotation on server with ID " + aimID);

		return aim;
	}

	public static void sendImageAnnotationToServer(ImageAnnotation imageAnnotation) throws AimException
	{
		AnnotationBuilder.saveToServer(imageAnnotation, eXistURI, aim3Namespace, eXistCollection, aim3XSDFilePath,
				eXistUsername, eXistPassword);

		String result = AnnotationBuilder.getAimXMLsaveResult();

		log.info("AIM file with ID " + imageAnnotation.getUniqueIdentifier() + " saved to server; result: " + result);
	}

	/**
	 * Currently called by plugins after generating DSO.
	 * <p>
	 * Also see {@link AIMUtil#generateAIMFileForDSO} for DSO AIM generation when not invoked from plugin.
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

		addSegmentToImageAnnotation(sopClassUID, dsoImageUID, sourceImageUID, templateImageAnnotation);
		addDICOMImageReferenceToImageAnnotation(dsoStudyUID, dsoSeriesUID, dsoImageUID, templateImageAnnotation);

		return templateImageAnnotation;
	}

	public static void saveAnnotationToAnnotationsDirectory(ImageAnnotation imageAnnotation) throws AimException
	{
		AnnotationBuilder.saveToFile(imageAnnotation,
				EPADConfig.getEPADWebServerAnnotationsDir() + imageAnnotation.getUniqueIdentifier() + ".xml",
				EPADConfig.getEPADWebServerAIM3XSDFilePath());
	}

	public static ImageAnnotation getImageAnnotationFromFile(File file) throws AimException
	{
		return AnnotationGetter.getImageAnnotationFromFile(getRealPath(file));
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

	public static class ROIData
	{
		public final double[] xData;
		public final double[] yData;

		public ROIData(double[] xData, double yData[])
		{
			this.xData = xData;
			this.yData = yData;
		}
	}

	public static ImageAnnotation addFeature(ImageAnnotation imageAnnotation, double[] featureValue,
			String[] featureString, double featureVersion) throws AimException
	{
		return AnnotationExtender.addFeature(imageAnnotation, featureValue, featureString, featureVersion);
	}

	public static List<String> getPersonNames(ImageAnnotation imageAnnotation)
	{
		List<String> personNames = new ArrayList<>();
		List<Person> persons = imageAnnotation.getListPerson();

		for (Person person : persons)
			personNames.add(person.getName());

		return personNames;
	}

	public static ROIData extractROIData(ImageAnnotation imageAnnotation)
	{
		int numROI;
		double[] roixData = null;
		double[] roiyData = null;

		GeometricShapeCollection geometricShapeCollection = imageAnnotation.getGeometricShapeCollection();
		GeometricShape geometricShape = null;
		for (int i = 0; i < geometricShapeCollection.getGeometricShapeList().size(); i++) {
			geometricShape = geometricShapeCollection.getGeometricShapeList().get(i);
			if (geometricShape.getXsiType().equals("Polyline")) {
				numROI = geometricShape.getSpatialCoordinateCollection().getSpatialCoordinateList().size();
				roixData = new double[numROI];
				roiyData = new double[numROI];
				for (int j = 0; j < numROI; j++) {
					SpatialCoordinate spatialCoordinate = geometricShape.getSpatialCoordinateCollection()
							.getSpatialCoordinateList().get(j);
					if ("TwoDimensionSpatialCoordinate".equals(spatialCoordinate.getXsiType())) {
						TwoDimensionSpatialCoordinate twoDimensionSpatialCoordinate = (TwoDimensionSpatialCoordinate)spatialCoordinate;
						int idx = twoDimensionSpatialCoordinate.getCoordinateIndex();
						roixData[idx] = twoDimensionSpatialCoordinate.getX();
						roiyData[idx] = twoDimensionSpatialCoordinate.getY();
					}
				}
			}
		}
		return new ROIData(roixData, roiyData);
	}

	public static List<Double> extractPoints (ImageAnnotation templateImageAnnotation) {
		List<Double> points = new ArrayList<Double>();
		double[] roixData = null;
		double[] roiyData = null;

		GeometricShapeCollection geometricShapeCollection = templateImageAnnotation.getGeometricShapeCollection();
		for (int i = 0; i < geometricShapeCollection.getGeometricShapeList().size(); i++) {
			GeometricShape geometricShape = geometricShapeCollection.getGeometricShapeList().get(i);
			if (geometricShape.getXsiType().equals("MultiPoint")) {
				int numberOfROIs = geometricShape.getSpatialCoordinateCollection().getSpatialCoordinateList().size();
				roixData = new double[numberOfROIs];
				roiyData = new double[numberOfROIs];
				for (int j = 0; j < numberOfROIs; j++) {
					SpatialCoordinate spatialCoordinate = geometricShape.getSpatialCoordinateCollection()
							.getSpatialCoordinateList().get(j);
					if ("TwoDimensionSpatialCoordinate".equals(spatialCoordinate.getXsiType())) {
						TwoDimensionSpatialCoordinate twoDimensionSpatialCoordinate = (TwoDimensionSpatialCoordinate)spatialCoordinate;
						int idx = twoDimensionSpatialCoordinate.getCoordinateIndex();
						roixData[idx] = twoDimensionSpatialCoordinate.getX();
						roiyData[idx] = twoDimensionSpatialCoordinate.getY();
						
						points.add(roixData[idx]);
						points.add(roiyData[idx]);
					}
				}
			}
		}
		
		return points;
	}

	public static double[] extractCoordinateFromAIMFile(File aimFile, int positionOfImageInSeries) throws Exception
	{
		double[] roixData = null;
		double[] roiyData = null;

		try { // Fill in roixData, roiyData
			ImageAnnotation fileImageAnnotation = AnnotationGetter.getImageAnnotationFromFile(PluginAIMUtil
					.getRealPath(aimFile));
			List<Person> listPerson = fileImageAnnotation.getListPerson();
			if (listPerson.size() > 0) {
				listPerson.get(0);
			}

			GeometricShapeCollection geometricShapeCollection = fileImageAnnotation.getGeometricShapeCollection();
			for (int i = 0; i < geometricShapeCollection.getGeometricShapeList().size(); i++) {
				GeometricShape geometricShape = geometricShapeCollection.getGeometricShapeList().get(i);
				if (geometricShape.getXsiType().equals("MultiPoint")) {
					int numberOfROIs = geometricShape.getSpatialCoordinateCollection().getSpatialCoordinateList().size();
					roixData = new double[numberOfROIs];
					roiyData = new double[numberOfROIs];
					for (int j = 0; j < numberOfROIs; j++) {
						SpatialCoordinate spatialCoordinate = geometricShape.getSpatialCoordinateCollection()
								.getSpatialCoordinateList().get(j);
						if ("TwoDimensionSpatialCoordinate".equals(spatialCoordinate.getXsiType())) {
							TwoDimensionSpatialCoordinate twoDimensionSpatialCoordinate = (TwoDimensionSpatialCoordinate)spatialCoordinate;
							int idx = twoDimensionSpatialCoordinate.getCoordinateIndex();
							roixData[idx] = twoDimensionSpatialCoordinate.getX();
							roiyData[idx] = twoDimensionSpatialCoordinate.getY();
						}
					}
				}
			}
		} catch (Throwable t) {
			log.warning("tedseg: Plugin failed to get ROI or person in AIM file", t);
			throw new Exception("tedseg: Plugin failed to get ROI or person in AIM file", t);
		}

		if (roixData == null && roiyData == null) {
			log.warning("tedseg: Plugin failed to get ROI in AIM file");
			throw new Exception("tedseg: Plugin failed to get ROI in AIM file");
		}

		int x_pos = (int)(((roixData[roixData.length - 1] + roixData[0]) / 2.0)); // Compute the median point
		int y_pos = (int)(((roiyData[roiyData.length - 1] + roiyData[0]) / 2.0));
		int z_pos = positionOfImageInSeries;
		double[] point = new double[3]; // log.info("Seed (x,y,z) = (" + x_pos + "," + y_pos + "," + z_pos + ")");
		point[0] = y_pos;
		point[1] = x_pos;
		point[2] = z_pos;

		return point;
	}

	/**
	 * Get the canonical path if possible, otherwise get the absolute path.
	 * 
	 * @param file File
	 * @return String path of file. Concurrent path if possible.
	 */
	private static String getRealPath(File file)
	{
		try {
			return file.getCanonicalPath();
		} catch (IOException ioe) {
			return file.getAbsolutePath();
		}
	}

	public static void addSegmentToImageAnnotation(String sopClassUID, String dsoSOPInstanceUID, String sourceImageUID,
			ImageAnnotation dsoImageAnnotation)
	{
		SegmentationCollection sc = new SegmentationCollection();
		sc.AddSegmentation(new Segmentation(0, sourceImageUID, sopClassUID, dsoSOPInstanceUID, 1));
		dsoImageAnnotation.setSegmentationCollection(sc);
	}

	private static void addDICOMImageReferenceToImageAnnotation(String studyInstanceUID, String seriesInstanceUID,
			String sopInstanceUID, ImageAnnotation imageAnnotation)
	{
		DICOMImageReference dicomImageReference = createDICOMImageReference(studyInstanceUID, seriesInstanceUID,
				sopInstanceUID);
		imageAnnotation.addImageReference(dicomImageReference);
	}

	private static String getOwnerFromImageAnnotation(ImageAnnotation aim) throws AimException
	{
		if (aim.getListUser() != null) {
			if (!aim.getListUser().isEmpty())
				return aim.getListUser().get(0).getLoginName();
		}
		throw new AimException("No User in image annotation");
	}
}
