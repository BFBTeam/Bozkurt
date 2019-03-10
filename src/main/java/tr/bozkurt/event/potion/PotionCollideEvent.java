package tr.bozkurt.event.potion;

import tr.bozkurt.entity.item.EntityPotion;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;
import tr.bozkurt.potion.Potion;

/**
 * Created by Snake1999 on 2016/1/12.
 * Package tr.bozkurt.event.potion in project bozkurt
 */
public class PotionCollideEvent extends PotionEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	private final EntityPotion thrownPotion;

	public PotionCollideEvent(Potion potion, EntityPotion thrownPotion){
		super(potion);
		this.thrownPotion = thrownPotion;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public EntityPotion getThrownPotion(){
		return thrownPotion;
	}

}
