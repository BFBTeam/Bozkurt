package tr.bozkurt.level.particle;

import tr.bozkurt.math.Vector3;

/**
 * Created on 2015/11/21 by xtypr.
 * Package tr.bozkurt.level.particle in project Bozkurt.
 */
public class CriticalParticle extends GenericParticle{

	public CriticalParticle(Vector3 pos){
		this(pos, 2);
	}

	public CriticalParticle(Vector3 pos, int scale){
		super(pos, Particle.TYPE_CRITICAL, scale);
	}

}
