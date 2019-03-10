package tr.bozkurt.block;

import tr.bozkurt.Player;
import tr.bozkurt.item.Item;
import tr.bozkurt.level.Level;
import tr.bozkurt.math.BlockFace;
import tr.bozkurt.utils.BlockColor;

/**
 * Created on 2015/12/2 by xtypr.
 * Package tr.bozkurt.block in project Bozkurt.
 */
public class BlockDandelion extends BlockFlowable{

	public BlockDandelion(){
		this(0);
	}

	public BlockDandelion(int meta){
		super(0);
	}

	@Override
	public String getName(){
		return "Dandelion";
	}

	@Override
	public int getId(){
		return DANDELION;
	}

	@Override
	public boolean place(Item item, Block block, Block target, BlockFace face, double fx, double fy, double fz, Player player){
		Block down = this.down();
		if(down.getId() == 2 || down.getId() == 3 || down.getId() == 60){
			this.getLevel().setBlock(block, this, true, true);

			return true;
		}
		return false;
	}

	@Override
	public int onUpdate(int type){
		if(type == Level.BLOCK_UPDATE_NORMAL){
			if(this.down().isTransparent()){
				this.getLevel().useBreakOn(this);

				return Level.BLOCK_UPDATE_NORMAL;
			}
		}
		return 0;
	}

	@Override
	public BlockColor getColor(){
		return BlockColor.FOLIAGE_BLOCK_COLOR;
	}

}
