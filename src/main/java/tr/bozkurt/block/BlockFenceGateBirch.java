package tr.bozkurt.block;

import tr.bozkurt.item.Item;

/**
 * Created on 2015/11/23 by xtypr.
 * Package tr.bozkurt.block in project Bozkurt.
 */
public class BlockFenceGateBirch extends BlockFenceGate{

	public BlockFenceGateBirch(){
		this(0);
	}

	public BlockFenceGateBirch(int meta){
		super(meta);
	}

	@Override
	public int getId(){
		return FENCE_GATE_BIRCH;
	}

	@Override
	public String getName(){
		return "Birch Fence Gate";
	}

	@Override
	public Item toItem(){
		return Item.get(Item.FENCE_GATE_BIRCH, 0, 1);
	}

}
