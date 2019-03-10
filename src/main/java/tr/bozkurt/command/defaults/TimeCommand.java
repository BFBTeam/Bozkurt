package tr.bozkurt.command.defaults;

import tr.bozkurt.Player;
import tr.bozkurt.command.Command;
import tr.bozkurt.command.CommandSender;
import tr.bozkurt.command.data.CommandParameter;
import tr.bozkurt.lang.TranslationContainer;
import tr.bozkurt.level.Level;
import tr.bozkurt.utils.TextFormat;

/**
 * Created on 2015/11/11 by xtypr.
 * Package tr.bozkurt.command.defaults in project Bozkurt.
 */
public class TimeCommand extends VanillaCommand{

	public TimeCommand(String name){
		super(name, "%bozkurt.command.time.description", "%bozkurt.command.time.usage");
		this.setPermission("bozkurt.command.time.add;" +
				"bozkurt.command.time.set;" +
				"bozkurt.command.time.start;" +
				"bozkurt.command.time.stop");
		this.commandParameters.clear();
		this.commandParameters.put("1arg", new CommandParameter[]{
				new CommandParameter("start|stop", CommandParameter.ARG_TYPE_STRING, false)
		});
		this.commandParameters.put("2args", new CommandParameter[]{
				new CommandParameter("add|set", CommandParameter.ARG_TYPE_STRING, false),
				new CommandParameter("value", CommandParameter.ARG_TYPE_INT, false)
		});
		this.commandParameters.put("2args_", new CommandParameter[]{
				new CommandParameter("add|set", CommandParameter.ARG_TYPE_STRING, false),
				new CommandParameter("value", CommandParameter.ARG_TYPE_STRING, false)
		});
	}

	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args){
		if(args.length < 1){
			sender.sendMessage(new TranslationContainer("commands.generic.usage", this.usageMessage));

			return false;
		}

		if("start".equals(args[0])){
			if(!sender.hasPermission("bozkurt.command.time.start")){
				sender.sendMessage(new TranslationContainer(TextFormat.RED + "%commands.generic.permission"));

				return true;
			}
			for(Level level : sender.getServer().getLevels().values()){
				level.checkTime();
				level.startTime();
				level.checkTime();
			}
			Command.broadcastCommandMessage(sender, "Restarted the time");
			return true;
		}else if("stop".equals(args[0])){
			if(!sender.hasPermission("bozkurt.command.time.stop")){
				sender.sendMessage(new TranslationContainer(TextFormat.RED + "%commands.generic.permission"));

				return true;
			}
			for(Level level : sender.getServer().getLevels().values()){
				level.checkTime();
				level.stopTime();
				level.checkTime();
			}
			Command.broadcastCommandMessage(sender, "Stopped the time");
			return true;
		}else if("query".equals(args[0])){
			if(!sender.hasPermission("bozkurt.command.time.query")){
				sender.sendMessage(new TranslationContainer(TextFormat.RED + "%commands.generic.permission"));

				return true;
			}
			Level level;
			if(sender instanceof Player){
				level = ((Player) sender).getLevel();
			}else{
				level = sender.getServer().getDefaultLevel();
			}
			sender.sendMessage(new TranslationContainer("commands.time.query", String.valueOf(level.getTime())));
			return true;
		}


		if(args.length < 2){
			sender.sendMessage(new TranslationContainer("commands.generic.usage", this.usageMessage));

			return false;
		}

		if("set".equals(args[0])){
			if(!sender.hasPermission("bozkurt.command.time.set")){
				sender.sendMessage(new TranslationContainer(TextFormat.RED + "%commands.generic.permission"));

				return true;
			}

			int value;
			if("day".equals(args[1])){
				value = Level.TIME_DAY;
			}else if("night".equals(args[1])){
				value = Level.TIME_NIGHT;
			}else if("midnight".equals(args[1])){
				value = Level.TIME_MIDNIGHT;
			}else if("noon".equals(args[1])){
				value = Level.TIME_NOON;
			}else if("sunrise".equals(args[1])){
				value = Level.TIME_SUNRISE;
			}else if("sunset".equals(args[1])){
				value = Level.TIME_SUNSET;
			}else{
				try{
					value = Math.max(0, Integer.parseInt(args[1]));
				}catch(Exception e){
					sender.sendMessage(new TranslationContainer("commands.generic.usage", this.usageMessage));
					return true;
				}
			}

			for(Level level : sender.getServer().getLevels().values()){
				level.checkTime();
				level.setTime(value);
				level.checkTime();
			}
			Command.broadcastCommandMessage(sender, new TranslationContainer("commands.time.set", String.valueOf(value)));
		}else if("add".equals(args[0])){
			if(!sender.hasPermission("bozkurt.command.time.add")){
				sender.sendMessage(new TranslationContainer(TextFormat.RED + "%commands.generic.permission"));

				return true;
			}

			int value;
			try{
				value = Math.max(0, Integer.parseInt(args[1]));
			}catch(Exception e){
				sender.sendMessage(new TranslationContainer("commands.generic.usage", this.usageMessage));
				return true;
			}

			for(Level level : sender.getServer().getLevels().values()){
				level.checkTime();
				level.setTime(level.getTime() + value);
				level.checkTime();
			}
			Command.broadcastCommandMessage(sender, new TranslationContainer("commands.time.added", String.valueOf(value)));
		}else{
			sender.sendMessage(new TranslationContainer("commands.generic.usage", this.usageMessage));
		}

		return true;
	}

}
