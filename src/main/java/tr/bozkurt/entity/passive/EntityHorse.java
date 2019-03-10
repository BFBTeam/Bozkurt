package tr.bozkurt.entity.passive;

import tr.bozkurt.item.Item;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;

/**
 * @author PikyCZ
 */
public class EntityHorse extends EntityAnimal{

	public static final int NETWORK_ID = 23;

	public EntityHorse(FullChunk chunk, CompoundTag nbt){
		super(chunk, nbt);
	}

	@Override
	public int getNetworkId(){
		return NETWORK_ID;
	}

	@Override
	public float getWidth(){
		if(this.isBaby()){
			return 0.6982f;
		}
		return 1.3965f;
	}

	@Override
	public float getHeight(){
		if(this.isBaby()){
			return 0.8f;
		}
		return 1.6f;
	}

	@Override
	public void initEntity(){
		super.initEntity();
		this.setMaxHealth(15);
	}

	@Override
	public Item[] getDrops(){
		return new Item[]{Item.get(Item.LEATHER)};
	}

}
