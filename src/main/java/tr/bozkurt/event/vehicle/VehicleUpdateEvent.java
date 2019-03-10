package tr.bozkurt.event.vehicle;

import tr.bozkurt.entity.item.EntityVehicle;
import tr.bozkurt.event.HandlerList;

public class VehicleUpdateEvent extends VehicleEvent{

	private static final HandlerList handlers = new HandlerList();

	public VehicleUpdateEvent(EntityVehicle vehicle){
		super(vehicle);
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

}
