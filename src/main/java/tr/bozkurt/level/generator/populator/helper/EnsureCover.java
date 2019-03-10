package tr.bozkurt.level.generator.populator.helper;

import tr.bozkurt.level.format.FullChunk;

import static tr.bozkurt.block.BlockID.AIR;
import static tr.bozkurt.block.BlockID.SNOW_LAYER;

/**
 * @author DaPorkchop_
 */
public interface EnsureCover{

	static boolean ensureCover(int x, int y, int z, FullChunk chunk){
		int id = chunk.getBlockId(x, y, z);
		return id == AIR || id == SNOW_LAYER;
	}

}
