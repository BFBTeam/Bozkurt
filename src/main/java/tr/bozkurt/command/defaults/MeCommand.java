package tr.bozkurt.command.defaults;

import tr.bozkurt.Player;
import tr.bozkurt.command.CommandSender;
import tr.bozkurt.command.data.CommandParameter;
import tr.bozkurt.lang.TranslationContainer;
import tr.bozkurt.utils.TextFormat;

/**
 * Created on 2015/11/12 by xtypr.
 * Package tr.bozkurt.command.defaults in project Bozkurt.
 */
public class MeCommand extends VanillaCommand{

	public MeCommand(String name){
		super(name, "%bozkurt.command.me.description", "%commands.me.usage");
		this.setPermission("bozkurt.command.me");
		this.commandParameters.clear();
		this.commandParameters.put("default", new CommandParameter[]{
				new CommandParameter("action ...", CommandParameter.ARG_TYPE_RAW_TEXT, false)
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

		String name;
		if(sender instanceof Player){
			name = ((Player) sender).getDisplayName();
		}else{
			name = sender.getName();
		}

		String msg = "";
		for(String arg : args){
			msg += arg + " ";
		}

		if(msg.length() > 0){
			msg = msg.substring(0, msg.length() - 1);
		}

		sender.getServer().broadcastMessage(new TranslationContainer("chat.type.emote", new String[]{name, TextFormat.WHITE + msg}));

		return true;
	}

}
