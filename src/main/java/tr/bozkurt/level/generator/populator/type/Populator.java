package tr.bozkurt.level.generator.populator.type;

import tr.bozkurt.block.BlockID;
import tr.bozkurt.level.ChunkManager;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.math.BozkurtRandom;

/**
 * Bozkurt Project
 */
public abstract class Populator implements BlockID{

	public abstract void populate(ChunkManager level, int chunkX, int chunkZ, BozkurtRandom random, FullChunk chunk);

	protected int getHighestWorkableBlock(ChunkManager level, int x, int z, FullChunk chunk){
		return chunk.getHighestBlockAt(x & 0xF, z & 0xF);
	}

}
