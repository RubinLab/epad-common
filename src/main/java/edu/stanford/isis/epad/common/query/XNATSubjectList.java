package edu.stanford.isis.epad.common.query;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;

/**
 * A result from XNAT listing a set of subjects. This is the default structure returned from an XNAT subject query.
 * <p>
 * Example query:
 * <p>
 * <code>curl -b JSESSIONID=[session_key] -X GET "http:[host:port]/epad/projects/[project_id]/subjects/"</code>
 * <p>
 * Redirects to the XNAT call <code>/xnat/data/projects/..</code>, which returns a JSON-specified list of subjects for
 * the specified project, e.g.,
 * <p>
 * <code>
 * {
 * "ResultSet":
 *  { "Result":
 *    [ 
 *      {"project":"PRJ1","insert_user":"bob","ID":"EPAD_S00002","insert_date":"...","label":"SID1","URI":"/data/subjects/EPAD_S00002", "src": ""},
 *    ], 
 *    "totalRecords": "1"
 *  }
 * }
 * </code>
 * 
 * @author martin
 */
public class XNATSubjectList
{
	public final XNATSubjectResultSet ResultSet;

	public XNATSubjectList(List<XNATSubject> Result)
	{
		this.ResultSet = new XNATSubjectResultSet(Result);
	}

	public XNATSubjectList()
	{
		this.ResultSet = new XNATSubjectResultSet();
	}

	public static XNATSubjectList emptySubjects()
	{
		return new XNATSubjectList();
	}

	public class XNATSubjectResultSet
	{
		public final List<XNATSubject> Result;
		public final int totalRecords;

		public XNATSubjectResultSet(List<XNATSubject> Result)
		{
			this.Result = Collections.unmodifiableList(Result);
			this.totalRecords = Result.size();
		}

		public XNATSubjectResultSet()
		{
			this.Result = new ArrayList<XNATSubject>();
			this.totalRecords = 0;
		}
	}

	public String toJSON()
	{
		Gson gson = new Gson();

		return gson.toJson(this);
	}
}
