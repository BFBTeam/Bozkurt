package tr.bozkurt.block;

import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemTool;
import tr.bozkurt.utils.BlockColor;
import tr.bozkurt.utils.DyeColor;

/**
 * Created on 2015/12/2 by xtypr.
 * Package tr.bozkurt.block in project Bozkurt.
 */
public class BlockTerracottaStained extends BlockSolidMeta{

	public BlockTerracottaStained(){
		this(0);
	}

	public BlockTerracottaStained(int meta){
		super(meta);
	}

	public BlockTerracottaStained(DyeColor dyeColor){
		this(dyeColor.getWoolData());
	}

	@Override
	public String getName(){
		return getDyeColor().getName() + " Terracotta";
	}

	@Override
	public int getId(){
		return STAINED_TERRACOTTA;
	}

	@Override
	public double getHardness(){
		return 1.25;
	}

	@Override
	public double getResistance(){
		return 0.75;
	}

	@Override
	public int getToolType(){
		return ItemTool.TYPE_PICKAXE;
	}

	@Override
	public Item[] getDrops(Item item){
		if(item.isPickaxe() && item.getTier() >= ItemTool.TIER_WOODEN){
			return new Item[]{toItem()};
		}else{
			return new Item[0];
		}
	}

	@Override
	public BlockColor getColor(){
		return DyeColor.getByWoolData(getDamage()).getColor();
	}

	public DyeColor getDyeColor(){
		return DyeColor.getByWoolData(getDamage());
	}

}
