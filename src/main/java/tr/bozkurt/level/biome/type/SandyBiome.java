package tr.bozkurt.level.biome.type;

import tr.bozkurt.block.Block;

/**
 * Bozkurt Project
 */
public abstract class SandyBiome extends CoveredBiome{

	@Override
	public int getSurfaceDepth(int y){
		return 3;
	}

	@Override
	public int getSurfaceBlock(int y){
		return Block.SAND;
	}

	@Override
	public int getGroundDepth(int y){
		return 2;
	}

	@Override
	public int getGroundBlock(int y){
		return Block.SANDSTONE;
	}

}
