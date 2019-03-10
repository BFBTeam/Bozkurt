package tr.bozkurt.item.enchantment.damage;

import tr.bozkurt.item.Item;
import tr.bozkurt.item.enchantment.Enchantment;
import tr.bozkurt.item.enchantment.EnchantmentType;

/**
 * Bozkurt Project
 */
public abstract class EnchantmentDamage extends Enchantment{

	protected final TYPE damageType;

	protected EnchantmentDamage(int id, String name, int weight, TYPE type){
		super(id, name, weight, EnchantmentType.SWORD);
		this.damageType = type;
	}

	@Override
	public boolean isCompatibleWith(Enchantment enchantment){
		return !(enchantment instanceof EnchantmentDamage);
	}

	@Override
	public boolean canEnchant(Item item){
		return item.isAxe() || super.canEnchant(item);
	}

	@Override
	public int getMaxLevel(){
		return 5;
	}

	@Override
	public String getName(){
		return "%enchantment.damage." + this.name;
	}

	@Override
	public boolean isMajor(){
		return true;
	}

	public enum TYPE{
		ALL,
		SMITE,
		ARTHROPODS
	}

}
