package tr.bozkurt.dispenser;

import tr.bozkurt.block.BlockDispenser;
import tr.bozkurt.entity.Entity;
import tr.bozkurt.item.Item;
import tr.bozkurt.level.Position;
import tr.bozkurt.math.BlockFace;
import tr.bozkurt.math.Vector3;
import tr.bozkurt.nbt.tag.CompoundTag;

/**
 * @author CreeperFace
 */
public class ProjectileDispenseBehavior implements DispenseBehavior{

	private String entityType;

	public ProjectileDispenseBehavior(){

	}

	public ProjectileDispenseBehavior(String entity){
		this.entityType = entity;
	}

	@Override
	public void dispense(BlockDispenser source, Item item){
		Position dispensePos = Position.fromObject(source.getDispensePosition(), source.getLevel());
		CompoundTag nbt = Entity.getDefaultNBT(dispensePos);
		this.correctNBT(nbt);

		BlockFace face = source.getFacing();

		Entity projectile = Entity.createEntity(getEntityType(), dispensePos.getLevel().getChunk(dispensePos.getFloorX(), dispensePos.getFloorZ()), nbt);
		if(projectile == null){
			return;
		}

		projectile.setMotion(new Vector3(face.getXOffset(), face.getYOffset() + 0.1f, face.getZOffset()).multiply(6));
		projectile.spawnToAll();
	}

	protected String getEntityType(){
		return this.entityType;
	}

	/**
	 * you can add extra data of projectile here
	 *
	 * @param nbt tag
	 */
	protected void correctNBT(CompoundTag nbt){

	}

}
