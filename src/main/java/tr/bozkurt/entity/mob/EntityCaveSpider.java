package tr.bozkurt.entity.mob;

import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;

/**
 * @author PikyCZ
 */
public class EntityCaveSpider extends EntityMob{

	public static final int NETWORK_ID = 40;

	public EntityCaveSpider(FullChunk chunk, CompoundTag nbt){
		super(chunk, nbt);
	}

	@Override
	public int getNetworkId(){
		return NETWORK_ID;
	}

	@Override
	protected void initEntity(){
		super.initEntity();
		this.setMaxHealth(12);
	}

	@Override
	public float getWidth(){
		return 0.7f;
	}

	@Override
	public float getHeight(){
		return 0.5f;
	}

	@Override
	public String getName(){
		return "CaveSpider";
	}

}
