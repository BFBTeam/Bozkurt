package tr.bozkurt.event.player;

import tr.bozkurt.Player;
import tr.bozkurt.block.Block;
import tr.bozkurt.event.HandlerList;

public class PlayerBedLeaveEvent extends PlayerEvent{

	private static final HandlerList handlers = new HandlerList();
	private final Block bed;

	public PlayerBedLeaveEvent(Player player, Block bed){
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
