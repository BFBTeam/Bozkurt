package tr.bozkurt.event.entity;

import tr.bozkurt.entity.Entity;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;
import tr.bozkurt.math.Vector3;

/**
 * Bozkurt Project
 */
public class EntityMotionEvent extends EntityEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	private final Vector3 motion;

	public EntityMotionEvent(Entity entity, Vector3 motion){
		this.entity = entity;
		this.motion = motion;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	@Deprecated
	public Vector3 getVector(){
		return this.motion;
	}

	public Vector3 getMotion(){
		return this.motion;
	}

}
