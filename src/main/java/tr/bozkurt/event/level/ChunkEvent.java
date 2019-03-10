package tr.bozkurt.event.level;

import tr.bozkurt.level.format.FullChunk;

/**
 * Bozkurt Project
 */
public abstract class ChunkEvent extends LevelEvent{

	private final FullChunk chunk;

	public ChunkEvent(FullChunk chunk){
		super(chunk.getProvider().getLevel());
		this.chunk = chunk;
	}

	public FullChunk getChunk(){
		return chunk;
	}

}
