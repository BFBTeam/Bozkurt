package tr.bozkurt.entity;

import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;

/**
 * Bozkurt Project
 */
public abstract class EntityCreature extends EntityLiving{

	public EntityCreature(FullChunk chunk, CompoundTag nbt){
		super(chunk, nbt);
	}

}
