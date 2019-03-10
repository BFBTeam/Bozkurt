package tr.bozkurt.raknet.protocol.packet;

import tr.bozkurt.raknet.protocol.DataPacket;
import tr.bozkurt.raknet.protocol.Packet;

/**
 * Bozkurt Project
 */
public class DATA_PACKET_B extends DataPacket{

	public static final byte ID = (byte) 0x8b;

	@Override
	public byte getID(){
		return ID;
	}

	public static final class Factory implements Packet.PacketFactory{

		@Override
		public Packet create(){
			return new DATA_PACKET_B();
		}

	}

}
