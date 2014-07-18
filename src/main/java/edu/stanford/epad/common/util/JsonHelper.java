package edu.stanford.epad.common.util;

/**
 * Help with processing of JSON objects.
 * 
 * @author Bradley Ross
 * 
 *         Class extracted from https://bmir-gforge.stanford.edu/svn/dirac/trunk/ePAD/ePAD-2012/DicomInterface to remove
 *         dependency.
 */
public class JsonHelper
{
	/**
	 * Precede double quotes with a backslash.
	 * 
	 * @param value string to be processed
	 * @return processed string
	 */
	public static String escape(String value)
	{
		return value.replaceAll("\\\\", "\\\\\\\\").replaceAll("\"", "\\\\\"").replaceAll("\'", "\\\\\'");
	}

	public static String createJSONErrorResponse(String errorMessage)
	{
		return "{ \"error\": \"" + errorMessage + "\" }";
	}
}
