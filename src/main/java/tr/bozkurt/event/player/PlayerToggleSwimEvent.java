package tr.bozkurt.event.player;

import tr.bozkurt.Player;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;

/**
 * @author CreeperFace
 */
public class PlayerToggleSwimEvent extends PlayerEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	private final boolean isSwimming;

	public PlayerToggleSwimEvent(Player player, boolean isSwimming){
		this.player = player;
		this.isSwimming = isSwimming;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public boolean isSwimming(){
		return this.isSwimming;
	}

}
