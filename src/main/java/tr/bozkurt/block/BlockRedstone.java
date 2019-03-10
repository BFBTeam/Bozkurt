package tr.bozkurt.block;

import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemTool;
import tr.bozkurt.math.BlockFace;
import tr.bozkurt.utils.BlockColor;

/*
 * Created on 2015/12/11 by Pub4Game.
 * Package tr.bozkurt.block in project Bozkurt.
 */
public class BlockRedstone extends BlockSolidMeta{

	public BlockRedstone(){
		this(0);
	}

	public BlockRedstone(int meta){
		super(0);
	}

	@Override
	public int getId(){
		return REDSTONE_BLOCK;
	}

	@Override
	public double getResistance(){
		return 10;
	}

	@Override
	public double getHardness(){
		return 5;
	}

	@Override
	public int getToolType(){
		return ItemTool.TYPE_PICKAXE;
	}

	@Override
	public String getName(){
		return "Redstone Block";
	}

	//TODO: redstone

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
		return BlockColor.REDSTONE_BLOCK_COLOR;
	}

	@Override
	public boolean isPowerSource(){
		return true;
	}

	@Override
	public int getWeakPower(BlockFace face){
		return 15;
	}

	@Override
	public boolean canHarvestWithHand(){
		return false;
	}

}