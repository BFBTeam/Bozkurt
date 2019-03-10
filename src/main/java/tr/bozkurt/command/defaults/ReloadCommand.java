package tr.bozkurt.command.defaults;

import tr.bozkurt.command.Command;
import tr.bozkurt.command.CommandSender;
import tr.bozkurt.lang.TranslationContainer;
import tr.bozkurt.utils.TextFormat;

/**
 * Bozkurt Project
 */
public class ReloadCommand extends VanillaCommand{

	public ReloadCommand(String name){
		super(name, "%bozkurt.command.reload.description", "%commands.reload.usage");
		this.setPermission("bozkurt.command.reload");
		this.commandParameters.clear();
	}

	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args){
		if(!this.testPermission(sender)){
			return true;
		}

		Command.broadcastCommandMessage(sender, new TranslationContainer(TextFormat.YELLOW + "%bozkurt.command.reload.reloading" + TextFormat.WHITE));

		sender.getServer().reload();

		Command.broadcastCommandMessage(sender, new TranslationContainer(TextFormat.YELLOW + "%bozkurt.command.reload.reloaded" + TextFormat.WHITE));

		return true;
	}

}
