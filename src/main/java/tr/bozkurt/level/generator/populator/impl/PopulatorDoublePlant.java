package tr.bozkurt.level.generator.populator.impl;

import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.level.generator.populator.helper.EnsureCover;
import tr.bozkurt.level.generator.populator.helper.EnsureGrassBelow;
import tr.bozkurt.level.generator.populator.type.PopulatorSurfaceBlock;
import tr.bozkurt.math.BozkurtRandom;

/**
 * author: DaPorkchop_
 * Bozkurt Project
 */
public class PopulatorDoublePlant extends PopulatorSurfaceBlock{

	private int type;

	public PopulatorDoublePlant(int type){
		this.type = type;
	}

	@Override
	protected boolean canStay(int x, int y, int z, FullChunk chunk){
		return EnsureCover.ensureCover(x, y, z, chunk) && EnsureCover.ensureCover(x, y + 1, z, chunk) && EnsureGrassBelow.ensureGrassBelow(x, y, z, chunk);
	}

	@Override
	protected int getBlockId(int x, int z, BozkurtRandom random, FullChunk chunk){
		return (DOUBLE_PLANT << 4) | type;
	}

	@Override
	protected void placeBlock(int x, int y, int z, int id, FullChunk chunk, BozkurtRandom random){
		super.placeBlock(x, y, z, id, chunk, random);
		chunk.setFullBlockId(x, y + 1, z, 8 | id);
	}

}
