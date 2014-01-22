package edu.stanford.isis.epad.common.xnat;

import java.util.Collections;
import java.util.List;

/**
 * A result from XNAT listing a set of projects.
 * <p>
 * Example invocation:
 * <p>
 * <code>curl -b JSESSIONID=[session_key] -X GET "http:[host:port]/epad/projects/"</code>
 * <p>
 * Redirects to the XNAT call <code>/xnat/data/projects</code>, which returns a JSON-specified list of projects, e.g.,
 * <p>
 * <code>
 * {
 * "ResultSet":
 *  { "Result":
 *    [ 
 *     {"secondary_ID":"epad-xnat","pi_lastname":"MrPI","description":"", "name":"XNAT Project","ID":"EPAD_PROJECT","pi_firstname":"An","URI":"/data/projects/EPAD_PROJECT"},
 *    ], 
 *    "totalRecords": "1"
 *  }
 * }
 * </code>
 * 
 * @author martin
 */
public class XNATProjectsResult
{
	public final XNATProjectResultSet ResultSet;

	public XNATProjectsResult(List<XNATProjectDescription> Result)
	{
		this.ResultSet = new XNATProjectResultSet(Result);
	}

	public XNATProjectsResult()
	{
		this.ResultSet = new XNATProjectResultSet();
	}

	public static XNATProjectsResult emptyProjects()
	{
		return new XNATProjectsResult();
	}

	public class XNATProjectResultSet
	{
		public final List<XNATProjectDescription> Result;
		public final int totalRecords;

		public XNATProjectResultSet(List<XNATProjectDescription> Result)
		{
			this.Result = Collections.unmodifiableList(Result);
			this.totalRecords = Result.size();
		}

		public XNATProjectResultSet()
		{
			this.Result = Collections.emptyList();
			this.totalRecords = 0;
		}
	}
}