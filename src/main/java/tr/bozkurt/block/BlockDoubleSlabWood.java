package tr.bozkurt.block;

import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemTool;
import tr.bozkurt.utils.BlockColor;

/**
 * Created on 2015/12/2 by xtypr.
 * Package tr.bozkurt.block in project Bozkurt.
 */
public class BlockDoubleSlabWood extends BlockSolidMeta{

	public BlockDoubleSlabWood(){
		this(0);
	}

	public BlockDoubleSlabWood(int meta){
		super(meta);
	}

	@Override
	public int getId(){
		return DOUBLE_WOOD_SLAB;
	}

	@Override
	public double getHardness(){
		return 2;
	}

	@Override
	public double getResistance(){
		return 15;
	}

	@Override
	public int getToolType(){
		return ItemTool.TYPE_AXE;
	}

	@Override
	public String getName(){
		String[] names = new String[]{
				"Oak",
				"Spruce",
				"Birch",
				"Jungle",
				"Acacia",
				"Dark Oak",
				"",
				""
		};
		return "Double " + names[this.getDamage() & 0x07] + " Slab";
	}

	public Item[] getDrops(Item item){
		return new Item[]{
				Item.get(Item.WOOD_SLAB, this.getDamage() & 0x07, 2)
		};
	}

	@Override
	public BlockColor getColor(){
		return BlockColor.WOOD_BLOCK_COLOR;
	}

}
