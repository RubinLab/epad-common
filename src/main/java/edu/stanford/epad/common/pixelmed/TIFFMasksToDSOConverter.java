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
	private AttributeList dicomAttributes = new AttributeList();
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
	 * @throws DicomException
	 */
	public void convert(List<String> maskFilePaths, List<String> dicomFilePaths, String outputFilePath)
			throws DicomException
	{
		try {
			// Following call fills in: dicomAttributes, orientation, spacing, thickness, positions, pixels, imageWidth,
			// imageHeight, imageFrames
			getAttributesFromDICOMFiles(dicomFilePaths);

			byte[] pixels = getPixelsFromMaskFiles(maskFilePaths);

			SegmentationObjectsFileWriter2 dsoWriter = new SegmentationObjectsFileWriter2(dicomAttributes, orientation,
					spacing, thickness);
			CodedConcept category = new CodedConcept("C0085089" /* conceptUniqueIdentifier */, "260787004" /* SNOMED CID */,
					"SRT" /* codingSchemeDesignator */, "SNM3" /* legacyCodingSchemeDesignator */,
					null /* codingSchemeVersion */, "A-00004" /* codeValue */, "Physical Object" /* codeMeaning */,
					null /* codeStringEquivalent */, null /* synonynms */);
			CodedConcept type = new CodedConcept("C0018787" /* conceptUniqueIdentifier */, "80891009" /* SNOMED CID */,
					"SRT" /* codingSchemeDesignator */, null /* legacyCodingSchemeDesignator */,
					null /* codingSchemeVersion */, "T-32000" /* codeValue */, "Heart" /* codeMeaning */,
					null /* codeStringEquivalent */, null /* synonynms */);

			dsoWriter.addOneSegment("Segment No.1 is for ...", category, type);
			dsoWriter.addAllFrames(pixels, numberOfFrames, imageWidth, imageHeight, "binary", (short)0, positions);
			dsoWriter.saveDicomFile(outputFilePath);
		} catch (Exception e) {
			log.warning("Error generating DSO: " + e.getMessage());
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

		this.dicomAttributes = (AttributeList)localDICOMAttributes.clone();
		this.imageWidth = (short)Attribute.getSingleIntegerValueOrDefault(localDICOMAttributes, TagFromName.Columns, 1);
		this.imageHeight = (short)Attribute.getSingleIntegerValueOrDefault(localDICOMAttributes, TagFromName.Rows, 1);
		this.numberOfFrames = (short)dicomFilePaths.size();

		{ // Get geometric info.
			Attribute dicomAttribute = localDICOMAttributes.get(TagFromName.SliceThickness);
			this.thickness = dicomAttribute.getSingleDoubleValueOrDefault(0.1);
			dicomAttribute = localDICOMAttributes.get(TagFromName.PixelSpacing);
			this.spacing = dicomAttribute.getDoubleValues();
			dicomAttribute = localDICOMAttributes.get(TagFromName.ImageOrientationPatient);
			String[] s = dicomAttribute.getStringValues();
			for (int i = 0; i < s.length; i++)
				this.orientation[i] = (short)Float.parseFloat(s[i]);
		}

		try { // Get sequence format. Get position of each frame.
			positions = new double[numberOfFrames][3];
			for (int i = 0; i < dicomFilePaths.size(); i++) {
				dicomInputFile = dicomFilePaths.get(i);
				dicomInputStream = new DicomInputStream(new FileInputStream(dicomInputFile));
				localDICOMAttributes.clear();
				localDICOMAttributes.read(dicomInputStream);
				Attribute attribute = localDICOMAttributes.get(TagFromName.ImagePositionPatient);
				this.positions[i] = attribute.getDoubleValues();
			}
		} finally {
			IOUtils.closeQuietly(dicomInputStream);
		}
	}

	private byte[] getPixelsFromMaskFiles(List<String> maskFilePaths) throws FileNotFoundException, IOException,
			DicomException
	{
		byte[] pixels = null;

		for (int i = 0; i < maskFilePaths.size(); i++) {
			File maskFile = new File(maskFilePaths.get(i));
			BufferedImage maskImage = ImageIO.read(maskFile);
			// BufferedImage bufferedImage = new BufferedImage(image.getWidth(), image.getHeight(),
			// BufferedImage.TYPE_BYTE_BINARY);
			byte[] new_frame = ((DataBufferByte)maskImage.getRaster().getDataBuffer()).getData();
			if (pixels == null) {
				pixels = new_frame.clone();
			} else {
				byte[] temp = new byte[pixels.length + new_frame.length];
				System.arraycopy(pixels, 0, temp, 0, pixels.length);
				System.arraycopy(new_frame, 0, temp, pixels.length, new_frame.length);
				pixels = temp.clone();
			}
		}
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

		List<String> dicomFilePaths = listFilesInAlphabeticOrder(dicomFilesDirectory);
		List<String> maskFilePaths = listFilesInAlphabeticOrder(maskFilesDirectory);

		if (dicomFilePaths.size() > maskFilePaths.size())
			dicomFilePaths = dicomFilePaths.subList(0, maskFilePaths.size());
		else if (maskFilePaths.size() > dicomFilePaths.size())
			maskFilePaths = maskFilePaths.subList(0, dicomFilePaths.size());

		try {
			TIFFMasksToDSOConverter converter = new TIFFMasksToDSOConverter();
			converter.convert(maskFilePaths, dicomFilePaths, outputFileName);
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace(System.err);
			System.exit(0);
		}
	}
}