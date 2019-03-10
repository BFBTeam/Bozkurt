package tr.bozkurt.level.generator.populator.impl;

import tr.bozkurt.level.ChunkManager;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.level.generator.populator.type.Populator;
import tr.bozkurt.math.BozkurtRandom;

/**
 * @author DaPorkchop_
 * <p>
 * Places bedrock on the bottom of the world
 */
public class PopulatorBedrock extends Populator{

	@Override
	public void populate(ChunkManager level, int chunkX, int chunkZ, BozkurtRandom random, FullChunk chunk){
		for(int x = 0; x < 16; x++){
			for(int z = 0; z < 16; z++){
				chunk.setBlockId(x, 0, z, BEDROCK);
				for(int i = 1; i < 5; i++){
					if(random.nextBoundedInt(i) == 0){ //decreasing amount
						chunk.setBlockId(x, i, z, BEDROCK);
					}
				}
			}
		}
	}

}
