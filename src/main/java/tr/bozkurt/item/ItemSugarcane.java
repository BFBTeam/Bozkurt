package tr.bozkurt.item;

import tr.bozkurt.block.BlockSugarcane;

/**
 * Bozkurt Project
 */
public class ItemSugarcane extends Item{

	public ItemSugarcane(){
		this(0, 1);
	}

	public ItemSugarcane(Integer meta){
		this(meta, 1);
	}

	public ItemSugarcane(Integer meta, int count){
		super(SUGARCANE, 0, count, "Sugar Cane");
		this.block = new BlockSugarcane();
	}

}
