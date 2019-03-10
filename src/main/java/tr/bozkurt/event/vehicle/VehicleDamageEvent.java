package tr.bozkurt.event.vehicle;

import tr.bozkurt.entity.Entity;
import tr.bozkurt.entity.item.EntityVehicle;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;

public class VehicleDamageEvent extends VehicleEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	private final Entity attacker;
	private double damage;

	public VehicleDamageEvent(EntityVehicle vehicle, Entity attacker, double damage){
		super(vehicle);
		this.attacker = attacker;
		this.damage = damage;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public Entity getAttacker(){
		return attacker;
	}

	public double getDamage(){
		return damage;
	}

	public void setDamage(double damage){
		this.damage = damage;
	}

}
