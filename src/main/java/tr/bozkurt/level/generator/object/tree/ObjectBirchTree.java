package tr.bozkurt.level.generator.object.tree;

import tr.bozkurt.block.Block;
import tr.bozkurt.block.BlockWood;
import tr.bozkurt.level.ChunkManager;
import tr.bozkurt.math.BozkurtRandom;

/**
 * Bozkurt Project
 */
public class ObjectBirchTree extends ObjectTree{

	protected int treeHeight = 7;

	@Override
	public int getTrunkBlock(){
		return Block.LOG;
	}

	@Override
	public int getLeafBlock(){
		return Block.LEAVES;
	}

	@Override
	public int getType(){
		return BlockWood.BIRCH;
	}

	@Override
	public int getTreeHeight(){
		return this.treeHeight;
	}

	@Override
	public void placeObject(ChunkManager level, int x, int y, int z, BozkurtRandom random){
		this.treeHeight = random.nextBoundedInt(2) + 5;
		super.placeObject(level, x, y, z, random);
	}

}
