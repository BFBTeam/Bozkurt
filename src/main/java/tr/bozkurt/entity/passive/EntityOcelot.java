package tr.bozkurt.entity.passive;

import tr.bozkurt.item.Item;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;

/**
 * Author: BeYkeRYkt Bozkurt Project
 */
public class EntityOcelot extends EntityAnimal{

	public static final int NETWORK_ID = 22;

	public EntityOcelot(FullChunk chunk, CompoundTag nbt){
		super(chunk, nbt);
	}

	@Override
	public float getWidth(){
		if(this.isBaby()){
			return 0.3f;
		}
		return 0.6f;
	}

	@Override
	public float getHeight(){
		if(this.isBaby()){
			return 0.35f;
		}
		return 0.7f;
	}

	@Override
	public String getName(){
		return "Ocelot";
	}

	@Override
	public int getNetworkId(){
		return NETWORK_ID;
	}

	@Override
	public void initEntity(){
		super.initEntity();
		setMaxHealth(10);
	}

	@Override
	public boolean isBreedingItem(Item item){
		return item.getId() == Item.RAW_FISH;
	}

}
