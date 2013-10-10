package edu.stanford.isis.epad.common.xnat;

/**
 * A description of an XNAT experiment.
 * <p>
 * <code>curl -b JSESSIONID=[session_key] -X GET "http:[host:port]/projects/[project_id]/subjects/[subject_id]/experiments"</code>
 * <p>
 * Redirects to the XNAT call <code>/xnat/data/projects/..</code>, which returns a JSON-specified list of subjects for
 * the specified project, e.g.,
 * <p>
 * <code>
 * {
 * "ResultSet":
 *  { "Result":
 *    [ 
 *      
 *    ], 
 *    "totalRecords": "1"
 *  }
 * }
 * </code>
 * 
 * @author martin
 */
public class XNATExperimentDescription
{
	public final String project, xsiType, id, insert_date, label, date, uri;

	public XNATExperimentDescription(String project, String xsiType, String id, String insert_date, String label,
			String date, String uri)
	{
		this.project = project;
		this.xsiType = xsiType;
		this.id = id;
		this.insert_date = insert_date;
		this.label = label;
		this.date = date;
		this.uri = uri;
	}
}
