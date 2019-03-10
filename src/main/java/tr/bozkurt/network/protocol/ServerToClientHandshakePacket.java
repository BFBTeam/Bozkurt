package tr.bozkurt.network.protocol;

public class ServerToClientHandshakePacket extends DataPacket{

	public String publicKey;
	public String serverToken;
	public String privateKey;

	@Override
	public byte pid(){
		return ProtocolInfo.SERVER_TO_CLIENT_HANDSHAKE_PACKET;
	}

	@Override
	public void decode(){

	}

	@Override
	public void encode(){
		//TODO
	}

}
