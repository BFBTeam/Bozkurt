package tr.bozkurt.level.particle;

import tr.bozkurt.math.Vector3;
import tr.bozkurt.network.protocol.DataPacket;
import tr.bozkurt.network.protocol.LevelEventPacket;

/**
 * Created on 2015/11/21 by xtypr.
 * Package tr.bozkurt.level.particle in project Bozkurt.
 */
public class MobSpawnParticle extends Particle{

	protected final int width;
	protected final int height;

	public MobSpawnParticle(Vector3 pos, float width, float height){
		super(pos.x, pos.y, pos.z);
		this.width = (int) width;
		this.height = (int) height;
	}

	@Override
	public DataPacket[] encode(){
		LevelEventPacket packet = new LevelEventPacket();
		packet.evid = LevelEventPacket.EVENT_PARTICLE_SPAWN;
		packet.x = (float) this.x;
		packet.y = (float) this.y;
		packet.z = (float) this.z;
		packet.data = (this.width & 0xff) + ((this.height & 0xff) << 8);

		return new DataPacket[]{packet};
	}

}
