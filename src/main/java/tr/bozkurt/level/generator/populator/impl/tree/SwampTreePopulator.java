package tr.bozkurt.level.generator.populator.impl.tree;

import tr.bozkurt.block.Block;
import tr.bozkurt.block.BlockSapling;
import tr.bozkurt.level.ChunkManager;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.level.generator.object.tree.ObjectSwampTree;
import tr.bozkurt.level.generator.populator.type.Populator;
import tr.bozkurt.math.BozkurtMath;
import tr.bozkurt.math.BozkurtRandom;
import tr.bozkurt.math.Vector3;

public class SwampTreePopulator extends Populator{

	private final int type;
	private ChunkManager level;
	private int randomAmount;
	private int baseAmount;

	public SwampTreePopulator(){
		this(BlockSapling.OAK);
	}

	public SwampTreePopulator(int type){
		this.type = type;
	}

	public void setRandomAmount(int randomAmount){
		this.randomAmount = randomAmount;
	}

	public void setBaseAmount(int baseAmount){
		this.baseAmount = baseAmount;
	}

	@Override
	public void populate(ChunkManager level, int chunkX, int chunkZ, BozkurtRandom random, FullChunk chunk){
		this.level = level;
		int amount = random.nextBoundedInt(this.randomAmount + 1) + this.baseAmount;
		Vector3 v = new Vector3();

		for(int i = 0; i < amount; ++i){
			int x = BozkurtMath.randomRange(random, chunkX << 4, (chunkX << 4) + 15);
			int z = BozkurtMath.randomRange(random, chunkZ << 4, (chunkZ << 4) + 15);
			int y = this.getHighestWorkableBlock(x, z);
			if(y == -1){
				continue;
			}
			new ObjectSwampTree().generate(level, random, v.setComponents(x, y, z));
		}
	}

	private int getHighestWorkableBlock(int x, int z){
		int y;
		for(y = 127; y > 0; --y){
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
