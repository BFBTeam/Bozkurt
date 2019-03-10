package tr.bozkurt.event.block;

import tr.bozkurt.block.Block;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;

/**
 * Bozkurt Project
 */
public class BlockUpdateEvent extends BlockEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();

	public BlockUpdateEvent(Block block){
		super(block);
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

}
