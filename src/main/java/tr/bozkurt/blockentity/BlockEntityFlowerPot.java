package tr.bozkurt.blockentity;

import tr.bozkurt.block.Block;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;

/**
 * Created by Snake1999 on 2016/2/4.
 * Package tr.bozkurt.blockentity in project Bozkurt.
 */
public class BlockEntityFlowerPot extends BlockEntitySpawnable{

	public BlockEntityFlowerPot(FullChunk chunk, CompoundTag nbt){
		super(chunk, nbt);
	}

	@Override
	protected void initBlockEntity(){
		if(!namedTag.contains("item")){
			namedTag.putShort("item", 0);
		}

		if(!namedTag.contains("data")){
			if(namedTag.contains("mData")){
				namedTag.putInt("data", namedTag.getInt("mData"));
				namedTag.remove("mData");
			}else{
				namedTag.putInt("data", 0);
			}
		}

		super.initBlockEntity();
	}

	@Override
	public boolean isBlockEntityValid(){
		int blockID = getBlock().getId();
		return blockID == Block.FLOWER_POT_BLOCK;
	}

	@Override
	public CompoundTag getSpawnCompound(){
		return new CompoundTag()
				.putString("id", BlockEntity.FLOWER_POT)
				.putInt("x", (int) this.x)
				.putInt("y", (int) this.y)
				.putInt("z", (int) this.z)
				.putShort("item", this.namedTag.getShort("item"))
				.putInt("mData", this.namedTag.getInt("data"));
	}

}
