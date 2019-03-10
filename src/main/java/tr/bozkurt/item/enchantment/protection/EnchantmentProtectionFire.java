package tr.bozkurt.item.enchantment.protection;

import tr.bozkurt.event.entity.EntityDamageEvent;
import tr.bozkurt.event.entity.EntityDamageEvent.DamageCause;

/**
 * Bozkurt Project
 */
public class EnchantmentProtectionFire extends EnchantmentProtection{

	public EnchantmentProtectionFire(){
		super(ID_PROTECTION_FIRE, "fire", 5, TYPE.FIRE);
	}

	@Override
	public int getMinEnchantAbility(int level){
		return 10 + (level - 1) * 8;
	}

	@Override
	public int getMaxEnchantAbility(int level){
		return this.getMinEnchantAbility(level) + 12;
	}

	@Override
	public double getTypeModifier(){
		return 2;
	}

	@Override
	public float getDamageProtection(EntityDamageEvent e){
		DamageCause cause = e.getCause();

		if(level <= 0 || (cause != DamageCause.LAVA && cause != DamageCause.FIRE && cause != DamageCause.FIRE_TICK)){
			return 0;
		}

		return (float) (getLevel() * getTypeModifier());
	}

}
