package tr.bozkurt.item;

/**
 * Bozkurt Project
 */
public class ItemApple extends ItemEdible{

	public ItemApple(){
		this(0, 1);
	}

	public ItemApple(Integer meta){
		this(meta, 1);
	}

	public ItemApple(Integer meta, int count){
		super(APPLE, 0, count, "Apple");
	}

}
