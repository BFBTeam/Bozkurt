package tr.bozkurt.item;

import tr.bozkurt.block.BlockCauldron;

/**
 * author: CreeperFace
 * Bozkurt Project
 */
public class ItemCauldron extends Item{

	public ItemCauldron(){
		this(0, 1);
	}

	public ItemCauldron(Integer meta){
		this(meta, 1);
	}

	public ItemCauldron(Integer meta, int count){
		super(CAULDRON, meta, count, "Cauldron");
		this.block = new BlockCauldron();
	}

}