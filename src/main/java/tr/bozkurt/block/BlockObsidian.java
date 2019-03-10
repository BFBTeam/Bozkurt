package tr.bozkurt.block;

import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemTool;
import tr.bozkurt.utils.BlockColor;

/**
 * Created on 2015/12/2 by xtypr.
 * Package tr.bozkurt.block in project Bozkurt.
 */
public class BlockObsidian extends BlockSolid{

	public BlockObsidian(){
	}

	@Override
	public String getName(){
		return "Obsidian";
	}

	@Override
	public int getId(){
		return OBSIDIAN;
	}

	@Override
	public int getToolType(){
		return ItemTool.TYPE_PICKAXE;
	}

	@Override
	public double getHardness(){
		return 35; //50 in PC
	}

	@Override
	public double getResistance(){
		return 6000;
	}

	@Override
	public Item[] getDrops(Item item){
		if(item.isPickaxe() && item.getTier() >= ItemTool.TIER_DIAMOND){
			return new Item[]{
					toItem()
			};
		}else{
			return new Item[0];
		}
	}

	@Override
	public boolean onBreak(Item item){
		//destroy the nether portal
		Block[] nearby = new Block[]{
				this.up(), this.down(),
				this.north(), south(),
				this.west(), this.east(),
		};
		for(Block aNearby : nearby){
			if(aNearby != null) if(aNearby.getId() == NETHER_PORTAL){
				aNearby.onBreak(item);
			}
		}
		return super.onBreak(item);
	}

	@Override
	public BlockColor getColor(){
		return BlockColor.OBSIDIAN_BLOCK_COLOR;
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
