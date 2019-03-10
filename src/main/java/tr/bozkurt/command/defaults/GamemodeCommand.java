package tr.bozkurt.command.defaults;

import tr.bozkurt.Player;
import tr.bozkurt.Server;
import tr.bozkurt.command.Command;
import tr.bozkurt.command.CommandSender;
import tr.bozkurt.command.data.CommandParameter;
import tr.bozkurt.lang.TranslationContainer;
import tr.bozkurt.utils.TextFormat;

/**
 * Created on 2015/11/13 by xtypr.
 * Package tr.bozkurt.command.defaults in project Bozkurt.
 */
public class GamemodeCommand extends VanillaCommand{

	public GamemodeCommand(String name){
		super(name, "%bozkurt.command.gamemode.description", "%commands.gamemode.usage",
				new String[]{"gm"});
		this.setPermission("bozkurt.command.gamemode.survival;" +
				"bozkurt.command.gamemode.creative;" +
				"bozkurt.command.gamemode.adventure;" +
				"bozkurt.command.gamemode.spectator;" +
				"bozkurt.command.gamemode.other");
		this.commandParameters.clear();
		this.commandParameters.put("default", new CommandParameter[]{
				new CommandParameter("mode", CommandParameter.ARG_TYPE_INT, false),
				new CommandParameter("player", CommandParameter.ARG_TYPE_TARGET, true)
		});
		this.commandParameters.put("byString", new CommandParameter[]{
				new CommandParameter("mode", new String[]{"survival", "s", "creative", "c",
						"adventure", "a", "spectator", "spc", "view", "v"}),
				new CommandParameter("player", CommandParameter.ARG_TYPE_TARGET, true)
		});
	}

	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args){
		if(args.length == 0){
			sender.sendMessage(new TranslationContainer("commands.generic.usage", this.usageMessage));
			return false;
		}

		int gameMode = Server.getGamemodeFromString(args[0]);
		if(gameMode == -1){
			sender.sendMessage("Unknown game mode");
			return true;
		}

		CommandSender target = sender;
		if(args.length > 1){
			if(sender.hasPermission("bozkurt.command.gamemode.other")){
				target = sender.getServer().getPlayer(args[1]);
				if(target == null){
					sender.sendMessage(new TranslationContainer(TextFormat.RED + "%commands.generic.player.notFound"));
					return true;
				}
			}else{
				sender.sendMessage(new TranslationContainer(TextFormat.RED + "%commands.generic.permission"));
				return true;
			}
		}else if(!(sender instanceof Player)){
			sender.sendMessage(new TranslationContainer("commands.generic.usage", this.usageMessage));
			return true;
		}

		if((gameMode == 0 && !sender.hasPermission("bozkurt.command.gamemode.survival")) ||
				(gameMode == 1 && !sender.hasPermission("bozkurt.command.gamemode.creative")) ||
				(gameMode == 2 && !sender.hasPermission("bozkurt.command.gamemode.adventure")) ||
				(gameMode == 3 && !sender.hasPermission("bozkurt.command.gamemode.spectator"))){
			sender.sendMessage(new TranslationContainer(TextFormat.RED + "%commands.generic.permission"));
			return true;
		}

		if(!((Player) target).setGamemode(gameMode)){
			sender.sendMessage("Game mode update for " + target.getName() + " failed");
		}else{
			if(target.equals(sender)){
				Command.broadcastCommandMessage(sender, new TranslationContainer("commands.gamemode.success.self", Server.getGamemodeString(gameMode)));
			}else{
				target.sendMessage(new TranslationContainer("gameMode.changed"));
				Command.broadcastCommandMessage(sender, new TranslationContainer("commands.gamemode.success.other", new String[]{target.getName(), Server.getGamemodeString(gameMode)}));
			}
		}

		return true;
	}

}
