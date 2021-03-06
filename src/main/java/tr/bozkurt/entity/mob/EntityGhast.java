package tr.bozkurt.entity.mob;

import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;

/**
 * @author PikyCZ
 */
public class EntityGhast extends EntityMob{

	public static final int NETWORK_ID = 41;

	public EntityGhast(FullChunk chunk, CompoundTag nbt){
		super(chunk, nbt);
	}

	@Override
	public int getNetworkId(){
		return NETWORK_ID;
	}

	@Override
	protected void initEntity(){
		super.initEntity();
		this.setMaxHealth(10);
	}

	@Override
	public float getWidth(){
		return 4;
	}

	@Override
	public float getHeight(){
		return 4;
	}

	@Override
	public String getName(){
		return "Ghast";
	}

}
