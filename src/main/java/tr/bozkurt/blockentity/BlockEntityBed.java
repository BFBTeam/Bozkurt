package tr.bozkurt.blockentity;

import tr.bozkurt.item.Item;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;
import tr.bozkurt.utils.DyeColor;

/**
 * Created by CreeperFace on 2.6.2017.
 */
public class BlockEntityBed extends BlockEntitySpawnable{

	public int color;

	public BlockEntityBed(FullChunk chunk, CompoundTag nbt){
		super(chunk, nbt);
	}

	@Override
	protected void initBlockEntity(){
		if(!this.namedTag.contains("color")){
			this.namedTag.putByte("color", 0);
		}

		this.color = this.namedTag.getByte("color");

		super.initBlockEntity();
	}

	@Override
	public boolean isBlockEntityValid(){
		return this.level.getBlockIdAt(this.getFloorX(), this.getFloorY(), this.getFloorZ()) == Item.BED_BLOCK;
	}

	@Override
	public void saveNBT(){
		super.saveNBT();
		this.namedTag.putByte("color", this.color);
	}

	@Override
	public CompoundTag getSpawnCompound(){
		return new CompoundTag()
				.putString("id", BlockEntity.BED)
				.putInt("x", (int) this.x)
				.putInt("y", (int) this.y)
				.putInt("z", (int) this.z)
				.putByte("color", this.color);
	}

	public DyeColor getDyeColor(){
		return DyeColor.getByWoolData(color);
	}

}
