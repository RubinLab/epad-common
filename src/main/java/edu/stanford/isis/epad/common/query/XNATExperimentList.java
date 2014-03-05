package edu.stanford.isis.epad.common.query;

import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;

/**
 * A result from XNAT listing a set of experiments.
 * <p>
 * <code>curl -b JSESSIONID=[session_key] -X GET "http:[host:port]/epad/projects/[project_id]/subjects/[subject_id]/experiments"</code>
 * <p>
 * Redirects to the XNAT call <code>/xnat/data/projects/..</code>, which returns a JSON-specified list of subjects for
 * the specified project, e.g.,
 * <p>
 * <code>
 * {
 * "ResultSet":
 *  { "Result":
 *    [ 
 *      {"project":"PRJ1","xsiType":"...","ID":"...","insert_date":"...","label":"SID1", "date":"...", "URI":"/data/subjects/EPAD_S00002"}  
 *    ], 
 *    "totalRecords": "1"
 *  }
 * }
 * </code>
 * 
 * @author martin
 */
public class XNATExperimentList
{
	public final XNATExperimentResultSet ResultSet;

	public XNATExperimentList(List<XNATExperiment> Result)
	{
		this.ResultSet = new XNATExperimentResultSet(Result);
	}

	public XNATExperimentList()
	{
		this.ResultSet = new XNATExperimentResultSet();
	}

	public static XNATExperimentList emptyExperiments()
	{
		return new XNATExperimentList();
	}

	public class XNATExperimentResultSet
	{
		public final List<XNATExperiment> Result;
		public final int totalRecords;

		public XNATExperimentResultSet(List<XNATExperiment> Result)
		{
			this.Result = Collections.unmodifiableList(Result);
			this.totalRecords = Result.size();
		}

		public XNATExperimentResultSet()
		{
			this.Result = Collections.emptyList();
			this.totalRecords = 0;
		}
	}

	public String toJSON()
	{
		Gson gson = new Gson();

		return gson.toJson(this);
	}
}
