package tr.bozkurt;

import tr.bozkurt.metadata.MetadataValue;
import tr.bozkurt.nbt.tag.CompoundTag;
import tr.bozkurt.plugin.Plugin;

import java.io.File;
import java.util.List;
import java.util.UUID;

public class OfflinePlayer implements IPlayer{

	private final String name;
	private final Server server;
	private final CompoundTag namedTag;

	public OfflinePlayer(Server server, String name){
		this.server = server;
		this.name = name;

		if(new File(this.server.getDataPath() + "players/" + name.toLowerCase() + ".dat").exists()){
			this.namedTag = this.server.getOfflinePlayerData(this.name);
		}else{
			this.namedTag = null;
		}
	}

	@Override
	public boolean isOnline(){
		return this.getPlayer() != null;
	}

	@Override
	public String getName(){
		return name;
	}

	@Override
	public UUID getUniqueId(){
		if(namedTag != null){
			long least = namedTag.getLong("UUIDLeast");
			long most = namedTag.getLong("UUIDMost");

			if(least != 0 && most != 0){
				return new UUID(most, least);
			}
		}
		return null;
	}

	public Server getServer(){
		return server;
	}

	@Override
	public boolean isOp(){
		return this.server.isOp(this.getName().toLowerCase());
	}

	@Override
	public void setOp(boolean value){
		if(value == this.isOp()){
			return;
		}

		if(value){
			this.server.addOp(this.getName().toLowerCase());
		}else{
			this.server.removeOp(this.getName().toLowerCase());
		}
	}

	@Override
	public boolean isBanned(){
		return this.server.getNameBans().isBanned(this.getName());
	}

	@Override
	public void setBanned(boolean value){
		if(value){
			this.server.getNameBans().addBan(this.getName(), null, null, null);
		}else{
			this.server.getNameBans().remove(this.getName());
		}
	}

	@Override
	public boolean isWhitelisted(){
		return this.server.isWhitelisted(this.getName().toLowerCase());
	}

	@Override
	public void setWhitelisted(boolean value){
		if(value){
			this.server.addWhitelist(this.getName().toLowerCase());
		}else{
			this.server.removeWhitelist(this.getName().toLowerCase());
		}
	}

	@Override
	public Player getPlayer(){
		return this.server.getPlayerExact(this.getName());
	}

	@Override
	public Long getFirstPlayed(){
		return this.namedTag != null ? this.namedTag.getLong("firstPlayed") : null;
	}

	@Override
	public Long getLastPlayed(){
		return this.namedTag != null ? this.namedTag.getLong("lastPlayed") : null;
	}

	@Override
	public boolean hasPlayedBefore(){
		return this.namedTag != null;
	}

	public void setMetadata(String metadataKey, MetadataValue newMetadataValue){
		this.server.getPlayerMetadata().setMetadata(this, metadataKey, newMetadataValue);
	}

	public List<MetadataValue> getMetadata(String metadataKey){
		return this.server.getPlayerMetadata().getMetadata(this, metadataKey);
	}

	public boolean hasMetadata(String metadataKey){
		return this.server.getPlayerMetadata().hasMetadata(this, metadataKey);
	}

	public void removeMetadata(String metadataKey, Plugin owningPlugin){
		this.server.getPlayerMetadata().removeMetadata(this, metadataKey, owningPlugin);
	}

}
