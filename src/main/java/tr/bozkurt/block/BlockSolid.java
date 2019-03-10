package tr.bozkurt.block;

import tr.bozkurt.utils.BlockColor;

/**
 * Bozkurt Project
 */
public abstract class BlockSolid extends Block{

	protected BlockSolid(){
	}

	@Override
	public boolean isSolid(){
		return true;
	}

	@Override
	public BlockColor getColor(){
		return BlockColor.STONE_BLOCK_COLOR;
	}

}
