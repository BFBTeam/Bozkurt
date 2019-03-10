package tr.bozkurt.block;

import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemTool;
import tr.bozkurt.utils.BlockColor;

/**
 * Created on 2015/12/26 by Pub4Game.
 * Package tr.bozkurt.block in project Bozkurt.
 */
public class BlockNetherrack extends BlockSolid{

	public BlockNetherrack(){
	}

	@Override
	public int getId(){
		return NETHERRACK;
	}

	@Override
	public double getResistance(){
		return 2;
	}

	@Override
	public double getHardness(){
		return 0.4;
	}

	@Override
	public int getToolType(){
		return ItemTool.TYPE_PICKAXE;
	}

	@Override
	public String getName(){
		return "Netherrack";
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
		return BlockColor.NETHERRACK_BLOCK_COLOR;
	}

	@Override
	public boolean canHarvestWithHand(){
		return false;
	}

}
