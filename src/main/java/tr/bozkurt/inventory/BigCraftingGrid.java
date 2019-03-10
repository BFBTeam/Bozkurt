package tr.bozkurt.inventory;

/**
 * @author CreeperFace
 */
public class BigCraftingGrid extends CraftingGrid{

	public BigCraftingGrid(InventoryHolder holder){
		super(holder, 9);
	}

	@Override
	public int getSize(){
		return 9;
	}

}
