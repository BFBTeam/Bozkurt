package tr.bozkurt.entity.passive;

import tr.bozkurt.item.Item;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;

/**
 * Author: BeYkeRYkt Bozkurt Project
 */
public class EntityPig extends EntityAnimal{

	public static final int NETWORK_ID = 12;

	public EntityPig(FullChunk chunk, CompoundTag nbt){
		super(chunk, nbt);
	}

	@Override
	public float getWidth(){
		if(this.isBaby()){
			return 0.45f;
		}
		return 0.9f;
	}

	@Override
	public float getHeight(){
		if(this.isBaby()){
			return 0.45f;
		}
		return 0.9f;
	}

	@Override
	public void initEntity(){
		super.initEntity();
		this.setMaxHealth(10);
	}

	@Override
	public String getName(){
		return "Pig";
	}

	@Override
	public Item[] getDrops(){
		return new Item[]{Item.get(Item.RAW_PORKCHOP)};
	}

	@Override
	public int getNetworkId(){
		return NETWORK_ID;
	}

	@Override
	public boolean isBreedingItem(Item item){
		int id = item.getId();

		return id == Item.CARROT || id == Item.POTATO || id == Item.BEETROOT;
	}

}
