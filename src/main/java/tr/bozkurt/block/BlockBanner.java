package tr.bozkurt.block;

import tr.bozkurt.Player;
import tr.bozkurt.blockentity.BlockEntity;
import tr.bozkurt.blockentity.BlockEntityBanner;
import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemBanner;
import tr.bozkurt.item.ItemTool;
import tr.bozkurt.level.Level;
import tr.bozkurt.math.AxisAlignedBB;
import tr.bozkurt.math.BlockFace;
import tr.bozkurt.math.BozkurtMath;
import tr.bozkurt.nbt.tag.CompoundTag;

public class BlockBanner extends BlockTransparentMeta{

	public BlockBanner(){
		this(0);
	}

	public BlockBanner(int meta){
		super(meta);
	}

	@Override
	public int getId(){
		return STANDING_BANNER;
	}

	@Override
	public double getHardness(){
		return 1;
	}

	@Override
	public double getResistance(){
		return 5;
	}

	@Override
	public int getToolType(){
		return ItemTool.TYPE_AXE;
	}

	@Override
	public String getName(){
		return "Banner";
	}

	@Override
	protected AxisAlignedBB recalculateBoundingBox(){
		return null;
	}

	@Override
	public boolean canPassThrough(){
		return true;
	}

	@Override
	public boolean place(Item item, Block block, Block target, BlockFace face, double fx, double fy, double fz, Player player){
		if(face != BlockFace.DOWN){
			if(face == BlockFace.UP){
				this.setDamage(BozkurtMath.floorDouble(((player.yaw + 180) * 16 / 360) + 0.5) & 0x0f);
				this.getLevel().setBlock(block, this, true);
			}else{
				this.setDamage(face.getIndex());
				this.getLevel().setBlock(block, new BlockWallBanner(this.getDamage()), true);
			}

			CompoundTag nbt = new CompoundTag("")
					.putString("id", BlockEntity.BANNER)
					.putInt("x", (int) this.x)
					.putInt("y", (int) this.y)
					.putInt("z", (int) this.z)
					.putInt("Base", item.getDamage() & 0x0f);
			new BlockEntityBanner(this.level.getChunk((int) this.x >> 4, (int) this.z >> 4), nbt);

			return true;
		}
		return false;
	}

	@Override
	public int onUpdate(int type){
		if(type == Level.BLOCK_UPDATE_NORMAL){
			if(this.down().getId() == Block.AIR){
				this.getLevel().useBreakOn(this);

				return Level.BLOCK_UPDATE_NORMAL;
			}
		}

		return 0;
	}

	@Override
	public Item toItem(){
		return new ItemBanner(this.getDamage() & 0x0f);
	}

}