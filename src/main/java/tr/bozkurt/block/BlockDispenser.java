package tr.bozkurt.block;

import tr.bozkurt.math.BlockFace;
import tr.bozkurt.math.Vector3;

/**
 * Created by CreeperFace on 15.4.2017.
 */
public class BlockDispenser extends BlockSolidMeta{

	public BlockDispenser(){
		this(0);
	}

	public BlockDispenser(int meta){
		super(meta);
	}

	@Override
	public boolean hasComparatorInputOverride(){
		return true;
	}

	@Override
	public String getName(){
		return "Dispenser";
	}

	@Override
	public int getId(){
		return DISPENSER;
	}

	@Override
	public int getComparatorInputOverride(){
        /*BlockEntity blockEntity = this.level.getBlockEntity(this);

        if(blockEntity instanceof BlockEntityDispenser) {
            //return ContainerInventory.calculateRedstone(((BlockEntityDispenser) blockEntity).getInventory()); TODO: dispenser
        }*/

		return super.getComparatorInputOverride();
	}

	public BlockFace getFacing(){
		return BlockFace.fromIndex(this.getDamage() & 7);
	}

	public boolean isTriggered(){
		return (this.getDamage() & 8) > 0;
	}

	public void setTriggered(boolean value){
		int i = 0;
		i |= getFacing().getIndex();

		if(value){
			i |= 8;
		}

		this.setDamage(i);
	}

	@Override
	public boolean canHarvestWithHand(){
		return false;
	}

	public Vector3 getDispensePosition(){
		BlockFace facing = getFacing();
		double x = this.getX() + 0.7 * facing.getXOffset();
		double y = this.getY() + 0.7 * facing.getYOffset();
		double z = this.getZ() + 0.7 * facing.getZOffset();
		return new Vector3(x, y, z);
	}

}
