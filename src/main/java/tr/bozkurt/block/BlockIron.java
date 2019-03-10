package tr.bozkurt.block;

import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemTool;
import tr.bozkurt.utils.BlockColor;

/**
 * author: Angelic47
 * Bozkurt Project
 */
public class BlockIron extends BlockSolid{


	public BlockIron(){
	}

	@Override
	public int getId(){
		return IRON_BLOCK;
	}

	@Override
	public String getName(){
		return "Iron Block";
	}

	@Override
	public int getToolType(){
		return ItemTool.TYPE_PICKAXE;
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
	public Item[] getDrops(Item item){
		if(item.isPickaxe() && item.getTier() >= ItemTool.TIER_STONE){
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
