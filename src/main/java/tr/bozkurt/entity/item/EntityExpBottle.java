package tr.bozkurt.entity.item;

import tr.bozkurt.entity.Entity;
import tr.bozkurt.entity.projectile.EntityProjectile;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.level.particle.EnchantParticle;
import tr.bozkurt.level.particle.Particle;
import tr.bozkurt.level.particle.SpellParticle;
import tr.bozkurt.math.BozkurtRandom;
import tr.bozkurt.nbt.tag.CompoundTag;

/**
 * @author xtypr
 */
public class EntityExpBottle extends EntityProjectile{

	public static final int NETWORK_ID = 68;

	public EntityExpBottle(FullChunk chunk, CompoundTag nbt){
		this(chunk, nbt, null);
	}

	public EntityExpBottle(FullChunk chunk, CompoundTag nbt, Entity shootingEntity){
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
		return 0.1f;
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

		int tickDiff = currentTick - this.lastUpdate;
		boolean hasUpdate = super.onUpdate(currentTick);

		if(this.age > 1200){
			this.kill();
			hasUpdate = true;
		}

		if(this.isCollided){
			this.kill();
			Particle particle1 = new EnchantParticle(this);
			this.getLevel().addParticle(particle1);
			Particle particle2 = new SpellParticle(this, 0x00385dc6);
			this.getLevel().addParticle(particle2);
			hasUpdate = true;

			BozkurtRandom random = new BozkurtRandom();
			int add = 1;
			for(int ii = 1; ii <= random.nextRange(3, 11); ii += add){
				getLevel().dropExpOrb(this, add);
				add = random.nextRange(1, 3);
			}
		}

		return hasUpdate;
	}

}
