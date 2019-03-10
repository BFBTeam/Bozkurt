package tr.bozkurt.level.particle;

import tr.bozkurt.item.Item;
import tr.bozkurt.math.Vector3;

/**
 * Created on 2015/11/21 by xtypr.
 * Package tr.bozkurt.level.particle in project Bozkurt.
 */
public class ItemBreakParticle extends GenericParticle{

	public ItemBreakParticle(Vector3 pos, Item item){
		super(pos, Particle.TYPE_ITEM_BREAK, (item.getId() << 16) | item.getDamage());
	}

}
