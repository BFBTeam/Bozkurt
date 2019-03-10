package tr.bozkurt.event.player;

import tr.bozkurt.Player;
import tr.bozkurt.block.Block;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;
import tr.bozkurt.item.Item;

/**
 * @author CreeperFace
 */
public class PlayerBlockPickEvent extends PlayerEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	private final Block blockClicked;
	private Item item;

	public PlayerBlockPickEvent(Player player, Block blockClicked, Item item){
		this.blockClicked = blockClicked;
		this.item = item;
		this.player = player;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public Item getItem(){
		return item;
	}

	public void setItem(Item item){
		this.item = item;
	}

	public Block getBlockClicked(){
		return blockClicked;
	}

}
