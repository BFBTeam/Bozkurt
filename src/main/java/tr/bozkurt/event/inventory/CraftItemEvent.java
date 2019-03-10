package tr.bozkurt.event.inventory;

import tr.bozkurt.Player;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.Event;
import tr.bozkurt.event.HandlerList;
import tr.bozkurt.inventory.Recipe;
import tr.bozkurt.inventory.transaction.CraftingTransaction;
import tr.bozkurt.item.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Bozkurt Project
 */
public class CraftItemEvent extends Event implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	private final Recipe recipe;
	private final Player player;
	private Item[] input = new Item[0];
	private CraftingTransaction transaction;

	public CraftItemEvent(CraftingTransaction transaction){
		this.transaction = transaction;

		List<Item> merged = new ArrayList<>();
		Item[][] input = transaction.getInputMap();

		for(Item[] items : input){
			merged.addAll(Arrays.asList(items));
		}
		this.player = transaction.getSource();
		this.input = merged.stream().toArray(Item[]::new);
		this.recipe = transaction.getRecipe();
	}

	public CraftItemEvent(Player player, Item[] input, Recipe recipe){
		this.player = player;
		this.input = input;
		this.recipe = recipe;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public CraftingTransaction getTransaction(){
		return transaction;
	}

	public Item[] getInput(){
		return input;
	}

	public Recipe getRecipe(){
		return recipe;
	}

	public Player getPlayer(){
		return this.player;
	}

}