package tr.bozkurt.command.defaults;

import tr.bozkurt.command.CommandSender;
import tr.bozkurt.lang.TranslationContainer;
import tr.bozkurt.plugin.Plugin;
import tr.bozkurt.utils.TextFormat;

import java.util.Map;

/**
 * Created on 2015/11/12 by xtypr.
 * Package tr.bozkurt.command.defaults in project Bozkurt.
 */
public class PluginsCommand extends VanillaCommand{

	public PluginsCommand(String name){
		super(name,
				"%bozkurt.command.plugins.description",
				"%bozkurt.command.plugins.usage",
				new String[]{"pl"}
		);
		this.setPermission("bozkurt.command.plugins");
		this.commandParameters.clear();
	}

	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args){
		if(!this.testPermission(sender)){
			return true;
		}

		this.sendPluginList(sender);
		return true;
	}

	private void sendPluginList(CommandSender sender){
		String list = "";
		Map<String, Plugin> plugins = sender.getServer().getPluginManager().getPlugins();
		for(Plugin plugin : plugins.values()){
			if(list.length() > 0){
				list += TextFormat.WHITE + ", ";
			}
			list += plugin.isEnabled() ? TextFormat.GREEN : TextFormat.RED;
			list += plugin.getDescription().getFullName();
		}

		sender.sendMessage(new TranslationContainer("bozkurt.command.plugins.success", new String[]{String.valueOf(plugins.size()), list}));
	}

}
