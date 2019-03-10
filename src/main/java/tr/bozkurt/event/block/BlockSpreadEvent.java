package tr.bozkurt.event.block;

import tr.bozkurt.block.Block;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;

/**
 * Bozkurt Project
 */
public class BlockSpreadEvent extends BlockFormEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	private final Block source;

	public BlockSpreadEvent(Block block, Block source, Block newState){
		super(block, newState);
		this.source = source;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public Block getSource(){
		return source;
	}

}
