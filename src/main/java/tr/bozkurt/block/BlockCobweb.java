package tr.bozkurt.block;

import tr.bozkurt.entity.Entity;
import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemString;
import tr.bozkurt.item.ItemTool;
import tr.bozkurt.utils.BlockColor;

/**
 * Created on 2015/12/2 by xtypr.
 * Package tr.bozkurt.block in project Bozkurt.
 */
public class BlockCobweb extends BlockFlowable{

	public BlockCobweb(){
		this(0);
	}

	public BlockCobweb(int meta){
		super(0);
	}

	@Override
	public String getName(){
		return "Cobweb";
	}

	@Override
	public int getId(){
		return COBWEB;
	}

	@Override
	public double getHardness(){
		return 4;
	}

	@Override
	public double getResistance(){
		return 20;
	}

	@Override
	public int getToolType(){
		return ItemTool.TYPE_SWORD;
	}

	@Override
	public void onEntityCollide(Entity entity){
		entity.resetFallDistance();
	}

	@Override
	public Item[] getDrops(Item item){
		if(item.isShears() || item.isSword()){
			return new Item[]{
					new ItemString()
			};
		}else{
			return new Item[0];
		}
	}

	@Override
	public BlockColor getColor(){
		return BlockColor.CLOTH_BLOCK_COLOR;
	}

	@Override
	public boolean canHarvestWithHand(){
		return false;
	}

}
