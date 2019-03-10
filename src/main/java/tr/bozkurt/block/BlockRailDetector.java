package tr.bozkurt.block;

import tr.bozkurt.entity.Entity;
import tr.bozkurt.entity.item.EntityMinecartAbstract;
import tr.bozkurt.item.Item;
import tr.bozkurt.level.Level;
import tr.bozkurt.math.BlockFace;
import tr.bozkurt.math.SimpleAxisAlignedBB;

/**
 * Created on 2015/11/22 by CreeperFace.
 * Contributed by: larryTheCoder on 2017/7/8.
 * <p>
 * Bozkurt Project,
 * Minecart and Riding Project,
 * Package tr.bozkurt.block in project Bozkurt.
 */
public class BlockRailDetector extends BlockRail{

	public BlockRailDetector(){
		this(0);
		canBePowered = true;
	}

	public BlockRailDetector(int meta){
		super(meta);
	}

	@Override
	public int getId(){
		return DETECTOR_RAIL;
	}

	@Override
	public String getName(){
		return "Detector Rail";
	}

	@Override
	public boolean isPowerSource(){
		return true;
	}

	@Override
	public int getWeakPower(BlockFace side){
		return isActive() ? 15 : 0;
	}

	@Override
	public int getStrongPower(BlockFace side){
		return isActive() ? 0 : (side == BlockFace.UP ? 15 : 0);
	}

	@Override
	public int onUpdate(int type){
		if(type == Level.BLOCK_UPDATE_SCHEDULED){
			updateState();
			return type;
		}
		return super.onUpdate(type);
	}

	@Override
	public void onEntityCollide(Entity entity){
		updateState();
	}

	protected void updateState(){
		boolean wasPowered = isActive();
		boolean isPowered = false;

		for(Entity entity : level.getNearbyEntities(new SimpleAxisAlignedBB(
				getFloorX() + 0.125D,
				getFloorY(),
				getFloorZ() + 0.125D,
				getFloorX() + 0.875D,
				getFloorY() + 0.525D,
				getFloorZ() + 0.875D))){
			if(entity instanceof EntityMinecartAbstract){
				isPowered = true;
			}
		}

		if(isPowered && !wasPowered){
			setActive(true);
			level.scheduleUpdate(this, this, 0);
			level.scheduleUpdate(this, this.down(), 0);
		}

		if(!isPowered && wasPowered){
			setActive(false);
			level.scheduleUpdate(this, this, 0);
			level.scheduleUpdate(this, this.down(), 0);
		}

		level.updateComparatorOutputLevel(this);
	}

	@Override
	public Item[] getDrops(Item item){
		return new Item[]{
				Item.get(Item.DETECTOR_RAIL, 0, 1)
		};
	}

}
