package tr.bozkurt.event.vehicle;

import tr.bozkurt.entity.item.EntityVehicle;
import tr.bozkurt.event.Event;

/**
 * Created by larryTheCoder at 7/5/2017.
 * <p>
 * Bozkurt Project
 */
public abstract class VehicleEvent extends Event{

	private final EntityVehicle vehicle;

	public VehicleEvent(EntityVehicle vehicle){
		this.vehicle = vehicle;
	}

	public EntityVehicle getVehicle(){
		return vehicle;
	}

}
