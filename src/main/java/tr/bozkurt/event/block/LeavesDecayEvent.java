package tr.bozkurt.event.block;

import tr.bozkurt.block.Block;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;

/**
 * Bozkurt Project
 */
public class LeavesDecayEvent extends BlockEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();

	public LeavesDecayEvent(Block block){
		super(block);
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

}
