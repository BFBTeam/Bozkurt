package tr.bozkurt.block;

import tr.bozkurt.item.Item;
import tr.bozkurt.utils.BlockColor;

public class BlockNetherWartBlock extends BlockSolid{

	public BlockNetherWartBlock(){
	}

	@Override
	public String getName(){
		return "Nether Wart Block";
	}

	@Override
	public int getId(){
		return BLOCK_NETHER_WART_BLOCK;
	}

	@Override
	public double getResistance(){
		return 5;
	}

	@Override
	public double getHardness(){
		return 1;
	}

	@Override
	public Item[] getDrops(Item item){
		return new Item[]{
				toItem()
		};
	}

	@Override
	public BlockColor getColor(){
		return BlockColor.NETHERRACK_BLOCK_COLOR;
	}

}
