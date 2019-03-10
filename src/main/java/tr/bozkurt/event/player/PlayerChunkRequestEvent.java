package tr.bozkurt.event.player;

import tr.bozkurt.Player;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;

public class PlayerChunkRequestEvent extends PlayerEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	private final int chunkX;
	private final int chunkZ;

	public PlayerChunkRequestEvent(Player player, int chunkX, int chunkZ){
		this.player = player;
		this.chunkX = chunkX;
		this.chunkZ = chunkZ;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public int getChunkX(){
		return chunkX;
	}

	public int getChunkZ(){
		return chunkZ;
	}

}
