package tr.bozkurt.event.entity;

import tr.bozkurt.block.Block;
import tr.bozkurt.entity.Entity;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;

/**
 * Created on 15-10-26.
 */
public class EntityBlockChangeEvent extends EntityEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	private final Block from;
	private final Block to;

	public EntityBlockChangeEvent(Entity entity, Block from, Block to){
		this.entity = entity;
		this.from = from;
		this.to = to;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public Block getFrom(){
		return from;
	}

	public Block getTo(){
		return to;
	}

}
