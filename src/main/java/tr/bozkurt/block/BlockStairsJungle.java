package tr.bozkurt.block;

/**
 * Created on 2015/11/25 by xtypr.
 * Package tr.bozkurt.block in project Bozkurt.
 */
public class BlockStairsJungle extends BlockStairsWood{

	public BlockStairsJungle(){
		this(0);
	}

	public BlockStairsJungle(int meta){
		super(meta);
	}

	@Override
	public int getId(){
		return JUNGLE_WOOD_STAIRS;
	}

	@Override
	public String getName(){
		return "Jungle Wood Stairs";
	}

}
