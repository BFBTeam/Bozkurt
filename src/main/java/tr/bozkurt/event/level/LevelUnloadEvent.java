package tr.bozkurt.event.level;

import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;
import tr.bozkurt.level.Level;

/**
 * Bozkurt Project
 */
public class LevelUnloadEvent extends LevelEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();

	public LevelUnloadEvent(Level level){
		super(level);
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

}
