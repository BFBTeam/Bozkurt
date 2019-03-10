package tr.bozkurt.entity.passive;

import tr.bozkurt.item.Item;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;

/**
 * @author PikyCZ
 */
public class EntityPolarBear extends EntityAnimal{

	public static final int NETWORK_ID = 28;

	public EntityPolarBear(FullChunk chunk, CompoundTag nbt){
		super(chunk, nbt);
	}

	@Override
	public int getNetworkId(){
		return NETWORK_ID;
	}

	@Override
	public float getWidth(){
		if(this.isBaby()){
			return 0.65f;
		}
		return 1.3f;
	}

	@Override
	public float getHeight(){
		if(this.isBaby()){
			return 0.7f;
		}
		return 1.4f;
	}

	@Override
	public void initEntity(){
		super.initEntity();
		this.setMaxHealth(30);
	}

	@Override
	public Item[] getDrops(){
		return new Item[]{Item.get(Item.RAW_FISH), Item.get(Item.RAW_SALMON)};
	}

}
