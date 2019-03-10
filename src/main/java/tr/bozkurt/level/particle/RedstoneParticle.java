package tr.bozkurt.level.particle;

import tr.bozkurt.math.Vector3;

/**
 * Created on 2015/11/21 by xtypr.
 * Package tr.bozkurt.level.particle in project Bozkurt.
 */
public class RedstoneParticle extends GenericParticle{

	public RedstoneParticle(Vector3 pos){
		this(pos, 1);
	}

	public RedstoneParticle(Vector3 pos, int lifetime){
		super(pos, Particle.TYPE_REDSTONE, lifetime);
	}

}
