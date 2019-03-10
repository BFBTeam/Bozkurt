package tr.bozkurt.block;

import tr.bozkurt.Player;
import tr.bozkurt.blockentity.BlockEntity;
import tr.bozkurt.blockentity.BlockEntityFurnace;
import tr.bozkurt.inventory.ContainerInventory;
import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemBlock;
import tr.bozkurt.item.ItemTool;
import tr.bozkurt.math.BlockFace;
import tr.bozkurt.nbt.tag.CompoundTag;
import tr.bozkurt.nbt.tag.ListTag;
import tr.bozkurt.nbt.tag.StringTag;
import tr.bozkurt.nbt.tag.Tag;

import java.util.Map;

/**
 * author: Angelic47
 * Bozkurt Project
 */
public class BlockFurnaceBurning extends BlockSolidMeta{

	public BlockFurnaceBurning(){
		this(0);
	}

	public BlockFurnaceBurning(int meta){
		super(meta);
	}

	@Override
	public int getId(){
		return BURNING_FURNACE;
	}

	@Override
	public String getName(){
		return "Burning Furnace";
	}

	@Override
	public boolean canBeActivated(){
		return true;
	}

	@Override
	public double getHardness(){
		return 3.5;
	}

	@Override
	public double getResistance(){
		return 17.5;
	}

	@Override
	public int getToolType(){
		return ItemTool.TYPE_PICKAXE;
	}

	@Override
	public int getLightLevel(){
		return 13;
	}

	@Override
	public boolean place(Item item, Block block, Block target, BlockFace face, double fx, double fy, double fz, Player player){
		int faces[] = {2, 5, 3, 4};
		this.setDamage(faces[player != null ? player.getDirection().getHorizontalIndex() : 0]);
		this.getLevel().setBlock(block, this, true, true);
		CompoundTag nbt = new CompoundTag()
				.putList(new ListTag<>("Items"))
				.putString("id", BlockEntity.FURNACE)
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

		new BlockEntityFurnace(this.getLevel().getChunk((int) (this.x) >> 4, (int) (this.z) >> 4), nbt);

		return true;
	}

	@Override
	public boolean onBreak(Item item){
		this.getLevel().setBlock(this, new BlockAir(), true, true);
		return true;
	}

	@Override
	public boolean onActivate(Item item, Player player){
		if(player != null){
			BlockEntity t = this.getLevel().getBlockEntity(this);
			BlockEntityFurnace furnace;
			if(t instanceof BlockEntityFurnace){
				furnace = (BlockEntityFurnace) t;
			}else{
				CompoundTag nbt = new CompoundTag()
						.putList(new ListTag<>("Items"))
						.putString("id", BlockEntity.FURNACE)
						.putInt("x", (int) this.x)
						.putInt("y", (int) this.y)
						.putInt("z", (int) this.z);
				furnace = new BlockEntityFurnace(this.getLevel().getChunk((int) (this.x) >> 4, (int) (this.z) >> 4), nbt);
			}

			if(furnace.namedTag.contains("Lock") && furnace.namedTag.get("Lock") instanceof StringTag){
				if(!furnace.namedTag.getString("Lock").equals(item.getCustomName())){
					return true;
				}
			}

			player.addWindow(furnace.getInventory());
		}

		return true;
	}

	@Override
	public Item[] getDrops(Item item){
		if(item.isPickaxe() && item.getTier() >= ItemTool.TIER_WOODEN){
			return new Item[]{
					new ItemBlock(new BlockFurnace())
			};
		}else{
			return new Item[0];
		}
	}

	public boolean hasComparatorInputOverride(){
		return true;
	}

	@Override
	public int getComparatorInputOverride(){
		BlockEntity blockEntity = this.level.getBlockEntity(this);

		if(blockEntity instanceof BlockEntityFurnace){
			return ContainerInventory.calculateRedstone(((BlockEntityFurnace) blockEntity).getInventory());
		}

		return super.getComparatorInputOverride();
	}

	@Override
	public boolean canHarvestWithHand(){
		return false;
	}

}
