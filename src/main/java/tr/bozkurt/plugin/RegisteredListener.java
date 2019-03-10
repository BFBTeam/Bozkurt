package tr.bozkurt.plugin;

import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.Event;
import tr.bozkurt.event.EventPriority;
import tr.bozkurt.event.Listener;
import tr.bozkurt.utils.EventException;

public class RegisteredListener{

	private final Listener listener;

	private final EventPriority priority;

	private final Plugin plugin;

	private final EventExecutor executor;

	private final boolean ignoreCancelled;

	public RegisteredListener(Listener listener, EventExecutor executor, EventPriority priority, Plugin plugin, boolean ignoreCancelled){
		this.listener = listener;
		this.priority = priority;
		this.plugin = plugin;
		this.executor = executor;
		this.ignoreCancelled = ignoreCancelled;
	}

	public Listener getListener(){
		return listener;
	}

	public Plugin getPlugin(){
		return plugin;
	}

	public EventPriority getPriority(){
		return priority;
	}

	public void callEvent(Event event) throws EventException{
		if(event instanceof Cancellable){
			if(event.isCancelled() && isIgnoringCancelled()){
				return;
			}
		}

		executor.execute(listener, event);
	}

	public boolean isIgnoringCancelled(){
		return ignoreCancelled;
	}

}
