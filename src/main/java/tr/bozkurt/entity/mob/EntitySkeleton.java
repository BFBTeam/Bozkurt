package tr.bozkurt.entity.mob;

import tr.bozkurt.item.Item;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;

/**
 * @author PikyCZ
 */
public class EntitySkeleton extends EntityMob{

	public static final int NETWORK_ID = 34;

	public EntitySkeleton(FullChunk chunk, CompoundTag nbt){
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
		return 1.99f;
	}

	@Override
	public String getName(){
		return "Skeleton";
	}

	@Override
	public Item[] getDrops(){
		return new Item[]{Item.get(Item.BONE, Item.ARROW)};
	}

}
