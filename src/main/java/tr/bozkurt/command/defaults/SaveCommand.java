package tr.bozkurt.command.defaults;

import tr.bozkurt.Player;
import tr.bozkurt.command.Command;
import tr.bozkurt.command.CommandSender;
import tr.bozkurt.lang.TranslationContainer;
import tr.bozkurt.level.Level;

/**
 * Created on 2015/11/13 by xtypr.
 * Package tr.bozkurt.command.defaults in project Bozkurt.
 */
public class SaveCommand extends VanillaCommand{

	public SaveCommand(String name){
		super(name, "%bozkurt.command.save.description", "%commands.save.usage");
		this.setPermission("bozkurt.command.save.perform");
		this.commandParameters.clear();
	}

	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args){
		if(!this.testPermission(sender)){
			return true;
		}

		Command.broadcastCommandMessage(sender, new TranslationContainer("commands.save.start"));

		for(Player player : sender.getServer().getOnlinePlayers().values()){
			player.save();
		}

		for(Level level : sender.getServer().getLevels().values()){
			level.save(true);
		}

		Command.broadcastCommandMessage(sender, new TranslationContainer("commands.save.success"));
		return true;
	}

}
