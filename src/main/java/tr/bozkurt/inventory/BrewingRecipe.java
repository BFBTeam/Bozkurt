package tr.bozkurt.inventory;


import tr.bozkurt.item.Item;

public class BrewingRecipe implements Recipe{

	private final Item output;

	private final Item potion;

	private Item ingredient;

	public BrewingRecipe(Item result, Item ingredient, Item potion){
		this.output = result.clone();
		this.ingredient = ingredient.clone();
		this.potion = potion.clone();
	}

	public Item getInput(){
		return ingredient.clone();
	}

	public void setInput(Item item){
		ingredient = item.clone();
	}

	public Item getPotion(){
		return potion.clone();
	}

	@Override
	public Item getResult(){
		return output.clone();
	}

	@Override
	public void registerToCraftingManager(CraftingManager manager){
		manager.registerBrewingRecipe(this);
	}

}