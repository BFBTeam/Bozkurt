package tr.bozkurt.block;

import tr.bozkurt.Player;
import tr.bozkurt.blockentity.BlockEntity;
import tr.bozkurt.blockentity.BlockEntityBeacon;
import tr.bozkurt.inventory.BeaconInventory;
import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemTool;
import tr.bozkurt.math.BlockFace;
import tr.bozkurt.nbt.tag.CompoundTag;

/**
 * author: Angelic47 Bozkurt Project
 */
public class BlockBeacon extends BlockTransparent{

	public BlockBeacon(){
	}

	@Override
	public int getId(){
		return BEACON;
	}

	@Override
	public double getHardness(){
		return 3;
	}

	@Override
	public double getResistance(){
		return 15;
	}

	@Override
	public int getLightLevel(){
		return 15;
	}

	@Override
	public int getToolType(){
		return ItemTool.TYPE_PICKAXE;
	}

	@Override
	public String getName(){
		return "Beacon";
	}

	@Override
	public boolean canBeActivated(){
		return true;
	}

	@Override
	public boolean onActivate(Item item, Player player){
		if(player != null){

			BlockEntity t = this.getLevel().getBlockEntity(this);
			BlockEntityBeacon beacon;
			if(t instanceof BlockEntityBeacon){
				beacon = (BlockEntityBeacon) t;
			}else{
				CompoundTag nbt = new CompoundTag("")
						.putString("id", BlockEntity.BEACON)
						.putInt("x", (int) this.x)
						.putInt("y", (int) this.y)
						.putInt("z", (int) this.z);
				beacon = new BlockEntityBeacon(this.getLevel().getChunk((int) (this.x) >> 4, (int) (this.z) >> 4), nbt);
			}

			player.addWindow(new BeaconInventory(this), Player.BEACON_WINDOW_ID);
		}
		return true;
	}

	@Override
	public boolean place(Item item, Block block, Block target, BlockFace face, double fx, double fy, double fz, Player player){
		boolean blockSuccess = super.place(item, block, target, face, fx, fy, fz, player);

		if(blockSuccess){
			CompoundTag nbt = new CompoundTag("")
					.putString("id", BlockEntity.BEACON)
					.putInt("x", (int) this.x)
					.putInt("y", (int) this.y)
					.putInt("z", (int) this.z);
			new BlockEntityBeacon(this.level.getChunk((int) this.x >> 4, (int) this.z >> 4), nbt);
		}

		return blockSuccess;
	}

	@Override
	public boolean canBePushed(){
		return false;
	}

}
