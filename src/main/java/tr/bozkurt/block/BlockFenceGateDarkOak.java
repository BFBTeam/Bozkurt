package tr.bozkurt.block;

import tr.bozkurt.item.Item;

/**
 * Created on 2015/11/23 by xtypr.
 * Package tr.bozkurt.block in project Bozkurt.
 */
public class BlockFenceGateDarkOak extends BlockFenceGate{

	public BlockFenceGateDarkOak(){
		this(0);
	}

	public BlockFenceGateDarkOak(int meta){
		super(meta);
	}

	@Override
	public int getId(){
		return FENCE_GATE_DARK_OAK;
	}

	@Override
	public String getName(){
		return "Dark Oak Fence Gate";
	}

	@Override
	public Item toItem(){
		return Item.get(Item.FENCE_GATE_DARK_OAK, 0, 1);
	}

}
