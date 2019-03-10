package tr.bozkurt.block;

import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemTool;
import tr.bozkurt.utils.BlockColor;

/**
 * Created on 2015/12/6 by xtypr.
 * Package tr.bozkurt.block in project Bozkurt.
 */
public class BlockIronBars extends BlockThin{

	public BlockIronBars(){
	}

	@Override
	public String getName(){
		return "Iron Bars";
	}

	@Override
	public int getId(){
		return IRON_BARS;
	}

	@Override
	public double getHardness(){
		return 5;
	}

	@Override
	public double getResistance(){
		return 10;
	}

	@Override
	public int getToolType(){
		return ItemTool.TYPE_PICKAXE;
	}

	@Override
	public Item[] getDrops(Item item){
		if(item.isPickaxe() && item.getTier() >= ItemTool.TIER_WOODEN){
			return new Item[]{
					toItem()
			};
		}else{
			return new Item[0];
		}
	}

	@Override
	public BlockColor getColor(){
		return BlockColor.IRON_BLOCK_COLOR;
	}

	@Override
	public boolean canHarvestWithHand(){
		return false;
	}

}
