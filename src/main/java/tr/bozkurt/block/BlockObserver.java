package tr.bozkurt.block;

import tr.bozkurt.Player;
import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemTool;
import tr.bozkurt.math.BlockFace;

/**
 * Created by Leonidius20 on 18.08.18.
 */
public class BlockObserver extends BlockSolidMeta{

	public BlockObserver(){
		this(0);
	}

	public BlockObserver(int meta){
		super(meta);
	}

	@Override
	public String getName(){
		return "Observer";
	}

	@Override
	public int getId(){
		return OBSERVER;
	}

	@Override
	public boolean place(Item item, Block block, Block target, BlockFace face, double fx, double fy, double fz, Player player){
		int faces[] = {2, 5, 3, 4};
		this.setDamage(faces[player != null ? player.getDirection().getHorizontalIndex() : 0]);
		this.getLevel().setBlock(block, this, true, true);
		return true;
	}

	@Override
	public boolean canHarvestWithHand(){
		return false;
	}

	@Override
	public int getToolType(){
		return ItemTool.TYPE_PICKAXE;
	}

	@Override
	public double getHardness(){
		return 3.5;
	}

	@Override
	public double getResistance(){
		return 17.5;
	}

}
