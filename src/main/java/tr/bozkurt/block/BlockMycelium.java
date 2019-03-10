package tr.bozkurt.block;

import tr.bozkurt.Server;
import tr.bozkurt.event.block.BlockSpreadEvent;
import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemBlock;
import tr.bozkurt.item.ItemTool;
import tr.bozkurt.level.Level;
import tr.bozkurt.math.BozkurtRandom;
import tr.bozkurt.math.Vector3;
import tr.bozkurt.utils.BlockColor;

/**
 * Created by Pub4Game on 03.01.2016.
 */
public class BlockMycelium extends BlockSolid{

	public BlockMycelium(){
	}

	@Override
	public String getName(){
		return "Mycelium";
	}

	@Override
	public int getId(){
		return MYCELIUM;
	}

	@Override
	public int getToolType(){
		return ItemTool.TYPE_SHOVEL;
	}

	@Override
	public double getHardness(){
		return 0.6;
	}

	@Override
	public double getResistance(){
		return 2.5;
	}

	@Override
	public Item[] getDrops(Item item){
		return new Item[]{
				new ItemBlock(new BlockDirt())
		};
	}

	@Override
	public int onUpdate(int type){
		if(type == Level.BLOCK_UPDATE_RANDOM){
			//TODO: light levels
			BozkurtRandom random = new BozkurtRandom();
			x = random.nextRange((int) x - 1, (int) x + 1);
			y = random.nextRange((int) y - 1, (int) y + 1);
			z = random.nextRange((int) z - 1, (int) z + 1);
			Block block = this.getLevel().getBlock(new Vector3(x, y, z));
			if(block.getId() == Block.DIRT){
				if(block.up().isTransparent()){
					BlockSpreadEvent ev = new BlockSpreadEvent(block, this, new BlockMycelium());
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
