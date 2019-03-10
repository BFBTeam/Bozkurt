package tr.bozkurt.event.player;

import tr.bozkurt.Player;
import tr.bozkurt.block.Block;
import tr.bozkurt.event.Cancellable;
import tr.bozkurt.event.HandlerList;
import tr.bozkurt.item.Item;
import tr.bozkurt.level.Position;
import tr.bozkurt.math.BlockFace;
import tr.bozkurt.math.Vector3;

/**
 * Bozkurt Project
 */
public class PlayerInteractEvent extends PlayerEvent implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	protected final Block blockTouched;
	protected final Vector3 touchVector;
	protected final BlockFace blockFace;
	protected final Item item;
	protected final Action action;

	public PlayerInteractEvent(Player player, Item item, Vector3 block, BlockFace face){
		this(player, item, block, face, Action.RIGHT_CLICK_BLOCK);
	}

	public PlayerInteractEvent(Player player, Item item, Vector3 block, BlockFace face, Action action){
		if(block instanceof Block){
			this.blockTouched = (Block) block;
			this.touchVector = new Vector3(0, 0, 0);
		}else{
			this.touchVector = block;
			this.blockTouched = Block.get(Block.AIR, 0, new Position(0, 0, 0, player.level));
		}

		this.player = player;
		this.item = item;
		this.blockFace = face;
		this.action = action;
	}

	public static HandlerList getHandlers(){
		return handlers;
	}

	public Action getAction(){
		return action;
	}

	public Item getItem(){
		return item;
	}

	public Block getBlock(){
		return blockTouched;
	}

	public Vector3 getTouchVector(){
		return touchVector;
	}

	public BlockFace getFace(){
		return blockFace;
	}

	public enum Action{
		LEFT_CLICK_BLOCK,
		RIGHT_CLICK_BLOCK,
		LEFT_CLICK_AIR,
		RIGHT_CLICK_AIR,
		PHYSICAL
	}

}
