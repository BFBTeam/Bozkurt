package tr.bozkurt.event.entity;

import tr.bozkurt.entity.Entity;

/**
 * Bozkurt Project
 */
public class EntityDamageByChildEntityEvent extends EntityDamageByEntityEvent{

	private final Entity childEntity;

	public EntityDamageByChildEntityEvent(Entity damager, Entity childEntity, Entity entity, DamageCause cause, float damage){
		super(damager, entity, cause, damage);
		this.childEntity = childEntity;
	}

	public Entity getChild(){
		return childEntity;
	}

}
