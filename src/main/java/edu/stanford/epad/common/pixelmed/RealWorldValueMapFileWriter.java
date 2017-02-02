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

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import com.pixelmed.dicom.Attribute;
import com.pixelmed.dicom.AttributeList;
import com.pixelmed.dicom.AttributeTag;
import com.pixelmed.dicom.CodeStringAttribute;
import com.pixelmed.dicom.CodedSequenceItem;
import com.pixelmed.dicom.CodingSchemeIdentification;
import com.pixelmed.dicom.CompositeInstanceContext;
import com.pixelmed.dicom.DateAttribute;
import com.pixelmed.dicom.DicomDictionary;
import com.pixelmed.dicom.DicomException;
import com.pixelmed.dicom.DicomInputStream;
import com.pixelmed.dicom.FileMetaInformation;
import com.pixelmed.dicom.FloatDoubleAttribute;
import com.pixelmed.dicom.IntegerStringAttribute;
import com.pixelmed.dicom.LongStringAttribute;
import com.pixelmed.dicom.PersonNameAttribute;
import com.pixelmed.dicom.SOPClass;
import com.pixelmed.dicom.SequenceAttribute;
import com.pixelmed.dicom.SequenceItem;
import com.pixelmed.dicom.ShortStringAttribute;
import com.pixelmed.dicom.SignedShortAttribute;
import com.pixelmed.dicom.TagFromName;
import com.pixelmed.dicom.TimeAttribute;
import com.pixelmed.dicom.TransferSyntax;
import com.pixelmed.dicom.UIDGenerator;
import com.pixelmed.dicom.UniqueIdentifierAttribute;
import edu.stanford.epad.common.util.EPADLogger;
import edu.stanford.epad.common.util.EPadWebServerVersion;

/**
 * A class for saving real world value maps.
 * A mixture of segmentation objects writer and insert real world value map in pixelmed
 * 
 * @author Emel Alkim
 * @date 2017-01
 */
public class RealWorldValueMapFileWriter
{
	public static final String Manufacturer = "Stanford University";
	public static final String ManufacturerModelName = "ePAD";
	public static final String DeviceSerialNumber = "SN123456";
	public static final String SoftwareVersion = new EPadWebServerVersion().getVersion();
	public static final String SeriesDescription = "ePAD Generated DSO";
	public static final String prefix = "ePAD DSO";
	public static final String SourceApplicationEntityTitle = "Default title";

	private static final EPADLogger log = EPADLogger.getInstance();

	private final AttributeList list = new AttributeList();
	private final SequenceAttribute segment_sequence = new SequenceAttribute(TagFromName.SegmentSequence);
	private final AttributeList shared_functional_groups_item = new AttributeList();
	private final SequenceAttribute per_frame_functional_groups_sequence = new SequenceAttribute(
			TagFromName.PerFrameFunctionalGroupsSequence);
	private SimpleDateFormat timestamp = new SimpleDateFormat("MMM-dd-HHmm");
	private String seriesUID = null;
	private String imageUID = null;
	
	private final String firstValueMapped, lastValueMapped, intercept, slope, explanation, label, unitsCodeValue, unitsCodingSchemeDesignator, unitsCodingSchemeVersion, unitsCodeMeaning;
	
	//moved declaration from line 521 for slicer per frame
	private String orig_class_uid;
	//moved declaration from line 540 for slicer per frame
	private String[] orig_inst_uids;
	
	
	/**
	 * default values for suv
	 * @param instanceUIDs is the array of instance uids in the series
	 * @param original_attrs_list
	 * @param firstValueMapped
	 * @param lastValueMapped
	 * @param intercept
	 * @param slope
	 * @param explanation
	 * @throws DicomException
	 */
	public RealWorldValueMapFileWriter(String[] instanceUIDs,AttributeList[] original_attrs_list, String firstValueMapped,String lastValueMapped,String intercept,String slope,String explanation) throws DicomException
	{
		this(instanceUIDs,original_attrs_list, firstValueMapped, lastValueMapped, intercept, slope, explanation, "{SUVbw}q/ml}", "{SUVbw}q/ml}","UCUM","","Standardized Uptake Value body weight", null, null, null);
	}
	
	/**
	 * Initialize the list with constant attributes and inherited attributes.
	 * 
	 * @param instanceUIDs is the array of instance uids in the series
	 * @param original_attrs is the whole attributes list.
	 * @param patient_orientation
	 * @param pixel_spacing
	 * @param slice_thickness
	 * @throws DicomException
	 */
	public RealWorldValueMapFileWriter(String[] instanceUIDs,AttributeList[] original_attrs_list, String firstValueMapped,String lastValueMapped,String intercept,String slope,String explanation,String label,String unitsCodeValue,String unitsCodingSchemeDesignator,String unitsCodingSchemeVersion,String unitsCodeMeaning) throws DicomException
	{
		this(instanceUIDs,original_attrs_list, firstValueMapped, lastValueMapped, intercept, slope, explanation, label, unitsCodeValue, unitsCodingSchemeDesignator, unitsCodingSchemeVersion, unitsCodeMeaning, null, null, null);
	}

	/**
	 * Initialize the list with constant attributes and inherited attributes.
	 * 
	 * @param instanceUIDs is the array of instance uids in the series
	 * @param original_attrs is the whole attributes list.
	 * @param patient_orientation
	 * @param pixel_spacing
	 * @param slice_thickness
	 * @throws DicomException
	 */
	public RealWorldValueMapFileWriter(String[] instanceUIDs,AttributeList[] original_attrs_list,String firstValueMapped,String lastValueMapped,String intercept,String slope,String explanation,String label,String unitsCodeValue,String unitsCodingSchemeDesignator,String unitsCodingSchemeVersion,String unitsCodeMeaning, String dsoSeriesDescription, String dsoSeriesUID, String dsoInstanceUID) throws DicomException
	{
		log.info("Generating DICOM attributes for rwvm");
		this.firstValueMapped=firstValueMapped;
		this.lastValueMapped=lastValueMapped;
		this.intercept=intercept;
		this.slope=slope;
		this.explanation =explanation;
		this.label=label;
		this.unitsCodeValue=unitsCodeValue;
		this.unitsCodingSchemeDesignator = unitsCodingSchemeDesignator;
		this.unitsCodingSchemeVersion=unitsCodingSchemeVersion;
		this.unitsCodeMeaning=unitsCodeMeaning;
		
		
		// Temporary
		//dsoSeriesUID = null; // Always create a new Series UID
		//dsoSeriesDescription = null; // Always create a new description
		log.info("Create RWVM, seriesDesc:" + dsoSeriesDescription + " seriesUID:" + dsoSeriesUID);
		if (original_attrs_list == null || original_attrs_list.length == 0)
			throw (new DicomException("The original attributes must not be null!"));
		AttributeList original_attrs = original_attrs_list[0];
		if (original_attrs == null)
			throw (new DicomException("The original attributes must not be null!"));


		/*********************************************************************
		 * Add constant attributes of rwvm objects.
		 *********************************************************************/
		{
			Attribute a = new UniqueIdentifierAttribute(TagFromName.MediaStorageSOPClassUID);
			a.addValue(SOPClass.RealWorldValueMappingStorage);
			list.put(a);
		}
		{
			Attribute a = new UniqueIdentifierAttribute(TagFromName.TransferSyntaxUID);
			a.addValue(TransferSyntax.ExplicitVRLittleEndian);
			list.put(a);
		}
		{
			Attribute a = new UniqueIdentifierAttribute(TagFromName.ImplementationClassUID);
			a.addValue(SOPClass.RealWorldValueMappingStorage);
			list.put(a);
		}
		{
			Attribute a = new UniqueIdentifierAttribute(TagFromName.SOPClassUID);
			a.addValue(SOPClass.RealWorldValueMappingStorage);
			list.put(a);
		}
		{
			Attribute a = new CodeStringAttribute(TagFromName.Modality);
			a.addValue("RWV");
			list.put(a);
		}
		{
			Attribute a = new CodeStringAttribute(TagFromName.ContentLabel);
			a.addValue("RWV");
			list.put(a);
		}


		/*********************************************************************
		 * Other attributes.
		 *********************************************************************/
		{ // Date and time.
			java.util.Date currentDateTime = new java.util.Date();
			String date = new java.text.SimpleDateFormat("yyyyMMdd").format(currentDateTime);
			String time = new java.text.SimpleDateFormat("HHmmss.SSS").format(currentDateTime);
			{
				Attribute a = new DateAttribute(TagFromName.StudyDate);
				a.addValue(date);
				list.put(a);
			}
			
			{
				Attribute a = new DateAttribute(TagFromName.ContentDate);
				a.addValue(date);
				list.put(a);
			}
			{
				Attribute a = new TimeAttribute(TagFromName.StudyTime);
				a.addValue(time);
				list.put(a);
			}
			
			{
				Attribute a = new TimeAttribute(TagFromName.ContentTime);
				a.addValue(time);
				list.put(a);
			}
		}
		
		{
			Attribute a = new ShortStringAttribute(TagFromName.AccessionNumber);
			list.put(a);
		}
//		{
//			Attribute a = new LongStringAttribute(TagFromName.SeriesDescription);
//			if (dsoSeriesDescription == null || dsoSeriesDescription.trim().length() == 0 || dsoSeriesDescription.startsWith(SeriesDescription))
//			{
//				a.addValue(SeriesDescription + " " +  timestamp.format(new Date()));
//			}
//			else	
//			{
//				if (!dsoSeriesDescription.startsWith(prefix))
//					dsoSeriesDescription = prefix + "-" + dsoSeriesDescription;
//				a.addValue(dsoSeriesDescription);
//			}
//			list.put(a);
//		}
		{
			Attribute a = new LongStringAttribute(TagFromName.Manufacturer);
			a.addValue(Manufacturer);
			list.put(a);
		}
		
		{
			Attribute a = new LongStringAttribute(TagFromName.SoftwareVersion);
			a.addValue(SoftwareVersion);
			list.put(a);
		}
		{
			Attribute a = new LongStringAttribute(TagFromName.ContentDescription);
			a.addValue(SeriesDescription);
			list.put(a);
		}
		{
			Attribute a = new PersonNameAttribute(TagFromName.ContentCreatorName);
			a.addValue(ManufacturerModelName + "^" + SoftwareVersion);
			list.put(a);
		}

		UIDGenerator u = new UIDGenerator();
		String study_id = "1"; // Attribute.getSingleStringValueOrEmptyString(original_attrs, TagFromName.StudyID);
		String series_number = "1002"; // for rwvms so that they are different from segmentation // Attribute.getSingleStringValueOrEmptyString(original_attrs,
																		// TagFromName.SeriesNumber);
		String instance_number = "1"; // Attribute.getSingleStringValueOrEmptyString(original_attrs,
																	// TagFromName.InstanceNumber);

		// The following is the original code that generates new series and image UIDs.
		String uid = Attribute.getSingleStringValueOrEmptyString(original_attrs, TagFromName.StudyID);
		{
			Attribute a = new UniqueIdentifierAttribute(TagFromName.StudyInstanceUID);
			a.addValue(u.getNewStudyInstanceUID(study_id));
			list.put(a);
			//does not work. why?
//			a = new UniqueIdentifierAttribute(TagFromName.StudyID);
//			a.addValue(uid);
//			list.put(a);
		}
		{
			uid = u.getNewSeriesInstanceUID(study_id, series_number);
			Attribute a = new UniqueIdentifierAttribute(TagFromName.SeriesInstanceUID);
			if (dsoSeriesUID != null && dsoSeriesUID.trim().length() > 0)
			{
				a.addValue(dsoSeriesUID);
				seriesUID = dsoSeriesUID;
			}
			else
			{
				a.addValue(uid); // Use new uid
				seriesUID = uid;
			}
			list.put(a);
			
		}
		{
			Attribute a = new UniqueIdentifierAttribute(TagFromName.SOPInstanceUID);
			if (dsoInstanceUID != null && dsoInstanceUID.trim().length() > 0)
			{
				a.addValue(dsoInstanceUID);
				imageUID = dsoInstanceUID;
			}
			else
			{
				String instanceUID = u.getNewSOPInstanceUID(study_id, series_number, instance_number);
				a.addValue(instanceUID);
				imageUID = instanceUID;
			}
			list.put(a);
		}

		

		{
			Attribute a = new ShortStringAttribute(TagFromName.StudyID);
			a.addValue(study_id);
			list.put(a);
		}
		{
			Attribute a = new IntegerStringAttribute(TagFromName.SeriesNumber);
			a.addValue(series_number);
			list.put(a);
		}
		{
			Attribute a = new IntegerStringAttribute(TagFromName.InstanceNumber);
			a.addValue(instance_number);
			list.put(a);
		}

		final DicomDictionary dicomDictionary = new DicomDictionary();

		orig_class_uid = Attribute.getSingleStringValueOrEmptyString(original_attrs, TagFromName.SOPClassUID);

		for (AttributeTag key : original_attrs.keySet()) {
			log.debug("ATTRIBUTE TAG: " + key);
			log.debug("ATTRIBUTE NAME " + dicomDictionary.getFullNameFromTag(key));
			log.debug("VALUE " + original_attrs.get(key));
		}

		
		SequenceAttribute referencedSeriesSequence = new SequenceAttribute(TagFromName.ReferencedSeriesSequence);
		AttributeList referencedSeriesSequenceAttributes = new AttributeList();
		
		{
			Attribute siu = new UniqueIdentifierAttribute(TagFromName.SeriesInstanceUID);
			String origSeriesInstanceUid = Attribute.getSingleStringValueOrEmptyString(original_attrs, TagFromName.SeriesInstanceUID);
			siu.addValue(origSeriesInstanceUid);
			referencedSeriesSequenceAttributes.put(siu);
		
			
		}
		

		//TODO we need to put all the instances, not just one. should this get a series instead of an instance?
		
		SequenceAttribute referencedInstanceSequence = new SequenceAttribute(TagFromName.ReferencedInstanceSequence);
		if (instanceUIDs==null) {
			orig_inst_uids = new String[original_attrs_list.length];
			for (int instanceIndex = 0; instanceIndex < original_attrs_list.length; instanceIndex++) {
				AttributeList referencedInstanceSequenceAttributes = new AttributeList();
				{
					Attribute a = new UniqueIdentifierAttribute(TagFromName.ReferencedSOPClassUID);
					a.addValue(orig_class_uid);
					referencedInstanceSequenceAttributes.put(a);
				}
				{
					Attribute a = new UniqueIdentifierAttribute(TagFromName.ReferencedSOPInstanceUID);
					String orig_inst_uid = Attribute.getSingleStringValueOrEmptyString(original_attrs_list[instanceIndex], TagFromName.SOPInstanceUID);
					//log.info("" + instanceIndex + " ReferencedSOPInstanceUID:" + orig_inst_uid);
					orig_inst_uids[instanceIndex] = orig_inst_uid;
					
					
					a.addValue(orig_inst_uid);
					referencedInstanceSequenceAttributes.put(a);
				}
				// Need this for multiframe source DICOM
	//			{
	//				Attribute a = new UniqueIdentifierAttribute(TagFromName.ReferencedFrameNumber);
	//				a.addValue(0);
	//				referencedInstanceSequenceAttributes.put(a);
	//			}
				referencedInstanceSequence.addItem(referencedInstanceSequenceAttributes);
			}
		}else { //use the sent list
			orig_inst_uids = instanceUIDs.clone(); //in case we use it elsewhere
			for (int instanceIndex = 0; instanceIndex < orig_inst_uids.length; instanceIndex++) {
				AttributeList referencedInstanceSequenceAttributes = new AttributeList();
				{
					Attribute a = new UniqueIdentifierAttribute(TagFromName.ReferencedSOPClassUID);
					a.addValue(orig_class_uid);
					referencedInstanceSequenceAttributes.put(a);
				}
				{
					Attribute a = new UniqueIdentifierAttribute(TagFromName.ReferencedSOPInstanceUID);
					a.addValue(orig_inst_uids[0]);
					referencedInstanceSequenceAttributes.put(a);
				}
				referencedInstanceSequence.addItem(referencedInstanceSequenceAttributes);
			}
		}
		referencedSeriesSequenceAttributes.put(referencedInstanceSequence);
		referencedSeriesSequence.addItem(referencedSeriesSequenceAttributes);

		list.put(referencedSeriesSequence);

		// Add meta information header.
//		FileMetaInformation.addFileMetaInformation(list, TransferSyntax.ExplicitVRLittleEndian,
//				SourceApplicationEntityTitle);

		/*********************************************************************
		 * Extract attributes from the original attributes list.
		 *********************************************************************/
		@SuppressWarnings("deprecation")
		CompositeInstanceContext cic = new CompositeInstanceContext(original_attrs);
		cic.removeInstance();
		cic.removeSeries();
		cic.removeEquipment();
		list.putAll(cic.getAttributeList());
		list.remove(TagFromName.ClinicalTrialSiteID);
		list.remove(TagFromName.ClinicalTrialSubjectID);
		list.remove(TagFromName.SliceThickness); // Not useful per Andriy, Sandy,  Clunie
	

		
		insertRWVM2AttrList();
		
	
	}

	
	public void insertRWVM2AttrList() throws DicomException{
		AttributeList listToAddRealWorldValueMappingSequenceTo = list;
		{
			SequenceAttribute aSharedFunctionalGroupsSequence = (SequenceAttribute)list.get(TagFromName.SharedFunctionalGroupsSequence);
			if (aSharedFunctionalGroupsSequence != null) {
				// assert aSharedFunctionalGroupsSequence.getNumberOfItems() == 1
				Iterator sitems = aSharedFunctionalGroupsSequence.iterator();
				if (sitems.hasNext()) {
					SequenceItem sitem = (SequenceItem)sitems.next();
					AttributeList slist = sitem.getAttributeList();
					if (slist != null) {
						listToAddRealWorldValueMappingSequenceTo = slist;
					}
				}
			}
		}
	
		// reuse (add to) existing sequence if present
		SequenceAttribute aReferencedRealWorldValueMappingSequence = (SequenceAttribute)(list.get(TagFromName.ReferencedImageRealWorldValueMappingSequence));
		if (aReferencedRealWorldValueMappingSequence == null) {
			aReferencedRealWorldValueMappingSequence = new SequenceAttribute(TagFromName.ReferencedImageRealWorldValueMappingSequence);
			listToAddRealWorldValueMappingSequenceTo.put(aReferencedRealWorldValueMappingSequence);
		}
		
		AttributeList rwvmReferenceList = new AttributeList();
		aReferencedRealWorldValueMappingSequence.addItem(rwvmReferenceList);
		
		// reuse (add to) existing sequence if present
		SequenceAttribute aRealWorldValueMappingSequence = (SequenceAttribute)(list.get(TagFromName.RealWorldValueMappingSequence));
		if (aRealWorldValueMappingSequence == null) {
			aRealWorldValueMappingSequence = new SequenceAttribute(TagFromName.RealWorldValueMappingSequence);
			rwvmReferenceList.put(aRealWorldValueMappingSequence);
		}
		
		SequenceAttribute referencedImageSequence = new SequenceAttribute(TagFromName.ReferencedImageSequence);
		
		for (int instanceIndex = 0; instanceIndex < orig_inst_uids.length; instanceIndex++) {
			AttributeList referencedImageSequenceAttributes = new AttributeList();
			{
				Attribute a = new UniqueIdentifierAttribute(TagFromName.ReferencedSOPClassUID);
				a.addValue(orig_class_uid);
				referencedImageSequenceAttributes.put(a);
			}
			{
				Attribute a = new UniqueIdentifierAttribute(TagFromName.ReferencedSOPInstanceUID);
				a.addValue(orig_inst_uids[0]);
				referencedImageSequenceAttributes.put(a);
			}
			referencedImageSequence.addItem(referencedImageSequenceAttributes);
		}
		rwvmReferenceList.put(referencedImageSequence);
		

		AttributeList rwvmList = new AttributeList();
		aRealWorldValueMappingSequence.addItem(rwvmList);
		
		// should we be checking the value that are supplied to see if they are signed, or using the signedness of the list that we are adding to ?
		
		boolean signed = Attribute.getSingleIntegerValueOrDefault(list,TagFromName.PixelRepresentation,0) == 1;
		if (signed) {
			{ Attribute a = new SignedShortAttribute(TagFromName.RealWorldValueFirstValueMapped); a.addValue(firstValueMapped); rwvmList.put(a); }
			{ Attribute a = new SignedShortAttribute(TagFromName.RealWorldValueLastValueMapped ); a.addValue(lastValueMapped ); rwvmList.put(a); }
		}
		else {
			{ Attribute a = new SignedShortAttribute(TagFromName.RealWorldValueFirstValueMapped); a.addValue(firstValueMapped); rwvmList.put(a); }
			{ Attribute a = new SignedShortAttribute(TagFromName.RealWorldValueLastValueMapped ); a.addValue(lastValueMapped ); rwvmList.put(a); }
		}

		{ Attribute a = new FloatDoubleAttribute(TagFromName.RealWorldValueIntercept); a.addValue(intercept); rwvmList.put(a); }
		{ Attribute a = new FloatDoubleAttribute(TagFromName.RealWorldValueSlope); a.addValue(slope); rwvmList.put(a); }
		
		{ Attribute a = new LongStringAttribute(TagFromName.LUTExplanation); a.addValue(explanation); rwvmList.put(a); }
		{ Attribute a = new ShortStringAttribute(TagFromName.LUTLabel); a.addValue(label); rwvmList.put(a); }
	
		{
			CodedSequenceItem item = null;
			if (unitsCodingSchemeVersion == null || unitsCodingSchemeVersion.trim().length() == 0) {
				item = new CodedSequenceItem(unitsCodeValue,unitsCodingSchemeDesignator,unitsCodeMeaning);
			}
			else {
				item = new CodedSequenceItem(unitsCodeValue,unitsCodingSchemeDesignator,unitsCodingSchemeVersion,unitsCodeMeaning);
			}
			if (item != null) {
				AttributeList itemList = item.getAttributeList();
				if (itemList != null) {
					{ SequenceAttribute a = new SequenceAttribute(TagFromName.MeasurementUnitsCodeSequence); a.addItem(itemList); rwvmList.put(a); }
				}
			}
		}
		
		
		CodingSchemeIdentification.replaceCodingSchemeIdentificationSequenceWithCodingSchemesUsedInAttributeList(list);
		
		// do NOT set to derived and replace UID
		// do not addContributingEquipmentSequence
										
		list.removeGroupLengthAttributes();
		list.removeMetaInformationHeaderAttributes();
		list.removePrivateAttributes();
		SequenceAttribute performedProcedureSequence = (SequenceAttribute)(list.get(TagFromName.PerformedProcedureCodeSequence));
		if (performedProcedureSequence != null) {
			performedProcedureSequence.removeValues();
			list.remove(performedProcedureSequence.getTag());
			
		}
		SequenceAttribute procedureSequence = (SequenceAttribute)(list.get(TagFromName.ProcedureCodeSequence));
		if (procedureSequence != null) {
			procedureSequence.removeValues();
			list.remove(procedureSequence.getTag());
		}
		list.remove(TagFromName.FrameOfReferenceUID);
		list.remove(TagFromName.PositionReferenceIndicator);
		list.remove(TagFromName.DataSetTrailingPadding);
		
		String ourAETitle = "OURAETITLE";
		FileMetaInformation.addFileMetaInformation(list,TransferSyntax.ExplicitVRLittleEndian,ourAETitle);
		
//		String sopInstanceUID = Attribute.getSingleStringValueOrEmptyString(list,TagFromName.SOPInstanceUID);	// will be the same SOP Instance UID since not replaced as derived
//		File dstFile = new File(dstFolderName,sopInstanceUID+".dcm");
//		list.write(dstFile,TransferSyntax.ExplicitVRLittleEndian,true,true);
	}
	

	/**
	 * Finally save the information to a DICOM file.
	 * 
	 * @param Name of the DICOM file.
	 * @throws DicomException
	 * @throws IOException
	 */
	public void saveDicomFile(String file_name) throws IOException, DicomException
	{
		
		
//		// Combine attributes that can be shared.
//		combine_shared_attributes(shared_functional_groups_item, per_frame_functional_groups_sequence);
//		// Add object Shared Functional Groups Sequence.
//		SequenceAttribute shared_functional_groups_sequence = new SequenceAttribute(
//				TagFromName.SharedFunctionalGroupsSequence);
//		shared_functional_groups_sequence.addItem(shared_functional_groups_item);
//		list.put(TagFromName.SharedFunctionalGroupsSequence, shared_functional_groups_sequence);
//		// Add object Per-frame Functional Groups Sequence.
//		list.put(TagFromName.PerFrameFunctionalGroupsSequence, per_frame_functional_groups_sequence);

		// Save the whole list.
		list.write(file_name, TransferSyntax.ExplicitVRLittleEndian, true, true);
		
	}

	/**
	 * This demo gets a dicom image and creates a rwvm using image file's tags.
	 * 
	 * @param args: java RealWorldValueMapFileWriter dicom_file output_file min max intercept slope 
	 */
	public static void main(String[] args)
	{
		String input_file = args[0];// "./DicomFiles/CT0010";//
		String output_file = args[1];// "./TEMP/CT0010.sobin";//"rwvm_test_out.dcm";
		String min = args[2];
		String max = args[3];
		String intercept = args[4];
		String slope = args[5];
		
		byte[] pixels = null;
		RealWorldValueMapFileWriter obj = null;
		
		try {
			DicomInputStream i_stream = new DicomInputStream(new FileInputStream(input_file));
			AttributeList list = new AttributeList();
			list.read(i_stream);
			
			AttributeList[] lists = new AttributeList[1];
			lists[0] = list;
			obj = new RealWorldValueMapFileWriter(new String[]{"1.3.6.1.4.1.14519.5.2.1.2744.7002.463147699317075738502572594868","1.3.6.1.4.1.14519.5.2.1.2744.7002.227680709104748625337095358807","1.3.6.1.4.1.14519.5.2.1.2744.7002.112252575599131280286405914020"},lists,"0" ,"32761","0","0.000375","SUV calculated by ePAD","{SUVbw}q/ml}", "{SUVbw}q/ml}","UCUM","","Standardized Uptake Value body weight");
//			obj = new RealWorldValueMapFileWriter(lists,min ,max,intercept,slope,"SUV calculated by ePAD","", "126401","DCM","","SUVbw");

			
			obj.saveDicomFile(output_file);

		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace(System.err);
			System.exit(0);
		}
	}

	public String getSeriesUID() {
		return seriesUID;
	}

	public void setSeriesUID(String seriesUID) {
		this.seriesUID = seriesUID;
	}

	public String getImageUID() {
		return imageUID;
	}

	public void setImageUID(String imageUID) {
		this.imageUID = imageUID;
	}

}