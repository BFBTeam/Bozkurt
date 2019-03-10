package tr.bozkurt.command.defaults;

import tr.bozkurt.Player;
import tr.bozkurt.Server;
import tr.bozkurt.command.Command;
import tr.bozkurt.command.CommandSender;
import tr.bozkurt.command.data.CommandParameter;
import tr.bozkurt.entity.Entity;
import tr.bozkurt.event.entity.EntityDamageEvent;
import tr.bozkurt.event.entity.EntityDamageEvent.DamageCause;
import tr.bozkurt.lang.TranslationContainer;
import tr.bozkurt.level.Level;
import tr.bozkurt.utils.TextFormat;

/**
 * Created on 2015/12/08 by Pub4Game.
 * Package tr.bozkurt.command.defaults in project Bozkurt.
 */
public class KillCommand extends VanillaCommand{

	public KillCommand(String name){
		super(name, "%bozkurt.command.kill.description", "%bozkurt.command.kill.usage");
		this.setPermission("bozkurt.command.kill.self;"
				+ "bozkurt.command.kill.other");
		this.commandParameters.clear();
		this.commandParameters.put("default", new CommandParameter[]{
				new CommandParameter("player", CommandParameter.ARG_TYPE_TARGET, true)
		});
	}

	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args){
		if(!this.testPermission(sender)){
			return true;
		}
		if(args.length >= 2){
			sender.sendMessage(new TranslationContainer("commands.generic.usage", this.usageMessage));
			return false;
		}
		if(args.length == 1){
			if(!sender.hasPermission("bozkurt.command.kill.other")){
				sender.sendMessage(new TranslationContainer(TextFormat.RED + "%commands.generic.permission"));
				return true;
			}
			Player player = sender.getServer().getPlayer(args[0]);
			if(player != null){
				EntityDamageEvent ev = new EntityDamageEvent(player, DamageCause.SUICIDE, 1000);
				sender.getServer().getPluginManager().callEvent(ev);
				if(ev.isCancelled()){
					return true;
				}
				player.setLastDamageCause(ev);
				player.setHealth(0);
				Command.broadcastCommandMessage(sender, new TranslationContainer("commands.kill.successful", player.getName()));
			}else if(args[0].equals("@e")){
				for(Level level : Server.getInstance().getLevels().values()){
					for(Entity entity : level.getEntities()){
						if(!(entity instanceof Player)){
							entity.close();
						}
					}
				}
				sender.sendMessage(new TranslationContainer(TextFormat.GOLD + "%commands.kill.entities.successful"));
			}else if(args[0].equals("@s")){
				if(!sender.hasPermission("bozkurt.command.kill.self")){
					sender.sendMessage(new TranslationContainer(TextFormat.RED + "%commands.generic.permission"));
					return true;
				}
				EntityDamageEvent ev = new EntityDamageEvent((Player) sender, DamageCause.SUICIDE, 1000);
				sender.getServer().getPluginManager().callEvent(ev);
				if(ev.isCancelled()){
					return true;
				}
				((Player) sender).setLastDamageCause(ev);
				((Player) sender).setHealth(0);
				sender.sendMessage(new TranslationContainer("commands.kill.successful", sender.getName()));
			}else if(args[0].equals("@a")){
				if(!sender.hasPermission("bozkurt.command.kill.other")){
					sender.sendMessage(new TranslationContainer(TextFormat.RED + "%commands.generic.permission"));
					return true;
				}
				for(Level level : Server.getInstance().getLevels().values()){
					for(Entity entity : level.getEntities()){
						if(entity instanceof Player){
							entity.setHealth(0);
						}
					}
				}
				sender.sendMessage(new TranslationContainer(TextFormat.GOLD + "%commands.kill.all.successful"));
			}else{
				sender.sendMessage(new TranslationContainer(TextFormat.RED + "%commands.generic.player.notFound"));
			}
			return true;
		}
		if(sender instanceof Player){
			if(!sender.hasPermission("bozkurt.command.kill.self")){
				sender.sendMessage(new TranslationContainer(TextFormat.RED + "%commands.generic.permission"));
				return true;
			}
			EntityDamageEvent ev = new EntityDamageEvent((Player) sender, DamageCause.SUICIDE, 1000);
			sender.getServer().getPluginManager().callEvent(ev);
			if(ev.isCancelled()){
				return true;
			}
			((Player) sender).setLastDamageCause(ev);
			((Player) sender).setHealth(0);
			sender.sendMessage(new TranslationContainer("commands.kill.successful", sender.getName()));
		}else{
			sender.sendMessage(new TranslationContainer("commands.generic.usage", this.usageMessage));
			return false;
		}
		return true;
	}

}
