package tr.bozkurt.entity.passive;

import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemDye;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;
import tr.bozkurt.utils.DyeColor;

/**
 * @author PikyCZ
 */
public class EntitySquid extends EntityWaterAnimal{

	public static final int NETWORK_ID = 17;

	public EntitySquid(FullChunk chunk, CompoundTag nbt){
		super(chunk, nbt);
	}

	@Override
	public int getNetworkId(){
		return NETWORK_ID;
	}

	@Override
	public float getWidth(){
		return 0.8f;
	}

	@Override
	public float getHeight(){
		return 0.8f;
	}

	@Override
	public void initEntity(){
		super.initEntity();
		this.setMaxHealth(10);
	}

	@Override
	public Item[] getDrops(){
		return new Item[]{new ItemDye(DyeColor.BLACK.getDyeData())};
	}

}
