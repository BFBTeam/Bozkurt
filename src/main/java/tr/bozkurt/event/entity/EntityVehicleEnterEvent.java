package tr.bozkurt.event.entity;

import tr.bozkurt.entity.Entity;
import tr.bozkurt.entity.item.EntityVehicle;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;

public class EntityVehicleEnterEvent extends EntityEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	private final EntityVehicle vehicle;

	public EntityVehicleEnterEvent(Entity entity, EntityVehicle vehicle){
		this.entity = entity;
		this.vehicle = vehicle;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public EntityVehicle getVehicle(){
		return vehicle;
	}

}
