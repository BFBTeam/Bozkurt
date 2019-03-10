package tr.bozkurt.item;

import tr.bozkurt.Player;
import tr.bozkurt.block.Block;
import tr.bozkurt.block.BlockRail;
import tr.bozkurt.entity.item.EntityMinecartEmpty;
import tr.bozkurt.level.Level;
import tr.bozkurt.math.BlockFace;
import tr.bozkurt.nbt.tag.CompoundTag;
import tr.bozkurt.nbt.tag.DoubleTag;
import tr.bozkurt.nbt.tag.FloatTag;
import tr.bozkurt.nbt.tag.ListTag;
import tr.bozkurt.utils.Rail;

/**
 * Bozkurt Project
 */
public class ItemMinecart extends Item{

	public ItemMinecart(){
		this(0, 1);
	}

	public ItemMinecart(Integer meta){
		this(meta, 1);
	}

	public ItemMinecart(Integer meta, int count){
		super(MINECART, meta, count, "Minecart");
	}

	@Override
	public boolean canBeActivated(){
		return true;
	}

	@Override
	public boolean onActivate(Level level, Player player, Block block, Block target, BlockFace face, double fx, double fy, double fz){
		if(Rail.isRailBlock(target)){
			Rail.Orientation type = ((BlockRail) target).getOrientation();
			double adjacent = 0.0D;
			if(type.isAscending()){
				adjacent = 0.5D;
			}
			EntityMinecartEmpty minecart = new EntityMinecartEmpty(
					level.getChunk(target.getFloorX() >> 4, target.getFloorZ() >> 4), new CompoundTag("")
					.putList(new ListTag<>("Pos")
							.add(new DoubleTag("", target.getX() + 0.5))
							.add(new DoubleTag("", target.getY() + 0.0625D + adjacent))
							.add(new DoubleTag("", target.getZ() + 0.5)))
					.putList(new ListTag<>("Motion")
							.add(new DoubleTag("", 0))
							.add(new DoubleTag("", 0))
							.add(new DoubleTag("", 0)))
					.putList(new ListTag<>("Rotation")
							.add(new FloatTag("", 0))
							.add(new FloatTag("", 0)))
			);
			minecart.spawnToAll();
			count -= 1;
			return true;
		}
		return false;
	}

	@Override
	public int getMaxStackSize(){
		return 1;
	}

}
