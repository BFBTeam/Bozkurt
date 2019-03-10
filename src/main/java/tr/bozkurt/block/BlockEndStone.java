package tr.bozkurt.block;

import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemTool;

/**
 * Created on 2015/12/1 by xtypr.
 * Package tr.bozkurt.block in project Bozkurt.
 */
public class BlockEndStone extends BlockSolid{

	public BlockEndStone(){
	}

	@Override
	public String getName(){
		return "End Stone";
	}

	@Override
	public int getId(){
		return END_STONE;
	}

	@Override
	public double getHardness(){
		return 3;
	}

	@Override
	public double getResistance(){
		return 45;
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
	public boolean canHarvestWithHand(){
		return false;
	}

}
