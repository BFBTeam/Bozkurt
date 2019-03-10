package tr.bozkurt.event.weather;

import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;
import tr.bozkurt.level.Level;

/**
 * author: funcraft
 * Bozkurt Project
 */
public class WeatherChangeEvent extends WeatherEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();

	private final boolean to;

	public WeatherChangeEvent(Level level, boolean to){
		super(level);
		this.to = to;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	/**
	 * Gets the state of weather that the world is being set to
	 *
	 * @return true if the weather is being set to raining, false otherwise
	 */
	public boolean toWeatherState(){
		return to;
	}

}
