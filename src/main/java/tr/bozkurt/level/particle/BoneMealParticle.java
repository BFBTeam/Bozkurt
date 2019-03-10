package tr.bozkurt.level.particle;

import tr.bozkurt.math.Vector3;
import tr.bozkurt.network.protocol.DataPacket;
import tr.bozkurt.network.protocol.LevelEventPacket;

/**
 * Created by CreeperFace on 15.4.2017.
 */
public class BoneMealParticle extends Particle{

	private Vector3 position;

	public BoneMealParticle(Vector3 pos){
		super(pos.x, pos.y, pos.z);
	}

	@Override
	public DataPacket[] encode(){
		LevelEventPacket pk = new LevelEventPacket();
		pk.evid = LevelEventPacket.EVENT_PARTICLE_BONEMEAL;
		pk.x = (float) this.x;
		pk.y = (float) this.y;
		pk.z = (float) this.z;
		pk.data = 0;

		return new DataPacket[]{pk};
	}

}
