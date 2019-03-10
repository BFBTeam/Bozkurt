package tr.bozkurt.event.entity;

import tr.bozkurt.entity.projectile.EntityProjectile;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;

public class ProjectileLaunchEvent extends EntityEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();

	public ProjectileLaunchEvent(EntityProjectile entity){
		this.entity = entity;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public EntityProjectile getEntity(){
		return (EntityProjectile) this.entity;
	}

}
