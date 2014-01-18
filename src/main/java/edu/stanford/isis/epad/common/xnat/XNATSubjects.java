package edu.stanford.isis.epad.common.xnat;

import java.util.Collections;
import java.util.List;

/**
 * A result from XNAT listing a set of subjects.
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
public class XNATSubjects
{
	public final XNATSubjectResultSet ResultSet;

	public XNATSubjects(List<XNATSubjectDescription> Result)
	{
		this.ResultSet = new XNATSubjectResultSet(Result);
	}

	public XNATSubjects()
	{
		this.ResultSet = new XNATSubjectResultSet();
	}

	public static XNATSubjects emptySubjects()
	{
		return new XNATSubjects();
	}

	public class XNATSubjectResultSet
	{
		public final List<XNATSubjectDescription> Result;
		public final int totalRecords;

		public XNATSubjectResultSet(List<XNATSubjectDescription> Result)
		{
			this.Result = Collections.unmodifiableList(Result);
			this.totalRecords = Result.size();
		}

		public XNATSubjectResultSet()
		{
			this.Result = Collections.emptyList();
			this.totalRecords = 0;
		}
	}
}
