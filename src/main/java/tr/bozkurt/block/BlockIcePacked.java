package tr.bozkurt.block;

import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemTool;

/**
 * Bozkurt Project
 */
public class BlockIcePacked extends BlockIce{

	public BlockIcePacked(){
	}

	@Override
	public int getId(){
		return PACKED_ICE;
	}

	@Override
	public String getName(){
		return "Packed Ice";
	}

	@Override
	public int getToolType(){
		return ItemTool.TYPE_PICKAXE;
	}

	@Override
	public int onUpdate(int type){
		return 0; //not being melted
	}

	@Override
	public boolean canHarvestWithHand(){
		return false;
	}

	@Override
	public boolean onBreak(Item item){
		this.getLevel().setBlock(this, new BlockAir(), true); //no water
		return true;
	}

	@Override
	public boolean canSilkTouch(){
		return true;
	}

}
