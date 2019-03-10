package tr.bozkurt.event.redstone;

import tr.bozkurt.block.Block;
import tr.bozkurt.event.HandlerList;
import tr.bozkurt.event.block.BlockUpdateEvent;

/**
 * author: Angelic47
 * Bozkurt Project
 */
public class RedstoneUpdateEvent extends BlockUpdateEvent{

	private static final HandlerList handlers = new HandlerList();

	public RedstoneUpdateEvent(Block source){
		super(source);
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

}

