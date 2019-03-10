package tr.bozkurt.block;

import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemPrismarineCrystals;
import tr.bozkurt.utils.BlockColor;

import java.util.concurrent.ThreadLocalRandom;


public class BlockSeaLantern extends BlockTransparent{

	public BlockSeaLantern(){
	}

	@Override
	public String getName(){
		return "Sea Lantern";
	}

	@Override
	public int getId(){
		return SEA_LANTERN;
	}

	@Override
	public double getResistance(){
		return 1.5;
	}

	@Override
	public double getHardness(){
		return 0.3;
	}

	@Override
	public int getLightLevel(){
		return 15;
	}

	@Override
	public Item[] getDrops(Item item){
		return new Item[]{
				new ItemPrismarineCrystals(0, ThreadLocalRandom.current().nextInt(2, 4))
		};
	}

	@Override
	public BlockColor getColor(){
		return BlockColor.AIR_BLOCK_COLOR;
	}

	@Override
	public boolean canSilkTouch(){
		return true;
	}

}
