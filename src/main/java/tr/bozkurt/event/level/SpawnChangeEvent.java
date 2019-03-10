package tr.bozkurt.event.level;

import tr.bozkurt.event.HandlerList;
import tr.bozkurt.level.Level;
import tr.bozkurt.level.Position;

/**
 * Bozkurt Project
 */
public class SpawnChangeEvent extends LevelEvent{

	private static final HandlerList handlers = new HandlerList();
	private final Position previousSpawn;

	public SpawnChangeEvent(Level level, Position previousSpawn){
		super(level);
		this.previousSpawn = previousSpawn;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public Position getPreviousSpawn(){
		return previousSpawn;
	}

}
