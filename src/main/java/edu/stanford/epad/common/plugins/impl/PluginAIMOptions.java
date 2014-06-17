package edu.stanford.epad.common.plugins.impl;

import edu.stanford.hakan.aim3api.base.ImageAnnotation;

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
}
