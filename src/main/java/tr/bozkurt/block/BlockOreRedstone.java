package tr.bozkurt.block;

import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemRedstone;
import tr.bozkurt.item.ItemTool;
import tr.bozkurt.item.enchantment.Enchantment;
import tr.bozkurt.level.Level;
import tr.bozkurt.math.BozkurtRandom;

import java.util.Random;

/**
 * Bozkurt Project
 */
public class BlockOreRedstone extends BlockSolid{

	public BlockOreRedstone(){
	}

	@Override
	public int getId(){
		return REDSTONE_ORE;
	}

	@Override
	public double getHardness(){
		return 3;
	}

	@Override
	public double getResistance(){
		return 15;
	}

	@Override
	public int getToolType(){
		return ItemTool.TYPE_PICKAXE;
	}

	@Override
	public String getName(){
		return "Redstone Ore";
	}

	@Override
	public Item[] getDrops(Item item){
		if(item.isPickaxe() && item.getTier() >= ItemTool.TIER_IRON){
			int count = new Random().nextInt(2) + 4;

			Enchantment fortune = item.getEnchantment(Enchantment.ID_FORTUNE_DIGGING);
			if(fortune != null && fortune.getLevel() >= 1){
				count += new Random().nextInt(fortune.getLevel() + 1);
			}

			return new Item[]{
					new ItemRedstone(0, count)
			};
		}else{
			return new Item[0];
		}
	}

	@Override
	public int onUpdate(int type){
		if(type == Level.BLOCK_UPDATE_TOUCH){ //type == Level.BLOCK_UPDATE_NORMAL ||
			this.getLevel().setBlock(this, new BlockOreRedstoneGlowing(), false, false);

			return Level.BLOCK_UPDATE_WEAK;
		}

		return 0;
	}

	@Override
	public int getDropExp(){
		return new BozkurtRandom().nextRange(1, 5);
	}

	@Override
	public boolean canHarvestWithHand(){
		return false;
	}

	@Override
	public boolean canSilkTouch(){
		return true;
	}

}
