package tr.bozkurt.item;

import tr.bozkurt.Player;
import tr.bozkurt.entity.Entity;
import tr.bozkurt.entity.projectile.EntityProjectile;
import tr.bozkurt.event.entity.ProjectileLaunchEvent;
import tr.bozkurt.level.Sound;
import tr.bozkurt.math.Vector3;
import tr.bozkurt.nbt.tag.CompoundTag;
import tr.bozkurt.nbt.tag.DoubleTag;
import tr.bozkurt.nbt.tag.FloatTag;
import tr.bozkurt.nbt.tag.ListTag;

/**
 * @author CreeperFace
 */
public abstract class ProjectileItem extends Item{

	public ProjectileItem(int id, Integer meta, int count, String name){
		super(id, meta, count, name);
	}

	abstract public String getProjectileEntityType();

	abstract public float getThrowForce();

	public boolean onClickAir(Player player, Vector3 directionVector){
		CompoundTag nbt = new CompoundTag()
				.putList(new ListTag<DoubleTag>("Pos")
						.add(new DoubleTag("", player.x))
						.add(new DoubleTag("", player.y + player.getEyeHeight() - 0.10000000149011612))
						.add(new DoubleTag("", player.z)))
				.putList(new ListTag<DoubleTag>("Motion")
						.add(new DoubleTag("", directionVector.x))
						.add(new DoubleTag("", directionVector.y))
						.add(new DoubleTag("", directionVector.z)))
				.putList(new ListTag<FloatTag>("Rotation")
						.add(new FloatTag("", (float) player.yaw))
						.add(new FloatTag("", (float) player.pitch)));

		this.correctNBT(nbt);

		Entity projectile = Entity.createEntity(this.getProjectileEntityType(), player.getLevel().getChunk(player.getFloorX() >> 4, player.getFloorZ() >> 4), nbt, player);
		if(projectile != null){
			projectile.setMotion(projectile.getMotion().multiply(this.getThrowForce()));
			this.count--;

			if(projectile instanceof EntityProjectile){
				ProjectileLaunchEvent ev = new ProjectileLaunchEvent((EntityProjectile) projectile);

				player.getServer().getPluginManager().callEvent(ev);
				if(ev.isCancelled()){
					projectile.kill();
				}else{
					projectile.spawnToAll();
					player.getLevel().addSound(player, Sound.RANDOM_BOW, 1, 1, player.getViewers().values());
				}
			}else{
				projectile.spawnToAll();
			}
		}else{
			return false;
		}
		return true;
	}

	protected void correctNBT(CompoundTag nbt){

	}

}
