package tr.bozkurt;

# ______          _               _
# | ___ \        | |             | |
# | |_/ / ___ ___| | ___   _ ____| |_
# | ___ \/ _ \_  / |/ / | | |  __| __|
# | |_/ / (_) / /|   <| |_| | |  | |_
# \_____/\___/___|_|\_\_____|_|   \__|

import tr.bozkurt.command.CommandReader;
import tr.bozkurt.network.protocol.ProtocolInfo;
import tr.bozkurt.utils.LogLevel;
import tr.bozkurt.utils.MainLogger;
import tr.bozkurt.utils.ServerKiller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Bozkurt Project
 */
public class Bozkurt{

	public final static Properties GIT_INFO = getGitInfo();
	public final static String VERSION = getVersion();
	public final static String API_VERSION = "1.0.0";
	public final static String CODENAME = "Injuried";
	@Deprecated
	public final static String MINECRAFT_VERSION = ProtocolInfo.MINECRAFT_VERSION;
	@Deprecated
	public final static String MINECRAFT_VERSION_NETWORK = ProtocolInfo.MINECRAFT_VERSION_NETWORK;

	public final static String PATH = System.getProperty("user.dir") + "/";
	public final static String DATA_PATH = System.getProperty("user.dir") + "/";
	public final static String PLUGIN_PATH = DATA_PATH + "plugins";
	public static final long START_TIME = System.currentTimeMillis();
	public static boolean ANSI = true;
	public static boolean TITLE = false;
	public static boolean shortTitle = false;
	public static int DEBUG = 1;

	public static void main(String[] args){
		// Force IPv4 since Bozkurt is not compatible with IPv6
		System.setProperty("java.net.preferIPv4Stack", "true");

		//Shorter title for Windows 8/2012
		String osName = System.getProperty("os.name").toLowerCase();
		if(osName.contains("windows")){
			if(osName.contains("windows 8") || osName.contains("2012")){
				shortTitle = true;
			}
		}

		LogLevel logLevel = LogLevel.DEFAULT_LEVEL;
		int index = -1;
		boolean skip = false;

		for(String arg : args){
			index++;
			if(skip){
				skip = false;
				continue;
			}

			switch(arg){
				case "disable-ansi":
					ANSI = false;
					break;
				case "enable-title":
					TITLE = true;
					break;
				case "--verbosity":
				case "-v":
					skip = true;
					try{
						String levelName = args[index + 1];
						Set<String> levelNames = Arrays.stream(LogLevel.values()).map(level -> level.name().toLowerCase()).collect(Collectors.toSet());
						if(!levelNames.contains(levelName.toLowerCase())){
							System.out.printf("'%s' is not a valid log level, using the default\n", levelName);
							continue;
						}
						logLevel = Arrays.stream(LogLevel.values()).filter(level -> level.name().equalsIgnoreCase(levelName)).findAny().orElse(LogLevel.DEFAULT_LEVEL);
					}catch(ArrayIndexOutOfBoundsException e){
						System.out.println("You must enter the requested log level, using the default\n");
					}

			}
		}

		MainLogger logger = new MainLogger(DATA_PATH + "server.log", logLevel);
		System.out.printf("Using log level '%s'\n", logLevel);

		try{
			if(ANSI){
				System.out.print((char) 0x1b + "]0;Starting Bozkurt Server For Minecraft" + (char) 0x07);
			}
			new Server(logger, PATH, DATA_PATH, PLUGIN_PATH);
		}catch(Exception e){
			logger.logException(e);
		}

		if(ANSI){
			System.out.print((char) 0x1b + "]0;Stopping Server..." + (char) 0x07);
		}
		logger.info("Stopping other threads");

		for(Thread thread : java.lang.Thread.getAllStackTraces().keySet()){
			if(!(thread instanceof InterruptibleThread)){
				continue;
			}
			logger.debug("Stopping " + thread.getClass().getSimpleName() + " thread");
			if(thread.isAlive()){
				thread.interrupt();
			}
		}

		ServerKiller killer = new ServerKiller(8);
		killer.start();

		logger.shutdown();
		CommandReader.getInstance().removePromptLine();

		if(ANSI){
			System.out.print((char) 0x1b + "]0;Server Stopped" + (char) 0x07);
		}
		System.exit(0);
	}

	private static Properties getGitInfo(){
		InputStream gitFileStream = Bozkurt.class.getClassLoader().getResourceAsStream("git.properties");
		if(gitFileStream == null){
			return null;
		}
		Properties properties = new Properties();
		try{
			properties.load(gitFileStream);
		}catch(IOException e){
			return null;
		}
		return properties;
	}

	private static String getVersion(){
		StringBuilder version = new StringBuilder();
		version.append("git-");
		String commitId;
		if(GIT_INFO == null || (commitId = GIT_INFO.getProperty("git.commit.id.abbrev")) == null){
			return version.append("null").toString();
		}
		return version.append(commitId).toString();
	}

}
