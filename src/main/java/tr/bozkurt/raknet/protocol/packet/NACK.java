package tr.bozkurt.raknet.protocol.packet;

import tr.bozkurt.raknet.protocol.AcknowledgePacket;
import tr.bozkurt.raknet.protocol.Packet;

/**
 * Bozkurt Project
 */
public class NACK extends AcknowledgePacket{

	public static final byte ID = (byte) 0xa0;

	@Override
	public byte getID(){
		return ID;
	}

	public static final class Factory implements Packet.PacketFactory{

		@Override
		public Packet create(){
			return new NACK();
		}

	}

}
