package tr.bozkurt.level.generator.populator.impl;

import tr.bozkurt.block.Block;
import tr.bozkurt.level.ChunkManager;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.level.generator.object.ore.OreType;
import tr.bozkurt.level.generator.populator.type.Populator;
import tr.bozkurt.math.BozkurtMath;
import tr.bozkurt.math.BozkurtRandom;

/**
 * Bozkurt Project
 */
public class PopulatorOre extends Populator{

	private final int replaceId;
	private OreType[] oreTypes = new OreType[0];

	public PopulatorOre(){
		this(Block.STONE);
	}

	public PopulatorOre(int id){
		this.replaceId = id;
	}

	@Override
	public void populate(ChunkManager level, int chunkX, int chunkZ, BozkurtRandom random, FullChunk chunk){
		int sx = chunkX << 4;
		int ex = sx + 15;
		int sz = chunkZ << 4;
		int ez = sz + 15;
		for(OreType type : this.oreTypes){
			for(int i = 0; i < type.clusterCount; i++){
				int x = BozkurtMath.randomRange(random, sx, ex);
				int z = BozkurtMath.randomRange(random, sz, ez);
				int y = BozkurtMath.randomRange(random, type.minHeight, type.maxHeight);
				if(level.getBlockIdAt(x, y, z) != replaceId){
					continue;
				}
				type.spawn(level, random, replaceId, x, y, z);
			}
		}
	}

	public void setOreTypes(OreType[] oreTypes){
		this.oreTypes = oreTypes;
	}

}
