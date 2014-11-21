package edu.stanford.epad.common.plugins;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import edu.stanford.epad.common.util.EPADLogger;
import edu.stanford.hakan.aim3api.base.AimException;

/**
 * TODO This text-based approach to extracting content from an AIM file is terrible and should be replaced.
 * <p>
 * It is used only by the TedSeg and JJJector plugins.
 */
public class PluginAIMContentUtil
{
	private static final EPADLogger log = EPADLogger.getInstance();

	public static String getAimFileContents(File aimFile) throws AimException
	{
		if (aimFile.exists()) {
			StringBuilder sb = new StringBuilder();
			try {
				BufferedReader in = new BufferedReader(new FileReader(aimFile));
				try {
					String line = null;
					while ((line = in.readLine()) != null) {
						sb.append(line);
						sb.append(System.getProperty("line.separator"));
					}
				} finally {
					in.close();
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			return sb.toString();
		} else {
			log.warning("AIM file " + aimFile.getAbsolutePath() + "does not exist");
			throw new AimException("input error - AIM.xml does not exist. file: " + aimFile.getAbsolutePath());
		}
	}

	public static String getStudyUID(String aimFileContents) throws PluginServletException
	{
		return getUIDFromAIM("Study", "instanceUID", aimFileContents);
	}

	public static String getSeriesUID(String aimFileContents) throws PluginServletException
	{
		return getUIDFromAIM("Series", "instanceUID", aimFileContents);
	}

	public static String getSOPInstanceUID(String aimFileContents) throws PluginServletException
	{
		return getUIDFromAIM("Image", "sopInstanceUID", aimFileContents);
	}

	public static String getSecondSeriesUID(String aimFileContents) throws PluginServletException
	{
		return getUIDFromAIM("<ImageSeries ", "instanceUID", aimFileContents, 2);
	}

	public static String getSecondSOPInstanceUID(String aimFileContents) throws PluginServletException
	{
		return getUIDFromAIM("<Image ", "sopInstanceUID", aimFileContents, 2);
	}

	/**
	 * This data comes from a AIM-Template.
	 * 
	 * Look for: <AnatomicEntity annotatorConfidence="0.0" cagridId="0" codeMeaning="Lung CT" codeValue="jjv-1"
	 * codingSchemeDesignator="JJV" label="Organ Type"/>
	 * 
	 * @param aimFileContents String
	 * @return String
	 * @throws edu.stanford.epad.common.plugins.PluginServletException
	 */
	public static String getOrganFromAimFile(String aimFileContents) throws PluginServletException
	{
		String templateOrganValue = null;
		int indexOfEntity = -2;
		int indexOfCodeMeaning = -2;
		int indexOfStartQuote = -2;
		int indexOfEndQuote = -2;

		try {
			indexOfEntity = aimFileContents.indexOf("AnatomicEntity");
			indexOfCodeMeaning = aimFileContents.indexOf("codeMeaning", indexOfEntity + 1);
			indexOfStartQuote = aimFileContents.indexOf("\"", indexOfCodeMeaning + 1);
			indexOfEndQuote = aimFileContents.indexOf("\"", indexOfStartQuote + 1);

			// get the substring.
			templateOrganValue = aimFileContents.substring(indexOfStartQuote, indexOfEndQuote - 1);

			// clean value up.
			templateOrganValue = templateOrganValue.replace("\"", " ");
			templateOrganValue = templateOrganValue.trim();
			templateOrganValue = templateOrganValue.toLowerCase();

		} catch (Exception e) {
			StringBuilder sb = new StringBuilder();

			sb.append("templateOrganValue=").append(templateOrganValue);
			sb.append("indexOfEntity=").append("" + indexOfEntity);
			sb.append("indexOfCodeMeaning=").append(indexOfCodeMeaning);
			sb.append("indexOfStartQuote=").append(indexOfStartQuote);
			sb.append("indexOfEndQuote=").append(indexOfEndQuote);
			sb.append("\n\n");
			sb.append(aimFileContents);

			throw new PluginServletException("Invalid input.", "Had: " + e.getMessage() + ". data:" + sb.toString());
		}

		if (templateOrganValue.contains("liver")) {
			return "Liver";
		} else if (templateOrganValue.contains("lung")) {
			return "Lung";
		} else if (templateOrganValue.contains("breast")) {
			return "Breast";
		} else if (templateOrganValue.contains("bone")) {
			return "Bone";
		}
		throw new PluginServletException("Invalid input.", "Invalid input: templateOrganValue=" + templateOrganValue);
	}

	private static String getUIDFromAIM(String tag, String attribute, String aimFileContents)
			throws PluginServletException
	{
		return getUIDFromAIM(tag, attribute, aimFileContents, 1);
	}
	private static String getUIDFromAIM(String tag, String attribute, String aimFileContents, int index)
			throws PluginServletException
	{

		tag = tag.toLowerCase();
		attribute = attribute.toLowerCase();
		aimFileContents = aimFileContents.toLowerCase();

		int fromIndex = 0;
		int tagIndex = 0;
		while (fromIndex < aimFileContents.length() && tagIndex != -1 && index > 0)
		{
			tagIndex = aimFileContents.indexOf(tag, fromIndex);
			index--;
			fromIndex = tagIndex + tag.length();
			//log.info(" tagIndex=" + tagIndex + " fromIndex=" + fromIndex + " index=" + index);
		}
		
		if (tagIndex > 0) {
			int attribIndex = aimFileContents.indexOf(attribute, tagIndex);

			if (attribIndex > 0) {

				int start = aimFileContents.indexOf("\"", attribIndex);
				int end = aimFileContents.indexOf("\"", start + 1);

				String retVal = aimFileContents.substring(start, end + 1);
				retVal = retVal.replace('"', ' ').trim();
				return retVal;
			} else {
				throw new PluginServletException("input error", "Didn't find attribute: " + attribute + " in tag:" + tag);
			}
		} else {
			log.warning("Didn't find tag: " + tag);
			return null;
		}
	}

}
