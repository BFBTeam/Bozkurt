package tr.bozkurt.entity.projectile;

import tr.bozkurt.Player;
import tr.bozkurt.entity.Entity;
import tr.bozkurt.event.player.PlayerTeleportEvent.TeleportCause;
import tr.bozkurt.level.Sound;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.math.BozkurtMath;
import tr.bozkurt.math.Vector3;
import tr.bozkurt.nbt.tag.CompoundTag;

public class EntityEnderPearl extends EntityProjectile{

	public static final int NETWORK_ID = 87;

	public EntityEnderPearl(FullChunk chunk, CompoundTag nbt){
		this(chunk, nbt, null);
	}

	public EntityEnderPearl(FullChunk chunk, CompoundTag nbt, Entity shootingEntity){
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

		if(this.isCollided && this.shootingEntity instanceof Player){
			this.shootingEntity.teleport(new Vector3(BozkurtMath.floorDouble(this.x) + 0.5, this.y, BozkurtMath.floorDouble(this.z) + 0.5), TeleportCause.ENDER_PEARL);
			if((((Player) this.shootingEntity).getGamemode() & 0x01) == 0) this.shootingEntity.attack(5);
			this.level.addSound(this, Sound.MOB_ENDERMEN_PORTAL);
		}

		if(this.age > 1200 || this.isCollided){
			this.kill();
			hasUpdate = true;
		}

		return hasUpdate;
	}

}
