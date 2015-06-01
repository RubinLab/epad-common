package edu.stanford.epad.common.pixelmed;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
	private short imageWidth = 0, imageHeight = 0, numberOfFrames = 0;

	private static final EPADLogger log = EPADLogger.getInstance();

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
	public String[] generateDSO(List<String> maskFilePaths, List<String> dicomFilePaths, String outputFilePath, String dsoSeriesDescription, String dsoSeriesUID, String dsoInstanceUID, boolean removeEmptyFrames)
			throws DicomException
	{
		try {
			// Following call fills in: dicomAttributes, orientation, spacing, thickness, positions, pixels, imageWidth,
			// imageHeight, imageFrames

			log.info("Reading pixels from mask files");
			byte[] pixels = getPixelsFromMaskFiles(maskFilePaths, dicomFilePaths, removeEmptyFrames);
			
			log.info("Getting attributes from DICOM files");
			getAttributesFromDICOMFiles(dicomFilePaths);

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
			dsoWriter.addAllFrames(pixels, numberOfFrames, imageWidth, imageHeight, "binary", (short)0, positions);
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

	private void getAttributesFromDICOMFiles(List<String> dicomFilePaths) throws FileNotFoundException, IOException,
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
			int[] instanceNos = new int[dicomFilePaths.size()];
			for (int i = 0; i < dicomFilePaths.size(); i++) {
				dicomInputFile = dicomFilePaths.get(i);
				dicomInputStream = new DicomInputStream(new FileInputStream(dicomInputFile));
				localDICOMAttributes.clear();
				localDICOMAttributes.read(dicomInputStream);
				Attribute attribute = localDICOMAttributes.get(TagFromName.ImagePositionPatient);
				if (attribute != null)
					this.positions[i] = attribute.getDoubleValues();
				if (i > 0)
				{
					dicomAttributes[i] = (AttributeList) localDICOMAttributes.clone();
					instanceNos[i] = Attribute.getSingleIntegerValueOrDefault(localDICOMAttributes, TagFromName.InstanceNumber, 1);
					System.out.println("Dicom file:" + (i+1) + " instance number:" + instanceNos[i]);
				}
			}
			for (int i = 0; i < instanceNos.length; i++) {
				for (int j = i+1; j < instanceNos.length; j++) {
					int instance = instanceNos[i];
					double[] position = positions[i];
					AttributeList alist = dicomAttributes[i];
					if (instanceNos[j] < instance) {
						instanceNos[i] = instanceNos[j];
						positions[i] = positions[j];
						dicomAttributes[i] = dicomAttributes[j];
						instanceNos[j] = instance;
						positions[j] = position;
						dicomAttributes[j] = alist;
					}
				}
			}
				
		} finally {
			IOUtils.closeQuietly(dicomInputStream);
		}
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
				System.out.println("Expected length, RGB:" + rgbLen + " BW:" + bwLen + " Grey:" + greyLen 
							+ " Actual tiff data len:" + new_frame.length);
			boolean nonzerodata = false;
			
			// looks like 4 bytes/pixel, compress to 1 bit/pixel (else assume it is already 1 bit/pixel)
			if (new_frame.length == rgbLen)
			{
				System.out.println("Compressing tiff mask from rgb, mask:" + i);
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
//					if (pixel_data[k] != 0)
//						log.info("maskfile" + i + ": " + k + " pixel:" + pixel_data[k]);
				}
			}
			else if (new_frame.length == greyLen)
			{
				System.out.println("Compressing tiff mask from grey, mask:" + i);
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
//					if (pixel_data[k] != 0)
//						log.info("maskfile" + i + ": " + k + " pixel:" + pixel_data[k]);
				}
			}
			else
			{
				System.out.println("Flipping odd bytes of bw tif, mask:" + i);
				int numbytes = maskImage.getWidth()*maskImage.getHeight()/8;
				pixel_data = new byte[numbytes];
				for (int k = 0; k < numbytes; k++)
				{
					// Flip every odd byte. why on earth do we need to do this?
					if (new_frame[k] != 0)
						nonzerodata = true;
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
//					if (pixel_data[k] != 0)
//						log.info("maskfile" + i + ": " + k + " pixel:" + pixel_data[k]);
				}
			}
//			log.info("maskfile" + i + ": " + maskFilePaths.get(i) + " frame_length:" + pixel_data.length + " nonzero data:" + nonzerodata);
			if (!nonzerodata && removeEmpty) {
				log.info("Nodata - maskfile" + i + ": " + maskFilePaths.get(i) + " frame_length:" + pixel_data.length);
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
		for (int i = emptyFileIndex.size(); i > 0; i--)
		{
			int index = emptyFileIndex.get(i-1);
			log.info("Removing dicom " + index);
			dicomFilePaths.remove(index);
		}
//		for (int i = 0; i < emptyFileIndex.size(); i++)
//		{
//			int index = emptyFileIndex.get(i);
//			log.info("Removing dicom " + (maskFilePaths.size() - index - 1));
//			dicomFilePaths.remove(maskFilePaths.size() - index - 1); // DicomFiles are in reverse order for!!!
//		}
		log.info("Number of pixels:" + pixels.length + " dicoms:" + dicomFilePaths.size());	
		return pixels;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
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
		if (maskFilePaths.size() == 0)
		{
			System.out.println("No Tif Mask files found");
			return;
		}

		if (dicomFilePaths.size() > maskFilePaths.size())
			dicomFilePaths = dicomFilePaths.subList(0, maskFilePaths.size());
		else if (maskFilePaths.size() > dicomFilePaths.size())
			maskFilePaths = maskFilePaths.subList(0, dicomFilePaths.size());

		try {
			TIFFMasksToDSOConverter converter = new TIFFMasksToDSOConverter();
			String[] uids = null;
			if (args.length > 3)
				uids = converter.generateDSO(maskFilePaths, dicomFilePaths, outputFileName, args[3]);
			else
				uids = converter.generateDSO(maskFilePaths, dicomFilePaths, outputFileName);
			System.out.println("DICOM Segmentation Object created. SeriesUID:" + uids[0] + " InstanceUID:" + uids[1]);
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace(System.err);
			System.exit(0);
		}
	}
}