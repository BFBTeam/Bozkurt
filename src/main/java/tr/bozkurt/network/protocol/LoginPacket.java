package tr.bozkurt.network.protocol;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import tr.bozkurt.entity.data.Skin;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.UUID;


/**
 * Created by on 15-10-13.
 */
public class LoginPacket extends DataPacket{

	public static final byte NETWORK_ID = ProtocolInfo.LOGIN_PACKET;

	public String username;
	public int protocol;
	public UUID clientUUID;
	public long clientId;
	public Skin skin;

	@Override
	public byte pid(){
		return NETWORK_ID;
	}

	@Override
	public void decode(){
		this.protocol = this.getInt();
		this.setBuffer(this.getByteArray(), 0);
		decodeChainData();
		decodeSkinData();
	}

	@Override
	public void encode(){

	}

	public int getProtocol(){
		return protocol;
	}

	private void decodeChainData(){
		Map<String, List<String>> map = new Gson().fromJson(new String(this.get(getLInt()), StandardCharsets.UTF_8),
				new TypeToken<Map<String, List<String>>>(){
				}.getType());
		if(map.isEmpty() || !map.containsKey("chain") || map.get("chain").isEmpty()) return;
		List<String> chains = map.get("chain");
		for(String c : chains){
			JsonObject chainMap = decodeToken(c);
			if(chainMap == null) continue;
			if(chainMap.has("extraData")){
				JsonObject extra = chainMap.get("extraData").getAsJsonObject();
				if(extra.has("displayName")) this.username = extra.get("displayName").getAsString();
				if(extra.has("identity")) this.clientUUID = UUID.fromString(extra.get("identity").getAsString());
			}
		}
	}

	private void decodeSkinData(){
		JsonObject skinToken = decodeToken(new String(this.get(this.getLInt())));
		if(skinToken.has("ClientRandomId")) this.clientId = skinToken.get("ClientRandomId").getAsLong();
		skin = new Skin();
		if(skinToken.has("SkinId")){
			skin.setSkinId(skinToken.get("SkinId").getAsString());
		}
		if(skinToken.has("SkinData")){
			skin.setSkinData(Base64.getDecoder().decode(skinToken.get("SkinData").getAsString()));
		}

		if(skinToken.has("CapeData")){
			this.skin.setCapeData(Base64.getDecoder().decode(skinToken.get("CapeData").getAsString()));
		}

		if(skinToken.has("SkinGeometryName")){
			skin.setGeometryName(skinToken.get("SkinGeometryName").getAsString());
		}

		if(skinToken.has("SkinGeometry")){
			skin.setGeometryData(skinToken.get("SkinGeometry").getAsString());
		}
	}

	private JsonObject decodeToken(String token){
		String[] base = token.split("\\.");
		if(base.length < 2) return null;
		return new Gson().fromJson(new String(Base64.getDecoder().decode(base[1]), StandardCharsets.UTF_8), JsonObject.class);
	}

}
