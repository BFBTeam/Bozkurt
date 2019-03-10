package tr.bozkurt.level.generator.populator.impl;

import tr.bozkurt.block.Block;
import tr.bozkurt.level.Level;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.level.generator.populator.helper.EnsureBelow;
import tr.bozkurt.level.generator.populator.helper.EnsureCover;
import tr.bozkurt.level.generator.populator.helper.EnsureGrassBelow;
import tr.bozkurt.level.generator.populator.type.PopulatorSurfaceBlock;
import tr.bozkurt.math.BozkurtRandom;

/**
 * @author Niall Lindsay (Niall7459)
 * <p>
 * Bozkurt Project
 * </p>
 */
public class PopulatorSugarcane extends PopulatorSurfaceBlock{

	private boolean findWater(int x, int y, int z, Level level){
		int count = 0;
		for(int i = x - 4; i < (x + 4); i++){
			for(int j = z - 4; j < (z + 4); j++){
				int b = level.getBlockIdAt(i, y, j);
				if(b == Block.WATER || b == Block.STILL_WATER){
					count++;
				}
				if(count > 10){
					return true;
				}
			}
		}
		return (count > 10);
	}

	@Override
	protected boolean canStay(int x, int y, int z, FullChunk chunk){
		return EnsureCover.ensureCover(x, y, z, chunk) && (EnsureGrassBelow.ensureGrassBelow(x, y, z, chunk) || EnsureBelow.ensureBelow(x, y, z, SAND, chunk)) && findWater(x, y - 1, z, chunk.getProvider().getLevel());
	}

	@Override
	protected int getBlockId(int x, int z, BozkurtRandom random, FullChunk chunk){
		return (SUGARCANE_BLOCK << 4) | 1;
	}

}
