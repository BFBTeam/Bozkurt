package tr.bozkurt.block;

import tr.bozkurt.Player;
import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemTool;
import tr.bozkurt.utils.BlockColor;

/**
 * Created by Pub4Game on 26.12.2015.
 */
public class BlockTrapdoorIron extends BlockTrapdoor{

	public BlockTrapdoorIron(){
		this(0);
	}

	public BlockTrapdoorIron(int meta){
		super(meta);
	}

	@Override
	public int getId(){
		return IRON_TRAPDOOR;
	}

	@Override
	public String getName(){
		return "Iron Trapdoor";
	}

	@Override
	public double getHardness(){
		return 5;
	}

	@Override
	public double getResistance(){
		return 25;
	}

	@Override
	public int getToolType(){
		return ItemTool.TYPE_PICKAXE;
	}

	@Override
	public BlockColor getColor(){
		return BlockColor.IRON_BLOCK_COLOR;
	}

	@Override
	public boolean onActivate(Item item, Player player){
		return false;
	}

	@Override
	public boolean canHarvestWithHand(){
		return false;
	}

}