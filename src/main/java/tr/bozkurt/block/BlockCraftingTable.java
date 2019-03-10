package tr.bozkurt.block;

import tr.bozkurt.Player;
import tr.bozkurt.inventory.BigCraftingGrid;
import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemTool;
import tr.bozkurt.utils.BlockColor;

/**
 * Created on 2015/12/5 by xtypr.
 * Package tr.bozkurt.block in project Bozkurt.
 */
public class BlockCraftingTable extends BlockSolid{

	public BlockCraftingTable(){
	}

	@Override
	public String getName(){
		return "Crafting Table";
	}

	@Override
	public int getId(){
		return WORKBENCH;
	}

	@Override
	public boolean canBeActivated(){
		return true;
	}

	@Override
	public double getHardness(){
		return 2.5;
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
	public boolean onActivate(Item item, Player player){
		if(player != null){
			player.setCraftingGrid(new BigCraftingGrid(player));
			player.craftingType = Player.CRAFTING_BIG;
		}
		return true;
	}

	@Override
	public BlockColor getColor(){
		return BlockColor.WOOD_BLOCK_COLOR;
	}

}
