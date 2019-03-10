package tr.bozkurt.network.protocol;

import tr.bozkurt.entity.data.EntityMetadata;
import tr.bozkurt.utils.Binary;

/**
 * Bozkurt Project
 */
public class SetEntityDataPacket extends DataPacket{

	public static final byte NETWORK_ID = ProtocolInfo.SET_ENTITY_DATA_PACKET;
	public long eid;
	public EntityMetadata metadata;

	@Override
	public byte pid(){
		return NETWORK_ID;
	}

	@Override
	public void decode(){

	}

	@Override
	public void encode(){
		this.reset();
		this.putEntityRuntimeId(this.eid);
		this.put(Binary.writeMetadata(this.metadata));
	}

}
