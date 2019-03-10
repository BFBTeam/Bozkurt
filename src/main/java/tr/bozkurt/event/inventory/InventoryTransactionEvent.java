package tr.bozkurt.event.inventory;

import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.Event;
import tr.bozkurt.event.HandlerList;
import tr.bozkurt.inventory.transaction.InventoryTransaction;

/**
 * Bozkurt Project
 */
public class InventoryTransactionEvent extends Event implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	private final InventoryTransaction transaction;

	public InventoryTransactionEvent(InventoryTransaction transaction){
		this.transaction = transaction;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public InventoryTransaction getTransaction(){
		return transaction;
	}

}