package tr.bozkurt.entity.passive;

import tr.bozkurt.item.Item;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;

/**
 * Created by PetteriM1
 */
public class EntityDolphin extends EntityAnimal{

	public static final int NETWORK_ID = 31;

	public EntityDolphin(FullChunk chunk, CompoundTag nbt){
		super(chunk, nbt);
	}

	@Override
	public int getNetworkId(){
		return NETWORK_ID;
	}

	public String getName(){
		return "Dolphin";
	}

	@Override
	public float getWidth(){
		return 0.9f;
	}

	@Override
	public float getHeight(){
		return 0.6f;
	}

	@Override
	public void initEntity(){
		super.initEntity();
		this.setMaxHealth(10);
	}

	@Override
	public Item[] getDrops(){
		return new Item[]{Item.get(Item.RAW_FISH)};
	}

}
