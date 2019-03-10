package tr.bozkurt.event.player;

import tr.bozkurt.Player;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;
import tr.bozkurt.item.Item;

public class PlayerDropItemEvent extends PlayerEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	private final Item drop;

	public PlayerDropItemEvent(Player player, Item drop){
		this.player = player;
		this.drop = drop;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public Item getItem(){
		return this.drop;
	}

}
