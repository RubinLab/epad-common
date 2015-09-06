package edu.stanford.epad.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 * Plugin database operations
 * @author Emel Alkim
 *
 */

public class PluginDBUtil {
	
	private static final EPADLogger log = EPADLogger.getInstance();

	/**
	 * Gets handler, template and name lists to fill
	 * @param pluginHandlerList
	 * @param pluginTemplateList
	 * @param pluginNameList
	 * @return true if table is not empty
	 * @throws Exception
	 */
	public static boolean getPlugins(List<String> pluginHandlerList,List<String> pluginTemplateList,List<String> pluginNameList) throws Exception
	{
		String username = EPADConfig.epadDatabaseUsername;
		String password = EPADConfig.epadDatabasePassword;
		String epadDatabaseURL = EPADConfig.epadDatabaseURL;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = null;
		Statement statement = null;
		ResultSet rs = null;
		try
		{
			con = DriverManager.getConnection(epadDatabaseURL, username, password);
    	    String sql = "SELECT javaclass,plugin_id,name from plugin ";
            log.info("Plugin list select:" + sql);
			statement = con.createStatement();
			rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				pluginHandlerList.add(rs.getString(1));
				pluginTemplateList.add(rs.getString(2));
				pluginNameList.add(rs.getString(3));
			}
			
			if (pluginHandlerList.isEmpty())
				return false;
			return true;
			
		}
		finally
		{
			if (rs != null) rs.close();
			if (statement != null) statement.close();
			if (con != null) con.close();
		}
	}

	public static void addPlugin(String handlerClass,String pluginId,String pluginName) throws Exception
	{
		String username = EPADConfig.epadDatabaseUsername;
		String password = EPADConfig.epadDatabasePassword;
		String epadDatabaseURL = EPADConfig.epadDatabaseURL;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = null;
		Statement statement = null;
		try
		{
			con = DriverManager.getConnection(epadDatabaseURL, username, password);
    	    String sql = "INSERT into plugin (javaclass,plugin_id,name) values( '" + handlerClass + "','" +  pluginId + "','" + pluginName + "')";
			statement = con.createStatement();
			statement.executeUpdate(sql);
		}
		finally
		{
			if (statement != null) statement.close();
			if (con != null) con.close();
		}
	}
}
