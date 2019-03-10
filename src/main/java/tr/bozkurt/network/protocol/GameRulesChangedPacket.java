package tr.bozkurt.network.protocol;

import tr.bozkurt.level.GameRules;

/**
 * Bozkurt Project
 */
public class GameRulesChangedPacket extends DataPacket{

	public static final byte NETWORK_ID = ProtocolInfo.GAME_RULES_CHANGED_PACKET;
	public GameRules gameRules;

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
		putGameRules(gameRules);
	}

}
