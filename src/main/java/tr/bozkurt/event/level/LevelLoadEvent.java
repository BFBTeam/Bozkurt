package tr.bozkurt.event.level;

import tr.bozkurt.event.HandlerList;
import tr.bozkurt.level.Level;

/**
 * Bozkurt Project
 */
public class LevelLoadEvent extends LevelEvent{

	private static final HandlerList handlers = new HandlerList();

	public LevelLoadEvent(Level level){
		super(level);
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

}
