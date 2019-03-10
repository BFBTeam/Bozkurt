package tr.bozkurt.event.level;

import tr.bozkurt.event.HandlerList;
import tr.bozkurt.level.format.FullChunk;

/**
 * Bozkurt Project
 */
public class ChunkLoadEvent extends ChunkEvent{

	private static final HandlerList handlers = new HandlerList();
	private final boolean newChunk;

	public ChunkLoadEvent(FullChunk chunk, boolean newChunk){
		super(chunk);
		this.newChunk = newChunk;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public boolean isNewChunk(){
		return newChunk;
	}

}