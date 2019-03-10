package tr.bozkurt.level.particle;

import tr.bozkurt.math.Vector3;

/**
 * Created on 2015/11/21 by xtypr.
 * Package tr.bozkurt.level.particle in project Bozkurt.
 */
public class SplashParticle extends GenericParticle{

	public SplashParticle(Vector3 pos){
		super(pos, Particle.TYPE_WATER_SPLASH);
	}

}
