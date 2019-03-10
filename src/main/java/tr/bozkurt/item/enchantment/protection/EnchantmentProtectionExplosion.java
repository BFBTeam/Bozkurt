package tr.bozkurt.item.enchantment.protection;

import tr.bozkurt.event.entity.EntityDamageEvent;
import tr.bozkurt.event.entity.EntityDamageEvent.DamageCause;

/**
 * Bozkurt Project
 */
public class EnchantmentProtectionExplosion extends EnchantmentProtection{

	public EnchantmentProtectionExplosion(){
		super(ID_PROTECTION_EXPLOSION, "explosion", 2, TYPE.EXPLOSION);
	}

	@Override
	public int getMinEnchantAbility(int level){
		return 5 + (level - 1) * 8;
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

		if(level <= 0 || (cause != DamageCause.ENTITY_EXPLOSION && cause != DamageCause.BLOCK_EXPLOSION)){
			return 0;
		}

		return (float) (getLevel() * getTypeModifier());
	}

}
