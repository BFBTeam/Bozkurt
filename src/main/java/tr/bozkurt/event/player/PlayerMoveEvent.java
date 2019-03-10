package tr.bozkurt.event.player;

import tr.bozkurt.Player;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;
import tr.bozkurt.level.Location;

public class PlayerMoveEvent extends PlayerEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	private Location from;
	private Location to;
	private boolean resetBlocksAround;

	public PlayerMoveEvent(Player player, Location from, Location to){
		this(player, from, to, true);
	}

	public PlayerMoveEvent(Player player, Location from, Location to, boolean resetBlocks){
		this.player = player;
		this.from = from;
		this.to = to;
		this.resetBlocksAround = resetBlocks;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public Location getFrom(){
		return from;
	}

	public void setFrom(Location from){
		this.from = from;
	}

	public Location getTo(){
		return to;
	}

	public void setTo(Location to){
		this.to = to;
	}

	public boolean isResetBlocksAround(){
		return resetBlocksAround;
	}

	public void setResetBlocksAround(boolean value){
		this.resetBlocksAround = value;
	}

	@Override
	public void setCancelled(){
		super.setCancelled();
	}

}
