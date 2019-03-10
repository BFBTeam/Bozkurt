package tr.bozkurt.block;

import tr.bozkurt.Player;
import tr.bozkurt.Server;
import tr.bozkurt.event.block.BlockSpreadEvent;
import tr.bozkurt.item.Item;
import tr.bozkurt.level.Level;
import tr.bozkurt.level.generator.object.ObjectTallGrass;
import tr.bozkurt.math.BozkurtRandom;
import tr.bozkurt.math.Vector3;
import tr.bozkurt.utils.BlockColor;

/**
 * author: Angelic47
 * Bozkurt Project
 */
public class BlockGrass extends BlockDirt{

	public BlockGrass(){
	}

	@Override
	public int getId(){
		return GRASS;
	}

	@Override
	public boolean canBeActivated(){
		return true;
	}

	@Override
	public double getHardness(){
		return 0.6;
	}

	@Override
	public double getResistance(){
		return 3;
	}

	@Override
	public String getName(){
		return "Grass";
	}

	@Override
	public boolean onActivate(Item item){
		return this.onActivate(item, null);
	}

	@Override
	public boolean onActivate(Item item, Player player){
		if(item.getId() == Item.DYE && item.getDamage() == 0x0F){
			item.count--;
			ObjectTallGrass.growGrass(this.getLevel(), this, new BozkurtRandom(), 15, 10);
			return true;
		}else if(item.isHoe()){
			item.useOn(this);
			this.getLevel().setBlock(this, new BlockFarmland());
			return true;
		}else if(item.isShovel()){
			item.useOn(this);
			this.getLevel().setBlock(this, new BlockGrassPath());
			return true;
		}

		return false;
	}

	@Override
	public int onUpdate(int type){
		if(type == Level.BLOCK_UPDATE_RANDOM){
			BozkurtRandom random = new BozkurtRandom();
			x = random.nextRange((int) x - 1, (int) x + 1);
			y = random.nextRange((int) y - 2, (int) y + 2);
			z = random.nextRange((int) z - 1, (int) z + 1);
			Block block = this.getLevel().getBlock(new Vector3(x, y, z));
			if(block.getId() == Block.DIRT){
				if(block.up() instanceof BlockAir){
					BlockSpreadEvent ev = new BlockSpreadEvent(block, this, new BlockGrass());
					Server.getInstance().getPluginManager().callEvent(ev);
					if(!ev.isCancelled()){
						this.getLevel().setBlock(block, ev.getNewState());
					}
				}
			}else if(block.getId() == Block.GRASS){
				if(block.up() instanceof BlockSolid){
					BlockSpreadEvent ev = new BlockSpreadEvent(block, this, new BlockDirt());
					Server.getInstance().getPluginManager().callEvent(ev);
					if(!ev.isCancelled()){
						this.getLevel().setBlock(block, ev.getNewState());
					}
				}
			}
		}
		return 0;
	}

	@Override
	public BlockColor getColor(){
		return BlockColor.GRASS_BLOCK_COLOR;
	}

	@Override
	public boolean canSilkTouch(){
		return true;
	}

}
