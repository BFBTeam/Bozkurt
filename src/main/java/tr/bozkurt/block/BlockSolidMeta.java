package tr.bozkurt.block;

import tr.bozkurt.utils.BlockColor;

public abstract class BlockSolidMeta extends BlockMeta{

	protected BlockSolidMeta(int meta){
		super(meta);
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
