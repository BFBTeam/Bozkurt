package tr.bozkurt.event.block;

import tr.bozkurt.block.Block;
import tr.bozkurt.event.HandlerList;

/**
 * Created by CreeperFace on 2.8.2017.
 */
public class BlockPistonChangeEvent extends BlockEvent{

	private static final HandlerList handlers = new HandlerList();
	private int oldPower;
	private int newPower;

	public BlockPistonChangeEvent(Block block, int oldPower, int newPower){
		super(block);
		this.oldPower = oldPower;
		this.newPower = newPower;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public int getOldPower(){
		return oldPower;
	}

	public int getNewPower(){
		return newPower;
	}

}
