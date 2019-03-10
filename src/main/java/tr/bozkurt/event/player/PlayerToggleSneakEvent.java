package tr.bozkurt.event.player;

import tr.bozkurt.Player;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;

public class PlayerToggleSneakEvent extends PlayerEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	protected final boolean isSneaking;

	public PlayerToggleSneakEvent(Player player, boolean isSneaking){
		this.player = player;
		this.isSneaking = isSneaking;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public boolean isSneaking(){
		return this.isSneaking;
	}

}
