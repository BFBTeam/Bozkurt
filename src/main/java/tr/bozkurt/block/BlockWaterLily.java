package tr.bozkurt.block;

import tr.bozkurt.Player;
import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemBlock;
import tr.bozkurt.level.Level;
import tr.bozkurt.math.AxisAlignedBB;
import tr.bozkurt.math.BlockFace;
import tr.bozkurt.utils.BlockColor;

/**
 * Created on 2015/12/1 by xtypr.
 * Package tr.bozkurt.block in project Bozkurt.
 */
public class BlockWaterLily extends BlockFlowable{

	public BlockWaterLily(){
		this(0);
	}

	public BlockWaterLily(int meta){
		super(meta);
	}

	@Override
	public String getName(){
		return "Lily Pad";
	}

	@Override
	public int getId(){
		return WATER_LILY;
	}

	@Override
	public double getMinX(){
		return this.x + 0.0625;
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
		return this.y + 0.015625;
	}

	@Override
	public double getMaxZ(){
		return this.z + 0.9375;
	}

	@Override
	protected AxisAlignedBB recalculateBoundingBox(){
		return this;
	}

	@Override
	public boolean place(Item item, Block block, Block target, BlockFace face, double fx, double fy, double fz, Player player){
		if(target instanceof BlockWater){
			Block up = target.up();
			if(up.getId() == Block.AIR){
				this.getLevel().setBlock(up, this, true, true);
				return true;
			}
		}
		return false;
	}

	@Override
	public int onUpdate(int type){
		if(type == Level.BLOCK_UPDATE_NORMAL){
			if(!(this.down() instanceof BlockWater)){
				this.getLevel().useBreakOn(this);
				return Level.BLOCK_UPDATE_NORMAL;
			}
		}
		return 0;
	}

	@Override
	public Item toItem(){
		return new ItemBlock(this, 0);
	}

	@Override
	public BlockColor getColor(){
		return BlockColor.FOLIAGE_BLOCK_COLOR;
	}

	@Override
	public boolean canPassThrough(){
		return false;
	}

}
