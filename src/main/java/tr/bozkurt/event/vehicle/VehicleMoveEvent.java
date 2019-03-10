package tr.bozkurt.event.vehicle;

import tr.bozkurt.entity.item.EntityVehicle;
import tr.bozkurt.event.HandlerList;
import tr.bozkurt.level.Location;

public class VehicleMoveEvent extends VehicleEvent{

	private static final HandlerList handlers = new HandlerList();
	private final Location from;
	private final Location to;

	public VehicleMoveEvent(EntityVehicle vehicle, Location from, Location to){
		super(vehicle);
		this.from = from;
		this.to = to;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public Location getFrom(){
		return from;
	}

	public Location getTo(){
		return to;
	}

}
