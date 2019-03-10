package tr.bozkurt.command.defaults;

import tr.bozkurt.Player;
import tr.bozkurt.command.Command;
import tr.bozkurt.command.CommandSender;
import tr.bozkurt.command.data.CommandParameter;
import tr.bozkurt.lang.TranslationContainer;
import tr.bozkurt.level.Level;

/**
 * author: Angelic47
 * Bozkurt Project
 */
public class WeatherCommand extends VanillaCommand{

	private java.util.Random rand = new java.util.Random();

	public WeatherCommand(String name){
		super(name, "%bozkurt.command.weather.description", "%commands.weather.usage");
		this.setPermission("bozkurt.command.weather");
		this.commandParameters.clear();
		this.commandParameters.put("default", new CommandParameter[]{
				new CommandParameter("clear|rain|thunder", CommandParameter.ARG_TYPE_STRING, false),
				new CommandParameter("duration in seconds", CommandParameter.ARG_TYPE_INT, true)
		});
	}

	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args){
		if(!this.testPermission(sender)){
			return true;
		}
		if(args.length == 0 || args.length > 2){
			sender.sendMessage(new TranslationContainer("commands.weather.usage", this.usageMessage));
			return false;
		}

		String weather = args[0];
		Level level;
		int seconds;
		if(args.length > 1){
			try{
				seconds = Integer.parseInt(args[1]);
			}catch(Exception e){
				sender.sendMessage(new TranslationContainer("commands.generic.usage", this.usageMessage));
				return true;
			}
		}else{
			seconds = 600 * 20;
		}

		if(sender instanceof Player){
			level = ((Player) sender).getLevel();
		}else{
			level = sender.getServer().getDefaultLevel();
		}

		switch(weather){
			case "clear":
				level.setRaining(false);
				level.setThundering(false);
				level.setRainTime(seconds * 20);
				level.setThunderTime(seconds * 20);
				Command.broadcastCommandMessage(sender,
						new TranslationContainer("commands.weather.clear"));
				return true;
			case "rain":
				level.setRaining(true);
				level.setRainTime(seconds * 20);
				Command.broadcastCommandMessage(sender,
						new TranslationContainer("commands.weather.rain"));
				return true;
			case "thunder":
				level.setThundering(true);
				level.setRainTime(seconds * 20);
				level.setThunderTime(seconds * 20);
				Command.broadcastCommandMessage(sender,
						new TranslationContainer("commands.weather.thunder"));
				return true;
			default:
				sender.sendMessage(new TranslationContainer("commands.weather.usage", this.usageMessage));
				return false;
		}

	}

}
