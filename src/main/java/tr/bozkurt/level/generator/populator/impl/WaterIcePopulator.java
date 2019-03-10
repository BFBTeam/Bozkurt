package tr.bozkurt.level.generator.populator.impl;

import tr.bozkurt.level.ChunkManager;
import tr.bozkurt.level.biome.Biome;
import tr.bozkurt.level.biome.EnumBiome;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.level.generator.populator.type.Populator;
import tr.bozkurt.math.BozkurtRandom;

public class WaterIcePopulator extends Populator{

	@Override
	public void populate(ChunkManager level, int chunkX, int chunkZ, BozkurtRandom random, FullChunk chunk){
		for(int x = 0; x < 16; x++){
			for(int z = 0; z < 16; z++){
				Biome biome = EnumBiome.getBiome(chunk.getBiomeId(x, z));
				if(biome.isFreezing()){
					int topBlock = chunk.getHighestBlockAt(x, z);
					if(chunk.getBlockId(x, topBlock, z) == STILL_WATER){
						chunk.setBlockId(x, topBlock, z, ICE);
					}
				}
			}
		}
	}

}
