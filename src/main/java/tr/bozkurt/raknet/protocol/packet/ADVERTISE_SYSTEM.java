package tr.bozkurt.raknet.protocol.packet;

import tr.bozkurt.raknet.protocol.Packet;

/**
 * Bozkurt Project
 */
public class ADVERTISE_SYSTEM extends UNCONNECTED_PONG{

	public static final byte ID = (byte) 0x1d;

	@Override
	public byte getID(){
		return ID;
	}

	public static final class Factory implements Packet.PacketFactory{

		@Override
		public Packet create(){
			return new ADVERTISE_SYSTEM();
		}

	}

}
