package tr.bozkurt.entity;

import tr.bozkurt.Player;

/**
 * Author: BeYkeRYkt
 * Bozkurt Project
 */
public interface EntityOwnable{

	String getOwnerName();

	void setOwnerName(String playerName);

	Player getOwner();

}
