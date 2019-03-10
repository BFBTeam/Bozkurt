package tr.bozkurt.command.defaults;

import tr.bozkurt.Server;
import tr.bozkurt.command.Command;
import tr.bozkurt.command.CommandSender;
import tr.bozkurt.command.data.CommandParameter;
import tr.bozkurt.lang.TranslationContainer;
import tr.bozkurt.network.protocol.SetDifficultyPacket;

import java.util.ArrayList;

/**
 * Created on 2015/11/12 by xtypr.
 * Package tr.bozkurt.command.defaults in project Bozkurt.
 */
public class DifficultyCommand extends VanillaCommand{

	public DifficultyCommand(String name){
		super(name, "%bozkurt.command.difficulty.description", "%commands.difficulty.usage");
		this.setPermission("bozkurt.command.difficulty");
		this.commandParameters.clear();
		this.commandParameters.put("default", new CommandParameter[]{
				new CommandParameter("difficulty", CommandParameter.ARG_TYPE_INT, false)
		});
		this.commandParameters.put("byString", new CommandParameter[]{
				new CommandParameter("difficulty", new String[]{"peaceful", "p", "easy", "e",
						"normal", "n", "hard", "h"})
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

		int difficulty = Server.getDifficultyFromString(args[0]);

		if(sender.getServer().isHardcore()){
			difficulty = 3;
		}

		if(difficulty != -1){
			sender.getServer().setPropertyInt("difficulty", difficulty);

			SetDifficultyPacket pk = new SetDifficultyPacket();
			pk.difficulty = sender.getServer().getDifficulty();
			Server.broadcastPacket(new ArrayList<>(sender.getServer().getOnlinePlayers().values()), pk);

			Command.broadcastCommandMessage(sender, new TranslationContainer("commands.difficulty.success", String.valueOf(difficulty)));
		}else{
			sender.sendMessage(new TranslationContainer("commands.generic.usage", this.usageMessage));

			return false;
		}

		return true;
	}

}
