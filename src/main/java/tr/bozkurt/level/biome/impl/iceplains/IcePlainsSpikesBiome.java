package tr.bozkurt.level.biome.impl.iceplains;

import tr.bozkurt.level.ChunkManager;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.level.generator.populator.type.Populator;
import tr.bozkurt.math.BozkurtRandom;

/**
 * author: DaPorkchop_
 * Bozkurt Project
 */
public class IcePlainsSpikesBiome extends IcePlainsBiome{

	public IcePlainsSpikesBiome(){
		super();

		PopulatorIceSpikes iceSpikes = new PopulatorIceSpikes();
		this.addPopulator(iceSpikes);
	}

	@Override
	public int getSurfaceBlock(int y){
		return SNOW_BLOCK;
	}

	public String getName(){
		return "Ice Plains Spikes";
	}

	@Override
	public boolean isFreezing(){
		return true;
	}

	/**
	 * @author DaPorkchop_
	 * <p>
	 * Please excuse this mess, but it runs way faster than the correct method
	 */
	private static class PopulatorIceSpikes extends Populator{

		@Override
		public void populate(ChunkManager level, int chunkX, int chunkZ, BozkurtRandom random, FullChunk chunk){
			for(int i = 0; i < 8; i++){
				int x = (chunkX << 4) + random.nextBoundedInt(16);
				int z = (chunkZ << 4) + random.nextBoundedInt(16);
				boolean isTall = random.nextBoundedInt(16) == 0;
				int height = 10 + random.nextBoundedInt(16) + (isTall ? random.nextBoundedInt(31) : 0);
				int startY = getHighestWorkableBlock(x, z, chunk);
				int maxY = startY + height;
				if(isTall){
					for(int y = startY; y < maxY; y++){
						//center column
						level.setBlockAt(x, y, z, PACKED_ICE);
						//t shape
						level.setBlockAt(x + 1, y, z, PACKED_ICE);
						level.setBlockAt(x - 1, y, z, PACKED_ICE);
						level.setBlockAt(x, y, z + 1, PACKED_ICE);
						level.setBlockAt(x, y, z - 1, PACKED_ICE);
						//additional blocks on the side
						if(random.nextBoolean()){
							level.setBlockAt(x + 1, y, z + 1, PACKED_ICE);
						}
						if(random.nextBoolean()){
							level.setBlockAt(x + 1, y, z - 1, PACKED_ICE);
						}
						if(random.nextBoolean()){
							level.setBlockAt(x - 1, y, z + 1, PACKED_ICE);
						}
						if(random.nextBoolean()){
							level.setBlockAt(x - 1, y, z - 1, PACKED_ICE);
						}
					}
					//finish with a point
					level.setBlockAt(x + 1, maxY, z, PACKED_ICE);
					level.setBlockAt(x - 1, maxY, z, PACKED_ICE);
					level.setBlockAt(x, maxY, z + 1, PACKED_ICE);
					level.setBlockAt(x, maxY, z - 1, PACKED_ICE);
					for(int y = maxY; y < maxY + 3; maxY++){
						level.setBlockAt(x, y, z, PACKED_ICE);
					}
				}else{
					//the maximum possible radius in blocks
					int baseWidth = random.nextBoundedInt(1) + 4;
					float shrinkFactor = baseWidth / (float) height;
					float currWidth = baseWidth;
					for(int y = startY; y < maxY; y++){
						for(int xx = (int) -currWidth; xx < currWidth; xx++){
							for(int zz = (int) -currWidth; zz < currWidth; zz++){
								int currDist = (int) Math.sqrt(xx * xx + zz * zz);
								if((int) currWidth != (int) currDist && random.nextBoolean()){
									level.setBlockAt(x + xx, y, z + zz, PACKED_ICE);
								}
							}
						}
						currWidth -= shrinkFactor;
					}
				}
			}
		}

		public int getHighestWorkableBlock(int x, int z, FullChunk chunk){
			return chunk.getHighestBlockAt(x & 0xF, z & 0xF) - 5;
		}

	}

}
