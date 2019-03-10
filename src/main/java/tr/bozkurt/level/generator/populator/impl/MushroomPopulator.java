package tr.bozkurt.level.generator.populator.impl;

import tr.bozkurt.block.Block;
import tr.bozkurt.level.ChunkManager;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.level.generator.object.mushroom.BigMushroom;
import tr.bozkurt.level.generator.populator.type.PopulatorCount;
import tr.bozkurt.math.BozkurtRandom;
import tr.bozkurt.math.Vector3;

/**
 * @author DaPorkchop_
 */
public class MushroomPopulator extends PopulatorCount{

	private final int type;

	public MushroomPopulator(){
		this(-1);
	}

	public MushroomPopulator(int type){
		this.type = type;
	}

	@Override
	public void populateCount(ChunkManager level, int chunkX, int chunkZ, BozkurtRandom random, FullChunk chunk){
		int x = (chunkX << 4) | random.nextBoundedInt(16);
		int z = (chunkZ << 4) | random.nextBoundedInt(16);
		int y = this.getHighestWorkableBlock(level, x, z, chunk);
		if(y != -1){
			new BigMushroom(type).generate(level, random, new Vector3(x, y, z));
		}
	}

	@Override
	protected int getHighestWorkableBlock(ChunkManager level, int x, int z, FullChunk chunk){
		int y;
		x &= 0xF;
		z &= 0xF;
		for(y = 254; y > 0; --y){
			int b = chunk.getBlockId(x, y, z);
			if(b == Block.DIRT || b == Block.GRASS){
				break;
			}else if(b != Block.AIR && b != Block.SNOW_LAYER){
				return -1;
			}
		}

		return ++y;
	}

}