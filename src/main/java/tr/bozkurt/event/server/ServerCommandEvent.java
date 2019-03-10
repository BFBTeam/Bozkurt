package tr.bozkurt.event.server;

import tr.bozkurt.command.CommandSender;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;

/**
 * Bozkurt Project
 */
public class ServerCommandEvent extends ServerEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	protected final CommandSender sender;
	protected String command;

	public ServerCommandEvent(CommandSender sender, String command){
		this.sender = sender;
		this.command = command;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public CommandSender getSender(){
		return sender;
	}

	public String getCommand(){
		return command;
	}

	public void setCommand(String command){
		this.command = command;
	}

}
