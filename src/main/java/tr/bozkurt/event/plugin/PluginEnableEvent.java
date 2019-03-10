package tr.bozkurt.event.plugin;

import tr.bozkurt.plugin.Plugin;

/**
 * Bozkurt Project
 */
public class PluginEnableEvent extends PluginEvent{

	public PluginEnableEvent(Plugin plugin){
		super(plugin);
	}

}
