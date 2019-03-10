package tr.bozkurt.entity.mob;

import tr.bozkurt.entity.Entity;
import tr.bozkurt.entity.data.ByteEntityData;
import tr.bozkurt.entity.weather.EntityLightningStrike;
import tr.bozkurt.event.entity.CreeperPowerEvent;
import tr.bozkurt.event.entity.EntityDamageByEntityEvent;
import tr.bozkurt.item.Item;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Box.
 */
public class EntityCreeper extends EntityMob{

	public static final int NETWORK_ID = 33;

	public static final int DATA_SWELL_DIRECTION = 16;
	public static final int DATA_SWELL = 17;
	public static final int DATA_SWELL_OLD = 18;
	public static final int DATA_POWERED = 19;

	public EntityCreeper(FullChunk chunk, CompoundTag nbt){
		super(chunk, nbt);
	}

	@Override
	public int getNetworkId(){
		return NETWORK_ID;
	}

	@Override
	public float getWidth(){
		return 0.6f;
	}

	@Override
	public float getHeight(){
		return 1.7f;
	}

	public boolean isPowered(){
		return getDataPropertyBoolean(DATA_POWERED);
	}

	public void setPowered(EntityLightningStrike bolt){
		CreeperPowerEvent ev = new CreeperPowerEvent(this, bolt, CreeperPowerEvent.PowerCause.LIGHTNING);
		this.getServer().getPluginManager().callEvent(ev);

		if(!ev.isCancelled()){
			this.setDataProperty(new ByteEntityData(DATA_POWERED, 1));
			this.namedTag.putBoolean("powered", true);
		}
	}

	public void setPowered(boolean powered){
		CreeperPowerEvent ev = new CreeperPowerEvent(this, powered ? CreeperPowerEvent.PowerCause.SET_ON : CreeperPowerEvent.PowerCause.SET_OFF);
		this.getServer().getPluginManager().callEvent(ev);

		if(!ev.isCancelled()){
			this.setDataProperty(new ByteEntityData(DATA_POWERED, powered ? 1 : 0));
			this.namedTag.putBoolean("powered", powered);
		}
	}

	public void onStruckByLightning(Entity entity){
		this.setPowered(true);
	}

	@Override
	protected void initEntity(){
		super.initEntity();

		if(this.namedTag.getBoolean("powered") || this.namedTag.getBoolean("IsPowered")){
			this.dataProperties.putBoolean(DATA_POWERED, true);
		}
		this.setMaxHealth(20);
	}

	@Override
	public String getName(){
		return "Creeper";
	}

	@Override
	public Item[] getDrops(){
		if(this.lastDamageCause instanceof EntityDamageByEntityEvent){
			return new Item[]{Item.get(Item.GUNPOWDER, ThreadLocalRandom.current().nextInt(2) + 1)};
		}
		return new Item[0];
	}

}
