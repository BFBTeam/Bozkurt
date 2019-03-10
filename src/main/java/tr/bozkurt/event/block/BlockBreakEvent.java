package tr.bozkurt.event.block;

import tr.bozkurt.Player;
import tr.bozkurt.block.Block;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;
import tr.bozkurt.item.Item;
import tr.bozkurt.math.BlockFace;

/**
 * Bozkurt Project
 */
public class BlockBreakEvent extends BlockEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	protected final Player player;
	protected final Item item;
	protected final BlockFace face;
	protected boolean instaBreak = false;
	protected Item[] blockDrops = new Item[0];
	protected boolean fastBreak = false;

	public BlockBreakEvent(Player player, Block block, Item item, Item[] drops){
		this(player, block, item, drops, false, false);
	}

	public BlockBreakEvent(Player player, Block block, Item item, Item[] drops, boolean instaBreak){
		this(player, block, item, drops, instaBreak, false);
	}

	public BlockBreakEvent(Player player, Block block, Item item, Item[] drops, boolean instaBreak, boolean fastBreak){
		this(player, block, null, item, drops, instaBreak, fastBreak);
	}

	public BlockBreakEvent(Player player, Block block, BlockFace face, Item item, Item[] drops, boolean instaBreak, boolean fastBreak){
		super(block);
		this.face = face;
		this.item = item;
		this.player = player;
		this.instaBreak = instaBreak;
		this.blockDrops = drops;
		this.fastBreak = fastBreak;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public Player getPlayer(){
		return player;
	}

	public BlockFace getFace(){
		return face;
	}

	public Item getItem(){
		return item;
	}

	public boolean getInstaBreak(){
		return this.instaBreak;
	}

	public void setInstaBreak(boolean instaBreak){
		this.instaBreak = instaBreak;
	}

	public Item[] getDrops(){
		return blockDrops;
	}

	public void setDrops(Item[] drops){
		this.blockDrops = drops;
	}

	public boolean isFastBreak(){
		return this.fastBreak;
	}

}
