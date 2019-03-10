package tr.bozkurt.event.block;

import tr.bozkurt.block.Block;
import tr.bozkurt.event.Event;

/**
 * Bozkurt Project
 */
public abstract class BlockEvent extends Event{

	protected final Block block;

	public BlockEvent(Block block){
		this.block = block;
	}

	public Block getBlock(){
		return block;
	}

}
