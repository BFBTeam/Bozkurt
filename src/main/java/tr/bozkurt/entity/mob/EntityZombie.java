package tr.bozkurt.entity.mob;

import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;

/**
 * Created by Dr. Nick Doran on 4/23/2017.
 */
public class EntityZombie extends EntityMob{

	public static final int NETWORK_ID = 32;

	public EntityZombie(FullChunk chunk, CompoundTag nbt){
		super(chunk, nbt);
	}

	@Override
	public int getNetworkId(){
		return NETWORK_ID;
	}

	@Override
	protected void initEntity(){
		super.initEntity();
		this.setMaxHealth(20);
	}

	@Override
	public float getWidth(){
		return 0.6f;
	}

	@Override
	public float getHeight(){
		return 1.95f;
	}

	@Override
	public String getName(){
		return "Zombie";
	}

}
