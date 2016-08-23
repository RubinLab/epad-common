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
package edu.stanford.epad.common.pixelmed;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;

import com.pixelmed.anatproc.CodedConcept;
import com.pixelmed.dicom.Attribute;
import com.pixelmed.dicom.AttributeList;
import com.pixelmed.dicom.DicomException;
import com.pixelmed.dicom.DicomInputStream;
import com.pixelmed.dicom.TagFromName;

import edu.stanford.epad.common.util.EPADLogger;

/**
 * <p>
 * A class for converting segmentation results in TIFF files to DICOM segmentation objects.
 * 
 * @author Wei Lu (luwei@tju.edu.cn)
 * @date 2013-5
 */
public class TIFFMasksToDSOConverter
{
	private AttributeList[] dicomAttributes;
	private final short[] orientation = new short[] { 1, 0, 0, 0, 0, 1 };
	private double[] spacing = new double[] { 0.65, 0.8 };
	private double thickness = 0.5;
	private double[][] positions = null;
	private double[] sliceLocations = null;
	private short imageWidth = 0, imageHeight = 0, numberOfFrames = 0;

	private static final EPADLogger log = EPADLogger.getInstance();
	public static HashMap<String,Integer> firstFrames= new HashMap<>();

	/**
	 * @param maskFiles: Array of the TIFF files which contain the masks.
	 * @param dicomFiles: Array of the original DICOM files.
	 * @param outputFile: Name of the output segmentation objects file.
	 * @return uids: uids[0] = Series UID uids[1] = ImageUID/InstanceUID
	 * @throws DicomException
	 */	
	public String[] generateDSO(List<String> maskFilePaths, List<String> dicomFilePaths, String outputFilePath)
			throws DicomException
	{
		return generateDSO(maskFilePaths, dicomFilePaths, outputFilePath, null, null,null);
	}
	public String[] generateDSO(List<String> maskFilePaths, List<String> dicomFilePaths, String outputFilePath, String seriesDescription)
			throws DicomException
	{
		return generateDSO(maskFilePaths, dicomFilePaths, outputFilePath, seriesDescription, null,null);
	}
	public String[] generateDSO(List<String> maskFilePaths, List<String> dicomFilePaths, String outputFilePath, String dsoSeriesDescription, String dsoSeriesUID, String dsoInstanceUID)
			throws DicomException
	{
		return generateDSO(maskFilePaths, dicomFilePaths, outputFilePath, dsoSeriesDescription, dsoSeriesUID, dsoInstanceUID, false);
	}


	/**
	 * @param maskFiles: Array of the TIFF files which contain the masks.
	 * @param dicomFiles: Array of the original DICOM files.
	 * @param outputFile: Name of the output segmentation objects file.
	 * @param dsoSeriesDescription: Series Name of created segmentation object.
	 * @param dsoSeriesUID: Series UID.
	 * @param dsoInstanceUID: SOP Instance UID.
	 * @param removeEmptyFrames: if true, optimize size by removing empty frames.
	 * @return uids: uids[0] = Series UID uids[1] = ImageUID/InstanceUID
	 * @throws DicomException
	 */

	//ml imgType added for saving color in dso
	public String[] generateDSO(List<String> maskFilePaths, List<String> dicomFilePaths, String outputFilePath, String dsoSeriesDescription, String dsoSeriesUID, String dsoInstanceUID, boolean removeEmptyFrames, String imgType)
			throws DicomException
	{
		try {
			List<String> originalFilePaths = new ArrayList<String>();
			for (String path: dicomFilePaths)
				originalFilePaths.add(path);
			// Following call fills in: dicomAttributes, orientation, spacing, thickness, positions, pixels, imageWidth,
			// imageHeight, imageFrames
			log.info("Getting attributes from DICOM files");
			int minInstanceNo = getAttributesFromDICOMFiles(dicomFilePaths);
			if (minInstanceNo > 1) removeEmptyFrames = false;
			log.info("Reading pixels from mask files");
			//send dso instance uid so it can be used in the map for framenumbers
			byte[] pixels = getPixelsFromMaskFiles(maskFilePaths, dicomFilePaths, removeEmptyFrames, dsoInstanceUID);
			if (dicomFilePaths.size() != dicomAttributes.length)
			{
				AttributeList[] dicomAttributesNew = new AttributeList[dicomFilePaths.size()];
				int i = 0;
				for (AttributeList attrs: dicomAttributes)
				{
					if (attrs == null) continue;
					dicomAttributesNew[i++] = attrs;
				}
				dicomAttributes = dicomAttributesNew;
				this.numberOfFrames = (short)dicomFilePaths.size();
			}
			log.debug("Dicom Files:" + dicomFilePaths.size() + " attributeLists:" + dicomAttributes.length);
			return generateDSO(pixels, dicomFilePaths, outputFilePath, dsoSeriesDescription, dsoSeriesUID, dsoInstanceUID, imgType);
		} catch (Exception e) {
			e.printStackTrace();
			log.warning("Error generating DSO: " + e);
			throw (new DicomException("Error generating DSO: " + e.getMessage()));
		}	
	}

	/**
	 * @param maskFiles: Array of the TIFF files which contain the masks.
	 * @param dicomFiles: Array of the original DICOM files.
	 * @param outputFile: Name of the output segmentation objects file.
	 * @param dsoSeriesDescription: Series Name of created segmentation object.
	 * @param dsoSeriesUID: Series UID.
	 * @param dsoInstanceUID: SOP Instance UID.
	 * @param removeEmptyFrames: if true, optimize size by removing empty frames.
	 * @return uids: uids[0] = Series UID uids[1] = ImageUID/InstanceUID
	 * @throws DicomException
	 */
	public String[] generateDSO(List<String> maskFilePaths, List<String> dicomFilePaths, String outputFilePath, String dsoSeriesDescription, String dsoSeriesUID, String dsoInstanceUID, boolean removeEmptyFrames)
			throws DicomException
	{
		try {
			List<String> originalFilePaths = new ArrayList<String>();
			for (String path: dicomFilePaths)
				originalFilePaths.add(path);
			// Following call fills in: dicomAttributes, orientation, spacing, thickness, positions, pixels, imageWidth,
			// imageHeight, imageFrames
			log.info("Getting attributes from DICOM files");
			int minInstanceNo = getAttributesFromDICOMFiles(dicomFilePaths);
			if (minInstanceNo > 1) removeEmptyFrames = false;
			log.info("Reading pixels from mask files");
			byte[] pixels = getPixelsFromMaskFiles(maskFilePaths, dicomFilePaths, removeEmptyFrames);
			if (dicomFilePaths.size() != dicomAttributes.length)
			{
				AttributeList[] dicomAttributesNew = new AttributeList[dicomFilePaths.size()];
				int i = 0;
				for (AttributeList attrs: dicomAttributes)
				{
					if (attrs == null) continue;
					dicomAttributesNew[i++] = attrs;
				}
				dicomAttributes = dicomAttributesNew;
				this.numberOfFrames = (short)dicomFilePaths.size();
			}
			log.debug("Dicom Files:" + dicomFilePaths.size() + " attributeLists:" + dicomAttributes.length);
			return generateDSO(pixels, dicomFilePaths, outputFilePath, dsoSeriesDescription, dsoSeriesUID, dsoInstanceUID);
		} catch (Exception e) {
			e.printStackTrace();
			log.warning("Error generating DSO: " + e);
			throw (new DicomException("Error generating DSO: " + e.getMessage()));
		}	
	}

	//ml imgType added for saving color in dso
	public String[] generateDSO(byte[] pixeldata, List<String> dicomFilePaths, String outputFilePath, String dsoSeriesDescription, String dsoSeriesUID, String dsoInstanceUID, String imgType)
			throws DicomException
	{
		try {
			if (dicomAttributes == null) getAttributesFromDICOMFiles(dicomFilePaths);
			SegmentationObjectsFileWriter dsoWriter = new SegmentationObjectsFileWriter(dicomAttributes, orientation,
					spacing, thickness, dsoSeriesDescription, dsoSeriesUID, dsoInstanceUID);
			CodedConcept category = new CodedConcept("C0085089" /* conceptUniqueIdentifier */, "260787004" /* SNOMED CID */,
					"SRT" /* codingSchemeDesignator */, "SNM3" /* legacyCodingSchemeDesignator */,
					null /* codingSchemeVersion */, "A-00004" /* codeValue */, "Physical Object" /* codeMeaning */,
					null /* codeStringEquivalent */, null /* synonynms */);
			CodedConcept type = new CodedConcept("C0018787" /* conceptUniqueIdentifier */, "80891009" /* SNOMED CID */,
					"SRT" /* codingSchemeDesignator */, null /* legacyCodingSchemeDesignator */,
					null /* codingSchemeVersion */, "T-32000" /* codeValue */, "Heart" /* codeMeaning */,
					null /* codeStringEquivalent */, null /* synonynms */);
			log.info("Adding One Segment...");
			dsoWriter.addOneSegment("Segment No.1 is for ...", category, type);
			log.info("Adding All Frames...");
			dsoWriter.addAllFrames(pixeldata, numberOfFrames, imageWidth, imageHeight, imgType, (short)0, positions);
			log.info("Saving Dicom File...");
			dsoWriter.saveDicomFile(outputFilePath);
			String[] seriesImageUids = new String[2];
			seriesImageUids[0] = dsoWriter.getSeriesUID();
			seriesImageUids[1] = dsoWriter.getImageUID();
			return seriesImageUids;
		} catch (Exception e) {
			e.printStackTrace();
			log.warning("Error generating DSO: " + e);
			throw (new DicomException("Error generating DSO: " + e.getMessage()));
		}
	}

	public String[] generateDSO(byte[] pixeldata, List<String> dicomFilePaths, String outputFilePath, String dsoSeriesDescription, String dsoSeriesUID, String dsoInstanceUID)
			throws DicomException
	{
		try {
			if (dicomAttributes == null) getAttributesFromDICOMFiles(dicomFilePaths);
			SegmentationObjectsFileWriter dsoWriter = new SegmentationObjectsFileWriter(dicomAttributes, orientation,
					spacing, thickness, dsoSeriesDescription, dsoSeriesUID, dsoInstanceUID);
			CodedConcept category = new CodedConcept("C0085089" /* conceptUniqueIdentifier */, "260787004" /* SNOMED CID */,
					"SRT" /* codingSchemeDesignator */, "SNM3" /* legacyCodingSchemeDesignator */,
					null /* codingSchemeVersion */, "A-00004" /* codeValue */, "Physical Object" /* codeMeaning */,
					null /* codeStringEquivalent */, null /* synonynms */);
			CodedConcept type = new CodedConcept("C0018787" /* conceptUniqueIdentifier */, "80891009" /* SNOMED CID */,
					"SRT" /* codingSchemeDesignator */, null /* legacyCodingSchemeDesignator */,
					null /* codingSchemeVersion */, "T-32000" /* codeValue */, "Heart" /* codeMeaning */,
					null /* codeStringEquivalent */, null /* synonynms */);
			log.info("Adding One Segment...");
			dsoWriter.addOneSegment("Segment No.1 is for ...", category, type);
			log.info("Adding All Frames...");
			dsoWriter.addAllFrames(pixeldata, numberOfFrames, imageWidth, imageHeight, "binary", (short)0, positions);
			log.info("Saving Dicom File...");
			dsoWriter.saveDicomFile(outputFilePath);
			String[] seriesImageUids = new String[2];
			seriesImageUids[0] = dsoWriter.getSeriesUID();
			seriesImageUids[1] = dsoWriter.getImageUID();
			return seriesImageUids;
		} catch (Exception e) {
			e.printStackTrace();
			log.warning("Error generating DSO: " + e);
			throw (new DicomException("Error generating DSO: " + e.getMessage()));
		}
	}

	/**
	 * <code>
	 * 
	 * </code>
	 */
	/**
	 * List the files in the assigned path and sort the filenames in alphabetic order.
	 * 
	 * @param folderPath
	 * @return Names of the files.
	 */
	private static List<String> listFilesInAlphabeticOrder(String folderPath)
	{
		final File folderFile = new File(folderPath);
		File[] listOfFiles = folderFile.listFiles();

		List<String> fileList = new ArrayList<String>();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				fileList.add(listOfFiles[i].toString());
			}
		}
		Collections.sort(fileList);

		return fileList;
	}

	private int getAttributesFromDICOMFiles(List<String> dicomFilePaths) throws FileNotFoundException, IOException,
	DicomException
	{
		AttributeList localDICOMAttributes = new AttributeList();
		String dicomInputFile = dicomFilePaths.get(0);

		DicomInputStream dicomInputStream = null;
		try {
			dicomInputStream = new DicomInputStream(new FileInputStream(dicomInputFile));
			localDICOMAttributes.read(dicomInputStream);
		} finally {
			IOUtils.closeQuietly(dicomInputStream);
		}
		if (dicomAttributes == null) dicomAttributes = new AttributeList[dicomFilePaths.size()];
		this.dicomAttributes[0] = (AttributeList)localDICOMAttributes.clone();
		this.imageWidth = (short)Attribute.getSingleIntegerValueOrDefault(localDICOMAttributes, TagFromName.Columns, 1);
		this.imageHeight = (short)Attribute.getSingleIntegerValueOrDefault(localDICOMAttributes, TagFromName.Rows, 1);
		this.numberOfFrames = (short)dicomFilePaths.size();
		log.info("Number of frames in DICOM file " + this.numberOfFrames);

		{ // Get geometric info.
			Attribute dicomAttribute = localDICOMAttributes.get(TagFromName.SliceThickness);
			this.thickness = dicomAttribute == null ? 0.1 : dicomAttribute.getSingleDoubleValueOrDefault(0.1);
			dicomAttribute = localDICOMAttributes.get(TagFromName.PixelSpacing);

			if (dicomAttribute != null)
				this.spacing = dicomAttribute.getDoubleValues();

			dicomAttribute = localDICOMAttributes.get(TagFromName.ImageOrientationPatient);
			if (dicomAttribute != null) {
				String[] s = dicomAttribute.getStringValues();
				for (int i = 0; i < s.length; i++) {
					this.orientation[i] = (short)Float.parseFloat(s[i]);
				}
			}
		}

		{ // Check Clinical Trial info.
			Attribute siteID = localDICOMAttributes.get(TagFromName.ClinicalTrialSiteID);
			if (siteID != null)
			{
				Attribute siteName = localDICOMAttributes.get(TagFromName.ClinicalTrialSiteName);
				Attribute sponsorName = localDICOMAttributes.get(TagFromName.ClinicalTrialSponsorName);
				Attribute protocolID = localDICOMAttributes.get(TagFromName.ClinicalTrialProtocolID);
				Attribute protocolName = localDICOMAttributes.get(TagFromName.ClinicalTrialProtocolName);
				if (siteName == null || sponsorName == null || protocolID == null || protocolName == null)
				{
					log.warning("Missing Clinical Trial Attributes in Source DICOM");
				}
			}
		}

		try { // Get sequence format. Get position of each frame.
			positions = new double[numberOfFrames][3];
			sliceLocations = new double[numberOfFrames];
			int[] instanceNos = new int[dicomFilePaths.size()];
			for (int i = 0; i < dicomFilePaths.size(); i++) {
				dicomInputFile = dicomFilePaths.get(i);
				dicomInputStream = new DicomInputStream(new FileInputStream(dicomInputFile));
				localDICOMAttributes.clear();
				localDICOMAttributes.read(dicomInputStream);
				Attribute attribute = localDICOMAttributes.get(TagFromName.ImagePositionPatient);
				if (attribute != null)
					this.positions[i] = attribute.getDoubleValues();
				sliceLocations[i] = Attribute.getSingleDoubleValueOrDefault(localDICOMAttributes, TagFromName.SliceLocation, 0);
				if (i > 0)
				{
					dicomAttributes[i] = (AttributeList) localDICOMAttributes.clone();
				}
				instanceNos[i] = Attribute.getSingleIntegerValueOrDefault(localDICOMAttributes, TagFromName.InstanceNumber, 1);
				log.info("instance "+i+ " no:"+instanceNos[i]);

			}
			//added slicelocation for sorting, we should actually use position and orientation for sorting 
			//but the defaultdcm4che operations do not have that info
			
			boolean fixInstanceNumbers=false;
			// trigger logic in default dcm4chee operations is last-first+1!=size 
			// should we do this?? as it is dso not the image 
//			if (instanceNos[instanceNos.length-1] - instanceNos[0] +1 != instanceNos.length)
//				fixInstanceNumbers = true;
			//order by instance numbers
			int mininstance = instanceNos.length;
			for (int i = 0; i < instanceNos.length; i++) {
				for (int j = i; j < instanceNos.length; j++) {
					int instance = instanceNos[i];
					if (instance < mininstance) mininstance = instance;
					double[] position = positions[i];
					double sliceLocation = sliceLocations[i];
					AttributeList alist = dicomAttributes[i];
					//if instance numbers are incorrect trigger fixing it, do not throw error
					// update instance numbers when there are more than one with the same number
					// trigger logic in default dcm4chee operations is last-first+1!=size 
					if (instanceNos[j] == instance  && j != i){
						fixInstanceNumbers=true;
						i=instanceNos.length-1;
						break;
//						throw new RuntimeException("Invalid source dicom, it has duplicate instances numbers: " + instance);
					}
					if (instanceNos[j] > instance) {
						instanceNos[i] = instanceNos[j];
						positions[i] = positions[j];
						dicomAttributes[i] = dicomAttributes[j];
						instanceNos[j] = instance;
						positions[j] = position;
						dicomAttributes[j] = alist;
						sliceLocations[i] = sliceLocations[j];
						sliceLocations[j] = sliceLocation;
						
					}
				}
			}
			
			if (fixInstanceNumbers) {
				//order by slice location in descending order
				for (int i = 0; i < instanceNos.length; i++) {
					for (int j = i; j < instanceNos.length; j++) {
						int instance = instanceNos[i];
						double[] position = positions[i];
						double sliceLocation = sliceLocations[i];
						AttributeList alist = dicomAttributes[i];
						
						if (sliceLocations[j] <= sliceLocation) {
							instanceNos[i] = instanceNos[j];
							positions[i] = positions[j];
							dicomAttributes[i] = dicomAttributes[j];
							instanceNos[j] = instance;
							positions[j] = position;
							dicomAttributes[j] = alist;
							sliceLocations[i] = sliceLocations[j];
							sliceLocations[j] = sliceLocation;
							
						}
					}
				}
				//go through the ordered list and fix instance numbers
				for (int i = 0; i < instanceNos.length; i++) {
					instanceNos[i] = i+1;
				}
				mininstance = 1;
				
			}
			return mininstance;
		} finally {
			IOUtils.closeQuietly(dicomInputStream);
		}
	}

	public static BufferedImage convertRGBAToIndexed(BufferedImage src) {
		BufferedImage dest = new BufferedImage(src.getWidth(), src.getHeight(), BufferedImage.TYPE_BYTE_INDEXED);

		dest.createGraphics().drawImage(src, 0, 0, null);
		return dest;
	}
	/**
	 * get pixels and fill firstFrame for dso
	 * @param maskFilePaths
	 * @param dicomFilePaths
	 * @param removeEmpty
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws DicomException
	 */
	private byte[] getPixelsFromMaskFiles(List<String> maskFilePaths, List<String> dicomFilePaths, boolean removeEmpty, String dsoUID) throws FileNotFoundException, IOException,
	DicomException
	{
		Integer firstFrame=-1;
		byte[] pixels = null;
		List<Integer> emptyFileIndex = new ArrayList<Integer>();
		for (int i = 0; i < maskFilePaths.size(); i++) {
			File maskFile = new File(maskFilePaths.get(i));
			BufferedImage maskImage = ImageIO.read(maskFile);
			// BufferedImage bufferedImage = new BufferedImage(image.getWidth(), image.getHeight(),
			// BufferedImage.TYPE_BYTE_BINARY);
			byte[] new_frame = ((DataBufferByte)maskImage.getRaster().getDataBuffer()).getData();
			byte[] pixel_data = new_frame;
			long rgbLen = maskImage.getWidth()*maskImage.getHeight()*4;
			long bwLen = maskImage.getWidth()*maskImage.getHeight()/8;
			long greyLen = maskImage.getWidth()*maskImage.getHeight();
			if (i == 0)
			{
				System.out.println("Expected length, RGB:" + rgbLen + " BW:" + bwLen + " Grey:" + greyLen 
						+ " Actual tiff data len:" + new_frame.length);
				log.info("Expected length, RGB:" + rgbLen + " BW:" + bwLen + " Grey:" + greyLen 
						+ " Actual tiff data len:" + new_frame.length);
			}
			boolean nonzerodata = false;

			// looks like 4 bytes/pixel, compress to 1 bit/pixel (else assume it is already 1 bit/pixel)
			if (new_frame.length == rgbLen)
			{
				if (i%10 == 0) {
					System.out.println("Compressing tiff mask from rgb, mask:" + i);
					log.debug("Compressing tiff mask from rgb, mask:" + i);
				}

				int numpixels = new_frame.length/4;
  				int numbytes = numpixels/8;		  				
  				pixel_data = new byte[numbytes];	
				for (int k = 0; k < numbytes; k++)
				{
					int index = k*8*4;
					pixel_data[k] = 0;
					for (int l = 0; l < 4*8; l=l+4)
					{
						if (new_frame[index + l] != 0)
						{
							int setBit =  pixel_data[k] + (1 << (l/4));
							pixel_data[k] =(byte) setBit;
							nonzerodata = true;
						}
					}
					if (pixel_data[k] != 0)
						log.info("maskfile" + i + ": " + k + " pixel:" + pixel_data[k] + " compress rgb");
				}
				 
					
					//				
				
			}
			// ml if 
			else if (new_frame.length == greyLen || maskImage.getType()== BufferedImage.TYPE_BYTE_INDEXED)
			{
				if (maskImage.getType()== BufferedImage.TYPE_BYTE_INDEXED) { //if not indexed old version should work
					if (i%10 == 0) {
						System.out.println("indexed tiff mask from rgb, mask:" + i);
						log.debug("indexed tiff mask from rgb, mask:" + i);
					}

					
					//				pixel_data = ((DataBufferByte)convertRGBAToIndexed(maskImage).getRaster().getDataBuffer()).getData();
					int numpixels = new_frame.length;
					pixel_data = new byte[numpixels];
					log.info("maskfile data");
					for (int k = 0; k < numpixels; k++)
					{
						pixel_data[k] = 0;
						if (new_frame[k] != 0)
						{
							pixel_data[k] = new_frame[k];
							nonzerodata = true;
						}

						//					byte red = (byte)((new_frame[index] * 8) / 256);
						//					byte green = (byte)((new_frame[index+1] * 8) / 256);
						//					byte blue = (byte)((new_frame[index+2] * 4) / 256);
						//					pixel_data[k] =(byte) ((red << 5) | (green << 2) | blue);

						//					for (int l = 0; l < 4; l=l+4)
						//					{
						//						if (new_frame[index + l] != 0)
						//						{
						//							int setBit =  pixel_data[k] + (1 << (l));
						//							pixel_data[k] =(byte) setBit;
						//							nonzerodata = true;
						//						}
						//					}
						if (pixel_data[k] != 0)
							log.info("maskfile" + i + ": " + k + " pixel:" + pixel_data[k] +" rgb " );
					}

				} else {
					if (i%10 == 0) {
						System.out.println("Compressing tiff mask from grey, mask:" + i);
						log.debug("Compressing tiff mask from grey, mask:" + i);
					}
					int numpixels = new_frame.length;
					int numbytes = numpixels/8;
					pixel_data = new byte[numbytes];
					for (int k = 0; k < numbytes; k++)
					{
						int index = k*8;
						pixel_data[k] = 0;
						for (int l = 0; l < 8; l++)
						{
							if (new_frame[index + l] != 0)
							{
								int setBit =  pixel_data[k] + (1 << l);
								pixel_data[k] =(byte) setBit;
								nonzerodata = true;
							}
						}
						if (pixel_data[k] != 0)
							log.info("maskfile" + i + ": " + k + " pixel:" + pixel_data[k]);
					}
				}

			}
			else //bw
			{
				if (i%10 == 0) {
					System.out.println("Flipping odd bytes of bw tif, mask:" + i);
					log.debug("Flipping odd bytes of bw tif, mask:" + i);
				}
				int numbytes = maskImage.getWidth()*maskImage.getHeight()/8;
				pixel_data = new byte[numbytes];
				for (int k = 0; k < numbytes; k++)
				{
					// Flip every odd byte. why on earth do we need to do this?
					if (new_frame[k] != 0)
						nonzerodata = true;
					//flip if not indexed image (8 bit color)
					if (k%2 != 0 && new_frame[k] != 0)
					{
						pixel_data[k] = 0;
						if ((new_frame[k] & 1) == 1)
						{
							int setBit = pixel_data[k]+128;
							pixel_data[k] =(byte) setBit;
						}
						if ((new_frame[k] & 2) == 2)
						{
							int setBit = pixel_data[k]+64;
							pixel_data[k] =(byte) setBit;
						}
						if ((new_frame[k] & 4) == 4)
						{
							int setBit = pixel_data[k]+32;
							pixel_data[k] =(byte) setBit;
						}
						if ((new_frame[k] & 8) == 8)
						{
							int setBit = pixel_data[k]+16;
							pixel_data[k] =(byte) setBit;
						}
						if ((new_frame[k] & 16) == 16)
						{
							int setBit = pixel_data[k]+8;
							pixel_data[k] =(byte) setBit;
						}
						if ((new_frame[k] & 32) == 32)
						{
							int setBit = pixel_data[k]+4;
							pixel_data[k] =(byte) setBit;
						}
						if ((new_frame[k] & 64) == 64)
						{
							int setBit = pixel_data[k]+2;
							pixel_data[k] =(byte) setBit;
						}
						if ((new_frame[k] & 128) == 128)
						{
							int setBit = pixel_data[k]+1;
							pixel_data[k] =(byte) setBit;
						}
						if (new_frame[k] != 0)
							System.out.println("Old byte:" + new_frame[k] + " New byte:" + pixel_data[k]);	
					}
					else
						pixel_data[k] = new_frame[k];
					if (pixel_data[k] != 0)
						log.info("maskfile bw-rgb" + i + ": " + k + " pixel:" + pixel_data[k]);
				}
			}
			log.info("maskfile" + i + ": " + maskFilePaths.get(i) + " frame_length:" + pixel_data.length + " nonzero data:" + nonzerodata);
			if (!nonzerodata && removeEmpty) {
				log.debug("Nodata - maskfile" + i + ": " + maskFilePaths.get(i) + " frame_length:" + pixel_data.length);
				emptyFileIndex.add(i);
				continue;
			}
			if (nonzerodata) {
				Integer reverseNum=maskFilePaths.size()-i-1;
				if (firstFrame==-1 || reverseNum< firstFrame) {
					firstFrame=reverseNum;
					log.info("setting firstframe:"+firstFrame);
					
				}
					
			}
			if (pixels == null) {
				//pixels = new_frame.clone();
				pixels = pixel_data;
			} else {
				byte[] temp = new byte[pixels.length + pixel_data.length];
				System.arraycopy(pixels, 0, temp, 0, pixels.length);
				System.arraycopy(pixel_data, 0, temp, pixels.length, pixel_data.length);
				//pixels = temp.clone();
				pixels = temp;
			}
		}
		//update the firstframe for this dso
		log.info("first frame for dso:"+ dsoUID + " is "+firstFrame);
		firstFrames.put(dsoUID, firstFrame);
		for (int i = 0; i < emptyFileIndex.size(); i++)
		{
			int index = emptyFileIndex.get(i);
			log.info("Removing dicom " + (dicomAttributes.length - index -1));
			dicomFilePaths.remove(dicomAttributes.length - index -1);
			dicomAttributes[index] = null;
		}
		//		for (int i = 0; i < emptyFileIndex.size(); i++)
		//		{
		//			int index = emptyFileIndex.get(i);
		//			log.info("Removing dicom " + (maskFilePaths.size() - index - 1));
		//			dicomFilePaths.remove(maskFilePaths.size() - index - 1); // DicomFiles are in reverse order for!!!
		//		}
		if (pixels == null)
			throw new RuntimeException("The DSO has all empty frames");
		log.info("Number of pixels:" + pixels.length + " dicoms:" + dicomFilePaths.size());	
		return pixels;
	}
	
	private byte[] getPixelsFromMaskFiles(List<String> maskFilePaths, List<String> dicomFilePaths, boolean removeEmpty) throws FileNotFoundException, IOException,
	DicomException
	{
		byte[] pixels = null;
		List<Integer> emptyFileIndex = new ArrayList<Integer>();
		for (int i = 0; i < maskFilePaths.size(); i++) {
			File maskFile = new File(maskFilePaths.get(i));
			BufferedImage maskImage = ImageIO.read(maskFile);
			// BufferedImage bufferedImage = new BufferedImage(image.getWidth(), image.getHeight(),
			// BufferedImage.TYPE_BYTE_BINARY);
			byte[] new_frame = ((DataBufferByte)maskImage.getRaster().getDataBuffer()).getData();
			byte[] pixel_data = new_frame;
			long rgbLen = maskImage.getWidth()*maskImage.getHeight()*4;
			long bwLen = maskImage.getWidth()*maskImage.getHeight()/8;
			long greyLen = maskImage.getWidth()*maskImage.getHeight();
			if (i == 0)
			{
				System.out.println("Expected length, RGB:" + rgbLen + " BW:" + bwLen + " Grey:" + greyLen 
						+ " Actual tiff data len:" + new_frame.length);
				log.info("Expected length, RGB:" + rgbLen + " BW:" + bwLen + " Grey:" + greyLen 
						+ " Actual tiff data len:" + new_frame.length);
			}
			boolean nonzerodata = false;

			// looks like 4 bytes/pixel, compress to 1 bit/pixel (else assume it is already 1 bit/pixel)
			if (new_frame.length == rgbLen)
			{
				if (i%10 == 0) {
					System.out.println("Compressing tiff mask from rgb, mask:" + i);
					log.debug("Compressing tiff mask from rgb, mask:" + i);
				}

				int numpixels = new_frame.length/4;
  				int numbytes = numpixels/8;		  				
  				pixel_data = new byte[numbytes];	
				for (int k = 0; k < numbytes; k++)
				{
					int index = k*8*4;
					pixel_data[k] = 0;
					for (int l = 0; l < 4*8; l=l+4)
					{
						if (new_frame[index + l] != 0)
						{
							int setBit =  pixel_data[k] + (1 << (l/4));
							pixel_data[k] =(byte) setBit;
							nonzerodata = true;
						}
					}
					if (pixel_data[k] != 0)
						log.info("maskfile" + i + ": " + k + " pixel:" + pixel_data[k] + " compress rgb");
				}
				 
					
					//				
				
			}
			// ml if 
			else if (new_frame.length == greyLen || maskImage.getType()== BufferedImage.TYPE_BYTE_INDEXED)
			{
				if (maskImage.getType()== BufferedImage.TYPE_BYTE_INDEXED) { //if not indexed old version should work
					if (i%10 == 0) {
						System.out.println("indexed tiff mask from rgb, mask:" + i);
						log.debug("indexed tiff mask from rgb, mask:" + i);
					}

					
					//				pixel_data = ((DataBufferByte)convertRGBAToIndexed(maskImage).getRaster().getDataBuffer()).getData();
					int numpixels = new_frame.length;
					pixel_data = new byte[numpixels];
					log.info("maskfile data");
					for (int k = 0; k < numpixels; k++)
					{
						pixel_data[k] = 0;
						if (new_frame[k] != 0)
						{
							pixel_data[k] = new_frame[k];
							nonzerodata = true;
						}

						//					byte red = (byte)((new_frame[index] * 8) / 256);
						//					byte green = (byte)((new_frame[index+1] * 8) / 256);
						//					byte blue = (byte)((new_frame[index+2] * 4) / 256);
						//					pixel_data[k] =(byte) ((red << 5) | (green << 2) | blue);

						//					for (int l = 0; l < 4; l=l+4)
						//					{
						//						if (new_frame[index + l] != 0)
						//						{
						//							int setBit =  pixel_data[k] + (1 << (l));
						//							pixel_data[k] =(byte) setBit;
						//							nonzerodata = true;
						//						}
						//					}
						if (pixel_data[k] != 0)
							log.info("maskfile" + i + ": " + k + " pixel:" + pixel_data[k] +" rgb " );
					}

				} else {
					if (i%10 == 0) {
						System.out.println("Compressing tiff mask from grey, mask:" + i);
						log.debug("Compressing tiff mask from grey, mask:" + i);
					}
					int numpixels = new_frame.length;
					int numbytes = numpixels/8;
					pixel_data = new byte[numbytes];
					for (int k = 0; k < numbytes; k++)
					{
						int index = k*8;
						pixel_data[k] = 0;
						for (int l = 0; l < 8; l++)
						{
							if (new_frame[index + l] != 0)
							{
								int setBit =  pixel_data[k] + (1 << l);
								pixel_data[k] =(byte) setBit;
								nonzerodata = true;
							}
						}
						if (pixel_data[k] != 0)
							log.info("maskfile" + i + ": " + k + " pixel:" + pixel_data[k]);
					}
				}

			}
			else //bw
			{
				if (i%10 == 0) {
					System.out.println("Flipping odd bytes of bw tif, mask:" + i);
					log.debug("Flipping odd bytes of bw tif, mask:" + i);
				}
				int numbytes = maskImage.getWidth()*maskImage.getHeight()/8;
				pixel_data = new byte[numbytes];
				for (int k = 0; k < numbytes; k++)
				{
					// Flip every odd byte. why on earth do we need to do this?
					if (new_frame[k] != 0)
						nonzerodata = true;
					//flip if not indexed image (8 bit color)
					if (k%2 != 0 && new_frame[k] != 0)
					{
						pixel_data[k] = 0;
						if ((new_frame[k] & 1) == 1)
						{
							int setBit = pixel_data[k]+128;
							pixel_data[k] =(byte) setBit;
						}
						if ((new_frame[k] & 2) == 2)
						{
							int setBit = pixel_data[k]+64;
							pixel_data[k] =(byte) setBit;
						}
						if ((new_frame[k] & 4) == 4)
						{
							int setBit = pixel_data[k]+32;
							pixel_data[k] =(byte) setBit;
						}
						if ((new_frame[k] & 8) == 8)
						{
							int setBit = pixel_data[k]+16;
							pixel_data[k] =(byte) setBit;
						}
						if ((new_frame[k] & 16) == 16)
						{
							int setBit = pixel_data[k]+8;
							pixel_data[k] =(byte) setBit;
						}
						if ((new_frame[k] & 32) == 32)
						{
							int setBit = pixel_data[k]+4;
							pixel_data[k] =(byte) setBit;
						}
						if ((new_frame[k] & 64) == 64)
						{
							int setBit = pixel_data[k]+2;
							pixel_data[k] =(byte) setBit;
						}
						if ((new_frame[k] & 128) == 128)
						{
							int setBit = pixel_data[k]+1;
							pixel_data[k] =(byte) setBit;
						}
						if (new_frame[k] != 0)
							System.out.println("Old byte:" + new_frame[k] + " New byte:" + pixel_data[k]);	
					}
					else
						pixel_data[k] = new_frame[k];
					if (pixel_data[k] != 0)
						log.info("maskfile bw-rgb" + i + ": " + k + " pixel:" + pixel_data[k]);
				}
			}
			log.info("maskfile" + i + ": " + maskFilePaths.get(i) + " frame_length:" + pixel_data.length + " nonzero data:" + nonzerodata);
			if (!nonzerodata && removeEmpty) {
				log.debug("Nodata - maskfile" + i + ": " + maskFilePaths.get(i) + " frame_length:" + pixel_data.length);
				emptyFileIndex.add(i);
				continue;
			}
			if (pixels == null) {
				//pixels = new_frame.clone();
				pixels = pixel_data;
			} else {
				byte[] temp = new byte[pixels.length + pixel_data.length];
				System.arraycopy(pixels, 0, temp, 0, pixels.length);
				System.arraycopy(pixel_data, 0, temp, pixels.length, pixel_data.length);
				//pixels = temp.clone();
				pixels = temp;
			}
		}
		for (int i = 0; i < emptyFileIndex.size(); i++)
		{
			int index = emptyFileIndex.get(i);
			log.info("Removing dicom " + (dicomAttributes.length - index -1));
			dicomFilePaths.remove(dicomAttributes.length - index -1);
			dicomAttributes[index] = null;
		}
		//		for (int i = 0; i < emptyFileIndex.size(); i++)
		//		{
		//			int index = emptyFileIndex.get(i);
		//			log.info("Removing dicom " + (maskFilePaths.size() - index - 1));
		//			dicomFilePaths.remove(maskFilePaths.size() - index - 1); // DicomFiles are in reverse order for!!!
		//		}
		if (pixels == null)
			throw new RuntimeException("The DSO has all empty frames");
		log.info("Number of pixels:" + pixels.length + " dicoms:" + dicomFilePaths.size());	
		return pixels;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		if (args.length < 3)
		{
			System.out.println("\n\nInvalid arguments.\n\nUsage: java -classpath epad-ws-1.1-jar-with-dependencies.jar edu.stanford.epad.common.pixelmed.TIFFMasksToDSOConverter tiffFolder dicomFolder outputDSO.dcm");
			return;
		}
		String maskFilesDirectory = args[0];
		String dicomFilesDirectory = args[1];
		String outputFileName = args[2];
		//String maskFilesDirectory = "/Stanford/rlabs/data/tiffmasks";
		//String dicomFilesDirectory = "/Stanford/rlabs/data/dicoms";
		//String outputFileName = "/Stanford/rlabs/data/output/dso.dcm";

		List<String> dicomFilePaths = listFilesInAlphabeticOrder(dicomFilesDirectory);
		for (int i = 0; i < dicomFilePaths.size(); i++)
		{
			if (!dicomFilePaths.get(i).toLowerCase().endsWith(".dcm"))
			{
				System.out.println("Removing DICOM file " + dicomFilePaths.get(i));
				dicomFilePaths.remove(i);
				i--;
			}
		}
		if (dicomFilePaths.size() == 0)
		{
			System.out.println("No DICOM files found");
			return;
		}

		List<String> maskFilePaths = listFilesInAlphabeticOrder(maskFilesDirectory);
		for (int i = 0; i < maskFilePaths.size(); i++)
		{
			if (!maskFilePaths.get(i).toLowerCase().endsWith(".tif") && !maskFilePaths.get(i).toLowerCase().endsWith(".tiff"))
			{
				System.out.println("Removing tif file " + maskFilePaths.get(i));
				maskFilePaths.remove(i);
				i--;
			}
		}
		// Flip them because the code expects that
		List<String> reverseMaskFilePaths = new ArrayList<String>();
		for (int i = maskFilePaths.size(); i > 0 ; i--)
		{
			reverseMaskFilePaths.add(maskFilePaths.get(i-1));
		}
		if (maskFilePaths.size() == 0)
		{
			System.out.println("No Tif Mask files found");
			return;
		}

		if (dicomFilePaths.size() > maskFilePaths.size())
			dicomFilePaths = dicomFilePaths.subList(0, reverseMaskFilePaths.size());
		else if (reverseMaskFilePaths.size() > dicomFilePaths.size())
			reverseMaskFilePaths = reverseMaskFilePaths.subList(0, dicomFilePaths.size());

		try {
			TIFFMasksToDSOConverter converter = new TIFFMasksToDSOConverter();
			String[] uids = null;
			if (args.length > 3)
				uids = converter.generateDSO(reverseMaskFilePaths, dicomFilePaths, outputFileName, args[3]);
			else
				uids = converter.generateDSO(reverseMaskFilePaths, dicomFilePaths, outputFileName);
			System.out.println("DICOM Segmentation Object created. SeriesUID:" + uids[0] + " InstanceUID:" + uids[1]);
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace(System.err);
			System.exit(0);
		}
	}
}