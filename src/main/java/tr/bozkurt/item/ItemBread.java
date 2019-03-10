package tr.bozkurt.item;

/**
 * Bozkurt Project
 */
public class ItemBread extends ItemEdible{

	public ItemBread(){
		this(0, 1);
	}

	public ItemBread(Integer meta){
		this(meta, 1);
	}

	public ItemBread(Integer meta, int count){
		super(BREAD, meta, count, "Bread");
	}

}
