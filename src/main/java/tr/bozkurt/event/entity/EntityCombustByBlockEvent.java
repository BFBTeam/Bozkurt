package tr.bozkurt.event.entity;

import tr.bozkurt.block.Block;
import tr.bozkurt.entity.Entity;

/**
 * author: Box
 * Bozkurt Project
 */
public class EntityCombustByBlockEvent extends EntityCombustEvent{

	protected final Block combuster;

	public EntityCombustByBlockEvent(Block combuster, Entity combustee, int duration){
		super(combustee, duration);
		this.combuster = combuster;
	}

	public Block getCombuster(){
		return combuster;
	}

}
