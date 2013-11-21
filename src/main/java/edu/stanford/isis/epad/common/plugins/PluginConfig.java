package edu.stanford.isis.epad.common.plugins;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import edu.stanford.isis.epad.common.util.EPADLogger;
import edu.stanford.isis.epad.common.util.EPADResources;

/**
 * Reads the file plugin-config.txt one line at a time. Each line is the class name for the plugin handler.
 * 
 * @author alansnyder
 */
public class PluginConfig
{
	private static final EPADLogger log = EPADLogger.getInstance();
	private static PluginConfig ourInstance = new PluginConfig();
	private final List<String> pluginHandlerList = new ArrayList<String>();
	private final List<String> pluginTemplateList = new ArrayList<String>();
	private final List<String> pluginNameList = new ArrayList<String>();

	public static PluginConfig getInstance()
	{
		return ourInstance;
	}

	private PluginConfig()
	{
		try {
			File configFile = getConfigFile();
			if (!configFile.exists())
				throw new IllegalStateException("No plugin config file: " + configFile.getAbsolutePath());

			BufferedReader br = new BufferedReader(new FileReader(configFile));
			String line;
			while ((line = br.readLine()) != null) {
				line = line.trim(); // process the line.
				if (!isCommentLine(line)) {
					log.info("looking for plugin class: " + line); // Add this to the list of plugins.
					String[] linePart = line.split("=");
					if (linePart.length != 3) {
						log.info("Wrong plugin ");
					} else {
						pluginHandlerList.add(linePart[0]);
						pluginTemplateList.add(linePart[1]);
						pluginNameList.add(linePart[2]);
					}
				}
			}
			br.close();
		} catch (Exception e) {
			log.warning("Failed to read plugin config file for: " + e.getMessage(), e);
		}
	}

	private static boolean isCommentLine(String line)
	{
		line = line.trim();
		if (line.startsWith("//"))
			return true;
		if (line.startsWith("#"))
			return true;
		if (line.startsWith("*"))
			return true;

		if ("".equals(line)) // count a blank line as a comment.
			return true;

		return false;
	}

	private File getConfigFile()
	{
		File configFile = new File(EPADResources.getEPADWebServerPluginConfigFilePath());

		log.info("EPadPlugin config file: " + configFile.getAbsolutePath());
		return configFile;
	}

	/**
	 * Get the list of plugins.
	 * 
	 * @return List of String
	 */
	public List<String> getPluginHandlerList()
	{
		return pluginHandlerList;
	}

	public List<String> getPluginTemplateList()
	{
		return pluginTemplateList;
	}

	public List<String> getPluginNameList()
	{
		return pluginNameList;
	}
}
