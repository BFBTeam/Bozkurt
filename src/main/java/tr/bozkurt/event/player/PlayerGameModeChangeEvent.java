package tr.bozkurt.event.player;

import tr.bozkurt.AdventureSettings;
import tr.bozkurt.Player;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;

public class PlayerGameModeChangeEvent extends PlayerEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	protected final int gamemode;
	protected AdventureSettings newAdventureSettings;

	public PlayerGameModeChangeEvent(Player player, int newGameMode, AdventureSettings newAdventureSettings){
		this.player = player;
		this.gamemode = newGameMode;
		this.newAdventureSettings = newAdventureSettings;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public int getNewGamemode(){
		return gamemode;
	}

	public AdventureSettings getNewAdventureSettings(){
		return newAdventureSettings;
	}

	public void setNewAdventureSettings(AdventureSettings newAdventureSettings){
		this.newAdventureSettings = newAdventureSettings;
	}

}
