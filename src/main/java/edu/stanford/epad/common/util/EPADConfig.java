/*******************************************************************************
 * Copyright (c) 2015 The Board of Trustees of the Leland Stanford Junior University
 * BY CLICKING ON "ACCEPT," DOWNLOADING, OR OTHERWISE USING EPAD, YOU AGREE TO THE FOLLOWING TERMS AND CONDITIONS:
 * STANFORD ACADEMIC SOFTWARE SOURCE CODE LICENSE FOR
 * "ePAD Annotation Platform for Radiology Images"
 *
 * This Agreement covers contributions to and downloads from the ePAD project ("ePAD") maintained by The Board of Trustees 
 * of the Leland Stanford Junior University ("Stanford"). 
 *
 * *	Part A applies to downloads of ePAD source code and/or data from ePAD. 
 *
 * *	Part B applies to contributions of software and/or data to ePAD (including making revisions of or additions to code 
 * and/or data already in ePAD), which may include source or object code. 
 *
 * Your download, copying, modifying, displaying, distributing or use of any ePAD software and/or data from ePAD 
 * (collectively, the "Software") is subject to Part A. Your contribution of software and/or data to ePAD (including any 
 * that occurred prior to the first publication of this Agreement) is a "Contribution" subject to Part B. Both Parts A and 
 * B shall be governed by and construed in accordance with the laws of the State of California without regard to principles 
 * of conflicts of law. Any legal action involving this Agreement or the Research Program will be adjudicated in the State 
 * of California. This Agreement shall supersede and replace any license terms that you may have agreed to previously with 
 * respect to ePAD.
 *
 * PART A. DOWNLOADING AGREEMENT - LICENSE FROM STANFORD WITH RIGHT TO SUBLICENSE ("SOFTWARE LICENSE").
 * 1. As used in this Software License, "you" means the individual downloading and/or using, reproducing, modifying, 
 * displaying and/or distributing Software and the institution or entity which employs or is otherwise affiliated with you. 
 * Stanford  hereby grants you, with right to sublicense, with respect to Stanford's rights in the Software, a 
 * royalty-free, non-exclusive license to use, reproduce, make derivative works of, display and distribute the Software, 
 * provided that: (a) you adhere to all of the terms and conditions of this Software License; (b) in connection with any 
 * copy, distribution of, or sublicense of all or any portion of the Software, the terms and conditions in this Software 
 * License shall appear in and shall apply to such copy and such sublicense, including without limitation all source and 
 * executable forms and on any user documentation, prefaced with the following words: "All or portions of this licensed 
 * product  have been obtained under license from The Board of Trustees of the Leland Stanford Junior University. and are 
 * subject to the following terms and conditions" AND any user interface to the Software or the "About" information display 
 * in the Software will display the following: "Powered by ePAD http://epad.stanford.edu;" (c) you preserve and maintain 
 * all applicable attributions, copyright notices and licenses included in or applicable to the Software; (d) modified 
 * versions of the Software must be clearly identified and marked as such, and must not be misrepresented as being the 
 * original Software; and (e) you consider making, but are under no obligation to make, the source code of any of your 
 * modifications to the Software freely available to others on an open source basis.
 *
 * 2. The license granted in this Software License includes without limitation the right to (i) incorporate the Software 
 * into your proprietary programs (subject to any restrictions applicable to such programs), (ii) add your own copyright 
 * statement to your modifications of the Software, and (iii) provide additional or different license terms and conditions 
 * in your sublicenses of modifications of the Software; provided that in each case your use, reproduction or distribution 
 * of such modifications otherwise complies with the conditions stated in this Software License.
 * 3. This Software License does not grant any rights with respect to third party software, except those rights that 
 * Stanford has been authorized by a third party to grant to you, and accordingly you are solely responsible for (i) 
 * obtaining any permissions from third parties that you need to use, reproduce, make derivative works of, display and 
 * distribute the Software, and (ii) informing your sublicensees, including without limitation your end-users, of their 
 * obligations to secure any such required permissions.
 * 4. You agree that you will use the Software in compliance with all applicable laws, policies and regulations including, 
 * but not limited to, those applicable to Personal Health Information ("PHI") and subject to the Institutional Review 
 * Board requirements of the your institution, if applicable. Licensee acknowledges and agrees that the Software is not 
 * FDA-approved, is intended only for research, and may not be used for clinical treatment purposes. Any commercialization 
 * of the Software is at the sole risk of you and the party or parties engaged in such commercialization. You further agree 
 * to use, reproduce, make derivative works of, display and distribute the Software in compliance with all applicable 
 * governmental laws, regulations and orders, including without limitation those relating to export and import control.
 * 5. You or your institution, as applicable, will indemnify, hold harmless, and defend Stanford against any third party 
 * claim of any kind made against Stanford arising out of or related to the exercise of any rights granted under this 
 * Agreement, the provision of Software, or the breach of this Agreement. Stanford provides the Software AS IS and WITH ALL 
 * FAULTS.  Stanford makes no representations and extends no warranties of any kind, either express or implied.  Among 
 * other things, Stanford disclaims any express or implied warranty in the Software:
 * (a)  of merchantability, of fitness for a particular purpose,
 * (b)  of non-infringement or 
 * (c)  arising out of any course of dealing.
 *
 * Title and copyright to the Program and any associated documentation shall at all times remain with Stanford, and 
 * Licensee agrees to preserve same. Stanford reserves the right to license the Program at any time for a fee.
 * 6. None of the names, logos or trademarks of Stanford or any of Stanford's affiliates or any of the Contributors, or any 
 * funding agency, may be used to endorse or promote products produced in whole or in part by operation of the Software or 
 * derived from or based on the Software without specific prior written permission from the applicable party.
 * 7. Any use, reproduction or distribution of the Software which is not in accordance with this Software License shall 
 * automatically revoke all rights granted to you under this Software License and render Paragraphs 1 and 2 of this 
 * Software License null and void.
 * 8. This Software License does not grant any rights in or to any intellectual property owned by Stanford or any 
 * Contributor except those rights expressly granted hereunder.
 *
 * PART B. CONTRIBUTION AGREEMENT - LICENSE TO STANFORD WITH RIGHT TO SUBLICENSE ("CONTRIBUTION AGREEMENT").
 * 1. As used in this Contribution Agreement, "you" means an individual providing a Contribution to ePAD and the 
 * institution or entity which employs or is otherwise affiliated with you.
 * 2. This Contribution Agreement applies to all Contributions made to ePAD at any time. By making a Contribution you 
 * represent that: (i) you are legally authorized and entitled by ownership or license to make such Contribution and to 
 * grant all licenses granted in this Contribution Agreement with respect to such Contribution; (ii) if your Contribution 
 * includes any patient data, all such data is de-identified in accordance with U.S. confidentiality and security laws and 
 * requirements, including but not limited to the Health Insurance Portability and Accountability Act (HIPAA) and its 
 * regulations, and your disclosure of such data for the purposes contemplated by this Agreement is properly authorized and 
 * in compliance with all applicable laws and regulations; and (iii) you have preserved in the Contribution all applicable 
 * attributions, copyright notices and licenses for any third party software or data included in the Contribution.
 * 3. Except for the licenses you grant in this Agreement, you reserve all right, title and interest in your Contribution.
 * 4. You hereby grant to Stanford, with the right to sublicense, a perpetual, worldwide, non-exclusive, no charge, 
 * royalty-free, irrevocable license to use, reproduce, make derivative works of, display and distribute the Contribution. 
 * If your Contribution is protected by patent, you hereby grant to Stanford, with the right to sublicense, a perpetual, 
 * worldwide, non-exclusive, no-charge, royalty-free, irrevocable license under your interest in patent rights embodied in 
 * the Contribution, to make, have made, use, sell and otherwise transfer your Contribution, alone or in combination with 
 * ePAD or otherwise.
 * 5. You acknowledge and agree that Stanford ham may incorporate your Contribution into ePAD and may make your 
 * Contribution as incorporated available to members of the public on an open source basis under terms substantially in 
 * accordance with the Software License set forth in Part A of this Agreement. You further acknowledge and agree that 
 * Stanford shall have no liability arising in connection with claims resulting from your breach of any of the terms of 
 * this Agreement.
 * 6. YOU WARRANT THAT TO THE BEST OF YOUR KNOWLEDGE YOUR CONTRIBUTION DOES NOT CONTAIN ANY CODE OBTAINED BY YOU UNDER AN 
 * OPEN SOURCE LICENSE THAT REQUIRES OR PRESCRIBES DISTRBUTION OF DERIVATIVE WORKS UNDER SUCH OPEN SOURCE LICENSE. (By way 
 * of non-limiting example, you will not contribute any code obtained by you under the GNU General Public License or other 
 * so-called "reciprocal" license.)
 *******************************************************************************/
package edu.stanford.epad.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.IOUtils;

/**
 * Read the "etc/proxy-config.properties" file on start up read all necessary configuration information.
 * <p>
 * All server configuration information is centralized here, i.e., the configuration file should not be read elsewhere.
 */
public class EPADConfig
{
	private static final EPADLogger log = EPADLogger.getInstance();
	private static EPADConfig ourInstance = null;
	public static final String configFileName = "proxy-config.properties";

	// The port that the ePAD server is sitting on
	public static final int epadPort = EPADConfig.getInstance().getIntegerPropertyValue("ePadClientPort");

	//qifp data
	public static final String qifpServer = EPADConfig.getInstance().getParamValue("qifpServer","epad-prod8.stanford.edu");
	public static final int qifpPort = EPADConfig.getInstance().getIntegerPropertyValue("qifpPort",8090);
	public static final String qifpUserName = EPADConfig.getInstance().getParamValue("qifpUserName","epad");
	public static final String qifpUserPass = EPADConfig.getInstance().getParamValue("qifpUserPass","epad123");
	
	
	// dcm4chee configuration
	public static final String jmxUserName = EPADConfig.getInstance().getParamValue("jmxUserName",null);
	public static final String jmxUserPass = EPADConfig.getInstance().getParamValue("jmxUserPassword",null);
	public static final String dcm4CheeServer = EPADConfig.getInstance().getStringPropertyValue("NameServer");
	public static final int dcm4cheeServerWadoPort = EPADConfig.getInstance().getIntegerPropertyValue(
			"DicomServerWadoPort");
	public static final String dcm4cheeDirRoot = EPADConfig.getInstance().getStringPropertyValue("dcm4cheeDirRoot");
	public static final String wadoURLExtension = EPADConfig.getInstance().getStringPropertyValue("WadoUrlExtension");
	public static final String dicomServerPort = EPADConfig.getInstance().getStringPropertyValue("DicomServerPort");
	public static final String dicomServerIP = EPADConfig.getInstance().getStringPropertyValue("DicomServerIP");
	public static final String aeTitle = EPADConfig.getInstance().getStringPropertyValue("DicomServerAETitle");
	public static final String dcm4cheeHome = EPADConfig.getInstance().getParamValue("dcm4cheeHome", "/home/pacs");

	// ePAD's MySQL database configuration
	public static final String epadDatabaseUsername = EPADConfig.getInstance().getStringPropertyValue(
			"epadDatabaseUsername");
	public static final String epadDatabasePassword = EPADConfig.getInstance().getStringPropertyValue(
			"epadDatabasePassword");
	public static final String epadDatabaseURL = EPADConfig.getInstance().getStringPropertyValue("epadDatabaseURL");

	// dcm4chee's MySQL database configuration
	public static final String dcm4CheeDatabaseUsername = EPADConfig.getInstance().getStringPropertyValue(
			"dcm4CheeDatabaseUsername");
	public static final String dcm4CheeDatabasePassword = EPADConfig.getInstance().getStringPropertyValue(
			"dcm4CheeDatabasePassword");
	public static final String dcm4CheeDatabaseURL = EPADConfig.getInstance().getStringPropertyValue(
			"dcm4CheeDatabaseURL");

	// AIM-related configuration
	public static final String aimeServerUrl = EPADConfig.getInstance().getParamValue("aimeServerUrl",null);//ml
	public static final String aimeApiKey = EPADConfig.getInstance().getParamValue("aimeApiKey",null);//ml
	public static final String eXistServerUrl = EPADConfig.getInstance().getStringPropertyValue("serverUrl");
	public static final String eXistURI = EPADConfig.getInstance().getStringPropertyValue("serverUrlUpload");
	public static final String eXistUsername = EPADConfig.getInstance().getStringPropertyValue("username");
	public static final String eXistPassword = EPADConfig.getInstance().getStringPropertyValue("password");
	public static final String eXistCollection = EPADConfig.getInstance().getStringPropertyValue("collection");
	public static final String aim3Namespace = EPADConfig.getInstance().getStringPropertyValue("namespace");
	public static final String xsdFile = EPADConfig.getInstance().getStringPropertyValue("xsdFile");
	public static final String xsdFilePath = EPADConfig.getInstance().getStringPropertyValue("baseSchemaDir") + xsdFile;
	public static final String useV4 = EPADConfig.getInstance().getStringPropertyValue("useV4");
	public static final String aim4Namespace = EPADConfig.getInstance().getStringPropertyValue("namespaceV4");
	public static final String eXistCollectionV4 = EPADConfig.getInstance().getStringPropertyValue("collectionV4");
	public static final String xsdFileV4 = EPADConfig.getInstance().getStringPropertyValue("xsdFileV4");
	public static final String xsdFilePathV4 = EPADConfig.getInstance().getStringPropertyValue("baseSchemaDir")
			+ xsdFileV4;
	public static final String baseAnnotationDir = EPADConfig.getInstance().getStringPropertyValue("baseAnnotationDir");
	public static final String templateXSDPath = EPADConfig.getInstance().getStringPropertyValue("baseSchemaDir") + EPADConfig.getInstance().getParamValue("templateSchema", "AIMTemplate_v2rvStanford.xsd");
	
	public static final String eventResourceURI = EPADConfig.getInstance().getStringPropertyValue("eventResourceURI");

	public static final String xnatServer = EPADConfig.getInstance().getStringPropertyValue("XNATServer");
	public static final int xnatPort = EPADConfig.getInstance().getIntegerPropertyValue("XNATPort");
	public static final String xnatUploadProjectID = EPADConfig.getInstance().getStringPropertyValue(
			"XNATUploadProjectID");
	public static final String xnatUploadProjectUser = EPADConfig.getInstance().getStringPropertyValue(
			"XNATUploadProjectUser");
	public static final String xnatUploadProjectPassword = EPADConfig.getInstance().getStringPropertyValue(
			"XNATUploadProjectPassword");
	public static boolean UseEPADUsersProjects = EPADConfig.getInstance().getBooleanPropertyValue(
			"UseEPADUsersProjects", true);
	public static String mongoHostname = EPADConfig.getInstance().getParam("MongoHost");
	public static final int mongoPort = EPADConfig.getInstance().getIntegerPropertyValue("MongoPort", 27017);
	public static String mongoDB = EPADConfig.getInstance().getParamValue("MongoDB", "epaddb");
	public static String mongoUser = EPADConfig.getInstance().getParam("MongoUser");
	public static String mongoPassword = EPADConfig.getInstance().getParam("MongoPassword");
	public static String webAuthPassword = EPADConfig.getInstance().getParamValue("WebAuthPassword", null);
	
	
	public static String pluginMaxtime = EPADConfig.getInstance().getParamValue("pluginMaxtime", null);
	public static int olderThan_Days = EPADConfig.getInstance().getIntegerPropertyValue("olderThan_Days", 360);
	
	private Properties properties;

	private static EPADConfig getInstance()
	{
		if (ourInstance == null)
			ourInstance = new EPADConfig();
		return ourInstance;
	}

	private EPADConfig()
	{
		try {
			properties = new Properties();
			File configFile = getConfigurationFile();
			if (!configFile.exists())
			{
				// Check for properties from docker running on mac
				configFile = getMacDockerConfigFile();
				if (!configFile.exists())
					throw new IllegalStateException("Could not find ePAD configuration file " + configFile.getAbsolutePath());
			}

			FileInputStream fis = new FileInputStream(configFile);
			try {
				properties.load(fis);
				log.info("Using ePAD configuration file " + configFile.getAbsolutePath());
			} finally {
				IOUtils.closeQuietly(fis);
			}
		} catch (Exception e) {
			log.severe("Error reading ePAD configuration file", e);
			throw new RuntimeException(e.getMessage());
		}
	}

	/**
	 * Get the base directory for the ePAD web server.
	 * <p>
	 * For the moment, we use ~/DicomProxy as the base directory for compatibility with older calls. Ultimately we will
	 * change location to something more general.
	 * 
	 * @return File Base directory for ePAD web server.
	 */
	public static String getEPADWebServerBaseDir()
	{
		return System.getProperty("user.home") + "/DicomProxy/";
	}

	public static String getEPADWebServerWebappsDir()
	{
		return getEPADWebServerBaseDir() + "webapps/";
	}

	public static String getEPADWebServerResourcesDir()
	{
		return getEPADWebServerBaseDir() + "resources/";
	}

	public static String getEPADWebServerEtcDir()
	{
		return getEPADWebServerBaseDir() + "etc/";
	}

	public static String getEPADWebServerDICOMScriptsDir()
	{
		return getEPADWebServerEtcDir() + "scripts/";
	}

	public static String getEPADWebServerDICOMBinDir()
	{
		return getEPADWebServerDICOMScriptsDir() + "tpl/bin/";
	}

	public static String getEPADWebServerIconsDir()
	{
		return getEPADWebServerEtcDir() + "icons/";
	}

	public static String getEPADWebServerMyScriptsDir()
	{
		return getEPADWebServerEtcDir() + "scripts/myscripts/bin/";
	}

	public static String getEPADWebServerMySQLScriptDir()
	{
		return getEPADWebServerEtcDir() + "db/mysql/";
	}

	public static String getEPADWebServerLoginDir()
	{
		return getEPADWebServerEtcDir() + "login/";
	}

	public static String getEPADWebServerUploadDir()
	{
		return getEPADWebServerResourcesDir() + "upload/";
	}

	public static String getEPADWebServerFileUploadDir()
	{
		return getEPADWebServerResourcesDir() + "fileupload/";
	}

	public static String getEPADWebServerRSNADir()
	{
		return getEPADWebServerResourcesDir() + "rsna/";
	}

	public static String getEPADWebServerAnnotationsDir()
	{
		return getEPADWebServerResourcesDir() + "annotations/";
	}

	public static String getEPADWebServerAnnotationsUploadDir()
	{
		return getEPADWebServerAnnotationsDir() + "upload/";
	}

	public static String getEPADWebServerSchemaDir()
	{
		return getEPADWebServerResourcesDir() + "schema/";
	}

	public static String getEPADWebServerAIM3XSDFilePath()
	{
		return getEPADWebServerSchemaDir() + "AIM_v3.xsd";
	}

	public static String getEPADWebServerLogDir()
	{
		return getEPADWebServerBaseDir() + "log/";
	}

	public static String getEPADWebServerPNGDir()
	{
		return getEPADWebServerResourcesDir() + "dicom/";
	}

	public static String getEPADWebServerDicomTagDir()
	{
		return getEPADWebServerResourcesDir() + "dicom/";
	}

	public static String getEPADWebServerDicomDir()
	{
		return getEPADWebServerResourcesDir() + "dicom/";
	}

	public static String getEPADWebServerPNGGridDir()
	{
		return getEPADWebServerResourcesDir() + "dicom_grid/";
	}

	public static String getEPADWebServerFilesDir()
	{
		return getEPADWebServerResourcesDir() + "files/";
	}

	public static String getEPADWebServerTemplatesDir()
	{
		return getEPADWebServerResourcesDir() + "templates/";
	}

	public static String getEPADWebServerPluginConfigFilePath()
	{
		return getEPADWebServerEtcDir() + "plugin-config.txt";
	}

	public static String getEPADWebServerConfigFilePath()
	{
		return getEPADWebServerEtcDir() + configFileName;
	}

	public static String getEPADWebServerLogFilePath()
	{
		return getEPADWebServerLogDir() + "dicom-proxy.log";
	}

	public static String getEPADWebServerJettyConfigFilePath()
	{
		return getEPADWebServerEtcDir() + "jetty-config.xml";
	}
	
	public static String getEPADWebServerJJVectorDataDir()
    {
		return System.getProperty("user.home") + "/tmp/jjvectorData";
    }
	
	public static String getEPADPluginDataDirectory()
    {
		return System.getProperty("user.home") + getParamValue("EPADPluginDataDirectory","/tmp");
    }

	private File getConfigurationFile()
	{
		File configFile = new File(EPADConfig.getEPADWebServerConfigFilePath());
		log.info("Found configuration file " + configFile.getAbsolutePath());

		return configFile;
	}
	
	public static File getMacDockerConfigFile()
    {
		return new File(System.getProperty("user.home") + "/mac/etc/" + EPADConfig.configFileName);
    }

	public static String getEPADRemotePACsConfigFilePath()
	{
		return getEPADWebServerEtcDir() + "RemotePACsConfig.properties";
	}

	/**
	 * Returns the values of a property in ePAD's configuration file.
	 * 
	 * @param name key in config file.
	 * @return the value of that parameter.
	 */
	public String getParam(String name)
	{
		return properties.getProperty(name);
	}

	public static String getParamValue(String name)
	{
		return EPADConfig.getInstance().getParam(name);
	}

	public static String getParamValue(String name, String defaultValue)
	{
		String value =  getParamValue(name);
		if (value != null)
			return value;
		else
			return defaultValue;
	}
	
	/**
	 * 
	 * @param propertyName
	 * @return
	 * @throws IllegalArgumentException
	 */
	private String getStringPropertyValue(String propertyName)
	{
		String parameterValue = getParam(propertyName);

		if (parameterValue == null || parameterValue.length() == 0) {
			String errorMessage = "No value for parameter " + propertyName + " in configuration file";
			log.warning(errorMessage);
			throw new IllegalArgumentException(errorMessage);
		}
		return parameterValue;
	}

	/**
	 * 
	 * @param propertyName
	 * @return
	 * @throws IllegalArgumentException
	 */
	public int getIntegerPropertyValue(String propertyName)
	{
		String parameterValue = getStringPropertyValue(propertyName);
		try {
			return Integer.parseInt(parameterValue);
		} catch (NumberFormatException nfe) {
			throw new IllegalArgumentException("The parameter value for property " + propertyName
					+ " needs to be an integer. It value was " + parameterValue);
		}
	}

	public int getIntegerPropertyValue(String propertyName, int defaultValue)
	{
		String parameterValue = getParamValue(propertyName);
		if (parameterValue == null) return defaultValue;
		try {
			return Integer.parseInt(parameterValue);
		} catch (NumberFormatException nfe) {
			throw new IllegalArgumentException("The parameter value for property " + propertyName
					+ " needs to be an integer. It value was " + parameterValue);
		}
	}

	/**
	 * 
	 * @param propertyName
	 * @return
	 * 
	 */
	public boolean getBooleanPropertyValue(String propertyName)
	{
		String parameterValue = getParam(propertyName);
		if ("true".equalsIgnoreCase(parameterValue))
		{
			return true;
		}
		else if (!"false".equalsIgnoreCase(parameterValue))
		{
			log.warning("Invalid or missing property value for " + propertyName);
		}
		return false;
	}

	/**
	 * 
	 * @param propertyName
	 * @return
	 * 
	 */
	public boolean getBooleanPropertyValue(String propertyName, boolean defaultValue)
	{
		String parameterValue = getParam(propertyName);
		if (parameterValue == null)
			return defaultValue;
		if ("true".equalsIgnoreCase(parameterValue))
		{
			return true;
		}
		else if (!"false".equalsIgnoreCase(parameterValue))
		{
			log.warning("Invalid or missing property value for " + propertyName);
		}
		return false;
	}

	/**
	 * Get all the key,values as a Map of Strings.
	 * 
	 * @return Map of String keys to String values
	 */
	public Map<String, String> getAllPropertyValues()
	{
		Set<String> keys = properties.stringPropertyNames();
		Map<String, String> retVal = new HashMap<String, String>();

		for (String key : keys) {
			retVal.put(key, properties.getProperty(key));
		}
		return retVal;
	}
}
