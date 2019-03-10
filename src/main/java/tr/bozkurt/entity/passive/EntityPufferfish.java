package tr.bozkurt.entity.passive;

import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;

/**
 * Created by PetteriM1
 */
public class EntityPufferfish extends EntityAnimal{

	public static final int NETWORK_ID = 108;

	public EntityPufferfish(FullChunk chunk, CompoundTag nbt){
		super(chunk, nbt);
	}

	@Override
	public int getNetworkId(){
		return NETWORK_ID;
	}

	public String getName(){
		return "Pufferfish";
	}

	@Override
	public float getWidth(){
		return 0.35f;
	}

	@Override
	public float getHeight(){
		return 0.35f;
	}

	@Override
	public void initEntity(){
		super.initEntity();
		this.setMaxHealth(3);
	}

}
