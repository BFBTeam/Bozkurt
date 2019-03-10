package tr.bozkurt.block;

import tr.bozkurt.item.Item;

/**
 * author: Angelic47
 * Bozkurt Project
 */
public class BlockGlass extends BlockTransparent{

	public BlockGlass(){
	}

	@Override
	public int getId(){
		return GLASS;
	}

	@Override
	public String getName(){
		return "Glass";
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
	public boolean canSilkTouch(){
		return true;
	}

}
