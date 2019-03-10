package tr.bozkurt.event.entity;

import tr.bozkurt.block.Block;
import tr.bozkurt.entity.Entity;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;

/**
 * @author CreeperFace
 */
public class EntityInteractEvent extends EntityEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	private Block block;

	public EntityInteractEvent(Entity entity, Block block){
		this.entity = entity;
		this.block = block;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public Block getBlock(){
		return block;
	}

}
