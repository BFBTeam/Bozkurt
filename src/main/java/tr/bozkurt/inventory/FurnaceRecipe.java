package tr.bozkurt.inventory;

import tr.bozkurt.item.Item;

/**
 * Bozkurt Project
 */
public class FurnaceRecipe implements Recipe{

	private final Item output;

	private Item ingredient;

	public FurnaceRecipe(Item result, Item ingredient){
		this.output = result.clone();
		this.ingredient = ingredient.clone();
	}

	public Item getInput(){
		return this.ingredient.clone();
	}

	public void setInput(Item item){
		this.ingredient = item.clone();
	}

	@Override
	public Item getResult(){
		return this.output.clone();
	}

	@Override
	public void registerToCraftingManager(CraftingManager manager){
		manager.registerFurnaceRecipe(this);
	}

}
