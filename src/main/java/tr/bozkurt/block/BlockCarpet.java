package tr.bozkurt.block;

import tr.bozkurt.Player;
import tr.bozkurt.item.Item;
import tr.bozkurt.level.Level;
import tr.bozkurt.math.AxisAlignedBB;
import tr.bozkurt.math.BlockFace;
import tr.bozkurt.utils.BlockColor;
import tr.bozkurt.utils.DyeColor;

/**
 * Created on 2015/11/24 by xtypr.
 * Package tr.bozkurt.block in project Bozkurt.
 */
public class BlockCarpet extends BlockFlowable{

	public BlockCarpet(){
		this(0);
	}

	public BlockCarpet(int meta){
		super(meta);
	}

	public BlockCarpet(DyeColor dyeColor){
		this(dyeColor.getWoolData());
	}

	@Override
	public int getId(){
		return CARPET;
	}

	@Override
	public double getHardness(){
		return 0.1;
	}

	@Override
	public double getResistance(){
		return 0.5;
	}

	@Override
	public boolean isSolid(){
		return true;
	}

	@Override
	public String getName(){
		return DyeColor.getByWoolData(getDamage()) + " Carpet";
	}

	@Override
	public boolean canPassThrough(){
		return false;
	}

	@Override
	protected AxisAlignedBB recalculateBoundingBox(){
		return this;
	}

	@Override
	public double getMaxY(){
		return this.y + 0.0625;
	}

	@Override
	public boolean place(Item item, Block block, Block target, BlockFace face, double fx, double fy, double fz, Player player){
		Block down = this.down();
		if(down.getId() != Item.AIR){
			this.getLevel().setBlock(block, this, true, true);
			return true;
		}
		return false;
	}

	@Override
	public int onUpdate(int type){
		if(type == Level.BLOCK_UPDATE_NORMAL){
			if(this.down().getId() == Item.AIR){
				this.getLevel().useBreakOn(this);

				return Level.BLOCK_UPDATE_NORMAL;
			}
		}

		return 0;
	}

	@Override
	public BlockColor getColor(){
		return DyeColor.getByWoolData(getDamage()).getColor();
	}

	public DyeColor getDyeColor(){
		return DyeColor.getByWoolData(getDamage());
	}

}
