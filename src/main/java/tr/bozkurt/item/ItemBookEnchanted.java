package tr.bozkurt.item;

/**
 * Bozkurt Project
 */
public class ItemBookEnchanted extends Item{

	public ItemBookEnchanted(){
		this(0, 1);
	}

	public ItemBookEnchanted(Integer meta){
		this(meta, 1);
	}

	public ItemBookEnchanted(Integer meta, int count){
		super(ENCHANTED_BOOK, meta, count, "Enchanted Book");
	}

}
