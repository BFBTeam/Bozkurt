package tr.bozkurt.event.player;

import tr.bozkurt.Player;
import tr.bozkurt.entity.Entity;
import tr.bozkurt.event.HandlerList;

public class PlayerMouseOverEntityEvent extends PlayerEvent{

	private static final HandlerList handlers = new HandlerList();
	private final Entity entity;

	public PlayerMouseOverEntityEvent(Player player, Entity entity){
		this.player = player;
		this.entity = entity;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public Entity getEntity(){
		return entity;
	}

}
