package tr.bozkurt.block;

import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemTool;
import tr.bozkurt.utils.BlockColor;
import tr.bozkurt.utils.DyeColor;

/**
 * Created on 2015/11/24 by xtypr.
 * Package tr.bozkurt.block in project Bozkurt.
 */
public class BlockTerracotta extends BlockSolidMeta{

	public BlockTerracotta(){
		this(0);
	}

	public BlockTerracotta(int meta){
		super(0);
	}

	public BlockTerracotta(DyeColor dyeColor){
		this(dyeColor.getWoolData());
	}

	@Override
	public int getId(){
		return TERRACOTTA;
	}

	@Override
	public String getName(){
		return "Terracotta";
	}

	@Override
	public int getToolType(){
		return ItemTool.TYPE_PICKAXE;
	}

	@Override
	public double getHardness(){
		return 1.25;
	}

	@Override
	public double getResistance(){
		return 7;
	}

	@Override
	public Item[] getDrops(Item item){
		if(item.isPickaxe() && item.getTier() >= ItemTool.TIER_WOODEN){
			return new Item[]{
					toItem()
			};
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
