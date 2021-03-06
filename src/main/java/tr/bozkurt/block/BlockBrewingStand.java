package tr.bozkurt.block;


import tr.bozkurt.Player;
import tr.bozkurt.blockentity.BlockEntity;
import tr.bozkurt.blockentity.BlockEntityBrewingStand;
import tr.bozkurt.inventory.ContainerInventory;
import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemBrewingStand;
import tr.bozkurt.item.ItemTool;
import tr.bozkurt.math.BlockFace;
import tr.bozkurt.nbt.tag.CompoundTag;
import tr.bozkurt.nbt.tag.ListTag;
import tr.bozkurt.nbt.tag.StringTag;
import tr.bozkurt.nbt.tag.Tag;
import tr.bozkurt.utils.BlockColor;

import java.util.Map;

public class BlockBrewingStand extends BlockSolidMeta{

	public BlockBrewingStand(){
		this(0);
	}

	public BlockBrewingStand(int meta){
		super(meta);
	}

	@Override
	public String getName(){
		return "Brewing Stand";
	}

	@Override
	public boolean canBeActivated(){
		return true;
	}

	@Override
	public double getHardness(){
		return 0.5;
	}

	@Override
	public double getResistance(){
		return 2.5;
	}

	@Override
	public int getToolType(){
		return ItemTool.TYPE_PICKAXE;
	}

	@Override
	public int getId(){
		return BREWING_STAND_BLOCK;
	}

	@Override
	public int getLightLevel(){
		return 1;
	}

	@Override
	public boolean place(Item item, Block block, Block target, BlockFace face, double fx, double fy, double fz, Player player){
		if(!block.down().isTransparent()){
			getLevel().setBlock(block, this, true, true);

			CompoundTag nbt = new CompoundTag()
					.putList(new ListTag<>("Items"))
					.putString("id", BlockEntity.BREWING_STAND)
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

			new BlockEntityBrewingStand(getLevel().getChunk((int) this.x >> 4, (int) this.z >> 4), nbt);

			return true;
		}
		return false;
	}

	@Override
	public boolean onActivate(Item item, Player player){
		if(player != null){
			BlockEntity t = getLevel().getBlockEntity(this);
			BlockEntityBrewingStand brewing;
			if(t instanceof BlockEntityBrewingStand){
				brewing = (BlockEntityBrewingStand) t;
			}else{
				CompoundTag nbt = new CompoundTag()
						.putList(new ListTag<>("Items"))
						.putString("id", BlockEntity.BREWING_STAND)
						.putInt("x", (int) this.x)
						.putInt("y", (int) this.y)
						.putInt("z", (int) this.z);
				brewing = new BlockEntityBrewingStand(this.getLevel().getChunk((int) (this.x) >> 4, (int) (this.z) >> 4), nbt);
			}

			if(brewing.namedTag.contains("Lock") && brewing.namedTag.get("Lock") instanceof StringTag){
				if(!brewing.namedTag.getString("Lock").equals(item.getCustomName())){
					return false;
				}
			}

			player.addWindow(brewing.getInventory());
		}

		return true;
	}

	@Override
	public Item toItem(){
		return new ItemBrewingStand();
	}

	@Override
	public Item[] getDrops(Item item){
		if(item.isPickaxe() && item.getTier() >= ItemTool.TIER_WOODEN){
			return new Item[]{
					toItem()
			};
		}else{
			return new Item[0];
		}
	}

	@Override
	public BlockColor getColor(){
		return BlockColor.IRON_BLOCK_COLOR;
	}

	public boolean hasComparatorInputOverride(){
		return true;
	}

	@Override
	public int getComparatorInputOverride(){
		BlockEntity blockEntity = this.level.getBlockEntity(this);

		if(blockEntity instanceof BlockEntityBrewingStand){
			return ContainerInventory.calculateRedstone(((BlockEntityBrewingStand) blockEntity).getInventory());
		}

		return super.getComparatorInputOverride();
	}

	@Override
	public boolean canHarvestWithHand(){
		return false;
	}

}
