package edu.stanford.epad.common.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FTPUtil {
	
	private String ftpHost;
	private String ftpUser;
	private String ftpPassword;
	private String ftpFolder;
	private int ftpPort = 21;

	public FTPUtil(String ftpHost, String ftpUser, String ftpPassword) {
		super();
		this.ftpHost = ftpHost;
		this.ftpUser = ftpUser;
		this.ftpPassword = ftpPassword;
	}

	public FTPUtil(String ftpHost, String ftpUser, String ftpPassword,
			int ftpPort) {
		super();
		this.ftpHost = ftpHost;
		this.ftpUser = ftpUser;
		this.ftpPassword = ftpPassword;
		this.ftpPort = ftpPort;
	}


	public void getFile(String remoteFile, File localFile) throws Exception {
	  	
		FTPClient ftpClient = new FTPClient();
		OutputStream outputStream = null;
	    try {	
	        ftpClient.connect(ftpHost, ftpPort);
	        ftpClient.enterLocalPassiveMode();
	        if (ftpUser != null && ftpUser.length() > 0)
	        	ftpClient.login(ftpUser, ftpPassword);
	        else
	        	ftpClient.login("anonymous", "");
	        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
	
	        outputStream = new BufferedOutputStream(new FileOutputStream(localFile));
	        InputStream inputStream = ftpClient.retrieveFileStream(remoteFile);
	        IOUtils.copy(inputStream, outputStream);
	        outputStream.flush();
	        IOUtils.closeQuietly(outputStream);
	        IOUtils.closeQuietly(inputStream);
	        boolean commandOK = ftpClient.completePendingCommand();
	        //boolean success = ftpClient.retrieveFile(remoteFile, outputStream);
	
	        //if (!success) {
	        //	throw new Exception("Error retrieving remote file: " + remoteFile);
	        //}	
	    } finally {
	        outputStream.close();	    	
	        ftpClient.disconnect();
	    }		
	}
	
	public boolean sendFile(String filePath, boolean delete) throws Exception {

		String fileName = filePath;
		int slash = fileName.lastIndexOf("/");
		if (slash != -1)
			fileName = fileName.substring(slash+1);
		slash = fileName.lastIndexOf("\\");
		if (slash != -1)
			fileName = fileName.substring(slash+1);
		boolean success = true;
		FTPClient ftp = new FTPClient();
		try
		{
			ftp.connect(ftpHost, ftpPort);
			int reply = ftp.getReplyCode();
			if (FTPReply.isPositiveCompletion(reply))
			{
				if (ftp.login(ftpUser, ftpPassword))
				{
					if (ftpFolder !=  null && ftpFolder.trim().length() > 0)
					{
						ftp.cwd(ftpFolder);
						System.out.print("ftp cd: " + ftp.getReplyString());
					}
					ftp.setFileType(FTP.ASCII_FILE_TYPE);					
					FileInputStream in = new FileInputStream(filePath);
					success = ftp.storeFile(fileName, in);
					in.close();
					if (delete)
					{
						File file = new File(filePath);
						file.delete();
					}
				}
				else
					success = false;
			}
		} finally {
			ftp.disconnect();
		}

		return success;
	}

	
 }