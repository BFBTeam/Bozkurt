package tr.bozkurt.event.level;

import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;
import tr.bozkurt.level.format.FullChunk;

/**
 * Bozkurt Project
 */
public class ChunkUnloadEvent extends ChunkEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();

	public ChunkUnloadEvent(FullChunk chunk){
		super(chunk);
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

}