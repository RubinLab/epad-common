package edu.stanford.epad.common.util;

public class EventMessageCodes {

	public static final String STUDY_PROCESSED = "Study Processing Complete";
	public static final String IMAGE_PROCESSED = "Image Generation Complete";
	
	public static final String STUDY_NOT_DELETED = "Study Not Deleted From System";
	
	public static final String UPLOAD_TYPE_ERROR = "No Dicom Files in Upload Directory";
	public static final String UPLOAD_ERROR = "Error Processing Uploaded File";
	public static final String DCM4CHEE_ERROR = "Error Sending Files To DCM4CHEE";
	public static final String INVALID_PATIENT_ID_IN_UPLOAD  = "Invalid Patient ID in Upload";
	public static final String DSO_GEN_ERROR = "Error Generating DSO Annotation";
	public static final String DSO_DELETE_ERROR = "Error Deleting DSO";
	
	public static final String REMOTE_PAC_TRANSFER_STARTED = "Remote PAC Transfer Started";
	public static final String REMOTE_PAC_TRANSFER_COMPLETE = "Remote PAC Transfer Complete";
	
	public static final String SOFTWARE_UPGRADE_AVAILABLE = "Software Upgrade Available";
	public static final String SOFTWARE_UPDATED = "ePAD Software Updated. Please Restart System.";
	public static final String SERVER_DISK_SPACE = "Server Low On Disk Space";
	
	public static final String PLUGIN_STARTED = "Plugin Started";
	public static final String PLUGIN_COMPLETED = "Plugin Completed";
	public static final String PLUGIN_FAILED = "Plugin Failed";

}
