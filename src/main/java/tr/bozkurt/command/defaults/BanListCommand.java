package tr.bozkurt.command.defaults;

import tr.bozkurt.command.CommandSender;
import tr.bozkurt.command.data.CommandParameter;
import tr.bozkurt.lang.TranslationContainer;
import tr.bozkurt.permission.BanEntry;
import tr.bozkurt.permission.BanList;

import java.util.Iterator;

/**
 * Created on 2015/11/11 by xtypr.
 * Package tr.bozkurt.command.defaults in project Bozkurt.
 */
public class BanListCommand extends VanillaCommand{

	public BanListCommand(String name){
		super(name, "%bozkurt.command.banlist.description", "%commands.banlist.usage");
		this.setPermission("bozkurt.command.ban.list");
		this.commandParameters.clear();
		this.commandParameters.put("default", new CommandParameter[]{
				new CommandParameter("ips|players", true)
		});
	}

	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args){
		if(!this.testPermission(sender)){
			return true;
		}

		BanList list;
		boolean ips = false;
		if(args.length > 0){
			switch(args[0].toLowerCase()){
				case "ips":
					list = sender.getServer().getIPBans();
					ips = true;
					break;
				case "players":
					list = sender.getServer().getNameBans();
					break;
				default:
					sender.sendMessage(new TranslationContainer("commands.generic.usage", this.usageMessage));
					return false;
			}
		}else{
			list = sender.getServer().getNameBans();
		}

		StringBuilder builder = new StringBuilder();
		Iterator<BanEntry> itr = list.getEntires().values().iterator();
		while(itr.hasNext()){
			builder.append(itr.next().getName());
			if(itr.hasNext()){
				builder.append(", ");
			}
		}

		if(ips){
			sender.sendMessage(new TranslationContainer("commands.banlist.ips", String.valueOf(list.getEntires().size())));
		}else{
			sender.sendMessage(new TranslationContainer("commands.banlist.players", String.valueOf(list.getEntires().size())));
		}
		sender.sendMessage(builder.toString());
		return true;
	}

}
