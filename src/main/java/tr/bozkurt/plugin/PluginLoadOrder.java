package tr.bozkurt.plugin;

/**
 * 描述一个Bozkurt插件加载顺序的类。<br>
 * Describes a Bozkurt plugin load order.
 * <p>
 * <p>Bozkurt插件的加载顺序有两个:{@link tr.bozkurt.plugin.PluginLoadOrder#STARTUP}
 * 和 {@link tr.bozkurt.plugin.PluginLoadOrder#POSTWORLD}。<br>
 * The load order of a Bozkurt plugin can be {@link tr.bozkurt.plugin.PluginLoadOrder#STARTUP}
 * or {@link tr.bozkurt.plugin.PluginLoadOrder#POSTWORLD}.</p>
 *
 * @author MagicDroidX(code) @ Bozkurt Project
 * @author iNevet(code) @ Bozkurt Project
 * @author 粉鞋大妈(javadoc) @ Bozkurt Project
 * @since Bozkurt 1.0 | Bozkurt API 1.0.0
 */
public enum PluginLoadOrder{
	/**
	 * 表示这个插件在服务器启动时就开始加载。<br>
	 * Indicates that the plugin will be loaded at startup.
	 *
	 * @see tr.bozkurt.plugin.PluginLoadOrder
	 * @since Bozkurt 1.0 | Bozkurt API 1.0.0
	 */
	STARTUP,
	/**
	 * 表示这个插件在第一个世界加载完成后开始加载。<br>
	 * Indicates that the plugin will be loaded after the first/default world was created.
	 *
	 * @see tr.bozkurt.plugin.PluginLoadOrder
	 * @since Bozkurt 1.0 | Bozkurt API 1.0.0
	 */
	POSTWORLD
}
