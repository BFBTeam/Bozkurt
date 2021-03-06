package tr.bozkurt.network.protocol;

import tr.bozkurt.item.Item;

/**
 * Bozkurt Project
 */
public class InventorySlotPacket extends DataPacket{

	public static final byte NETWORK_ID = ProtocolInfo.INVENTORY_SLOT_PACKET;
	public int inventoryId;
	public int slot;
	public Item item;

	@Override
	public byte pid(){
		return NETWORK_ID;
	}

	@Override
	public void decode(){
		this.inventoryId = (int) this.getUnsignedVarInt();
		this.slot = (int) this.getUnsignedVarInt();
		this.item = this.getSlot();
	}

	@Override
	public void encode(){
		this.reset();
		this.putUnsignedVarInt((byte) this.inventoryId);
		this.putUnsignedVarInt(this.slot);
		this.putSlot(this.item);
	}

}
