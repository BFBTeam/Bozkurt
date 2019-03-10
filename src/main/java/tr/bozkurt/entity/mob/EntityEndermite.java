package tr.bozkurt.entity.mob;

import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;

/**
 * @author Box.
 */
public class EntityEndermite extends EntityMob{

	public static final int NETWORK_ID = 55;

	public EntityEndermite(FullChunk chunk, CompoundTag nbt){
		super(chunk, nbt);
	}

	@Override
	public int getNetworkId(){
		return NETWORK_ID;
	}

	@Override
	protected void initEntity(){
		super.initEntity();
		this.setMaxHealth(8);
	}

	@Override
	public float getWidth(){
		return 0.4f;
	}

	@Override
	public float getHeight(){
		return 0.3f;
	}

	@Override
	public String getName(){
		return "Endermite";
	}

}
