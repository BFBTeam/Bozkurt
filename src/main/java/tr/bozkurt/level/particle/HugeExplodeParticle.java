package tr.bozkurt.level.particle;

import tr.bozkurt.math.Vector3;

/**
 * Created on 2015/11/21 by xtypr.
 * Package tr.bozkurt.level.particle in project Bozkurt.
 */
public class HugeExplodeParticle extends GenericParticle{

	public HugeExplodeParticle(Vector3 pos){
		super(pos, Particle.TYPE_HUGE_EXPLODE);
	}

}
