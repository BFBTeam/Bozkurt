package tr.bozkurt.block;

import tr.bozkurt.item.Item;

/**
 * Created on 2015/11/23 by xtypr.
 * Package tr.bozkurt.block in project Bozkurt.
 */
public class BlockFenceGateSpruce extends BlockFenceGate{

	public BlockFenceGateSpruce(){
		this(0);
	}

	public BlockFenceGateSpruce(int meta){
		super(meta);
	}

	@Override
	public int getId(){
		return FENCE_GATE_SPRUCE;
	}

	@Override
	public String getName(){
		return "Spruce Fence Gate";
	}

	@Override
	public Item toItem(){
		return Item.get(Item.FENCE_GATE_SPRUCE, 0, 1);
	}

}
