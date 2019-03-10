package tr.bozkurt.level.generator.populator.impl;

import tr.bozkurt.block.Block;
import tr.bozkurt.level.ChunkManager;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.level.generator.populator.helper.EnsureBelow;
import tr.bozkurt.level.generator.populator.helper.EnsureCover;
import tr.bozkurt.level.generator.populator.type.PopulatorSurfaceBlock;
import tr.bozkurt.math.BozkurtRandom;

/**
 * @author DaPorkchop_
 */
public class PopulatorGroundFire extends PopulatorSurfaceBlock{

	@Override
	protected boolean canStay(int x, int y, int z, FullChunk chunk){
		return EnsureCover.ensureCover(x, y, z, chunk) && EnsureBelow.ensureBelow(x, y, z, NETHERRACK, chunk);
	}

	@Override
	protected int getBlockId(int x, int z, BozkurtRandom random, FullChunk chunk){
		return FIRE << 4;
	}

	@Override
	protected void placeBlock(int x, int y, int z, int id, FullChunk chunk, BozkurtRandom random){
		super.placeBlock(x, y, z, id, chunk, random);
		chunk.setBlockLight(x, y, z, Block.light[FIRE]);
	}

	@Override
	protected int getHighestWorkableBlock(ChunkManager level, int x, int z, FullChunk chunk){
		int y;
		for(y = 0; y <= 127; ++y){
			int b = chunk.getBlockId(x, y, z);
			if(b == Block.AIR){
				break;
			}
		}
		return y == 0 ? -1 : y;
	}

}
