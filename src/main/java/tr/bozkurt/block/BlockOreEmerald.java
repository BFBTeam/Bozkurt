package tr.bozkurt.block;

import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemEmerald;
import tr.bozkurt.item.ItemTool;
import tr.bozkurt.item.enchantment.Enchantment;
import tr.bozkurt.math.BozkurtRandom;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created on 2015/12/1 by xtypr.
 * Package tr.bozkurt.block in project Bozkurt.
 */
public class BlockOreEmerald extends BlockSolid{

	public BlockOreEmerald(){
	}

	@Override
	public String getName(){
		return "Emerald Ore";
	}

	@Override
	public int getId(){
		return EMERALD_ORE;
	}

	@Override
	public int getToolType(){
		return ItemTool.TYPE_PICKAXE;
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
	public Item[] getDrops(Item item){
		if(item.isPickaxe() && item.getTier() >= ItemTool.TIER_IRON){
			int count = 1;
			Enchantment fortune = item.getEnchantment(Enchantment.ID_FORTUNE_DIGGING);
			if(fortune != null && fortune.getLevel() >= 1){
				int i = ThreadLocalRandom.current().nextInt(fortune.getLevel() + 2) - 1;

				if(i < 0){
					i = 0;
				}

				count = i + 1;
			}

			return new Item[]{
					new ItemEmerald(0, count)
			};
		}else{
			return new Item[0];
		}
	}

	@Override
	public int getDropExp(){
		return new BozkurtRandom().nextRange(3, 7);
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
