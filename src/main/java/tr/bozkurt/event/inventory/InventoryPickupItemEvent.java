package tr.bozkurt.event.inventory;

import tr.bozkurt.entity.item.EntityItem;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;
import tr.bozkurt.inventory.Inventory;

/**
 * Bozkurt Project
 */
public class InventoryPickupItemEvent extends InventoryEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	private final EntityItem item;

	public InventoryPickupItemEvent(Inventory inventory, EntityItem item){
		super(inventory);
		this.item = item;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public EntityItem getItem(){
		return item;
	}

}