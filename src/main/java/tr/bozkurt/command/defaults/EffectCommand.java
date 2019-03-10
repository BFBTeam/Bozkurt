package tr.bozkurt.command.defaults;

import tr.bozkurt.Player;
import tr.bozkurt.command.Command;
import tr.bozkurt.command.CommandSender;
import tr.bozkurt.command.data.CommandParameter;
import tr.bozkurt.lang.TranslationContainer;
import tr.bozkurt.potion.Effect;
import tr.bozkurt.potion.InstantEffect;
import tr.bozkurt.utils.ServerException;
import tr.bozkurt.utils.TextFormat;

/**
 * Created by Snake1999 and Pub4Game on 2016/1/23.
 * Package tr.bozkurt.command.defaults in project bozkurt.
 */
public class EffectCommand extends Command{

	public EffectCommand(String name){
		super(name, "%bozkurt.command.effect.description", "%commands.effect.usage");
		this.setPermission("bozkurt.command.effect");
		this.commandParameters.clear();
		this.commandParameters.put("default", new CommandParameter[]{
				new CommandParameter("player", CommandParameter.ARG_TYPE_TARGET, false),
				new CommandParameter("effect", CommandParameter.ARG_TYPE_STRING, false), //Do not use Enum here because of buggy behavior
				new CommandParameter("seconds", CommandParameter.ARG_TYPE_INT, true),
				new CommandParameter("amplifier", true),
				new CommandParameter("hideParticle", CommandParameter.ARG_TYPE_BOOL, true)
		});
		this.commandParameters.put("clear", new CommandParameter[]{
				new CommandParameter("player", CommandParameter.ARG_TYPE_TARGET, false),
				new CommandParameter("clear", new String[]{"clear"})
		});
	}

	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args){
		if(!this.testPermission(sender)){
			return true;
		}
		if(args.length < 2){
			sender.sendMessage(new TranslationContainer("commands.generic.usage", this.usageMessage));
			return true;
		}
		Player player = sender.getServer().getPlayer(args[0]);
		if(player == null){
			sender.sendMessage(new TranslationContainer(TextFormat.RED + "%commands.generic.player.notFound"));
			return true;
		}
		if(args[1].equalsIgnoreCase("clear")){
			for(Effect effect : player.getEffects().values()){
				player.removeEffect(effect.getId());
			}
			sender.sendMessage(new TranslationContainer("commands.effect.success.removed.all", player.getDisplayName()));
			return true;
		}
		Effect effect;
		try{
			effect = Effect.getEffect(Integer.parseInt(args[1]));
		}catch(NumberFormatException | ServerException a){
			try{
				effect = Effect.getEffectByName(args[1]);
			}catch(Exception e){
				sender.sendMessage(new TranslationContainer("commands.effect.notFound", args[1]));
				return true;
			}
		}
		int duration = 300;
		int amplification = 0;
		if(args.length >= 3){
			try{
				duration = Integer.valueOf(args[2]);
			}catch(NumberFormatException a){
				sender.sendMessage(new TranslationContainer("commands.generic.usage", this.usageMessage));
				return true;
			}
			if(!(effect instanceof InstantEffect)){
				duration *= 20;
			}
		}else if(effect instanceof InstantEffect){
			duration = 1;
		}
		if(args.length >= 4){
			try{
				amplification = Integer.valueOf(args[3]);
			}catch(NumberFormatException a){
				sender.sendMessage(new TranslationContainer("commands.generic.usage", this.usageMessage));
				return true;
			}
		}
		if(args.length >= 5){
			String v = args[4].toLowerCase();
			if(v.matches("(?i)|on|true|t|1")){
				effect.setVisible(false);
			}
		}
		if(duration == 0){
			if(!player.hasEffect(effect.getId())){
				if(player.getEffects().size() == 0){
					sender.sendMessage(new TranslationContainer("commands.effect.failure.notActive.all", player.getDisplayName()));
				}else{
					sender.sendMessage(new TranslationContainer("commands.effect.failure.notActive", effect.getName(), player.getDisplayName()}));
				}
				return true;
			}
			player.removeEffect(effect.getId());
			sender.sendMessage(new TranslationContainer("commands.effect.success.removed", effect.getName(), player.getDisplayName()}));
		}else{
			effect.setDuration(duration).setAmplifier(amplification);
			player.addEffect(effect);
			Command.broadcastCommandMessage(sender, new TranslationContainer("%commands.effect.success", effect.getName(), String.valueOf(effect.getId()), String.valueOf(effect.getAmplifier()), player.getDisplayName(), String.valueOf(effect.getDuration() / 20)}));
		}
		return true;
	}

}
