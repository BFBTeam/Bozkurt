package tr.bozkurt.command.defaults;

import tr.bozkurt.command.CommandSender;
import tr.bozkurt.level.Level;
import tr.bozkurt.math.BozkurtMath;
import tr.bozkurt.utils.TextFormat;
import tr.bozkurt.utils.ThreadCache;

/**
 * Created on 2015/11/11 by xtypr.
 * Package tr.bozkurt.command.defaults in project Bozkurt.
 */
public class GarbageCollectorCommand extends VanillaCommand{

	public GarbageCollectorCommand(String name){
		super(name, "%bozkurt.command.gc.description", "%bozkurt.command.gc.usage");
		this.setPermission("bozkurt.command.gc");
		this.commandParameters.clear();
	}

	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args){
		if(!this.testPermission(sender)){
			return true;
		}

		int chunksCollected = 0;
		int entitiesCollected = 0;
		int tilesCollected = 0;
		long memory = Runtime.getRuntime().freeMemory();

		for(Level level : sender.getServer().getLevels().values()){
			int chunksCount = level.getChunks().size();
			int entitiesCount = level.getEntities().length;
			int tilesCount = level.getBlockEntities().size();
			level.doChunkGarbageCollection();
			level.unloadChunks(true);
			chunksCollected += chunksCount - level.getChunks().size();
			entitiesCollected += entitiesCount - level.getEntities().length;
			tilesCollected += tilesCount - level.getBlockEntities().size();
		}

		ThreadCache.clean();
		System.gc();

		long freedMemory = Runtime.getRuntime().freeMemory() - memory;

		sender.sendMessage(TextFormat.GREEN + "---- " + TextFormat.WHITE + "Garbage collection result" + TextFormat.GREEN + " ----");
		sender.sendMessage(TextFormat.GOLD + "Chunks: " + TextFormat.RED + chunksCollected);
		sender.sendMessage(TextFormat.GOLD + "Entities: " + TextFormat.RED + entitiesCollected);
		sender.sendMessage(TextFormat.GOLD + "Block Entities: " + TextFormat.RED + tilesCollected);
		sender.sendMessage(TextFormat.GOLD + "Memory freed: " + TextFormat.RED + BozkurtMath.round((freedMemory / 1024d / 1024d), 2) + " MB");
		return true;
	}

}
