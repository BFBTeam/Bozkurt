package tr.bozkurt.event.entity;

import tr.bozkurt.entity.Entity;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;

public class EntityPortalEnterEvent extends EntityEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();

	private final PortalType type;

	public EntityPortalEnterEvent(Entity entity, PortalType type){
		this.entity = entity;
		this.type = type;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public PortalType getPortalType(){
		return type;
	}

	public enum PortalType{
		NETHER,
		END
	}

}
