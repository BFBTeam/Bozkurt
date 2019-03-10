package tr.bozkurt.event.entity;

import tr.bozkurt.entity.projectile.EntityProjectile;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;
import tr.bozkurt.level.MovingObjectPosition;

/**
 * Bozkurt Project
 */
public class ProjectileHitEvent extends EntityEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	private MovingObjectPosition movingObjectPosition;

	public ProjectileHitEvent(EntityProjectile entity){
		this(entity, null);
	}

	public ProjectileHitEvent(EntityProjectile entity, MovingObjectPosition movingObjectPosition){
		this.entity = entity;
		this.movingObjectPosition = movingObjectPosition;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public MovingObjectPosition getMovingObjectPosition(){
		return movingObjectPosition;
	}

	public void setMovingObjectPosition(MovingObjectPosition movingObjectPosition){
		this.movingObjectPosition = movingObjectPosition;
	}

}
