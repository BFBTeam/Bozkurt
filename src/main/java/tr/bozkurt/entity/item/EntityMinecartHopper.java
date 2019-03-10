package tr.bozkurt.entity.item;

import tr.bozkurt.Player;
import tr.bozkurt.block.BlockHopper;
import tr.bozkurt.entity.Entity;
import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemMinecartHopper;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;
import tr.bozkurt.utils.MinecartType;

public class EntityMinecartHopper extends EntityMinecartAbstract{

	public static final int NETWORK_ID = 96;

	public EntityMinecartHopper(FullChunk chunk, CompoundTag nbt){
		super(chunk, nbt);
		super.setDisplayBlock(new BlockHopper());
	}

	@Override
	public MinecartType getType(){
		return MinecartType.valueOf(5);
	}

	@Override
	public int getNetworkId(){
		return NETWORK_ID;
	}

	@Override
	public void dropItem(){
		level.dropItem(this, new ItemMinecartHopper());
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
