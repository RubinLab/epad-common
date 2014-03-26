package edu.stanford.epad.common.plugins;


/**
 * This is the interface to the ePAD plugin
 */
public interface EPadPlugin
{
	/**
	 * Returns the version string for the ePadPlugin Implementation.
	 * 
	 * @return ePadPlugin
	 */
	String getPluginImplVersion();

	String PLUGIN_INTERFACE_VERSION = "2013-11 23:00"; // TODO: set at compile time
}
