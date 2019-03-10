package tr.bozkurt.event.weather;

import tr.bozkurt.entity.weather.EntityLightningStrike;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;
import tr.bozkurt.level.Level;

/**
 * author: funcraft
 * Bozkurt Project
 */
public class LightningStrikeEvent extends WeatherEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	private final EntityLightningStrike bolt;

	public LightningStrikeEvent(Level level, final EntityLightningStrike bolt){
		super(level);
		this.bolt = bolt;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	/**
	 * Gets the bolt which is striking the earth.
	 *
	 * @return lightning entity
	 */
	public EntityLightningStrike getLightning(){
		return bolt;
	}

}
