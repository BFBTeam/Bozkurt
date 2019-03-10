package tr.bozkurt.command.defaults;

import tr.bozkurt.command.Command;
import tr.bozkurt.command.CommandSender;
import tr.bozkurt.lang.TranslationContainer;

/**
 * Created on 2015/11/13 by xtypr.
 * Package tr.bozkurt.command.defaults in project Bozkurt.
 */
public class SaveOffCommand extends VanillaCommand{

	public SaveOffCommand(String name){
		super(name, "%bozkurt.command.saveoff.description", "%commands.save-off.usage");
		this.setPermission("bozkurt.command.save.disable");
		this.commandParameters.clear();
	}

	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args){
		if(!this.testPermission(sender)){
			return true;
		}
		sender.getServer().setAutoSave(false);
		Command.broadcastCommandMessage(sender, new TranslationContainer("commands.save.disabled"));
		return true;
	}

}
