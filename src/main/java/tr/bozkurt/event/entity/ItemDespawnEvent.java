package tr.bozkurt.event.entity;

import tr.bozkurt.entity.item.EntityItem;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;

/**
 * Bozkurt Project
 */
public class ItemDespawnEvent extends EntityEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();

	public ItemDespawnEvent(EntityItem item){
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
