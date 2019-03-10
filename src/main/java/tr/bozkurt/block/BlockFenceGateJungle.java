package tr.bozkurt.block;

import tr.bozkurt.item.Item;

/**
 * Created on 2015/11/23 by xtypr.
 * Package tr.bozkurt.block in project Bozkurt.
 */
public class BlockFenceGateJungle extends BlockFenceGate{

	public BlockFenceGateJungle(){
		this(0);
	}

	public BlockFenceGateJungle(int meta){
		super(meta);
	}

	@Override
	public int getId(){
		return FENCE_GATE_JUNGLE;
	}

	@Override
	public String getName(){
		return "Jungle Fence Gate";
	}

	@Override
	public Item toItem(){
		return Item.get(Item.FENCE_GATE_JUNGLE, 0, 1);
	}

}
