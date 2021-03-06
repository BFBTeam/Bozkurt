package tr.bozkurt.block;

import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemTool;
import tr.bozkurt.utils.BlockColor;

/**
 * @author Bozkurt Project Team
 */
public class BlockBricks extends BlockSolid{

	public BlockBricks(){
	}

	@Override
	public String getName(){
		return "Bricks";
	}

	@Override
	public int getId(){
		return BRICKS_BLOCK;
	}

	@Override
	public double getHardness(){
		return 2;
	}

	@Override
	public double getResistance(){
		return 30;
	}

	@Override
	public int getToolType(){
		return ItemTool.TYPE_PICKAXE;
	}

	@Override
	public Item[] getDrops(Item item){
		if(item.isPickaxe() && item.getTier() >= ItemTool.TIER_WOODEN){
			return new Item[]{
					Item.get(Item.BRICKS_BLOCK, 0, 1)
			};
		}else{
			return new Item[0];
		}
	}

	@Override
	public BlockColor getColor(){
		return BlockColor.STONE_BLOCK_COLOR;
	}

	@Override
	public boolean canHarvestWithHand(){
		return false;
	}

}
