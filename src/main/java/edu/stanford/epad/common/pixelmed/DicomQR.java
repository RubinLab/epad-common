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
package edu.stanford.epad.common.pixelmed;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Properties;
import java.util.Set;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;
import javax.imageio.ImageIO;

import com.pixelmed.database.DatabaseInformationModel;
import com.pixelmed.database.DatabaseTreeBrowser;
import com.pixelmed.database.DatabaseTreeRecord;
import com.pixelmed.database.MinimalPatientStudySeriesInstanceModel;
//import com.pixelmed.database.PatientStudySeriesConcatenationInstanceModel;

import com.pixelmed.dicom.*;
import com.pixelmed.event.ApplicationEventDispatcher;
import com.pixelmed.display.event.StatusChangeEvent;
import com.pixelmed.display.ApplicationFrame;
import com.pixelmed.display.DialogMessageLogger;
import com.pixelmed.display.DicomBrowser;
import com.pixelmed.display.SafeCursorChanger;
import com.pixelmed.display.SafeFileChooser;
import com.pixelmed.display.SafeProgressBarUpdaterThread;
import com.pixelmed.network.UnencapsulatedExplicitStoreFindMoveGetPresentationContextSelectionPolicy;
import com.pixelmed.network.DicomNetworkException;
import com.pixelmed.network.MultipleInstanceTransferStatusHandlerWithFileName;
import com.pixelmed.network.NetworkApplicationConfigurationDialog;
import com.pixelmed.network.NetworkApplicationInformation;
import com.pixelmed.network.NetworkApplicationInformationFederated;
import com.pixelmed.network.NetworkApplicationProperties;
import com.pixelmed.network.PresentationAddress;
import com.pixelmed.network.PresentationContext;
import com.pixelmed.network.PresentationContextListFactory;
import com.pixelmed.network.ReceivedObjectHandler;
import com.pixelmed.network.StorageSOPClassSCPDispatcher;
import com.pixelmed.network.StorageSOPClassSCU;
import com.pixelmed.network.TransferSyntaxSelectionPolicy;
import com.pixelmed.query.QueryInformationModel;
import com.pixelmed.query.QueryTreeBrowser;
import com.pixelmed.query.QueryTreeModel;
import com.pixelmed.query.QueryTreeRecord;
import com.pixelmed.query.StudyRootQueryInformationModel;
import com.pixelmed.utils.CopyStream;
import com.pixelmed.utils.MessageLogger;

/**
 * <p>This class is an application for retrieving DICOM studies of patients and downloading or transmitting them.</p>
 * 
 * <p>It is configured by use of a properties file that resides in the user's
 * home directory in <code>.com.pixelmed.display.DownloadOrTransmit.properties</code>.</p>
 * 
 * @author	dclunie
 */
public class DicomQR extends ApplicationFrame {

	/***/
	private static final String identString = "@(#) $Header: /userland/cvs/pixelmed/imgbook/com/pixelmed/apps/DownloadOrTransmit.java,v 1.7 2013/01/25 13:55:45 dclunie Exp $";

	protected static String propertiesFileName  = "/DicomProxy/etc/RemotePACsConfig.properties";

	protected static String propertyName_DicomCurrentlySelectedStorageTargetAE = "Dicom.CurrentlySelectedStorageTargetAE";
	protected static String propertyName_DicomCurrentlySelectedQueryTargetAE = "Dicom.CurrentlySelectedQueryTargetAE";

	protected static String localDatabaseName = "Local";
	protected static String localDatabaseServerName = "RemotePACS";	// if not null, can access externally: java -cp lib/additional/hsqldb.jar org.hsqldb.util.DatabaseManagerSwing --url "jdbc:hsqldb:hsql://localhost/DownloadOrTransmit"

	protected static String rootNameForDicomInstanceFilesOnInterchangeMedia = "DICOM";
	protected static String filePrefixForDicomInstanceFilesOnInterchangeMedia = "I";
	protected static String fileSuffixForDicomInstanceFilesOnInterchangeMedia = "";
	protected static String nameForDicomDirectoryOnInterchangeMedia = "DICOMDIR";
	protected static String exportedZipFileName = "export.zip";

	protected static int textFieldLengthForQueryPatientName = 16;
	protected static int textFieldLengthForQueryPatientID = 10;
	protected static int textFieldLengthForQueryStudyDate = 8;

	static protected String queryIntroductionLabelText = "Query -";
	static protected String queryPatientNameLabelText = "Patient's Name:";
	static protected String queryPatientIDLabelText = "Patient's ID:";
	static protected String queryStudyDateLabelText = "Study Date:";

	static protected String configureButtonLabel = "Configure";
	static protected String       logButtonLabel = "Log";
	static protected String     queryButtonLabel = "Query";
	static protected String  retrieveButtonLabel = "Retrieve";
	static protected String    importButtonLabel = "Open";
	static protected String      viewButtonLabel = "View";
	static protected String    exportButtonLabel = "->Save";
	static protected String     purgeButtonLabel = "Purge";

	static protected String configureButtonToolTipText = "Configure the application, including DICOM network properties";
	static protected String       logButtonToolTipText = "Show the log of activities";
	static protected String     queryButtonToolTipText = "Query a remote DICOM network host";
	static protected String  retrieveButtonToolTipText = "Retrieve query selection from remote DICOM network host";
	static protected String    importButtonToolTipText = "Open files and import them for sending";
	static protected String      viewButtonToolTipText = "View image";
	static protected String    exportButtonToolTipText = "exportButtonToolTipText";
	static protected String     purgeButtonToolTipText = "Remove selected entry from local database and delete any local copy of files";

	static protected String queryPatientNameToolTipText = "The text to use for the Patient's Name when querying";
	static protected String queryPatientIDToolTipText = "The text to use for the Patient's ID when querying";
	static protected String queryStudyDateToolTipText = "The text to use for the Study Date when querying";

	static protected String    showDetailedLogLabelText = "Show detailed log";
	static protected String          zipExportLabelText = "Zip exported files";
	static protected String hierarchicalExportLabelText = "Hierarchical names in export";
	static protected String  addDicomDirectoryLabelText = "Include DICOMDIR in export";

	static protected String hierarchicalExportToolTipText = "Use descriptive Patient/Study/Series/Instance hierarchy of folder and file names (which are ILLEGAL on DICOM media and INVALID for CS VR in DICOMDIR)";
	static protected String  addDicomDirectoryToolTipText = "Generate a DICOMDIR for the exported files (required to make a valid DICOM Fileset)";

	static protected String loggerTitleMessage = "Download Or Transmit Log";

	static protected int viewerFrameWidthWanted  = 512;
	static protected int viewerFrameHeightWanted = 512;

	static protected int validatorFrameWidthWanted  = 512;
	static protected int validatorFrameHeightWanted = 384;

	static protected int loggertDialogWidthWanted  = 512;
	static protected int loggerDialogHeightWanted = 384;

	protected DatabaseInformationModel srcDatabase;

	protected JPanel srcDatabasePanel;
	protected JPanel remoteQueryRetrievePanel;

	protected JCheckBox showDetailedLogCheckBox;
	protected JCheckBox zipExportCheckBox;
	protected JCheckBox hierarchicalExportCheckBox;
	protected JCheckBox addDicomDirectoryCheckBox;

	protected JTextField queryFilterPatientNameTextField;
	protected JTextField queryFilterPatientIDTextField;
	protected JTextField queryFilterStudyDateTextField;

	protected SafeProgressBarUpdaterThread progressBarUpdater;

	protected SafeCursorChanger cursorChanger;

	protected MessageLogger logger;

	protected NetworkApplicationProperties networkApplicationProperties;
	protected NetworkApplicationInformation networkApplicationInformation;

	protected QueryInformationModel currentRemoteQueryInformationModel;
	protected QueryTreeBrowser currentRemoteQueryTreeBrowser;

	protected QueryTreeRecord currentRemoteQuerySelectionQueryTreeRecord;
	protected AttributeList currentRemoteQuerySelectionUniqueKeys;
	protected Attribute currentRemoteQuerySelectionUniqueKey;
	protected String currentRemoteQuerySelectionRetrieveAE;
	protected String currentRemoteQuerySelectionLevel;

	protected String ourCalledAETitle;		// set when reading network properties; used not just in StorageSCP, but also when creating exported meta information headers

	protected static boolean haveScannedForCodecs = false;

	protected static boolean haveCheckedForJPEGLosslessCodec = false;
	protected static boolean haveFoundJPEGLosslessCodec = false;

	protected boolean haveJPEGLosslessCodec() {
		if (!haveCheckedForJPEGLosslessCodec) {
			if (!haveScannedForCodecs) {
				//System.err.println("DownloadOrTransmit.haveJPEGLosslessCodec(): Scanning for ImageIO plugin codecs");
				ImageIO.scanForPlugins();
				haveScannedForCodecs=true;
			}
			haveFoundJPEGLosslessCodec = false;
			String readerWanted="jpeg-lossless";
			try {
				javax.imageio.ImageReader reader =  (javax.imageio.ImageReader)(javax.imageio.ImageIO.getImageReadersByFormatName(readerWanted).next());
				if (reader != null) {
					//System.err.println("DownloadOrTransmit.haveJPEGLosslessCodec(): Found jpeg-lossless reader");
					haveFoundJPEGLosslessCodec = true;
					try {
						//System.err.println("DownloadOrTransmit.haveJPEGLosslessCodec(): Calling dispose() on reader");
						reader.dispose();
					}
					catch (Exception e) {
						e.printStackTrace(System.err);
					}
				}
				else {
					//System.err.println("DownloadOrTransmit.haveJPEGLosslessCodec(): No jpeg-lossless reader");
				}
			}
			catch (Exception e) {
				//System.err.println("DownloadOrTransmit.haveJPEGLosslessCodec(): No jpeg-lossless reader");
				haveFoundJPEGLosslessCodec = false;
			}
			haveCheckedForJPEGLosslessCodec = true;
		}
		return haveFoundJPEGLosslessCodec;
	}

	protected static boolean haveCheckedForJPEG2000Part1Codec = false;
	protected static boolean haveFoundJPEG2000Part1Codec = false;

	protected boolean haveJPEG2000Part1Codec() {
		if (!haveCheckedForJPEG2000Part1Codec) {
			if (!haveScannedForCodecs) {
				//System.err.println("DownloadOrTransmit.haveJPEG2000Part1Codec(): Scanning for ImageIO plugin codecs");
				ImageIO.scanForPlugins();
				haveScannedForCodecs=true;
			}
			haveFoundJPEG2000Part1Codec = false;
			String readerWanted="JPEG2000";
			try {
				javax.imageio.ImageReader reader =  (javax.imageio.ImageReader)(javax.imageio.ImageIO.getImageReadersByFormatName(readerWanted).next());
				if (reader != null) {
					//System.err.println("DownloadOrTransmit.haveJPEG2000Part1Codec(): Found JPEG2000 reader");
					haveFoundJPEG2000Part1Codec = true;
					try {
						//System.err.println("DownloadOrTransmit.haveJPEG2000Part1Codec(): Calling dispose() on reader");
						reader.dispose();
					}
					catch (Exception e) {
						e.printStackTrace(System.err);
					}
				}
				else {
					//System.err.println("DownloadOrTransmit.haveJPEG2000Part1Codec(): No JPEG2000 reader");
				}
			}
			catch (Exception e) {
				//System.err.println("DownloadOrTransmit.haveJPEG2000Part1Codec(): No JPEG2000 reader");
				haveFoundJPEG2000Part1Codec = false;
			}
			haveCheckedForJPEG2000Part1Codec = true;
		}
		return haveFoundJPEG2000Part1Codec;
	}

	protected void setCurrentRemoteQueryInformationModel(String remoteAEForQuery) {
		currentRemoteQueryInformationModel=null;
		String stringForTitle="";
		if (remoteAEForQuery != null && remoteAEForQuery.length() > 0 && networkApplicationProperties != null && networkApplicationInformation != null) {
			try {
				String              queryCallingAETitle = networkApplicationProperties.getCallingAETitle();
				String               queryCalledAETitle = networkApplicationInformation.getApplicationEntityTitleFromLocalName(remoteAEForQuery);
				PresentationAddress presentationAddress = networkApplicationInformation.getApplicationEntityMap().getPresentationAddress(queryCalledAETitle);

				if (presentationAddress == null) {
					throw new Exception("For remote query AE <"+remoteAEForQuery+">, presentationAddress cannot be determined");
				}

				String                        queryHost = presentationAddress.getHostname();
				int			      queryPort = presentationAddress.getPort();
				String                       queryModel = networkApplicationInformation.getApplicationEntityMap().getQueryModel(queryCalledAETitle);
				int                     queryDebugLevel = networkApplicationProperties.getQueryDebugLevel();

				if (NetworkApplicationProperties.isStudyRootQueryModel(queryModel) || queryModel == null) {
					currentRemoteQueryInformationModel=new StudyRootQueryInformationModel(queryHost,queryPort,queryCalledAETitle,queryCallingAETitle,queryDebugLevel);
					stringForTitle=":"+remoteAEForQuery;
				}
				else {
					throw new Exception("For remote query AE <"+remoteAEForQuery+">, query model "+queryModel+" not supported");
				}
			}
			catch (Exception e) {		// if an AE's property has no value, or model not supported
				e.printStackTrace(System.err);
			}
		}
	}

	private String showInputDialogToSelectNetworkTargetByLocalApplicationEntityName(String message,String title,String defaultSelection) {
		String ae =defaultSelection;
		if (networkApplicationInformation != null) {
			Set localNamesOfRemoteAEs = networkApplicationInformation.getListOfLocalNamesOfApplicationEntities();
			if (localNamesOfRemoteAEs != null) {
				String sta[] = new String[localNamesOfRemoteAEs.size()];
				int i=0;
				Iterator it = localNamesOfRemoteAEs.iterator();
				while (it.hasNext()) {
					sta[i++]=(String)(it.next());
				}
				ae = (String)JOptionPane.showInputDialog(getContentPane(),message,title,JOptionPane.QUESTION_MESSAGE,null,sta,ae);
			}
		}
		return ae;
	}
	
	private String getFirstNetworkTargetByLocalApplicationEntityName() {
		String ae = null;
		if (networkApplicationInformation != null) {
			Set localNamesOfRemoteAEs = networkApplicationInformation.getListOfLocalNamesOfApplicationEntities();
			if (localNamesOfRemoteAEs != null) {
				String sta[] = new String[localNamesOfRemoteAEs.size()];
				int i=0;
				Iterator it = localNamesOfRemoteAEs.iterator();
				while (it.hasNext()) {
					sta[i++]=(String)(it.next());
				}
				ae=sta[0];
			}
		}
		return ae;
	}
	

	protected static void importFileIntoDatabase(DatabaseInformationModel database,String dicomFileName,String fileRefererenceType) throws FileNotFoundException, IOException, DicomException {
		ApplicationEventDispatcher.getApplicationEventDispatcher().processEvent(new StatusChangeEvent("Importing: "+dicomFileName));
		//System.err.println("Importing: "+dicomFileName);
		FileInputStream fis = new FileInputStream(dicomFileName);
		DicomInputStream i = new DicomInputStream(new BufferedInputStream(fis));
		AttributeList list = new AttributeList();
		list.read(i,TagFromName.PixelData);
		i.close();
		fis.close();
		database.insertObject(list,dicomFileName,fileRefererenceType);
	}

	protected class OurReceivedObjectHandler extends ReceivedObjectHandler {
		public void sendReceivedObjectIndication(String dicomFileName,String transferSyntax,String callingAETitle)
		throws DicomNetworkException, DicomException, IOException {
			if (dicomFileName != null) {
				String localName = networkApplicationInformation.getLocalNameFromApplicationEntityTitle(callingAETitle);
				ApplicationEventDispatcher.getApplicationEventDispatcher().processEvent(new StatusChangeEvent("Received "+dicomFileName+" from "+callingAETitle+" in "+transferSyntax));
				System.out.println("Received: "+dicomFileName+" from "+callingAETitle+" in "+transferSyntax);
				if (showDetailedLogCheckBox.isSelected()) { logger.sendLn("Received "+dicomFileName+" from "+localName+" ("+callingAETitle+")"); }
				try {
					importFileIntoDatabase(srcDatabase,dicomFileName,DatabaseInformationModel.FILE_COPIED);
					srcDatabasePanel.removeAll();
					new OurSourceDatabaseTreeBrowser(srcDatabase,srcDatabasePanel);
					srcDatabasePanel.validate();
					new File(dicomFileName).deleteOnExit();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}

		}
	}

	protected File savedImagesFolder;

	protected StorageSOPClassSCPDispatcher storageSOPClassSCPDispatcher;

	/**
	 * <p>Start DICOM storage listener for populating source database.</p>
	 *
	 * @exception	DicomException
	 */
	protected void activateStorageSCP() throws DicomException, IOException {
		// Start up DICOM association listener in background for receiving images and responding to echoes ...
		if (networkApplicationProperties != null) {
			{
				int port = networkApplicationProperties.getListeningPort();
				ourCalledAETitle = networkApplicationProperties.getCalledAETitle();
				ApplicationEventDispatcher.getApplicationEventDispatcher().processEvent(new StatusChangeEvent("Starting up DICOM association listener on port "+port+" AET "+ourCalledAETitle));
				System.err.println("Starting up DICOM association listener on port "+port+" AET "+ourCalledAETitle);
				int storageSCPDebugLevel = networkApplicationProperties.getStorageSCPDebugLevel();
				int queryDebugLevel = networkApplicationProperties.getQueryDebugLevel();
				storageSOPClassSCPDispatcher = new StorageSOPClassSCPDispatcher(port,ourCalledAETitle,savedImagesFolder,StoredFilePathStrategy.BYSOPINSTANCEUIDINSINGLEFOLDER,new OurReceivedObjectHandler(),
						srcDatabase == null ? null : srcDatabase.getQueryResponseGeneratorFactory(queryDebugLevel),
								srcDatabase == null ? null : srcDatabase.getRetrieveResponseGeneratorFactory(queryDebugLevel),
										networkApplicationInformation,
										new OurPresentationContextSelectionPolicy(),
										false/*secureTransport*/,
										storageSCPDebugLevel);
				new Thread(storageSOPClassSCPDispatcher).start();
			}
		}
	}

	class OurPresentationContextSelectionPolicy extends UnencapsulatedExplicitStoreFindMoveGetPresentationContextSelectionPolicy {
		OurPresentationContextSelectionPolicy() {
			super();
			transferSyntaxSelectionPolicy = new OurTransferSyntaxSelectionPolicy();
		}
	}

	// we will (grudgingly) accept JPEGBaseline, since we know the JRE can natively decode it without JIIO extensions present,
	// so will work by decompressing during attribute list read for cleaning

	class OurTransferSyntaxSelectionPolicy extends TransferSyntaxSelectionPolicy {
		public LinkedList applyTransferSyntaxSelectionPolicy(LinkedList presentationContexts,int associationNumber,int debugLevel) {
			//System.err.println("DownloadOrTransmit.OurTransferSyntaxSelectionPolicy.applyTransferSyntaxSelectionPolicy(): offered "+presentationContexts);
			boolean canUseBzip = PresentationContextListFactory.haveBzip2Support();
			ListIterator pcsi = presentationContexts.listIterator();
			while (pcsi.hasNext()) {
				PresentationContext pc = (PresentationContext)(pcsi.next());
				boolean foundExplicitVRLittleEndian = false;
				boolean foundImplicitVRLittleEndian = false;
				boolean foundExplicitVRBigEndian = false;
				boolean foundDeflated = false;
				boolean foundBzipped = false;
				boolean foundJPEGBaseline = false;
				boolean foundJPEGLossless = false;
				boolean foundJPEGLosslessSV1 = false;
				boolean foundJPEG2000 = false;
				boolean foundJPEG2000Lossless = false;
				List tsuids = pc.getTransferSyntaxUIDs();
				ListIterator tsuidsi = tsuids.listIterator();
				while (tsuidsi.hasNext()) {
					String transferSyntaxUID=(String)(tsuidsi.next());
					if (transferSyntaxUID != null) {
						if      (transferSyntaxUID.equals(TransferSyntax.ImplicitVRLittleEndian)) foundImplicitVRLittleEndian = true;
						else if (transferSyntaxUID.equals(TransferSyntax.ExplicitVRLittleEndian)) foundExplicitVRLittleEndian = true;
						else if (transferSyntaxUID.equals(TransferSyntax.ExplicitVRBigEndian)) foundExplicitVRBigEndian = true;
						else if (transferSyntaxUID.equals(TransferSyntax.DeflatedExplicitVRLittleEndian)) foundDeflated = true;
						else if (transferSyntaxUID.equals(TransferSyntax.PixelMedBzip2ExplicitVRLittleEndian)) foundBzipped = true;
						else if (transferSyntaxUID.equals(TransferSyntax.JPEGBaseline)) foundJPEGBaseline = true;
						else if (transferSyntaxUID.equals(TransferSyntax.JPEGLossless)) foundJPEGLossless = true;
						else if (transferSyntaxUID.equals(TransferSyntax.JPEGLosslessSV1)) foundJPEGLosslessSV1 = true;
						else if (transferSyntaxUID.equals(TransferSyntax.JPEG2000)) foundJPEG2000 = true;
						else if (transferSyntaxUID.equals(TransferSyntax.JPEG2000Lossless)) foundJPEG2000Lossless = true;
					}
				}
				// discard old list and make a new one ...
				pc.newTransferSyntaxUIDs();
				// Policy is prefer bzip then deflate compressed then explicit (little then big) then implicit,
				// then supported image compression transfer syntaxes in the following order and ignore anything else
				// with the intent of having the sender decompress the image compression transfer syntaxes if it provided multiple choices.
				// must only support ONE in response
				if (foundBzipped && canUseBzip) {
					pc.addTransferSyntaxUID(TransferSyntax.PixelMedBzip2ExplicitVRLittleEndian);
				}
				else if (foundDeflated) {
					pc.addTransferSyntaxUID(TransferSyntax.DeflatedExplicitVRLittleEndian);
				}
				else if (foundExplicitVRLittleEndian) {
					pc.addTransferSyntaxUID(TransferSyntax.ExplicitVRLittleEndian);
				}
				else if (foundExplicitVRBigEndian) {
					pc.addTransferSyntaxUID(TransferSyntax.ExplicitVRBigEndian);
				}
				else if (foundImplicitVRLittleEndian) {
					pc.addTransferSyntaxUID(TransferSyntax.ImplicitVRLittleEndian);
				}
				else if (foundJPEGBaseline) {
					pc.addTransferSyntaxUID(TransferSyntax.JPEGBaseline);
				}
				else if (foundJPEGLossless && haveJPEGLosslessCodec()) {
					pc.addTransferSyntaxUID(TransferSyntax.JPEGLossless);
				}
				else if (foundJPEGLosslessSV1 && haveJPEGLosslessCodec()) {
					pc.addTransferSyntaxUID(TransferSyntax.JPEGLosslessSV1);
				}
				else if (foundJPEG2000 && haveJPEG2000Part1Codec()) {
					pc.addTransferSyntaxUID(TransferSyntax.JPEG2000);
				}
				else if (foundJPEG2000Lossless && haveJPEG2000Part1Codec()) {
					pc.addTransferSyntaxUID(TransferSyntax.JPEG2000Lossless);
				}
				else {
					pc.setResultReason((byte)4);				// transfer syntaxes not supported (provider rejection)
				}
			}
			//System.err.println("DownloadOrTransmit.OurTransferSyntaxSelectionPolicy.applyTransferSyntaxSelectionPolicy(): accepted "+presentationContexts);
			return presentationContexts;
		}
	}

	/**
	 * <p>Start local database.</p>
	 *
	 * <p>Will not persist when the application is closed, so in memory database
	 *  is used and instances live in the temporary filesystem.</p>
	 *
	 * @exception	DicomException
	 */
	protected void activateTemporaryDatabases() throws DicomException {
		//srcDatabase = new PatientStudySeriesConcatenationInstanceModel("mem:src",localDatabaseServerName,localDatabaseName);
		srcDatabase = new MinimalPatientStudySeriesInstanceModel("mem:src",localDatabaseServerName,localDatabaseName);
	}

	protected DatabaseTreeRecord[] currentDatabaseTreeRecordSelections;

	protected Vector getCurrentSourceFilePathSelections() {
		Vector names = new Vector();
		if (currentDatabaseTreeRecordSelections != null) {
			for (DatabaseTreeRecord r : currentDatabaseTreeRecordSelections) {
				DatabaseTreeBrowser.recurseThroughChildrenGatheringFileNames(r,names);
			}
		}
		return names;
	}

	protected class OurSourceDatabaseTreeBrowser extends DatabaseTreeBrowser {
		public OurSourceDatabaseTreeBrowser(DatabaseInformationModel d,Container content) throws DicomException {
			super(d,content);
			//System.err.println("DownloadOrTransmit.OurSourceDatabaseTreeBrowser(): end of constructor ");
		}

		protected TreeSelectionListener buildTreeSelectionListenerToDoSomethingWithSelectedFiles() {
			return new TreeSelectionListener() {
				public void valueChanged(TreeSelectionEvent tse) {
					currentDatabaseTreeRecordSelections = getSelectionPaths();
				}
			};
		}

		// doSomethingWithSelections(DatabaseTreeRecord) is never called so do not need to override it ... we set the currentDatabaseTreeRecordSelection value directly

		// doSomethingWithSelectedFiles(Vector paths) is never called so do not need to override it ... we build this ourselves on demand from the cached currentDatabaseTreeRecordSelection

		protected void doSomethingMoreWithWhateverWasSelected() {
			// doSomethingMoreWithWhateverWasSelected() do nothing on double click of node
		}

	}

	// very similar to code in DicomCleaner and DicomImageViewer and DoseUtility apart from logging and progress bar ... should refactor :(
	protected void purgeFilesAndDatabaseInformation(DatabaseTreeRecord[] databaseSelections,MessageLogger logger,SafeProgressBarUpdaterThread progressBarUpdater,int done,int maximum) throws DicomException, IOException {
		if (databaseSelections != null) {
			for (DatabaseTreeRecord databaseSelection : databaseSelections) {
				purgeFilesAndDatabaseInformation(databaseSelection,logger,progressBarUpdater,done,maximum);
			}
		}
	}

	protected void purgeFilesAndDatabaseInformation(DatabaseTreeRecord databaseSelection,MessageLogger logger,SafeProgressBarUpdaterThread progressBarUpdater,int done,int maximum) throws DicomException, IOException {
		//System.err.println("DownloadOrTransmit.purgeFilesAndDatabaseInformation(): "+databaseSelection);
		if (databaseSelection != null) {
			SafeProgressBarUpdaterThread.updateProgressBar(progressBarUpdater,done,maximum);
			InformationEntity ie = databaseSelection.getInformationEntity();
			//System.err.println("DownloadOrTransmit.purgeFilesAndDatabaseInformation(): ie = "+ie);
			if (ie == null /* the root of the tree, i.e., everything */ || !ie.equals(InformationEntity.INSTANCE)) {
				// Do it one study at a time, in the order in which the patients and studies are sorted in the tree
				Enumeration children = databaseSelection.children();
				if (children != null) {
					maximum+=databaseSelection.getChildCount();
					while (children.hasMoreElements()) {
						DatabaseTreeRecord child = (DatabaseTreeRecord)(children.nextElement());
						if (child != null) {
							purgeFilesAndDatabaseInformation(child,logger,progressBarUpdater,done,maximum);
							++done;
						}
					}
				}
				// AFTER we have processed all the children, if any, we can delete ourselves, unless we are the root
				if (ie != null) {
					//System.err.println("DownloadOrTransmit.purgeFilesAndDatabaseInformation(): removeFromParent having recursed over children "+databaseSelection);
					if (showDetailedLogCheckBox.isSelected()) { logger.sendLn("Purging "+databaseSelection); }
					databaseSelection.removeFromParent();
				}
			}
			else {
				// Instance level ... may need to delete files
				String fileName = databaseSelection.getLocalFileNameValue();
				String fileReferenceType = databaseSelection.getLocalFileReferenceTypeValue();
				//System.err.println("DownloadOrTransmit.purgeFilesAndDatabaseInformation(): fileReferenceType = "+fileReferenceType+" for file "+fileName);
				if (fileReferenceType != null && fileReferenceType.equals(DatabaseInformationModel.FILE_COPIED)) {
					//System.err.println("DownloadOrTransmit.purgeFilesAndDatabaseInformation(): deleting fileName "+fileName);
					try {
						if (showDetailedLogCheckBox.isSelected()) { logger.sendLn("Deleting file "+fileName); }
						if (!new File(fileName).delete()) {
							logger.sendLn("Failed to delete local copy of file "+fileName);
						}
					}
					catch (Exception e) {
						e.printStackTrace(System.err);
						logger.sendLn("Failed to delete local copy of file "+fileName);
					}
				}
				//System.err.println("DownloadOrTransmit.purgeFilesAndDatabaseInformation(): removeFromParent instance level "+databaseSelection);
				if (showDetailedLogCheckBox.isSelected()) { logger.sendLn("Purging "+databaseSelection); }
				databaseSelection.removeFromParent();
			}
		}
	}

	protected class PurgeWorker implements Runnable {
		DatabaseTreeRecord[] databaseSelections;

		PurgeWorker(DatabaseTreeRecord[] databaseSelections) {
			this.databaseSelections=databaseSelections;
		}

		public void run() {
			cursorChanger.setWaitCursor();
			logger.sendLn("Purging started");
			ApplicationEventDispatcher.getApplicationEventDispatcher().processEvent(new StatusChangeEvent("Purging started"));
			SafeProgressBarUpdaterThread.startProgressBar(progressBarUpdater);
			try {
				purgeFilesAndDatabaseInformation(databaseSelections,logger,progressBarUpdater,0,1);
			} catch (Exception e) {
				ApplicationEventDispatcher.getApplicationEventDispatcher().processEvent(new StatusChangeEvent("Purging failed: "+e));
				e.printStackTrace(System.err);
			}
			srcDatabasePanel.removeAll();
			try {
				new OurSourceDatabaseTreeBrowser(srcDatabase,srcDatabasePanel);
			} catch (Exception e) {
				ApplicationEventDispatcher.getApplicationEventDispatcher().processEvent(new StatusChangeEvent("Refresh source database browser failed: "+e));
				e.printStackTrace(System.err);
			}
			srcDatabasePanel.validate();
			SafeProgressBarUpdaterThread.endProgressBar(progressBarUpdater);
			logger.sendLn("Purging complete");
			ApplicationEventDispatcher.getApplicationEventDispatcher().processEvent(new StatusChangeEvent("Done purging"));
			cursorChanger.restoreCursor();
		}
	}

	protected class PurgeActionListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				activeThread = new Thread(new PurgeWorker(currentDatabaseTreeRecordSelections));
				activeThread.start();

			} catch (Exception e) {
				ApplicationEventDispatcher.getApplicationEventDispatcher().processEvent(new StatusChangeEvent("Purging failed: "+e));
				e.printStackTrace(System.err);
			}
		}
	}

	protected static String getSRDescriptionForLog(AttributeList list) {
		return 
		"Patient "+Attribute.getSingleStringValueOrEmptyString(list,TagFromName.PatientID)
		+ " Study "+Attribute.getSingleStringValueOrEmptyString(list,TagFromName.StudyDate)
		+ " Accession "+Attribute.getSingleStringValueOrEmptyString(list,TagFromName.AccessionNumber)
		;
	}

	protected class ViewWorker implements Runnable {
		Vector sourceFilePathSelections;

		ViewWorker(Vector sourceFilePathSelections) {
			this.sourceFilePathSelections=sourceFilePathSelections;
		}

		public void run() {
			cursorChanger.setWaitCursor();
			if (logger instanceof DialogMessageLogger) {
				((DialogMessageLogger)logger).setVisible(true);
			}
			if (showDetailedLogCheckBox.isSelected()) { logger.sendLn("View started"); }
			ApplicationEventDispatcher.getApplicationEventDispatcher().processEvent(new StatusChangeEvent("View started"));
			SafeProgressBarUpdaterThread.startProgressBar(progressBarUpdater);
			if (sourceFilePathSelections != null) {
				DicomBrowser.loadAndDisplayImagesFromSOPInstances(sourceFilePathSelections,null,null,viewerFrameWidthWanted,viewerFrameHeightWanted);
			}
			SafeProgressBarUpdaterThread.endProgressBar(progressBarUpdater);
			if (showDetailedLogCheckBox.isSelected()) { logger.sendLn("View complete"); }
			ApplicationEventDispatcher.getApplicationEventDispatcher().processEvent(new StatusChangeEvent("Done view"));
			cursorChanger.restoreCursor();
		}
	}

	protected class ViewActionListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				activeThread = new Thread(new ViewWorker(getCurrentSourceFilePathSelections()));
				activeThread.start();

			} catch (Exception e) {
				ApplicationEventDispatcher.getApplicationEventDispatcher().processEvent(new StatusChangeEvent("View failed: "+e));
				e.printStackTrace(System.err);
			}
		}
	}


	protected String exportDirectoryPath;	// keep around between invocations

	protected static String makeNewFullyQualifiedInterchangeMediaInstancePathName(int fileCount) throws IOException {
		return new File(
				rootNameForDicomInstanceFilesOnInterchangeMedia,
				filePrefixForDicomInstanceFilesOnInterchangeMedia + Integer.toString(fileCount) + fileSuffixForDicomInstanceFilesOnInterchangeMedia)
		.getPath();
	}

	protected static String makeNewFullyQualifiedHierarchicalInstancePathName(String sourceFileName) throws DicomException, IOException {
		AttributeList list = new AttributeList();
		list.read(sourceFileName,TagFromName.PixelData);
		String hierarchicalFileName = MoveDicomFilesIntoHierarchy.makeHierarchicalPathFromAttributes(list);
		return new File(rootNameForDicomInstanceFilesOnInterchangeMedia,hierarchicalFileName).getPath();
	}

	protected static void exportFiles(Vector<String> filesToCopy,File whereToCopyFiles,String actionNoun,SafeProgressBarUpdaterThread progressBarUpdater,MessageLogger logger,boolean detailedLog,boolean addDicomDirectory,boolean hierarchicalExport,String zipFileName) {
		String actionIng = actionNoun.replaceFirst("[aeiou]$","") + "ing";
		String actionAdjective = actionNoun.replaceFirst("[aeiou]$","") + "ed";
		logger.sendLn(actionNoun+" started");
		try {
			int nFiles = filesToCopy.size();
			SafeProgressBarUpdaterThread.updateProgressBar(progressBarUpdater,0,nFiles+1);		// include DICOMDIR
			String exportFileNames[] = new String[nFiles];
			for (int j=0; j<nFiles; ++j) {
				String databaseFileName = (String)(filesToCopy.get(j));
				String exportRelativePathName = hierarchicalExport ? makeNewFullyQualifiedHierarchicalInstancePathName(databaseFileName) : makeNewFullyQualifiedInterchangeMediaInstancePathName(j);
				File exportFile = new File(whereToCopyFiles,exportRelativePathName);
				ApplicationEventDispatcher.getApplicationEventDispatcher().processEvent(new StatusChangeEvent(actionIng+" "+exportRelativePathName));
				if (detailedLog) logger.sendLn(actionIng+" "+databaseFileName+" to "+exportFile.getCanonicalPath());
				exportFile.getParentFile().mkdirs();
				CopyStream.copy(new File(databaseFileName),exportFile);
				exportFileNames[j] = exportRelativePathName;
				SafeProgressBarUpdaterThread.updateProgressBar(progressBarUpdater,j+1);
			}

			if (addDicomDirectory) {
				ApplicationEventDispatcher.getApplicationEventDispatcher().processEvent(new StatusChangeEvent("Creating DICOMDIR"));
				logger.sendLn("Creating DICOMDIR");
				DicomDirectory dicomDirectory = new DicomDirectory(whereToCopyFiles,exportFileNames);
				dicomDirectory.write(new File(whereToCopyFiles,nameForDicomDirectoryOnInterchangeMedia).getCanonicalPath());
				SafeProgressBarUpdaterThread.updateProgressBar(progressBarUpdater,nFiles+1);		// include DICOMDIR
			}

			if (zipFileName != null && zipFileName.length() > 0) {
				File zipFile = new File(whereToCopyFiles,zipFileName);
				ApplicationEventDispatcher.getApplicationEventDispatcher().processEvent(new StatusChangeEvent("Zipping "+actionAdjective.toLowerCase()+" files to "+zipFile));
				if (detailedLog) logger.sendLn("Zipping "+actionAdjective.toLowerCase()+" files to "+zipFile);
				zipFile.delete();
				FileOutputStream fout = new FileOutputStream(zipFile);
				ZipOutputStream zout = new ZipOutputStream(fout);
				zout.setMethod(ZipOutputStream.DEFLATED);
				zout.setLevel(9);

				SafeProgressBarUpdaterThread.updateProgressBar(progressBarUpdater,0,nFiles+1);		// include DICOMDIR
				for (int j=0; j<nFiles; ++j) {
					String exportRelativePathName = exportFileNames[j];
					ApplicationEventDispatcher.getApplicationEventDispatcher().processEvent(new StatusChangeEvent("Adding "+exportRelativePathName+" to "+zipFile));
					if (detailedLog) logger.sendLn("Adding "+exportRelativePathName+" to "+zipFile);
					File inFile = new File(whereToCopyFiles,exportRelativePathName);
					ZipEntry zipEntry = new ZipEntry(exportRelativePathName);
					//zipEntry.setMethod(ZipOutputStream.DEFLATED);
					zout.putNextEntry(zipEntry);
					FileInputStream in = new FileInputStream(inFile);
					CopyStream.copy(in,zout);
					zout.closeEntry();
					in.close();
					inFile.delete();
					SafeProgressBarUpdaterThread.updateProgressBar(progressBarUpdater,j+1);
				}

				{
					ApplicationEventDispatcher.getApplicationEventDispatcher().processEvent(new StatusChangeEvent("Adding "+nameForDicomDirectoryOnInterchangeMedia+" to "+zipFile));
					if (detailedLog) logger.sendLn("Adding "+nameForDicomDirectoryOnInterchangeMedia+" to "+zipFile);
					File inFile = new File(whereToCopyFiles,nameForDicomDirectoryOnInterchangeMedia);
					ZipEntry zipEntry = new ZipEntry(nameForDicomDirectoryOnInterchangeMedia);
					zipEntry.setMethod(ZipOutputStream.DEFLATED);
					zout.putNextEntry(zipEntry);
					FileInputStream in = new FileInputStream(inFile);
					CopyStream.copy(in,zout);
					zout.closeEntry();
					in.close();
					inFile.delete();
					SafeProgressBarUpdaterThread.updateProgressBar(progressBarUpdater,nFiles+1);		// include DICOMDIR
				}
				zout.close();
				fout.close();
				new File(whereToCopyFiles,rootNameForDicomInstanceFilesOnInterchangeMedia).delete();
				ApplicationEventDispatcher.getApplicationEventDispatcher().processEvent(new StatusChangeEvent("Zipping to "+zipFile+" complete"));
				if (detailedLog) logger.sendLn("Zipping to "+zipFile+" complete");
			}

		} catch (Exception e) {
			ApplicationEventDispatcher.getApplicationEventDispatcher().processEvent(new StatusChangeEvent(actionNoun+" failed: "+e));
			e.printStackTrace(System.err);
		}

		SafeProgressBarUpdaterThread.endProgressBar(progressBarUpdater);
		logger.sendLn(actionNoun+" complete");
		ApplicationEventDispatcher.getApplicationEventDispatcher().processEvent(new StatusChangeEvent("Done "+actionIng+" to "+whereToCopyFiles));
	}

	protected class ExportWorker implements Runnable {
		Vector destinationFilePathSelections;
		File exportDirectory;

		ExportWorker(Vector destinationFilePathSelections,File exportDirectory) {
			this.destinationFilePathSelections=destinationFilePathSelections;
			this.exportDirectory=exportDirectory;
		}

		public void run() {
			cursorChanger.setWaitCursor();
			exportFiles(destinationFilePathSelections,exportDirectory,"Save",progressBarUpdater,logger,
					showDetailedLogCheckBox.isSelected(),
					addDicomDirectoryCheckBox.isSelected(),
					hierarchicalExportCheckBox.isSelected(),
					zipExportCheckBox.isSelected() ? exportedZipFileName : null);
			cursorChanger.restoreCursor();
		}
	}

	protected class ExportActionListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (currentDatabaseTreeRecordSelections != null) {
				Vector actualPaths = new Vector();
				for (DatabaseTreeRecord databaseSelection : currentDatabaseTreeRecordSelections) {
					if (databaseSelection != null) {
						DatabaseTreeBrowser.recurseThroughChildrenGatheringFileNames(databaseSelection,actualPaths);
					}
				}
				if (actualPaths.size() > 0) {
					SafeFileChooser chooser = new SafeFileChooser(exportDirectoryPath);
					chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					if (chooser.showOpenDialog(DicomQR.this.getContentPane()) == JFileChooser.APPROVE_OPTION) {
						try {
							//exportDirectoryPath=chooser.getCurrentDirectory().getCanonicalPath();
							exportDirectoryPath = chooser.getSelectedFile().getCanonicalPath();
							File exportDirectory = new File(exportDirectoryPath);
							//System.err.println("DicomCleaner.ExportActionListener.actionPerformed(): selected root directory = "+exportDirectory);
							//System.err.println("DicomCleaner.ExportActionListener.actionPerformed(): copying files");
							new Thread(new ExportWorker(actualPaths,exportDirectory)).start();
						}
						catch (Exception e) {
							ApplicationEventDispatcher.getApplicationEventDispatcher().processEvent(new StatusChangeEvent("Export failed: "+e));
							e.printStackTrace(System.err);
						}
					}
					// else user cancelled operation in JOptionPane.showInputDialog() so gracefully do nothing
				}
			}
		}
	}

	protected class OurMultipleInstanceTransferStatusHandler extends MultipleInstanceTransferStatusHandlerWithFileName {
		int nFiles;
		MessageLogger logger;
		SafeProgressBarUpdaterThread progressBarUpdater;

		OurMultipleInstanceTransferStatusHandler(int nFiles,MessageLogger logger,SafeProgressBarUpdaterThread progressBarUpdater) {
			this.nFiles=nFiles;
			this.logger=logger;
			this.progressBarUpdater=progressBarUpdater;
		}

		public void updateStatus(int nRemaining,int nCompleted,int nFailed,int nWarning,String sopInstanceUID,String fileName,boolean success) {
			ApplicationEventDispatcher.getApplicationEventDispatcher().processEvent(new StatusChangeEvent("Remaining "+nRemaining+", completed "+nCompleted+", failed "+nFailed+", warning "+nWarning));
			SafeProgressBarUpdaterThread.updateProgressBar(progressBarUpdater,nFiles-nRemaining,nFiles);
			if (logger != null) {
				logger.sendLn((success ? "Sent " : "Failed to send ")+fileName);
			}
		}
	}


	

	

	// should be extracted to a utility class ... also used in DoseUtility and DoseReporterWithLegacyOCRAndAutoSendToRegistry :(
	public static String getQueryRetrieveAEFromIdentifier(AttributeList identifier,QueryInformationModel queryInformationModel) {
		String retrieveAE = null;
		if (identifier != null) {
			Attribute aRetrieveAETitle=identifier.get(TagFromName.RetrieveAETitle);
			if (aRetrieveAETitle != null) retrieveAE=aRetrieveAETitle.getSingleStringValueOrNull();
		}
		if (retrieveAE == null) {
			// it is legal for RetrieveAETitle to be zero length at all but the lowest levels of
			// the query model :( (See PS 3.4 C.4.1.1.3.2)
			// (so far the Leonardo is the only one that doesn't send it at all levels)
			// we could recurse down to the lower levels and get the union of the value there
			// but lets just keep it simple and ...
			// default to whoever it was we queried in the first place ...
			if (queryInformationModel != null) {
				retrieveAE=queryInformationModel.getCalledAETitle();
			}
		}
		return retrieveAE;
	}

	// should be extracted to a utility class ... also used in DoseUtility and DoseReporterWithLegacyOCRAndAutoSendToRegistry :(
	public static String getQueryRetrieveLevel(AttributeList identifier,Attribute uniqueKey) {
		String level = null;
		if (identifier != null) {
			Attribute a = identifier.get(TagFromName.QueryRetrieveLevel);
			if (a != null) {
				level = a.getSingleStringValueOrNull();
			}
		}
		if (level == null) {
			// QueryRetrieveLevel must have been (erroneously) missing in query response ... see with Dave Harvey's code on public server
			// so try to guess it from unique key in tree record
			// Fixes [bugs.mrmf] (000224) Missing query/retrieve level in C-FIND response causes tree select and retrieve to fail
			if (uniqueKey != null) {
				AttributeTag tag = uniqueKey.getTag();
				if (tag != null) {
					if (tag.equals(TagFromName.PatientID)) {
						level="PATIENT";
					}
					else if (tag.equals(TagFromName.StudyInstanceUID)) {
						level="STUDY";
					}
					else if (tag.equals(TagFromName.SeriesInstanceUID)) {
						level="SERIES";
					}
					else if (tag.equals(TagFromName.SOPInstanceUID)) {
						level="IMAGE";
					}
				}
			}
			//System.err.println("DownloadOrTransmit.getQueryRetrieveLevel(): Guessed missing Query Retrieve Level to be "+level);
		}
		return level;
	}

	protected void setCurrentRemoteQuerySelection(AttributeList uniqueKeys,Attribute uniqueKey,AttributeList identifier) {
		currentRemoteQuerySelectionUniqueKeys=uniqueKeys;
		currentRemoteQuerySelectionUniqueKey=uniqueKey;
		currentRemoteQuerySelectionRetrieveAE=null;
		if (identifier != null) {
			Attribute aRetrieveAETitle=identifier.get(TagFromName.RetrieveAETitle);
			if (aRetrieveAETitle != null) currentRemoteQuerySelectionRetrieveAE=aRetrieveAETitle.getSingleStringValueOrNull();
		}
		if (currentRemoteQuerySelectionRetrieveAE == null) {
			// it is legal for RetrieveAETitle to be zero length at all but the lowest levels of
			// the query model :( (See PS 3.4 C.4.1.1.3.2)
			// (so far the Leonardo is the only one that doesn't send it at all levels)
			// we could recurse down to the lower levels and get the union of the value there
			// but lets just keep it simple and ...
			// default to whoever it was we queried in the first place ...
			if (currentRemoteQueryInformationModel != null) {
				currentRemoteQuerySelectionRetrieveAE=currentRemoteQueryInformationModel.getCalledAETitle();
			}
		}
		currentRemoteQuerySelectionLevel = null;
		if (identifier != null) {
			Attribute a = identifier.get(TagFromName.QueryRetrieveLevel);
			if (a != null) {
				currentRemoteQuerySelectionLevel = a.getSingleStringValueOrNull();
			}
		}
		if (currentRemoteQuerySelectionLevel == null) {
			// QueryRetrieveLevel must have been (erroneously) missing in query response ... see with Dave Harvey's code on public server
			// so try to guess it from unique key in tree record
			// Fixes [bugs.mrmf] (000224) Missing query/retrieve level in C-FIND response causes tree select and retrieve to fail
			if (uniqueKey != null) {
				AttributeTag tag = uniqueKey.getTag();
				if (tag != null) {
					if (tag.equals(TagFromName.PatientID)) {
						currentRemoteQuerySelectionLevel="PATIENT";
					}
					else if (tag.equals(TagFromName.StudyInstanceUID)) {
						currentRemoteQuerySelectionLevel="STUDY";
					}
					else if (tag.equals(TagFromName.SeriesInstanceUID)) {
						currentRemoteQuerySelectionLevel="SERIES";
					}
					else if (tag.equals(TagFromName.SOPInstanceUID)) {
						currentRemoteQuerySelectionLevel="IMAGE";
					}
				}
			}
			System.err.println("DownloadOrTransmit.setCurrentRemoteQuerySelection(): Guessed missing currentRemoteQuerySelectionLevel to be "+currentRemoteQuerySelectionLevel);
		}
	}

	protected class OurQueryTreeBrowser extends QueryTreeBrowser {
		/**
		 * @param	q
		 * @param	m
		 * @param	content
		 * @exception	DicomException
		 */
		OurQueryTreeBrowser(QueryInformationModel q,QueryTreeModel m,Container content) throws DicomException {
			super(q,m,content);
		}
		/***/
		protected TreeSelectionListener buildTreeSelectionListenerToDoSomethingWithSelectedLevel() {
			return new TreeSelectionListener() {
				public void valueChanged(TreeSelectionEvent tse) {
					TreePath tp = tse.getNewLeadSelectionPath();
					if (tp != null) {
						Object lastPathComponent = tp.getLastPathComponent();
						if (lastPathComponent instanceof QueryTreeRecord) {
							QueryTreeRecord r = (QueryTreeRecord)lastPathComponent;
							setCurrentRemoteQuerySelection(r.getUniqueKeys(),r.getUniqueKey(),r.getAllAttributesReturnedInIdentifier());
							currentRemoteQuerySelectionQueryTreeRecord=r;
						}
					}
				}
			};
		}
	}

	protected class QueryWorker implements Runnable {
		AttributeList filter;

		QueryWorker(AttributeList filter) {
			this.filter=filter;
		}

		public void run() {
			cursorChanger.setWaitCursor();
			String calledAET = currentRemoteQueryInformationModel.getCalledAETitle();
			String localName = networkApplicationInformation.getLocalNameFromApplicationEntityTitle(calledAET);
			ApplicationEventDispatcher.getApplicationEventDispatcher().processEvent(new StatusChangeEvent("Performing query on "+localName));
			if (showDetailedLogCheckBox.isSelected()) { logger.sendLn("Query to "+localName+" ("+calledAET+") starting"); }
			try {
				QueryTreeModel treeModel = currentRemoteQueryInformationModel.performHierarchicalQuery(filter);
				currentRemoteQueryTreeBrowser = new OurQueryTreeBrowser(currentRemoteQueryInformationModel,treeModel,remoteQueryRetrievePanel);
				ApplicationEventDispatcher.getApplicationEventDispatcher().processEvent(new StatusChangeEvent("Done querying "+localName));
			} catch (Exception e) {
				ApplicationEventDispatcher.getApplicationEventDispatcher().processEvent(new StatusChangeEvent("Query to "+localName+" failed "+e));
				if (showDetailedLogCheckBox.isSelected()) { logger.sendLn("Query to "+localName+" ("+calledAET+") failed due to"+ e); }
				e.printStackTrace(System.err);
			}
			if (showDetailedLogCheckBox.isSelected()) { logger.sendLn("Query to "+localName+" ("+calledAET+") complete"); }
			ApplicationEventDispatcher.getApplicationEventDispatcher().processEvent(new StatusChangeEvent("Done querying  "+localName));
			cursorChanger.restoreCursor();
		}
	}

	protected class QueryActionListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			//new QueryRetrieveDialog("DownloadOrTransmit Query",400,512);
			Properties properties = getProperties();
			String ae = properties.getProperty(propertyName_DicomCurrentlySelectedQueryTargetAE);
			ae = showInputDialogToSelectNetworkTargetByLocalApplicationEntityName("Select remote system","Query ...",ae);
			remoteQueryRetrievePanel.removeAll();
			if (ae != null) {
				setCurrentRemoteQueryInformationModel(ae);
				if (currentRemoteQueryInformationModel == null) {
					ApplicationEventDispatcher.getApplicationEventDispatcher().processEvent(new StatusChangeEvent("Cannot query "+ae));
				}
				else {
					try {
						SpecificCharacterSet specificCharacterSet = new SpecificCharacterSet((String[])null);
						AttributeList filter = new AttributeList();
						{
							AttributeTag t = TagFromName.PatientName; Attribute a = new PersonNameAttribute(t,specificCharacterSet);
							String patientName = queryFilterPatientNameTextField.getText().trim();
							if (patientName != null && patientName.length() > 0) {
								a.addValue(patientName);
							}
							filter.put(t,a);
						}
						{
							AttributeTag t = TagFromName.PatientID; Attribute a = new ShortStringAttribute(t,specificCharacterSet);
							String patientID = queryFilterPatientIDTextField.getText().trim();
							if (patientID != null && patientID.length() > 0) {
								a.addValue(patientID);
							}
							filter.put(t,a);
						}
						{ AttributeTag t = TagFromName.PatientBirthDate; Attribute a = new DateAttribute(t); filter.put(t,a); }
						{ AttributeTag t = TagFromName.PatientSex; Attribute a = new CodeStringAttribute(t); filter.put(t,a); }

						{ AttributeTag t = TagFromName.StudyID; Attribute a = new ShortStringAttribute(t,specificCharacterSet); filter.put(t,a); }
						{ AttributeTag t = TagFromName.StudyDescription; Attribute a = new LongStringAttribute(t,specificCharacterSet); filter.put(t,a); }
						{ AttributeTag t = TagFromName.ModalitiesInStudy; Attribute a = new CodeStringAttribute(t); filter.put(t,a); }
						{
							AttributeTag t = TagFromName.StudyDate; Attribute a = new DateAttribute(t);
							String studyDate = queryFilterStudyDateTextField.getText().trim();
							if (studyDate != null && studyDate.length() > 0) {
								a.addValue(studyDate);
							}
							filter.put(t,a);
						}
						{ AttributeTag t = TagFromName.StudyTime; Attribute a = new TimeAttribute(t); filter.put(t,a); }
						{ AttributeTag t = TagFromName.PatientAge; Attribute a = new AgeStringAttribute(t); filter.put(t,a); }

						{ AttributeTag t = TagFromName.SeriesDescription; Attribute a = new LongStringAttribute(t,specificCharacterSet); filter.put(t,a); }
						{ AttributeTag t = TagFromName.SeriesNumber; Attribute a = new IntegerStringAttribute(t); filter.put(t,a); }
						{ AttributeTag t = TagFromName.Manufacturer; Attribute a = new LongStringAttribute(t); filter.put(t,a); }
						{ AttributeTag t = TagFromName.Modality; Attribute a = new CodeStringAttribute(t); filter.put(t,a); }
						{ AttributeTag t = TagFromName.SeriesDate; Attribute a = new DateAttribute(t); filter.put(t,a); }
						{ AttributeTag t = TagFromName.SeriesTime; Attribute a = new TimeAttribute(t); filter.put(t,a); }

						{ AttributeTag t = TagFromName.InstanceNumber; Attribute a = new IntegerStringAttribute(t); filter.put(t,a); }
						{ AttributeTag t = TagFromName.ContentDate; Attribute a = new DateAttribute(t); filter.put(t,a); }
						{ AttributeTag t = TagFromName.ContentTime; Attribute a = new TimeAttribute(t); filter.put(t,a); }
						{ AttributeTag t = TagFromName.ImageType; Attribute a = new CodeStringAttribute(t); filter.put(t,a); }
						{ AttributeTag t = TagFromName.NumberOfFrames; Attribute a = new IntegerStringAttribute(t); filter.put(t,a); }
						{ AttributeTag t = TagFromName.WindowCenter; Attribute a = new DecimalStringAttribute(t); filter.put(t,a); }
						{ AttributeTag t = TagFromName.WindowWidth; Attribute a = new DecimalStringAttribute(t); filter.put(t,a); }

						{ AttributeTag t = TagFromName.StudyInstanceUID; Attribute a = new UniqueIdentifierAttribute(t); filter.put(t,a); }
						{ AttributeTag t = TagFromName.SeriesInstanceUID; Attribute a = new UniqueIdentifierAttribute(t); filter.put(t,a); }
						{ AttributeTag t = TagFromName.SOPInstanceUID; Attribute a = new UniqueIdentifierAttribute(t); filter.put(t,a); }
						{ AttributeTag t = TagFromName.SOPClassUID; Attribute a = new UniqueIdentifierAttribute(t); filter.put(t,a); }
						{ AttributeTag t = TagFromName.SpecificCharacterSet; Attribute a = new CodeStringAttribute(t); filter.put(t,a); a.addValue("ISO_IR 100"); }

						activeThread = new Thread(new QueryWorker(filter));
						activeThread.start();
					}
					catch (Exception e) {
						e.printStackTrace(System.err);
						ApplicationEventDispatcher.getApplicationEventDispatcher().processEvent(new StatusChangeEvent("Query to "+ae+" failed"));
					}
				}
			}
			remoteQueryRetrievePanel.validate();
		}
	}

	protected void performRetrieve(AttributeList uniqueKeys,String selectionLevel,String retrieveAE) {
		try {
			AttributeList identifier = new AttributeList();
			if (uniqueKeys != null) {
				identifier.putAll(uniqueKeys);
				{ AttributeTag t = TagFromName.QueryRetrieveLevel; Attribute a = new CodeStringAttribute(t); a.addValue(selectionLevel); identifier.put(t,a); }
				currentRemoteQueryInformationModel.performHierarchicalMoveFrom(identifier,retrieveAE);
			}
			// else do nothing, since no unique key to specify what to retrieve
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}


	protected class RetrieveWorker implements Runnable {
		RetrieveWorker() {
		}

		public void run() {
			cursorChanger.setWaitCursor();
			String localName = networkApplicationInformation.getLocalNameFromApplicationEntityTitle(currentRemoteQuerySelectionRetrieveAE);
			if (currentRemoteQuerySelectionLevel == null) {	// they have selected the root of the tree
				QueryTreeRecord parent = currentRemoteQuerySelectionQueryTreeRecord;
				if (parent != null) {
					ApplicationEventDispatcher.getApplicationEventDispatcher().processEvent(new StatusChangeEvent("Retrieving everything from "+localName));
					logger.sendLn("Retrieving everything from "+localName+" ("+currentRemoteQuerySelectionRetrieveAE+")");
					Enumeration children = parent.children();
					if (children != null) {
						int nChildren = parent.getChildCount();
						//System.err.println("DownloadOrTransmit.RetrieveWorker.run(): Everything nChildren = "+nChildren);
						SafeProgressBarUpdaterThread.startProgressBar(progressBarUpdater,nChildren);
						int doneCount = 0;
						while (children.hasMoreElements()) {
							QueryTreeRecord r = (QueryTreeRecord)(children.nextElement());
							if (r != null) {
								setCurrentRemoteQuerySelection(r.getUniqueKeys(),r.getUniqueKey(),r.getAllAttributesReturnedInIdentifier());
								ApplicationEventDispatcher.getApplicationEventDispatcher().processEvent(new StatusChangeEvent("Retrieving "+currentRemoteQuerySelectionLevel+" "+currentRemoteQuerySelectionUniqueKey.getSingleStringValueOrEmptyString()+" from "+localName));
								logger.sendLn("Retrieving "+currentRemoteQuerySelectionLevel+" "+currentRemoteQuerySelectionUniqueKey.getSingleStringValueOrEmptyString()+" from "+localName+" ("+currentRemoteQuerySelectionRetrieveAE+")");
								performRetrieve(currentRemoteQuerySelectionUniqueKeys,currentRemoteQuerySelectionLevel,currentRemoteQuerySelectionRetrieveAE);
								SafeProgressBarUpdaterThread.updateProgressBar(progressBarUpdater,++doneCount);
								//System.err.println("DownloadOrTransmit.RetrieveWorker.run(): doneCount = "+doneCount);
							}
						}
						SafeProgressBarUpdaterThread.endProgressBar(progressBarUpdater);
					}
					ApplicationEventDispatcher.getApplicationEventDispatcher().processEvent(new StatusChangeEvent("Done sending retrieval request"));
					setCurrentRemoteQuerySelection(null,null,null);
				}
			}
			else {
				ApplicationEventDispatcher.getApplicationEventDispatcher().processEvent(new StatusChangeEvent("Retrieving "+currentRemoteQuerySelectionLevel+" "+currentRemoteQuerySelectionUniqueKey.getSingleStringValueOrEmptyString()+" from "+localName));
				logger.sendLn("Request retrieval of "+currentRemoteQuerySelectionLevel+" "+currentRemoteQuerySelectionUniqueKey.getSingleStringValueOrEmptyString()+" from "+localName+" ("+currentRemoteQuerySelectionRetrieveAE+")");
				SafeProgressBarUpdaterThread.startProgressBar(progressBarUpdater,1);
				performRetrieve(currentRemoteQuerySelectionUniqueKeys,currentRemoteQuerySelectionLevel,currentRemoteQuerySelectionRetrieveAE);
				ApplicationEventDispatcher.getApplicationEventDispatcher().processEvent(new StatusChangeEvent("Done sending retrieval request"));
				SafeProgressBarUpdaterThread.endProgressBar(progressBarUpdater);
			}
			cursorChanger.restoreCursor();
		}
	}

	protected class RetrieveActionListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			activeThread = new Thread(new RetrieveWorker());
			activeThread.start();
		}
	}

	protected class LogActionListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (logger instanceof DialogMessageLogger) {
				((DialogMessageLogger)logger).setVisible(true);
			}
		}
	}

	protected class ConfigureActionListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				storageSOPClassSCPDispatcher.shutdown();
				new NetworkApplicationConfigurationDialog(DicomQR.this.getContentPane(),networkApplicationInformation,networkApplicationProperties);
				networkApplicationProperties.getProperties(getProperties());
				storeProperties("Edited and saved from user interface");
				//getProperties().store(System.err,"Bla");
				activateStorageSCP();
			} catch (Exception e) {
				e.printStackTrace(System.err);
			}
		}
	}

	Thread activeThread;

	// Based on Apple's MyApp.java example supplied with OSXAdapter ...
	// Generic registration with the Mac OS X application menu
	// Checks the platform, then attempts to register with the Apple EAWT
	// See OSXAdapter.java to see how this is done without directly referencing any Apple APIs
	//public void registerForMacOSXEvents() {
	//	if (System.getProperty("os.name").toLowerCase(java.util.Locale.US).startsWith("mac os x")) {
	//System.err.println("DicomImageViewer.registerForMacOSXEvents(): on MacOSX");
	//		try {
	//			// Generate and register the OSXAdapter, passing it a hash of all the methods we wish to
	//			// use as delegates for various com.apple.eawt.ApplicationListener methods
	//			OSXAdapter.setQuitHandler(this, getClass().getDeclaredMethod("quit", (Class[])null));		// need this, else won't quite from X or Cmd-Q any more, once any events registered
	//			//OSXAdapter.setAboutHandler(this, getClass().getDeclaredMethod("about", (Class[])null));
	//			//OSXAdapter.setPreferencesHandler(this, getClass().getDeclaredMethod("preferences", (Class[])null));
	//			OSXAdapter.setFileHandler(this, getClass().getDeclaredMethod("osxFileHandler", new Class[] { String.class }));
	//		} catch (NoSuchMethodException e) {
	//			// trap it, since we don't want to fail just because we cannot register events
	//			e.printStackTrace();
	//		}
	//	}
	//}

	public DicomQR(String title) throws DicomException, IOException {
		super(title,propertiesFileName);
		activateTemporaryDatabases();
		savedImagesFolder = new File(System.getProperty("java.io.tmpdir"));

		try {
			networkApplicationProperties = new NetworkApplicationProperties(getProperties(),true/*addPublicStorageSCPsIfNoRemoteAEsConfigured*/);
		}
		catch (Exception e) {
			networkApplicationProperties = null;
		}
		{
			NetworkApplicationInformationFederated federatedNetworkApplicationInformation = new NetworkApplicationInformationFederated();
			federatedNetworkApplicationInformation.startupAllKnownSourcesAndRegister(networkApplicationProperties);
			networkApplicationInformation = federatedNetworkApplicationInformation;
			System.err.print("networkApplicationInformation ...\n"+networkApplicationInformation);
		}
		activateStorageSCP();

		logger = new DialogMessageLogger(loggerTitleMessage,loggertDialogWidthWanted,loggerDialogHeightWanted,false/*exitApplicationOnClose*/,false/*visible*/);

		cursorChanger = new SafeCursorChanger(this);

		// ShutdownHook will run regardless of whether Command-Q (on Mac) or window closed ...
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				//System.err.println("DownloadOrTransmit.ShutdownHook.run()");
				if (networkApplicationInformation != null && networkApplicationInformation instanceof NetworkApplicationInformationFederated) {
					((NetworkApplicationInformationFederated)networkApplicationInformation).removeAllSources();
				}
				//System.err.print(TransferMonitor.report());
			}
		});

		//registerForMacOSXEvents();

		srcDatabasePanel = new JPanel();
		remoteQueryRetrievePanel = new JPanel();

		srcDatabasePanel.setLayout(new GridLayout(1,1));
		remoteQueryRetrievePanel.setLayout(new GridLayout(1,1));

		DatabaseTreeBrowser srcDatabaseTreeBrowser = new OurSourceDatabaseTreeBrowser(srcDatabase,srcDatabasePanel);

		Border panelBorder = BorderFactory.createEtchedBorder();

		JSplitPane remoteAndLocalBrowserPanes = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,remoteQueryRetrievePanel,srcDatabasePanel);
		remoteAndLocalBrowserPanes.setOneTouchExpandable(true);
		remoteAndLocalBrowserPanes.setResizeWeight(0.5);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.setBorder(panelBorder);

		JButton configureButton = new JButton(configureButtonLabel);
		configureButton.setToolTipText(configureButtonToolTipText);
		buttonPanel.add(configureButton);
		configureButton.addActionListener(new ConfigureActionListener());

		JButton logButton = new JButton(logButtonLabel);
		logButton.setToolTipText(logButtonToolTipText);
		buttonPanel.add(logButton);
		logButton.addActionListener(new LogActionListener());

		JButton queryButton = new JButton(queryButtonLabel);
		queryButton.setToolTipText(queryButtonToolTipText);
		buttonPanel.add(queryButton);
		queryButton.addActionListener(new QueryActionListener());

		JButton retrieveButton = new JButton(retrieveButtonLabel);
		retrieveButton.setToolTipText(retrieveButtonToolTipText);
		buttonPanel.add(retrieveButton);
		retrieveButton.addActionListener(new RetrieveActionListener());


		JButton viewButton = new JButton(viewButtonLabel);
		viewButton.setToolTipText(viewButtonToolTipText);
		buttonPanel.add(viewButton);
		viewButton.addActionListener(new ViewActionListener());

		JButton exportButton = new JButton(exportButtonLabel);
		exportButton.setToolTipText(exportButtonToolTipText);
		buttonPanel.add(exportButton);
		exportButton.addActionListener(new ExportActionListener());

	
		JButton purgeButton = new JButton(purgeButtonLabel);
		purgeButton.setToolTipText(purgeButtonToolTipText);
		buttonPanel.add(purgeButton);
		purgeButton.addActionListener(new PurgeActionListener());

		JPanel queryFilterTextEntryPanel = new JPanel();
		queryFilterTextEntryPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		queryFilterTextEntryPanel.setBorder(panelBorder);

		JLabel queryIntroduction = new JLabel(queryIntroductionLabelText);
		queryFilterTextEntryPanel.add(queryIntroduction);

		JLabel queryFilterPatientNameLabel = new JLabel(queryPatientNameLabelText);
		queryFilterPatientNameLabel.setToolTipText(queryPatientNameToolTipText);
		queryFilterTextEntryPanel.add(queryFilterPatientNameLabel);
		queryFilterPatientNameTextField = new JTextField("",textFieldLengthForQueryPatientName);
		queryFilterTextEntryPanel.add(queryFilterPatientNameTextField);

		JLabel queryFilterPatientIDLabel = new JLabel(queryPatientIDLabelText);
		queryFilterPatientIDLabel.setToolTipText(queryPatientIDToolTipText);
		queryFilterTextEntryPanel.add(queryFilterPatientIDLabel);
		queryFilterPatientIDTextField = new JTextField("",textFieldLengthForQueryPatientID);
		queryFilterTextEntryPanel.add(queryFilterPatientIDTextField);

		JLabel queryFilterStudyDateLabel = new JLabel(queryStudyDateLabelText);
		queryFilterStudyDateLabel.setToolTipText(queryStudyDateToolTipText);
		queryFilterTextEntryPanel.add(queryFilterStudyDateLabel);
		queryFilterStudyDateTextField = new JTextField("",textFieldLengthForQueryStudyDate);
		queryFilterTextEntryPanel.add(queryFilterStudyDateTextField);

		JPanel checkBoxPanel = new JPanel();
		checkBoxPanel.setLayout(new GridLayout(2,0));	// only one dimension has any effect
		checkBoxPanel.setBorder(panelBorder);

		showDetailedLogCheckBox = new JCheckBox(showDetailedLogLabelText);
		showDetailedLogCheckBox.setSelected(false);
		checkBoxPanel.add(showDetailedLogCheckBox);

		zipExportCheckBox = new JCheckBox(zipExportLabelText);
		zipExportCheckBox.setSelected(false);
		checkBoxPanel.add(zipExportCheckBox);

		hierarchicalExportCheckBox = new JCheckBox(hierarchicalExportLabelText);
		hierarchicalExportCheckBox.setSelected(false);
		hierarchicalExportCheckBox.setToolTipText(hierarchicalExportToolTipText);
		checkBoxPanel.add(hierarchicalExportCheckBox);

		addDicomDirectoryCheckBox = new JCheckBox(addDicomDirectoryLabelText);
		addDicomDirectoryCheckBox.setSelected(true);
		addDicomDirectoryCheckBox.setToolTipText(addDicomDirectoryToolTipText);
		checkBoxPanel.add(addDicomDirectoryCheckBox);

		JPanel statusBarPanel = new JPanel();
		{
			GridBagLayout statusBarPanelLayout = new GridBagLayout();
			statusBarPanel.setLayout(statusBarPanelLayout);
			{
				JLabel statusBar = getStatusBar();
				GridBagConstraints statusBarConstraints = new GridBagConstraints();
				statusBarConstraints.weightx = 1;
				statusBarConstraints.fill = GridBagConstraints.BOTH;
				statusBarConstraints.anchor = GridBagConstraints.WEST;
				statusBarConstraints.gridwidth = GridBagConstraints.RELATIVE;
				statusBarPanelLayout.setConstraints(statusBar,statusBarConstraints);
				statusBarPanel.add(statusBar);
			}
			{
				JProgressBar progressBar = new JProgressBar();
				progressBar.setStringPainted(false);
				GridBagConstraints progressBarConstraints = new GridBagConstraints();
				progressBarConstraints.weightx = 0.5;
				progressBarConstraints.fill = GridBagConstraints.BOTH;
				progressBarConstraints.anchor = GridBagConstraints.EAST;
				progressBarConstraints.gridwidth = GridBagConstraints.REMAINDER;
				statusBarPanelLayout.setConstraints(progressBar,progressBarConstraints);
				statusBarPanel.add(progressBar);

				progressBarUpdater = new SafeProgressBarUpdaterThread(progressBar);
			}
		}

		JPanel mainPanel = new JPanel();
		{
			GridBagLayout mainPanelLayout = new GridBagLayout();
			mainPanel.setLayout(mainPanelLayout);
			{
				GridBagConstraints remoteAndLocalBrowserPanesConstraints = new GridBagConstraints();
				remoteAndLocalBrowserPanesConstraints.gridx = 0;
				remoteAndLocalBrowserPanesConstraints.gridy = 0;
				remoteAndLocalBrowserPanesConstraints.weightx = 1;
				remoteAndLocalBrowserPanesConstraints.weighty = 1;
				remoteAndLocalBrowserPanesConstraints.fill = GridBagConstraints.BOTH;
				mainPanelLayout.setConstraints(remoteAndLocalBrowserPanes,remoteAndLocalBrowserPanesConstraints);
				mainPanel.add(remoteAndLocalBrowserPanes);
			}
			{
				GridBagConstraints buttonPanelConstraints = new GridBagConstraints();
				buttonPanelConstraints.gridx = 0;
				buttonPanelConstraints.gridy = 1;
				buttonPanelConstraints.fill = GridBagConstraints.HORIZONTAL;
				mainPanelLayout.setConstraints(buttonPanel,buttonPanelConstraints);
				mainPanel.add(buttonPanel);
			}
			{
				GridBagConstraints queryFilterTextEntryPanelConstraints = new GridBagConstraints();
				queryFilterTextEntryPanelConstraints.gridx = 0;
				queryFilterTextEntryPanelConstraints.gridy = 2;
				queryFilterTextEntryPanelConstraints.fill = GridBagConstraints.HORIZONTAL;
				mainPanelLayout.setConstraints(queryFilterTextEntryPanel,queryFilterTextEntryPanelConstraints);
				mainPanel.add(queryFilterTextEntryPanel);
			}
			{
				GridBagConstraints checkBoxPanelConstraints = new GridBagConstraints();
				checkBoxPanelConstraints.gridx = 0;
				checkBoxPanelConstraints.gridy = 3;
				checkBoxPanelConstraints.fill = GridBagConstraints.HORIZONTAL;
				mainPanelLayout.setConstraints(checkBoxPanel,checkBoxPanelConstraints);
				mainPanel.add(checkBoxPanel);
			}
			{
				GridBagConstraints statusBarPanelConstraints = new GridBagConstraints();
				statusBarPanelConstraints.gridx = 0;
				statusBarPanelConstraints.gridy = 4;
				statusBarPanelConstraints.fill = GridBagConstraints.HORIZONTAL;
				mainPanelLayout.setConstraints(statusBarPanel,statusBarPanelConstraints);
				mainPanel.add(statusBarPanel);
			}
		}
		Container content = getContentPane();
		content.add(mainPanel);
		pack();
		setVisible(true);
	}


	public void query(){

		Properties properties = getProperties();
		String ae = properties.getProperty(propertyName_DicomCurrentlySelectedQueryTargetAE);
		ae=getFirstNetworkTargetByLocalApplicationEntityName();
		
		remoteQueryRetrievePanel.removeAll();
		if (ae != null) {
			setCurrentRemoteQueryInformationModel(ae);
			if (currentRemoteQueryInformationModel == null) {
				ApplicationEventDispatcher.getApplicationEventDispatcher().processEvent(new StatusChangeEvent("Cannot query "+ae));
			}
			else {
				try {
					SpecificCharacterSet specificCharacterSet = new SpecificCharacterSet((String[])null);
					AttributeList filter = new AttributeList();
					{
						AttributeTag t = TagFromName.PatientName; Attribute a = new PersonNameAttribute(t,specificCharacterSet);
						String patientName = queryFilterPatientNameTextField.getText().trim();
						if (patientName != null && patientName.length() > 0) {
							a.addValue(patientName);
						}
						filter.put(t,a);
					}
					{
						AttributeTag t = TagFromName.PatientID; Attribute a = new ShortStringAttribute(t,specificCharacterSet);
						String patientID = queryFilterPatientIDTextField.getText().trim();
						if (patientID != null && patientID.length() > 0) {
							a.addValue(patientID);
						}
						filter.put(t,a);
					}
					{ AttributeTag t = TagFromName.PatientBirthDate; Attribute a = new DateAttribute(t); filter.put(t,a); }
					{ AttributeTag t = TagFromName.PatientSex; Attribute a = new CodeStringAttribute(t); filter.put(t,a); }

					{ AttributeTag t = TagFromName.StudyID; Attribute a = new ShortStringAttribute(t,specificCharacterSet); filter.put(t,a); }
					{ AttributeTag t = TagFromName.StudyDescription; Attribute a = new LongStringAttribute(t,specificCharacterSet); filter.put(t,a); }
					{ AttributeTag t = TagFromName.ModalitiesInStudy; Attribute a = new CodeStringAttribute(t); filter.put(t,a); }
					{
						AttributeTag t = TagFromName.StudyDate; Attribute a = new DateAttribute(t);
						String studyDate = queryFilterStudyDateTextField.getText().trim();
						if (studyDate != null && studyDate.length() > 0) {
							a.addValue(studyDate);
						}
						filter.put(t,a);
					}
					{ AttributeTag t = TagFromName.StudyTime; Attribute a = new TimeAttribute(t); filter.put(t,a); }
					{ AttributeTag t = TagFromName.PatientAge; Attribute a = new AgeStringAttribute(t); filter.put(t,a); }

					{ AttributeTag t = TagFromName.SeriesDescription; Attribute a = new LongStringAttribute(t,specificCharacterSet); filter.put(t,a); }
					{ AttributeTag t = TagFromName.SeriesNumber; Attribute a = new IntegerStringAttribute(t); filter.put(t,a); }
					{ AttributeTag t = TagFromName.Manufacturer; Attribute a = new LongStringAttribute(t); filter.put(t,a); }
					{ AttributeTag t = TagFromName.Modality; Attribute a = new CodeStringAttribute(t); filter.put(t,a); }
					{ AttributeTag t = TagFromName.SeriesDate; Attribute a = new DateAttribute(t); filter.put(t,a); }
					{ AttributeTag t = TagFromName.SeriesTime; Attribute a = new TimeAttribute(t); filter.put(t,a); }

					{ AttributeTag t = TagFromName.InstanceNumber; Attribute a = new IntegerStringAttribute(t); filter.put(t,a); }
					{ AttributeTag t = TagFromName.ContentDate; Attribute a = new DateAttribute(t); filter.put(t,a); }
					{ AttributeTag t = TagFromName.ContentTime; Attribute a = new TimeAttribute(t); filter.put(t,a); }
					{ AttributeTag t = TagFromName.ImageType; Attribute a = new CodeStringAttribute(t); filter.put(t,a); }
					{ AttributeTag t = TagFromName.NumberOfFrames; Attribute a = new IntegerStringAttribute(t); filter.put(t,a); }
					{ AttributeTag t = TagFromName.WindowCenter; Attribute a = new DecimalStringAttribute(t); filter.put(t,a); }
					{ AttributeTag t = TagFromName.WindowWidth; Attribute a = new DecimalStringAttribute(t); filter.put(t,a); }

					{ AttributeTag t = TagFromName.StudyInstanceUID; Attribute a = new UniqueIdentifierAttribute(t); filter.put(t,a); }
					{ AttributeTag t = TagFromName.SeriesInstanceUID; Attribute a = new UniqueIdentifierAttribute(t); filter.put(t,a); }
					{ AttributeTag t = TagFromName.SOPInstanceUID; Attribute a = new UniqueIdentifierAttribute(t); filter.put(t,a); }
					{ AttributeTag t = TagFromName.SOPClassUID; Attribute a = new UniqueIdentifierAttribute(t); filter.put(t,a); }
					{ AttributeTag t = TagFromName.SpecificCharacterSet; Attribute a = new CodeStringAttribute(t); filter.put(t,a); a.addValue("ISO_IR 100"); }

					activeThread = new Thread(new QueryWorker(filter));
					activeThread.start();
				}
				catch (Exception e) {
					e.printStackTrace(System.err);
					ApplicationEventDispatcher.getApplicationEventDispatcher().processEvent(new StatusChangeEvent("Query to "+ae+" failed"));
				}
			}
		}
		remoteQueryRetrievePanel.validate();
	}



	

	/**
	 * <p>The method to invoke the application.</p>
	 *
	 * @param	arg	none
	 */
	public static void main(String arg[]) {
		try {
			DicomQR qr=new DicomQR("Remote PACS Query/Retrieve");
			qr.query();
		}
		catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}
}
