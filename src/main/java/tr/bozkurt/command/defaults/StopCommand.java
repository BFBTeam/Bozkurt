package tr.bozkurt.command.defaults;

import tr.bozkurt.command.Command;
import tr.bozkurt.command.CommandSender;
import tr.bozkurt.lang.TranslationContainer;

/**
 * Bozkurt Project
 */
public class StopCommand extends VanillaCommand{

	public StopCommand(String name){
		super(name, "%bozkurt.command.stop.description", "%commands.stop.usage");
		this.setPermission("bozkurt.command.stop");
		this.commandParameters.clear();
	}

	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args){
		if(!this.testPermission(sender)){
			return true;
		}

		Command.broadcastCommandMessage(sender, new TranslationContainer("commands.stop.start"));

		sender.getServer().shutdown();

		return true;
	}

}
