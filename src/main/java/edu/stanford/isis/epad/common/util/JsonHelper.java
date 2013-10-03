package edu.stanford.isis.epad.common.util;

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

	public static String createJSONErrorResponse(String errorMessage, Throwable t)
	{
		return "{ \"error\": \"" + errorMessage + ": " + t.getMessage() + "\" }";
	}

	/**
	 * Test driver.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args)
	{
		String[] tests = { "abcdef\\a\\\'\\\"", "abc" };
		for (int i = 0; i < tests.length; i++) {
			System.out.println("*****  *****");
			System.out.println(tests[i]);
			System.out.println(escape(tests[i]));
		}
	}
}
