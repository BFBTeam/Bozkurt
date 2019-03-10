package tr.bozkurt.event.inventory;

import tr.bozkurt.blockentity.BlockEntityBrewingStand;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;
import tr.bozkurt.item.Item;

/**
 * @author CreeperFace
 */
public class StartBrewEvent extends InventoryEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	private final BlockEntityBrewingStand brewingStand;
	private final Item ingredient;
	private final Item[] potions;

	public StartBrewEvent(BlockEntityBrewingStand blockEntity){
		super(blockEntity.getInventory());
		this.brewingStand = blockEntity;

		this.ingredient = blockEntity.getInventory().getIngredient();

		this.potions = new Item[3];
		for(int i = 0; i < 3; i++){
			this.potions[i] = blockEntity.getInventory().getItem(i);
		}
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public BlockEntityBrewingStand getBrewingStand(){
		return brewingStand;
	}

	public Item getIngredient(){
		return ingredient;
	}

	public Item[] getPotions(){
		return potions;
	}

	/**
	 * @param index Potion index in range 0 - 2
	 * @return potion
	 */
	public Item getPotion(int index){
		return this.potions[index];
	}

}
