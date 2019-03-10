package tr.bozkurt.event.player;

import tr.bozkurt.Player;
import tr.bozkurt.event.Event;

/**
 * Bozkurt Project
 */
public abstract class PlayerEvent extends Event{

	protected Player player;

	public Player getPlayer(){
		return player;
	}

}
