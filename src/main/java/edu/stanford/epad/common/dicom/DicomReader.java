package edu.stanford.epad.common.dicom;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;

import org.apache.commons.io.IOUtils;
import org.dcm4che2.data.DicomObject;
import org.dcm4che2.data.Tag;
import org.dcm4che2.imageio.plugins.dcm.DicomImageReadParam;
import org.dcm4che2.imageioimpl.plugins.dcm.DicomImageReader;
import org.dcm4che2.imageioimpl.plugins.dcm.DicomImageReaderSpi;
import org.dcm4che2.io.DicomInputStream;
import org.dcm4che2.io.StopTagInputHandler;

import com.pixelmed.display.ConsumerFormatImageMaker;

import edu.stanford.epad.common.util.EPADLogger;

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
	private static final EPADLogger log = EPADLogger.getInstance();
	protected final File dicomFile;

	static {
		ImageIO.scanForPlugins();
	}
	
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
		BufferedImage image;

		try {
			fis = new FileImageInputStream(dicomFile);
			DicomImageReader codec = (DicomImageReader)new DicomImageReaderSpi().createReaderInstance();
			codec.setInput(fis);
			DicomImageReadParam param = (DicomImageReadParam)codec.getDefaultReadParam();
			image = codec.read(frameValue, param);
		} finally {
			if (fis != null)
				fis.close();
		}
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
		BufferedImage packedImage = null;

		try {
			StopTagInputHandler stop = new StopTagInputHandler(Tag.PixelData);
			log.info("" + Thread.currentThread().getId() + " Opening Dicom:" + dicomFile.getName());
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
			packedImage = rasterProcessor.buildPng(raster);
		} finally {
			IOUtils.closeQuietly(dis);
			if (fis != null)
				fis.close();
			log.info("" + Thread.currentThread().getId() + " Closed");
		}
		return packedImage;
	}

	// See http://forums.dcm4che.org/jiveforums/message.jspa?messageID=21407 for various ways of reading a DICOM file.
	public static String getPatientName(File dicomFile) throws IOException
	{
		DicomInputStream dis = null;
		String patientName = null;

		try {
			log.info("" + Thread.currentThread().getId() + " Opening Dicom:" + dicomFile.getName());
			dis = new DicomInputStream(dicomFile);
			dis.setHandler(new StopTagInputHandler(Tag.PixelData));
			DicomObject dicomObject = dis.readDicomObject();
			patientName = dicomObject.getString(Tag.PatientName);
		} finally {
			IOUtils.closeQuietly(dis);
			log.info("" + Thread.currentThread().getId() + " Closed");
		}
		return patientName;
	}

	public static String getPatientID(File dicomFile) throws IOException
	{
		DicomInputStream dis = null;
		String patientID = null;

		try {
			log.info("" + Thread.currentThread().getId() + " Opening Dicom:" + dicomFile.getName());
			dis = new DicomInputStream(dicomFile);
			dis.setHandler(new StopTagInputHandler(Tag.PixelData));
			DicomObject dicomObject = dis.readDicomObject();
			patientID = dicomObject.getString(Tag.PatientID);
		} finally {
			IOUtils.closeQuietly(dis);
			log.info("" + Thread.currentThread().getId() + " Closed");
		}
		return patientID;
	}

	public static String getStudyIUID(File dicomFile) throws IOException
	{
		DicomInputStream dis = null;
		String studyIUID = null;

		try {
			log.info("" + Thread.currentThread().getId() + " Opening Dicom:" + dicomFile.getName());
			dis = new DicomInputStream(dicomFile);
			dis.setHandler(new StopTagInputHandler(Tag.PixelData));
			DicomObject dicomObject = dis.readDicomObject();
			studyIUID = dicomObject.getString(Tag.StudyInstanceUID);
		} finally {
			IOUtils.closeQuietly(dis);
			log.info("" + Thread.currentThread().getId() + " Closed");
		}
		return studyIUID;
	}
	
	public static DicomObject getDicomObject(File dicomFile) throws IOException
	{
		DicomInputStream dis = null;

		try {
			log.info("" + Thread.currentThread().getId() + " Opening Dicom:" + dicomFile.getName());
			dis = new DicomInputStream(dicomFile);
			dis.setHandler(new StopTagInputHandler(Tag.PixelData));
			return dis.readDicomObject();
		} finally {
			IOUtils.closeQuietly(dis);
			log.info("" + Thread.currentThread().getId() + " Closed");
		}
	}
	
	public static String getModality(File dicomFile) throws IOException
	{
		DicomInputStream dis = null;
		String modality = null;

		try {
			log.info("" + Thread.currentThread().getId() + " Opening Dicom:" + dicomFile.getName());
			dis = new DicomInputStream(dicomFile);
			dis.setHandler(new StopTagInputHandler(Tag.PixelData));
			DicomObject dicomObject = dis.readDicomObject();
			modality = dicomObject.getString(Tag.Modality);
		} finally {
			IOUtils.closeQuietly(dis);
			log.info("" + Thread.currentThread().getId() + " Closed");
		}
		return modality;
	}
	
	/*
	 * Copied from dcmche forums (appears to be same as above method)
	 */
//	public void dcmconvpng2(int index, File pngFile) throws Exception{
//		ImageIO.scanForPlugins();
//		Iterator<ImageReader> iter = ImageIO.getImageReadersByFormatName("dicom");
//		 if (!iter.hasNext())
//			 throw new Exception("Dicom Reader not found");
//		ImageReader readers =  iter.next();//next item
//		DicomImageReadParam param = (DicomImageReadParam) readers.getDefaultReadParam();//return DicomImageReadParam
//		// Adjust the values of Rows and Columns in it and add a Pixel Data attribute with the byte array from the DataBuffer of the scaled Raster 
//
//		ImageInputStream iis = ImageIO.createImageInputStream(dicomFile);
//
//		readers.setInput(iis, true);//sets the input source to use the given ImageInputSteam or other Object 
//
//		BufferedImage myPngImage = readers.read(index, param); //read dicom 
//		OutputStream output = new BufferedOutputStream(new FileOutputStream(pngFile)); //BufferedOuput permit make file 
//		try {
//			PNGEncodeParam.RGB param2 = new PNGEncodeParam.RGB();
//			ImageEncoder enc = ImageCodec.createImageEncoder("PNG", output,param2);
//			enc.encode( myPngImage);
//		}
//		finally {
//			output.close();
//		}
//	}

	
	/*
	 * Pixelmed library
	 */
	public void dcmconvpng3(int index, File pngFile) throws Exception{
		ConsumerFormatImageMaker.convertFileToEightBitImage(dicomFile.getAbsolutePath(), pngFile.getAbsolutePath(), "png", index);
	}	

}
