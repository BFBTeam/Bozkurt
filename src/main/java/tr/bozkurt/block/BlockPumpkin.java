package tr.bozkurt.block;

import tr.bozkurt.Player;
import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemTool;
import tr.bozkurt.math.BlockFace;
import tr.bozkurt.utils.BlockColor;

/**
 * Created on 2015/12/8 by xtypr.
 * Package tr.bozkurt.block in project Bozkurt.
 */
public class BlockPumpkin extends BlockSolidMeta{

	public BlockPumpkin(){
		this(0);
	}

	public BlockPumpkin(int meta){
		super(meta);
	}

	@Override
	public String getName(){
		return "Pumpkin";
	}

	@Override
	public int getId(){
		return PUMPKIN;
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
	public boolean place(Item item, Block block, Block target, BlockFace face, double fx, double fy, double fz, Player player){
		this.setDamage(player != null ? player.getDirection().getOpposite().getHorizontalIndex() : 0);
		this.getLevel().setBlock(block, this, true, true);
		return true;
	}

	@Override
	public BlockColor getColor(){
		return BlockColor.FOLIAGE_BLOCK_COLOR;
	}

	@Override
	public boolean canBePushed(){
		return false;
	}

}
