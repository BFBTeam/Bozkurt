package tr.bozkurt.network.protocol;

/**
 * Bozkurt Project
 */
public class ShowProfilePacket extends DataPacket{

	public static final byte NETWORK_ID = ProtocolInfo.SHOW_PROFILE_PACKET;

	public String xuid;

	@Override
	public byte pid(){
		return NETWORK_ID;
	}

	@Override
	public void decode(){
		this.xuid = this.getString();
	}

	@Override
	public void encode(){
		this.reset();
		this.putString(this.xuid);
	}

}
