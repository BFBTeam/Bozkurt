package tr.bozkurt.block;

import tr.bozkurt.Player;
import tr.bozkurt.blockentity.BlockEntity;
import tr.bozkurt.blockentity.BlockEntityChest;
import tr.bozkurt.inventory.ContainerInventory;
import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemTool;
import tr.bozkurt.math.BlockFace;
import tr.bozkurt.nbt.tag.CompoundTag;
import tr.bozkurt.nbt.tag.ListTag;
import tr.bozkurt.nbt.tag.StringTag;
import tr.bozkurt.nbt.tag.Tag;
import tr.bozkurt.utils.BlockColor;

import java.util.Map;

/**
 * author: Angelic47
 * Bozkurt Project
 */
public class BlockChest extends BlockTransparentMeta{

	public BlockChest(){
		this(0);
	}

	public BlockChest(int meta){
		super(meta);
	}

	@Override
	public boolean canBeActivated(){
		return true;
	}

	@Override
	public int getId(){
		return CHEST;
	}

	@Override
	public String getName(){
		return "Chest";
	}

	@Override
	public double getHardness(){
		return 2.5;
	}

	@Override
	public double getResistance(){
		return 12.5;
	}

	@Override
	public int getToolType(){
		return ItemTool.TYPE_AXE;
	}

	@Override
	public double getMinX(){
		return this.x + 0.0625;
	}

	@Override
	public double getMinY(){
		return this.y;
	}

	@Override
	public double getMinZ(){
		return this.z + 0.0625;
	}

	@Override
	public double getMaxX(){
		return this.x + 0.9375;
	}

	@Override
	public double getMaxY(){
		return this.y + 0.9475;
	}

	@Override
	public double getMaxZ(){
		return this.z + 0.9375;
	}


	@Override
	public boolean place(Item item, Block block, Block target, BlockFace face, double fx, double fy, double fz, Player player){
		BlockEntityChest chest = null;
		int[] faces = {2, 5, 3, 4};
		this.setDamage(faces[player != null ? player.getDirection().getHorizontalIndex() : 0]);

		for(int side = 2; side <= 5; ++side){
			if((this.getDamage() == 4 || this.getDamage() == 5) && (side == 4 || side == 5)){
				continue;
			}else if((this.getDamage() == 3 || this.getDamage() == 2) && (side == 2 || side == 3)){
				continue;
			}
			Block c = this.getSide(BlockFace.fromIndex(side));
			if(c instanceof BlockChest && c.getDamage() == this.getDamage()){
				BlockEntity blockEntity = this.getLevel().getBlockEntity(c);
				if(blockEntity instanceof BlockEntityChest && !((BlockEntityChest) blockEntity).isPaired()){
					chest = (BlockEntityChest) blockEntity;
					break;
				}
			}
		}

		this.getLevel().setBlock(block, this, true, true);
		CompoundTag nbt = new CompoundTag("")
				.putList(new ListTag<>("Items"))
				.putString("id", BlockEntity.CHEST)
				.putInt("x", (int) this.x)
				.putInt("y", (int) this.y)
				.putInt("z", (int) this.z);

		if(item.hasCustomName()){
			nbt.putString("CustomName", item.getCustomName());
		}

		if(item.hasCustomBlockData()){
			Map<String, Tag> customData = item.getCustomBlockData().getTags();
			for(Map.Entry<String, Tag> tag : customData.entrySet()){
				nbt.put(tag.getKey(), tag.getValue());
			}
		}

		BlockEntity blockEntity = new BlockEntityChest(this.getLevel().getChunk((int) (this.x) >> 4, (int) (this.z) >> 4), nbt);

		if(chest != null){
			chest.pairWith(((BlockEntityChest) blockEntity));
			((BlockEntityChest) blockEntity).pairWith(chest);
		}

		return true;
	}

	@Override
	public boolean onBreak(Item item){
		BlockEntity t = this.getLevel().getBlockEntity(this);
		if(t instanceof BlockEntityChest){
			((BlockEntityChest) t).unpair();
		}
		this.getLevel().setBlock(this, new BlockAir(), true, true);

		return true;
	}

	@Override
	public boolean onActivate(Item item, Player player){
		if(player != null){
			Block top = up();
			if(!top.isTransparent()){
				return true;
			}

			BlockEntity t = this.getLevel().getBlockEntity(this);
			BlockEntityChest chest;
			if(t instanceof BlockEntityChest){
				chest = (BlockEntityChest) t;
			}else{
				CompoundTag nbt = new CompoundTag("")
						.putList(new ListTag<>("Items"))
						.putString("id", BlockEntity.CHEST)
						.putInt("x", (int) this.x)
						.putInt("y", (int) this.y)
						.putInt("z", (int) this.z);
				chest = new BlockEntityChest(this.getLevel().getChunk((int) (this.x) >> 4, (int) (this.z) >> 4), nbt);
			}

			if(chest.namedTag.contains("Lock") && chest.namedTag.get("Lock") instanceof StringTag){
				if(!chest.namedTag.getString("Lock").equals(item.getCustomName())){
					return true;
				}
			}

			player.addWindow(chest.getInventory());
		}

		return true;
	}

	@Override
	public BlockColor getColor(){
		return BlockColor.WOOD_BLOCK_COLOR;
	}

	public boolean hasComparatorInputOverride(){
		return true;
	}

	public int getComparatorInputOverride(){
		BlockEntity blockEntity = this.level.getBlockEntity(this);

		if(blockEntity instanceof BlockEntityChest){
			return ContainerInventory.calculateRedstone(((BlockEntityChest) blockEntity).getInventory());
		}

		return super.getComparatorInputOverride();
	}

}
