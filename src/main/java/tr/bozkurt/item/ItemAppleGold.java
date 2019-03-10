package tr.bozkurt.item;

/**
 * Bozkurt Project
 */
public class ItemAppleGold extends Item{

	public ItemAppleGold(){
		this(0, 1);
	}

	public ItemAppleGold(Integer meta){
		this(meta, 1);
	}

	public ItemAppleGold(Integer meta, int count){
		super(GOLDEN_APPLE, meta, count, "Golden Apple");
	}

}