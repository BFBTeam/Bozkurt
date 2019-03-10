package tr.bozkurt.level.particle;

import tr.bozkurt.block.Block;
import tr.bozkurt.level.GlobalBlockPalette;
import tr.bozkurt.math.Vector3;

/**
 * Created on 2015/11/21 by xtypr.
 * Package tr.bozkurt.level.particle in project Bozkurt.
 */
public class TerrainParticle extends GenericParticle{

	public TerrainParticle(Vector3 pos, Block block){
		super(pos, Particle.TYPE_TERRAIN, GlobalBlockPalette.getOrCreateRuntimeId(block.getDamage(), block.getId()));
	}

}
