package tr.bozkurt.entity.passive;

import tr.bozkurt.item.Item;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;

/**
 * Author: BeYkeRYkt Bozkurt Project
 */
public class EntityRabbit extends EntityAnimal{

	public static final int NETWORK_ID = 18;

	public EntityRabbit(FullChunk chunk, CompoundTag nbt){
		super(chunk, nbt);
	}

	@Override
	public float getWidth(){
		if(this.isBaby()){
			return 0.2f;
		}
		return 0.4f;
	}

	@Override
	public float getHeight(){
		if(this.isBaby()){
			return 0.25f;
		}
		return 0.5f;
	}

	@Override
	public String getName(){
		return "Rabbit";
	}

	@Override
	public Item[] getDrops(){
		return new Item[]{Item.get(Item.RAW_RABBIT), Item.get(Item.RABBIT_HIDE), Item.get(Item.RABBIT_FOOT)};
	}

	@Override
	public int getNetworkId(){
		return NETWORK_ID;
	}

	@Override
	protected void initEntity(){
		super.initEntity();
		setMaxHealth(10);
	}

}
