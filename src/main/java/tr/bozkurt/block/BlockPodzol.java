package tr.bozkurt.block;

/**
 * Created on 2015/11/22 by xtypr.
 * Package tr.bozkurt.block in project Bozkurt.
 */
public class BlockPodzol extends BlockDirt{

	public BlockPodzol(){
	}

	@Override
	public int getId(){
		return PODZOL;
	}

	@Override
	public String getName(){
		return "Podzol";
	}

	@Override
	public boolean canSilkTouch(){
		return true;
	}

}
