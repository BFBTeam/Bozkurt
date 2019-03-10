package tr.bozkurt.entity.mob;

import tr.bozkurt.Player;
import tr.bozkurt.entity.EntityCreature;
import tr.bozkurt.item.Item;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;

/**
 * Bozkurt Project
 */
public abstract class EntityMob extends EntityCreature{

	public EntityMob(FullChunk chunk, CompoundTag nbt){
		super(chunk, nbt);
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
