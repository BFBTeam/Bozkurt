package tr.bozkurt.event.inventory;

import tr.bozkurt.Player;
import tr.bozkurt.event.HandlerList;
import tr.bozkurt.inventory.Inventory;

/**
 * author: Box
 * Bozkurt Project
 */
public class InventoryCloseEvent extends InventoryEvent{

	private static final HandlerList handlers = new HandlerList();
	private final Player who;

	public InventoryCloseEvent(Inventory inventory, Player who){
		super(inventory);
		this.who = who;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public Player getPlayer(){
		return this.who;
	}

}
