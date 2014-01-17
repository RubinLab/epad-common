package edu.stanford.isis.epad.common.xnat;

/**
 * A description of an XNAT subject.
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
public class XNATSubjectDescription
{
	public final String project, insert_user, id, insert_date, label, uri, src;

	public XNATSubjectDescription(String project, String insert_user, String id, String insert_date, String label,
			String uri, String src)
	{
		this.project = project;
		this.insert_user = insert_user;
		this.id = id;
		this.insert_date = insert_date;
		this.label = label;
		this.uri = uri;
		this.src = src;
	}
}
