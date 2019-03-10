package tr.bozkurt.inventory;


import tr.bozkurt.blockentity.BlockEntityBrewingStand;
import tr.bozkurt.item.Item;

public class BrewingInventory extends ContainerInventory{

	public BrewingInventory(BlockEntityBrewingStand brewingStand){
		super(brewingStand, InventoryType.BREWING_STAND);
	}

	@Override
	public BlockEntityBrewingStand getHolder(){
		return (BlockEntityBrewingStand) this.holder;
	}

	public Item getIngredient(){
		return getItem(0);
	}

	public void setIngredient(Item item){
		setItem(0, item);
	}

	public Item getFuel(){
		return getItem(4);
	}

	public void setFuel(Item fuel){
		setItem(4, fuel);
	}

	@Override
	public void onSlotChange(int index, Item before, boolean send){
		super.onSlotChange(index, before, send);

		if(index >= 0 && index <= 2){
			this.getHolder().updateBlock();
		}

		this.getHolder().scheduleUpdate();
	}

}