package tr.bozkurt.item;

import tr.bozkurt.block.BlockDoorSpruce;

public class ItemDoorSpruce extends Item{

	public ItemDoorSpruce(){
		this(0, 1);
	}

	public ItemDoorSpruce(Integer meta){
		this(meta, 1);
	}

	public ItemDoorSpruce(Integer meta, int count){
		super(SPRUCE_DOOR, 0, count, "Spruce Door");
		this.block = new BlockDoorSpruce();
	}

}
