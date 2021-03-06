package tr.bozkurt.entity.passive;

import tr.bozkurt.item.Item;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;

/**
 * @author PikyCZ
 */
public class EntityParrot extends EntityAnimal{

	public static final int NETWORK_ID = 30;

	public EntityParrot(FullChunk chunk, CompoundTag nbt){
		super(chunk, nbt);
	}

	@Override
	public int getNetworkId(){
		return NETWORK_ID;
	}

	public String getName(){
		return "Parrot";
	}

	@Override
	public float getWidth(){
		return 0.5f;
	}

	@Override
	public float getHeight(){
		return 0.9f;
	}

	@Override
	public void initEntity(){
		super.initEntity();
		this.setMaxHealth(6);
	}

	@Override
	public Item[] getDrops(){
		return new Item[]{Item.get(Item.FEATHER)};
	}

}
