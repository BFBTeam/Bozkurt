package tr.bozkurt.item;

import tr.bozkurt.block.BlockCake;

/**
 * Bozkurt Project
 */
public class ItemCake extends Item{

	public ItemCake(){
		this(0, 1);
	}

	public ItemCake(Integer meta){
		this(meta, 1);
	}

	public ItemCake(Integer meta, int count){
		super(CAKE, 0, count, "Cake");
		this.block = new BlockCake();
	}

	@Override
	public int getMaxStackSize(){
		return 1;
	}

}
