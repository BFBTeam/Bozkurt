package tr.bozkurt.entity.mob;

import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;

/**
 * @author PikyCZ
 */
public class EntityMagmaCube extends EntityMob{

	public static final int NETWORK_ID = 42;

	public EntityMagmaCube(FullChunk chunk, CompoundTag nbt){
		super(chunk, nbt);
	}

	@Override
	public int getNetworkId(){
		return NETWORK_ID;
	}

	@Override
	protected void initEntity(){
		super.initEntity();
		this.setMaxHealth(16);
	}

	@Override
	public float getWidth(){
		return 2.04f;
	}

	@Override
	public float getHeight(){
		return 2.04f;
	}

	@Override
	public String getName(){
		return "Magma Cube";
	}

}
