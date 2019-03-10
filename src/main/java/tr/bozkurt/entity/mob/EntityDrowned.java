package tr.bozkurt.entity.mob;

import tr.bozkurt.item.Item;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;

/**
 * Created by PetteriM1
 */
public class EntityDrowned extends EntityMob{

	public static final int NETWORK_ID = 110;

	public EntityDrowned(FullChunk chunk, CompoundTag nbt){
		super(chunk, nbt);
	}

	@Override
	public int getNetworkId(){
		return NETWORK_ID;
	}

	@Override
	protected void initEntity(){
		super.initEntity();
		this.setMaxHealth(20);
	}

	@Override
	public float getWidth(){
		return 0.6f;
	}

	@Override
	public float getHeight(){
		return 1.95f;
	}

	@Override
	public String getName(){
		return "Drowned";
	}

	@Override
	public Item[] getDrops(){
		return new Item[]{Item.get(Item.ROTTEN_FLESH)};
	}

}
