package tr.bozkurt.block;

import tr.bozkurt.Player;
import tr.bozkurt.item.Item;
import tr.bozkurt.level.Level;
import tr.bozkurt.level.generator.object.BasicGenerator;
import tr.bozkurt.level.generator.object.tree.*;
import tr.bozkurt.level.particle.BoneMealParticle;
import tr.bozkurt.math.BlockFace;
import tr.bozkurt.math.BozkurtRandom;
import tr.bozkurt.math.Vector3;
import tr.bozkurt.utils.BlockColor;

import java.util.concurrent.ThreadLocalRandom;

/**
 * author: Angelic47
 * Bozkurt Project
 */
public class BlockSapling extends BlockFlowable{

	public static final int OAK = 0;
	public static final int SPRUCE = 1;
	public static final int BIRCH = 2;
	/**
	 * placeholder
	 */
	public static final int BIRCH_TALL = 8 | BIRCH;
	public static final int JUNGLE = 3;
	public static final int ACACIA = 4;
	public static final int DARK_OAK = 5;

	public BlockSapling(){
		this(0);
	}

	public BlockSapling(int meta){
		super(meta);
	}

	@Override
	public int getId(){
		return SAPLING;
	}

	@Override
	public String getName(){
		String[] names = new String[]{
				"Oak Sapling",
				"Spruce Sapling",
				"Birch Sapling",
				"Jungle Sapling",
				"Acacia Sapling",
				"Dark Oak Sapling",
				"",
				""
		};
		return names[this.getDamage() & 0x07];
	}

	@Override
	public boolean place(Item item, Block block, Block target, BlockFace face, double fx, double fy, double fz, Player player){
		Block down = this.down();
		if(down.getId() == Block.GRASS || down.getId() == Block.DIRT || down.getId() == Block.FARMLAND || down.getId() == Block.PODZOL){
			this.getLevel().setBlock(block, this, true, true);
			return true;
		}

		return false;
	}

	@Override
	public boolean canBeActivated(){
		return true;
	}

	public boolean onActivate(Item item, Player player){
		if(item.getId() == Item.DYE && item.getDamage() == 0x0F){ //BoneMeal
			if((player.gamemode & 0x01) == 0){
				item.count--;
			}

			this.level.addParticle(new BoneMealParticle(this));
			if(ThreadLocalRandom.current().nextFloat() >= 0.45){
				return true;
			}

			BasicGenerator generator = null;
			boolean bigTree = false;

			int x = 0;
			int z = 0;

			switch(this.getDamage()){
				case JUNGLE:
					loop:
					for(x = 0; x >= -1; --x){
						for(z = 0; z >= -1; --z){
							if(this.findSaplings(x, z, JUNGLE)){
								generator = new ObjectJungleBigTree(10, 20, new BlockWood(BlockWood.JUNGLE), new BlockLeaves(BlockLeaves.JUNGLE));
								bigTree = true;
								break loop;
							}
						}
					}

					if(!bigTree){
						generator = new NewJungleTree(4, 7);
					}
					break;
				case ACACIA:
					generator = new ObjectSavannaTree();
					break;
				case DARK_OAK:
					bigTree = false;

					loop:
					for(x = 0; x >= -1; --x){
						for(z = 0; z >= -1; --z){
							if(this.findSaplings(x, z, DARK_OAK)){
								generator = new ObjectDarkOakTree();
								bigTree = true;
								break loop;
							}
						}
					}

					if(!bigTree){
						return false;
					}
					break;
				//TODO: big spruce
				default:
					ObjectTree.growTree(this.getLevel(), (int) this.x, (int) this.y, (int) this.z, new BozkurtRandom(), this.getDamage() & 0x07);
					return true;
			}
			BlockAir air = new BlockAir();

			if(bigTree){
				this.level.setBlock(this.add(x, 0, z), air, true, false);
				this.level.setBlock(this.add(x + 1, 0, z), air, true, false);
				this.level.setBlock(this.add(x, 0, z + 1), air, true, false);
				this.level.setBlock(this.add(x + 1, 0, z + 1), air, true, false);
			}else{
				this.level.setBlock(this, air, true, false);
			}

			if(!generator.generate(this.level, new BozkurtRandom(), this.add(x, 0, z))){
				if(bigTree){
					this.level.setBlock(this.add(x, 0, z), this, true, false);
					this.level.setBlock(this.add(x + 1, 0, z), this, true, false);
					this.level.setBlock(this.add(x, 0, z + 1), this, true, false);
					this.level.setBlock(this.add(x + 1, 0, z + 1), this, true, false);
				}else{
					this.level.setBlock(this, this, true, false);
				}
			}
			return true;
		}
		return false;
	}

	public int onUpdate(int type){
		if(type == Level.BLOCK_UPDATE_NORMAL){
			if(this.down().isTransparent()){
				this.getLevel().useBreakOn(this);
				return Level.BLOCK_UPDATE_NORMAL;
			}
		}else if(type == Level.BLOCK_UPDATE_RANDOM){ //Growth
			if(new BozkurtRandom().nextRange(1, 7) == 1){
				if((this.getDamage() & 0x08) == 0x08){
					ObjectTree.growTree(this.getLevel(), (int) this.x, (int) this.y, (int) this.z, new BozkurtRandom(), this.getDamage() & 0x07);
				}else{
					this.setDamage(this.getDamage() | 0x08);
					this.getLevel().setBlock(this, this, true);
					return Level.BLOCK_UPDATE_RANDOM;
				}
			}else{
				return Level.BLOCK_UPDATE_RANDOM;
			}
		}
		return 1;
	}

	private boolean findSaplings(int x, int z, int type){
		return this.isSameType(this.add(x, 0, z), type) && this.isSameType(this.add(x + 1, 0, z), type) && this.isSameType(this.add(x, 0, z + 1), type) && this.isSameType(this.add(x + 1, 0, z + 1), type);
	}

	public boolean isSameType(Vector3 pos, int type){
		Block block = this.level.getBlock(pos);
		return block.getId() == this.getId() && block.getDamage() == type;
	}

	@Override
	public BlockColor getColor(){
		return BlockColor.FOLIAGE_BLOCK_COLOR;
	}

}
