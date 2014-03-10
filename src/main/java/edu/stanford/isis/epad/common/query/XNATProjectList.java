package edu.stanford.isis.epad.common.query;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;

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
public class XNATProjectList
{
	public final XNATProjectResultSet ResultSet;

	public XNATProjectList(List<XNATProject> Result)
	{
		this.ResultSet = new XNATProjectResultSet(Result);
	}

	public XNATProjectList()
	{
		this.ResultSet = new XNATProjectResultSet();
	}

	public static XNATProjectList emptyProjects()
	{
		return new XNATProjectList();
	}

	public class XNATProjectResultSet
	{
		public final List<XNATProject> Result;
		public final int totalRecords;

		public XNATProjectResultSet(List<XNATProject> Result)
		{
			this.Result = Collections.unmodifiableList(Result);
			this.totalRecords = Result.size();
		}

		public XNATProjectResultSet()
		{
			this.Result = new ArrayList<XNATProject>();
			this.totalRecords = 0;
		}
	}

	public String toJSON()
	{
		Gson gson = new Gson();

		return gson.toJson(this);
	}
}