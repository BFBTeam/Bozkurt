package tr.bozkurt.event.player;

import tr.bozkurt.Player;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;

public class PlayerLoginEvent extends PlayerEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	protected String kickMessage;

	public PlayerLoginEvent(Player player, String kickMessage){
		this.player = player;
		this.kickMessage = kickMessage;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public String getKickMessage(){
		return kickMessage;
	}

	public void setKickMessage(String kickMessage){
		this.kickMessage = kickMessage;
	}

}
