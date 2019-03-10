package tr.bozkurt.level.particle;

import tr.bozkurt.math.Vector3;

/**
 * Created on 2015/11/21 by xtypr.
 * Package tr.bozkurt.level.particle in project Bozkurt.
 */
public class EntityFlameParticle extends GenericParticle{

	public EntityFlameParticle(Vector3 pos){
		super(pos, Particle.TYPE_MOB_FLAME);
	}

}
