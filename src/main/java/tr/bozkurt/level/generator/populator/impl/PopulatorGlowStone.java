package tr.bozkurt.level.generator.populator.impl;

import tr.bozkurt.block.Block;
import tr.bozkurt.level.ChunkManager;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.level.generator.populator.type.Populator;
import tr.bozkurt.math.BozkurtMath;
import tr.bozkurt.math.BozkurtRandom;

public class PopulatorGlowStone extends Populator{

	@Override
	public void populate(ChunkManager level, int chunkX, int chunkZ, BozkurtRandom random, FullChunk chunk){
		int x = BozkurtMath.randomRange(random, chunkX << 4, (chunkX << 4) + 15);
		int z = BozkurtMath.randomRange(random, chunkZ << 4, (chunkZ << 4) + 15);
		int y = this.getHighestWorkableBlock(chunk, x & 0xF, z & 0xF);
		if(y != -1 && level.getBlockIdAt(x, y, z) != NETHERRACK){
			int count = BozkurtMath.randomRange(random, 40, 60);
			for(int i = 0; i < count; i++){
				level.setBlockAt(x + (random.nextBoundedInt(7) - 3), y + (random.nextBoundedInt(9) - 4), z + (random.nextBoundedInt(7) - 3), GLOWSTONE);
			}
		}
	}

	private int getHighestWorkableBlock(FullChunk chunk, int x, int z){
		int y;
		//start scanning a bit lower down to allow space for placing on top
		for(y = 120; y >= 0; y--){
			int b = chunk.getBlockId(x, y, z);
			if(b == Block.AIR){
				break;
			}
		}
		return y == 0 ? -1 : y;
	}

}
