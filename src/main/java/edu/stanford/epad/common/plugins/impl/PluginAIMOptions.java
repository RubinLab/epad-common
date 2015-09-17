package edu.stanford.epad.common.plugins.impl;

import java.util.List;

import org.apache.commons.logging.Log;

import edu.stanford.epad.common.util.EPADLogger;
import edu.stanford.hakan.aim3api.base.ImageAnnotation;
import edu.stanford.hakan.aim4api.base.ImageAnnotationCollection;
import edu.stanford.hakan.aim4api.plugin.PluginParameter;
import edu.stanford.hakan.aim4api.plugin.v4.PluginV4;

public class PluginAIMOptions
{
	public final String pluginName, aimUID, aimName, patientID, patientName, templateID, templateName, sessionID;
	

	public PluginAIMOptions(String pluginName, String aimUID, String aimName, String patientID, String patientName,
			String templateID, String templateName, String sessionID)
	{
		this.pluginName = pluginName;
		this.aimUID = aimUID;
		this.aimName = aimName;
		this.patientID = patientID;
		this.patientName = patientName;
		this.templateID = templateID;
		this.templateName = templateName;
		this.sessionID = sessionID;
	}

	public PluginAIMOptions(String pluginName, String sessionID, ImageAnnotation imageAnnotation)
	{
		this.pluginName = pluginName;
		this.aimUID = imageAnnotation.getUniqueIdentifier();
		this.aimName = imageAnnotation.getName();
		this.patientID = imageAnnotation.getListPerson().get(0).getId();
		this.patientName = imageAnnotation.getListPerson().get(0).getName();
		this.templateID = imageAnnotation.getCodeValue();
		this.templateName = imageAnnotation.getCodeMeaning();
		this.sessionID = sessionID;
	}
	
	public PluginAIMOptions(String pluginName, String sessionID, ImageAnnotationCollection imageAnnotationCollection)
	{
		edu.stanford.hakan.aim4api.base.ImageAnnotation imageAnnotationV4 = imageAnnotationCollection.getImageAnnotations().get(0);
		this.pluginName = pluginName;
		this.aimUID = imageAnnotationCollection.getUniqueIdentifier().getRoot();
		this.aimName = imageAnnotationV4.getName().getValue();
		this.patientID = imageAnnotationCollection.getPerson().getId().getValue();
		this.patientName = imageAnnotationCollection.getPerson().getName().getValue();
		this.templateID = imageAnnotationV4.getListTypeCode().get(0).getCode();
		this.templateName = imageAnnotationV4.getListTypeCode().get(0).getCodeSystem();
		this.sessionID = sessionID;
		
		
	}	
	
}
