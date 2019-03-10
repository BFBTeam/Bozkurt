package tr.bozkurt.event.vehicle;

import tr.bozkurt.Player;
import tr.bozkurt.entity.Entity;
import tr.bozkurt.entity.item.EntityVehicle;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;

public class EntityExitVehicleEvent extends VehicleEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	private final Entity riding;

	public EntityExitVehicleEvent(Entity riding, EntityVehicle vehicle){
		super(vehicle);
		this.riding = riding;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public Entity getEntity(){
		return riding;
	}

	public boolean isPlayer(){
		return riding instanceof Player;
	}

}
