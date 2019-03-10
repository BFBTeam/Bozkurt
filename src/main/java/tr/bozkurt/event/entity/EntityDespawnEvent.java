package tr.bozkurt.event.entity;

import tr.bozkurt.entity.Entity;
import tr.bozkurt.entity.EntityCreature;
import tr.bozkurt.entity.EntityHuman;
import tr.bozkurt.entity.item.EntityItem;
import tr.bozkurt.entity.item.EntityVehicle;
import tr.bozkurt.entity.projectile.EntityProjectile;
import tr.bozkurt.event.HandlerList;
import tr.bozkurt.level.Position;

/**
 * Bozkurt Project
 */
public class EntityDespawnEvent extends EntityEvent{

	private static final HandlerList handlers = new HandlerList();
	private final int entityType;

	public EntityDespawnEvent(Entity entity){
		this.entity = entity;
		this.entityType = entity.getNetworkId();
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public Position getPosition(){
		return this.entity.getPosition();
	}

	public int getType(){
		return this.entityType;
	}

	public boolean isCreature(){
		return this.entity instanceof EntityCreature;
	}

	public boolean isHuman(){
		return this.entity instanceof EntityHuman;
	}

	public boolean isProjectile(){
		return this.entity instanceof EntityProjectile;
	}

	public boolean isVehicle(){
		return this.entity instanceof EntityVehicle;
	}

	public boolean isItem(){
		return this.entity instanceof EntityItem;
	}

}
