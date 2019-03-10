package tr.bozkurt.block;

import tr.bozkurt.Player;
import tr.bozkurt.entity.Entity;
import tr.bozkurt.event.entity.EntityDamageByBlockEvent;
import tr.bozkurt.event.entity.EntityDamageEvent;
import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemTool;
import tr.bozkurt.potion.Effect;
import tr.bozkurt.utils.BlockColor;

public class BlockMagma extends BlockSolid{

	public BlockMagma(){

	}

	@Override
	public int getId(){
		return MAGMA;
	}

	@Override
	public String getName(){
		return "Magma Block";
	}

	@Override
	public int getToolType(){
		return ItemTool.TYPE_PICKAXE;
	}

	@Override
	public double getHardness(){
		return 0.5;
	}

	@Override
	public double getResistance(){
		return 30;
	}

	@Override
	public int getLightLevel(){
		return 3;
	}

	@Override
	public Item[] getDrops(Item item){
		if(item.isPickaxe() && item.getTier() >= ItemTool.TIER_WOODEN){
			return new Item[]{
					toItem()
			};
		}else{
			return new Item[0];
		}
	}

	@Override
	public void onEntityCollide(Entity entity){
		if(!entity.hasEffect(Effect.FIRE_RESISTANCE)){
			if(entity instanceof Player){
				Player p = (Player) entity;
				if(!p.isCreative() && !p.isSpectator() && !p.isSneaking()){
					entity.attack(new EntityDamageByBlockEvent(this, entity, EntityDamageEvent.DamageCause.LAVA, 1));
				}
			}else{
				entity.attack(new EntityDamageByBlockEvent(this, entity, EntityDamageEvent.DamageCause.LAVA, 1));
			}
		}
	}

	@Override
	public BlockColor getColor(){
		return BlockColor.BROWN_BLOCK_COLOR;
	}

	@Override
	public boolean canHarvestWithHand(){
		return false;
	}

}
