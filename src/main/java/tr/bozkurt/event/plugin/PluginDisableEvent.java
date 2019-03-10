package tr.bozkurt.event.plugin;

import tr.bozkurt.plugin.Plugin;

/**
 * Bozkurt Project
 */
public class PluginDisableEvent extends PluginEvent{

	public PluginDisableEvent(Plugin plugin){
		super(plugin);
	}

}
