package tr.bozkurt.event.entity;

import tr.bozkurt.entity.Entity;
import tr.bozkurt.event.Event;

/**
 * Bozkurt Project
 */
public abstract class EntityEvent extends Event{

	protected Entity entity;

	public Entity getEntity(){
		return entity;
	}

}
