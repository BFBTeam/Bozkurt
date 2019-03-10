package tr.bozkurt.event.inventory;

import tr.bozkurt.Player;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;
import tr.bozkurt.inventory.Inventory;
import tr.bozkurt.item.Item;

/**
 * author: boybook
 * Bozkurt Project
 */
public class InventoryClickEvent extends InventoryEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	private final int slot;
	private final Item sourceItem;
	private final Item heldItem;
	private final Player player;

	public InventoryClickEvent(Player who, Inventory inventory, int slot, Item sourceItem, Item heldItem){
		super(inventory);
		this.slot = slot;
		this.sourceItem = sourceItem;
		this.heldItem = heldItem;
		this.player = who;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public int getSlot(){
		return slot;
	}

	public Item getSourceItem(){
		return sourceItem;
	}

	public Item getHeldItem(){
		return heldItem;
	}

	public Player getPlayer(){
		return player;
	}

}