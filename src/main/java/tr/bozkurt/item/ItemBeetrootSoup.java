package tr.bozkurt.item;

/**
 * Bozkurt Project
 */
public class ItemBeetrootSoup extends ItemEdible{

	public ItemBeetrootSoup(){
		this(0, 1);
	}

	public ItemBeetrootSoup(Integer meta){
		this(meta, 1);
	}

	public ItemBeetrootSoup(Integer meta, int count){
		super(BEETROOT_SOUP, 0, count, "Beetroot Soup");
	}

}
