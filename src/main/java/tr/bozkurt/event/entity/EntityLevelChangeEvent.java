package tr.bozkurt.event.entity;

import tr.bozkurt.entity.Entity;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;
import tr.bozkurt.level.Level;

/**
 * Bozkurt Project
 */
public class EntityLevelChangeEvent extends EntityEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	private final Level originLevel;
	private final Level targetLevel;

	public EntityLevelChangeEvent(Entity entity, Level originLevel, Level targetLevel){
		this.entity = entity;
		this.originLevel = originLevel;
		this.targetLevel = targetLevel;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public Level getOrigin(){
		return originLevel;
	}

	public Level getTarget(){
		return targetLevel;
	}

}
