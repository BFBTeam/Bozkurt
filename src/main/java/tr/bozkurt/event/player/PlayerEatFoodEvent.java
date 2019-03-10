package tr.bozkurt.event.player;

import tr.bozkurt.Player;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;
import tr.bozkurt.item.food.Food;

/**
 * Created by Snake1999 on 2016/1/14.
 * Package tr.bozkurt.event.player in project bozkurt.
 */
public class PlayerEatFoodEvent extends PlayerEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	private Food food;

	public PlayerEatFoodEvent(Player player, Food food){
		this.player = player;
		this.food = food;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public Food getFood(){
		return food;
	}

	public void setFood(Food food){
		this.food = food;
	}

}
