package tr.bozkurt.entity.passive;

import tr.bozkurt.item.Item;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;

/**
 * Author: BeYkeRYkt Bozkurt Project
 */
public class EntityWolf extends EntityAnimal{

	public static final int NETWORK_ID = 14;

	public EntityWolf(FullChunk chunk, CompoundTag nbt){
		super(chunk, nbt);
	}

	@Override
	public float getWidth(){
		return 0.6f;
	}

	@Override
	public float getHeight(){
		return 0.85f;
	}

	@Override
	public String getName(){
		return "Wolf";
	}

	@Override
	public int getNetworkId(){
		return NETWORK_ID;
	}

	@Override
	public void initEntity(){
		super.initEntity();
		this.setMaxHealth(8);
	}

	@Override
	public boolean isBreedingItem(Item item){
		return false; //only certain food
	}

}
