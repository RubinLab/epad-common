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

import com.pixelmed.anatproc.CodedConcept;
import com.pixelmed.dicom.Attribute;
import com.pixelmed.dicom.AttributeList;
import com.pixelmed.dicom.DicomException;
import com.pixelmed.dicom.DicomInputStream;
import com.pixelmed.dicom.TagFromName;

/**
 * <p>
 * A class for converting segmentation results in TIFF files to DICOM segmentation objects.
 * 
 * @author Wei Lu (luwei@tju.edu.cn)
 * @date 2013-5
 */
public class TIFFMasksToDSOConverter
{
	private AttributeList attributeList = new AttributeList();
	private final short[] orientation = new short[] { 1, 0, 0, 0, 0, 1 };
	private double[] spacing = new double[] { 0.65, 0.8 };
	private double thickness = 0.5;
	private double[][] positions = null;
	private byte[] pixels = null;
	private short imageWidth = 0, imageHeight = 0, imageFrames = 0;

	/**
	 * @param maskFiles: Array of the TIFF files which save the masks.
	 * @param dicomFiles: Array of the original DICOM files.
	 * @param outputFile: Name of the output segmentation objects file.
	 * @throws DicomException
	 * @throws IOException
	 */
	public void convert(List<String> maskFiles, List<String> dicomFiles, String outputFile) throws DicomException,
			IOException
	{
		try {
			// Fills in: attributeList, orientation, spacing, thickness, positions, pixels
			getAttributesFromDICOMFiles(dicomFiles);
			getPixelsFromMaskFiles(maskFiles);
		} catch (Exception e) {
			throw (new DicomException("Error reading dicom files: " + e.getMessage()));
		}

		SegmentationObjectsFileWriter dsoWriter = new SegmentationObjectsFileWriter(attributeList, orientation, spacing,
				thickness);
		CodedConcept category = new CodedConcept("260787004" /* conceptUniqueIdentifier */,
				"SRT" /* codingSchemeDesignator */, "SNM3" /* legacyCodingSchemeDesignator */,
				null /* codingSchemeVersion */, "A-00004" /* codeValue */, "Physical Object" /* codeMeaning */,
				null /* codeStringEquivalent */, null /* synonynms */);
		CodedConcept type = new CodedConcept(null /* conceptUniqueIdentifier */, "SRT" /* codingSchemeDesignator */,
				null /* legacyCodingSchemeDesignator */, null /* codingSchemeVersion */, "T-32000" /* codeValue */,
				"Heart" /* codeMeaning */, null /* codeStringEquivalent */, null /* synonynms */);

		dsoWriter.addOneSegment("Segment No.1 is for ...", category, type);

		dsoWriter.addAllFrames(pixels, imageFrames, imageWidth, imageHeight, "binary", (short)0, positions);

		dsoWriter.saveDicomFile(outputFile);
	}

	/**
	 * List the files in the assigned path and sort the filenames in alphabetic order.
	 * 
	 * @param folderPath
	 * @return Names of the files.
	 */
	public static List<String> listFilesInAlphabeticOrder(String folderPath)
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

	private void getAttributesFromDICOMFiles(List<String> dicomFilenames) throws FileNotFoundException, IOException,
			DicomException
	{
		AttributeList localAttributeList = new AttributeList();
		String dicomInputFile = null;
		DicomInputStream dicomInputStream = null;

		// Get common attributes from the first input file.
		dicomInputFile = dicomFilenames.get(0);
		try {
			dicomInputStream = new DicomInputStream(new FileInputStream(dicomInputFile));
		} finally {
			if (dicomInputStream != null) {
				dicomInputStream.close();
				dicomInputStream = null;
			}
		}
		localAttributeList.read(dicomInputStream);
		this.attributeList = (AttributeList)localAttributeList.clone();

		this.imageWidth = (short)Attribute.getSingleIntegerValueOrDefault(localAttributeList, TagFromName.Columns, 1);
		this.imageHeight = (short)Attribute.getSingleIntegerValueOrDefault(localAttributeList, TagFromName.Rows, 1);
		this.imageFrames = (short)dicomFilenames.size();
		// Get geometric info.
		{
			Attribute attribute = localAttributeList.get(TagFromName.SliceThickness);
			this.thickness = attribute.getSingleDoubleValueOrDefault(0.1);
			attribute = localAttributeList.get(TagFromName.PixelSpacing);
			this.spacing = attribute.getDoubleValues();
			attribute = localAttributeList.get(TagFromName.ImageOrientationPatient);
			String[] s = attribute.getStringValues();
			for (int i = 0; i < s.length; i++)
				this.orientation[i] = (short)Float.parseFloat(s[i]);
		}

		// Get position of each frame.
		try { // Get sequence format.
			positions = new double[imageFrames][3];
			for (int i = 0; i < dicomFilenames.size(); i++) {
				dicomInputFile = dicomFilenames.get(i);
				dicomInputStream = new DicomInputStream(new FileInputStream(dicomInputFile));
				localAttributeList.clear();
				localAttributeList.read(dicomInputStream);
				Attribute attribute = localAttributeList.get(TagFromName.ImagePositionPatient);
				this.positions[i] = attribute.getDoubleValues();
			}
		} finally {
			if (dicomInputStream != null)
				dicomInputStream.close();
		}
	}

	private void getPixelsFromMaskFiles(List<String> maskFileNames) throws FileNotFoundException, IOException,
			DicomException
	{
		for (int i = 0; i < maskFileNames.size(); i++) {
			File maskFile = new File(maskFileNames.get(i));
			BufferedImage maskImage = ImageIO.read(maskFile);
			// BufferedImage bufferedImage = new BufferedImage(image.getWidth(), image.getHeight(),
			// BufferedImage.TYPE_BYTE_BINARY);
			byte[] new_frame = ((DataBufferByte)maskImage.getRaster().getDataBuffer()).getData();
			if (this.pixels == null) {
				this.pixels = new_frame.clone();
			} else {
				byte[] temp = new byte[pixels.length + new_frame.length];
				System.arraycopy(pixels, 0, temp, 0, this.pixels.length);
				System.arraycopy(new_frame, 0, temp, this.pixels.length, new_frame.length);
				this.pixels = temp.clone();
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String maskFilesDirectory = args[0];
		String dicomFilesDirectory = args[1];
		String outputFileName = args[2];

		List<String> dicomFileNames = listFilesInAlphabeticOrder(dicomFilesDirectory);
		List<String> maskFileNames = listFilesInAlphabeticOrder(maskFilesDirectory);

		if (dicomFileNames.size() > maskFileNames.size())
			dicomFileNames = dicomFileNames.subList(0, maskFileNames.size());
		else if (maskFileNames.size() > dicomFileNames.size())
			maskFileNames = maskFileNames.subList(0, dicomFileNames.size());

		try {
			TIFFMasksToDSOConverter converter = new TIFFMasksToDSOConverter();
			converter.convert(maskFileNames, dicomFileNames, outputFileName);
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace(System.err);
			System.exit(0);
		}
	}
}