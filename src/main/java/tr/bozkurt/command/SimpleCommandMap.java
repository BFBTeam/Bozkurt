package tr.bozkurt.command;

import tr.bozkurt.Server;
import tr.bozkurt.command.data.CommandParameter;
import tr.bozkurt.command.defaults.*;
import tr.bozkurt.command.simple.*;
import tr.bozkurt.lang.TranslationContainer;
import tr.bozkurt.utils.MainLogger;
import tr.bozkurt.utils.TextFormat;
import tr.bozkurt.utils.Utils;

import java.lang.reflect.Method;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class SimpleCommandMap implements CommandMap{

	protected final Map<String, Command> knownCommands = new HashMap<>();

	private final Server server;

	public SimpleCommandMap(Server server){
		this.server = server;
		this.setDefaultCommands();
	}

	private void setDefaultCommands(){
		this.register("bozkurt", new VersionCommand("version"));
		this.register("bozkurt", new PluginsCommand("plugins"));
		this.register("bozkurt", new SeedCommand("seed"));
		this.register("bozkurt", new HelpCommand("help"));
		this.register("bozkurt", new StopCommand("stop"));
		this.register("bozkurt", new TellCommand("tell"));
		this.register("bozkurt", new DefaultGamemodeCommand("defaultgamemode"));
		this.register("bozkurt", new BanCommand("ban"));
		this.register("bozkurt", new BanIpCommand("ban-ip"));
		this.register("bozkurt", new BanListCommand("banlist"));
		this.register("bozkurt", new PardonCommand("pardon"));
		this.register("bozkurt", new PardonIpCommand("pardon-ip"));
		this.register("bozkurt", new SayCommand("say"));
		this.register("bozkurt", new MeCommand("me"));
		this.register("bozkurt", new ListCommand("list"));
		this.register("bozkurt", new DifficultyCommand("difficulty"));
		this.register("bozkurt", new KickCommand("kick"));
		this.register("bozkurt", new OpCommand("op"));
		this.register("bozkurt", new DeopCommand("deop"));
		this.register("bozkurt", new WhitelistCommand("whitelist"));
		this.register("bozkurt", new SaveOnCommand("save-on"));
		this.register("bozkurt", new SaveOffCommand("save-off"));
		this.register("bozkurt", new SaveCommand("save-all"));
		this.register("bozkurt", new GiveCommand("give"));
		this.register("bozkurt", new EffectCommand("effect"));
		this.register("bozkurt", new EnchantCommand("enchant"));
		this.register("bozkurt", new ParticleCommand("particle"));
		this.register("bozkurt", new GamemodeCommand("gamemode"));
		this.register("bozkurt", new GameruleCommand("gamerule"));
		this.register("bozkurt", new KillCommand("kill"));
		this.register("bozkurt", new SpawnpointCommand("spawnpoint"));
		this.register("bozkurt", new SetWorldSpawnCommand("setworldspawn"));
		this.register("bozkurt", new TeleportCommand("tp"));
		this.register("bozkurt", new TimeCommand("time"));
		this.register("bozkurt", new TitleCommand("title"));
		this.register("bozkurt", new ReloadCommand("reload"));
		this.register("bozkurt", new WeatherCommand("weather"));
		this.register("bozkurt", new XpCommand("xp"));

//        if ((boolean) this.server.getConfig("debug.commands", false)) {
		this.register("bozkurt", new StatusCommand("status"));
		this.register("bozkurt", new GarbageCollectorCommand("gc"));
		this.register("bozkurt", new DebugPasteCommand("debugpaste"));
		//this.register("bozkurt", new DumpMemoryCommand("dumpmemory"));
//        }
	}

	@Override
	public void registerAll(String fallbackPrefix, List<? extends Command> commands){
		for(Command command : commands){
			this.register(fallbackPrefix, command);
		}
	}

	@Override
	public boolean register(String fallbackPrefix, Command command){
		return this.register(fallbackPrefix, command, null);
	}

	@Override
	public boolean register(String fallbackPrefix, Command command, String label){
		if(label == null){
			label = command.getName();
		}
		label = label.trim().toLowerCase();
		fallbackPrefix = fallbackPrefix.trim().toLowerCase();

		boolean registered = this.registerAlias(command, false, fallbackPrefix, label);

		List<String> aliases = new ArrayList<>(Arrays.asList(command.getAliases()));

		for(Iterator<String> iterator = aliases.iterator(); iterator.hasNext(); ){
			String alias = iterator.next();
			if(!this.registerAlias(command, true, fallbackPrefix, alias)){
				iterator.remove();
			}
		}
		command.setAliases(aliases.stream().toArray(String[]::new));

		if(!registered){
			command.setLabel(fallbackPrefix + ":" + label);
		}

		command.register(this);

		return registered;
	}

	@Override
	public void registerSimpleCommands(Object object){
		for(Method method : object.getClass().getDeclaredMethods()){
			tr.bozkurt.command.simple.Command def = method.getAnnotation(tr.bozkurt.command.simple.Command.class);
			if(def != null){
				SimpleCommand sc = new SimpleCommand(object, method, def.name(), def.description(), def.usageMessage(), def.aliases());

				Arguments args = method.getAnnotation(Arguments.class);
				if(args != null){
					sc.setMaxArgs(args.max());
					sc.setMinArgs(args.min());
				}

				CommandPermission perm = method.getAnnotation(CommandPermission.class);
				if(perm != null){
					sc.setPermission(perm.value());
				}

				if(method.isAnnotationPresent(ForbidConsole.class)){
					sc.setForbidConsole(true);
				}

				CommandParameters commandParameters = method.getAnnotation(CommandParameters.class);
				if(commandParameters != null){
					Map<String, CommandParameter[]> map = Arrays.stream(commandParameters.parameters())
							.collect(Collectors.toMap(Parameters::name, parameters -> Arrays.stream(parameters.parameters())
									.map(parameter -> new CommandParameter(parameter.name(), parameter.type(), parameter.optional()))
									.distinct()
									.toArray(CommandParameter[]::new)));

					sc.commandParameters.putAll(map);
				}

				this.register(def.name(), sc);
			}
		}
	}

	private boolean registerAlias(Command command, boolean isAlias, String fallbackPrefix, String label){
		this.knownCommands.put(fallbackPrefix + ":" + label, command);

		//if you're registering a command alias that is already registered, then return false
		boolean alreadyRegistered = this.knownCommands.containsKey(label);
		Command existingCommand = this.knownCommands.get(label);
		boolean existingCommandIsNotVanilla = alreadyRegistered && !(existingCommand instanceof VanillaCommand);
		//basically, if we're an alias and it's already registered, or we're a vanilla command, then we can't override it
		if((command instanceof VanillaCommand || isAlias) && alreadyRegistered && existingCommandIsNotVanilla){
			return false;
		}

		//if you're registering a name (alias or label) which is identical to another command who's primary name is the same
		//so basically we can't override the main name of a command, but we can override aliases if we're not an alias

		//added the last statement which will allow us to override a VanillaCommand unconditionally
		if(alreadyRegistered && existingCommand.getLabel() != null && existingCommand.getLabel().equals(label) && existingCommandIsNotVanilla){
			return false;
		}

		//you can now assume that the command is either uniquely named, or overriding another command's alias (and is not itself, an alias)

		if(!isAlias){
			command.setLabel(label);
		}

		// Then we need to check if there isn't any command conflicts with vanilla commands
		ArrayList<String> toRemove = new ArrayList<String>();

		for(Entry<String, Command> entry : knownCommands.entrySet()){
			Command cmd = entry.getValue();
			if(cmd.getLabel().equalsIgnoreCase(command.getLabel()) && !cmd.equals(command)){ // If the new command conflicts... (But if it isn't the same command)
				if(cmd instanceof VanillaCommand){ // And if the old command is a vanilla command...
					// Remove it!
					toRemove.add(entry.getKey());
				}
			}
		}

		// Now we loop the toRemove list to remove the command conflicts from the knownCommands map
		for(String cmd : toRemove){
			knownCommands.remove(cmd);
		}

		this.knownCommands.put(label, command);

		return true;
	}

	private ArrayList<String> parseArguments(String cmdLine){
		StringBuilder sb = new StringBuilder(cmdLine);
		ArrayList<String> args = new ArrayList<>();
		boolean notQuoted = true;
		int start = 0;

		for(int i = 0; i < sb.length(); i++){
			if(sb.charAt(i) == '\\'){
				sb.deleteCharAt(i);
				continue;
			}

			if(sb.charAt(i) == ' ' && notQuoted){
				String arg = sb.substring(start, i);
				if(!arg.isEmpty()){
					args.add(arg);
				}
				start = i + 1;
			}else if(sb.charAt(i) == '"'){
				sb.deleteCharAt(i);
				--i;
				notQuoted = !notQuoted;
			}
		}

		String arg = sb.substring(start);
		if(!arg.isEmpty()){
			args.add(arg);
		}
		return args;
	}

	@Override
	public boolean dispatch(CommandSender sender, String cmdLine){
		ArrayList<String> parsed = parseArguments(cmdLine);
		if(parsed.size() == 0){
			return false;
		}

		String sentCommandLabel = parsed.remove(0).toLowerCase();
		String[] args = parsed.toArray(new String[parsed.size()]);
		Command target = this.getCommand(sentCommandLabel);

		if(target == null){
			return false;
		}

		try{
			target.execute(sender, sentCommandLabel, args);
		}catch(Exception e){
			sender.sendMessage(new TranslationContainer(TextFormat.RED + "%commands.generic.exception"));
			this.server.getLogger().critical(this.server.getLanguage().translateString("bozkurt.command.exception", cmdLine, target.toString(), Utils.getExceptionMessage(e)));
			MainLogger logger = sender.getServer().getLogger();
			if(logger != null){
				logger.logException(e);
			}
		}

		return true;
	}

	@Override
	public void clearCommands(){
		for(Command command : this.knownCommands.values()){
			command.unregister(this);
		}
		this.knownCommands.clear();
		this.setDefaultCommands();
	}

	@Override
	public Command getCommand(String name){
		if(this.knownCommands.containsKey(name)){
			return this.knownCommands.get(name);
		}
		return null;
	}

	public Map<String, Command> getCommands(){
		return knownCommands;
	}

	public void registerServerAliases(){
		Map<String, List<String>> values = this.server.getCommandAliases();
		for(Map.Entry<String, List<String>> entry : values.entrySet()){
			String alias = entry.getKey();
			List<String> commandStrings = entry.getValue();
			if(alias.contains(" ") || alias.contains(":")){
				this.server.getLogger().warning(this.server.getLanguage().translateString("bozkurt.command.alias.illegal", alias));
				continue;
			}
			List<String> targets = new ArrayList<>();

			String bad = "";

			for(String commandString : commandStrings){
				String[] args = commandString.split(" ");
				Command command = this.getCommand(args[0]);

				if(command == null){
					if(bad.length() > 0){
						bad += ", ";
					}
					bad += commandString;
				}else{
					targets.add(commandString);
				}
			}

			if(bad.length() > 0){
				this.server.getLogger().warning(this.server.getLanguage().translateString("bozkurt.command.alias.notFound", new String[]{alias, bad}));
				continue;
			}

			if(!targets.isEmpty()){
				this.knownCommands.put(alias.toLowerCase(), new FormattedCommandAlias(alias.toLowerCase(), targets));
			}else{
				this.knownCommands.remove(alias.toLowerCase());
			}
		}
	}

}