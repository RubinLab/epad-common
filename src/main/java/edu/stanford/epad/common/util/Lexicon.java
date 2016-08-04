package edu.stanford.epad.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import edu.stanford.hakan.aim4api.base.CD;
import edu.stanford.hakan.aim4api.utility.EPADConfig;


/* author Emel Alkim
 * holds lexicon for epad
 */

public class Lexicon extends HashMap<String, CD> {

	
	private static final long serialVersionUID = -8907800188313433052L;
	private static Lexicon ourInstance = null;
	private static final Logger logger = Logger.getLogger("Aim");
	private static String FILE_NAME="lexicon.csv";
	private final String ePadDesignator="99EPAD",ePadCodeSystem="99EPAD", ePadLexVersion="1.0";
	
	String username = EPADConfig.getInstance().getStringPropertyValue("epadDatabaseUsername");
	String password = EPADConfig.getInstance().getStringPropertyValue("epadDatabasePassword");
	String epadDatabaseURL = EPADConfig.getInstance().getStringPropertyValue("epadDatabaseURL");
	
	
	Connection conn ;
	public static Lexicon getInstance()
	{
		if (ourInstance == null)
			ourInstance = new Lexicon();
		return ourInstance;
	}
	
	public CD getDefaultAlgorithType(){
		return new CD("99EPADA0","NA",this.ePadDesignator);
	}
	public CD getDefaultDataType(){
		return new CD("99EPADD0","NA",this.ePadDesignator);
	}
	
//	public String getName(CD cdIn) {
//		for (Entry<String, CD> entry : this.entrySet()) {
//	        if (Objects.equals(cdIn, entry.getValue())) {
//	            return entry.getKey();
//	        }
//		}
//		return null;
//
//	}
	
	
//	ml just made up for displaying smt at least (jjvector and riesz) AnnotationExtender ln.58. It was meaningless things like description, etc.
//	 calculation.setDescription("Feature Extraction");
//     calculation.setCodeValue("99EPADC0");
//     calculation.setCodeMeaning("Feature Extraction");
//     calculation.setCodingSchemeDesignator("99EPAD");
	
	
//	  public ResultSet getLexes(String lex) throws SQLException {
//	        String sqlSelect = "SELECT * FROM lexicon WHERE( CODEMEANING = '" + lex + "' )";
//	        return this.statement.executeQuery(sqlSelect);
//	    }
	
	public CD getLex(String lex){
		//get from db
		if (conn==null) {
			try {
				conn = createConnection();
			} catch (SQLException e) {
				
				logger.warning("Create connection failed; debugInfo=" + e);
			}
		
		}
		
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sqlSelect = "SELECT * FROM lexicon WHERE( CODE_MEANING = '" + lex + "' )";
		CD cd=null;
		try {
			ps = conn.prepareStatement(sqlSelect);
			rs = ps.executeQuery();
			while (rs.next()) {
				cd =new CD(rs.getString("CODE_VALUE"),rs.getString("CODE_MEANING"),rs.getString("SCHEMA_DESIGNATOR"),rs.getString("SCHEMA_VERSION"));
			}
		} catch (SQLException sqle) {
			logger.warning("Database operation failed; debugInfo=" + sqle);
		} finally {
			close(c, ps, rs);
		}
		if (cd==null)
//			return new CD("99EPADD0","NA",this.ePadDesignator);
			return new CD("99EPADD0",lex,this.ePadDesignator);
		return cd;
	}
	private void close(Connection c, PreparedStatement ps, ResultSet rs)
	{
		close(c);
		close(ps);
		close(rs);
	}
	
	public static void close(Connection conn)
	{
		if (conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				logger.warning("Failed to close connection" + e);
			}
		}
	}
	public static void close(PreparedStatement ps)
	{
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				logger.warning("Failed to close prepared statement" + e);
			}
		}
	}

	public static void close(ResultSet rs)
	{
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				logger.warning("Failed to close result set" + e);
			}
		}
	}

	
	private Connection createConnection() throws SQLException
	{
		return DriverManager.getConnection(epadDatabaseURL, username, password);
	}

	
	
	private Lexicon()
	{
		
		
		//use this instead
//		loadFile(EPADResources.getEPADWebServerConfigFilePath()+"/"+FILE_NAME);
		
		
		String algPrefix="99EPADA";
		String dtPrefix="99EPADD";
		
		
		//RID12780 calculation jjvector!!!
		
		try {
			this.put("G-D7FE", new CD("G-D7FE","Length","SRT"));
			//algorithms, start with 99EPADA
			this.put(algPrefix+"1", new CD(algPrefix+"1","Calculation",ePadDesignator));
			this.put(algPrefix+"2", new CD(algPrefix+"2","Plugin",ePadDesignator));
			this.put(algPrefix+"3", new CD(algPrefix+"3","JJVector",ePadDesignator));
			
			
			//datatypes, start with 99EPADD
			this.put(dtPrefix+"1", new CD(dtPrefix+"1","Double",ePadDesignator));
			
			
			
			//
			this.put("RID39224", new CD("RID39224","Mean value calculation","RadLex","3.12"));
			this.put(algPrefix+"4", new CD(algPrefix+"4","Area",ePadDesignator));
			this.put(algPrefix+"5", new CD(algPrefix+"5","StandardDeviation",ePadDesignator));
			this.put(algPrefix+"6", new CD(algPrefix+"6","Min",ePadDesignator));
			this.put(algPrefix+"7", new CD(algPrefix+"7","Max",ePadDesignator));
			
			
		} catch (Exception e) {
			logger.info("Error getting lexicon "+ e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
	}
//	public void loadFile(String csvFile) {
//		BufferedReader br;
//		try {
//			br = new BufferedReader(new FileReader(csvFile));
//		
//			String line="";
//			String csvSplitBy = ",";
//			while ((line = br.readLine()) != null) {
//				line = line.trim(); // process the line.
//				// use comma as separator
//				if (!line.equals("")) {
//					String[] lex = line.split(csvSplitBy);
//		
//					this.put(lex[1], new CD(lex[1],lex[0],lex[2]));
//				}
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//			
//	}
	
	
//	public void loadFile(String csvFile ) {
//		StreamReader br = null;
//		String line = "";
//		String cvsSplitBy = ",";
//
//		try {
//			br = new StreamReader(csvFile);
//			while ((line = br.ReadLine()) != null) {
//
//				// use comma as separator
//				String[] lex = line.split(cvsSplitBy);
//
//				this.put(lex[1], new CD(lex[1],lex[0],lex[2]));
//
//			}
//
//		
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			if (br != null) {
//				try {
//					br.Close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}

}
