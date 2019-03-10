package tr.bozkurt.command.simple;

import tr.bozkurt.Server;
import tr.bozkurt.command.Command;
import tr.bozkurt.command.CommandSender;
import tr.bozkurt.command.ConsoleCommandSender;
import tr.bozkurt.lang.TranslationContainer;

import java.lang.reflect.Method;

/**
 * @author Tee7even
 */
public class SimpleCommand extends Command{

	private Object object;
	private Method method;
	private boolean forbidConsole;
	private int maxArgs;
	private int minArgs;

	public SimpleCommand(Object object, Method method, String name, String description, String usageMessage, String[] aliases){
		super(name, description, usageMessage, aliases);
		this.object = object;
		this.method = method;
	}

	public void setForbidConsole(boolean forbidConsole){
		this.forbidConsole = forbidConsole;
	}

	public void setMaxArgs(int maxArgs){
		this.maxArgs = maxArgs;
	}

	public void setMinArgs(int minArgs){
		this.minArgs = minArgs;
	}

	public void sendUsageMessage(CommandSender sender){
		if(!this.usageMessage.equals("")){
			sender.sendMessage(new TranslationContainer("commands.generic.usage", this.usageMessage));
		}
	}

	public void sendInGameMessage(CommandSender sender){
		sender.sendMessage(new TranslationContainer("commands.generic.ingame"));
	}

	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args){
		if(this.forbidConsole && sender instanceof ConsoleCommandSender){
			this.sendInGameMessage(sender);
			return false;
		}else if(!this.testPermission(sender)){
			return false;
		}else if(this.maxArgs != 0 && args.length > this.maxArgs){
			this.sendUsageMessage(sender);
			return false;
		}else if(this.minArgs != 0 && args.length < this.minArgs){
			this.sendUsageMessage(sender);
			return false;
		}

		boolean success = false;

		try{
			success = (Boolean) this.method.invoke(this.object, sender, commandLabel, args);
		}catch(Exception exception){
			Server.getInstance().getLogger().logException(exception);
		}

		if(!success){
			this.sendUsageMessage(sender);
		}

		return success;
	}

}
