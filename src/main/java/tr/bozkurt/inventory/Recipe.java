package tr.bozkurt.inventory;

import tr.bozkurt.item.Item;

/**
 * Bozkurt Project
 */
public interface Recipe{

	Item getResult();

	void registerToCraftingManager(CraftingManager manager);

}
