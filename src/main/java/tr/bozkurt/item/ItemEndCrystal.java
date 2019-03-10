package tr.bozkurt.item;

import tr.bozkurt.Player;
import tr.bozkurt.block.Block;
import tr.bozkurt.block.BlockBedrock;
import tr.bozkurt.block.BlockObsidian;
import tr.bozkurt.entity.Entity;
import tr.bozkurt.level.Level;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.math.BlockFace;
import tr.bozkurt.nbt.tag.CompoundTag;
import tr.bozkurt.nbt.tag.DoubleTag;
import tr.bozkurt.nbt.tag.FloatTag;
import tr.bozkurt.nbt.tag.ListTag;

import java.util.Random;

public class ItemEndCrystal extends Item{

	public ItemEndCrystal(){
		this(0, 1);
	}

	public ItemEndCrystal(Integer meta){
		this(meta, 1);
	}

	public ItemEndCrystal(Integer meta, int count){
		super(END_CRYSTAL, meta, count, "End Crystal");
	}

	@Override
	public boolean canBeActivated(){
		return true;
	}

	@Override
	public boolean onActivate(Level level, Player player, Block block, Block target, BlockFace face, double fx, double fy, double fz){
		if(!(target instanceof BlockBedrock) && !(target instanceof BlockObsidian)) return false;
		FullChunk chunk = level.getChunk((int) block.getX() >> 4, (int) block.getZ() >> 4);

		if(chunk == null){
			return false;
		}

		CompoundTag nbt = new CompoundTag()
				.putList(new ListTag<DoubleTag>("Pos")
						.add(new DoubleTag("", block.getX() + 0.5))
						.add(new DoubleTag("", block.getY()))
						.add(new DoubleTag("", block.getZ() + 0.5)))
				.putList(new ListTag<DoubleTag>("Motion")
						.add(new DoubleTag("", 0))
						.add(new DoubleTag("", 0))
						.add(new DoubleTag("", 0)))
				.putList(new ListTag<FloatTag>("Rotation")
						.add(new FloatTag("", new Random().nextFloat() * 360))
						.add(new FloatTag("", 0)));

		if(this.hasCustomName()){
			nbt.putString("CustomName", this.getCustomName());
		}

		Entity entity = Entity.createEntity("EndCrystal", chunk, nbt);

		if(entity != null){
			if(player.isSurvival()){
				Item item = player.getInventory().getItemInHand();
				item.setCount(item.getCount() - 1);
				player.getInventory().setItemInHand(item);
			}
			entity.spawnToAll();
			return true;
		}
		return false;
	}

}
