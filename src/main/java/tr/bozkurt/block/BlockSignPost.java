package tr.bozkurt.block;

import tr.bozkurt.Player;
import tr.bozkurt.blockentity.BlockEntity;
import tr.bozkurt.blockentity.BlockEntitySign;
import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemSign;
import tr.bozkurt.item.ItemTool;
import tr.bozkurt.level.Level;
import tr.bozkurt.math.AxisAlignedBB;
import tr.bozkurt.math.BlockFace;
import tr.bozkurt.nbt.tag.CompoundTag;
import tr.bozkurt.nbt.tag.Tag;
import tr.bozkurt.utils.BlockColor;

/**
 * @author Bozkurt Project Team
 */
public class BlockSignPost extends BlockTransparentMeta{

	public BlockSignPost(){
		this(0);
	}

	public BlockSignPost(int meta){
		super(meta);
	}

	@Override
	public int getId(){
		return SIGN_POST;
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
	public boolean isSolid(){
		return false;
	}

	@Override
	public String getName(){
		return "Sign Post";
	}

	@Override
	public AxisAlignedBB getBoundingBox(){
		return null;
	}

	@Override
	public boolean place(Item item, Block block, Block target, BlockFace face, double fx, double fy, double fz, Player player){
		if(face != BlockFace.DOWN){
			CompoundTag nbt = new CompoundTag()
					.putString("id", BlockEntity.SIGN)
					.putInt("x", (int) block.x)
					.putInt("y", (int) block.y)
					.putInt("z", (int) block.z)
					.putString("Text1", "")
					.putString("Text2", "")
					.putString("Text3", "")
					.putString("Text4", "");

			if(face == BlockFace.UP){
				setDamage((int) Math.floor(((player.yaw + 180) * 16 / 360) + 0.5) & 0x0f);
				getLevel().setBlock(block, new BlockSignPost(getDamage()), true);
			}else{
				setDamage(face.getIndex());
				getLevel().setBlock(block, new BlockWallSign(getDamage()), true);
			}

			if(player != null){
				nbt.putString("Creator", player.getUniqueId().toString());
			}

			if(item.hasCustomBlockData()){
				for(Tag aTag : item.getCustomBlockData().getAllTags()){
					nbt.put(aTag.getName(), aTag);
				}
			}

			new BlockEntitySign(getLevel().getChunk((int) block.x >> 4, (int) block.z >> 4), nbt);

			return true;
		}

		return false;
	}

	@Override
	public int onUpdate(int type){
		if(type == Level.BLOCK_UPDATE_NORMAL){
			if(down().getId() == Block.AIR){
				getLevel().useBreakOn(this);

				return Level.BLOCK_UPDATE_NORMAL;
			}
		}

		return 0;
	}

	@Override
	public Item toItem(){
		return new ItemSign();
	}

	@Override
	public int getToolType(){
		return ItemTool.TYPE_AXE;
	}

	@Override
	public BlockColor getColor(){
		return BlockColor.AIR_BLOCK_COLOR;
	}

}
