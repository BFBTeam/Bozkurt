package tr.bozkurt.event.vehicle;

import tr.bozkurt.entity.item.EntityVehicle;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;

public class VehicleCreateEvent extends VehicleEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();

	public VehicleCreateEvent(EntityVehicle vehicle){
		super(vehicle);
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

}
