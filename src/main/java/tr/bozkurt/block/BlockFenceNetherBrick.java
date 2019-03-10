package tr.bozkurt.block;

import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemTool;
import tr.bozkurt.utils.BlockColor;

/**
 * Created on 2015/12/7 by xtypr.
 * Package tr.bozkurt.block in project Bozkurt.
 */
public class BlockFenceNetherBrick extends BlockFence{

	public BlockFenceNetherBrick(){
		this(0);
	}

	public BlockFenceNetherBrick(int meta){
		super(meta);
	}

	@Override
	public int getToolType(){
		return ItemTool.TYPE_PICKAXE;
	}

	@Override
	public String getName(){
		return "Nether Brick Fence";
	}

	@Override
	public int getId(){
		return NETHER_BRICK_FENCE;
	}

	@Override
	public double getHardness(){
		return 2;
	}

	@Override
	public double getResistance(){
		return 10;
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
	public boolean canConnect(Block block){
		return (block instanceof BlockFenceNetherBrick || block instanceof BlockFenceGate) || block.isSolid() && !block.isTransparent();
	}

	@Override
	public BlockColor getColor(){
		return BlockColor.NETHERRACK_BLOCK_COLOR;
	}

	@Override
	public boolean canHarvestWithHand(){
		return false;
	}

}