package tr.bozkurt.block;

import tr.bozkurt.item.ItemTool;
import tr.bozkurt.utils.BlockColor;
import tr.bozkurt.utils.DyeColor;

/**
 * Created on 2015/12/2 by xtypr.
 * Package tr.bozkurt.block in project Bozkurt.
 */
public class BlockWool extends BlockSolidMeta{

	public BlockWool(){
		this(0);
	}

	public BlockWool(int meta){
		super(meta);
	}

	public BlockWool(DyeColor dyeColor){
		this(dyeColor.getWoolData());
	}

	@Override
	public String getName(){
		return getDyeColor().getName() + " Wool";
	}

	@Override
	public int getId(){
		return WOOL;
	}

	@Override
	public int getToolType(){
		return ItemTool.TYPE_SHEARS;
	}

	@Override
	public double getHardness(){
		return 0.8;
	}

	@Override
	public double getResistance(){
		return 4;
	}

	@Override
	public int getBurnChance(){
		return 30;
	}

	@Override
	public int getBurnAbility(){
		return 60;
	}

	@Override
	public BlockColor getColor(){
		return DyeColor.getByWoolData(getDamage()).getColor();
	}

	public DyeColor getDyeColor(){
		return DyeColor.getByWoolData(getDamage());
	}

}
