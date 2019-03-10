package tr.bozkurt.event.player;

import tr.bozkurt.Player;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;
import tr.bozkurt.item.Item;

/**
 * Called when a player eats something
 */
public class PlayerItemConsumeEvent extends PlayerEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	private final Item item;

	public PlayerItemConsumeEvent(Player player, Item item){
		this.player = player;
		this.item = item;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public Item getItem(){
		return this.item.clone();
	}

}
