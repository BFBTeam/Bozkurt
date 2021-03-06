package tr.bozkurt.level.generator.populator.impl;

import tr.bozkurt.block.Block;
import tr.bozkurt.block.BlockSapling;
import tr.bozkurt.level.ChunkManager;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.level.generator.object.tree.ObjectTree;
import tr.bozkurt.level.generator.populator.type.PopulatorCount;
import tr.bozkurt.math.BozkurtMath;
import tr.bozkurt.math.BozkurtRandom;

/**
 * author: DaPorkchop_
 * Bozkurt Project
 */
public class PopulatorTree extends PopulatorCount{

	private final int type;
	private ChunkManager level;

	public PopulatorTree(){
		this(BlockSapling.OAK);
	}

	public PopulatorTree(int type){
		this.type = type;
	}

	@Override
	public void populateCount(ChunkManager level, int chunkX, int chunkZ, BozkurtRandom random, FullChunk chunk){
		this.level = level;
		int x = BozkurtMath.randomRange(random, chunkX << 4, (chunkX << 4) + 15);
		int z = BozkurtMath.randomRange(random, chunkZ << 4, (chunkZ << 4) + 15);
		int y = this.getHighestWorkableBlock(x, z);
		if(y < 3){
			return;
		}
		ObjectTree.growTree(this.level, x, y, z, random, this.type);
	}

	private int getHighestWorkableBlock(int x, int z){
		int y;
		for(y = 254; y > 0; --y){
			int b = this.level.getBlockIdAt(x, y, z);
			if(b == Block.DIRT || b == Block.GRASS){
				break;
			}else if(b != Block.AIR && b != Block.SNOW_LAYER){
				return -1;
			}
		}

		return ++y;
	}

}
