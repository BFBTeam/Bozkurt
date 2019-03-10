package tr.bozkurt.level.particle;

import tr.bozkurt.math.Vector3;

/**
 * Created on 2015/11/21 by xtypr.
 * Package tr.bozkurt.level.particle in project Bozkurt.
 */
public class SmokeParticle extends GenericParticle{

	public SmokeParticle(Vector3 pos){
		this(pos, 0);
	}

	public SmokeParticle(Vector3 pos, int scale){
		super(pos, Particle.TYPE_SMOKE, scale);
	}

}
