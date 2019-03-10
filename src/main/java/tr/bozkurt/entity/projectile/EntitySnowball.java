package tr.bozkurt.entity.projectile;

import tr.bozkurt.entity.Entity;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;

/**
 * Bozkurt Project
 */
public class EntitySnowball extends EntityProjectile{

	public static final int NETWORK_ID = 81;

	public EntitySnowball(FullChunk chunk, CompoundTag nbt){
		this(chunk, nbt, null);
	}

	public EntitySnowball(FullChunk chunk, CompoundTag nbt, Entity shootingEntity){
		super(chunk, nbt, shootingEntity);
	}

	@Override
	public int getNetworkId(){
		return NETWORK_ID;
	}

	@Override
	public float getWidth(){
		return 0.25f;
	}

	@Override
	public float getLength(){
		return 0.25f;
	}

	@Override
	public float getHeight(){
		return 0.25f;
	}

	@Override
	protected float getGravity(){
		return 0.03f;
	}

	@Override
	protected float getDrag(){
		return 0.01f;
	}

	@Override
	public boolean onUpdate(int currentTick){
		if(this.closed){
			return false;
		}

		boolean hasUpdate = super.onUpdate(currentTick);

		if(this.age > 1200 || this.isCollided){
			this.kill();
			hasUpdate = true;
		}

		return hasUpdate;
	}

}
