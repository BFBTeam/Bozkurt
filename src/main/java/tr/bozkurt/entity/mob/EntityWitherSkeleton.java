package tr.bozkurt.entity.mob;

import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;

/**
 * @author PikyCZ
 */
public class EntityWitherSkeleton extends EntityMob{

	public static final int NETWORK_ID = 48;

	public EntityWitherSkeleton(FullChunk chunk, CompoundTag nbt){
		super(chunk, nbt);
	}

	@Override
	public int getNetworkId(){
		return NETWORK_ID;
	}

	@Override
	protected void initEntity(){
		super.initEntity();
	}

	@Override
	public float getWidth(){
		return 0.7f;
	}

	@Override
	public float getHeight(){
		return 2.4f;
	}

	@Override
	public String getName(){
		return "WitherSkeleton";
	}

}
