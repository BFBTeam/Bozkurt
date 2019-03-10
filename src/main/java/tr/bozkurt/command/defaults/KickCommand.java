package tr.bozkurt.command.defaults;

import tr.bozkurt.Player;
import tr.bozkurt.command.Command;
import tr.bozkurt.command.CommandSender;
import tr.bozkurt.command.data.CommandParameter;
import tr.bozkurt.event.player.PlayerKickEvent;
import tr.bozkurt.lang.TranslationContainer;
import tr.bozkurt.utils.TextFormat;

/**
 * Created on 2015/11/11 by xtypr.
 * Package tr.bozkurt.command.defaults in project Bozkurt.
 */
public class KickCommand extends VanillaCommand{

	public KickCommand(String name){
		super(name, "%bozkurt.command.kick.description", "%commands.kick.usage");
		this.setPermission("bozkurt.command.kick");
		this.commandParameters.clear();
		this.commandParameters.put("default", new CommandParameter[]{
				new CommandParameter("player", CommandParameter.ARG_TYPE_TARGET, false),
				new CommandParameter("reason", true)
		});
	}

	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args){
		if(!this.testPermission(sender)){
			return true;
		}
		if(args.length == 0){
			sender.sendMessage(new TranslationContainer("commands.generic.usage", this.usageMessage));
			return false;
		}

		String name = args[0];

		String reason = "";
		for(int i = 1; i < args.length; i++){
			reason += args[i] + " ";
		}

		if(reason.length() > 0){
			reason = reason.substring(0, reason.length() - 1);
		}

		Player player = sender.getServer().getPlayer(name);
		if(player != null){
			player.kick(PlayerKickEvent.Reason.KICKED_BY_ADMIN, reason);
			if(reason.length() >= 1){
				Command.broadcastCommandMessage(sender, new TranslationContainer("commands.kick.success.reason", new String[]{player.getName(), reason})
				);
			}else{
				Command.broadcastCommandMessage(sender, new TranslationContainer("commands.kick.success", player.getName()));
			}
		}else{
			sender.sendMessage(new TranslationContainer(TextFormat.RED + "%commands.generic.player.notFound"));
		}

		return true;
	}

}
