package tr.bozkurt.entity.mob;

import tr.bozkurt.item.Item;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;

/**
 * @author PikyCZ
 */
public class EntityVindicator extends EntityMob{

	public static final int NETWORK_ID = 57;

	public EntityVindicator(FullChunk chunk, CompoundTag nbt){
		super(chunk, nbt);
	}

	@Override
	public int getNetworkId(){
		return NETWORK_ID;
	}

	@Override
	protected void initEntity(){
		super.initEntity();
		this.setMaxHealth(24);
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
		return "Vindicator";
	}

	@Override
	public Item[] getDrops(){
		return new Item[]{Item.get(Item.IRON_AXE)};
	}

}
