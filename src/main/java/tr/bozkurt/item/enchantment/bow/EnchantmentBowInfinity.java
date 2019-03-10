package tr.bozkurt.item.enchantment.bow;

import tr.bozkurt.item.enchantment.Enchantment;

/**
 * Bozkurt Project
 */
public class EnchantmentBowInfinity extends EnchantmentBow{

	public EnchantmentBowInfinity(){
		super(Enchantment.ID_BOW_INFINITY, "arrowInfinite", 1);
	}

	@Override
	public int getMinEnchantAbility(int level){
		return 20;
	}

	@Override
	public int getMaxEnchantAbility(int level){
		return 50;
	}

	@Override
	public int getMaxLevel(){
		return 1;
	}

}
