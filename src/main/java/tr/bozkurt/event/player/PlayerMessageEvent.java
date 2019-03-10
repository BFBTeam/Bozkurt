package tr.bozkurt.event.player;

/**
 * Created on 2015/12/23 by xtypr.
 * Package tr.bozkurt.event.player in project Bozkurt.
 */
public abstract class PlayerMessageEvent extends PlayerEvent{

	protected String message;

	public String getMessage(){
		return this.message;
	}

	public void setMessage(String message){
		this.message = message;
	}

}
