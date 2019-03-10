package tr.bozkurt.block;

import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemTool;

/**
 * Bozkurt Project
 */
public class BlockOreIron extends BlockSolid{


	public BlockOreIron(){
	}

	@Override
	public int getId(){
		return IRON_ORE;
	}

	@Override
	public double getHardness(){
		return 3;
	}

	@Override
	public double getResistance(){
		return 5;
	}

	@Override
	public int getToolType(){
		return ItemTool.TYPE_PICKAXE;
	}

	@Override
	public String getName(){
		return "Iron Ore";
	}

	@Override
	public Item[] getDrops(Item item){
		if(item.isPickaxe() && item.getTier() >= ItemTool.TIER_STONE){
			return new Item[]{
					Item.get(IRON_ORE)
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
