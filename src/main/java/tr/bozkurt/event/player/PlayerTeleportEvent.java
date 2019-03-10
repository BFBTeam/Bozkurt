package tr.bozkurt.event.player;

import tr.bozkurt.Player;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;
import tr.bozkurt.level.Level;
import tr.bozkurt.level.Location;
import tr.bozkurt.level.Position;
import tr.bozkurt.math.Vector3;

public class PlayerTeleportEvent extends PlayerEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	private TeleportCause cause;
	private Location from;
	private Location to;

	private PlayerTeleportEvent(Player player){
		this.player = player;
	}

	public PlayerTeleportEvent(Player player, Location from, Location to, TeleportCause cause){
		this(player);
		this.from = from;
		this.to = to;
		this.cause = cause;
	}

	public PlayerTeleportEvent(Player player, Vector3 from, Vector3 to, TeleportCause cause){
		this(player);
		this.from = vectorToLocation(player.getLevel(), from);
		this.from = vectorToLocation(player.getLevel(), to);
		this.cause = cause;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public Location getFrom(){
		return from;
	}

	public Location getTo(){
		return to;
	}

	public TeleportCause getCause(){
		return cause;
	}

	private Location vectorToLocation(Level baseLevel, Vector3 vector){
		if(vector instanceof Location) return (Location) vector;
		if(vector instanceof Position) return ((Position) vector).getLocation();
		return new Location(vector.getX(), vector.getY(), vector.getZ(), 0, 0, baseLevel);
	}


	public enum TeleportCause{
		COMMAND,       // For Bozkurt tp command only
		PLUGIN,        // Every plugin
		NETHER_PORTAL, // Teleport using Nether portal
		ENDER_PEARL,   // Teleport by ender pearl
		UNKNOWN        // Unknown cause
	}

}
