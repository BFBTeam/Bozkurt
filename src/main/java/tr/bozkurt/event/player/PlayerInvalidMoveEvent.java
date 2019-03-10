package tr.bozkurt.event.player;

import tr.bozkurt.Player;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;

/**
 * call when a player moves wrongly
 *
 * @author WilliamGao
 */

public class PlayerInvalidMoveEvent extends PlayerEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();

	private boolean revert;

	public PlayerInvalidMoveEvent(Player player, boolean revert){
		this.player = player;
		this.revert = revert;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public boolean isRevert(){
		return this.revert;
	}

	/**
	 * @param revert revert movement
	 * @deprecated If you just simply want to disable the movement check, please use {@link Player#setCheckMovement(boolean)} instead.
	 */
	@Deprecated
	public void setRevert(boolean revert){
		this.revert = revert;
	}

}
