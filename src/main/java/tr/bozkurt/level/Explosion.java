package tr.bozkurt.level;

import it.unimi.dsi.fastutil.longs.LongArraySet;
import tr.bozkurt.block.Block;
import tr.bozkurt.block.BlockAir;
import tr.bozkurt.block.BlockID;
import tr.bozkurt.block.BlockTNT;
import tr.bozkurt.entity.Entity;
import tr.bozkurt.event.block.BlockUpdateEvent;
import tr.bozkurt.event.entity.EntityDamageByBlockEvent;
import tr.bozkurt.event.entity.EntityDamageByEntityEvent;
import tr.bozkurt.event.entity.EntityDamageEvent;
import tr.bozkurt.event.entity.EntityDamageEvent.DamageCause;
import tr.bozkurt.event.entity.EntityExplodeEvent;
import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemBlock;
import tr.bozkurt.level.particle.HugeExplodeSeedParticle;
import tr.bozkurt.math.*;
import tr.bozkurt.network.protocol.ExplodePacket;
import tr.bozkurt.utils.Hash;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * author: Angelic47
 * Bozkurt Project
 */
public class Explosion{

	private final int rays = 16; //Rays
	private final Level level;
	private final Position source;
	private final double size;
	private final double stepLen = 0.3d;
	private final Object what;
	private List<Block> affectedBlocks = new ArrayList<>();

	public Explosion(Position center, double size, Entity what){
		this.level = center.getLevel();
		this.source = center;
		this.size = Math.max(size, 0);
		this.what = what;
	}

	/**
	 * @return bool
	 * @deprecated
	 */
	public boolean explode(){
		if(explodeA()){
			return explodeB();
		}
		return false;
	}

	/**
	 * @return bool
	 */
	public boolean explodeA(){
		if(this.size < 0.1){
			return false;
		}

		Vector3 vector = new Vector3(0, 0, 0);
		Vector3 vBlock = new Vector3(0, 0, 0);

		int mRays = this.rays - 1;
		for(int i = 0; i < this.rays; ++i){
			for(int j = 0; j < this.rays; ++j){
				for(int k = 0; k < this.rays; ++k){
					if(i == 0 || i == mRays || j == 0 || j == mRays || k == 0 || k == mRays){
						vector.setComponents((double) i / (double) mRays * 2d - 1, (double) j / (double) mRays * 2d - 1, (double) k / (double) mRays * 2d - 1);
						double len = vector.length();
						vector.setComponents((vector.x / len) * this.stepLen, (vector.y / len) * this.stepLen, (vector.z / len) * this.stepLen);
						double pointerX = this.source.x;
						double pointerY = this.source.y;
						double pointerZ = this.source.z;

						for(double blastForce = this.size * (ThreadLocalRandom.current().nextInt(700, 1301)) / 1000d; blastForce > 0; blastForce -= this.stepLen * 0.75d){
							int x = (int) pointerX;
							int y = (int) pointerY;
							int z = (int) pointerZ;
							vBlock.x = pointerX >= x ? x : x - 1;
							vBlock.y = pointerY >= y ? y : y - 1;
							vBlock.z = pointerZ >= z ? z : z - 1;
							if(vBlock.y < 0 || vBlock.y > 255){
								break;
							}
							Block block = this.level.getBlock(vBlock);

							if(block.getId() != 0){
								blastForce -= (block.getResistance() / 5 + 0.3d) * this.stepLen;
								if(blastForce > 0){
									if(!this.affectedBlocks.contains(block)){
										this.affectedBlocks.add(block);
									}
								}
							}
							pointerX += vector.x;
							pointerY += vector.y;
							pointerZ += vector.z;
						}
					}
				}
			}
		}

		return true;
	}

	public boolean explodeB(){

		LongArraySet updateBlocks = new LongArraySet();
		List<Vector3> send = new ArrayList<>();

		Vector3 source = (new Vector3(this.source.x, this.source.y, this.source.z)).floor();
		double yield = (1d / this.size) * 100d;

		if(this.what instanceof Entity){
			EntityExplodeEvent ev = new EntityExplodeEvent((Entity) this.what, this.source, this.affectedBlocks, yield);
			this.level.getServer().getPluginManager().callEvent(ev);
			if(ev.isCancelled()){
				return false;
			}else{
				yield = ev.getYield();
				this.affectedBlocks = ev.getBlockList();
			}
		}

		double explosionSize = this.size * 2d;
		double minX = BozkurtMath.floorDouble(this.source.x - explosionSize - 1);
		double maxX = BozkurtMath.ceilDouble(this.source.x + explosionSize + 1);
		double minY = BozkurtMath.floorDouble(this.source.y - explosionSize - 1);
		double maxY = BozkurtMath.ceilDouble(this.source.y + explosionSize + 1);
		double minZ = BozkurtMath.floorDouble(this.source.z - explosionSize - 1);
		double maxZ = BozkurtMath.ceilDouble(this.source.z + explosionSize + 1);

		AxisAlignedBB explosionBB = new SimpleAxisAlignedBB(minX, minY, minZ, maxX, maxY, maxZ);

		Entity[] list = this.level.getNearbyEntities(explosionBB, this.what instanceof Entity ? (Entity) this.what : null);
		for(Entity entity : list){
			double distance = entity.distance(this.source) / explosionSize;

			if(distance <= 1){
				Vector3 motion = entity.subtract(this.source).normalize();
				int exposure = 1;
				double impact = (1 - distance) * exposure;
				int damage = (int) (((impact * impact + impact) / 2) * 8 * explosionSize + 1);

				if(this.what instanceof Entity){
					entity.attack(new EntityDamageByEntityEvent((Entity) this.what, entity, DamageCause.ENTITY_EXPLOSION, damage));
				}else if(this.what instanceof Block){
					entity.attack(new EntityDamageByBlockEvent((Block) this.what, entity, DamageCause.BLOCK_EXPLOSION, damage));
				}else{
					entity.attack(new EntityDamageEvent(entity, DamageCause.BLOCK_EXPLOSION, damage));
				}

				entity.setMotion(motion.multiply(impact));
			}
		}

		ItemBlock air = new ItemBlock(new BlockAir());

		//Iterator iter = this.affectedBlocks.entrySet().iterator();
		for(Block block : this.affectedBlocks){
			//Block block = (Block) ((HashMap.Entry) iter.next()).getValue();
			if(block.getId() == Block.TNT){
				((BlockTNT) block).prime(new BozkurtRandom().nextRange(10, 30), this.what instanceof Entity ? (Entity) this.what : null);
			}else if(Math.random() * 100 < yield){
				for(Item drop : block.getDrops(air)){
					this.level.dropItem(block.add(0.5, 0.5, 0.5), drop);
				}
			}

			this.level.setBlockAt((int) block.x, (int) block.y, (int) block.z, BlockID.AIR);

			Vector3 pos = new Vector3(block.x, block.y, block.z);

			for(BlockFace side : BlockFace.values()){
				Vector3 sideBlock = pos.getSide(side);
				long index = Hash.hashBlock((int) sideBlock.x, (int) sideBlock.y, (int) sideBlock.z);
				if(!this.affectedBlocks.contains(sideBlock) && !updateBlocks.contains(index)){
					BlockUpdateEvent ev = new BlockUpdateEvent(this.level.getBlock(sideBlock));
					this.level.getServer().getPluginManager().callEvent(ev);
					if(!ev.isCancelled()){
						ev.getBlock().onUpdate(Level.BLOCK_UPDATE_NORMAL);
					}
					updateBlocks.add(index);
				}
			}
			send.add(new Vector3(block.x - source.x, block.y - source.y, block.z - source.z));
		}

		ExplodePacket pk = new ExplodePacket();
		pk.x = (float) this.source.x;
		pk.y = (float) this.source.y;
		pk.z = (float) this.source.z;
		pk.radius = (float) this.size;
		pk.records = send.toArray(new Vector3[0]);

		this.level.addChunkPacket((int) source.x >> 4, (int) source.z >> 4, pk);
		this.level.addParticle(new HugeExplodeSeedParticle(this.source));
		this.level.addSound(new Vector3(this.source.x, this.source.y, this.source.z), Sound.RANDOM_EXPLODE);

		return true;
	}

}
