package tr.bozkurt.level.particle;

import tr.bozkurt.block.Block;
import tr.bozkurt.level.GlobalBlockPalette;
import tr.bozkurt.math.BlockFace;
import tr.bozkurt.math.Vector3;
import tr.bozkurt.network.protocol.DataPacket;
import tr.bozkurt.network.protocol.LevelEventPacket;

public class PunchBlockParticle extends Particle{

	protected final int data;

	public PunchBlockParticle(Vector3 pos, Block block, BlockFace face){
		this(pos, block.getId(), block.getDamage(), face);
	}

	public PunchBlockParticle(Vector3 pos, int blockId, int blockDamage, BlockFace face){
		super(pos.x, pos.y, pos.z);
		this.data = GlobalBlockPalette.getOrCreateRuntimeId(blockId, blockDamage) | (face.getIndex() << 24);
	}

	@Override
	public DataPacket[] encode(){
		LevelEventPacket pk = new LevelEventPacket();
		pk.evid = LevelEventPacket.EVENT_PARTICLE_PUNCH_BLOCK;
		pk.x = (float) this.x;
		pk.y = (float) this.y;
		pk.z = (float) this.z;
		pk.data = this.data;

		return new DataPacket[]{pk};
	}

}
