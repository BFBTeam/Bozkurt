package tr.bozkurt.block;

import tr.bozkurt.utils.BlockColor;

/**
 * Bozkurt Project
 */
public abstract class BlockTransparent extends Block{

	@Override
	public boolean isTransparent(){
		return true;
	}

	@Override
	public BlockColor getColor(){
		return BlockColor.TRANSPARENT_BLOCK_COLOR;
	}

}
