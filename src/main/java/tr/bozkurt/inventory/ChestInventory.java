package tr.bozkurt.inventory;

import tr.bozkurt.Player;
import tr.bozkurt.blockentity.BlockEntityChest;
import tr.bozkurt.level.Level;
import tr.bozkurt.level.Sound;
import tr.bozkurt.network.protocol.BlockEventPacket;

/**
 * Bozkurt Project
 */
public class ChestInventory extends ContainerInventory{

	protected DoubleChestInventory doubleInventory;

	public ChestInventory(BlockEntityChest chest){
		super(chest, InventoryType.CHEST);
	}

	@Override
	public BlockEntityChest getHolder(){
		return (BlockEntityChest) this.holder;
	}

	@Override
	public void onOpen(Player who){
		super.onOpen(who);

		if(this.getViewers().size() == 1){
			BlockEventPacket pk = new BlockEventPacket();
			pk.x = (int) this.getHolder().getX();
			pk.y = (int) this.getHolder().getY();
			pk.z = (int) this.getHolder().getZ();
			pk.case1 = 1;
			pk.case2 = 2;

			Level level = this.getHolder().getLevel();
			if(level != null){
				level.addSound(this.getHolder().add(0.5, 0.5, 0.5), Sound.RANDOM_CHESTOPEN);
				level.addChunkPacket((int) this.getHolder().getX() >> 4, (int) this.getHolder().getZ() >> 4, pk);
			}
		}
	}

	@Override
	public void onClose(Player who){
		if(this.getViewers().size() == 1){
			BlockEventPacket pk = new BlockEventPacket();
			pk.x = (int) this.getHolder().getX();
			pk.y = (int) this.getHolder().getY();
			pk.z = (int) this.getHolder().getZ();
			pk.case1 = 1;
			pk.case2 = 0;

			Level level = this.getHolder().getLevel();
			if(level != null){
				level.addSound(this.getHolder().add(0.5, 0.5, 0.5), Sound.RANDOM_CHESTCLOSED);
				level.addChunkPacket((int) this.getHolder().getX() >> 4, (int) this.getHolder().getZ() >> 4, pk);
			}
		}

		super.onClose(who);
	}

	public DoubleChestInventory getDoubleInventory(){
		return doubleInventory;
	}

	public void setDoubleInventory(DoubleChestInventory doubleInventory){
		this.doubleInventory = doubleInventory;
	}

	@Override
	public void sendSlot(int index, Player... players){
		if(this.doubleInventory != null){
			this.doubleInventory.sendSlot(this, index, players);
		}else{
			super.sendSlot(index, players);
		}
	}

}
