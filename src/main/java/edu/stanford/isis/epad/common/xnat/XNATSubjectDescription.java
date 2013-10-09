package edu.stanford.isis.epad.common.xnat;

/**
 * A description of an XNAT subject.
 * <p>
 * <code>curl -b JSESSIONID=[session_key] -X GET "http:[host:port]/projects/[project_id]/subjects/"</code>
 * <p>
 * Redirects to the XNAT call <code>/xnat/data/projects/..</code>, which returns a JSON-specified list of subjects for
 * the specified project, e.g.,
 * <p>
 * <code>
 * {
 * "ResultSet":
 *  { "Result":
 *    [ 
 *      {"project":"BOBP","insert_user":"bob","ID":"EPAD_S00002","insert_date":"2013-09-05 10:01:03.035","label":"SID1","URI":"/data/subjects/EPAD_S00002"},
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
	public final String project, insert_user, id, insert_date, label, uri;

	public XNATSubjectDescription(String project, String insert_user, String id, String insert_date, String label,
			String uri)
	{
		this.project = project;
		this.insert_user = insert_user;
		this.id = id;
		this.insert_date = insert_date;
		this.label = label;
		this.uri = uri;
	}
}
