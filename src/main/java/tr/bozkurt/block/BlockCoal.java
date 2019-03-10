package tr.bozkurt.block;

import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemTool;

/**
 * Created on 2015/11/24 by xtypr.
 * Package tr.bozkurt.block in project Bozkurt.
 */
public class BlockCoal extends BlockSolid{

	public BlockCoal(){
	}

	@Override
	public int getId(){
		return COAL_BLOCK;
	}

	@Override
	public double getHardness(){
		return 5;
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
	public int getBurnChance(){
		return 5;
	}

	@Override
	public int getBurnAbility(){
		return 5;
	}

	@Override
	public String getName(){
		return "Block of Coal";
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
