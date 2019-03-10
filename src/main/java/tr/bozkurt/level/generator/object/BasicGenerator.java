package tr.bozkurt.level.generator.object;

import tr.bozkurt.block.Block;
import tr.bozkurt.level.ChunkManager;
import tr.bozkurt.math.BlockVector3;
import tr.bozkurt.math.BozkurtRandom;
import tr.bozkurt.math.Vector3;

public abstract class BasicGenerator{

	//also autism, see below
	public abstract boolean generate(ChunkManager level, BozkurtRandom rand, Vector3 position);

	public void setDecorationDefaults(){
	}

	protected void setBlockAndNotifyAdequately(ChunkManager level, BlockVector3 pos, Block state){
		setBlock(level, new Vector3(pos.x, pos.y, pos.z), state);
	}

	protected void setBlockAndNotifyAdequately(ChunkManager level, Vector3 pos, Block state){
		setBlock(level, pos, state);
	}

	//what autism is this? why are we using floating-point vectors for setting block IDs?
	protected void setBlock(ChunkManager level, Vector3 v, Block b){
		level.setBlockAt((int) v.x, (int) v.y, (int) v.z, b.getId(), b.getDamage());
	}

}
