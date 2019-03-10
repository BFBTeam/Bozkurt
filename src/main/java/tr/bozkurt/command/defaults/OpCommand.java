package tr.bozkurt.command.defaults;

import tr.bozkurt.IPlayer;
import tr.bozkurt.Player;
import tr.bozkurt.command.Command;
import tr.bozkurt.command.CommandSender;
import tr.bozkurt.command.data.CommandParameter;
import tr.bozkurt.lang.TranslationContainer;
import tr.bozkurt.utils.TextFormat;

/**
 * Created on 2015/11/12 by xtypr.
 * Package tr.bozkurt.command.defaults in project Bozkurt.
 */
public class OpCommand extends VanillaCommand{

	public OpCommand(String name){
		super(name, "%bozkurt.command.op.description", "%commands.op.description");
		this.setPermission("bozkurt.command.op.give");
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
		if(args.length == 0){
			sender.sendMessage(new TranslationContainer("commands.generic.usage", this.usageMessage));
			return false;
		}

		String name = args[0];
		IPlayer player = sender.getServer().getOfflinePlayer(name);

		Command.broadcastCommandMessage(sender, new TranslationContainer("commands.op.success", player.getName()));
		if(player instanceof Player){
			((Player) player).sendMessage(new TranslationContainer(TextFormat.GRAY + "%commands.op.message"));
		}

		player.setOp(true);

		return true;
	}

}
