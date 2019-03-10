package tr.bozkurt.command;

import tr.bozkurt.Server;
import tr.bozkurt.lang.TextContainer;
import tr.bozkurt.permission.PermissibleBase;
import tr.bozkurt.permission.Permission;
import tr.bozkurt.permission.PermissionAttachment;
import tr.bozkurt.permission.PermissionAttachmentInfo;
import tr.bozkurt.plugin.Plugin;
import tr.bozkurt.utils.MainLogger;

import java.util.Map;

/**
 * Bozkurt Project
 */
public class ConsoleCommandSender implements CommandSender{

	private final PermissibleBase perm;

	public ConsoleCommandSender(){
		this.perm = new PermissibleBase(this);
	}

	@Override
	public boolean isPermissionSet(String name){
		return this.perm.isPermissionSet(name);
	}

	@Override
	public boolean isPermissionSet(Permission permission){
		return this.perm.isPermissionSet(permission);
	}

	@Override
	public boolean hasPermission(String name){
		return this.perm.hasPermission(name);
	}

	@Override
	public boolean hasPermission(Permission permission){
		return this.perm.hasPermission(permission);
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin){
		return this.perm.addAttachment(plugin);
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, String name){
		return this.perm.addAttachment(plugin, name);
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, String name, Boolean value){
		return this.perm.addAttachment(plugin, name, value);
	}

	@Override
	public void removeAttachment(PermissionAttachment attachment){
		this.perm.removeAttachment(attachment);
	}

	@Override
	public void recalculatePermissions(){
		this.perm.recalculatePermissions();
	}

	@Override
	public Map<String, PermissionAttachmentInfo> getEffectivePermissions(){
		return this.perm.getEffectivePermissions();
	}

	public boolean isPlayer(){
		return false;
	}

	@Override
	public Server getServer(){
		return Server.getInstance();
	}

	@Override
	public void sendMessage(String message){
		message = this.getServer().getLanguage().translateString(message);
		for(String line : message.trim().split("\n")){
			MainLogger.getLogger().info(line);
		}
	}

	@Override
	public void sendMessage(TextContainer message){
		this.sendMessage(this.getServer().getLanguage().translate(message));
	}

	@Override
	public String getName(){
		return "CONSOLE";
	}

	@Override
	public boolean isOp(){
		return true;
	}

	@Override
	public void setOp(boolean value){

	}

}