package tr.bozkurt.event.entity;

import tr.bozkurt.block.Block;
import tr.bozkurt.entity.Entity;

/**
 * Bozkurt Project
 */
public class EntityDamageByBlockEvent extends EntityDamageEvent{

	private final Block damager;

	public EntityDamageByBlockEvent(Block damager, Entity entity, DamageCause cause, float damage){
		super(entity, cause, damage);
		this.damager = damager;
	}

	public Block getDamager(){
		return damager;
	}

}
