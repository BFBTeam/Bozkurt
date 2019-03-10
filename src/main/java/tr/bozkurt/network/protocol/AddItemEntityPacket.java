package tr.bozkurt.network.protocol;

import tr.bozkurt.entity.data.EntityMetadata;
import tr.bozkurt.item.Item;
import tr.bozkurt.utils.Binary;

/**
 * Bozkurt Project
 */
public class AddItemEntityPacket extends DataPacket{

	public static final byte NETWORK_ID = ProtocolInfo.ADD_ITEM_ENTITY_PACKET;
	public long entityUniqueId;
	public long entityRuntimeId;
	public Item item;
	public float x;
	public float y;
	public float z;
	public float speedX;
	public float speedY;
	public float speedZ;
	public EntityMetadata metadata = new EntityMetadata();
	public boolean isFromFishing = false;

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
		this.putEntityUniqueId(this.entityUniqueId);
		this.putEntityRuntimeId(this.entityRuntimeId);
		this.putSlot(this.item);
		this.putVector3f(this.x, this.y, this.z);
		this.putVector3f(this.speedX, this.speedY, this.speedZ);
		this.put(Binary.writeMetadata(metadata));
		this.putBoolean(this.isFromFishing);
	}

}
