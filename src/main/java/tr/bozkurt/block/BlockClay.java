package tr.bozkurt.block;

import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemClay;
import tr.bozkurt.item.ItemTool;
import tr.bozkurt.utils.BlockColor;

/**
 * @author Bozkurt Project Team
 */
public class BlockClay extends BlockSolid{

	public BlockClay(){
	}

	@Override
	public double getHardness(){
		return 0.6;
	}

	@Override
	public double getResistance(){
		return 3;
	}

	@Override
	public int getToolType(){
		return ItemTool.TYPE_SHOVEL;
	}

	@Override
	public int getId(){
		return CLAY_BLOCK;
	}

	@Override
	public String getName(){
		return "Clay Block";
	}

	@Override
	public Item[] getDrops(Item item){
		return new Item[]{
				new ItemClay(0, 4)
		};
	}

	@Override
	public BlockColor getColor(){
		return BlockColor.CLAY_BLOCK_COLOR;
	}

	@Override
	public boolean canSilkTouch(){
		return true;
	}

}
