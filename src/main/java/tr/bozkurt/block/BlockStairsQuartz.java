package tr.bozkurt.block;

import tr.bozkurt.item.ItemTool;
import tr.bozkurt.utils.BlockColor;

/**
 * Created on 2015/11/25 by xtypr.
 * Package tr.bozkurt.block in project Bozkurt.
 */
public class BlockStairsQuartz extends BlockStairs{

	public BlockStairsQuartz(){
		this(0);
	}

	public BlockStairsQuartz(int meta){
		super(meta);
	}

	@Override
	public int getId(){
		return QUARTZ_STAIRS;
	}

	@Override
	public double getHardness(){
		return 0.8;
	}

	@Override
	public double getResistance(){
		return 4;
	}

	@Override
	public int getToolType(){
		return ItemTool.TYPE_PICKAXE;
	}

	@Override
	public String getName(){
		return "Quartz Stairs";
	}

	@Override
	public BlockColor getColor(){
		return BlockColor.QUARTZ_BLOCK_COLOR;
	}

	@Override
	public boolean canHarvestWithHand(){
		return false;
	}

}
