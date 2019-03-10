package tr.bozkurt.event.block;

import tr.bozkurt.block.Block;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;

/**
 * Bozkurt Project
 */
public class BlockGrowEvent extends BlockEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	private final Block newState;

	public BlockGrowEvent(Block block, Block newState){
		super(block);
		this.newState = newState;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public Block getNewState(){
		return newState;
	}

}
