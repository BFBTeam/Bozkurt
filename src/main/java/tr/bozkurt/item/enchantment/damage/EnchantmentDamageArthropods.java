package tr.bozkurt.item.enchantment.damage;

import tr.bozkurt.entity.Entity;
import tr.bozkurt.entity.EntityArthropod;
import tr.bozkurt.potion.Effect;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Bozkurt Project
 */
public class EnchantmentDamageArthropods extends EnchantmentDamage{

	public EnchantmentDamageArthropods(){
		super(ID_DAMAGE_ARTHROPODS, "arthropods", 5, TYPE.SMITE);
	}

	@Override
	public int getMinEnchantAbility(int level){
		return 5 + (level - 1) * 8;
	}

	@Override
	public int getMaxEnchantAbility(int level){
		return this.getMinEnchantAbility(level) + 20;
	}

	@Override
	public double getDamageBonus(Entity entity){
		if(entity instanceof EntityArthropod){
			return getLevel() * 2.5;
		}

		return 0;
	}

	@Override
	public void doPostAttack(Entity attacker, Entity entity){
		if(entity instanceof EntityArthropod){
			int duration = 20 + ThreadLocalRandom.current().nextInt(10 * this.level);
			entity.addEffect(Effect.getEffect(Effect.SLOWNESS).setDuration(duration).setAmplifier(3));
		}
	}

}
