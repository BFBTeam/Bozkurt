package tr.bozkurt.item;

/**
 * Bozkurt Project
 */
public class ItemPumpkinPie extends ItemEdible{

	public ItemPumpkinPie(){
		this(0, 1);
	}

	public ItemPumpkinPie(Integer meta){
		this(meta, 1);
	}

	public ItemPumpkinPie(Integer meta, int count){
		super(PUMPKIN_PIE, meta, count, "Pumpkin Pie");
	}

}
