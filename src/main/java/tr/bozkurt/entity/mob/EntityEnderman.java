package tr.bozkurt.entity.mob;

import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;

/**
 * @author PikyCZ
 */
public class EntityEnderman extends EntityMob{

	public static final int NETWORK_ID = 38;

	public EntityEnderman(FullChunk chunk, CompoundTag nbt){
		super(chunk, nbt);
	}

	@Override
	public int getNetworkId(){
		return NETWORK_ID;
	}

	@Override
	protected void initEntity(){
		super.initEntity();
		this.setMaxHealth(40);
	}

	@Override
	public float getWidth(){
		return 0.6f;
	}

	@Override
	public float getHeight(){
		return 2.9f;
	}

	@Override
	public String getName(){
		return "Enderman";
	}

}
