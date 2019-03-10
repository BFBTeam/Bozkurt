package tr.bozkurt.item.enchantment.loot;

import tr.bozkurt.item.enchantment.Enchantment;
import tr.bozkurt.item.enchantment.EnchantmentType;

/**
 * Bozkurt Project
 */
public class EnchantmentLootDigging extends EnchantmentLoot{

	public EnchantmentLootDigging(){
		super(Enchantment.ID_FORTUNE_DIGGING, "lootBonusDigger", 2, EnchantmentType.DIGGER);
	}

}
