package tr.bozkurt.item.enchantment.bow;

import tr.bozkurt.item.enchantment.Enchantment;
import tr.bozkurt.item.enchantment.EnchantmentType;

/**
 * Bozkurt Project
 */
public abstract class EnchantmentBow extends Enchantment{

	protected EnchantmentBow(int id, String name, int weight){
		super(id, name, weight, EnchantmentType.BOW);
	}

}
