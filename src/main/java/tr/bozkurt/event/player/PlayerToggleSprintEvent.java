package tr.bozkurt.event.player;

import tr.bozkurt.Player;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;

public class PlayerToggleSprintEvent extends PlayerEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	protected final boolean isSprinting;

	public PlayerToggleSprintEvent(Player player, boolean isSprinting){
		this.player = player;
		this.isSprinting = isSprinting;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public boolean isSprinting(){
		return this.isSprinting;
	}

}
