package tr.bozkurt.entity.mob;

import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;

/**
 * @author PikyCZ
 */
public class EntityWither extends EntityMob{

	public static final int NETWORK_ID = 52;

	public EntityWither(FullChunk chunk, CompoundTag nbt){
		super(chunk, nbt);
	}

	@Override
	public int getNetworkId(){
		return NETWORK_ID;
	}

	@Override
	public float getWidth(){
		return 0.9f;
	}

	@Override
	public float getHeight(){
		return 3.5f;
	}

	@Override
	protected void initEntity(){
		super.initEntity();
		this.setMaxHealth(300);
	}

	@Override
	public String getName(){
		return "Wither";
	}

}
