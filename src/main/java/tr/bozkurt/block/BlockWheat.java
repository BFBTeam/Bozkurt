package tr.bozkurt.block;

import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemSeedsWheat;
import tr.bozkurt.item.ItemWheat;

/**
 * Created on 2015/12/2 by xtypr.
 * Package tr.bozkurt.block in project Bozkurt.
 */
public class BlockWheat extends BlockCrops{

	public BlockWheat(){
		this(0);
	}

	public BlockWheat(int meta){
		super(meta);
	}

	@Override
	public String getName(){
		return "Wheat Block";
	}

	@Override
	public int getId(){
		return WHEAT_BLOCK;
	}

	@Override
	public Item[] getDrops(Item item){
		if(this.getDamage() >= 0x07){
			return new Item[]{
					new ItemWheat(),
					new ItemSeedsWheat(0, (int) (4d * Math.random()))
			};
		}else{
			return new Item[]{
					new ItemSeedsWheat()
			};
		}
	}

}
