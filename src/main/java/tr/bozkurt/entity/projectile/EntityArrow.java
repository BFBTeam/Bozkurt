package tr.bozkurt.entity.projectile;

import tr.bozkurt.entity.Entity;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Bozkurt Project
 */
public class EntityArrow extends EntityProjectile{

	public static final int NETWORK_ID = 80;

	public static final int DATA_SOURCE_ID = 17;
	protected float gravity = 0.05f;
	protected float drag = 0.01f;

	public EntityArrow(FullChunk chunk, CompoundTag nbt){
		this(chunk, nbt, null);
	}

	public EntityArrow(FullChunk chunk, CompoundTag nbt, Entity shootingEntity){
		this(chunk, nbt, shootingEntity, false);
	}

	public EntityArrow(FullChunk chunk, CompoundTag nbt, Entity shootingEntity, boolean critical){
		super(chunk, nbt, shootingEntity);
		this.setCritical(critical);
	}

	@Override
	public int getNetworkId(){
		return NETWORK_ID;
	}

	@Override
	public float getWidth(){
		return 0.5f;
	}

	@Override
	public float getLength(){
		return 0.5f;
	}

	@Override
	public float getHeight(){
		return 0.5f;
	}

	@Override
	public float getGravity(){
		return 0.05f;
	}

	@Override
	public float getDrag(){
		return 0.01f;
	}

	@Override
	protected void initEntity(){
		super.initEntity();

		this.damage = namedTag.contains("damage") ? namedTag.getDouble("damage") : 2;
	}

	public void setCritical(){
		this.setCritical(true);
	}

	public boolean isCritical(){
		return this.getDataFlag(DATA_FLAGS, DATA_FLAG_CRITICAL);
	}

	public void setCritical(boolean value){
		this.setDataFlag(DATA_FLAGS, DATA_FLAG_CRITICAL, value);
	}

	@Override
	public int getResultDamage(){
		int base = super.getResultDamage();

		if(this.isCritical()){
			base += ThreadLocalRandom.current().nextInt(base / 2 + 2);
		}

		return base;
	}

	@Override
	protected double getBaseDamage(){
		return 2;
	}

	@Override
	public boolean onUpdate(int currentTick){
		if(this.closed){
			return false;
		}

		boolean hasUpdate = super.onUpdate(currentTick);

		if(this.onGround || this.hadCollision){
			this.setCritical(false);
		}

		if(this.age > 1200){
			this.close();
			hasUpdate = true;
		}

		return hasUpdate;
	}

}
