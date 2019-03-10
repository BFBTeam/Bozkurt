package tr.bozkurt.block;

import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemTool;

/**
 * Created on 2015/11/22 by xtypr.
 * Package tr.bozkurt.block in project Bozkurt.
 */
public class BlockObsidianGlowing extends BlockSolid{

	public BlockObsidianGlowing(){
	}

	@Override
	public int getId(){
		return GLOWING_OBSIDIAN;
	}

	@Override
	public int getToolType(){
		return ItemTool.TYPE_PICKAXE;
	}

	@Override
	public String getName(){
		return "Glowing Obsidian";
	}

	@Override
	public double getHardness(){
		return 50;
	}

	@Override
	public double getResistance(){
		return 6000;
	}

	@Override
	public int getLightLevel(){
		return 12;
	}

	@Override
	public Item[] getDrops(Item item){
		if(item.isPickaxe() && item.getTier() > ItemTool.DIAMOND_PICKAXE){
			return new Item[]{
					toItem()
			};
		}else{
			return new Item[0];
		}
	}

	@Override
	public boolean canBePushed(){
		return false;
	}

	@Override
	public boolean canHarvestWithHand(){
		return false;
	}

}
