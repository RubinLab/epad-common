package edu.stanford.epad.common.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RunSystemCommand {
	
	private static final EPADLogger log = EPADLogger.getInstance();

	String command;
	public RunSystemCommand(String command) {
		super();
		this.command = command; // no double spaces
		log.info("Run command:" + command);
	}
	
	public String run() throws Exception
	{
		//dcm2nii.exe -g n -r n -f y -d n -p n -e n -o /outputfolder /inputfolder
		String[] args = command.split(" ");
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			ProcessBuilder processBuilder = new ProcessBuilder(args);
			processBuilder.directory(new File(EPADConfig.getEPADWebServerBaseDir() + "bin/"));
			processBuilder.redirectErrorStream(true);
			Process process = processBuilder.start();
			is = process.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
	
			String line;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
				log.debug(args[0] + " output: " + line);
			}

			int exitValue = process.waitFor();
			log.info(args[0] + " exit value is: " + exitValue);
			return sb.toString();
		} catch (Exception e) {
			log.warning("Error running command " + command, e);
			throw e;
		}		
	}

}
