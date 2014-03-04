package edu.stanford.isis.epad.common.dicom;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

// import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.FileImageInputStream;

import org.dcm4che2.data.DicomObject;
import org.dcm4che2.data.Tag;
import org.dcm4che2.imageio.plugins.dcm.DicomImageReadParam;
import org.dcm4che2.imageioimpl.plugins.dcm.DicomImageReader;
import org.dcm4che2.imageioimpl.plugins.dcm.DicomImageReaderSpi;
import org.dcm4che2.io.DicomInputStream;
import org.dcm4che2.io.StopTagInputHandler;

/**
 * Read a DICOM instance and generate a variety of other formats that can be used to create files.
 * 
 * @author Bradley Ross
 * @see edu.stanford.aim.proxy.servlet.files.GetJpeg
 * @see RasterProcessor
 * 
 *      Class extracted from https://bmir-gforge.stanford.edu/svn/dirac/trunk/ePAD/ePAD-2012/DicomInterface to remove
 *      dependency.
 */
public class DicomReader
{
	protected final File dicomFile;

	public DicomReader(File dicomFile)
	{
		this.dicomFile = dicomFile;
	}

	/**
	 * Generate a buffered image using the parameters in the file.
	 * 
	 * @param frameValue frame number
	 * @return image
	 * @throws IOException
	 */
	public BufferedImage getImage(int frameValue) throws IOException
	{
		FileImageInputStream fis = null;
		fis = new FileImageInputStream(dicomFile);
		DicomImageReader codec = (DicomImageReader)new DicomImageReaderSpi().createReaderInstance();
		codec.setInput(fis);
		DicomImageReadParam param = (DicomImageReadParam)codec.getDefaultReadParam();
		BufferedImage image = codec.read(frameValue, param);
		fis.close();
		return image;
	}

	/**
	 * Generate a buffered image with the high order bits of PixelData in the red channel and low order bits in the green
	 * channel.
	 * 
	 * @return image
	 * @throws IOException
	 */
	public BufferedImage getPackedImage() throws IOException
	{
		return getPackedImage(0);
	}

	/**
	 * Generate a buffered image with the high order bits of PixelData in the red channel and low order bits in the green
	 * channel.
	 * 
	 * @param frameValue frame number
	 * @return image
	 * @throws IOException
	 */
	public BufferedImage getPackedImage(int frameValue) throws IOException
	{
		FileImageInputStream fis = null;
		DicomInputStream dis = null;
		StopTagInputHandler stop = new StopTagInputHandler(Tag.PixelData);
		dis = new DicomInputStream(dicomFile);
		dis.setHandler(stop);
		DicomObject object = dis.readDicomObject();
		RasterProcessor rasterProcessor = new RasterProcessor(object);
		dis.close();
		fis = new FileImageInputStream(dicomFile);
		DicomImageReader codec = (DicomImageReader)new DicomImageReaderSpi().createReaderInstance();
		codec.setInput(fis);
		DicomImageReadParam param = (DicomImageReadParam)codec.getDefaultReadParam();
		Raster raster = codec.readRaster(frameValue, param);
		BufferedImage packedImage = rasterProcessor.buildPng(raster);
		dis.close();
		fis.close();
		return packedImage;
	}

	// See http://forums.dcm4che.org/jiveforums/message.jspa?messageID=21407 for various ways of reading a DICOM file.
	public static String getPatientName(File dicomFile) throws IOException
	{
		DicomInputStream dis = new DicomInputStream(dicomFile);
		DicomObject dicomObject = dis.readDicomObject();
		String patientName = dicomObject.getString(Tag.PatientName);
		dis.close();
		return patientName;
	}

	public static String getPatientID(File dicomFile) throws IOException
	{
		DicomInputStream dis = new DicomInputStream(dicomFile);
		DicomObject dicomObject = dis.readDicomObject();
		String patientID = dicomObject.getString(Tag.PatientID);
		dis.close();
		return patientID;
	}

	public static String getStudyIUID(File dicomFile) throws IOException
	{
		DicomInputStream dis = new DicomInputStream(dicomFile);
		DicomObject dicomObject = dis.readDicomObject();
		String studyIUID = dicomObject.getString(Tag.StudyInstanceUID);
		dis.close();
		return studyIUID;
	}
}
