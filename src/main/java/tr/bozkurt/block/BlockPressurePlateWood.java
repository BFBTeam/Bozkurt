package tr.bozkurt.block;

import tr.bozkurt.entity.Entity;
import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemTool;
import tr.bozkurt.math.AxisAlignedBB;
import tr.bozkurt.utils.BlockColor;

/**
 * @author Bozkurt Project Team
 */
public class BlockPressurePlateWood extends BlockPressurePlateBase{

	public BlockPressurePlateWood(int meta){
		super(meta);
		this.onPitch = 0.8f;
		this.offPitch = 0.7f;
	}

	public BlockPressurePlateWood(){
		this(0);
	}

	@Override
	public String getName(){
		return "Wooden Pressure Plate";
	}

	@Override
	public int getId(){
		return WOODEN_PRESSURE_PLATE;
	}

	@Override
	public int getToolType(){
		return ItemTool.TYPE_AXE;
	}

	@Override
	public double getHardness(){
		return 0.5D;
	}

	@Override
	public double getResistance(){
		return 2.5D;
	}

	@Override
	public Item[] getDrops(Item item){
		return new Item[]{
				toItem()
		};
	}

	@Override
	public BlockColor getColor(){
		return BlockColor.WOOD_BLOCK_COLOR;
	}

	@Override
	protected int computeRedstoneStrength(){
		AxisAlignedBB bb = getCollisionBoundingBox();

		for(Entity entity : this.level.getCollidingEntities(bb)){
			if(entity.doesTriggerPressurePlate()){
				return 15;
			}
		}

		return 0;
	}

}