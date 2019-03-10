package tr.bozkurt.item;

/**
 * Created by Snake1999 on 2016/1/14.
 * Package tr.bozkurt.item in project Bozkurt.
 */
public class ItemFishingRod extends ItemTool{

	public ItemFishingRod(){
		this(0, 1);
	}

	public ItemFishingRod(Integer meta){
		this(meta, 1);
	}

	public ItemFishingRod(Integer meta, int count){
		super(FISHING_ROD, meta, count, "Fishing Rod");
	}

	@Override
	public int getEnchantAbility(){
		return 1;
	}

	@Override
	public int getMaxStackSize(){
		return 1;
	}

}
