package tr.bozkurt.event.level;

import tr.bozkurt.event.HandlerList;
import tr.bozkurt.level.Level;

/**
 * Bozkurt Project
 */
public class LevelSaveEvent extends LevelEvent{

	private static final HandlerList handlers = new HandlerList();

	public LevelSaveEvent(Level level){
		super(level);
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

}
