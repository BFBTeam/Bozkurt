package tr.bozkurt.entity.item;

import tr.bozkurt.Player;
import tr.bozkurt.block.BlockChest;
import tr.bozkurt.entity.Entity;
import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemMinecartChest;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;
import tr.bozkurt.utils.MinecartType;

/**
 * Created by Snake1999 on 2016/1/30.
 * Package tr.bozkurt.entity.item in project Bozkurt.
 */
public class EntityMinecartChest extends EntityMinecartAbstract{

	public static final int NETWORK_ID = 98;

	public EntityMinecartChest(FullChunk chunk, CompoundTag nbt){
		super(chunk, nbt);
		super.setDisplayBlock(new BlockChest(), false);
	}

	@Override
	public MinecartType getType(){
		return MinecartType.valueOf(1);
	}

	@Override
	public boolean isRideable(){
		return false;
	}

	@Override
	public int getNetworkId(){
		return NETWORK_ID;
	}

	@Override
	public void dropItem(){
		level.dropItem(this, new ItemMinecartChest());
	}

	@Override
	protected void activate(int x, int y, int z, boolean flag){

	}

	@Override
	public boolean mountEntity(Entity entity){
		return false;
	}

	@Override
	public boolean onInteract(Player p, Item item){
		return false;
	}

}
