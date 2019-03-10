package tr.bozkurt.block;

import tr.bozkurt.Player;
import tr.bozkurt.blockentity.BlockEntity;
import tr.bozkurt.blockentity.BlockEntityJukebox;
import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemRecord;
import tr.bozkurt.math.BlockFace;
import tr.bozkurt.nbt.tag.CompoundTag;
import tr.bozkurt.nbt.tag.ListTag;

/**
 * Created by CreeperFace on 7.8.2017.
 */
public class BlockJukebox extends BlockSolid{

	public BlockJukebox(){
	}

	@Override
	public String getName(){
		return "Jukebox";
	}

	@Override
	public int getId(){
		return JUKEBOX;
	}

	@Override
	public boolean canBeActivated(){
		return true;
	}

	@Override
	public boolean onActivate(Item item, Player player){
		BlockEntity blockEntity = this.getLevel().getBlockEntity(this);
		if(blockEntity == null || !(blockEntity instanceof BlockEntityJukebox)){
			blockEntity = this.createBlockEntity();
		}

		BlockEntityJukebox jukebox = (BlockEntityJukebox) blockEntity;
		if(jukebox.getRecordItem().getId() != 0){
			jukebox.dropItem();
		}else if(item instanceof ItemRecord){
			jukebox.setRecordItem(item);
			jukebox.play();
			player.getInventory().decreaseCount(player.getInventory().getHeldItemIndex());
		}

		return false;
	}

	@Override
	public boolean place(Item item, Block block, Block target, BlockFace face, double fx, double fy, double fz, Player player){
		if(super.place(item, block, target, face, fx, fy, fz, player)){
			createBlockEntity();
			return true;
		}

		return false;
	}

	@Override
	public boolean onBreak(Item item){
		if(super.onBreak(item)){
			BlockEntity blockEntity = this.level.getBlockEntity(this);

			if(blockEntity instanceof BlockEntityJukebox){
				((BlockEntityJukebox) blockEntity).dropItem();
			}
			return true;
		}

		return false;
	}

	private BlockEntity createBlockEntity(){
		CompoundTag nbt = new CompoundTag()
				.putList(new ListTag<>("Items"))
				.putString("id", BlockEntity.JUKEBOX)
				.putInt("x", getFloorX())
				.putInt("y", getFloorY())
				.putInt("z", getFloorZ());

		return BlockEntity.createBlockEntity(BlockEntity.JUKEBOX, this.level.getChunk(getFloorX() >> 4, getFloorZ() >> 4), nbt);
	}

}
