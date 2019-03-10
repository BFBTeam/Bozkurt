package tr.bozkurt.event.level;

import tr.bozkurt.event.Event;
import tr.bozkurt.level.Level;

/**
 * author: funcraft
 * Bozkurt Project
 */
public abstract class WeatherEvent extends Event{

	private final Level level;

	public WeatherEvent(Level level){
		this.level = level;
	}

	public Level getLevel(){
		return level;
	}

}
