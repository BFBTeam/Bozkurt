package tr.bozkurt.block;

import tr.bozkurt.Player;
import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemStick;
import tr.bozkurt.level.Level;
import tr.bozkurt.math.BlockFace;
import tr.bozkurt.utils.BlockColor;

import java.util.Random;

/**
 * Created on 2015/12/2 by xtypr.
 * Package tr.bozkurt.block in project Bozkurt.
 */
public class BlockDeadBush extends BlockFlowable{

	public BlockDeadBush(){
		this(0);
	}

	public BlockDeadBush(int meta){
		// Dead bushes can't have meta. Also stops the server from throwing an exception with the block palette.
		super(0);
	}

	@Override
	public String getName(){
		return "Dead Bush";
	}

	@Override
	public int getId(){
		return DEAD_BUSH;
	}

	@Override
	public boolean canBeReplaced(){
		return true;
	}

	@Override
	public boolean place(Item item, Block block, Block target, BlockFace face, double fx, double fy, double fz, Player player){
		Block down = this.down();
		if(down.getId() == SAND || down.getId() == TERRACOTTA || down.getId() == STAINED_TERRACOTTA || down.getId() == PODZOL){
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
	public Item[] getDrops(Item item){
		if(item.isShears()){
			return new Item[]{
					toItem()
			};
		}else{
			return new Item[]{
					new ItemStick(0, new Random().nextInt(3))
			};
		}
	}

	public BlockColor getColor(){
		return BlockColor.FOLIAGE_BLOCK_COLOR;
	}

}
