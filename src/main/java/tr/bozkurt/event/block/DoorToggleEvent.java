package tr.bozkurt.event.block;

import tr.bozkurt.Player;
import tr.bozkurt.block.Block;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;

/**
 * Created by Snake1999 on 2016/1/22.
 * Package tr.bozkurt.event.block in project bozkurt.
 */
public class DoorToggleEvent extends BlockUpdateEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	private Player player;

	public DoorToggleEvent(Block block, Player player){
		super(block);
		this.player = player;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public Player getPlayer(){
		return player;
	}

	public void setPlayer(Player player){
		this.player = player;
	}

}
