package tr.bozkurt.event.entity;

import tr.bozkurt.entity.item.EntityItem;
import tr.bozkurt.event.HandlerList;

/**
 * Bozkurt Project
 */
public class ItemSpawnEvent extends EntityEvent{

	private static final HandlerList handlers = new HandlerList();

	public ItemSpawnEvent(EntityItem item){
		this.entity = item;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	@Override
	public EntityItem getEntity(){
		return (EntityItem) this.entity;
	}

}
