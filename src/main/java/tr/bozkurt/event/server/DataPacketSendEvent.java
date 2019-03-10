package tr.bozkurt.event.server;

import tr.bozkurt.Player;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;
import tr.bozkurt.network.protocol.DataPacket;

/**
 * Bozkurt Project
 */
public class DataPacketSendEvent extends ServerEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	private final DataPacket packet;
	private final Player player;

	public DataPacketSendEvent(Player player, DataPacket packet){
		this.packet = packet;
		this.player = player;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public Player getPlayer(){
		return player;
	}

	public DataPacket getPacket(){
		return packet;
	}

}
