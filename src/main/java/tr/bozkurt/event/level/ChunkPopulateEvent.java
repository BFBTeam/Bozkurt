package tr.bozkurt.event.level;

import tr.bozkurt.event.HandlerList;
import tr.bozkurt.level.format.FullChunk;

/**
 * Bozkurt Project
 */
public class ChunkPopulateEvent extends ChunkEvent{

	private static final HandlerList handlers = new HandlerList();

	public ChunkPopulateEvent(FullChunk chunk){
		super(chunk);
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

}