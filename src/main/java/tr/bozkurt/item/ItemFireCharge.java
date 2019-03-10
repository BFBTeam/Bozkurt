package tr.bozkurt.item;

import tr.bozkurt.Player;
import tr.bozkurt.block.Block;
import tr.bozkurt.block.BlockFire;
import tr.bozkurt.block.BlockSolid;
import tr.bozkurt.block.BlockSolidMeta;
import tr.bozkurt.event.block.BlockIgniteEvent;
import tr.bozkurt.level.Level;
import tr.bozkurt.level.Sound;
import tr.bozkurt.math.BlockFace;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by PetteriM1
 */
public class ItemFireCharge extends Item{

	public ItemFireCharge(){
		this(0, 1);
	}

	public ItemFireCharge(Integer meta){
		this(meta, 1);
	}

	public ItemFireCharge(Integer meta, int count){
		super(FIRE_CHARGE, 0, count, "Fire Charge");
	}

	@Override
	public boolean canBeActivated(){
		return true;
	}

	@Override
	public boolean onActivate(Level level, Player player, Block block, Block target, BlockFace face, double fx, double fy, double fz){
		if(block.getId() == AIR && (target instanceof BlockSolid || target instanceof BlockSolidMeta)){
			BlockFire fire = new BlockFire();
			fire.x = block.x;
			fire.y = block.y;
			fire.z = block.z;
			fire.level = level;

			if(fire.isBlockTopFacingSurfaceSolid(fire.down()) || fire.canNeighborBurn()){
				BlockIgniteEvent e = new BlockIgniteEvent(block, null, player, BlockIgniteEvent.BlockIgniteCause.FLINT_AND_STEEL);
				block.getLevel().getServer().getPluginManager().callEvent(e);

				if(!e.isCancelled()){
					level.setBlock(fire, fire, true);
					level.addSound(block, Sound.MOB_GHAST_FIREBALL);
					level.scheduleUpdate(fire, fire.tickRate() + ThreadLocalRandom.current().nextInt(10));
				}
				if(player.isSurvival()){
					Item item = player.getInventory().getItemInHand();
					item.setCount(item.getCount() - 1);
					player.getInventory().setItemInHand(item);
				}
				return true;
			}
		}
		return false;
	}

}
