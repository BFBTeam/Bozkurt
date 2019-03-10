package tr.bozkurt.level.particle;

import tr.bozkurt.block.Block;
import tr.bozkurt.level.GlobalBlockPalette;
import tr.bozkurt.math.Vector3;
import tr.bozkurt.network.protocol.DataPacket;
import tr.bozkurt.network.protocol.LevelEventPacket;

/**
 * Created on 2015/11/21 by xtypr.
 * Package tr.bozkurt.level.particle in project Bozkurt.
 */
public class DestroyBlockParticle extends Particle{

	protected final int data;

	public DestroyBlockParticle(Vector3 pos, Block block){
		super(pos.x, pos.y, pos.z);
		this.data = GlobalBlockPalette.getOrCreateRuntimeId(block.getId(), block.getDamage());
	}

	@Override
	public DataPacket[] encode(){
		LevelEventPacket pk = new LevelEventPacket();
		pk.evid = LevelEventPacket.EVENT_PARTICLE_DESTROY;
		pk.x = (float) this.x;
		pk.y = (float) this.y;
		pk.z = (float) this.z;
		pk.data = this.data;

		return new DataPacket[]{pk};
	}

}
