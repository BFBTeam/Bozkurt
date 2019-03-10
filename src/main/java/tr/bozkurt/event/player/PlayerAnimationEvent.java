package tr.bozkurt.event.player;

import tr.bozkurt.Player;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;

public class PlayerAnimationEvent extends PlayerEvent implements Cancellable{

	public static final int ARM_SWING = 1;
	private static final HandlerList handlers = new HandlerList();
	private final int animationType;

	public PlayerAnimationEvent(Player player){
		this(player, ARM_SWING);
	}

	public PlayerAnimationEvent(Player player, int animation){
		this.player = player;
		this.animationType = animation;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public int getAnimationType(){
		return this.animationType;
	}

}
