package tr.bozkurt.event.potion;

import tr.bozkurt.entity.Entity;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;
import tr.bozkurt.potion.Effect;
import tr.bozkurt.potion.Potion;

/**
 * Created by Snake1999 on 2016/1/12.
 * Package tr.bozkurt.event.potion in project bozkurt
 */
public class PotionApplyEvent extends PotionEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	private final Entity entity;
	private Effect applyEffect;

	public PotionApplyEvent(Potion potion, Effect applyEffect, Entity entity){
		super(potion);
		this.applyEffect = applyEffect;
		this.entity = entity;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public Entity getEntity(){
		return entity;
	}

	public Effect getApplyEffect(){
		return applyEffect;
	}

	public void setApplyEffect(Effect applyEffect){
		this.applyEffect = applyEffect;
	}

}
