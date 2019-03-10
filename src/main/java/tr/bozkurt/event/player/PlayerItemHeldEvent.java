package tr.bozkurt.event.player;

import tr.bozkurt.Player;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;
import tr.bozkurt.item.Item;

/**
 * Bozkurt Project
 */
public class PlayerItemHeldEvent extends PlayerEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	private final Item item;
	private final int hotbarSlot;

	public PlayerItemHeldEvent(Player player, Item item, int hotbarSlot){
		this.player = player;
		this.item = item;
		this.hotbarSlot = hotbarSlot;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public int getSlot(){
		return this.hotbarSlot;
	}

	@Deprecated
	public int getInventorySlot(){
		return hotbarSlot;
	}

	public Item getItem(){
		return item;
	}

}
