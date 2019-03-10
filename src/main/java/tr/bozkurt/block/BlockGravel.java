package tr.bozkurt.block;

import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemFlint;
import tr.bozkurt.item.ItemTool;
import tr.bozkurt.utils.BlockColor;

import java.util.Random;

/**
 * Bozkurt Project
 */
public class BlockGravel extends BlockFallable{


	public BlockGravel(){
	}

	@Override
	public int getId(){
		return GRAVEL;
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
	public int getToolType(){
		return ItemTool.TYPE_SHOVEL;
	}

	@Override
	public String getName(){
		return "Gravel";
	}

	@Override
	public Item[] getDrops(Item item){
		if(new Random().nextInt(9) == 0){
			return new Item[]{
					new ItemFlint()
			};
		}else{
			return new Item[]{
					toItem()
			};
		}
	}

	@Override
	public BlockColor getColor(){
		return BlockColor.SAND_BLOCK_COLOR;
	}

}
