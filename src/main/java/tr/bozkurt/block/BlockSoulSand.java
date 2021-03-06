package tr.bozkurt.block;

import tr.bozkurt.entity.Entity;
import tr.bozkurt.item.ItemTool;
import tr.bozkurt.utils.BlockColor;

/**
 * Created by Pub4Game on 27.12.2015.
 */
public class BlockSoulSand extends BlockSolid{

	public BlockSoulSand(){
	}

	@Override
	public String getName(){
		return "Soul Sand";
	}

	@Override
	public int getId(){
		return SOUL_SAND;
	}

	@Override
	public double getHardness(){
		return 0.5;
	}

	@Override
	public double getResistance(){
		return 2.5;
	}

	@Override
	public int getToolType(){
		return ItemTool.TYPE_SHOVEL;
	}

	@Override
	public double getMaxY(){
		return this.y + 1 - 0.125;
	}

	@Override
	public boolean hasEntityCollision(){
		return true;
	}

	@Override
	public void onEntityCollide(Entity entity){
		entity.motionX *= 0.4d;
		entity.motionZ *= 0.4d;
	}

	@Override
	public BlockColor getColor(){
		return BlockColor.SAND_BLOCK_COLOR;
	}

}
