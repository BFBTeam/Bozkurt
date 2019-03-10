package tr.bozkurt.command.defaults;

import tr.bozkurt.Player;
import tr.bozkurt.command.CommandSender;
import tr.bozkurt.lang.TranslationContainer;

/**
 * Bozkurt Project
 */
public class SeedCommand extends VanillaCommand{

	public SeedCommand(String name){
		super(name, "%bozkurt.command.seed.description", "%commands.seed.usage");
		this.setPermission("bozkurt.command.seed");
		this.commandParameters.clear();
	}

	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args){
		if(!this.testPermission(sender)){
			return true;
		}

		long seed;
		if(sender instanceof Player){
			seed = ((Player) sender).getLevel().getSeed();
		}else{
			seed = sender.getServer().getDefaultLevel().getSeed();
		}

		sender.sendMessage(new TranslationContainer("commands.seed.success", String.valueOf(seed)));

		return true;
	}

}
