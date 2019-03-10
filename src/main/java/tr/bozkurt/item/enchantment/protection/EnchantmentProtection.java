package tr.bozkurt.item.enchantment.protection;

import tr.bozkurt.item.enchantment.Enchantment;
import tr.bozkurt.item.enchantment.EnchantmentType;

/**
 * Bozkurt Project
 */
public abstract class EnchantmentProtection extends Enchantment{

	protected final TYPE protectionType;

	protected EnchantmentProtection(int id, String name, int weight, EnchantmentProtection.TYPE type){
		super(id, name, weight, EnchantmentType.ARMOR);
		this.protectionType = type;
		if(protectionType == TYPE.FALL){
			this.type = EnchantmentType.ARMOR_FEET;
		}
	}

	@Override
	public boolean isCompatibleWith(Enchantment enchantment){
		if(enchantment instanceof EnchantmentProtection){
			if(((EnchantmentProtection) enchantment).protectionType == this.protectionType){
				return false;
			}
			return ((EnchantmentProtection) enchantment).protectionType == TYPE.FALL || this.protectionType == TYPE.FALL;
		}
		return super.isCompatibleWith(enchantment);
	}

	@Override
	public int getMaxLevel(){
		return 4;
	}

	@Override
	public String getName(){
		return "%enchantment.protect." + this.name;
	}

	public double getTypeModifier(){
		return 0;
	}

	@Override
	public boolean isMajor(){
		return true;
	}

	public enum TYPE{
		ALL,
		FIRE,
		FALL,
		EXPLOSION,
		PROJECTILE
	}

}
