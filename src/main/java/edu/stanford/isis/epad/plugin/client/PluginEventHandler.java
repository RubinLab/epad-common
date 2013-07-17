package edu.stanford.isis.epad.plugin.client;

/**
 * PluginEventHandler
 * 
 * @author amsnyder
 */
public interface PluginEventHandler
{
	void onPluginEvent(EPadPluginEvent<?> event);
}
