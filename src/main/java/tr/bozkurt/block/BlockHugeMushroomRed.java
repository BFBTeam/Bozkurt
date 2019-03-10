package tr.bozkurt.block;

import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemBlock;
import tr.bozkurt.item.ItemTool;
import tr.bozkurt.math.BozkurtRandom;

/**
 * Created by Pub4Game on 28.01.2016.
 */
public class BlockHugeMushroomRed extends BlockSolidMeta{

	public BlockHugeMushroomRed(){
		this(0);
	}

	public BlockHugeMushroomRed(int meta){
		super(meta);
	}

	@Override
	public String getName(){
		return "Red Mushroom Block";
	}

	@Override
	public int getId(){
		return RED_MUSHROOM_BLOCK;
	}

	@Override
	public int getToolType(){
		return ItemTool.TYPE_AXE;
	}

	@Override
	public double getHardness(){
		return 0.2;
	}

	@Override
	public double getResistance(){
		return 1;
	}

	@Override
	public Item[] getDrops(Item item){
		if(new BozkurtRandom().nextRange(1, 20) == 0){
			return new Item[]{
					new ItemBlock(new BlockMushroomRed())
			};
		}else{
			return new Item[0];
		}
	}

	@Override
	public boolean canSilkTouch(){
		return true;
	}

}