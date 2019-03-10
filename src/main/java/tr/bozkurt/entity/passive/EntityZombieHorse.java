package tr.bozkurt.entity.passive;

import tr.bozkurt.item.Item;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;

/**
 * @author PikyCZ
 */
public class EntityZombieHorse extends EntityAnimal{

	public static final int NETWORK_ID = 27;

	public EntityZombieHorse(FullChunk chunk, CompoundTag nbt){
		super(chunk, nbt);
	}

	@Override
	public int getNetworkId(){
		return NETWORK_ID;
	}

	@Override
	public float getWidth(){
		return 1.4f;
	}

	@Override
	public float getHeight(){
		return 1.6f;
	}

	@Override
	public void initEntity(){
		super.initEntity();
		this.setMaxHealth(15);
	}

	@Override
	public Item[] getDrops(){
		return new Item[]{Item.get(Item.ROTTEN_FLESH, 1, 1)};
	}

}
