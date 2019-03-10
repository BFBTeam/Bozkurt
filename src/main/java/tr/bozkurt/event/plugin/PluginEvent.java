package tr.bozkurt.event.plugin;

import tr.bozkurt.event.Event;
import tr.bozkurt.event.HandlerList;
import tr.bozkurt.plugin.Plugin;

/**
 * Bozkurt Project
 */
public class PluginEvent extends Event{

	private static final HandlerList handlers = new HandlerList();

	private final Plugin plugin;

	public PluginEvent(Plugin plugin){
		this.plugin = plugin;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public Plugin getPlugin(){
		return plugin;
	}

}
