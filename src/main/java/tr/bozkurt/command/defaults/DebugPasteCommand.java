package tr.bozkurt.command.defaults;

import tr.bozkurt.Server;
import tr.bozkurt.command.CommandSender;
import tr.bozkurt.network.protocol.ProtocolInfo;
import tr.bozkurt.plugin.Plugin;
import tr.bozkurt.plugin.PluginDescription;
import tr.bozkurt.scheduler.AsyncTask;
import tr.bozkurt.utils.HastebinUtility;
import tr.bozkurt.utils.MainLogger;
import tr.bozkurt.utils.Utils;

import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;

public class DebugPasteCommand extends VanillaCommand{

	public DebugPasteCommand(String name){
		super(name, "%bozkurt.command.debug.description", "%commands.debug.usage");
		this.setPermission("bozkurt.command.debug.perform");
	}

	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args){
		if(!this.testPermission(sender)){
			return true;
		}
		Server server = Server.getInstance();
		server.getScheduler().scheduleAsyncTask(new AsyncTask(){
			@Override
			public void onRun(){
				try{
					new StatusCommand("status").execute(server.getConsoleSender(), "status", new String[]{});
					String dataPath = server.getDataPath();
					String bozkurtYML = HastebinUtility.upload(new File(dataPath, "bozkurt.yml"));
					String serverProperties = HastebinUtility.upload(new File(dataPath, "server.properties"));
					String latestLog = HastebinUtility.upload(new File(dataPath, "server.log"));
					String threadDump = HastebinUtility.upload(Utils.getAllThreadDumps());

					StringBuilder b = new StringBuilder();
					b.append("# Files\n");
					b.append("links.bozkurt_yml: ").append(bozkurtYML).append('\n');
					b.append("links.server_properties: ").append(serverProperties).append('\n');
					b.append("links.server_log: ").append(latestLog).append('\n');
					b.append("links.thread_dump: ").append(threadDump).append('\n');
					b.append("\n# Server Information\n");

					b.append("version.api: ").append(server.getApiVersion()).append('\n');
					b.append("version.bozkurt: ").append(server.getBozkurtVersion()).append('\n');
					b.append("version.minecraft: ").append(server.getVersion()).append('\n');
					b.append("version.protocol: ").append(ProtocolInfo.CURRENT_PROTOCOL).append('\n');
					b.append("plugins:");
					for(Plugin plugin : server.getPluginManager().getPlugins().values()){
						boolean enabled = plugin.isEnabled();
						String name = plugin.getName();
						PluginDescription desc = plugin.getDescription();
						String version = desc.getVersion();
						b.append("\n  ")
								.append(name)
								.append(":\n    ")
								.append("version: '")
								.append(version)
								.append('\'')
								.append("\n    enabled: ")
								.append(enabled);
					}
					b.append("\n\n# Java Details\n");
					Runtime runtime = Runtime.getRuntime();
					b.append("memory.free: ").append(runtime.freeMemory()).append('\n');
					b.append("memory.max: ").append(runtime.maxMemory()).append('\n');
					b.append("cpu.runtime: ").append(ManagementFactory.getRuntimeMXBean().getUptime()).append('\n');
					b.append("cpu.processors: ").append(runtime.availableProcessors()).append('\n');
					b.append("java.specification.version: '").append(System.getProperty("java.specification.version")).append("'\n");
					b.append("java.vendor: '").append(System.getProperty("java.vendor")).append("'\n");
					b.append("java.version: '").append(System.getProperty("java.version")).append("'\n");
					b.append("os.arch: '").append(System.getProperty("os.arch")).append("'\n");
					b.append("os.name: '").append(System.getProperty("os.name")).append("'\n");
					b.append("os.version: '").append(System.getProperty("os.version")).append("'\n\n");
					b.append("\n# Create a ticket: https://github.com/BozkurtX/Bozkurt/issues/new");
					String link = HastebinUtility.upload(b.toString());
					sender.sendMessage(link);
				}catch(IOException e){
					MainLogger.getLogger().logException(e);
				}
			}
		});
		return true;
	}

}