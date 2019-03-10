package tr.bozkurt.command.defaults;

import tr.bozkurt.command.CommandSender;
import tr.bozkurt.lang.TranslationContainer;
import tr.bozkurt.network.protocol.ProtocolInfo;
import tr.bozkurt.plugin.Plugin;
import tr.bozkurt.plugin.PluginDescription;
import tr.bozkurt.utils.TextFormat;

import java.util.List;

/**
 * Created on 2015/11/12 by xtypr.
 * Package tr.bozkurt.command.defaults in project Bozkurt.
 */
public class VersionCommand extends VanillaCommand{

	public VersionCommand(String name){
		super(name,
				"%bozkurt.command.version.description",
				"%bozkurt.command.version.usage",
				new String[]{"ver", "about"}
		);
		this.setPermission("bozkurt.command.version");
		this.commandParameters.clear();
	}

	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args){
		if(!this.testPermission(sender)){
			return true;
		}
		if(args.length == 0){
			sender.sendMessage(new TranslationContainer("bozkurt.server.info.extended", new String[]{
					sender.getServer().getName(),
					sender.getServer().getBozkurtVersion(),
					sender.getServer().getCodename(),
					sender.getServer().getApiVersion(),
					sender.getServer().getVersion(),
					String.valueOf(ProtocolInfo.CURRENT_PROTOCOL)
			}));
		}else{
			String pluginName = "";
			for(String arg : args) pluginName += arg + " ";
			pluginName = pluginName.trim();
			final boolean[] found = {false};
			final Plugin[] exactPlugin = {sender.getServer().getPluginManager().getPlugin(pluginName)};

			if(exactPlugin[0] == null){
				pluginName = pluginName.toLowerCase();
				final String finalPluginName = pluginName;
				sender.getServer().getPluginManager().getPlugins().forEach((s, p) -> {
					if(s.toLowerCase().contains(finalPluginName)){
						exactPlugin[0] = p;
						found[0] = true;
					}
				});
			}else{
				found[0] = true;
			}

			if(found[0]){
				PluginDescription desc = exactPlugin[0].getDescription();
				sender.sendMessage(TextFormat.DARK_GREEN + desc.getName() + TextFormat.WHITE + " version " + TextFormat.DARK_GREEN + desc.getVersion());
				if(desc.getDescription() != null){
					sender.sendMessage(desc.getDescription());
				}
				if(desc.getWebsite() != null){
					sender.sendMessage("Website: " + desc.getWebsite());
				}
				List<String> authors = desc.getAuthors();
				final String[] authorsString = {""};
				authors.forEach((s) -> authorsString[0] += s);
				if(authors.size() == 1){
					sender.sendMessage("Author: " + authorsString[0]);
				}else if(authors.size() >= 2){
					sender.sendMessage("Authors: " + authorsString[0]);
				}
			}else{
				sender.sendMessage(new TranslationContainer("bozkurt.command.version.noSuchPlugin"));
			}
		}
		return true;
	}

}
