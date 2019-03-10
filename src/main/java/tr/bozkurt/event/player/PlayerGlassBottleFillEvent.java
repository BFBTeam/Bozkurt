package tr.bozkurt.event.player;

import tr.bozkurt.Player;
import tr.bozkurt.block.Block;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.item.Item;

public class PlayerGlassBottleFillEvent extends PlayerEvent implements Cancellable{

	protected final Item item;
	protected final Block target;

	public PlayerGlassBottleFillEvent(Player player, Block target, Item item){
		this.player = player;
		this.target = target;
		this.item = item.clone();
	}

	public Item getItem(){
		return item;
	}

	public Block getBlock(){
		return target;
	}

}
