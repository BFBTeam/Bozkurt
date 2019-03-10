package tr.bozkurt.block;

import tr.bozkurt.item.Item;

/**
 * Created on 2015/11/23 by xtypr.
 * Package tr.bozkurt.block in project Bozkurt.
 */
public class BlockFenceGateAcacia extends BlockFenceGate{

	public BlockFenceGateAcacia(){
		this(0);
	}

	public BlockFenceGateAcacia(int meta){
		super(meta);
	}

	@Override
	public int getId(){
		return FENCE_GATE_ACACIA;
	}

	@Override
	public String getName(){
		return "Acacia Fence Gate";
	}

	@Override
	public Item toItem(){
		return Item.get(Item.FENCE_GATE_ACACIA, 0, 1);
	}

}
