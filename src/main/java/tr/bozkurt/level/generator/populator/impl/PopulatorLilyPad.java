package tr.bozkurt.level.generator.populator.impl;

import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.level.generator.populator.helper.EnsureBelow;
import tr.bozkurt.level.generator.populator.helper.EnsureCover;
import tr.bozkurt.level.generator.populator.type.PopulatorSurfaceBlock;
import tr.bozkurt.math.BozkurtRandom;

/**
 * @author DaPorkchop_
 */
public class PopulatorLilyPad extends PopulatorSurfaceBlock{

	@Override
	protected boolean canStay(int x, int y, int z, FullChunk chunk){
		return EnsureCover.ensureCover(x, y, z, chunk) && EnsureBelow.ensureBelow(x, y, z, STILL_WATER, chunk);
	}

	@Override
	protected int getBlockId(int x, int z, BozkurtRandom random, FullChunk chunk){
		return (WATER_LILY << 4) | 1;
	}

}
