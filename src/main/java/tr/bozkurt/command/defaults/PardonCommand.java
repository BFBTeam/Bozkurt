package tr.bozkurt.command.defaults;

import tr.bozkurt.command.Command;
import tr.bozkurt.command.CommandSender;
import tr.bozkurt.command.data.CommandParameter;
import tr.bozkurt.lang.TranslationContainer;

/**
 * Bozkurt Project
 */
public class PardonCommand extends VanillaCommand{

	public PardonCommand(String name){
		super(name, "%bozkurt.command.unban.player.description", "%commands.unban.usage");
		this.setPermission("bozkurt.command.unban.player");
		this.setAliases(new String[]{"unban"});
		this.commandParameters.clear();
		this.commandParameters.put("default", new CommandParameter[]{
				new CommandParameter("player", CommandParameter.ARG_TYPE_TARGET, false)
		});
	}

	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args){
		if(!this.testPermission(sender)){
			return true;
		}

		if(args.length != 1){
			sender.sendMessage(new TranslationContainer("commands.generic.usage", this.usageMessage));

			return false;
		}

		sender.getServer().getNameBans().remove(args[0]);

		Command.broadcastCommandMessage(sender, new TranslationContainer("%commands.unban.success", args[0]));

		return true;
	}

}
