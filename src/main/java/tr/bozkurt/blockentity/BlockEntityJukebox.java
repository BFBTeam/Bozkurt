package tr.bozkurt.blockentity;

import tr.bozkurt.Server;
import tr.bozkurt.block.Block;
import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemRecord;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.NBTIO;
import tr.bozkurt.nbt.tag.CompoundTag;
import tr.bozkurt.network.protocol.PlaySoundPacket;
import tr.bozkurt.network.protocol.StopSoundPacket;

import java.util.Objects;

/**
 * @author CreeperFace
 */
public class BlockEntityJukebox extends BlockEntitySpawnable{

	private Item recordItem;

	public BlockEntityJukebox(FullChunk chunk, CompoundTag nbt){
		super(chunk, nbt);
	}

	@Override
	protected void initBlockEntity(){
		if(namedTag.contains("RecordItem")){
			this.recordItem = NBTIO.getItemHelper(namedTag.getCompound("RecordItem"));
		}else{
			this.recordItem = Item.get(0);
		}

		super.initBlockEntity();
	}

	@Override
	public boolean isBlockEntityValid(){
		return this.getLevel().getBlockIdAt(getFloorX(), getFloorY(), getFloorZ()) == Block.JUKEBOX;
	}

	public Item getRecordItem(){
		return recordItem;
	}

	public void setRecordItem(Item recordItem){
		Objects.requireNonNull(recordItem, "Record item cannot be null");
		this.recordItem = recordItem;
	}

	public void play(){
		if(this.recordItem instanceof ItemRecord){
			PlaySoundPacket pk = new PlaySoundPacket();
			pk.name = ((ItemRecord) this.recordItem).getSoundId();
			pk.pitch = 1;
			pk.volume = 1;
			pk.x = getFloorX();
			pk.y = getFloorY();
			pk.z = getFloorZ();

			Server.broadcastPacket(this.level.getPlayers().values(), pk);
		}
	}

	public void stop(){
		if(this.recordItem instanceof ItemRecord){
			StopSoundPacket pk = new StopSoundPacket();
			pk.name = ((ItemRecord) this.recordItem).getSoundId();

			Server.broadcastPacket(this.level.getPlayers().values(), pk);
		}
	}

	public void dropItem(){
		if(this.recordItem.getId() != 0){
			stop();
			this.level.dropItem(this.up(), this.recordItem);
			this.recordItem = Item.get(0);
		}
	}

	@Override
	public void saveNBT(){
		super.saveNBT();
		this.namedTag.putCompound("RecordItem", NBTIO.putItemHelper(this.recordItem));
	}

	@Override
	public CompoundTag getSpawnCompound(){
		return getDefaultCompound(this, JUKEBOX)
				.putCompound("RecordItem", NBTIO.putItemHelper(this.recordItem));
	}

}
