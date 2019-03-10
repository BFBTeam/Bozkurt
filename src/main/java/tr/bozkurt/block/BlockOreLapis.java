package tr.bozkurt.block;

import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemDye;
import tr.bozkurt.item.ItemTool;
import tr.bozkurt.item.enchantment.Enchantment;
import tr.bozkurt.math.BozkurtRandom;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Bozkurt Project
 */
public class BlockOreLapis extends BlockSolid{


	public BlockOreLapis(){
	}

	@Override
	public int getId(){
		return LAPIS_ORE;
	}

	@Override
	public double getHardness(){
		return 3;
	}

	@Override
	public double getResistance(){
		return 5;
	}

	@Override
	public int getToolType(){
		return ItemTool.TYPE_PICKAXE;
	}

	@Override
	public String getName(){
		return "Lapis Lazuli Ore";
	}

	@Override
	public Item[] getDrops(Item item){
		if(item.isPickaxe() && item.getTier() >= ItemTool.TIER_STONE){
			int count = 4 + ThreadLocalRandom.current().nextInt(5);
			Enchantment fortune = item.getEnchantment(Enchantment.ID_FORTUNE_DIGGING);
			if(fortune != null && fortune.getLevel() >= 1){
				int i = ThreadLocalRandom.current().nextInt(fortune.getLevel() + 2) - 1;

				if(i < 0){
					i = 0;
				}

				count *= (i + 1);
			}

			return new Item[]{
					new ItemDye(4, new Random().nextInt(4) + 4)
			};
		}else{
			return new Item[0];
		}
	}

	@Override
	public int getDropExp(){
		return new BozkurtRandom().nextRange(2, 5);
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
