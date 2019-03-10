package tr.bozkurt.event.block;

import tr.bozkurt.block.Block;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;

/**
 * Bozkurt Project
 */
public class BlockFormEvent extends BlockGrowEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();

	public BlockFormEvent(Block block, Block newState){
		super(block, newState);
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

}
