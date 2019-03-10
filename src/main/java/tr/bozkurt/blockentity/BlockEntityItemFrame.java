package tr.bozkurt.blockentity;

import tr.bozkurt.block.Block;
import tr.bozkurt.block.BlockAir;
import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemBlock;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.NBTIO;
import tr.bozkurt.nbt.tag.CompoundTag;

/**
 * Created by Pub4Game on 03.07.2016.
 */
public class BlockEntityItemFrame extends BlockEntitySpawnable{

	public BlockEntityItemFrame(FullChunk chunk, CompoundTag nbt){
		super(chunk, nbt);
	}

	@Override
	protected void initBlockEntity(){
		if(!namedTag.contains("Item")){
			namedTag.putCompound("Item", NBTIO.putItemHelper(new ItemBlock(new BlockAir())));
		}
		if(!namedTag.contains("ItemRotation")){
			namedTag.putByte("ItemRotation", 0);
		}
		if(!namedTag.contains("ItemDropChance")){
			namedTag.putFloat("ItemDropChance", 1.0f);
		}

		this.level.updateComparatorOutputLevel(this);

		super.initBlockEntity();
	}

	@Override
	public String getName(){
		return "Item Frame";
	}

	@Override
	public boolean isBlockEntityValid(){
		return this.getBlock().getId() == Block.ITEM_FRAME_BLOCK;
	}

	public int getItemRotation(){
		return this.namedTag.getByte("ItemRotation");
	}

	public void setItemRotation(int itemRotation){
		this.namedTag.putByte("ItemRotation", itemRotation);
		this.level.updateComparatorOutputLevel(this);
		this.setDirty();
	}

	public Item getItem(){
		CompoundTag NBTTag = this.namedTag.getCompound("Item");
		return NBTIO.getItemHelper(NBTTag);
	}

	public void setItem(Item item){
		this.setItem(item, true);
	}

	public void setItem(Item item, boolean setChanged){
		this.namedTag.putCompound("Item", NBTIO.putItemHelper(item));
		if(setChanged){
			this.setDirty();
		}

		this.level.updateComparatorOutputLevel(this);
	}

	public float getItemDropChance(){
		return this.namedTag.getFloat("ItemDropChance");
	}

	public void setItemDropChance(float chance){
		this.namedTag.putFloat("ItemDropChance", chance);
	}

	public void setDirty(){
		this.spawnToAll();
		super.setDirty();
	}

	@Override
	public CompoundTag getSpawnCompound(){
		if(!this.namedTag.contains("Item")){
			this.setItem(new ItemBlock(new BlockAir()), false);
		}
		CompoundTag NBTItem = namedTag.getCompound("Item").copy();
		NBTItem.setName("Item");
		boolean item = NBTItem.getShort("id") == Item.AIR;
		return new CompoundTag()
				.putString("id", BlockEntity.ITEM_FRAME)
				.putInt("x", (int) this.x)
				.putInt("y", (int) this.y)
				.putInt("z", (int) this.z)
				.putCompound("Item", item ? NBTIO.putItemHelper(new ItemBlock(new BlockAir())) : NBTItem)
				.putByte("ItemRotation", item ? 0 : this.getItemRotation());
		// TODO: This crashes the client, why?
		// .putFloat("ItemDropChance", this.getItemDropChance());
	}

	public int getAnalogOutput(){
		return this.getItem() == null || this.getItem().getId() == 0 ? 0 : this.getItemRotation() % 8 + 1;
	}

}
