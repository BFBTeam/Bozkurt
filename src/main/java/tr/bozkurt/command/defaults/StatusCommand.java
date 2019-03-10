package tr.bozkurt.command.defaults;

import tr.bozkurt.Bozkurt;
import tr.bozkurt.Server;
import tr.bozkurt.command.CommandSender;
import tr.bozkurt.level.Level;
import tr.bozkurt.math.BozkurtMath;
import tr.bozkurt.utils.TextFormat;

import java.util.Objects;

/**
 * Created on 2015/11/11 by xtypr.
 * Package tr.bozkurt.command.defaults in project Bozkurt.
 */
public class StatusCommand extends VanillaCommand{

	public StatusCommand(String name){
		super(name, "%bozkurt.command.status.description", "%bozkurt.command.status.usage");
		this.setPermission("bozkurt.command.status");
		this.commandParameters.clear();
	}

	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args){
		if(!this.testPermission(sender)){
			return true;
		}

		Server server = sender.getServer();
		sender.sendMessage(TextFormat.GREEN + "---- " + TextFormat.WHITE + "Server status" + TextFormat.GREEN + " ----");

		long time = (System.currentTimeMillis() - Bozkurt.START_TIME) / 1000;
		int seconds = BozkurtMath.floorDouble(time % 60);
		int minutes = BozkurtMath.floorDouble((time % 3600) / 60);
		int hours = BozkurtMath.floorDouble(time % (3600 * 24) / 3600);
		int days = BozkurtMath.floorDouble(time / (3600 * 24));
		String upTimeString = TextFormat.RED + "" + days + TextFormat.GOLD + " days " +
				TextFormat.RED + hours + TextFormat.GOLD + " hours " +
				TextFormat.RED + minutes + TextFormat.GOLD + " minutes " +
				TextFormat.RED + seconds + TextFormat.GOLD + " seconds";
		sender.sendMessage(TextFormat.GOLD + "Uptime: " + upTimeString);

		TextFormat tpsColor = TextFormat.GREEN;
		float tps = server.getTicksPerSecond();
		if(tps < 17){
			tpsColor = TextFormat.GOLD;
		}else if(tps < 12){
			tpsColor = TextFormat.RED;
		}

		sender.sendMessage(TextFormat.GOLD + "Current TPS: " + tpsColor + BozkurtMath.round(tps, 2));

		sender.sendMessage(TextFormat.GOLD + "Load: " + tpsColor + server.getTickUsage() + "%");

		sender.sendMessage(TextFormat.GOLD + "Network upload: " + TextFormat.GREEN + BozkurtMath.round((server.getNetwork().getUpload() / 1024 * 1000), 2) + " kB/s");

		sender.sendMessage(TextFormat.GOLD + "Network download: " + TextFormat.GREEN + BozkurtMath.round((server.getNetwork().getDownload() / 1024 * 1000), 2) + " kB/s");

		sender.sendMessage(TextFormat.GOLD + "Thread count: " + TextFormat.GREEN + Thread.getAllStackTraces().size());


		Runtime runtime = Runtime.getRuntime();
		double totalMB = BozkurtMath.round(((double) runtime.totalMemory()) / 1024 / 1024, 2);
		double usedMB = BozkurtMath.round((double) (runtime.totalMemory() - runtime.freeMemory()) / 1024 / 1024, 2);
		double maxMB = BozkurtMath.round(((double) runtime.maxMemory()) / 1024 / 1024, 2);
		double usage = usedMB / maxMB * 100;
		TextFormat usageColor = TextFormat.GREEN;

		if(usage > 85){
			usageColor = TextFormat.GOLD;
		}

		sender.sendMessage(TextFormat.GOLD + "Used memory: " + usageColor + usedMB + " MB. (" + BozkurtMath.round(usage, 2) + "%)");

		sender.sendMessage(TextFormat.GOLD + "Total memory: " + TextFormat.RED + totalMB + " MB.");

		sender.sendMessage(TextFormat.GOLD + "Maximum VM memory: " + TextFormat.RED + maxMB + " MB.");

		sender.sendMessage(TextFormat.GOLD + "Available processors: " + TextFormat.GREEN + runtime.availableProcessors());


		TextFormat playerColor = TextFormat.GREEN;
		if(((float) server.getOnlinePlayers().size() / (float) server.getMaxPlayers()) > 0.85){
			playerColor = TextFormat.GOLD;
		}

		sender.sendMessage(TextFormat.GOLD + "Players: " + playerColor + server.getOnlinePlayers().size() + TextFormat.GREEN + " online, " +
				TextFormat.RED + server.getMaxPlayers() + TextFormat.GREEN + " max. ");

		for(Level level : server.getLevels().values()){
			sender.sendMessage(
					TextFormat.GOLD + "World \"" + level.getFolderName() + "\"" + (!Objects.equals(level.getFolderName(), level.getName()) ? " (" + level.getName() + ")" : "") + ": " +
							TextFormat.RED + level.getChunks().size() + TextFormat.GREEN + " chunks, " +
							TextFormat.RED + level.getEntities().length + TextFormat.GREEN + " entities, " +
							TextFormat.RED + level.getBlockEntities().size() + TextFormat.GREEN + " blockEntities." +
							" Time " + ((level.getTickRate() > 1 || level.getTickRateTime() > 40) ? TextFormat.RED : TextFormat.YELLOW) + BozkurtMath.round(level.getTickRateTime(), 2) + "ms" +
							(level.getTickRate() > 1 ? " (tick rate " + level.getTickRate() + ")" : "")
			);
		}

		return true;
	}

}
