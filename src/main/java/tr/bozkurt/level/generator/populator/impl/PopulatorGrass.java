package tr.bozkurt.level.generator.populator.impl;

import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.level.generator.populator.helper.PopulatorHelpers;
import tr.bozkurt.level.generator.populator.type.PopulatorSurfaceBlock;
import tr.bozkurt.math.BozkurtRandom;

/**
 * author: DaPorkchop_
 * Bozkurt Project
 */
public class PopulatorGrass extends PopulatorSurfaceBlock{

	@Override
	protected boolean canStay(int x, int y, int z, FullChunk chunk){
		return PopulatorHelpers.canGrassStay(x, y, z, chunk);
	}

	@Override
	protected int getBlockId(int x, int z, BozkurtRandom random, FullChunk chunk){
		return TALL_GRASS << 4;
	}

}
