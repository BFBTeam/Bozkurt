package tr.bozkurt.command.defaults;

import tr.bozkurt.Player;
import tr.bozkurt.command.CommandSender;
import tr.bozkurt.lang.TranslationContainer;

/**
 * Created on 2015/11/11 by xtypr.
 * Package tr.bozkurt.command.defaults in project Bozkurt.
 */
public class ListCommand extends VanillaCommand{

	public ListCommand(String name){
		super(name, "%bozkurt.command.list.description", "%commands.players.usage");
		this.setPermission("bozkurt.command.list");
		this.commandParameters.clear();
	}

	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args){
		if(!this.testPermission(sender)){
			return true;
		}
		String online = "";
		int onlineCount = 0;
		for(Player player : sender.getServer().getOnlinePlayers().values()){
			if(player.isOnline() && (!(sender instanceof Player) || ((Player) sender).canSee(player))){
				online += player.getDisplayName() + ", ";
				++onlineCount;
			}
		}

		if(online.length() > 0){
			online = online.substring(0, online.length() - 2);
		}

		sender.sendMessage(new TranslationContainer("commands.players.list",
				new String[]{String.valueOf(onlineCount), String.valueOf(sender.getServer().getMaxPlayers())}));
		sender.sendMessage(online);
		return true;
	}

}
