package tr.bozkurt.event.player;

import tr.bozkurt.Player;
import tr.bozkurt.block.Block;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;

public class PlayerBedEnterEvent extends PlayerEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	private final Block bed;

	public PlayerBedEnterEvent(Player player, Block bed){
		this.player = player;
		this.bed = bed;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public Block getBed(){
		return bed;
	}

}
