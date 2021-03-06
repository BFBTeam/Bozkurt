package tr.bozkurt.block;

import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemBook;
import tr.bozkurt.item.ItemTool;
import tr.bozkurt.utils.BlockColor;

/**
 * @author Bozkurt Project Team
 */
public class BlockBookshelf extends BlockSolidMeta{

	public BlockBookshelf(int meta){
		super(meta);
	}

	public BlockBookshelf(){
		this(0);
	}

	@Override
	public String getName(){
		return "Bookshelf";
	}

	@Override
	public int getId(){
		return BOOKSHELF;
	}

	@Override
	public double getHardness(){
		return 1.5D;
	}

	@Override
	public double getResistance(){
		return 7.5D;
	}

	@Override
	public int getToolType(){
		return ItemTool.TYPE_AXE;
	}

	@Override
	public int getBurnChance(){
		return 30;
	}

	@Override
	public int getBurnAbility(){
		return 20;
	}

	@Override
	public Item[] getDrops(Item item){
		return new Item[]{
				new ItemBook(0, 3)
		};
	}

	@Override
	public BlockColor getColor(){
		return BlockColor.WOOD_BLOCK_COLOR;
	}

	@Override
	public boolean canSilkTouch(){
		return true;
	}

}
