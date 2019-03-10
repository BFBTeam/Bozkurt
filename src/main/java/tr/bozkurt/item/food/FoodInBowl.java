package tr.bozkurt.item.food;

import tr.bozkurt.Player;
import tr.bozkurt.item.ItemBowl;

/**
 * Created by Snake1999 on 2016/1/14.
 * Package tr.bozkurt.item.food in project bozkurt.
 */
public class FoodInBowl extends Food{

	public FoodInBowl(int restoreFood, float restoreSaturation){
		this.setRestoreFood(restoreFood);
		this.setRestoreSaturation(restoreSaturation);
	}

	@Override
	protected boolean onEatenBy(Player player){
		super.onEatenBy(player);
		player.getInventory().addItem(new ItemBowl());
		return true;
	}

}
