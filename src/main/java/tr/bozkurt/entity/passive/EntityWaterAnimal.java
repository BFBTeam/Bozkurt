package tr.bozkurt.entity.passive;

import tr.bozkurt.entity.Entity;
import tr.bozkurt.entity.EntityAgeable;
import tr.bozkurt.entity.EntityCreature;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;

/**
 * Bozkurt Project
 */
public abstract class EntityWaterAnimal extends EntityCreature implements EntityAgeable{

	public EntityWaterAnimal(FullChunk chunk, CompoundTag nbt){
		super(chunk, nbt);
	}

	@Override
	public boolean isBaby(){
		return this.getDataFlag(DATA_FLAGS, Entity.DATA_FLAG_BABY);
	}

}
