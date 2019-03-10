package tr.bozkurt.entity.passive;

import tr.bozkurt.Player;
import tr.bozkurt.entity.Entity;
import tr.bozkurt.entity.EntityAgeable;
import tr.bozkurt.entity.EntityCreature;
import tr.bozkurt.item.Item;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;

/**
 * Bozkurt Project
 */
public abstract class EntityAnimal extends EntityCreature implements EntityAgeable{

	public EntityAnimal(FullChunk chunk, CompoundTag nbt){
		super(chunk, nbt);
	}

	@Override
	public boolean isBaby(){
		return this.getDataFlag(DATA_FLAGS, Entity.DATA_FLAG_BABY);
	}

	public boolean isBreedingItem(Item item){
		return item.getId() == Item.WHEAT; //default
	}

	@Override
	public boolean onInteract(Player player, Item item){
		if(item.getId() == Item.NAME_TAG){
			if(item.hasCustomName()){
				this.setNameTag(item.getCustomName());
				this.setNameTagVisible(true);
				player.getInventory().removeItem(item);
				return true;
			}
		}
		return false;
	}

}
