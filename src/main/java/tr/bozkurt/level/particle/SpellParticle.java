package tr.bozkurt.level.particle;

import tr.bozkurt.math.Vector3;
import tr.bozkurt.network.protocol.DataPacket;
import tr.bozkurt.network.protocol.LevelEventPacket;
import tr.bozkurt.utils.BlockColor;

/**
 * Created on 2015/12/27 by xtypr.
 * Package tr.bozkurt.level.particle in project Bozkurt.
 * The name "spell" comes from minecraft wiki.
 */
public class SpellParticle extends Particle{

	protected final int data;

	public SpellParticle(Vector3 pos){
		this(pos, 0);
	}

	public SpellParticle(Vector3 pos, int data){
		super(pos.x, pos.y, pos.z);
		this.data = data;
	}

	public SpellParticle(Vector3 pos, BlockColor blockColor){
		//alpha is ignored
		this(pos, blockColor.getRed(), blockColor.getGreen(), blockColor.getBlue());
	}

	public SpellParticle(Vector3 pos, int r, int g, int b){
		this(pos, r, g, b, 0x00);
	}

	protected SpellParticle(Vector3 pos, int r, int g, int b, int a){
		this(pos, ((a & 0xff) << 24) | ((r & 0xff) << 16) | ((g & 0xff) << 8) | (b & 0xff));
	}

	@Override
	public DataPacket[] encode(){
		LevelEventPacket pk = new LevelEventPacket();
		pk.evid = LevelEventPacket.EVENT_PARTICLE_SPLASH;
		pk.x = (float) this.x;
		pk.y = (float) this.y;
		pk.z = (float) this.z;
		pk.data = this.data;

		return new DataPacket[]{pk};
	}

}
