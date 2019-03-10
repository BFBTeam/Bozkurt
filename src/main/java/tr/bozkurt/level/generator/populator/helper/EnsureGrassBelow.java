package tr.bozkurt.level.generator.populator.helper;

import tr.bozkurt.level.format.FullChunk;

import static tr.bozkurt.block.BlockID.GRASS;

/**
 * @author DaPorkchop_
 */
public interface EnsureGrassBelow{

	static boolean ensureGrassBelow(int x, int y, int z, FullChunk chunk){
		return EnsureBelow.ensureBelow(x, y, z, GRASS, chunk);
	}

}
