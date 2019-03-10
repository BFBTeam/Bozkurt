package tr.bozkurt.item.food;

import tr.bozkurt.Player;
import tr.bozkurt.item.ItemBucket;

/**
 * Created by Snake1999 on 2016/1/21.
 * Package tr.bozkurt.item.food in project bozkurt.
 */
public class FoodMilk extends Food{

	@Override
	protected boolean onEatenBy(Player player){
		super.onEatenBy(player);
		player.getInventory().addItem(new ItemBucket());
		player.removeAllEffects();
		return true;
	}

}
