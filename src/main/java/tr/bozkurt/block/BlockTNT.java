package tr.bozkurt.block;

import tr.bozkurt.Player;
import tr.bozkurt.entity.Entity;
import tr.bozkurt.entity.item.EntityPrimedTNT;
import tr.bozkurt.item.Item;
import tr.bozkurt.level.Level;
import tr.bozkurt.level.Sound;
import tr.bozkurt.math.BozkurtRandom;
import tr.bozkurt.nbt.tag.CompoundTag;
import tr.bozkurt.nbt.tag.DoubleTag;
import tr.bozkurt.nbt.tag.FloatTag;
import tr.bozkurt.nbt.tag.ListTag;
import tr.bozkurt.utils.BlockColor;

/**
 * Created on 2015/12/8 by xtypr.
 * Package tr.bozkurt.block in project Bozkurt.
 */
public class BlockTNT extends BlockSolid{

	public BlockTNT(){
	}

	@Override
	public String getName(){
		return "TNT";
	}

	@Override
	public int getId(){
		return TNT;
	}

	@Override
	public double getHardness(){
		return 0;
	}

	@Override
	public double getResistance(){
		return 0;
	}

	@Override
	public boolean canBeActivated(){
		return true;
	}

	@Override
	public int getBurnChance(){
		return 15;
	}

	@Override
	public int getBurnAbility(){
		return 100;
	}

	public void prime(){
		this.prime(80);
	}

	public void prime(int fuse){
		prime(fuse, null);
	}

	public void prime(int fuse, Entity source){
		this.getLevel().setBlock(this, new BlockAir(), true);
		double mot = (new BozkurtRandom()).nextSignedFloat() * Math.PI * 2;
		CompoundTag nbt = new CompoundTag()
				.putList(new ListTag<DoubleTag>("Pos")
						.add(new DoubleTag("", this.x + 0.5))
						.add(new DoubleTag("", this.y))
						.add(new DoubleTag("", this.z + 0.5)))
				.putList(new ListTag<DoubleTag>("Motion")
						.add(new DoubleTag("", -Math.sin(mot) * 0.02))
						.add(new DoubleTag("", 0.2))
						.add(new DoubleTag("", -Math.cos(mot) * 0.02)))
				.putList(new ListTag<FloatTag>("Rotation")
						.add(new FloatTag("", 0))
						.add(new FloatTag("", 0)))
				.putShort("Fuse", fuse);
		Entity tnt = new EntityPrimedTNT(
				this.getLevel().getChunk(this.getFloorX() >> 4, this.getFloorZ() >> 4),
				nbt, source
		);
		tnt.spawnToAll();
		this.level.addSound(this, Sound.RANDOM_FUSE);
	}

	@Override
	public int onUpdate(int type){
		if((type == Level.BLOCK_UPDATE_NORMAL || type == Level.BLOCK_UPDATE_REDSTONE) && this.level.isBlockPowered(this.getLocation())){
			this.prime();
		}

		return 0;
	}

	@Override
	public boolean onActivate(Item item, Player player){
		if(item.getId() == Item.FLINT_STEEL){
			item.useOn(this);
			this.prime(80, player);
			return true;
		}
		if(item.getId() == Item.FIRE_CHARGE){
			if(!player.isCreative()) player.getInventory().removeItem(Item.get(Item.FIRE_CHARGE, 0, 1));
			this.level.addSound(player, Sound.MOB_GHAST_FIREBALL);
			this.prime(80, player);
			return true;
		}
		return false;
	}

	@Override
	public BlockColor getColor(){
		return BlockColor.TNT_BLOCK_COLOR;
	}

}
