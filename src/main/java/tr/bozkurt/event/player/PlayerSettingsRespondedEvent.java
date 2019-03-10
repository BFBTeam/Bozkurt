package tr.bozkurt.event.player;

import tr.bozkurt.Player;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;
import tr.bozkurt.form.response.FormResponse;
import tr.bozkurt.form.window.FormWindow;

public class PlayerSettingsRespondedEvent extends PlayerEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	protected int formID;
	protected FormWindow window;
	protected boolean closed = false;

	public PlayerSettingsRespondedEvent(Player player, int formID, FormWindow window){
		this.player = player;
		this.formID = formID;
		this.window = window;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public int getFormID(){
		return this.formID;
	}

	public FormWindow getWindow(){
		return window;
	}

	/**
	 * Can be null if player closed the window instead of submitting it
	 *
	 * @return response
	 */
	public FormResponse getResponse(){
		return window.getResponse();
	}

	/**
	 * Defines if player closed the window or submitted it
	 *
	 * @return form closed
	 */
	public boolean wasClosed(){
		return window.wasClosed();
	}

	@Override
	public void setCancelled(){
		super.setCancelled();
	}

}
