package tr.bozkurt.command.defaults;

import tr.bozkurt.command.Command;
import tr.bozkurt.command.CommandSender;
import tr.bozkurt.lang.TranslationContainer;

/**
 * Created on 2015/11/13 by xtypr.
 * Package tr.bozkurt.command.defaults in project Bozkurt.
 */
public class SaveOnCommand extends VanillaCommand{

	public SaveOnCommand(String name){
		super(name, "%bozkurt.command.saveon.description", "%commands.save-on.usage");
		this.setPermission("bozkurt.command.save.enable");
		this.commandParameters.clear();
	}

	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args){
		if(!this.testPermission(sender)){
			return true;
		}
		sender.getServer().setAutoSave(true);
		Command.broadcastCommandMessage(sender, new TranslationContainer("commands.save.enabled"));
		return true;
	}

}
