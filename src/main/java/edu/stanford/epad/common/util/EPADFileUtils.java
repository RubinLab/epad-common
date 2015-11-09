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

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Writer;
import java.net.URLConnection;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.xml.sax.SAXException;

/**
 * Utility for writing generic files with text data.
 */
public class EPADFileUtils
{
	private static final EPADLogger log = EPADLogger.getInstance();

	EPADFileUtils()
	{
	}

	/**
	 * True if the write succeed otherwise it is false.
	 * 
	 * @param file - File including full directory path to write.
	 * @param contents - String complete contents of file.
	 * @return boolean
	 */
	public static boolean write(File file, String contents)
	{
		try {
			Writer out = new BufferedWriter(new FileWriter(file));
			out.write(contents);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			log.warning("Failed to write file: " + file.getAbsolutePath(), e);
			return false;
		}
	}

	/**
	 * User this instead of write when a file will be over-written often.
	 * 
	 * @param file File the file to over-write.
	 * @param contents String
	 * @return boolean
	 */
	public static boolean overwrite(File file, String contents)
	{
		String tempFilename = file.getAbsoluteFile() + "." + UUID.randomUUID().toString() + ".tmp";
		File tempFile = new File(tempFilename);

		return write(tempFile, contents) && tempFile.renameTo(file);
	}

	@SuppressWarnings("unchecked")
	public static Collection<File> getAllFilesWithExtension(File dir, String extension, boolean recursive)
	{
		String[] extensions = new String[] { extension };

		return FileUtils.listFiles(dir, extensions, recursive);
	}

	public static List<File> getAllFilesWithoutExtension(File dir, final String extension)
	{
		File[] files = dir.listFiles(new FileFilter() {
			@Override
			public boolean accept(File file)
			{
				return !file.getName().endsWith(extension);
			}
		});
		if (files != null) {
			return Arrays.asList(files);
		} else {
			return new ArrayList<File>(); // return an empty list of no files.
		}
	}

	/**
	 * Get all the directories under the file specified. If it isn't a directory then
	 * 
	 * @param dir File
	 * @return List of File
	 */
	public static List<File> getDirectoriesIn(File dir)
	{
		List<File> retVal = new ArrayList<File>();
		try {
			if (!dir.isDirectory()) {
				throw new IllegalArgumentException("Not a directory!!");
			}

			File[] candidates = dir.listFiles();
			for (File curr : candidates) {
				if (curr.isDirectory()) {
					retVal.add(curr);
				}
			}
		} catch (Exception e) {
			log.warning("Had:" + e.getMessage() + " for " + dir.getAbsolutePath(), e);
		}
		return retVal;
	}

	public static int countFilesWithEnding(String dirPath, String ending)
	{
		return countFilesWithEnding(new File(dirPath), ending);
	}

	/**
	 * Count the total number of files in a directory with a give ending. Recursively descend down the directory
	 * structure.
	 * 
	 * @param dir File
	 * @param ending String
	 * @return int total files with this ending.
	 */
	public static int countFilesWithEnding(File dir, final String ending)
	{
		if (!dir.isDirectory()) {
			throw new IllegalStateException("Not a directory: " + dir.getAbsolutePath());
		}

		File[] files = dir.listFiles(new FileFilter() {
			@Override
			public boolean accept(File file)
			{
				return file.getName().toLowerCase().endsWith(ending);
			}
		});
		if (files == null) {
			return 0;
		}
		int count = files.length;
		for (File currFile : files) {
			if (currFile.isDirectory()) {
				count += countFilesWithEnding(currFile, ending);
			}
		}

		return count;
	}

	/**
	 * 
	 * @param f File
	 * @return String
	 */
	public static String getExtension(File f)
	{
		if (!f.exists()) {
			throw new IllegalStateException("File does not exists. file: " + f.getAbsolutePath());
		}

		String name = f.getName().toLowerCase();
		int dot = name.lastIndexOf('.');
		return name.substring(dot + 1);
	}

	/**
	 * Return true if the file doesn't have an extension.
	 * 
	 * @param f File
	 * @return boolean
	 */
	public static boolean hasExtension(File f)
	{
		if (!f.exists()) {
			throw new IllegalStateException("File does not exists. file: " + f.getAbsolutePath());
		}

		String name = f.getName().toLowerCase();
		int dot = name.lastIndexOf('.');

		return dot > 0;
	}

	/**
	 * Looks for an extension, which is the last dot '.' in a file name, but only if the characters are alpha to
	 * distinguish it from DicomUIDs.
	 * 
	 * @param f File ex. ./dir1/dir2/SomeFileName.ext
	 * @return String - ./dir1/dir2/SomeFileName
	 */
	public static String fileAbsolutePathWithoutExtension(File f)
	{
		String fullPath;
		try {
			fullPath = f.getCanonicalPath();
		} catch (IOException ioe) {
			fullPath = f.getAbsolutePath();
		}
		return removeExtension(fullPath);
	}

	/**
	 * Looks for an extension, which is the last dot '.' in a file name, but only if the characters are alpha to
	 * distinguish it from DicomUIDs.
	 * 
	 * @param f File ex. ./dir1/dir2/SomeFileName.ext
	 * @return String - SomeFileName
	 */
	public static String fileNameWithoutExtension(File f)
	{
		return removeExtension(f.getName());
	}

	/**
	 * Unzip the specified file.
	 * 
	 * @param zipFilePath String path to zip file.
	 * @throws IOException during zip or read process.
	 */
	public static void extractFolder(String zipFilePath) throws IOException
	{
		ZipFile zipFile = null;

		try {
			int BUFFER = 2048;
			File file = new File(zipFilePath);

			zipFile = new ZipFile(file);
			String newPath = zipFilePath.substring(0, zipFilePath.length() - 4);

			makeDirs(new File(newPath));
			Enumeration<?> zipFileEntries = zipFile.entries();

			while (zipFileEntries.hasMoreElements()) {
				ZipEntry entry = (ZipEntry)zipFileEntries.nextElement();
				String currentEntry = entry.getName();
				File destFile = new File(newPath, currentEntry);
				File destinationParent = destFile.getParentFile();

				// create the parent directory structure if needed
				makeDirs(destinationParent);

				InputStream is = null;
				BufferedInputStream bis = null;
				FileOutputStream fos = null;
				BufferedOutputStream bos = null;

				try {
					if (destFile.exists() && destFile.isDirectory())
						continue;

					if (!entry.isDirectory()) {
						int currentByte;
						byte data[] = new byte[BUFFER];
						is = zipFile.getInputStream(entry);
						bis = new BufferedInputStream(is);
						fos = new FileOutputStream(destFile);
						bos = new BufferedOutputStream(fos, BUFFER);

						while ((currentByte = bis.read(data, 0, BUFFER)) != -1) {
							bos.write(data, 0, currentByte);
						}
						bos.flush();
					}
				} finally {
					IOUtils.closeQuietly(bis);
					IOUtils.closeQuietly(is);
					IOUtils.closeQuietly(bos);
					IOUtils.closeQuietly(fos);
				}

				if (currentEntry.endsWith(".zip")) {
					extractFolder(destFile.getAbsolutePath());
				}
			}
		} catch (Exception e) {
			log.warning("Failed to unzip: " + zipFilePath, e);
			throw new IllegalStateException(e);
		} finally {
			if (zipFile != null)
				zipFile.close();
		}
	}

	/**
	 * Check to see if the file exists. If it doesn't then move it to the new location.
	 * 
	 * @param from File - The file in the old location.
	 * @param to File - The file in the new location.
	 * @throws IOException during move.
	 */
	public static void checkAndMoveFile(File from, File to) throws IOException
	{
		// If the directory doesn't exist create it.
		File parentDir = to.getParentFile();
		if (!parentDir.exists()) {
			EPADFileUtils.makeDirs(parentDir);
		}

		if (!to.exists()) {
			// log.info("Moving file to: "+to.getCanonicalPath());
			FileUtils.moveFile(from, to);
		} else {
			// log.info("Not moving file since it already exists. file="+to.getCanonicalPath());
			FileUtils.deleteQuietly(from);
		}
	}// checkAndMove

	/**
	 * Make a directory in a thread-safe manner in case multiple threads try to make it at the same time.
	 * 
	 * @param dir File the directory(ies) to make.
	 * @return boolean true if the process was successful, or the directory already exists.
	 */
	public static boolean makeDirs(File dir)
	{
		// make a key based on the name.
		FileKey lock = new FileKey(dir);

		synchronized (lock.toString()) {
			if (!dir.exists()) {
				return dir.mkdirs();
			}
		}
		return true;
	}

	public static boolean createDirsAndFile(File file)
	{
		if (file.exists()) return true;
		boolean success = makeDirs(file.getParentFile());
		if (!success) {
			return false;
		}

		FileKey lock = new FileKey(file);
		synchronized (lock.toString()) {
			if (!file.exists()) {
				try {
					return file.createNewFile();
				} catch (IOException ioe) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Delete a directory and all of its contents.
	 * 
	 * @param directoryToDelete File
	 * @return boolean true if everything deleted.
	 */
	public static boolean deleteDirectoryAndContents(File directoryToDelete)
	{
		try {
			List<File> dirs = getDirectoriesIn(directoryToDelete);
			for (File currDir : dirs) {
				if (!deleteDirectoryAndContents(currDir)) {
					throw new IllegalStateException("Filed to delete dir=" + directoryToDelete.getAbsolutePath());
				}
			}
			File[] files = directoryToDelete.listFiles();
			for (File currFile : files) {
				if (!currFile.delete()) {
					throw new IllegalStateException("Could not delete file=" + currFile.getAbsolutePath());
				}
			}
			if (!directoryToDelete.delete()) {
				throw new IllegalStateException("Could not delete: " + directoryToDelete.getAbsolutePath());
			}
			return true;

		} catch (IllegalStateException ise) {
			log.warning("Warning: error deleting directory " + directoryToDelete.getAbsolutePath(), ise);
			return false;
		} catch (Exception e) {
			log.warning("Warning: error deleting directory " + directoryToDelete.getAbsolutePath(), e);
			return false;
		}
	}

	public static boolean deleteFilesInDirWithoutExtension(File dir, String extension)
	{
		try {
			List<File> files = getAllFilesWithoutExtension(dir, extension);

			for (File file : files) {
				if (!file.delete()) {
					throw new IllegalStateException("Could not delete file=" + file.getAbsolutePath());
				}
			}
			return true;
		} catch (IllegalStateException ise) {
			log.warning(ise.getMessage());
			return false;
		} catch (Exception e) {
			log.warning("Had: " + e.getMessage() + " for " + dir.getAbsolutePath(), e);
			return false;
		}
	}

	public static boolean deleteFilesInDirectoryWithExtension(File dir, String extension)
	{
		try {
			Collection<File> files = getAllFilesWithExtension(dir, extension, true);

			for (File file : files) {
				if (!file.delete()) {
					throw new IllegalStateException("Could not delete file " + file.getAbsolutePath());
				}
			}
			return true;
		} catch (IllegalStateException ise) {
			log.warning(ise.getMessage());
			return false;
		} catch (Exception e) {
			log.warning("Had: " + e.getMessage() + " for " + dir.getAbsolutePath(), e);
			return false;
		}
	}
	
    public static File copyFile(File src, File dst)
    {
    	FileChannel inChannel = null;
    	FileChannel outChannel = null;
		try {
	        inChannel = new FileInputStream(src).getChannel();
	        outChannel = new FileOutputStream(dst).getChannel();
	        inChannel.transferTo(0, inChannel.size(), outChannel);
			return dst;
		} catch (Exception e) {
			log.warning("Error copying file, from " + src.getAbsolutePath() + " to " + dst.getAbsolutePath(), e);
		} finally {
			try {
	            if (inChannel != null) inChannel.close();
	            if (outChannel != null) outChannel.close();
			} catch (IOException e) {}
		}
		return null;
    }

    public static void downloadFile(HttpServletRequest httpRequest, HttpServletResponse httpResponse, File file, String fileName) throws Exception
    {
    	sendFile(httpRequest, httpResponse, file, fileName, true);
    }
    public static void sendFile(HttpServletRequest httpRequest, HttpServletResponse httpResponse, File file, String fileName, boolean download) throws Exception
    {
		InputStream is = null; 
		try
		{		
			is = new BufferedInputStream(new FileInputStream(file)); 
			String mimeType = URLConnection.guessContentTypeFromStream(is);
			httpResponse.setContentType (mimeType) ;
			if (download)
				httpResponse.setHeader("Content-disposition", "attachment;filename=" + fileName) ;
			httpResponse.setHeader("pragma", "no-cache");
			OutputStream outStream = null;
			String encoding = null;
			if (httpRequest != null)
				encoding = httpRequest.getHeader("Accept-Encoding");    
			  
			if (false && encoding != null && encoding.indexOf("gzip") != -1)
			{
				httpResponse.setHeader("Content-Encoding" , "gzip");
				outStream = new GZIPOutputStream(httpResponse.getOutputStream());
			}
			else if (false && encoding != null && encoding.indexOf("compress") != -1)
			{
				httpResponse.setHeader("Content-Encoding" , "compress");
				outStream = new ZipOutputStream(httpResponse.getOutputStream());
			} 
			else
			{
				outStream = httpResponse.getOutputStream();
			}
			int chunk = 1024 ;
		
			byte[] buffer = new byte[chunk] ;
			int length = -1 ;
			int i = 0 ;
		
			while ((length = is.read(buffer)) != -1)
			{
				outStream.write(buffer, 0, length) ;
				if (length < chunk)
					break;
			}
			is.close();
			is = null;
		}
		finally
		{
			if (is != null) is.close();
		}
    }
    
    public static String readFileAsString(File file) throws Exception {
		BufferedReader reader = null;
		InputStream is = null;
		try {
			is = new FileInputStream(file);
			reader = new BufferedReader(new InputStreamReader(is, "UTF8"));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
				sb.append("\n");
			}
			return sb.toString();
		} catch (Exception x) {
			x.printStackTrace();
			throw x;
		} finally {
			if (reader != null)
				reader.close();
			else if (is != null)
				is.close();
		}
	}

	public static boolean isImage(File file) {
		String name = file.getName().toLowerCase();
		if (name.endsWith(".jpeg")
				|| name.endsWith(".jpg")
				|| name.endsWith(".png")
				|| name.endsWith(".gif")
				|| name.endsWith(".nii")
				|| name.endsWith(".bmp")
				|| name.endsWith(".tif")
				|| name.endsWith(".tiff")
				|| name.endsWith(".yuv")
				|| name.endsWith(".psd")
				|| name.endsWith(".xcf")
				|| name.endsWith(".mhd")
				)
			return true;
		else
			return false;
	}

	// is this a valid file against its schema?
	public static boolean isValidXml(File f, String xsdSchema) {
		try {
			String err = validateXml(f, xsdSchema);
			if ("".equals(err))
				return true;
		} catch (Exception e) {
			log.warning("Exception validating a file: " + f.getName(), e);
		}
		return false;
	}

	// is this a valid file against its schema?
	public static String validateXml(File f, String xsdSchema) throws Exception {
		try {
			FileInputStream xml = new FileInputStream(f);
			InputStream xsd = null;
			try {
				xsd = new FileInputStream(xsdSchema);
				SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
				Schema schema = factory.newSchema(new StreamSource(xsd));
				Validator validator = schema.newValidator();
				validator.validate(new StreamSource(xml));
				return "";
			} catch (SAXException ex) {
				log.info("Error: validating template/annotation " + ex.getMessage());
				return ex.getMessage();
			} catch (IOException e) {
				log.info("Error: validating template/annotation " + e.getMessage());
				throw e;
			}
		} catch (IOException e) {
			log.info("Exception validating a file: " + f.getName());
			throw e;
		}
	}

	// is this a valid file against its schema?
	public static boolean isValidXmlUsingClassPathSchema(File f, String xsdSchema) {
		try {
			log.debug("xml:" + f.getName() + " xsd:" + xsdSchema);
			FileInputStream xml = new FileInputStream(f);
			InputStream xsd = null;
			try {
				xsd = EPADFileUtils.class.getClassLoader().getResourceAsStream(xsdSchema);
				SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
				Schema schema = factory.newSchema(new StreamSource(xsd));
				Validator validator = schema.newValidator();
				validator.validate(new StreamSource(xml));
				return true;
			} catch (SAXException ex) {
				log.info("Error: validating template/annotation " + ex.getMessage());
			} catch (IOException e) {
				log.info("Error: validating template/annotation " + e.getMessage());
			}
		} catch (IOException e) {
			log.info("Exception validating a file: " + f.getName());
		}
		return false;
	}

	/**
	 * 
	 * @param name String
	 * @return String
	 */
	public static String removeExtension(String name)
	{
		int lastDotIndex = name.lastIndexOf('.');
		if (lastDotIndex < 1) {
			return name;
		}

		String ext = name.substring(lastDotIndex);
		ext = ext.replace('.', ' ').trim();
		if (isNumber(ext)) {
			return name;
		}

		return name.substring(0, lastDotIndex);
	}
	
	
	/** Untar an input file into an output file.

	 * The output file is created in the output folder, having the same name
	 * as the input file, minus the '.tar' extension. 
	 * 
	 * @param inputFile     the input .tar file
	 * @param outputDir     the output directory file. 
	 * @throws IOException 
	 * @throws FileNotFoundException
	 *  
	 * @return  The {@link List} of {@link File}s with the untared content.
	 * @throws ArchiveException 
	 */
	public static List<File> unTar(final File inputFile, final File outputDir) throws Exception {

	    log.debug(String.format("Untaring %s to dir %s.", inputFile.getAbsolutePath(), outputDir.getAbsolutePath()));

	    final List<File> untaredFiles = new LinkedList<File>();
	    final InputStream is = new FileInputStream(inputFile); 
	    final TarArchiveInputStream debInputStream = (TarArchiveInputStream) new ArchiveStreamFactory().createArchiveInputStream("tar", is);
	    TarArchiveEntry entry = null; 
	    while ((entry = (TarArchiveEntry)debInputStream.getNextEntry()) != null) {
	        final File outputFile = new File(outputDir, entry.getName());
	        if (entry.isDirectory()) {
	            log.debug(String.format("Attempting to write output directory %s.", outputFile.getAbsolutePath()));
	            if (!outputFile.exists()) {
	                log.debug(String.format("Attempting to create output directory %s.", outputFile.getAbsolutePath()));
	                if (!outputFile.mkdirs()) {
	                    throw new IllegalStateException(String.format("Couldn't create directory %s.", outputFile.getAbsolutePath()));
	                }
	            }
	        } else {
	            log.debug(String.format("Creating output file %s.", outputFile.getAbsolutePath()));
	            final OutputStream outputFileStream = new FileOutputStream(outputFile); 
	            IOUtils.copy(debInputStream, outputFileStream);
	            outputFileStream.close();
	        }
	        untaredFiles.add(outputFile);
	    }
	    debInputStream.close(); 

	    return untaredFiles;
	}

	/**
	 * Ungzip an input file into an output file.
	 * <p>
	 * The output file is created in the output folder, having the same name
	 * as the input file, minus the '.gz' extension. 
	 * 
	 * @param inputFile     the input .gz file
	 * @param outputDir     the output directory file. 
	 * @throws IOException 
	 * @throws FileNotFoundException
	 *  
	 * @return  The {@File} with the ungzipped content.
	 */
	public static File unGzip(final File inputFile, final File outputDir) throws FileNotFoundException, IOException {

	    log.debug(String.format("Ungzipping %s to dir %s.", inputFile.getAbsolutePath(), outputDir.getAbsolutePath()));

	    final File outputFile = new File(outputDir, inputFile.getName().substring(0, inputFile.getName().length() - 3));

	    final GZIPInputStream in = new GZIPInputStream(new FileInputStream(inputFile));
	    final FileOutputStream out = new FileOutputStream(outputFile);

	    IOUtils.copy(in, out);

	    in.close();
	    out.close();

	    return outputFile;
	}
	
	public static File renameFile(File file, String newName) throws Exception
	{
		File newFile = new File(file.getParent(), newName);
		file.renameTo(newFile);
		return newFile;
	}
	
	private static boolean isNumber(String checkForNumber)
	{

		for (int i = 0; i < checkForNumber.length(); i++) {
			// If we find a non-digit character we return false.
			if (!Character.isDigit(checkForNumber.charAt(i)))
				return false;
		}

		return true;
	}

}
