/*******************************************************************************
 * Copyright (c) 2015 The Board of Trustees of the Leland Stanford Junior University
 * BY CLICKING ON "ACCEPT," DOWNLOADING, OR OTHERWISE USING EPAD, YOU AGREE TO THE FOLLOWING TERMS AND CONDITIONS:
 * STANFORD ACADEMIC SOFTWARE SOURCE CODE LICENSE FOR
 * "ePAD Annotation Platform for Radiology Images"
 *
 * This Agreement covers contributions to and downloads from the ePAD project ("ePAD") maintained by The Board of Trustees 
 * of the Leland Stanford Junior University ("Stanford"). 
 *
 * *	Part A applies to downloads of ePAD source code and/or data from ePAD. 
 *
 * *	Part B applies to contributions of software and/or data to ePAD (including making revisions of or additions to code 
 * and/or data already in ePAD), which may include source or object code. 
 *
 * Your download, copying, modifying, displaying, distributing or use of any ePAD software and/or data from ePAD 
 * (collectively, the "Software") is subject to Part A. Your contribution of software and/or data to ePAD (including any 
 * that occurred prior to the first publication of this Agreement) is a "Contribution" subject to Part B. Both Parts A and 
 * B shall be governed by and construed in accordance with the laws of the State of California without regard to principles 
 * of conflicts of law. Any legal action involving this Agreement or the Research Program will be adjudicated in the State 
 * of California. This Agreement shall supersede and replace any license terms that you may have agreed to previously with 
 * respect to ePAD.
 *
 * PART A. DOWNLOADING AGREEMENT - LICENSE FROM STANFORD WITH RIGHT TO SUBLICENSE ("SOFTWARE LICENSE").
 * 1. As used in this Software License, "you" means the individual downloading and/or using, reproducing, modifying, 
 * displaying and/or distributing Software and the institution or entity which employs or is otherwise affiliated with you. 
 * Stanford  hereby grants you, with right to sublicense, with respect to Stanford's rights in the Software, a 
 * royalty-free, non-exclusive license to use, reproduce, make derivative works of, display and distribute the Software, 
 * provided that: (a) you adhere to all of the terms and conditions of this Software License; (b) in connection with any 
 * copy, distribution of, or sublicense of all or any portion of the Software, the terms and conditions in this Software 
 * License shall appear in and shall apply to such copy and such sublicense, including without limitation all source and 
 * executable forms and on any user documentation, prefaced with the following words: "All or portions of this licensed 
 * product  have been obtained under license from The Board of Trustees of the Leland Stanford Junior University. and are 
 * subject to the following terms and conditions" AND any user interface to the Software or the "About" information display 
 * in the Software will display the following: "Powered by ePAD http://epad.stanford.edu;" (c) you preserve and maintain 
 * all applicable attributions, copyright notices and licenses included in or applicable to the Software; (d) modified 
 * versions of the Software must be clearly identified and marked as such, and must not be misrepresented as being the 
 * original Software; and (e) you consider making, but are under no obligation to make, the source code of any of your 
 * modifications to the Software freely available to others on an open source basis.
 *
 * 2. The license granted in this Software License includes without limitation the right to (i) incorporate the Software 
 * into your proprietary programs (subject to any restrictions applicable to such programs), (ii) add your own copyright 
 * statement to your modifications of the Software, and (iii) provide additional or different license terms and conditions 
 * in your sublicenses of modifications of the Software; provided that in each case your use, reproduction or distribution 
 * of such modifications otherwise complies with the conditions stated in this Software License.
 * 3. This Software License does not grant any rights with respect to third party software, except those rights that 
 * Stanford has been authorized by a third party to grant to you, and accordingly you are solely responsible for (i) 
 * obtaining any permissions from third parties that you need to use, reproduce, make derivative works of, display and 
 * distribute the Software, and (ii) informing your sublicensees, including without limitation your end-users, of their 
 * obligations to secure any such required permissions.
 * 4. You agree that you will use the Software in compliance with all applicable laws, policies and regulations including, 
 * but not limited to, those applicable to Personal Health Information ("PHI") and subject to the Institutional Review 
 * Board requirements of the your institution, if applicable. Licensee acknowledges and agrees that the Software is not 
 * FDA-approved, is intended only for research, and may not be used for clinical treatment purposes. Any commercialization 
 * of the Software is at the sole risk of you and the party or parties engaged in such commercialization. You further agree 
 * to use, reproduce, make derivative works of, display and distribute the Software in compliance with all applicable 
 * governmental laws, regulations and orders, including without limitation those relating to export and import control.
 * 5. You or your institution, as applicable, will indemnify, hold harmless, and defend Stanford against any third party 
 * claim of any kind made against Stanford arising out of or related to the exercise of any rights granted under this 
 * Agreement, the provision of Software, or the breach of this Agreement. Stanford provides the Software AS IS and WITH ALL 
 * FAULTS.  Stanford makes no representations and extends no warranties of any kind, either express or implied.  Among 
 * other things, Stanford disclaims any express or implied warranty in the Software:
 * (a)  of merchantability, of fitness for a particular purpose,
 * (b)  of non-infringement or 
 * (c)  arising out of any course of dealing.
 *
 * Title and copyright to the Program and any associated documentation shall at all times remain with Stanford, and 
 * Licensee agrees to preserve same. Stanford reserves the right to license the Program at any time for a fee.
 * 6. None of the names, logos or trademarks of Stanford or any of Stanford's affiliates or any of the Contributors, or any 
 * funding agency, may be used to endorse or promote products produced in whole or in part by operation of the Software or 
 * derived from or based on the Software without specific prior written permission from the applicable party.
 * 7. Any use, reproduction or distribution of the Software which is not in accordance with this Software License shall 
 * automatically revoke all rights granted to you under this Software License and render Paragraphs 1 and 2 of this 
 * Software License null and void.
 * 8. This Software License does not grant any rights in or to any intellectual property owned by Stanford or any 
 * Contributor except those rights expressly granted hereunder.
 *
 * PART B. CONTRIBUTION AGREEMENT - LICENSE TO STANFORD WITH RIGHT TO SUBLICENSE ("CONTRIBUTION AGREEMENT").
 * 1. As used in this Contribution Agreement, "you" means an individual providing a Contribution to ePAD and the 
 * institution or entity which employs or is otherwise affiliated with you.
 * 2. This Contribution Agreement applies to all Contributions made to ePAD at any time. By making a Contribution you 
 * represent that: (i) you are legally authorized and entitled by ownership or license to make such Contribution and to 
 * grant all licenses granted in this Contribution Agreement with respect to such Contribution; (ii) if your Contribution 
 * includes any patient data, all such data is de-identified in accordance with U.S. confidentiality and security laws and 
 * requirements, including but not limited to the Health Insurance Portability and Accountability Act (HIPAA) and its 
 * regulations, and your disclosure of such data for the purposes contemplated by this Agreement is properly authorized and 
 * in compliance with all applicable laws and regulations; and (iii) you have preserved in the Contribution all applicable 
 * attributions, copyright notices and licenses for any third party software or data included in the Contribution.
 * 3. Except for the licenses you grant in this Agreement, you reserve all right, title and interest in your Contribution.
 * 4. You hereby grant to Stanford, with the right to sublicense, a perpetual, worldwide, non-exclusive, no charge, 
 * royalty-free, irrevocable license to use, reproduce, make derivative works of, display and distribute the Contribution. 
 * If your Contribution is protected by patent, you hereby grant to Stanford, with the right to sublicense, a perpetual, 
 * worldwide, non-exclusive, no-charge, royalty-free, irrevocable license under your interest in patent rights embodied in 
 * the Contribution, to make, have made, use, sell and otherwise transfer your Contribution, alone or in combination with 
 * ePAD or otherwise.
 * 5. You acknowledge and agree that Stanford ham may incorporate your Contribution into ePAD and may make your 
 * Contribution as incorporated available to members of the public on an open source basis under terms substantially in 
 * accordance with the Software License set forth in Part A of this Agreement. You further acknowledge and agree that 
 * Stanford shall have no liability arising in connection with claims resulting from your breach of any of the terms of 
 * this Agreement.
 * 6. YOU WARRANT THAT TO THE BEST OF YOUR KNOWLEDGE YOUR CONTRIBUTION DOES NOT CONTAIN ANY CODE OBTAINED BY YOU UNDER AN 
 * OPEN SOURCE LICENSE THAT REQUIRES OR PRESCRIBES DISTRBUTION OF DERIVATIVE WORKS UNDER SUCH OPEN SOURCE LICENSE. (By way 
 * of non-limiting example, you will not contribute any code obtained by you under the GNU General Public License or other 
 * so-called "reciprocal" license.)
 *******************************************************************************/
package edu.stanford.epad.common.plugins;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pixelmed.dicom.Attribute;
import com.pixelmed.dicom.AttributeList;
import com.pixelmed.dicom.TagFromName;

import edu.stanford.epad.common.util.EPADConfig;
import edu.stanford.epad.common.util.EPADLogger;
import edu.stanford.hakan.aim4api.base.AimException;
import edu.stanford.hakan.aim4api.base.CD;
import edu.stanford.hakan.aim4api.base.ImageAnnotationCollection;
import edu.stanford.hakan.aim4api.base.Person;
import edu.stanford.hakan.aim4api.compability.aimv3.GeometricShape;
import edu.stanford.hakan.aim4api.compability.aimv3.GeometricShapeCollection;
import edu.stanford.hakan.aim4api.compability.aimv3.ImageAnnotation;
import edu.stanford.hakan.aim4api.compability.aimv3.Segmentation;
import edu.stanford.hakan.aim4api.compability.aimv3.SegmentationCollection;
import edu.stanford.hakan.aim4api.compability.aimv3.SpatialCoordinate;
import edu.stanford.hakan.aim4api.compability.aimv3.TwoDimensionSpatialCoordinate;
import edu.stanford.hakan.aim4api.usage.AnnotationBuilder;
import edu.stanford.hakan.aim4api.usage.AnnotationExtender;
//import edu.stanford.hakan.aim4api.compability.aimv3.Lexicon;
import edu.stanford.epad.common.util.Lexicon;



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
	private static final String aim4Namespace = EPADConfig.aim4Namespace;
	private static final String eXistCollectionV4 = EPADConfig.eXistCollectionV4;
	private static final String xsdFileV4 = EPADConfig.xsdFileV4;
	private static final String xsdFilePathV4 = EPADConfig.xsdFilePathV4;

	public static ImageAnnotationCollection getImageAnnotationCollectionFromServer(String aimID, String projectID) throws edu.stanford.hakan.aim4api.base.AimException
	{
	    String collection4Name = eXistCollectionV4;
	    if (projectID != null && projectID.length() > 0)
	    	collection4Name = collection4Name + "/" + projectID;
		ImageAnnotationCollection aim = edu.stanford.hakan.aim4api.usage.AnnotationGetter
				.getImageAnnotationCollectionByUniqueIdentifier(eXistServerUrl, aim4Namespace, collection4Name,
						eXistUsername, eXistPassword, aimID);
		return aim;
	}
	
	
	public static void sendImageAnnotationToServer(ImageAnnotationCollection imageAnnotation, String projectID, String oldAimID) throws edu.stanford.hakan.aim4api.base.AimException
	{
	    String collectionName = eXistCollectionV4;
	    if (projectID != null && projectID.length() > 0)
	    	collectionName = collectionName + "/" + projectID;
		edu.stanford.hakan.aim4api.usage.AnnotationBuilder.saveToServer(imageAnnotation, eXistServerUrl, aim4Namespace,
				collectionName, xsdFilePathV4, eXistUsername, eXistPassword);

		String result = AnnotationBuilder.getAimXMLsaveResult();
		try {
			cloneAIMXmlInDatabase(imageAnnotation.getUniqueIdentifier().getRoot(),imageAnnotation.getImageAnnotation().getName().getValue(),
					edu.stanford.hakan.aim4api.usage.AnnotationBuilder.convertToString(imageAnnotation), oldAimID);
		} catch (Exception e) {
			throw new edu.stanford.hakan.aim4api.base.AimException(e.getMessage());
		}

		log.info("AIM file with ID " + imageAnnotation.getUniqueIdentifier() + " saved to server; result: " + result);
	}
	
	public static void sendImageAnnotationToServer(ImageAnnotationCollection imageAnnotation, String projectID) throws edu.stanford.hakan.aim4api.base.AimException
	{
	    String collectionName = eXistCollectionV4;
	    if (projectID != null && projectID.length() > 0)
	    	collectionName = collectionName + "/" + projectID;
		edu.stanford.hakan.aim4api.usage.AnnotationBuilder.saveToServer(imageAnnotation, eXistServerUrl, aim4Namespace,
				collectionName, xsdFilePathV4, eXistUsername, eXistPassword);

		String result = AnnotationBuilder.getAimXMLsaveResult();
		try {
			updateAIMXmlInDatabase(imageAnnotation.getUniqueIdentifier().getRoot(),
					edu.stanford.hakan.aim4api.usage.AnnotationBuilder.convertToString(imageAnnotation));
		} catch (Exception e) {
			throw new edu.stanford.hakan.aim4api.base.AimException(e.getMessage());
		}

		log.info("AIM file with ID " + imageAnnotation.getUniqueIdentifier() + " saved to server; result: " + result);
	}
	
	public static ImageAnnotationCollection generateAIMFileForDSO(ImageAnnotationCollection imageAnnotationCollection,
			AttributeList dsoDICOMAttributes, String sourceStudyUID, String sourceSeriesUID, String sourceImageUID, String username)
			throws Exception
	{
            edu.stanford.hakan.aim4api.compability.aimv3.ImageAnnotation imageAnnotation = new edu.stanford.hakan.aim4api.compability.aimv3.ImageAnnotation(imageAnnotationCollection);
		String patientID = Attribute.getSingleStringValueOrEmptyString(dsoDICOMAttributes, TagFromName.PatientID);
		String patientName = Attribute.getSingleStringValueOrEmptyString(dsoDICOMAttributes, TagFromName.PatientName);
		String patientBirthDay = Attribute.getSingleStringValueOrEmptyString(dsoDICOMAttributes, TagFromName.PatientBirthDate);
		if (patientBirthDay.trim().length() != 8) patientBirthDay = "19650212";
		String patientSex = Attribute.getSingleStringValueOrEmptyString(dsoDICOMAttributes, TagFromName.PatientSex);
		if (patientSex.trim().length() != 1) patientSex = "F";
		String dsoDate = Attribute.getSingleStringValueOrEmptyString(dsoDICOMAttributes, TagFromName.SeriesDate);
		if (dsoDate.trim().length() != 8) dsoDate = "20001017";
		String sopClassUID = Attribute.getSingleStringValueOrEmptyString(dsoDICOMAttributes, TagFromName.SOPClassUID);
		String studyUID = Attribute.getSingleStringValueOrEmptyString(dsoDICOMAttributes, TagFromName.StudyInstanceUID);
		String seriesUID = Attribute.getSingleStringValueOrEmptyString(dsoDICOMAttributes, TagFromName.SeriesInstanceUID);
		String imageUID = Attribute.getSingleStringValueOrEmptyString(dsoDICOMAttributes, TagFromName.SOPInstanceUID);
		String description = Attribute.getSingleStringValueOrEmptyString(dsoDICOMAttributes, TagFromName.SeriesDescription);

		log.info("Generating AIM file for DSO series " + seriesUID + " for patient " + patientName);
		log.info("SOP Class UID=" + sopClassUID);
		log.info("DSO Study UID=" + studyUID);
		log.info("DSO Series UID=" + seriesUID);
		log.info("DSO Image UID=" + imageUID);
		log.info("Referenced SOP Instance UID=" + sourceImageUID);
		log.info("Referenced Series Instance UID=" + sourceSeriesUID);

		String name = description;
		if (name == null || name.trim().length() == 0) name = "segmentation";

		// Hakan needs to give equivalent code for AIM4
                edu.stanford.hakan.aim4api.compability.aimv3.SegmentationCollection sc = new edu.stanford.hakan.aim4api.compability.aimv3.SegmentationCollection();
		sc.AddSegmentation(new edu.stanford.hakan.aim4api.compability.aimv3.Segmentation(0, imageUID, sopClassUID, sourceImageUID, 1));
		
		imageAnnotation.setSegmentationCollection(sc);

		//ml remove adding the second image ref
//		edu.stanford.hakan.aim4api.compability.aimv3.DICOMImageReference dicomImageReference = createDICOMImageReferenceV3Compability(studyUID, seriesUID,
//				imageUID);
//		imageAnnotation.addImageReference(dicomImageReference);

		
		updateDSOAIMInDatabase(imageAnnotation.getUniqueIdentifier(), seriesUID);
		return imageAnnotation.toAimV4();
	}

	public static void saveAnnotationToAnnotationsDirectory(ImageAnnotationCollection imageAnnotation) throws edu.stanford.hakan.aim4api.base.AimException
	{
		edu.stanford.hakan.aim4api.usage.AnnotationBuilder.saveToFile(imageAnnotation,
				EPADConfig.getEPADWebServerAnnotationsDir() + imageAnnotation.getUniqueIdentifier().getRoot() + ".xml",
				xsdFilePathV4);
	}

	public static ImageAnnotationCollection getImageAnnotationV4FromFile(File file) throws edu.stanford.hakan.aim4api.base.AimException
	{
		return edu.stanford.hakan.aim4api.usage.AnnotationGetter.getImageAnnotationCollectionFromFile(getRealPath(file), xsdFilePathV4);
	}
        

        //ml added sopclassuid from image		 +        
	 public static edu.stanford.hakan.aim4api.compability.aimv3.DICOMImageReference createDICOMImageReferenceV3Compability(String dsoStudyInstanceUID, String dsoSeriesInstanceUID,		
				String dsoSOPInstanceUID, String sopClassUID) 		
	 	{		
	 		edu.stanford.hakan.aim4api.compability.aimv3.DICOMImageReference dicomImageReference = new edu.stanford.hakan.aim4api.compability.aimv3.DICOMImageReference();		
	 		dicomImageReference.setCagridId(0);		
	 		
	 		edu.stanford.hakan.aim4api.compability.aimv3.ImageStudy imageStudy = new edu.stanford.hakan.aim4api.compability.aimv3.ImageStudy();		
	 		imageStudy.setCagridId(0);		
	 		imageStudy.setInstanceUID(dsoStudyInstanceUID);		
	 		imageStudy.setStartDate("2012-01-01T01:01:01"); // TODO		
	 		imageStudy.setStartTime("12:00:00"); // TODO		
	 		
	 		edu.stanford.hakan.aim4api.compability.aimv3.ImageSeries imageSeries = new edu.stanford.hakan.aim4api.compability.aimv3.ImageSeries();		
	 		imageSeries.setCagridId(0);		
	 		imageSeries.setInstanceUID(dsoSeriesInstanceUID);		
	 		
	 		edu.stanford.hakan.aim4api.compability.aimv3.Image image = new edu.stanford.hakan.aim4api.compability.aimv3.Image();		
	 		image.setCagridId(0);		
	 		log.info("written SOP Class UID=" + sopClassUID);		
	 		log.info("written SOP Instance UID=" + dsoSOPInstanceUID);		
	 					
	 		image.setSopClassUID(sopClassUID); // TODO ml retrieved from parameter		
	 		image.setSopInstanceUID(dsoSOPInstanceUID);		
	 		
	 		imageSeries.addImage(image); // Add Image to ImageSeries		
	 		imageStudy.setImageSeries(imageSeries); // Add ImageSeries to ImageStudy		
	 		dicomImageReference.setImageStudy(imageStudy); // Add ImageStudy to ImageReference		
	 		
	 		return dicomImageReference;		
	 	}    
	

	public static edu.stanford.hakan.aim4api.compability.aimv3.DICOMImageReference createDICOMImageReferenceV3Compability(String dsoStudyInstanceUID, String dsoSeriesInstanceUID,
			String dsoSOPInstanceUID)
	{
		edu.stanford.hakan.aim4api.compability.aimv3.DICOMImageReference dicomImageReference = new edu.stanford.hakan.aim4api.compability.aimv3.DICOMImageReference();
		dicomImageReference.setCagridId(0);

		edu.stanford.hakan.aim4api.compability.aimv3.ImageStudy imageStudy = new edu.stanford.hakan.aim4api.compability.aimv3.ImageStudy();
		imageStudy.setCagridId(0);
		imageStudy.setInstanceUID(dsoStudyInstanceUID);
		imageStudy.setStartDate("2012-01-01T01:01:01"); // TODO
		imageStudy.setStartTime("12:00:00"); // TODO

		edu.stanford.hakan.aim4api.compability.aimv3.ImageSeries imageSeries = new edu.stanford.hakan.aim4api.compability.aimv3.ImageSeries();
		imageSeries.setCagridId(0);
		imageSeries.setInstanceUID(dsoSeriesInstanceUID);

		edu.stanford.hakan.aim4api.compability.aimv3.Image image = new edu.stanford.hakan.aim4api.compability.aimv3.Image();
		image.setCagridId(0);

		image.setSopClassUID("NA"); // TODO
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
	//old version
	public static ImageAnnotationCollection addFeature(ImageAnnotationCollection imageAnnotationCollection, double[] featureValue,
			String[] featureString, double featureVersion, CD calcCD) throws edu.stanford.hakan.aim4api.base.AimException 
	{
		return edu.stanford.hakan.aim4api.usage.AnnotationExtender.addFeature(imageAnnotationCollection, featureValue, featureString, featureVersion, calcCD);
	
	}
	//old version
	public static ImageAnnotationCollection addFeature(ImageAnnotationCollection imageAnnotationCollection, double[] featureValue,
			String[] featureString, double featureVersion) throws edu.stanford.hakan.aim4api.base.AimException 
	{
		return edu.stanford.hakan.aim4api.usage.AnnotationExtender.addFeature(imageAnnotationCollection, featureValue, featureString, featureVersion);
	}
	
	public static String[] parseFeature(String feature) {
		String cd="";
		String label="";
		//remove all the numbers and items in paranthesis at the end
		cd=feature.replaceAll("\\(.*\\)$", "").trim();
		cd=cd.replaceAll("([0-9]*)$", "").trim();
		cd=cd.replaceAll("\\-*$", "").trim();
		
		label = feature;
		return new String[]{cd,label};
	}
	
	//new version. uses lexicon and adds as seperate calculation entities
	public static ImageAnnotationCollection addFeatures(ImageAnnotationCollection imageAnnotationCollection, ArrayList<String[]> features, double featureVersion, CD calcCD) throws edu.stanford.hakan.aim4api.base.AimException 
	{
		
		 for (int i = 0; i < features.size(); i++) {
	            if (features.get(i).length != 2) {
	            	log.info("Not a feature pair, what is it?");
	                continue;
	            }  
	            //parse the feature to cd value and label
	            String[] parsedFeature = parseFeature(features.get(i)[0]);
	            
	            CD featureCD = Lexicon.getInstance().getLex(parsedFeature[0]);
	           
	            try {
	            	imageAnnotationCollection = edu.stanford.hakan.aim4api.usage.AnnotationExtender.addFeature(imageAnnotationCollection, Double.parseDouble(features.get(i)[1]), featureCD, featureVersion, calcCD, parsedFeature[1]);
	            }catch (NumberFormatException ne) {
	            	log.info("Could not parse the feature value to a double. feature name:"+features.get(i)[0]+" value:"+ features.get(i)[1]);
	            }
	     }
		 return imageAnnotationCollection;
	}
	
	//new version. uses lexicon and adds as seperate calculation entities
	public static ImageAnnotationCollection addFeatures(ImageAnnotationCollection imageAnnotationCollection, double[] featureValue,
			String[] featureString, double featureVersion, CD calcCD) throws edu.stanford.hakan.aim4api.base.AimException 
	{
		
		if (featureValue.length != featureString.length) {
            throw new AimException("AimException: lenght of featureValue and featureString must be equal");
        }

		 for (int i = 0; i < featureValue.length; i++) {
	            if (featureString[i] == null) {
	                continue;
	            }  
	          //parse the feature to cd value and label
	            String[] parsedFeature = parseFeature(featureString[i]);
	            
	            CD featureCD = Lexicon.getInstance().getLex(parsedFeature[0]);
	           
	           imageAnnotationCollection = edu.stanford.hakan.aim4api.usage.AnnotationExtender.addFeature(imageAnnotationCollection, featureValue[i], featureCD, featureVersion, calcCD, parsedFeature[1]);
		}
		 return imageAnnotationCollection;
	}
	
    //new version. uses lexicon and adds as seperate calculation entities
//	public static ImageAnnotationCollection addFeatures(ImageAnnotationCollection imageAnnotationCollection, double[] featureValue,
//			String[] featureString, double featureVersion) throws edu.stanford.hakan.aim4api.base.AimException 
//	{
//		return edu.stanford.hakan.aim4api.usage.AnnotationExtender.addFeature(imageAnnotationCollection, featureValue, featureString, featureVersion);
//	}
	
	public static String getPersonName(ImageAnnotationCollection imageAnnotationCollection)
	{
		edu.stanford.hakan.aim4api.base.Person person = imageAnnotationCollection.getPerson();
		
		if (person == null)
			return null;
		
		return person.getName().getValue();
	}

	public static ROIData extractROIData(edu.stanford.hakan.aim4api.compability.aimv3.ImageAnnotation imageAnnotation)
	{
		int numROI;
		double[] roixData = null;
		double[] roiyData = null;

		edu.stanford.hakan.aim4api.compability.aimv3.GeometricShapeCollection geometricShapeCollection = imageAnnotation.getGeometricShapeCollection();
		edu.stanford.hakan.aim4api.compability.aimv3.GeometricShape geometricShape = null;
		for (int i = 0; i < geometricShapeCollection.getGeometricShapeList().size(); i++) {
			geometricShape = geometricShapeCollection.getGeometricShapeList().get(i);
			if (geometricShape.getXsiType().equals("Polyline")) {
				numROI = geometricShape.getSpatialCoordinateCollection().getSpatialCoordinateList().size();
				roixData = new double[numROI];
				roiyData = new double[numROI];
				for (int j = 0; j < numROI; j++) {
					edu.stanford.hakan.aim4api.compability.aimv3.SpatialCoordinate spatialCoordinate = geometricShape.getSpatialCoordinateCollection()
																										.getSpatialCoordinateList().get(j);
					if ("TwoDimensionSpatialCoordinate".equals(spatialCoordinate.getXsiType())) {
						edu.stanford.hakan.aim4api.compability.aimv3.TwoDimensionSpatialCoordinate twoDimensionSpatialCoordinate = 
								(edu.stanford.hakan.aim4api.compability.aimv3.TwoDimensionSpatialCoordinate)spatialCoordinate;
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

	public static double[] extractCoordinateFromAIMFile(ImageAnnotationCollection fileImageAnnotationCollection, int positionOfImageInSeries) throws Exception
	{
		double[] roixData = null;
		double[] roiyData = null;

		try { // Fill in roixData, roiyData
//			ImageAnnotationCollection fileImageAnnotationCollection = edu.stanford.hakan.aim4api.usage.AnnotationGetter.getImageAnnotationCollectionFromFile(PluginAIMUtil.getRealPath(aimFile));
			edu.stanford.hakan.aim4api.compability.aimv3.ImageAnnotation fileImageAnnotation = new edu.stanford.hakan.aim4api.compability.aimv3.ImageAnnotation(fileImageAnnotationCollection);
			List<edu.stanford.hakan.aim4api.compability.aimv3.Person> listPerson = fileImageAnnotation.getListPerson();
			if (listPerson.size() > 0) {
				listPerson.get(0);
			}

			edu.stanford.hakan.aim4api.compability.aimv3.GeometricShapeCollection geometricShapeCollection = fileImageAnnotation.getGeometricShapeCollection();
			for (int i = 0; i < geometricShapeCollection.getGeometricShapeList().size(); i++) {
				edu.stanford.hakan.aim4api.compability.aimv3.GeometricShape geometricShape = geometricShapeCollection.getGeometricShapeList().get(i);
				if (geometricShape.getXsiType().equals("MultiPoint")) {
					int numberOfROIs = geometricShape.getSpatialCoordinateCollection().getSpatialCoordinateList().size();
					roixData = new double[numberOfROIs];
					roiyData = new double[numberOfROIs];
					for (int j = 0; j < numberOfROIs; j++) {
						edu.stanford.hakan.aim4api.compability.aimv3.SpatialCoordinate spatialCoordinate = geometricShape.getSpatialCoordinateCollection()
								.getSpatialCoordinateList().get(j);
						if ("TwoDimensionSpatialCoordinate".equals(spatialCoordinate.getXsiType())) {
							edu.stanford.hakan.aim4api.compability.aimv3.TwoDimensionSpatialCoordinate twoDimensionSpatialCoordinate = 
									(edu.stanford.hakan.aim4api.compability.aimv3.TwoDimensionSpatialCoordinate)spatialCoordinate;
							int idx = twoDimensionSpatialCoordinate.getCoordinateIndex();
							roixData[idx] = twoDimensionSpatialCoordinate.getX();
							roiyData[idx] = twoDimensionSpatialCoordinate.getY();
						}
					}
				} else if (geometricShape.getXsiType().equals("Point")) {
					roixData = new double[1];
					roiyData = new double[1];
					edu.stanford.hakan.aim4api.compability.aimv3.SpatialCoordinate spatialCoordinate = geometricShape.getSpatialCoordinateCollection()
							.getSpatialCoordinateList().get(0);
					if ("TwoDimensionSpatialCoordinate".equals(spatialCoordinate.getXsiType())) {
						edu.stanford.hakan.aim4api.compability.aimv3.TwoDimensionSpatialCoordinate twoDimensionSpatialCoordinate = 
								(edu.stanford.hakan.aim4api.compability.aimv3.TwoDimensionSpatialCoordinate)spatialCoordinate;
						roixData[0] = twoDimensionSpatialCoordinate.getX();
						roiyData[0] = twoDimensionSpatialCoordinate.getY();
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
	
	public static boolean setNewSegmentationPoints (edu.stanford.hakan.aim4api.compability.aimv3.ImageAnnotation imageAnnotation, String imageUID, String pluginName, double[] xVector, double[] yVector) {
		edu.stanford.hakan.aim4api.compability.aimv3.Polyline polyline = new edu.stanford.hakan.aim4api.compability.aimv3.Polyline();
		polyline.setCagridId(0);
		polyline.setIncludeFlag(true);
		polyline.setShapeIdentifier(0);
		polyline.setLineStyle("lineStyle");
		
		// TODO referencedFrameNumber may be different than 0 (?)
		for (int i = 0, ii = xVector.length; i < ii; i++) {
		   polyline.addSpatialCoordinate(new edu.stanford.hakan.aim4api.compability.aimv3.TwoDimensionSpatialCoordinate(0, i, imageUID, 0, xVector[i], yVector[i]));
		}
		
		// TODO use a different approach to replace the geometric shape
		edu.stanford.hakan.aim4api.compability.aimv3.GeometricShapeCollection geometricShapeCollection = imageAnnotation.getGeometricShapeCollection();		
		geometricShapeCollection.getGeometricShapeList().set(0, polyline);		
		return true;
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

	public static String getOwnerFromImageAnnotation(ImageAnnotation aim) throws AimException
	{
		if (aim.getListUser() != null) {
			if (!aim.getListUser().isEmpty())
				return aim.getListUser().get(0).getLoginName();
		}
		throw new AimException("No User in image annotation");
	}
	
	private static void updateDSOAIMInDatabase(String annotationID,String dsoSeriesUID) throws Exception
	{
		String username = EPADConfig.epadDatabaseUsername;
		String password = EPADConfig.epadDatabasePassword;
		String epadDatabaseURL = EPADConfig.epadDatabaseURL;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = null;
		Statement statement = null;
		try
		{
			con = DriverManager.getConnection(epadDatabaseURL, username, password);
    	    String sql = "UPDATE annotations set DSOSeriesUID = '" + dsoSeriesUID + "' where AnnotationUID = '" + annotationID + "'";
            log.info("DSO AIM update:" + sql);
			statement = con.createStatement();
			statement.executeUpdate(sql);
		}
		finally
		{
			if (statement != null) statement.close();
			if (con != null) con.close();
		}
	}
	
	
	private static void cloneAIMXmlInDatabase(String annotationID,String annotationName,String xml, String oldAnnotationID) throws Exception
	{
		String username = EPADConfig.epadDatabaseUsername;
		String password = EPADConfig.epadDatabasePassword;
		String epadDatabaseURL = EPADConfig.epadDatabaseURL;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = null;
		Statement statement = null;
		try
		{
			con = DriverManager.getConnection(epadDatabaseURL, username, password);
    	    String sql = "insert into annotations(UserLoginName,PatientID,SeriesUID,DSOSeriesUID,StudyUID,ImageUID,FrameID,AnnotationUID,ProjectUID,XML, DELETED, DSOFRAMENO, TEMPLATECODE, SHAREDPROJECTS, NAME,AIMCOLOR ) " +
			"(select UserLoginName,PatientID,SeriesUID,DSOSeriesUID,StudyUID,ImageUID,FrameID,'"+annotationID +"',ProjectUID,'"+ xml+"', DELETED, DSOFRAMENO, TEMPLATECODE, SHAREDPROJECTS, '"+annotationName +"',AIMCOLOR from annotations where AnnotationUID='"+oldAnnotationID+"')";
    	    log.info("sql:"+sql);
			statement = con.createStatement();
			statement.executeUpdate(sql);
		}
		finally
		{
			if (statement != null) statement.close();
			if (con != null) con.close();
		}
	}
	
	private static void updateAIMXmlInDatabase(String annotationID,String xml) throws Exception
	{
		String username = EPADConfig.epadDatabaseUsername;
		String password = EPADConfig.epadDatabasePassword;
		String epadDatabaseURL = EPADConfig.epadDatabaseURL;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = null;
		Statement statement = null;
		try
		{
			con = DriverManager.getConnection(epadDatabaseURL, username, password);
    	    String sql = "UPDATE annotations set Xml = '" + sqlEncode(xml) + "' where AnnotationUID = '" + annotationID + "'";
			statement = con.createStatement();
			statement.executeUpdate(sql);
		}
		finally
		{
			if (statement != null) statement.close();
			if (con != null) con.close();
		}
	}
	
	public static String sqlEncode(String str) 
	{
		if (str == null) return str;
		StringWriter sw = new StringWriter();
		for (int i = 0; i < str.length(); i++) 
		{
		    char c = str.charAt(i);
		    if (c == '\'') sw.append('\'');
		    sw.append(c);
		}
		return sw.toString();
	}
	
	public static String getDSOSeriesUID(String annotationID) throws Exception
	{
		String username = EPADConfig.epadDatabaseUsername;
		String password = EPADConfig.epadDatabasePassword;
		String epadDatabaseURL = EPADConfig.epadDatabaseURL;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = null;
		Statement statement = null;
		ResultSet rs = null;
		String dsoSeriesUID = null;
		try
		{
			con = DriverManager.getConnection(epadDatabaseURL, username, password);
    	    String sql = "SELECT  DSOSeriesUID from annotations where AnnotationUID = '" + annotationID + "'";
            log.info("DSO AIM selecte:" + sql);
			statement = con.createStatement();
			rs = statement.executeQuery(sql);
			if (rs.next()) {
				dsoSeriesUID = rs.getString(1);
			}
			return dsoSeriesUID;
		}
		finally
		{
			if (rs != null) rs.close();
			if (statement != null) statement.close();
			if (con != null) con.close();
		}
	}
}
