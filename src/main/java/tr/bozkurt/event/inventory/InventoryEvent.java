package tr.bozkurt.event.inventory;

import tr.bozkurt.Player;
import tr.bozkurt.event.Event;
import tr.bozkurt.inventory.Inventory;

/**
 * Bozkurt Project
 */
public abstract class InventoryEvent extends Event{

	protected final Inventory inventory;

	public InventoryEvent(Inventory inventory){
		this.inventory = inventory;
	}

	public Inventory getInventory(){
		return inventory;
	}

	public Player[] getViewers(){
		return this.inventory.getViewers().stream().toArray(Player[]::new);
	}

}
