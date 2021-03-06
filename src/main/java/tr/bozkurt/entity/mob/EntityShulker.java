package tr.bozkurt.entity.mob;

import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;

/**
 * @author PikyCZ
 */
public class EntityShulker extends EntityMob{

	public static final int NETWORK_ID = 54;

	public EntityShulker(FullChunk chunk, CompoundTag nbt){
		super(chunk, nbt);
	}

	@Override
	public int getNetworkId(){
		return NETWORK_ID;
	}

	@Override
	protected void initEntity(){
		super.initEntity();
		this.setMaxHealth(30);
	}

	@Override
	public float getWidth(){
		return 1f;
	}

	@Override
	public float getHeight(){
		return 1f;
	}

	@Override
	public String getName(){
		return "Shulker";
	}

}
