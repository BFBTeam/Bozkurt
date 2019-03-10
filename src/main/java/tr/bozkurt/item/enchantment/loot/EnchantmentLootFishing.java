package tr.bozkurt.item.enchantment.loot;

import tr.bozkurt.item.enchantment.Enchantment;
import tr.bozkurt.item.enchantment.EnchantmentType;

/**
 * Bozkurt Project
 */
public class EnchantmentLootFishing extends EnchantmentLoot{

	public EnchantmentLootFishing(){
		super(Enchantment.ID_FORTUNE_FISHING, "lootBonusFishing", 2, EnchantmentType.FISHING_ROD);
	}

}
