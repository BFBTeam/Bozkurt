package tr.bozkurt.event.level;

import tr.bozkurt.event.Event;
import tr.bozkurt.level.Level;

/**
 * Bozkurt Project
 */
public abstract class LevelEvent extends Event{

	private final Level level;

	public LevelEvent(Level level){
		this.level = level;
	}

	public Level getLevel(){
		return level;
	}

}
