package tr.bozkurt.block;

/**
 * Created on 2015/11/25 by xtypr.
 * Package tr.bozkurt.block in project Bozkurt.
 */
public class BlockStairsBirch extends BlockStairsWood{

	public BlockStairsBirch(){
		this(0);
	}

	public BlockStairsBirch(int meta){
		super(meta);
	}

	@Override
	public int getId(){
		return BIRCH_WOOD_STAIRS;
	}

	@Override
	public String getName(){
		return "Birch Wood Stairs";
	}

}
