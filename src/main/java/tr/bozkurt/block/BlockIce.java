package tr.bozkurt.block;

import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemTool;
import tr.bozkurt.level.Level;
import tr.bozkurt.utils.BlockColor;

/**
 * Bozkurt Project
 */
public class BlockIce extends BlockTransparent{

	public BlockIce(){
	}

	@Override
	public int getId(){
		return ICE;
	}

	@Override
	public String getName(){
		return "Ice";
	}

	@Override
	public double getResistance(){
		return 2.5;
	}

	@Override
	public double getHardness(){
		return 0.5;
	}

	@Override
	public double getFrictionFactor(){
		return 0.98;
	}

	@Override
	public int getToolType(){
		return ItemTool.TYPE_PICKAXE;
	}

	@Override
	public boolean onBreak(Item item){
		this.getLevel().setBlock(this, new BlockWater(), true);
		return true;
	}

	@Override
	public int onUpdate(int type){
		if(type == Level.BLOCK_UPDATE_RANDOM){
			if(this.getLevel().getBlockLightAt((int) this.x, (int) this.y, (int) this.z) >= 12){
				this.getLevel().setBlock(this, new BlockWater(), true);
				return Level.BLOCK_UPDATE_NORMAL;
			}
		}
		return 0;
	}

	@Override
	public Item[] getDrops(Item item){
		return new Item[0];
	}

	@Override
	public BlockColor getColor(){
		return BlockColor.ICE_BLOCK_COLOR;
	}

	@Override
	public boolean canSilkTouch(){
		return true;
	}

}
