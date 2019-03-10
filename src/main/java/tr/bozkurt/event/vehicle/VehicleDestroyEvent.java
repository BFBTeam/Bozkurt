package tr.bozkurt.event.vehicle;

import tr.bozkurt.entity.Entity;
import tr.bozkurt.entity.item.EntityVehicle;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;

public class VehicleDestroyEvent extends VehicleEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	private final Entity attacker;

	public VehicleDestroyEvent(EntityVehicle vehicle, Entity attacker){
		super(vehicle);
		this.attacker = attacker;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public Entity getAttacker(){
		return attacker;
	}

}
