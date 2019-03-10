package tr.bozkurt.entity.mob;

import tr.bozkurt.item.Item;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;

/**
 * Created by PetteriM1
 */
public class EntityPhantom extends EntityMob{

	public static final int NETWORK_ID = 58;

	public EntityPhantom(FullChunk chunk, CompoundTag nbt){
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
		return 0.9f;
	}

	@Override
	public float getHeight(){
		return 0.5f;
	}

	@Override
	public String getName(){
		return "Phantom";
	}

	@Override
	public Item[] getDrops(){
		return new Item[]{Item.get(470)};
	}

}
