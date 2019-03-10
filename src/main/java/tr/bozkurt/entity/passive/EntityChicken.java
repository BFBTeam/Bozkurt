package tr.bozkurt.entity.passive;

import tr.bozkurt.item.Item;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;

/**
 * Author: BeYkeRYkt Bozkurt Project
 */
public class EntityChicken extends EntityAnimal{

	public static final int NETWORK_ID = 10;

	public EntityChicken(FullChunk chunk, CompoundTag nbt){
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
			return 0.35f;
		}
		return 0.7f;
	}

	@Override
	public String getName(){
		return "Chicken";
	}

	@Override
	public Item[] getDrops(){
		return new Item[]{Item.get(Item.RAW_CHICKEN), Item.get(Item.FEATHER)};
	}

	@Override
	public int getNetworkId(){
		return NETWORK_ID;
	}

	@Override
	protected void initEntity(){
		super.initEntity();
		setMaxHealth(4);
	}

	@Override
	public boolean isBreedingItem(Item item){
		int id = item.getId();

		return id == Item.WHEAT_SEEDS || id == Item.MELON_SEEDS || id == Item.PUMPKIN_SEEDS || id == Item.BEETROOT_SEEDS;
	}

}
