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
	public static final String AccessionNumberCode = getTagCode(TagFromName.AccessionNumber);
	public static final String AccessionNumberTagName = dicomDictionary.getFullNameFromTag(TagFromName.AccessionNumber);
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
	public static final String ReferencedSegmentNumberCode = getTagCode(TagFromName.ReferencedSegmentNumber);
	public static final String SegmentNumberCode = getTagCode(TagFromName.SegmentNumber);
	public static final String ROIDisplayColor = getTagCode(TagFromName.ROIDisplayColor);
	public static final String BodyPartExamined = getTagCode(TagFromName.BodyPartExamined);
	
	//added for getting segmentation category
	public static final String CodeValueCode = getTagCode(TagFromName.CodeValue);
	public static final String CodeMeaningCode = getTagCode(TagFromName.CodeMeaning);
	public static final String CodingSchemeDesignatorCode = getTagCode(TagFromName.CodingSchemeDesignator);
	public static final String SOPClassUIDCode = getTagCode(TagFromName.SOPClassUID);
	public static final String PatientIDCode = getTagCode(TagFromName.PatientID);
	
	//required for suv
	//injected, acqDate, acqTime, radioPhStartTime, radioPhHalfTime, weight, units
	public static final String TotalDoseCode = getTagCode(TagFromName.RadionuclideTotalDose);
	public static final String SeriesDateCode = getTagCode(TagFromName.SeriesDate);
	public static final String SeriesTimeCode = getTagCode(TagFromName.SeriesTime);
	public static final String RadiopharmaceuticalStartTimeCode = getTagCode(TagFromName.RadiopharmaceuticalStartTime);
	public static final String RadionuclideHalfLifeCode = getTagCode(TagFromName.RadionuclideHalfLife);
	public static final String PatientWeightCode = getTagCode(TagFromName.PatientWeight);
	public static final String UnitsCode = getTagCode(TagFromName.Units);
	public static final String SmallestImagePixelValueCode = getTagCode(TagFromName.SmallestImagePixelValue);
	public static final String LargestImagePixelValueCode = getTagCode(TagFromName.LargestImagePixelValue);
	
	//added for pf migration
	public static final String StudyInstanceUIDCode = getTagCode(TagFromName.StudyInstanceUID);
	public static final String SeriesInstanceUIDCode = getTagCode(TagFromName.SeriesInstanceUID);
	public static final String ImagePositionPatientCode = getTagCode(TagFromName.ImagePositionPatient);
	
	
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
			log.info("" + Thread.currentThread().getId() + " Opening Dicom:" + dicomFilePath);
			dis = new DicomInputStream(new FileInputStream(dicomFilePath));
			attributeList.read(dis);
		} finally {
			IOUtils.closeQuietly(dis);
			log.info("" + Thread.currentThread().getId() + " Closed");
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
			log.debug("Number of frames:" + numberOfFrames + " file:" + filePath);
			return numberOfFrames > 1;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean isDicomSR(String filePath)
	{
		try {
			AttributeList list = readAttributeListFromDicomFile(filePath);
			String modality = Attribute.getSingleStringValueOrEmptyString(list, TagFromName.Modality);
			log.info("Modality:" + modality + " file:" + filePath);
			return modality.trim().equals("SR");
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean isDicom(String filePath)
	{
		try {
			AttributeList list = readAttributeListFromDicomFile(filePath);
			if (list!=null && list.size()>0){
				log.info("Can read the attribute list. It is dicom");
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
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

	public static String getTagCode(AttributeTag tag)
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
