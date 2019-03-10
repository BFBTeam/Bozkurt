package tr.bozkurt.entity.item;

import tr.bozkurt.Server;
import tr.bozkurt.entity.Entity;
import tr.bozkurt.entity.data.ByteEntityData;
import tr.bozkurt.entity.data.IntEntityData;
import tr.bozkurt.entity.data.SlotEntityData;
import tr.bozkurt.event.entity.EntityDamageEvent;
import tr.bozkurt.event.entity.EntityDamageEvent.DamageCause;
import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemFirework;
import tr.bozkurt.level.Sound;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.NBTIO;
import tr.bozkurt.nbt.tag.CompoundTag;
import tr.bozkurt.network.protocol.EntityEventPacket;
import tr.bozkurt.network.protocol.LevelSoundEventPacket;
import tr.bozkurt.network.protocol.PlaySoundPacket;

import java.util.Random;

/**
 * @author CreeperFace
 */
public class EntityFirework extends Entity{

	public static final int NETWORK_ID = 72;

	private int fireworkAge;
	private int lifetime;
	private Item firework;

	public EntityFirework(FullChunk chunk, CompoundTag nbt){
		super(chunk, nbt);

		this.fireworkAge = 0;
		Random rand = new Random();
		this.lifetime = 30 + rand.nextInt(6) + rand.nextInt(7);

		this.motionX = rand.nextGaussian() * 0.001D;
		this.motionZ = rand.nextGaussian() * 0.001D;
		this.motionY = 0.05D;

		if(nbt.contains("FireworkItem")){
			firework = NBTIO.getItemHelper(nbt.getCompound("FireworkItem"));
		}else{
			firework = new ItemFirework();
		}

		this.setDataProperty(new SlotEntityData(Entity.DATA_DISPLAY_ITEM, firework));
		this.setDataProperty(new IntEntityData(Entity.DATA_DISPLAY_OFFSET, 1));
		this.setDataProperty(new ByteEntityData(Entity.DATA_HAS_DISPLAY, 1));
	}

	@Override
	public int getNetworkId(){
		return NETWORK_ID;
	}

	@Override
	public boolean onUpdate(int currentTick){
		if(this.closed){
			return false;
		}

		int tickDiff = currentTick - this.lastUpdate;

		if(tickDiff <= 0 && !this.justCreated){
			return true;
		}

		this.lastUpdate = currentTick;

		boolean hasUpdate = this.entityBaseTick(tickDiff);

		if(this.isAlive()){

			this.motionX *= 1.15D;
			this.motionZ *= 1.15D;
			this.motionY += 0.04D;
			this.move(this.motionX, this.motionY, this.motionZ);

			this.updateMovement();


			float f = (float) Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
			this.yaw = (float) (Math.atan2(this.motionX, this.motionZ) * (180D / Math.PI));

			this.pitch = (float) (Math.atan2(this.motionY, (double) f) * (180D / Math.PI));


			if(this.fireworkAge == 0){
				PlaySoundPacket pk = new PlaySoundPacket();
				pk.name = Sound.FIREWORK_LAUNCH.getSound();
				pk.volume = 1;
				pk.pitch = 1;
				pk.x = getFloorX();
				pk.y = getFloorY();
				pk.z = getFloorZ();

				this.level.addChunkPacket(this.getFloorX() >> 4, this.getFloorZ() >> 4, pk);
			}

			this.fireworkAge++;

			hasUpdate = true;
			if(this.fireworkAge >= this.lifetime){
				EntityEventPacket pk = new EntityEventPacket();
				pk.data = 0;
				pk.event = EntityEventPacket.FIREWORK_EXPLOSION;
				pk.eid = this.getId();

				level.addLevelSoundEvent(this, LevelSoundEventPacket.SOUND_LARGE_BLAST, -1, NETWORK_ID);

				Server.broadcastPacket(getViewers().values(), pk);

				this.kill();
				hasUpdate = true;
			}
		}

		return hasUpdate || !this.onGround || Math.abs(this.motionX) > 0.00001 || Math.abs(this.motionY) > 0.00001 || Math.abs(this.motionZ) > 0.00001;
	}

	@Override
	public boolean attack(EntityDamageEvent source){
		return (source.getCause() == DamageCause.VOID ||
				source.getCause() == DamageCause.FIRE_TICK ||
				source.getCause() == DamageCause.ENTITY_EXPLOSION ||
				source.getCause() == DamageCause.BLOCK_EXPLOSION)
				&& super.attack(source);
	}

	public void setFirework(Item item){
		this.firework = item;
		this.setDataProperty(new SlotEntityData(Entity.DATA_DISPLAY_ITEM, item));
	}

	@Override
	public float getWidth(){
		return 0.25f;
	}

	@Override
	public float getHeight(){
		return 0.25f;
	}

}