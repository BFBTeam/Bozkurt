package tr.bozkurt.event.player;

import tr.bozkurt.Player;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;

public class PlayerToggleGlideEvent extends PlayerEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	protected final boolean isGliding;

	public PlayerToggleGlideEvent(Player player, boolean isSneaking){
		this.player = player;
		this.isGliding = isSneaking;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public boolean isGliding(){
		return this.isGliding;
	}

}
