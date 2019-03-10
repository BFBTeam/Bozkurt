package tr.bozkurt.entity.item;

import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;
import tr.bozkurt.utils.MinecartType;

/**
 * Created by Snake1999 on 2016/1/30.
 * Package tr.bozkurt.entity.item in project Bozkurt.
 */
public class EntityMinecartEmpty extends EntityMinecartAbstract{

	public static final int NETWORK_ID = 84;

	public EntityMinecartEmpty(FullChunk chunk, CompoundTag nbt){
		super(chunk, nbt);
	}

	@Override
	public int getNetworkId(){
		return NETWORK_ID;
	}

	@Override
	public MinecartType getType(){
		return MinecartType.valueOf(0);
	}

	@Override
	public boolean isRideable(){
		return true;
	}

	@Override
	protected void activate(int x, int y, int z, boolean flag){
		if(flag){
			if(this.riding != null){
				mountEntity(riding);
			}
			// looks like MCPE and MCPC not same XD
			// removed rolling feature from here because of MCPE logic?
		}
	}

}
