package tr.bozkurt.block;

import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemDoorDarkOak;

public class BlockDoorDarkOak extends BlockDoorWood{

	public BlockDoorDarkOak(){
		this(0);
	}

	public BlockDoorDarkOak(int meta){
		super(meta);
	}

	@Override
	public String getName(){
		return "Dark Oak Door Block";
	}

	@Override
	public int getId(){
		return DARK_OAK_DOOR_BLOCK;
	}

	@Override
	public Item toItem(){
		return new ItemDoorDarkOak();
	}

}
