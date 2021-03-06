package tr.bozkurt.entity.mob;

import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;

/**
 * @author PikyCZ
 */
public class EntityElderGuardian extends EntityMob{

	public static final int NETWORK_ID = 50;

	public EntityElderGuardian(FullChunk chunk, CompoundTag nbt){
		super(chunk, nbt);
	}

	@Override
	public int getNetworkId(){
		return NETWORK_ID;
	}

	@Override
	protected void initEntity(){
		super.initEntity();
		this.setMaxHealth(80);
		this.setDataFlag(DATA_FLAGS, DATA_FLAG_ELDER, true);
	}

	@Override
	public float getWidth(){
		return 1.9975f;
	}

	@Override
	public float getHeight(){
		return 1.9975f;
	}

	@Override
	public String getName(){
		return "Elder Guardian";
	}

}
