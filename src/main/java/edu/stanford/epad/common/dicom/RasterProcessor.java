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
package edu.stanford.epad.common.dicom;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

import org.dcm4che2.data.DicomObject;
import org.dcm4che2.data.Tag;

import edu.stanford.epad.common.util.EPADLogger;

public class RasterProcessor
{
	/**
	 * Logger object.
	 */
	private static EPADLogger logger = EPADLogger.getInstance();
	/**
	 * Controls amount of diagnostic output.
	 */
	protected int debugLevel = 0;

	/**
	 * Getter for {@link #debugLevel} property.
	 * 
	 * @return value of property
	 */
	public int getDebugLevel()
	{
		return debugLevel;
	}

	/**
	 * Setter for {@link #debugLevel} property.
	 * 
	 * @param value value for property
	 */
	public void setDebugLevel(int value)
	{
		debugLevel = value;
	}

	/**
	 * Class to generate a histogram of values.
	 * 
	 * @author Bradley Ross
	 * 
	 */
	protected static class Distribution
	{
		/**
		 * Descriptive text for listings.
		 */
		protected String desc = new String();

		/**
		 * Setter for {@link #desc} property.
		 * 
		 * @param value value for property
		 */
		public void setDesc(String value)
		{
			if (value == null) {
				desc = new String();
			}
			desc = value;
		}

		/**
		 * Getter for {@link #desc} property.
		 * 
		 * @return value of property
		 */
		public String getDesc()
		{
			return desc;
		}

		/**
		 * Minimum value encountered for data values.
		 */
		protected float minimum = 0.0f;
		/**
		 * Maximum value encountered for data values.
		 */
		protected float maximum = 0.0f;
		/**
		 * Low end of histogram range.
		 */
		protected float lowValue = 0.0f;
		/**
		 * High end of histogram range.
		 */
		protected float highValue = 0.0f;
		/**
		 * Size of each step in histogram.
		 */
		protected float increment = 0.0f;
		/**
		 * Counters for each range in histogram.
		 */
		int[] dist = null;
		/**
		 * Total count of data values.
		 */
		int count = 0;

		/**
		 * Constructor specifying range for values.
		 * 
		 * @param bottom lowest value for histogram
		 * @param top highest value for histogram
		 * 
		 */
		public Distribution(float bottom, float top)
		{
			starter(bottom, top, 50);
		}

		/**
		 * Constructor specifying range for values and number of increments.
		 * 
		 * @param bottom lowest value for histogram
		 * @param top highest value for histogram
		 * @param increments number of increments
		 */
		public Distribution(float bottom, float top, int increments)
		{
			starter(bottom, top, increments);
		}

		/**
		 * Initializes variables.
		 * 
		 * @param bottom lowest value for histogram
		 * @param top highest value for histogram
		 * @param increments number of increments
		 */
		protected void starter(float bottom, float top, int increments)
		{
			count = 0;
			dist = new int[increments + 1];
			if (top > bottom) {
				lowValue = bottom;
				highValue = top;
			} else {
				lowValue = top;
				highValue = bottom;
			}
			for (int i = 0; i < dist.length; i++) {
				dist[i] = 0;
			}
			minimum = highValue + 2000.0f;
			maximum = lowValue - 2000.0f;
			increment = (highValue - lowValue) / (dist.length - 1);
		}

		/**
		 * Add a data point to the histogram.
		 * 
		 * @param value data value
		 */
		public void add(float value)
		{
			count++;
			if (minimum > value) {
				minimum = value;
			}
			if (maximum < value) {
				maximum = value;
			}
			int loc = (int)((value - lowValue) / increment);
			if (loc < 0) {
				loc = 0;
			} else if (loc > dist.length - 1) {
				loc = dist.length - 1;
			}
			dist[loc]++;
		}

		/**
		 * Display the histogram.
		 */
		public void print()
		{
			logger.info("Processing distribution " + getDesc());
			logger.info("There are " + Integer.toString(count) + " items");
			logger.info("Range is " + Float.toString(lowValue) + " to " + Float.toString(highValue));
			logger.info("Minimum value is " + Float.toString(minimum));
			logger.info("Maximum value is " + Float.toString(maximum));
			for (int i = 0; i < dist.length; i++) {
				logger.info(String.format("%3d  %8.2f  %8d", i, lowValue + increment * i, dist[i]));
			}
		}
	}

	/**
	 * Modality LUT.
	 * <p>
	 * See part 3, Annex C.11.1.1
	 * </p>
	 * <p>
	 * One way of describing the mapping is to use {@link Tag#RescaleSlope} and {@link Tag#RescaleIntercept}.
	 * </p>
	 * <ul>
	 * </ul>
	 * <p>
	 * The other method is to use {Tag.ModalityLUTSequence}. In this case the following items are used within the nested
	 * Dicom object.
	 * </p>
	 * <ul>
	 * <li>
	 * <p>
	 * {@link Tag#LUTDescriptor} Three integers holding the number of entries in the lookup table, first stored pixel
	 * value mapped, and the number of bits in LUTData.
	 * </p>
	 * </li>
	 * <li>{@link Tag#LUTExplanation}</li>
	 * <li>{@link Tag#ModalityLUTType}</li>
	 * <li>{@link Tag#LUTData}</li>
	 * <li>{@link Tag#RescaleIntercept}</li>
	 * <li>{@link Tag#RescaleSlope}</li>
	 * <li>{@link Tag#RescaleType}</li>
	 * </ul>
	 * 
	 * @author Bradley Ross
	 * 
	 */
	public class MLUT
	{
		protected DicomObject modalityLUT = null;
		protected int[] lutDescriptor;
		protected float rescaleSlope = 1.0f;
		protected float rescaleIntercept = 0.0f;

		public MLUT(DicomObject value)
		{
			if (value.containsValue(Tag.RescaleSlope)) {
				rescaleSlope = value.getFloat(Tag.RescaleSlope);
			}
			if (value.containsValue(Tag.RescaleIntercept)) {
				rescaleIntercept = value.getFloat(Tag.RescaleIntercept);
			}
			if (value.containsValue(Tag.ModalityLUTSequence)) {
				modalityLUT = value.getNestedDicomObject(Tag.ModalityLUTSequence);
				lutDescriptor = value.getInts(Tag.LUTDescriptor);
				rescaleSlope = modalityLUT.getFloat(Tag.RescaleSlope);
				rescaleIntercept = modalityLUT.getFloat(Tag.RescaleIntercept);
			}
		}
	}

	/**
	 * Value of Interest (VOI) LUT.
	 * 
	 * @author Bradley Ross
	 * 
	 */
	public class VLUT
	{
		protected DicomObject volumeLUT = null;
		protected float[] windowCenter = { -10.0f };
		protected float[] windowWidth = { -10.0f };

		public VLUT(DicomObject value)
		{
			if (value.containsValue(Tag.WindowCenter)) {
				windowCenter = value.getFloats(Tag.WindowCenter);
			}
			if (value.containsValue(Tag.WindowWidth)) {
				windowWidth = value.getFloats(Tag.WindowWidth);
			}
			if (value.containsValue(Tag.VOILUTSequence)) {
				volumeLUT = value.getNestedDicomObject(Tag.VOILUTSequence);
			}
		}
	}

	/**
	 * Presentation LUT.
	 * 
	 * @author Bradley Ross
	 * 
	 */
	public class PLUT
	{
		protected DicomObject presentationLUT = null;

		public PLUT(DicomObject value)
		{
			if (value.containsValue(Tag.PresentationLUTSequence)) {
				presentationLUT = value.getNestedDicomObject(Tag.PresentationLUTSequence);
			}
		}
	}

	protected MLUT mLUT = null;
	protected VLUT vLUT = null;
	protected PLUT pLUT = null;
	protected int minimumGrayLevel = 10000;
	protected int maximumGrayLevel = -10000;

	/**
	 * Prints some information about the Raster object.
	 * 
	 * @param raster object to be described
	 */
	public void print(Raster raster)
	{
		/*
		 * DataBuffer buffer = raster.getDataBuffer();
		 * 
		 * int dataType = buffer.getDataType();
		 * 
		 * int dataSize = DataBuffer.getDataTypeSize(dataType);
		 * 
		 * if (dataType == DataBuffer.TYPE_BYTE) { logger.info("BYTE " + Integer.toString(dataSize)); } else if (dataType ==
		 * DataBuffer.TYPE_SHORT) { logger.info("SHORT " + Integer.toString(dataSize)); } else if (dataType ==
		 * DataBuffer.TYPE_USHORT) { logger.info("USHORT " + Integer.toString(dataSize)); } else if (dataType ==
		 * DataBuffer.TYPE_INT) { logger.info("INT " + Integer.toString(dataSize)); } else if (dataType ==
		 * DataBuffer.TYPE_FLOAT) { logger.info("FLOAT " + Integer.toString(dataSize)); } else if (dataType ==
		 * DataBuffer.TYPE_DOUBLE) { logger.info("DOUBLE " + Integer.toString(dataSize)); } else if (dataType ==
		 * DataBuffer.TYPE_UNDEFINED) { logger.info("UNDEFINED"); }
		 */
		int min = 100000;
		int max = -100000;
		int min2 = 10000;
		int max2 = -10000;
		int[] dummy1 = new int[1];
		for (int x = 0; x < raster.getWidth(); x++) {
			for (int y = 0; y < raster.getHeight(); y++) {
				int[] gray = raster.getPixel(x, y, dummy1);
				int signed = dataValue(gray[0]);
				if (gray[0] > max) {
					max = gray[0];
				}
				if (gray[0] < min) {
					min = gray[0];
				}

				if (signed > max2) {
					max2 = signed;
				}
				if (signed < min2) {
					min2 = signed;
				}
			}
		}
		Distribution raw = new Distribution(min, max, 50);
		Distribution signed = new Distribution(min2, max2, 50);
		raw.setDesc("Raster values");
		signed.setDesc("Signed values");
		for (int x = 0; x < raster.getWidth(); x++) {
			for (int y = 0; y < raster.getHeight(); y++) {
				int[] gray = raster.getPixel(x, y, dummy1);
				raw.add(gray[0]);
				signed.add(dataValue(gray[0]));
			}
		}
		raw.print();
		signed.print();
	}

	/**
	 * Combine low and high order bytes to make 16 bit signed number.
	 * 
	 * @param high value of high order byte
	 * @param low value of low order byte
	 * @return 16 bit signed number
	 */
	public int combine(int high, int low)
	{

		return 256 * high + low;
	}

	/**
	 * Obtain the high order 8 bits of a 16 bit signed number.
	 * 
	 * @param value
	 * @return high order 8 bits as unsigned number
	 */
	public int high(int value)
	{

		return (value >> 8) & 255;
	}

	/**
	 * Obtain the lower 8 bits of a signed 16 bit number.
	 * 
	 * @param value 16 bit signed number
	 * @return low order bits as 8 bit unsigned number
	 */
	public int low(int value)
	{

		return value & 255;
	}

	protected String photometricInterpretation = null;
	/**
	 * Indicates whether PixelData values are signed or unsigned.
	 * <p>
	 * 0 = unsigned, 1 = signed.
	 * </p>
	 */
	protected int pixelRepresentation = 0;

	/**
	 * Getter for {@link #pixelRepresentation} property.
	 * 
	 * @return value of property
	 */
	public int getPixelRepresentation()
	{
		return pixelRepresentation;
	}

	protected String[] windowCenterWidthExplanation = new String[1];
	protected float[] windowCenter = new float[1];
	protected float[] windowWidth = new float[1];
	protected float rescaleIntercept = 0.0f;

	public float getRescaleIntercept()
	{
		return rescaleIntercept;
	}

	protected float rescaleSlope = 1.0f;

	protected String rescaleType = null;
	/**
	 * Value of {@link Tag#PixelPaddingValue}, with pixels having values below this not being actual measurements.
	 */
	protected int pixelPaddingValue = -100000;

	public int getPixelPaddingValue()
	{
		return pixelPaddingValue;
	}

	/**
	 * Indicates that the Dicom object has a Modality Look Up Table (MLUT).
	 */
	protected boolean hasMLUT = false;

	/**
	 * Sets values for internal tests.
	 * 
	 * @param pixel value for {@link #pixelRepresentation}
	 * @param bitsA value for {@link #bitsAllocated}
	 * @param bitsS value for {@link #bitsStored}
	 * @param hBit value for {@link #highBit}
	 * @param center value for {@link #windowCenter}
	 * @param width value for {@link #windowWidth}
	 * @param intercept value for {@link #rescaleIntercept}
	 * @param slope value for {@link #rescaleSlope}
	 */
	protected void setValues(int pixel, int bitsA, int bitsS, int hBit, float center, float width, float intercept,
			float slope)
	{
		pixelRepresentation = pixel;
		windowCenter[0] = center;
		windowWidth[0] = width;
		rescaleIntercept = intercept;
		rescaleIntercept = intercept;
		rescaleSlope = slope;
		bitsAllocated = bitsA;
		bitsStored = bitsS;
		highBit = hBit;
		common();
	}

	/**
	 * Location of the high order bit for the pixel value.
	 * <p>
	 * Zero indicates the units position in the integer.
	 * </p>
	 */
	protected int highBit = -1;
	/**
	 * Number of bits allocated in the PixelData tag for an individual component of a pixel.
	 * 
	 * <p>
	 * For gray scale objects, this is normally 16.
	 * </p>
	 */
	protected int bitsAllocated = 16;
	/**
	 * Number of bits used to store a component of a pixel.
	 * <p>
	 * If the value is a signed number, this includes the sign bit.
	 * </p>
	 */
	protected int bitsStored = -1;

	/**
	 * Getter for {@link #bitsStored} property.
	 * 
	 * @return value of property
	 */
	public int getBitsStored()
	{
		return bitsStored;
	}

	/**
	 * Value to be added to pixel value for all items to be zero or positive.
	 */
	protected int adjustment = 0;

	/**
	 * Getter for value of {@link #adjustment} property.
	 * 
	 * @return value of property
	 */
	public int getAdjustment()
	{
		return adjustment;
	}

	/**
	 * Number of unused bits on the high order side of the PixelData value.
	 */
	protected int unusedHighBits = -1;
	/**
	 * Number of unused bits on the low order side of the PixelData value.
	 */
	protected int unusedLowBits = -1;
	/**
	 * This is a data mask that will only allow the least significant {@link #bitsStored} bits.
	 */
	protected int dataMask = (1 << 16) - 1;

	/**
	 * Default constructor used only for internal tests.
	 */
	public RasterProcessor()
	{
		;
	}

	/**
	 * Constructor using Dicom object.
	 * 
	 * @param objectValue Dicom object containing properties
	 */
	public RasterProcessor(DicomObject objectValue)
	{
		if (objectValue.containsValue(Tag.PixelRepresentation)) {
			pixelRepresentation = objectValue.getInt(Tag.PixelRepresentation);
		} else {
			// logger.info("Default used for PixelRepresentation");
			pixelRepresentation = 0;
		}
		if (objectValue.containsValue(Tag.PhotometricInterpretation)) {
			photometricInterpretation = objectValue.getString(Tag.PhotometricInterpretation);
		}
		if (objectValue.containsValue(Tag.ModalityLUTSequence)) {
			hasMLUT = true;
			DicomObject nested = objectValue.getNestedDicomObject(Tag.ModalityLUTSequence);
			mLUT = new MLUT(nested);
			if (nested.containsValue(Tag.RescaleIntercept)) {
				rescaleIntercept = nested.getFloat(Tag.RescaleIntercept);
			} else {
				// logger.info("Default value of 0.0 used for RescaleIntercept");
				rescaleIntercept = 0.0f;
			}
			if (nested.containsValue(Tag.RescaleSlope)) {
				rescaleSlope = nested.getFloat(Tag.RescaleSlope);
			} else {
				// logger.info("Default value of 1.0 used for RescaleSlope");
				rescaleSlope = 1.0f;
			}
			if (nested.containsValue(Tag.RescaleType)) {
				rescaleType = nested.getString(Tag.RescaleType);
			}
			logger.info("Object has Modality LUT Sequence");
		} else {
			if (objectValue.containsValue(Tag.RescaleIntercept)) {
				rescaleIntercept = objectValue.getFloat(Tag.RescaleIntercept);
			} else {
				// logger.info("Default value of 0.0 used for RescaleIntercept");
				rescaleIntercept = 0.0f;
			}
			if (objectValue.containsValue(Tag.RescaleSlope)) {
				rescaleSlope = objectValue.getFloat(Tag.RescaleSlope);
			} else {
				// logger.info("Default value of 1.0 used for RescaleSlope");
				rescaleSlope = 1.0f;
			}
			if (objectValue.containsValue(Tag.RescaleType)) {
				rescaleType = objectValue.getString(Tag.RescaleType);
			}
		}

		if (objectValue.containsValue(Tag.HighBit)) {
			highBit = objectValue.getInt(Tag.HighBit);
		}
		if (objectValue.containsValue(Tag.BitsAllocated)) {
			bitsAllocated = objectValue.getInt(Tag.BitsAllocated);
		}
		if (objectValue.containsValue(Tag.BitsStored)) {
			bitsStored = objectValue.getInt(Tag.BitsStored);
		}

		if (objectValue.containsValue(Tag.WindowWidth)) {
			windowWidth = objectValue.getFloats(Tag.WindowWidth);
		} else {
			windowWidth[0] = -100.0f;
			// logger.info("Must calculate WindowCenter");
		}
		if (objectValue.containsValue(Tag.WindowCenter)) {
			windowCenter = objectValue.getFloats(Tag.WindowCenter);
		} else {
			windowCenter[0] = -100.0f;
			// logger.info("Must calculate WindowCenter");
		}
		if (objectValue.containsValue(Tag.WindowCenterWidthExplanation)) {
			windowCenterWidthExplanation = objectValue.getStrings(Tag.WindowCenterWidthExplanation);
		}
		if (objectValue.containsValue(Tag.PixelPaddingValue)) {
			pixelPaddingValue = objectValue.getInt(Tag.PixelPaddingValue);
			if (pixelRepresentation == 1) {
				adjustment = 1 << (bitsStored - 1);
				/*
				 * // This is only good for MONOCHROME2 int temp = pixelPaddingValue & ((1 << bitsStored) - 1);
				 * 
				 * if (temp >= (1 << (1 << (bitsStored - 1)))) { pixelPaddingValue = temp - (1 << bitsStored); } if
				 * (pixelPaddingValue < 0) { adjustment = -pixelPaddingValue; }
				 */
			}
		} else {
			if (pixelRepresentation == 1) {
				adjustment = 1 << (bitsStored - 1);
			}
		}
		common();
	}

	/**
	 * Constructor using Properties object.
	 * 
	 * @param propertiesValue object containing values
	 */
	/*
	 * public RasterProcessorDP(Properties propertiesValue) { if (propertiesValue.containsKey("PixelRepresentation")) {
	 * try { pixelRepresentation = (int) Integer.parseInt(propertiesValue.getProperty("PropertiesValue")); } catch
	 * (Exception e) { ; } } if (propertiesValue.containsKey("PhotometricInterpretation")) { try {
	 * photometricInterpretation = propertiesValue.getProperty("PhotometricInterpretation"); } catch (Exception e) { ; } }
	 * if (propertiesValue.containsKey("WindowCenter")) { try { windowCenter[0] = (float)
	 * Float.parseFloat(propertiesValue.getProperty("windowCenter")); } catch (Exception e) { ; } } if
	 * (propertiesValue.containsKey("WindowWidth")) { try { windowWidth[0] = (float)
	 * Float.parseFloat(propertiesValue.getProperty("windowWidth")); } catch (Exception e) { ; } } if
	 * (propertiesValue.containsValue("WindowCenterWidthExplanation")) { try { windowCenterWidthExplanation[0] =
	 * propertiesValue.getProperty("WindowCenterWidthExplanation"); } catch (Exception e) { ; } } if
	 * (propertiesValue.containsValue("RescaleIntercept")) { try { rescaleIntercept = (float)
	 * Float.parseFloat(propertiesValue.getProperty("RescaleIntercept")); } catch (Exception e) { ; } } if
	 * (propertiesValue.containsValue("RescaleSlope")) { try { rescaleSlope = (float)
	 * Float.parseFloat(propertiesValue.getProperty("RescaleSlope")); } catch (Exception e) { ; } } if
	 * (propertiesValue.containsValue("RescaleType")) { try { rescaleType = (String)
	 * propertiesValue.getProperty("RescaleType"); } catch (Exception e) { ; } } if
	 * (propertiesValue.containsValue("HighBit")) { try { highBit = (int)
	 * Integer.parseInt(propertiesValue.getProperty("HighBit")); } catch (Exception e) { ; } } if
	 * (propertiesValue.containsValue("BitsAllocated")) { try { bitsAllocated = (int)
	 * Integer.parseInt(propertiesValue.getProperty("BitsAllocated")); } catch (Exception e) { ; } } if
	 * (propertiesValue.containsValue("BitsStored")) { try { bitsStored = (int)
	 * Integer.parseInt(propertiesValue.getProperty("BitsStored")); } catch (Exception e) { ; } } common(); }
	 */
	/**
	 * Common operations to constructors.
	 */
	protected void common()
	{
		unusedHighBits = bitsAllocated - 1 - highBit;
		unusedLowBits = highBit - bitsStored + 1;
		dataMask = (1 << bitsStored) - 1;
		// logger.info("Bits allocated=" + Integer.toString(bitsAllocated) + ", stored=" + Integer.toString(bitsStored)
		// + ", high=" + Integer.toString(highBit));
		// if (pixelRepresentation == 0) {
		// logger.info("Unsigned values");
		// } else {
		// logger.info("Signed values");
		// }
		// logger.info("Data mask is " + Integer.toString(dataMask, 16));
	}

	/**
	 * Convert the contents of PixelData to a grayscale value.
	 * <p>
	 * The values in the data buffer belonging to the raster are actually stored as unsigned short. However,
	 * PixelRepresentation=1 means that the bits are to be interpreted as if it was a signed short. This method calculates
	 * the actual integer value and then maps them to a range of zero or positive values.
	 * </p>
	 * 
	 * @param value content of PixelData
	 * @return grayscale
	 */
	protected int dataValue(int value)
	{
		int working = value;
		if (pixelRepresentation == 0) { // Unsigned DataPixel values
			return working & dataMask;
		} else { // Signed DataPixel values
			if (working > (1 << (bitsStored - 1)) - 1) {
				working = (working & dataMask) - (1 << (bitsStored));
			}
			working = working + adjustment; // For signed, 1 << (bitsStored - 1);
			if (working < 0) {
				return (1 << (bitsStored)) - 1;
			} else {
				return working;
			}
		}
	}

	/**
	 * Convert the contents of PixelData to a signed value.
	 * <p>
	 * The values in the data buffer belonging to the raster are actually stored as unsigned short. However,
	 * PixelRepresentation=1 means that the bits are to be interpreted as if it was a signed short. This method calculates
	 * the actual signed integer value.
	 * </p>
	 * 
	 * @param value content of PixelData
	 * @return signed value
	 */
	protected int signedDataValue(int value)
	{
		int working = value;
		if (pixelRepresentation == 0) {
			/* unsigned DataPixel values */
			return working & ((1 << bitsStored) - 1);
		} else {
			if (working > (1 << (bitsStored - 1)) - 1) {
				return (working & dataMask) - (1 << bitsStored);
			} else {
				return (working & dataMask);
			}
		}
	}

	/**
	 * Create the image for the PNG file.
	 * <p>
	 * This routine places the high order bits in the first channel and the low order bits in the second channel.
	 * </p>
	 * <p>
	 * If dealing with signed data, it is necessary to add a constant to the pixel values before placing them in the PNG
	 * file. The value used is placed in the blue channel of the first two pixels on the first row of the image. The high
	 * order bits are placed in the first pixel while the low order bits are placed in the second pixel.
	 * </p>
	 * 
	 * @param raster raster from grayscale image
	 * @return bgr image with two channels used
	 */
	public BufferedImage buildPng(Raster raster)
	{
		BufferedImage pngImage = new BufferedImage(raster.getWidth(), raster.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
		// BufferedImage pngImage = new BufferedImage(raster.getWidth(), raster.getHeight(),
		// BufferedImage.TYPE_USHORT_GRAY);
		WritableRaster writablePNGRaster = pngImage.getRaster();
		Distribution rawValuesDistribution = null;
		Distribution highOrderBitsDistribution = null;
		Distribution lowOrderBitsDistribution = null;
		int[] grayInputArray = new int[1];
		int[] grayArray = new int[1];
		int[] bgrArray = new int[3];
		// int[] pngGrayArray = new int[2];

		if (debugLevel > 0) {
			// if (pixelRepresentation == 0) {
			// logger.info("Running buildPNG with unsigned PixelData");
			// } else {
			// logger.info("Running buildPNG with signed PixelData");
			// }
			rawValuesDistribution = new Distribution(-40000.0f, 40000.0f);
			rawValuesDistribution.setDesc("buildPng - Raw values");
			highOrderBitsDistribution = new Distribution(0.0f, 256.0f);
			highOrderBitsDistribution.setDesc("buildPng - high order bits");
			lowOrderBitsDistribution = new Distribution(0.0f, 256.0f);
			lowOrderBitsDistribution.setDesc("buildPng - low order bits");
		}
		for (int x = 0; x < raster.getWidth(); x++) {
			for (int y = 0; y < raster.getHeight(); y++) {
				grayArray = raster.getPixel(x, y, grayInputArray);
				int pixelValue = dataValue(grayArray[0]);
				if (debugLevel > 0) {
					rawValuesDistribution.add(pixelValue);
					highOrderBitsDistribution.add(high(pixelValue));
					lowOrderBitsDistribution.add(low(pixelValue));
				}
				bgrArray[0] = high(pixelValue);
				bgrArray[1] = low(pixelValue);
				// pngGrayArray[1] = high(pixelValue);
				// pngGrayArray[0] = low(pixelValue);
				if (y == 0 && x == 0) {
					bgrArray[2] = high(getAdjustment());
				} else if (y == 0 && x == 1) {
					bgrArray[2] = low(getAdjustment());
				} else {
					bgrArray[2] = 0;
				}
				writablePNGRaster.setPixel(x, y, bgrArray);
				// writablePNGRaster.setPixel(x, y, pngGrayArray);
			}
		}
		/*
		 * logger.info("TestingXXXX"); int[] bgrInputArray = new int[3]; for (int x = 0; x < raster.getWidth(); x++) { for
		 * (int y = 0; y < raster.getHeight(); y++) { grayArray = raster.getPixel(x, y, grayInputArray); int rawPixelValue =
		 * grayArray[0]; int pixelValue = dataValue(rawPixelValue);
		 * 
		 * bgrArray = writablePNGRaster.getPixel(x, y, bgrInputArray); if (bgrArray[0] != high(pixelValue))
		 * logger.info("Broken"); if (bgrArray[1] != low(pixelValue)) logger.info("Broken2"); if (x > 1 && bgrArray[2] != 0)
		 * logger.info("Also broken"); } }
		 */
		if (debugLevel > 0) {
			logger.info("Distribution of gray values");
			rawValuesDistribution.print();
			logger.info("Distribution of high order bits");
			highOrderBitsDistribution.print();
			logger.info("Distribution of low order bits");
			lowOrderBitsDistribution.print();
		}
		return pngImage;
	}

	
	/**
	 * Builds a binary mask for the raster. anything that is not 0 is 1
	 * @param raster
	 * @return
	 */
	public BufferedImage buildMask(Raster raster)
	{
		BufferedImage pngImage = new BufferedImage(raster.getWidth(), raster.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
		// BufferedImage pngImage = new BufferedImage(raster.getWidth(), raster.getHeight(),
		// BufferedImage.TYPE_USHORT_GRAY);
		WritableRaster writablePNGRaster = pngImage.getRaster();
		Distribution rawValuesDistribution = null;
		Distribution highOrderBitsDistribution = null;
		Distribution lowOrderBitsDistribution = null;
		int[] grayInputArray = new int[1];
		int[] grayArray = new int[1];
		int[] bgrArray = new int[3];
		// int[] pngGrayArray = new int[2];

		if (debugLevel > 0) {
			// if (pixelRepresentation == 0) {
			// logger.info("Running buildPNG with unsigned PixelData");
			// } else {
			// logger.info("Running buildPNG with signed PixelData");
			// }
			rawValuesDistribution = new Distribution(-40000.0f, 40000.0f);
			rawValuesDistribution.setDesc("buildPng - Raw values");
			highOrderBitsDistribution = new Distribution(0.0f, 256.0f);
			highOrderBitsDistribution.setDesc("buildPng - high order bits");
			lowOrderBitsDistribution = new Distribution(0.0f, 256.0f);
			lowOrderBitsDistribution.setDesc("buildPng - low order bits");
		}
		for (int x = 0; x < raster.getWidth(); x++) {
			for (int y = 0; y < raster.getHeight(); y++) {
				grayArray = raster.getPixel(x, y, grayInputArray);
				int pixelValue = dataValue(grayArray[0]);
				if (debugLevel > 0) {
					rawValuesDistribution.add(pixelValue);
					highOrderBitsDistribution.add(high(pixelValue));
					lowOrderBitsDistribution.add(low(pixelValue));
				}
				if (pixelValue==0) {
					bgrArray[0] = 0;
					bgrArray[1] = 0;
					bgrArray[2] = 0;
				}else {
					bgrArray[0] = 255;
					bgrArray[1] = 255;
					bgrArray[2] = 255;
				}
				
				writablePNGRaster.setPixel(x, y, bgrArray);
				// writablePNGRaster.setPixel(x, y, pngGrayArray);
			}
		}
		/*
		 * logger.info("TestingXXXX"); int[] bgrInputArray = new int[3]; for (int x = 0; x < raster.getWidth(); x++) { for
		 * (int y = 0; y < raster.getHeight(); y++) { grayArray = raster.getPixel(x, y, grayInputArray); int rawPixelValue =
		 * grayArray[0]; int pixelValue = dataValue(rawPixelValue);
		 * 
		 * bgrArray = writablePNGRaster.getPixel(x, y, bgrInputArray); if (bgrArray[0] != high(pixelValue))
		 * logger.info("Broken"); if (bgrArray[1] != low(pixelValue)) logger.info("Broken2"); if (x > 1 && bgrArray[2] != 0)
		 * logger.info("Also broken"); } }
		 */
		if (debugLevel > 0) {
			logger.info("Distribution of gray values");
			rawValuesDistribution.print();
			logger.info("Distribution of high order bits");
			highOrderBitsDistribution.print();
			logger.info("Distribution of low order bits");
			lowOrderBitsDistribution.print();
		}
		return pngImage;
	}
	/**
	 * Pack 16 bit PixelData in 2 channels of image.
	 * <p>
	 * For signed PixelData -32768 ( - 1<<15) to 32767 (1<<15 - 1) mapped to 0 to 65535 (1<<16 - 1)
	 * </p>
	 * 
	 * @param raster raster image from DCM4CHE2
	 * @return Image containing packed data
	 */
	public BufferedImage buildRawS(Raster raster)
	{
		int[] grayInputArray = new int[1];
		int[] grayArray = new int[1];
		int[] bgrArray = new int[3];
		BufferedImage working = new BufferedImage(raster.getWidth(), raster.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
		WritableRaster writable = working.getRaster();
		Distribution rawValuesDistribution = null;
		Distribution highOrderBitsDistribution = null;
		Distribution lowOrderBitsDistribution = null;

		if (debugLevel > 0) {
			if (pixelRepresentation == 0) {
				logger.info("Running buildRawS with unsigned PixelData");
				rawValuesDistribution = new Distribution(0, 10000.0f);
			} else {
				logger.info("Running buildRawS with signed PixelData");
				rawValuesDistribution = new Distribution(32768.0f - 20000.0f, 32768.0f + 20000.0f);
			}
			rawValuesDistribution.setDesc("buildRawS - Distribution of PixelData values");
			highOrderBitsDistribution = new Distribution(0.0f, 256.0f);
			highOrderBitsDistribution.setDesc("buildRawS - Distribution of high order bits");
			lowOrderBitsDistribution = new Distribution(0.0f, 256.0f);
			lowOrderBitsDistribution.setDesc("buildRawS - Distribution of low order bits");
		}
		for (int x = 0; x < raster.getWidth(); x++) {
			for (int y = 0; y < raster.getHeight(); y++) {
				grayArray = raster.getPixel(x, y, grayInputArray);
				int pixelValue = dataValue(grayArray[0]);
				if (debugLevel > 0) {
					rawValuesDistribution.add(pixelValue);
					highOrderBitsDistribution.add(high(pixelValue));
					lowOrderBitsDistribution.add(low(pixelValue));
				}
				bgrArray[0] = high(pixelValue);
				bgrArray[1] = low(pixelValue);
				bgrArray[2] = 0;
				writable.setPixel(x, y, bgrArray);
			}
		}
		if (debugLevel > 0) {
			logger.info("Distribution of gray values");
			rawValuesDistribution.print();
			logger.info("Distribution of high order bits");
			highOrderBitsDistribution.print();
			logger.info("Distribution of low order bits");
			lowOrderBitsDistribution.print();
		}
		return working;
	}

	/**
	 * Create the image for the PNG file after rescaling.
	 * <p>
	 * This routine places the high order bits in the first channel and the low order bits in the second channel.
	 * </p>
	 * 
	 * @param raster raster from grayscale image
	 * @return bgr image with two channels used
	 */
	public BufferedImage buildScaled(Raster raster)
	{
		int[] grayInputArray = new int[1];
		int[] grayArray = new int[1];
		int[] bgrArray = new int[3];
		BufferedImage pngImage = new BufferedImage(raster.getWidth(), raster.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
		WritableRaster pngRaster = pngImage.getRaster();
		Distribution rawValuesDistribution = null;
		Distribution highOrderBitsDistribution = null;
		Distribution lowOrderBitsDistribution = null;

		if (debugLevel > 0) {
			rawValuesDistribution = new Distribution(-40000.0f, 40000.0f);
			rawValuesDistribution.setDesc("buildScaled - Distribution of rescaled gray values");
			highOrderBitsDistribution = new Distribution(0.0f, 256.0f);
			highOrderBitsDistribution.setDesc("buildScaled - Distribution of high order bits");
			lowOrderBitsDistribution = new Distribution(0.0f, 256.0f);
			lowOrderBitsDistribution.setDesc("buildScaled - Distribution of low order bits");
		}
		for (int x = 0; x < raster.getWidth(); x++) {
			for (int y = 0; y < raster.getHeight(); y++) {
				grayArray = raster.getPixel(x, y, grayInputArray);
				int pixelValue = dataValue(grayArray[0]);
				float scaledValue = rescaleSlope * pixelValue + rescaleIntercept;
				pixelValue = (int)scaledValue;

				if (debugLevel > 0) {
					rawValuesDistribution.add(pixelValue);
					highOrderBitsDistribution.add(high(pixelValue));
					lowOrderBitsDistribution.add(low(pixelValue));
				}
				bgrArray[0] = high(pixelValue);
				bgrArray[1] = low(pixelValue);
				bgrArray[2] = 0;
				pngRaster.setPixel(x, y, bgrArray);
			}
		}
		if (debugLevel > 0) {
			logger.info("Distribution of rescaled gray values");
			rawValuesDistribution.print();
			logger.info("Distribution of rescaled high order bits");
			highOrderBitsDistribution.print();
			logger.info("Distribution of rescaled low order bits");
			lowOrderBitsDistribution.print();
		}
		return pngImage;
	}

	/**
	 * Create image using windowing instructions in Dicom object.
	 * <p>
	 * In this method, the rescale and windowing operations are carried out internally rather than by the DCM4CHE2 code.
	 * </p>
	 * 
	 * @param raster Raster object from PixelData fragment
	 * @return image with windowing applied
	 */
	public BufferedImage buildWindowed(Raster raster)
	{
		int[] dummy1 = new int[1];
		int[] gray = new int[1];
		if (windowCenter[0] < -10 || windowWidth[0] < -10) {
			for (int x = 0; x < raster.getWidth(); x++) {
				for (int y = 0; y < raster.getHeight(); y++) {
					gray = raster.getPixel(x, y, dummy1);
					int signed = dataValue(gray[0]);

					if (signed > maximumGrayLevel) {
						maximumGrayLevel = signed;
					}
					if (signed < minimumGrayLevel) {
						minimumGrayLevel = signed;
					}
				}
			}
			windowWidth[0] = (maximumGrayLevel - minimumGrayLevel) * rescaleSlope;
			windowCenter[0] = (maximumGrayLevel + minimumGrayLevel) * rescaleSlope / 2.0f + rescaleIntercept;
			// logger.info("WindowWidth is " + Float.toString(windowWidth[0]));
			// logger.info("WindowCenter is " + Float.toString(windowCenter[0]));
		}
		BufferedImage working = new BufferedImage(raster.getWidth(), raster.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
		WritableRaster writable = working.getRaster();
		float a01 = 255.0f * rescaleSlope / windowWidth[0];
		float a04 = 255.0f / windowWidth[0]
				* (rescaleIntercept - rescaleSlope * adjustment - windowCenter[0] + 0.5f * windowWidth[0]);
		for (int x = 0; x < raster.getWidth(); x++) {
			for (int y = 0; y < raster.getHeight(); y++) {
				gray = raster.getPixel(x, y, dummy1);
				int pixelValue = dataValue(gray[0]);
				float value = a01 * pixelValue + a04;
				gray[0] = (int)value;
				if (gray[0] > 255) {
					gray[0] = 255;
				} else if (gray[0] < 0) {
					gray[0] = 0;
				}
				writable.setPixel(x, y, gray);
			}
		}
		return working;
	}

	/**
	 * Test conversion back and forth between two eight bit and one sixteen bit value.
	 * 
	 * @param value value to be converted from 16 bit to 2 8 bit
	 */
	public static void test(int value)
	{
		RasterProcessor instance = new RasterProcessor();
		logger.info(String.format("%1$6d  ", value));
		logger.info(String.format("%1$02x  %2$02x  %3$7d", instance.high(value), instance.low(value),
				instance.combine(instance.high(value), instance.low(value))));
	}

	protected void test2(int value)
	{
		logger.info(String.format("%1$04x  %1$8d  %2$8d", value & dataMask, dataValue(value)));
	}

	/**
	 * Test driver
	 * 
	 * @param args not used
	 */
	public static void main(String[] args)
	{
		test(2);
		test(1);
		test(0);
		test(-1);
		test(-2);
		test(100);
		test(-100);
		test(4000);
		test(-4000);
		test(32767);
		test(-32768);
		test(-32767);
		Distribution distribute = new Distribution(0.0f, 100.0f);
		distribute.add(1.0f);
		distribute.add(11.0f);
		distribute.add(5.0f);
		distribute.add(2.0f);
		distribute.add(2.1f);
		distribute.add(2.2f);
		distribute.print();
		logger.info("Tests for bit shifting");
		long mask1 = (1l << 32) - (1l << 16);
		logger.info(Long.toString(mask1, 16) + "  (1<<32) - (1<<16)");
		logger.info(Long.toString(1l << 16, 16) + "  1<<16");
		logger.info(Long.toString(1l << 15, 16) + "  1<<15");
		RasterProcessor instance = null;
		instance = new RasterProcessor();
		instance.setDebugLevel(10);
		instance.setValues(1, 16, 12, 11, 40.0f, 400.0f, -400.0f, 1.0f);

		instance.test2(0x07FF);
		instance.test2(0x07FE);
		instance.test2(0x0030);
		instance.test2(0x0020);
		instance.test2(0x0010);
		instance.test2(0x0000);
		instance.test2(0x0fff);
		instance.test2(0x0fef);
		instance.test2(0x0fdf);
		instance.test2(0x0fcf);
		instance.test2(0x0801);
		instance.test2(0x0800);
		instance = new RasterProcessor();
		instance.setDebugLevel(10);
		instance.setValues(1, 16, 10, 13, 40.0f, 400.0f, -400.0f, 1.0f);
		instance.test2(0x01ff);
		instance.test2(0x01fe);
		instance.test2(0x0060);
		instance.test2(0x0002);
		instance.test2(0x0001);
		instance.test2(0x0000);
		instance.test2(0xffff);
		instance.test2(0x03ff);
		instance.test2(0x03fe);
		instance.test2(0x03fd);
		instance.test2(0x0201);
		instance.test2(0x0200);
	}
}
