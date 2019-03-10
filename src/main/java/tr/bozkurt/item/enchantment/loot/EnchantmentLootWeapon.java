package tr.bozkurt.item.enchantment.loot;

import tr.bozkurt.item.enchantment.Enchantment;
import tr.bozkurt.item.enchantment.EnchantmentType;

/**
 * Bozkurt Project
 */
public class EnchantmentLootWeapon extends EnchantmentLoot{

	public EnchantmentLootWeapon(){
		super(Enchantment.ID_LOOTING, "lootBonus", 2, EnchantmentType.SWORD);
	}

}
