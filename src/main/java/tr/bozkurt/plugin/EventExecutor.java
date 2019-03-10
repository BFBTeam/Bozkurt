package tr.bozkurt.plugin;

import tr.bozkurt.event.Event;
import tr.bozkurt.event.Listener;
import tr.bozkurt.utils.EventException;

/**
 * author: iNevet
 * Bozkurt Project
 */
public interface EventExecutor{

	void execute(Listener listener, Event event) throws EventException;

}
