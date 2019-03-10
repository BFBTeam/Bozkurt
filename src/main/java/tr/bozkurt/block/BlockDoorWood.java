package tr.bozkurt.block;

import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemDoorWood;
import tr.bozkurt.item.ItemTool;
import tr.bozkurt.utils.BlockColor;

/**
 * Bozkurt Project
 */
public class BlockDoorWood extends BlockDoor{

	public BlockDoorWood(){
		this(0);
	}

	public BlockDoorWood(int meta){
		super(meta);
	}

	@Override
	public String getName(){
		return "Wood Door Block";
	}

	@Override
	public int getId(){
		return WOOD_DOOR_BLOCK;
	}

	@Override
	public double getHardness(){
		return 3;
	}

	@Override
	public double getResistance(){
		return 15;
	}

	@Override
	public int getToolType(){
		return ItemTool.TYPE_AXE;
	}

	@Override
	public Item toItem(){
		return new ItemDoorWood();
	}

	@Override
	public BlockColor getColor(){
		return BlockColor.WOOD_BLOCK_COLOR;
	}

}
