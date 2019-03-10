package tr.bozkurt.entity.passive;

import tr.bozkurt.item.Item;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;

/**
 * Author: BeYkeRYkt Bozkurt Project
 */
public class EntityCow extends EntityAnimal{

	public static final int NETWORK_ID = 11;

	public EntityCow(FullChunk chunk, CompoundTag nbt){
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
			return 0.7f;
		}
		return 1.4f;
	}

	@Override
	public String getName(){
		return "Cow";
	}

	@Override
	public Item[] getDrops(){
		return new Item[]{Item.get(Item.LEATHER), Item.get(Item.RAW_BEEF)};
	}

	@Override
	public int getNetworkId(){
		return NETWORK_ID;
	}

	@Override
	protected void initEntity(){
		super.initEntity();
		this.setMaxHealth(10);
	}

}
