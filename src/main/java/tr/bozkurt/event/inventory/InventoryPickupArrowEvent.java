package tr.bozkurt.event.inventory;

import tr.bozkurt.entity.projectile.EntityArrow;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;
import tr.bozkurt.inventory.Inventory;

/**
 * Bozkurt Project
 */
public class InventoryPickupArrowEvent extends InventoryEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	private final EntityArrow arrow;

	public InventoryPickupArrowEvent(Inventory inventory, EntityArrow arrow){
		super(inventory);
		this.arrow = arrow;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public EntityArrow getArrow(){
		return arrow;
	}

}