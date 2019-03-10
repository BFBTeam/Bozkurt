package tr.bozkurt.block;

import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemSnowball;
import tr.bozkurt.item.ItemTool;
import tr.bozkurt.utils.BlockColor;

public class BlockSnow extends BlockSolid{

	public BlockSnow(){
	}

	@Override
	public String getName(){
		return "Snow Block";
	}

	@Override
	public int getId(){
		return SNOW_BLOCK;
	}

	@Override
	public double getHardness(){
		return 0.2;
	}

	@Override
	public double getResistance(){
		return 1;
	}

	@Override
	public int getToolType(){
		return ItemTool.TYPE_SHOVEL;
	}

	@Override
	public Item[] getDrops(Item item){
		if(item.isShovel() && item.getTier() >= ItemTool.TIER_WOODEN){
			return new Item[]{
					new ItemSnowball(0, 4)
			};
		}else{
			return new Item[0];
		}
	}

	@Override
	public BlockColor getColor(){
		return BlockColor.SNOW_BLOCK_COLOR;
	}


	@Override
	public boolean canHarvestWithHand(){
		return false;
	}

	@Override
	public boolean canSilkTouch(){
		return true;
	}

}
