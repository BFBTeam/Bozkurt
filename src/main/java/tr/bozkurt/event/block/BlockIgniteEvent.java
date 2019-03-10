package tr.bozkurt.event.block;

import tr.bozkurt.block.Block;
import tr.bozkurt.entity.Entity;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;

public class BlockIgniteEvent extends BlockEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	private final Block source;
	private final Entity entity;
	private final BlockIgniteCause cause;

	public BlockIgniteEvent(Block block, Block source, Entity entity, BlockIgniteCause cause){
		super(block);
		this.source = source;
		this.entity = entity;
		this.cause = cause;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public Block getSource(){
		return source;
	}

	public Entity getEntity(){
		return entity;
	}

	public BlockIgniteCause getCause(){
		return cause;
	}

	public enum BlockIgniteCause{
		EXPLOSION,
		FIREBALL,
		FLINT_AND_STEEL,
		LAVA,
		LIGHTNING,
		SPREAD
	}

}
