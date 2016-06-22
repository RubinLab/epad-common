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

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.commons.io.IOUtils;

import com.pixelmed.anatproc.CodedConcept;
import com.pixelmed.dicom.Attribute;
import com.pixelmed.dicom.AttributeList;
import com.pixelmed.dicom.AttributeTag;
import com.pixelmed.dicom.AttributeTagAttribute;
import com.pixelmed.dicom.CodeStringAttribute;
import com.pixelmed.dicom.CompositeInstanceContext;
import com.pixelmed.dicom.DateAttribute;
import com.pixelmed.dicom.DecimalStringAttribute;
import com.pixelmed.dicom.DicomDictionary;
import com.pixelmed.dicom.DicomException;
import com.pixelmed.dicom.DicomInputStream;
import com.pixelmed.dicom.DicomOutputStream;
import com.pixelmed.dicom.FileMetaInformation;
import com.pixelmed.dicom.GeometryOfSliceFromAttributeList;
import com.pixelmed.dicom.IntegerStringAttribute;
import com.pixelmed.dicom.LongStringAttribute;
import com.pixelmed.dicom.OtherByteAttribute;
import com.pixelmed.dicom.OtherByteAttributeOnDisk;
import com.pixelmed.dicom.PersonNameAttribute;
import com.pixelmed.dicom.SOPClass;
import com.pixelmed.dicom.SequenceAttribute;
import com.pixelmed.dicom.SequenceItem;
import com.pixelmed.dicom.ShortStringAttribute;
import com.pixelmed.dicom.ShortTextAttribute;
import com.pixelmed.dicom.TagFromName;
import com.pixelmed.dicom.TimeAttribute;
import com.pixelmed.dicom.TransferSyntax;
import com.pixelmed.dicom.UIDGenerator;
import com.pixelmed.dicom.UniqueIdentifierAttribute;
import com.pixelmed.dicom.UnsignedLongAttribute;
import com.pixelmed.dicom.UnsignedShortAttribute;
import com.pixelmed.dicom.VersionAndConstants;
import com.pixelmed.geometry.GeometryOfSlice;
import com.pixelmed.utils.CopyStream;

import edu.stanford.epad.common.util.EPADLogger;

/**
 * A class for saving segmentation results.
 * 
 * @author Wei Lu (luwei@tju.edu.cn)
 * @date 2012-12
 */
public class SegmentationObjectsFileWriter
{
	public static final String Manufacturer = "Stanford University";
	public static final String ManufacturerModelName = "ePAD";
	public static final String DeviceSerialNumber = "SN123456";
	public static final String SoftwareVersion = "2.0.1";
	public static final String SeriesDescription = "ePAD Generated DSO";
	public static final String prefix = "ePAD DSO";
	public static final String SourceApplicationEntityTitle = "Default title";

	private static final EPADLogger log = EPADLogger.getInstance();

	private final AttributeList list = new AttributeList();
	private AttributeList geometry_list = new AttributeList();
	private final SequenceAttribute segment_sequence = new SequenceAttribute(TagFromName.SegmentSequence);
	private final AttributeList shared_functional_groups_item = new AttributeList();
	private final SequenceAttribute per_frame_functional_groups_sequence = new SequenceAttribute(
			TagFromName.PerFrameFunctionalGroupsSequence);
	private final Attribute pixel_data = new OtherByteAttribute(TagFromName.PixelData);;
	private int current_segment = 0;
	private int frame_counter = 0;
	private boolean use_temp_file = false;
	private String temp_file = "temp_pixel_data_file.tmp"; // Will be renamed to a unique value per instance.
	private SimpleDateFormat timestamp = new SimpleDateFormat("MMM-dd-HHmm");
	private String seriesUID = null;
	private String imageUID = null;
	
	//moved declaration from line 521 for slicer per frame
	private String orig_class_uid;
	//moved declaration from line 540 for slicer per frame
	private String[] orig_inst_uids;
	//added for slicer positions per frame
	private double[][] seg_positions;
	
	/**
	 * Initialize the list with constant attributes and inherited attributes.
	 * 
	 * @param original_attrs is the whole attributes list.
	 * @param patient_orientation
	 * @param pixel_spacing
	 * @param slice_thickness
	 * @throws DicomException
	 */
	public SegmentationObjectsFileWriter(AttributeList[] original_attrs_list, short[] patient_orientation,
			double[] pixel_spacing, double slice_thickness) throws DicomException
	{
		this(original_attrs_list, patient_orientation, pixel_spacing, slice_thickness, null, null, null);
	}

	/**
	 * Initialize the list with constant attributes and inherited attributes.
	 * 
	 * @param original_attrs is the whole attributes list.
	 * @param patient_orientation
	 * @param pixel_spacing
	 * @param slice_thickness
	 * @throws DicomException
	 */
	public SegmentationObjectsFileWriter(AttributeList[] original_attrs_list, short[] patient_orientation,
			double[] pixel_spacing, double slice_thickness, String dsoSeriesDescription, String dsoSeriesUID, String dsoInstanceUID) throws DicomException
	{
		log.info("Generating DICOM attributes for DSO");
		// Temporary
		//dsoSeriesUID = null; // Always create a new Series UID
		//dsoSeriesDescription = null; // Always create a new description
		log.info("Create DSO, seriesDesc:" + dsoSeriesDescription + " seriesUID:" + dsoSeriesUID);
		if (original_attrs_list == null || original_attrs_list.length == 0)
			throw (new DicomException("The original attributes must not be null!"));
		AttributeList original_attrs = original_attrs_list[0];
		/*********************************************************************
		 * Generate a unique name for the temporary pixel data file.
		 *********************************************************************/
		{
			int rand = (int)(Math.random() * Integer.MAX_VALUE);
			temp_file = Integer.toString(rand) + ".tmp"; // temp_file has a unique name.
		}

		if (original_attrs == null)
			throw (new DicomException("The original attributes must not be null!"));

		if (patient_orientation == null || patient_orientation.length != 6)
			throw (new DicomException("Invalid patient orientation!"));

		if (pixel_spacing == null || pixel_spacing.length != 2)
			throw (new DicomException("Invalid pixel spacing!"));

		if (slice_thickness <= 0)
			throw (new DicomException("Invalid slice thickness!"));

		/*********************************************************************
		 * Save the geometric attributes to geometry_list. 
		 *********************************************************************/
		{
			Attribute a = new DecimalStringAttribute(TagFromName.ImageOrientationPatient); 
			for(int i = 0; i < patient_orientation.length; i++)
				a.addValue(patient_orientation[i]);
			geometry_list.put(a);
			Attribute spacing = new DecimalStringAttribute(TagFromName.PixelSpacing); spacing.addValue(pixel_spacing[0]); spacing.addValue(pixel_spacing[1]);
			Attribute thickness = new DecimalStringAttribute(TagFromName.SliceThickness); thickness.addValue(slice_thickness);
			geometry_list.put(spacing);
			geometry_list.put(thickness);
		}

		/*********************************************************************
		 * Add constant attributes of segmentation objects.
		 *********************************************************************/
		{
			Attribute a = new UniqueIdentifierAttribute(TagFromName.MediaStorageSOPClassUID);
			a.addValue(SOPClass.SegmentationStorage);
			list.put(a);
		}
		{
			Attribute a = new UniqueIdentifierAttribute(TagFromName.TransferSyntaxUID);
			a.addValue(TransferSyntax.ExplicitVRLittleEndian);
			list.put(a);
		}
		{
			Attribute a = new UniqueIdentifierAttribute(TagFromName.ImplementationClassUID);
			a.addValue(SOPClass.SegmentationStorage);
			list.put(a);
		}
		{
			Attribute a = new UniqueIdentifierAttribute(TagFromName.SOPClassUID);
			a.addValue(SOPClass.SegmentationStorage);
			list.put(a);
		}
		{
			Attribute a = new CodeStringAttribute(TagFromName.Modality);
			a.addValue("SEG");
			list.put(a);
		}
		{
			Attribute a = new CodeStringAttribute(TagFromName.ContentLabel);
			a.addValue("ROI");
			list.put(a);
		}
		{
			Attribute a = new UnsignedShortAttribute(TagFromName.SamplesPerPixel);
			a.addValue(1);
			list.put(a);
		}
		{
			Attribute a = new CodeStringAttribute(TagFromName.PhotometricInterpretation);
			a.addValue("MONOCHROME2");
			list.put(a);
		}
		{
			Attribute a = new CodeStringAttribute(TagFromName.ImageType);
			a.addValue("DERIVED");
			a.addValue("PRIMARY");
			list.put(a);
		}
		{
			Attribute a = new UnsignedShortAttribute(TagFromName.PixelRepresentation);
			a.addValue(0);
			list.put(a);
		}
		{
			Attribute a = new CodeStringAttribute(TagFromName.LossyImageCompression);
			a.addValue("00");
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
				Attribute a = new DateAttribute(TagFromName.SeriesDate);
				a.addValue(date);
				list.put(a);
			}
			{
				Attribute a = new DateAttribute(TagFromName.AcquisitionDate);
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
				Attribute a = new TimeAttribute(TagFromName.SeriesTime);
				a.addValue(time);
				list.put(a);
			}
			{
				Attribute a = new TimeAttribute(TagFromName.AcquisitionTime);
				a.addValue(time);
				list.put(a);
			}
			{
				Attribute a = new TimeAttribute(TagFromName.ContentTime);
				a.addValue(time);
				list.put(a);
			}
		}
		// Device specific information.
		{
			Attribute a = new UniqueIdentifierAttribute(TagFromName.InstanceCreatorUID);
			a.addValue(VersionAndConstants.instanceCreatorUID);
			list.put(a);
		}
		{
			Attribute a = new ShortStringAttribute(TagFromName.AccessionNumber);
			list.put(a);
		}
		{
			Attribute a = new LongStringAttribute(TagFromName.SeriesDescription);
			if (dsoSeriesDescription == null || dsoSeriesDescription.trim().length() == 0 || dsoSeriesDescription.startsWith(SeriesDescription))
			{
				a.addValue(SeriesDescription + " " +  timestamp.format(new Date()));
			}
			else	
			{
				if (!dsoSeriesDescription.startsWith(prefix))
					dsoSeriesDescription = prefix + "-" + dsoSeriesDescription;
				a.addValue(dsoSeriesDescription);
			}
			list.put(a);
		}
		{
			Attribute a = new LongStringAttribute(TagFromName.Manufacturer);
			a.addValue(Manufacturer);
			list.put(a);
		}
		{
			Attribute a = new LongStringAttribute(TagFromName.ManufacturerModelName);
			a.addValue(ManufacturerModelName);
			list.put(a);
		}
		{
			Attribute a = new LongStringAttribute(TagFromName.DeviceSerialNumber);
			a.addValue(DeviceSerialNumber);
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
		String series_number = "1000"; // Attribute.getSingleStringValueOrEmptyString(original_attrs,
																		// TagFromName.SeriesNumber);
		String instance_number = "1"; // Attribute.getSingleStringValueOrEmptyString(original_attrs,
																	// TagFromName.InstanceNumber);

		// The following is the original code that generates new series and image UIDs.
		String uid = Attribute.getSingleStringValueOrEmptyString(original_attrs, TagFromName.StudyID);
		{
			Attribute a = new UniqueIdentifierAttribute(TagFromName.StudyInstanceUID);
			a.addValue(u.getNewStudyInstanceUID(study_id));
			list.put(a);
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
			a = new UniqueIdentifierAttribute(TagFromName.FrameOfReferenceUID);
			a.addValue(uid);
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

		// If we want to generate a DSO with the same study.series/image UID we copy the original UID attributes.
		// String study_uid = Attribute.getSingleStringValueOrEmptyString(original_attrs, TagFromName.StudyInstanceUID);
		// String series_uid = Attribute.getSingleStringValueOrEmptyString(original_attrs, TagFromName.SeriesInstanceUID);
		// String image_uid = Attribute.getSingleStringValueOrEmptyString(original_attrs, TagFromName.SOPInstanceUID);
		// {
		// Attribute a = new UniqueIdentifierAttribute(TagFromName.StudyInstanceUID);
		// a.addValue(study_uid);
		// list.put(a);
		// }
		// {
		// Attribute a = new UniqueIdentifierAttribute(TagFromName.SeriesInstanceUID);
		// a.addValue(series_uid);
		// list.put(a);
		// }
		// {
		// Attribute a = new UniqueIdentifierAttribute(TagFromName.SOPInstanceUID);
		// a.addValue(image_uid);
		// list.put(a);
		// }

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

		SequenceAttribute referencedInstanceSequence = new SequenceAttribute(TagFromName.ReferencedInstanceSequence);
		seg_positions = new double[original_attrs_list.length][3];
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
				
				//get positions for segmentation frames
				seg_positions[instanceIndex] = Attribute.getDoubleValues(original_attrs_list[instanceIndex], TagFromName.ImagePositionPatient);
						
				
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
		referencedSeriesSequenceAttributes.put(referencedInstanceSequence);
		referencedSeriesSequence.addItem(referencedSeriesSequenceAttributes);

		list.put(referencedSeriesSequence);

		// Add meta information header.
		FileMetaInformation.addFileMetaInformation(list, TransferSyntax.ExplicitVRLittleEndian,
				SourceApplicationEntityTitle);

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
		
		{ // Define dimensions as (stack id, in-stack position, segment number).
			SequenceAttribute seq = new SequenceAttribute(TagFromName.DimensionOrganizationSequence);
			AttributeList a = SequenceAttribute.getAttributeListFromWithinSequenceWithSingleItem(original_attrs,
					TagFromName.DimensionOrganizationSequence);
			Attribute org_uid = new UniqueIdentifierAttribute(TagFromName.DimensionOrganizationUID);
			if (a == null) {
				a = new AttributeList();
				org_uid.addValue(u.getNewUID());
				a.put(org_uid);
			} else {
				org_uid
						.addValue(Attribute.getSingleStringValueOrDefault(a, TagFromName.DimensionOrganizationUID, u.getNewUID()));
			}
			seq.addItem(a);
			list.put(seq);

			seq = new SequenceAttribute(TagFromName.DimensionIndexSequence);
			a = SequenceAttribute.getAttributeListFromWithinSequenceWithSingleItem(original_attrs,
					TagFromName.DimensionIndexSequence);
			if (a == null) {
				a = new AttributeList();
				a.put(org_uid);
				AttributeTagAttribute t = new AttributeTagAttribute(TagFromName.DimensionIndexPointer);
				t.addValue(0x0020, 0x9056); // Stack ID as a dimension
				a.put(t);
				t = new AttributeTagAttribute(TagFromName.FunctionalGroupPointer);
				t.addValue(0x0020, 0x9111); // Frame Content Sequence
				a.put(t);
				LongStringAttribute lo = new LongStringAttribute(TagFromName.DimensionDescriptionLabel);
				lo.addValue("Stack ID");
				a.put(t);
				seq.addItem(a);

				a = new AttributeList();
				a.put(org_uid);
				t = new AttributeTagAttribute(TagFromName.DimensionIndexPointer);
				t.addValue(0x0020, 0x9057); // In-Stack Position Number as a dimension
				a.put(t);
				t = new AttributeTagAttribute(TagFromName.FunctionalGroupPointer);
				t.addValue(0x0020, 0x9111); // Frame Content Sequence
				a.put(t);
				lo = new LongStringAttribute(TagFromName.DimensionDescriptionLabel);
				lo.addValue("In-Stack Position Number");
				a.put(t);
				seq.addItem(a);

				/*
				 * Temporal dimension is rarely used, so it is not supported here. a = new AttributeList(); a.put(org_uid); t =
				 * new AttributeTagAttribute(TagFromName.DimensionIndexPointer); t.addValue(0x0020, 0x9128); // Temporal
				 * Position Index as a dimension a.put(t); t= new AttributeTagAttribute(TagFromName.FunctionalGroupPointer);
				 * t.addValue(0x0020, 0x9111); // Frame Content Sequence a.put(t); lo = new
				 * LongStringAttribute(TagFromName.DimensionDescriptionLabel); lo.addValue("Temporal Position Index"); a.put(t);
				 * seq.addItem(a);
				 */

				a = new AttributeList();
				a.put(org_uid);
				t = new AttributeTagAttribute(TagFromName.DimensionIndexPointer);
				t.addValue(0x0062, 0x000b); // Referenced Segment Number as a dimension
				a.put(t);
				t = new AttributeTagAttribute(TagFromName.FunctionalGroupPointer);
				t.addValue(0x0062, 0x000a); // Segment Identification Sequence
				a.put(t);
				lo = new LongStringAttribute(TagFromName.DimensionDescriptionLabel);
				lo.addValue("Referenced Segment Number");
				a.put(t);
				seq.addItem(a);
			} else {
				seq.addItem(a);
			}
			list.put(seq);
		}

		// Attributes below are not mandatory, so special check needs to be done.
		{
			String temp = Attribute.getSingleStringValueOrEmptyString(original_attrs, TagFromName.PositionReferenceIndicator);
			Attribute a = new LongStringAttribute(TagFromName.PositionReferenceIndicator);
			a.addValue(temp);
			list.put(a);
		}

		// Following attributes are inherited.

		// Generate Shared Functional Groups Sequence
		{ // DerivationImageSequence - TODO - Need to verify if this is correct???
			SequenceAttribute derivation_image_seq = new SequenceAttribute(TagFromName.DerivationImageSequence);
			AttributeList reference = new AttributeList();
			{
				AttributeList item = new AttributeList();
				{
					Attribute a = new ShortStringAttribute(TagFromName.CodeValue);
					a.addValue("113076");
					item.put(a);
				}
				{
					Attribute a = new ShortStringAttribute(TagFromName.CodingSchemeDesignator);
					a.addValue("DCM");
					item.put(a);
				}
				{
					Attribute a = new LongStringAttribute(TagFromName.CodeMeaning);
					a.addValue("Segmentation");
					item.put(a);
				}
				SequenceAttribute seq = new SequenceAttribute(TagFromName.DerivationCodeSequence);
				seq.addItem(item);
				reference.put(seq);
			}
			SequenceAttribute source_image_seq = new SequenceAttribute(TagFromName.SourceImageSequence);
			for (int i = 0; i < orig_inst_uids.length; i++)
			{ // SourceImageSequence
				AttributeList image = new AttributeList();
				AttributeList item = new AttributeList();
				{
					Attribute a = new ShortStringAttribute(TagFromName.CodeValue);
					a.addValue("121322");
					item.put(a);
				}
				{
					Attribute a = new ShortStringAttribute(TagFromName.CodingSchemeDesignator);
					a.addValue("DCM");
					item.put(a);
				}
				{
					Attribute a = new LongStringAttribute(TagFromName.CodeMeaning);
					a.addValue("Source image for image processing operation");
					item.put(a);
				}
				SequenceAttribute seq = new SequenceAttribute(TagFromName.PurposeOfReferenceCodeSequence);
				seq.addItem(item);
				image.put(seq);
				{
					Attribute a = new UniqueIdentifierAttribute(TagFromName.ReferencedSOPClassUID);
					a.addValue(orig_class_uid);
					image.put(a);
				}
				{
					//log.info("SourceImageSequence:" + i + " ReferencedSOPInstanceUID:" + orig_inst_uids[i]);
					Attribute a = new UniqueIdentifierAttribute(TagFromName.ReferencedSOPInstanceUID);
					a.addValue(orig_inst_uids[i]);
					image.put(a);
				}
				// Need this for multiframe source DICOM???
				{
					Attribute a = new IntegerStringAttribute(TagFromName.ReferencedFrameNumber);
					a.addValue("1");
					image.put(a);
				}
				source_image_seq.addItem(image);
			}
			reference.put(source_image_seq);
			derivation_image_seq.addItem(reference);
			shared_functional_groups_item.put(derivation_image_seq);
		}
		{ // PlaneOrientationSequence
			SequenceAttribute plane_orientation_seq = new SequenceAttribute(TagFromName.PlaneOrientationSequence);
			AttributeList item = new AttributeList();
			Attribute a = new DecimalStringAttribute(TagFromName.ImageOrientationPatient);
			for (int i = 0; i < patient_orientation.length; i++)
				a.addValue(patient_orientation[i]);
			item.put(a);
			plane_orientation_seq.addItem(item);
			shared_functional_groups_item.put(plane_orientation_seq);
		}
		{ // PixelMeasuresSequence
			SequenceAttribute pixel_measures_seq = new SequenceAttribute(TagFromName.PixelMeasuresSequence);
			AttributeList item = new AttributeList();
			Attribute spacing = new DecimalStringAttribute(TagFromName.PixelSpacing);
			spacing.addValue(pixel_spacing[0]);
			spacing.addValue(pixel_spacing[1]);
			Attribute thickness = new DecimalStringAttribute(TagFromName.SliceThickness);
			thickness.addValue(slice_thickness);
			item.put(spacing);
			item.put(thickness);
			pixel_measures_seq.addItem(item);
			shared_functional_groups_item.put(pixel_measures_seq);
		}
	}

	/**
	 * Add a segment.
	 * 
	 * @param description is the user defined string which may be the purpose of segmenting.
	 * @param category should be a value defined in future SegmentationPropertyCategories.
	 * @param type should be a value defined in future SegmentationPropertyTypes.
	 * @throws DicomException
	 */
	public void addOneSegment(String description, CodedConcept category, CodedConcept type) throws DicomException
	{
		// Validate the parameters.
		current_segment++;

		if (description == null) {
			description = "Segment No." + Integer.toString(current_segment);
		}

		// SegmentSequence attribute
		AttributeList list = new AttributeList();
		{
			Attribute a = new UnsignedShortAttribute(TagFromName.SegmentNumber);
			a.addValue(current_segment);
			list.put(a);
		}
		{
			Attribute a = new ShortTextAttribute(TagFromName.SegmentDescription);
			a.addValue(description);
			list.put(a);
		}
		{
			String[] context = parse_context(type);
			Attribute a = new LongStringAttribute(TagFromName.SegmentLabel);
			a.addValue(context[2]);
			list.put(a);
		}
		{
			Attribute a = new CodeStringAttribute(TagFromName.SegmentAlgorithmType);
			a.addValue("SEMIAUTOMATIC");
			list.put(a);
		}
		{
			Attribute a = new LongStringAttribute(TagFromName.SegmentAlgorithmName);
			a.addValue(ManufacturerModelName + SoftwareVersion);
			list.put(a);
		}
		{
			String[] context = parse_context(category);
			AttributeList item = new AttributeList();
			{
				Attribute a = new ShortStringAttribute(TagFromName.CodingSchemeDesignator);
				a.addValue(context[0]);
				item.put(a);
			}
			{
				Attribute a = new ShortStringAttribute(TagFromName.CodeValue);
				a.addValue(context[1]);
				item.put(a);
			}
			{
				Attribute a = new LongStringAttribute(TagFromName.CodeMeaning);
				a.addValue(context[2]);
				item.put(a);
			}
			SequenceAttribute seq = new SequenceAttribute(TagFromName.AnatomicRegionSequence);
			seq.addItem(item);
			list.put(seq);
		}
		{
			String[] context = parse_context(category);
			AttributeList item = new AttributeList();
			{
				Attribute a = new ShortStringAttribute(TagFromName.CodingSchemeDesignator);
				a.addValue(context[0]);
				item.put(a);
			}
			{
				Attribute a = new ShortStringAttribute(TagFromName.CodeValue);
				a.addValue(context[1]);
				item.put(a);
			}
			{
				Attribute a = new LongStringAttribute(TagFromName.CodeMeaning);
				a.addValue(context[2]);
				item.put(a);
			}
			SequenceAttribute seq = new SequenceAttribute(TagFromName.SegmentedPropertyCategoryCodeSequence);
			seq.addItem(item);
			list.put(seq);
		}
		{
			String[] context = parse_context(type);
			AttributeList item = new AttributeList();
			{
				Attribute a = new ShortStringAttribute(TagFromName.CodingSchemeDesignator);
				a.addValue(context[0]);
				item.put(a);
			}
			{
				Attribute a = new ShortStringAttribute(TagFromName.CodeValue);
				a.addValue(context[1]);
				item.put(a);
			}
			{
				Attribute a = new LongStringAttribute(TagFromName.CodeMeaning);
				a.addValue(context[2]);
				item.put(a);
			}
			SequenceAttribute seq = new SequenceAttribute(TagFromName.SegmentedPropertyTypeCodeSequence);
			seq.addItem(item);
			list.put(seq);
		}

		SequenceItem item = new SequenceItem(list);
		segment_sequence.addItem(item);
	}

	/**
	 * Add a sequence of frames to current segment.
	 * 
	 * @param frames contains a width*height*frame_num sequence;
	 * @param type is either "PROBABILITY" or "OCCUPANCY" for fractional type, or "BINARY"/null for binary type.
	 * @param stack_id is the index of current stack.
	 * @param positions is the position of each frame.
	 * @throws DicomException
	 * @throws IOException
	 */
	public void addAllFrames(byte[] frames, int frame_num, int image_width, int image_height, String type,
			short stack_id, double[][] positions) throws DicomException, IOException
	{
		if (frames == null)
			throw (new DicomException("There is no pixel data!"));

		if (frame_num <= 0 || image_width <= 0 || image_height <= 0)
			throw (new DicomException("Image size is not correct!"));
//		log.info("pixel data length:" + frames.length + " frames:" + frame_num + " width:" + image_width + " height:" + image_height);
//		log.info("(image_width * image_height * frame_num - 1) / 8 + 1): " + ((image_width * image_height * frame_num - 1) / 8 + 1));
//		log.info("image_width * image_height * frame_num :" + image_width * image_height * frame_num);
		if (type == null)
			type = "BINARY";
		else if (!type.equalsIgnoreCase("PROBABILITY") && !type.equalsIgnoreCase("OCCUPANCY"))
			type = "BINARY";

		 if (!type.equalsIgnoreCase("BINARY")) { // 8-bit/pixel
			 System.err.println("type:" + type + " frames.length " + frames.length + " width:" + image_width + " height:" + image_height + " frames:" + frame_num);
			 System.err.println("image_width * image_height * frame_num " + image_width * image_height * frame_num);
			 log.warning("type:" + type + " frames.length " + frames.length + " width:" + image_width + " height:" + image_height + " frames:" + frame_num);
			 log.warning("image_width * image_height * frame_num " + image_width * image_height * frame_num);
			 if (frames.length != image_width * image_height * frame_num) {
				 throw (new DicomException("Image size or type is not correct!"));
			 }
		 } else if (frames.length != (image_width * image_height * frame_num - 1) / 8 + 1) {
			 System.err.println("type:" + type + " frames.length " + frames.length + " width:" + image_width + " height:" + image_height + " frames:" + frame_num);
			 System.err.println("image_width * image_height * frame_num - 1) / 8 + 1 :"
					 + ((image_width * image_height * frame_num - 1) / 8 + 1));
			 log.warning("type:" + type + " frames.length " + frames.length + " width:" + image_width + " height:" + image_height + " frames:" + frame_num);
			 log.warning("image_width * image_height * frame_num - 1) / 8 + 1 :"
					 + ((image_width * image_height * frame_num - 1) / 8 + 1));
			 throw (new DicomException("Image size or type is not correct!"));
		 }

		if (frame_counter == 0) { // Record the segmentation type at the first time.
			if (!type.equalsIgnoreCase("BINARY")) { // 8-bit/pixel
				{
					Attribute a = new CodeStringAttribute(TagFromName.SegmentationType);
					a.addValue("FRACTIONAL");
					list.put(a);
				}
				{
					Attribute a = new UnsignedShortAttribute(TagFromName.BitsAllocated);
					a.addValue(8);
					list.put(a);
				}
				{
					Attribute a = new UnsignedShortAttribute(TagFromName.MaximumFractionalValue);
					a.addValue(0xFF);
					list.put(a);
				}
				{
					Attribute a = new UnsignedShortAttribute(TagFromName.BitsStored);
					a.addValue(8);
					list.put(a);
				}
				{
					Attribute a = new UnsignedShortAttribute(TagFromName.HighBit);
					a.addValue(7);
					list.put(a);
				}
				{
					Attribute a = new CodeStringAttribute(TagFromName.SegmentationFractionalType);
					a.addValue(type.toUpperCase());
					list.put(a);
				}
			} else { // 1-bit/pixel
				{
					Attribute a = new CodeStringAttribute(TagFromName.SegmentationType);
					a.addValue("BINARY");
					list.put(a);
				}
				{
					Attribute a = new UnsignedShortAttribute(TagFromName.BitsAllocated);
					a.addValue(1);
					list.put(a);
				}
				{
					Attribute a = new UnsignedShortAttribute(TagFromName.BitsStored);
					a.addValue(1);
					list.put(a);
				}
				{
					Attribute a = new UnsignedShortAttribute(TagFromName.HighBit);
					a.addValue(0);
					list.put(a);
				}
			}
		} else { // All the segmentation objects MUST have the same data type.
			String s_type = Attribute.getSingleStringValueOrDefault(list, TagFromName.SegmentationFractionalType, "BINARY");
			if (!s_type.equalsIgnoreCase(type))
				throw (new DicomException("All the segmentation objects MUST have same data type!"));
		}

		if (frame_counter == 0) { // Record the rows and columns at the first time.
			Attribute a = new UnsignedShortAttribute(TagFromName.Rows);
			a.addValue(image_height);
			list.put(a);
			geometry_list.put(a);
			a = new UnsignedShortAttribute(TagFromName.Columns);
			a.addValue(image_width);
			list.put(a);
			geometry_list.put(a);
		} else { // Check whether the new frames have the same resolution.
			short height = (short)Attribute.getSingleIntegerValueOrDefault(list, TagFromName.Rows, 1);
			short width = (short)Attribute.getSingleIntegerValueOrDefault(list, TagFromName.Columns, 1);
			if (height != image_height || width != image_width)
				throw (new DicomException("Image size MUST be same!"));
		}

		// Add new data to the end of the existing data.
		if (use_temp_file == false) { // Save pixel data to memory.
			try {
				byte[] current = pixel_data.getByteValues();
				if (current != null) {
					byte[] temp = new byte[current.length + frames.length];
					System.arraycopy(current, 0, temp, 0, current.length);
					System.arraycopy(frames, 0, temp, current.length, frames.length);
					pixel_data.setValues(temp);
				} else {
					byte[] temp = frames.clone();
					pixel_data.setValues(temp);
				}
			} catch (java.lang.OutOfMemoryError e) {
				use_temp_file = true;
				byte[] data = pixel_data.getByteValues();
				if (data != null)
					save_pixeldata_to_temp_file(data, temp_file, false);
				if (frames != null)
					save_pixeldata_to_temp_file(frames, temp_file, true);
			}
		} else { // Save pixel data to a temporary file.
			if (frames != null)
				save_pixeldata_to_temp_file(frames, temp_file, true);
		}

		// Sort the frames according to their positions.
		int[] in_stack_position = sort_frames_by_position(geometry_list, positions, frame_num);
		log.info("frame num " + frame_num);
		// Generate Per-frame attributes. Refer to Table A.51-2 SEGMENTATION FUNCTIONAL GROUP MACROS
		for (int k = 0; k < frame_num; k++) {
			AttributeList item2 = new AttributeList();

			{
				AttributeList item = new AttributeList();
				SequenceAttribute seq = new SequenceAttribute(TagFromName.SegmentIdentificationSequence);
				Attribute a = new UnsignedShortAttribute(TagFromName.ReferencedSegmentNumber);
				a.addValue(current_segment);
				item.put(a);
				seq.addItem(item);
				item2.put(seq);
			}

			{ // Assign FrameContentSequence.
				SequenceAttribute seq = new SequenceAttribute(TagFromName.FrameContentSequence);
				AttributeList item = new AttributeList();
				Attribute a = new ShortStringAttribute(TagFromName.StackID);
				stack_id = stack_id > 0 ? stack_id : 1;
				a.addValue(Integer.toString(stack_id));
				item.put(a);
				a = new UnsignedLongAttribute(TagFromName.InStackPositionNumber);
				a.addValue(in_stack_position[k]);
				item.put(a);
				a = new UnsignedLongAttribute(TagFromName.DimensionIndexValues);
				a.addValue(stack_id);
				a.addValue(in_stack_position[k]);
				a.addValue(current_segment);
				item.put(a);
				seq.addItem(item);
				item2.put(seq);
			}

			{ // Assign PlanePositionSequence
				SequenceAttribute seq = new SequenceAttribute(TagFromName.PlanePositionSequence);
				AttributeList item = new AttributeList();
				Attribute a = new DecimalStringAttribute(TagFromName.ImagePositionPatient);
				if (positions != null) {
					//for slicer get seg positions
					a.addValue(seg_positions[k][0]);
					a.addValue(seg_positions[k][1]);
					a.addValue(seg_positions[k][2]);
//					a.addValue(positions[k][0]);
//					a.addValue(positions[k][1]);
//					a.addValue(positions[k][2]);
				} else {
					a.addValue(0);
					a.addValue(0);
					a.addValue(0);
				}
				item.put(a);
				seq.addItem(item);
				item2.put(seq);
				
		}
			//for slicer add derivation to per frame
			{ // DerivationImageSequence - TODO - Need to verify if this is correct???
				SequenceAttribute derivation_image_seq = new SequenceAttribute(TagFromName.DerivationImageSequence);
				AttributeList reference = new AttributeList();
				{
					AttributeList item = new AttributeList();
					{
						Attribute a = new ShortStringAttribute(TagFromName.CodeValue);
						a.addValue("113076");
						item.put(a);
					}
					{
						Attribute a = new ShortStringAttribute(TagFromName.CodingSchemeDesignator);
						a.addValue("DCM");
						item.put(a);
					}
					{
						Attribute a = new LongStringAttribute(TagFromName.CodeMeaning);
						a.addValue("Segmentation");
						item.put(a);
					}
					SequenceAttribute seq = new SequenceAttribute(TagFromName.DerivationCodeSequence);
					seq.addItem(item);
					reference.put(seq);
				}
				SequenceAttribute source_image_seq = new SequenceAttribute(TagFromName.SourceImageSequence);
				{ // SourceImageSequence
					AttributeList image = new AttributeList();
					AttributeList item = new AttributeList();
					{
						Attribute a = new ShortStringAttribute(TagFromName.CodeValue);
						a.addValue("121322");
						item.put(a);
					}
					{
						Attribute a = new ShortStringAttribute(TagFromName.CodingSchemeDesignator);
						a.addValue("DCM");
						item.put(a);
					}
					{
						Attribute a = new LongStringAttribute(TagFromName.CodeMeaning);
						a.addValue("Source image for image processing operation");
						item.put(a);
					}
					SequenceAttribute seq = new SequenceAttribute(TagFromName.PurposeOfReferenceCodeSequence);
					seq.addItem(item);
					image.put(seq);
					{
						Attribute a = new UniqueIdentifierAttribute(TagFromName.ReferencedSOPClassUID);
						a.addValue(orig_class_uid);
						image.put(a);
					}
					{
						//log.info("SourceImageSequence:" + i + " ReferencedSOPInstanceUID:" + orig_inst_uids[i]);
						Attribute a = new UniqueIdentifierAttribute(TagFromName.ReferencedSOPInstanceUID);
						
						a.addValue(orig_inst_uids[k]);
						image.put(a);
					}
					// Need this for multiframe source DICOM???
					{
						Attribute a = new IntegerStringAttribute(TagFromName.ReferencedFrameNumber);
						a.addValue("1");
						image.put(a);
					}
					source_image_seq.addItem(image);
				}
				reference.put(source_image_seq);
				derivation_image_seq.addItem(reference);
				item2.put(derivation_image_seq);
			}
			
			per_frame_functional_groups_sequence.addItem(item2);
		}

		// Update the frame counter (NumberOfFrames).
		frame_counter += frame_num;
		{
			Attribute a = new IntegerStringAttribute(TagFromName.NumberOfFrames);
			a.addValue(frame_counter);
			list.put(a);
		}
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
		// Add object Segment Sequence.
		list.put(TagFromName.SegmentSequence, segment_sequence);

		// Combine attributes that can be shared.
		combine_shared_attributes(shared_functional_groups_item, per_frame_functional_groups_sequence);
		// Add object Shared Functional Groups Sequence.
		SequenceAttribute shared_functional_groups_sequence = new SequenceAttribute(
				TagFromName.SharedFunctionalGroupsSequence);
		shared_functional_groups_sequence.addItem(shared_functional_groups_item);
		list.put(TagFromName.SharedFunctionalGroupsSequence, shared_functional_groups_sequence);
		// Add object Per-frame Functional Groups Sequence.
		list.put(TagFromName.PerFrameFunctionalGroupsSequence, per_frame_functional_groups_sequence);

		if (use_temp_file) {
			list.write(file_name, TransferSyntax.ExplicitVRLittleEndian, true, true);
			append_pixeldata_attribute(temp_file, file_name);
		} else {
			// Add object Pixel Data.
			list.put(pixel_data);
			// Save the whole list.
			list.write(file_name, TransferSyntax.ExplicitVRLittleEndian, true, true);
		}
	}

	/**
	 * @param Output strings in scheme, value, meaning order.
	 */
	private String[] parse_context(CodedConcept prop)
	{
		String[] val = { "Unknown Scheme", "Unknown Value", "Unknown Meaning" };

		try {
			val[0] = prop.getCodingSchemeDesignator();
			val[1] = prop.getCodeValue();
			val[2] = prop.getCodeMeaning();
		} catch (Exception e) {
			System.err.println("The property is not a valid CodedConcept object!");
			val[0] = "Unknown Scheme";
			val[1] = "Unknown Value";
			val[2] = "Unknown Meaning";
		}

		return val;
	}

	/**
	 * @param pixels contain the pixel data.
	 * @param pixel_file is the name of the temporary file.
	 * @param append is false when the new file is created and append is true when new data is appended to the existing
	 *          file.
	 * @throws IOException
	 */
	private void save_pixeldata_to_temp_file(byte[] pixels, String pixel_file, boolean append) throws IOException
	{
		OutputStream outputStream = null;

		try {
			outputStream = new FileOutputStream(pixel_file, append);
			outputStream.write(pixels);
		} finally {
			IOUtils.closeQuietly(outputStream);
		}
	}

	/**
	 * This function calls PixelMed methods to generate PixelData attribute and append it to the output.
	 * 
	 * @param pixel_file: This file stores raw pixel data.
	 * @param output_file: This file is the final DICOM segmentation objects output.
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws DicomException
	 */
	private void append_pixeldata_attribute(String pixel_file_name, String output_file) throws FileNotFoundException,
			IOException, DicomException
	{
		String tmp_tag_file_name = "TAG_" + pixel_file_name; // File with tag.

		{ // Copy raw pixel data to a tagged file.
			File pixelFile = new File(pixel_file_name);
			OutputStream tagOutputStream = null;
			DicomOutputStream dicomOutputStream = null;
			DicomInputStream dicomInputStream = null;

			try {
				tagOutputStream = new FileOutputStream(tmp_tag_file_name);
				dicomOutputStream = new DicomOutputStream(tagOutputStream, TransferSyntax.ExplicitVRLittleEndian,
						TransferSyntax.ExplicitVRLittleEndian);
				dicomInputStream = new DicomInputStream(pixelFile, TransferSyntax.ExplicitVRLittleEndian, false);
				OtherByteAttributeOnDisk data = new OtherByteAttributeOnDisk(TagFromName.PixelData, pixelFile.length(),
						dicomInputStream, 0);
				data.write(dicomOutputStream);
			} finally {
				IOUtils.closeQuietly(dicomOutputStream);
				IOUtils.closeQuietly(tagOutputStream);
				IOUtils.closeQuietly(dicomInputStream);
				pixelFile.delete(); // Delete the temporary raw data file.
			}
		}

		{ // Append the tagged file to the output.
			File tagFile = new File(tmp_tag_file_name);
			DataInputStream dicomInputStream = null;
			FileOutputStream dicomOutputStream = null;
			try {
				dicomInputStream = new DataInputStream((new FileInputStream(tagFile)));
				dicomOutputStream = new FileOutputStream(output_file, true);
				// Skip the 132-byte DICOM header.
				CopyStream.skipInsistently(dicomInputStream, 132);
				CopyStream.copy(dicomInputStream, dicomOutputStream);
			} finally {
				IOUtils.closeQuietly(dicomInputStream);
				IOUtils.closeQuietly(dicomOutputStream);
				tagFile.delete(); // Delete the temporary file.
			}
		}
	}

	/**
	 * Moved common attributes from per-frame functional group to shared functional group.
	 * 
	 * @param shared_group contains the attributes in SharedFunctionalGroup.
	 * @param per_frame_sequence is the attribute sequence of PerFrameFunctionalGroup.
	 * @throws DicomException
	 */
	private void combine_shared_attributes(AttributeList shared_group, SequenceAttribute per_frame_sequence)
			throws DicomException
	{
		// Check all the items in per_frame_sequence and move the common attributes to shared_group.
		//plane position sequence removed from check for slicer
		AttributeTag[] checked_attrs = new AttributeTag[] { TagFromName.SegmentIdentificationSequence/*,
				TagFromName.PlanePositionSequence*/
		/* , TagFromName.StackID, TagFromName.PlaneOrientationSequence, TagFromName.SliceThickness, TagFromName.PixelSpacing */};
		Hashtable<AttributeTag, SequenceAttribute> common_attrs = get_common_attributes(checked_attrs, per_frame_sequence);
		add_attributes_to_shared_group(common_attrs, shared_group);
		remove_attributes_from_sequence(common_attrs.keySet(), per_frame_sequence);
	}

	/**
	 * Test if the attribute is common to all frames.
	 * 
	 * @param tags provides the TagName of the attributes to be checked.
	 * @param sequence is the attribute sequence of all frames.
	 * @return Return (key, value) of common attributes.
	 * @throws DicomException
	 */
	private Hashtable<AttributeTag, SequenceAttribute> get_common_attributes(AttributeTag[] tags,
			SequenceAttribute sequence) throws DicomException
	{
		Hashtable<AttributeTag, SequenceAttribute> attrs = new Hashtable<AttributeTag, SequenceAttribute>();
		for (AttributeTag tag : tags) {
			attrs.put(tag, new SequenceAttribute(tag));
		}

		@SuppressWarnings("unchecked")
		Iterator<SequenceItem> it = sequence.iterator();
		boolean initial = true;
		while (it.hasNext()) {
			AttributeList l = it.next().getAttributeList();
			if (initial) {
				// Initialize the attributes.
				initial = false;
				Enumeration<AttributeTag> i = attrs.keys();
				while (i.hasMoreElements()) {
					AttributeTag key = i.nextElement();
					SequenceAttribute seq = null;
					// Since some keys are not the top-level attributes, get their parent sequence attributes instead.
					if (key.equals(TagFromName.StackID)) {
						seq = (SequenceAttribute)l.get(TagFromName.FrameContentSequence);
					} else if (key.equals(TagFromName.SliceThickness) || key.equals(TagFromName.PixelSpacing)) {
						seq = (SequenceAttribute)l.get(TagFromName.PixelMeasuresSequence);
					} else {
						seq = (SequenceAttribute)l.get(key);
					}

					if (seq == null)
						seq = new SequenceAttribute(key);
					attrs.put(key, seq);
				}
			} else {
				// Check if the values are equal.
				Enumeration<AttributeTag> i = attrs.keys();
				while (i.hasMoreElements()) {
					AttributeTag key = i.nextElement();
					SequenceAttribute seq = null;
					// Since some keys are not the top-level attributes, get their parent sequence attributes instead.
					if (key.equals(TagFromName.StackID))
						seq = (SequenceAttribute)l.get(TagFromName.FrameContentSequence);
					else if (key.equals(TagFromName.SliceThickness) || key.equals(TagFromName.PixelSpacing))
						seq = (SequenceAttribute)l.get(TagFromName.PixelMeasuresSequence);
					else
						seq = (SequenceAttribute)l.get(key);
					if (compare_sequence_attribute(key, attrs.get(key), seq) != true)
					attrs.remove(key);
				}
			}
		}

		return attrs;
	}

	private boolean compare_sequence_attribute(AttributeTag tag, SequenceAttribute s1, SequenceAttribute s2)
			throws DicomException
	{
		if (s1 == null || s2 == null)
			return false;

		boolean equal = false;

		if (tag.equals(TagFromName.SegmentIdentificationSequence)) {
			Attribute a1 = SequenceAttribute.getNamedAttributeFromWithinSequenceWithSingleItem(s1,
					TagFromName.ReferencedSegmentNumber);
			Attribute a2 = SequenceAttribute.getNamedAttributeFromWithinSequenceWithSingleItem(s2,
					TagFromName.ReferencedSegmentNumber);
			short[] val1 = a1.getShortValues();
			short[] val2 = a2.getShortValues();
			for (int i = 0; i < val1.length; i++) {
				equal = val1[i] == val2[i];
				if (!equal)
					break;
			}
		} else if (tag.equals(TagFromName.StackID)) {
			Attribute a1 = SequenceAttribute.getNamedAttributeFromWithinSequenceWithSingleItem(s1, TagFromName.StackID);
			Attribute a2 = SequenceAttribute.getNamedAttributeFromWithinSequenceWithSingleItem(s2, TagFromName.StackID);
			short[] val1 = a1.getShortValues();
			short[] val2 = a2.getShortValues();
			for (int i = 0; i < val1.length; i++) {
				equal = val1[i] == val2[i];
				if (!equal)
					break;
			}
		} else if (tag.equals(TagFromName.PlanePositionSequence)) {
			Attribute a1 = SequenceAttribute.getNamedAttributeFromWithinSequenceWithSingleItem(s1,
					TagFromName.ImagePositionPatient);
			Attribute a2 = SequenceAttribute.getNamedAttributeFromWithinSequenceWithSingleItem(s2,
					TagFromName.ImagePositionPatient);
			double[] val1 = a1.getDoubleValues();
			double[] val2 = a2.getDoubleValues();
			for (int i = 0; i < val1.length; i++) {
				equal = val1[i] == val2[i];
				if (!equal)
					break;
			}
		} else if (tag.equals(TagFromName.PlaneOrientationSequence)) {
			Attribute a1 = SequenceAttribute.getNamedAttributeFromWithinSequenceWithSingleItem(s1,
					TagFromName.ImageOrientationPatient);
			Attribute a2 = SequenceAttribute.getNamedAttributeFromWithinSequenceWithSingleItem(s2,
					TagFromName.ImageOrientationPatient);
			short[] val1 = a1.getShortValues();
			short[] val2 = a2.getShortValues();
			for (int i = 0; i < val1.length; i++) {
				equal = val1[i] == val2[i];
				if (!equal)
					break;
			}
		} else if (tag.equals(TagFromName.SliceThickness)) {
			Attribute a1 = SequenceAttribute
					.getNamedAttributeFromWithinSequenceWithSingleItem(s1, TagFromName.SliceThickness);
			Attribute a2 = SequenceAttribute
					.getNamedAttributeFromWithinSequenceWithSingleItem(s2, TagFromName.SliceThickness);
			double[] val1 = a1.getDoubleValues();
			double[] val2 = a2.getDoubleValues();
			for (int i = 0; i < val1.length; i++) {
				equal = val1[i] == val2[i];
				if (!equal)
					break;
			}
		} else if (tag.equals(TagFromName.PixelSpacing)) {
			Attribute a1 = SequenceAttribute.getNamedAttributeFromWithinSequenceWithSingleItem(s1, TagFromName.PixelSpacing);
			Attribute a2 = SequenceAttribute.getNamedAttributeFromWithinSequenceWithSingleItem(s2, TagFromName.PixelSpacing);
			double[] val1 = a1.getDoubleValues();
			double[] val2 = a2.getDoubleValues();
			for (int i = 0; i < val1.length; i++) {
				equal = val1[i] == val2[i];
				if (!equal)
					break;
			}
		}

		return equal;
	}

	private void remove_attributes_from_sequence(Set<AttributeTag> tags, SequenceAttribute sequence)
	{
		@SuppressWarnings("unchecked")
		Iterator<SequenceItem> it = sequence.iterator();
		while (it.hasNext()) {
			AttributeList l = it.next().getAttributeList();
			Iterator<AttributeTag> i = tags.iterator();
			while (i.hasNext()) {
				AttributeTag tag = i.next();
				if (tag.equals(TagFromName.StackID)) {
					AttributeList seq = SequenceAttribute.getAttributeListFromWithinSequenceWithSingleItem(l,
							TagFromName.FrameContentSequence);
					seq.remove(tag);
				} else if (tag.equals(TagFromName.SliceThickness) || tag.equals(TagFromName.PixelSpacing)) {
					AttributeList seq = SequenceAttribute.getAttributeListFromWithinSequenceWithSingleItem(l,
							TagFromName.PixelMeasuresSequence);
					seq.remove(tag);
					if (seq.isEmpty())
						l.remove(TagFromName.PixelMeasuresSequence); // Delete this attribute if it is empty.
				} else
					l.remove(tag);
			}
		}
	}

	private void add_attributes_to_shared_group(Hashtable<AttributeTag, SequenceAttribute> attrs, AttributeList shared)
	{
		/*
		 * {TagFromName.SegmentIdentificationSequence, TagFromName.StackID, TagFromName.PlanePositionSequence,
		 * TagFromName.PlaneOrientationSequence, TagFromName.SliceThickness, TagFromName.PixelSpacing}
		 */
		Enumeration<AttributeTag> i = attrs.keys();
		while (i.hasMoreElements()) {
			AttributeTag tag = i.nextElement();
			if (tag.equals(TagFromName.StackID)) {
				Attribute a = SequenceAttribute.getNamedAttributeFromWithinSequenceWithSingleItem(attrs.get(tag), tag);
				if (a == null)
					continue;
				SequenceAttribute seq = new SequenceAttribute(TagFromName.FrameContentSequence);
				AttributeList item = new AttributeList();
				item.put(a);
				seq.addItem(item);
				shared.put(seq);
			} else if (tag.equals(TagFromName.SliceThickness) || tag.equals(TagFromName.PixelSpacing)) {
				Attribute a = SequenceAttribute.getNamedAttributeFromWithinSequenceWithSingleItem(attrs.get(tag), tag);
				if (a == null)
					continue;
				SequenceAttribute pixel_measures_seq = (SequenceAttribute)shared.get(TagFromName.PixelMeasuresSequence);
				if (pixel_measures_seq != null) { // If PixelMeasuresSequence is already there, add one attribute to it instead
																					// of rewriting it.
					AttributeList l = SequenceAttribute.getAttributeListFromWithinSequenceWithSingleItem(pixel_measures_seq);
					l.put(a);
				} else {
					SequenceAttribute seq = new SequenceAttribute(TagFromName.PixelMeasuresSequence);
					AttributeList item = new AttributeList();
					item.put(a);
					seq.addItem(item);
					shared.put(seq);
				}
			} else
				shared.put(attrs.get(tag));
		}
	}

	/**
	 * Sort the frames by their position.
	 * 
	 * @param positions are the geometry attribute of the input frame.
	 * @param frame_num is the number of frames.
	 * @return index ordered by frame's position.
	 * @throws DicomException
	 */
	private int[] sort_frames_by_position(double[][] positions, int frame_num) throws DicomException
	{
		int[] index = new int[frame_num];

		for (int i = 0; i < frame_num; i++) {
			index[i] = i;
		}

		return index;
	}

	private int [] sort_frames_by_position(AttributeList geometry, double [][] positions, int frame_num) throws DicomException {
		int [] index = new int[frame_num];
		double [] distances = new double[frame_num];
		
	    class DoubleArrayComparator implements Comparator <List <Double>> {
	        public int compare(List <Double> o1, List <Double> o2) {
	        	int val;
	            if(o1.get(0) > o2.get(0))
	            	val = 1;
	            else if(o1.get(0) < o2.get(0))
	            	val = -1;
	            else {
		            if(o1.get(1) > o2.get(1))
		            	val = 1;
		            else if(o1.get(1) < o2.get(1))
		            	val = -1;
		            else
		            	val = 0;
	            }
	            return val;
	        }
	    }
	    
		SortedMap <ArrayList <Double>, Integer> sorting = new TreeMap <ArrayList <Double>, Integer> (new DoubleArrayComparator());
		GeometryOfSlice slice_geometry;
		AttributeList geometry_list = (AttributeList)geometry.clone();
		ArrayList <Double> key;
		
		for(int i = 0; i < frame_num; i++) {
			Attribute a = new DecimalStringAttribute(TagFromName.ImagePositionPatient);
			if(positions != null) {
				a.addValue(positions[i][0]); 
				a.addValue(positions[i][1]); 
				a.addValue(positions[i][2]);
			} else {
				a.addValue(0); a.addValue(0); a.addValue(0);
			}
			geometry_list.put(a);
			slice_geometry = new GeometryOfSliceFromAttributeList(geometry_list);
			distances[i] = slice_geometry.getDistanceAlongNormalFromOrigin();
			
			key = new ArrayList <Double> (2); 
			key.add(0, distances[i]); key.add(1, (double)i);  
			sorting.put(key, 0);
		}

		// k will be the index of sorted keys.
		int k = 1;
		for (Map.Entry <ArrayList <Double>, Integer> entry : sorting.entrySet()) {
	        sorting.put(entry.getKey(), k++);
		}
		
		for(int i = 0; i < frame_num; i++) {
			key = new ArrayList <Double> (2); 
			key.add(0, distances[i]); key.add(1, (double)i);  
			index[i] = sorting.get(key);
		}
		
		return index;
	}
	/**
	 * This demo gets segmentation maps from map_file, then inserts the maps twice as two segments.
	 * 
	 * @param args: java SegmentationObjectsFileWriter dicom_file map_file output_file mode mode is "BINARY" or
	 *          "FRACTIONAL".
	 */
	public static void main(String[] args)
	{
		String input_file = args[0];// "./DicomFiles/CT0010";//
		String map_file = args[1];// "./TEMP/CT0010.mapbin";//
		String output_file = args[2];// "./TEMP/CT0010.sobin";//"segmentation_test_out.dcm";
		// String mode = args[3]; //"BINARY";

		byte[] pixels = null;
		SegmentationObjectsFileWriter obj = null;
		short image_width = 0, image_height = 0, image_frames = 0;

		// Read pixel array from the map_file.
		File file = new File(map_file);
		DataInputStream dis = null;
		pixels = new byte[(int)file.length()];
		try {
			dis = new DataInputStream((new FileInputStream(file)));
			dis.readFully(pixels);
			dis.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			IOUtils.closeQuietly(dis);
		}

		try {
			DicomInputStream i_stream = new DicomInputStream(new FileInputStream(input_file));
			AttributeList list = new AttributeList();
			list.read(i_stream);

			{ // Get sequence format.
				image_width = (short)Attribute.getSingleIntegerValueOrDefault(list, TagFromName.Columns, 1);
				image_height = (short)Attribute.getSingleIntegerValueOrDefault(list, TagFromName.Rows, 1);
				image_frames = (short)Attribute.getSingleIntegerValueOrDefault(list, TagFromName.NumberOfFrames, 1);
			}

			short[] orientation = new short[] { 1, 0, 0, 0, 0, 1 };
			double[] spacing = new double[] { 0.65, 0.8 };
			double thickness = 0.5;
			AttributeList[] lists = new AttributeList[1];
			lists[0] = list;
			obj = new SegmentationObjectsFileWriter(lists, orientation, spacing, thickness);

			CodedConcept category = new CodedConcept("C0085089" /* conceptUniqueIdentifier */, "260787004" /* SNOMED CID */,
					"SRT" /* codingSchemeDesignator */, "SNM3" /* legacyCodingSchemeDesignator */,
					null /* codingSchemeVersion */, "A-00004" /* codeValue */, "Physical Object" /* codeMeaning */,
					null /* codeStringEquivalent */, null /* synonynms */);
			CodedConcept type = new CodedConcept("C0018787" /* conceptUniqueIdentifier */, "80891009" /* SNOMED CID */,
					"SRT" /* codingSchemeDesignator */, null /* legacyCodingSchemeDesignator */,
					null /* codingSchemeVersion */, "T-32000" /* codeValue */, "Heart" /* codeMeaning */,
					null /* codeStringEquivalent */, null /* synonynms */);
			double[][] positions = new double[image_frames][3];
			/*
			 * void AddAllFrames(byte [] frames, int frame_num, int image_width, int image_height, String type, double [][]
			 * positions, short [] patient_orientation, double slice_thickness, double [] pixel_spacing, short stack_id)
			 */
			// Segment 1
			obj.addOneSegment("Segment No.1 is for ...", category, type);
			obj.addAllFrames(pixels, image_frames, image_width, image_height, "binary", (short)0, positions);
			short stack_id = 2;
			positions[0][0] = 0.2;
			obj.addAllFrames(pixels, image_frames, image_width, image_height, "binary", stack_id, positions);
			// Segment 2
			// obj.AddOneSegment(null, null, null);
			obj.addOneSegment("Segment No.2 is for ...", category, type);
			obj.addAllFrames(pixels, image_frames, image_width, image_height, "binary", (short)1, positions);
			obj.addAllFrames(pixels, image_frames, image_width, image_height, "binary", stack_id, positions);

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