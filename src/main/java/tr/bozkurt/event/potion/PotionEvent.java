package tr.bozkurt.event.potion;

import tr.bozkurt.event.Event;
import tr.bozkurt.potion.Potion;

/**
 * Created by Snake1999 on 2016/1/12.
 * Package tr.bozkurt.event.potion in project bozkurt
 */
public abstract class PotionEvent extends Event{

	private Potion potion;

	public PotionEvent(Potion potion){
		this.potion = potion;
	}

	public Potion getPotion(){
		return potion;
	}

	public void setPotion(Potion potion){
		this.potion = potion;
	}

}
