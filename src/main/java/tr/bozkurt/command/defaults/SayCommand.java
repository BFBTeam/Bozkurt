package tr.bozkurt.command.defaults;

import tr.bozkurt.Player;
import tr.bozkurt.command.CommandSender;
import tr.bozkurt.command.ConsoleCommandSender;
import tr.bozkurt.command.data.CommandParameter;
import tr.bozkurt.lang.TranslationContainer;
import tr.bozkurt.utils.TextFormat;

/**
 * Created on 2015/11/12 by xtypr.
 * Package tr.bozkurt.command.defaults in project Bozkurt.
 */
public class SayCommand extends VanillaCommand{

	public SayCommand(String name){
		super(name, "%bozkurt.command.say.description", "%commands.say.usage");
		this.setPermission("bozkurt.command.say");
		this.commandParameters.clear();
		this.commandParameters.put("default", new CommandParameter[]{
				new CommandParameter("message")
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

		String senderString;
		if(sender instanceof Player){
			senderString = ((Player) sender).getDisplayName();
		}else if(sender instanceof ConsoleCommandSender){
			senderString = "Server";
		}else{
			senderString = sender.getName();
		}

		String msg = "";
		for(String arg : args){
			msg += arg + " ";
		}
		if(msg.length() > 0){
			msg = msg.substring(0, msg.length() - 1);
		}


		sender.getServer().broadcastMessage(new TranslationContainer(
				TextFormat.LIGHT_PURPLE + "%chat.type.announcement",
				new String[]{senderString, TextFormat.LIGHT_PURPLE + msg}
		));
		return true;
	}

}
