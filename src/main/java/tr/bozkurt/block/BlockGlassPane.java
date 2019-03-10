package tr.bozkurt.block;

import tr.bozkurt.item.Item;
import tr.bozkurt.utils.BlockColor;

/**
 * Created on 2015/12/6 by xtypr.
 * Package tr.bozkurt.block in project Bozkurt.
 */
public class BlockGlassPane extends BlockThin{

	public BlockGlassPane(){
	}

	@Override
	public String getName(){
		return "Glass Pane";
	}

	@Override
	public int getId(){
		return GLASS_PANE;
	}

	@Override
	public double getResistance(){
		return 1.5;
	}

	@Override
	public double getHardness(){
		return 0.3;
	}

	@Override
	public Item[] getDrops(Item item){
		return new Item[0];
	}

	@Override
	public BlockColor getColor(){
		return BlockColor.AIR_BLOCK_COLOR;
	}

	@Override
	public boolean canSilkTouch(){
		return true;
	}

}
