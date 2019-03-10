package tr.bozkurt.block;

import tr.bozkurt.item.ItemTool;
import tr.bozkurt.utils.BlockColor;

/**
 * Created on 2015/11/25 by xtypr.
 * Package tr.bozkurt.block in project Bozkurt.
 */
public class BlockStairsBrick extends BlockStairs{

	public BlockStairsBrick(){
		this(0);
	}

	public BlockStairsBrick(int meta){
		super(meta);
	}

	@Override
	public int getId(){
		return BRICK_STAIRS;
	}

	@Override
	public double getHardness(){
		return 2;
	}

	@Override
	public double getResistance(){
		return 30;
	}

	@Override
	public int getToolType(){
		return ItemTool.TYPE_PICKAXE;
	}

	@Override
	public String getName(){
		return "Brick Stairs";
	}

	@Override
	public BlockColor getColor(){
		return BlockColor.STONE_BLOCK_COLOR;
	}

	@Override
	public boolean canHarvestWithHand(){
		return false;
	}

}
