package edu.stanford.epad.common.plugins;

import java.io.File;
import java.util.List;

/**
 * This is the interface for getting files from the ePAD.
 */
public interface EPadFiles
{
	/**
	 * Does the local DicomProxy have this study.
	 * 
	 * @param studyUID String
	 * @return boolean
	 */
	public boolean hasStudy(String studyUID);

	/**
	 * Get all the studies in the DicomProxy.
	 * 
	 * @return List<String>
	 */
	public List<String> getStudies();

	/**
	 * Does the DicomProxy have this series?
	 * 
	 * @param parentStudyUID study
	 * @param series String
	 * @return boolean
	 */
	public boolean hasSeries(String parentStudyUID, String series);

	/**
	 * Get a list of series for a study.
	 * 
	 * @param parentStudyUID String
	 * @return List of Strings
	 */
	public List<String> getSeries(String parentStudyUID);

	/**
	 * Get a list of file associated with an extension for a series.
	 * 
	 * @param seriesUID String
	 * @param extension String file extension
	 * @return List of file of extension type. If the files have an order, they are sorted.
	 */
	public List<File> getFiles(String seriesUID, String extension);

	/**
	 * Get the order of files.
	 * 
	 * @param seriesUID String seriesUID
	 * @return List of DICOM InstanceUID associated with a series.
	 */
	public List<String> getOrderOfFiles(String seriesUID);

	/**
	 * Return the number of annotation files in this series.
	 * 
	 * @param seriesUID String
	 * @return int
	 */
	public int hasAnnotations(String seriesUID);

	/**
	 * Get a list of all annotations for this series.
	 * 
	 * @param seriesUID String
	 * @return List of AIM annotation files for this series.
	 */
	public List<File> getAnnotations(String seriesUID);

	/**
	 * 
	 * @param aimXmlFile File
	 * @return True if the file is saved.
	 */
	public boolean saveAnnotationFile(File aimXmlFile);

	/**
	 * Get an Aim file by it's name. If the file doesn't exist then return null.
	 * 
	 * @param aimFileName String name of the AIM xml file like. AIM_1234567.xml
	 * @return File AIM xml file or null it name doesn't exist.
	 */
	public File getAimFile(String aimFileName);
}
