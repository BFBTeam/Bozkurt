package tr.bozkurt.inventory;

import tr.bozkurt.level.Position;

/**
 * Bozkurt Project
 */
public class FakeBlockMenu extends Position implements InventoryHolder{

	private final Inventory inventory;

	public FakeBlockMenu(Inventory inventory, Position pos){
		super(pos.x, pos.y, pos.z, pos.level);
		this.inventory = inventory;
	}

	@Override
	public Inventory getInventory(){
		return inventory;
	}

}
