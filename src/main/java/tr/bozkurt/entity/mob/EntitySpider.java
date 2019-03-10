package tr.bozkurt.entity.mob;

import tr.bozkurt.item.Item;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;

/**
 * @author PikyCZ
 */
public class EntitySpider extends EntityMob{

	public static final int NETWORK_ID = 35;

	public EntitySpider(FullChunk chunk, CompoundTag nbt){
		super(chunk, nbt);
	}

	@Override
	public int getNetworkId(){
		return NETWORK_ID;
	}

	@Override
	protected void initEntity(){
		super.initEntity();
		this.setMaxHealth(16);
	}

	@Override
	public float getWidth(){
		return 1.4f;
	}

	@Override
	public float getHeight(){
		return 0.9f;
	}

	@Override
	public String getName(){
		return "Spider";
	}

	@Override
	public Item[] getDrops(){
		return new Item[]{Item.get(Item.STRING, Item.SPIDER_EYE)};
	}

}
