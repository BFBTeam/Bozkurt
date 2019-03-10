package tr.bozkurt.command.defaults;

import tr.bozkurt.command.Command;
import tr.bozkurt.command.CommandSender;
import tr.bozkurt.command.data.CommandParameter;
import tr.bozkurt.lang.TranslationContainer;

import java.util.regex.Pattern;

/**
 * Bozkurt Project
 */
public class PardonIpCommand extends VanillaCommand{

	public PardonIpCommand(String name){
		super(name, "%bozkurt.command.unban.ip.description", "%commands.unbanip.usage");
		this.setPermission("bozkurt.command.unban.ip");
		this.setAliases(new String[]{"unbanip", "unban-ip", "pardonip"});
		this.commandParameters.clear();
		this.commandParameters.put("default", new CommandParameter[]{
				new CommandParameter("ip")
		});
	}

	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args){
		if(!this.testPermission(sender)){
			return true;
		}

		if(args.length != 1){
			sender.sendMessage(new TranslationContainer("commands.generic.usage", this.usageMessage));

			return false;
		}

		String value = args[0];

		if(Pattern.matches("^(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])$", value)){
			sender.getServer().getIPBans().remove(value);
			sender.getServer().getNetwork().unblockAddress(value);

			Command.broadcastCommandMessage(sender, new TranslationContainer("commands.unbanip.success", value));
		}else{

			sender.sendMessage(new TranslationContainer("commands.unbanip.invalid"));
		}

		return true;
	}

}
