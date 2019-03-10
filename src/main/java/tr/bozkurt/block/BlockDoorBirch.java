package tr.bozkurt.block;

import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemDoorBirch;

public class BlockDoorBirch extends BlockDoorWood{

	public BlockDoorBirch(){
		this(0);
	}

	public BlockDoorBirch(int meta){
		super(meta);
	}

	@Override
	public String getName(){
		return "Birch Door Block";
	}

	@Override
	public int getId(){
		return BIRCH_DOOR_BLOCK;
	}

	@Override
	public Item toItem(){
		return new ItemDoorBirch();
	}

}
