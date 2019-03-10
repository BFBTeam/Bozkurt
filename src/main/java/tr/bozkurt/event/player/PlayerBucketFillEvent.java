package tr.bozkurt.event.player;

import tr.bozkurt.Player;
import tr.bozkurt.block.Block;
import tr.bozkurt.event.HandlerList;
import tr.bozkurt.item.Item;
import tr.bozkurt.math.BlockFace;

public class PlayerBucketFillEvent extends PlayerBucketEvent{

	private static final HandlerList handlers = new HandlerList();

	public PlayerBucketFillEvent(Player who, Block blockClicked, BlockFace blockFace, Item bucket, Item itemInHand){
		super(who, blockClicked, blockFace, bucket, itemInHand);
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

}
