package tr.bozkurt.block;

import tr.bozkurt.Player;
import tr.bozkurt.blockentity.BlockEntity;
import tr.bozkurt.blockentity.BlockEntityHopper;
import tr.bozkurt.inventory.ContainerInventory;
import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemHopper;
import tr.bozkurt.item.ItemTool;
import tr.bozkurt.level.Level;
import tr.bozkurt.math.BlockFace;
import tr.bozkurt.nbt.tag.CompoundTag;
import tr.bozkurt.nbt.tag.ListTag;

/**
 * @author CreeperFace
 */
public class BlockHopper extends BlockTransparentMeta{

	public BlockHopper(){
		this(0);
	}

	public BlockHopper(int meta){
		super(meta);
	}

	@Override
	public int getId(){
		return HOPPER_BLOCK;
	}

	@Override
	public String getName(){
		return "Hopper Block";
	}

	@Override
	public double getHardness(){
		return 3;
	}

	@Override
	public double getResistance(){
		return 24;
	}

	@Override
	public boolean place(Item item, Block block, Block target, BlockFace face, double fx, double fy, double fz, Player player){
		BlockFace facing = face.getOpposite();

		if(facing == BlockFace.UP){
			facing = BlockFace.DOWN;
		}

		this.setDamage(facing.getIndex());

		boolean powered = this.level.isBlockPowered(this.getLocation());

		if(powered == this.isEnabled()){
			this.setEnabled(!powered);
		}

		this.level.setBlock(this, this);

		CompoundTag nbt = new CompoundTag()
				.putList(new ListTag<>("Items"))
				.putString("id", BlockEntity.HOPPER)
				.putInt("x", (int) this.x)
				.putInt("y", (int) this.y)
				.putInt("z", (int) this.z);

		new BlockEntityHopper(this.level.getChunk(this.getFloorX() >> 4, this.getFloorZ() >> 4), nbt);
		return true;
	}

	@Override
	public boolean onActivate(Item item, Player player){
		BlockEntity blockEntity = this.level.getBlockEntity(this);

		if(blockEntity instanceof BlockEntityHopper){
			return player.addWindow(((BlockEntityHopper) blockEntity).getInventory()) != -1;
		}

		return false;
	}

	@Override
	public boolean canBeActivated(){
		return true;
	}

	public boolean hasComparatorInputOverride(){
		return true;
	}

	@Override
	public int getComparatorInputOverride(){
		BlockEntity blockEntity = this.level.getBlockEntity(this);

		if(blockEntity instanceof BlockEntityHopper){
			return ContainerInventory.calculateRedstone(((BlockEntityHopper) blockEntity).getInventory());
		}

		return super.getComparatorInputOverride();
	}

	public BlockFace getFacing(){
		return BlockFace.fromIndex(this.getDamage() & 7);
	}

	public boolean isEnabled(){
		return (this.getDamage() & 0x08) != 8;
	}

	public void setEnabled(boolean enabled){
		if(isEnabled() != enabled){
			this.setDamage(this.getDamage() ^ 0x08);
		}
	}

	@Override
	public int onUpdate(int type){
		if(type == Level.BLOCK_UPDATE_NORMAL){
			boolean powered = this.level.isBlockPowered(this.getLocation());

			if(powered == this.isEnabled()){
				this.setEnabled(!powered);
				this.level.setBlock(this, this, true, false);
			}

			return type;
		}

		return 0;
	}

	@Override
	public int getToolType(){
		return ItemTool.TYPE_PICKAXE;
	}

	@Override
	public Item[] getDrops(Item item){
		if(item.getTier() >= ItemTool.TIER_WOODEN){
			return new Item[]{toItem()};
		}

		return new Item[0];
	}

	@Override
	public Item toItem(){
		return new ItemHopper();
	}

	@Override
	public boolean canHarvestWithHand(){
		return false;
	}

}
