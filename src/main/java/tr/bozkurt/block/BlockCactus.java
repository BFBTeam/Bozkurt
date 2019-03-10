package tr.bozkurt.block;

import tr.bozkurt.Player;
import tr.bozkurt.Server;
import tr.bozkurt.entity.Entity;
import tr.bozkurt.event.block.BlockGrowEvent;
import tr.bozkurt.event.entity.EntityDamageByBlockEvent;
import tr.bozkurt.event.entity.EntityDamageEvent.DamageCause;
import tr.bozkurt.item.Item;
import tr.bozkurt.level.Level;
import tr.bozkurt.math.AxisAlignedBB;
import tr.bozkurt.math.BlockFace;
import tr.bozkurt.math.SimpleAxisAlignedBB;
import tr.bozkurt.math.Vector3;
import tr.bozkurt.utils.BlockColor;

/**
 * @author Bozkurt Project Team
 */
public class BlockCactus extends BlockTransparentMeta{

	public BlockCactus(int meta){
		super(meta);
	}

	public BlockCactus(){
		this(0);
	}

	@Override
	public int getId(){
		return CACTUS;
	}

	@Override
	public double getHardness(){
		return 0.4;
	}

	@Override
	public double getResistance(){
		return 2;
	}

	@Override
	public boolean hasEntityCollision(){
		return true;
	}

	@Override
	public double getMinX(){
		return this.x + 0.0625;
	}

	@Override
	public double getMinY(){
		return this.y;
	}

	@Override
	public double getMinZ(){
		return this.z + 0.0625;
	}

	@Override
	public double getMaxX(){
		return this.x + 0.9375;
	}

	@Override
	public double getMaxY(){
		return this.y + 0.9375;
	}

	@Override
	public double getMaxZ(){
		return this.z + 0.9375;
	}

	@Override
	protected AxisAlignedBB recalculateCollisionBoundingBox(){
		return new SimpleAxisAlignedBB(this.x, this.y, this.z, this.x + 1, this.y + 1, this.z + 1);
	}

	@Override
	public void onEntityCollide(Entity entity){
		entity.attack(new EntityDamageByBlockEvent(this, entity, DamageCause.CONTACT, 1));
	}

	@Override
	public int onUpdate(int type){
		if(type == Level.BLOCK_UPDATE_NORMAL){
			Block down = down();
			if(down.getId() != SAND && down.getId() != CACTUS){
				this.getLevel().useBreakOn(this);
			}else{
				for(int side = 2; side <= 5; ++side){
					Block block = getSide(BlockFace.fromIndex(side));
					if(!block.canBeFlowedInto()){
						this.getLevel().useBreakOn(this);
					}
				}
			}
		}else if(type == Level.BLOCK_UPDATE_RANDOM){
			if(down().getId() != CACTUS){
				if(this.getDamage() == 0x0F){
					for(int y = 1; y < 3; ++y){
						Block b = this.getLevel().getBlock(new Vector3(this.x, this.y + y, this.z));
						if(b.getId() == AIR){
							BlockGrowEvent event = new BlockGrowEvent(b, new BlockCactus());
							Server.getInstance().getPluginManager().callEvent(event);
							if(!event.isCancelled()){
								this.getLevel().setBlock(b, event.getNewState(), true);
							}
						}
					}
					this.setDamage(0);
					this.getLevel().setBlock(this, this);
				}else{
					this.setDamage(this.getDamage() + 1);
					this.getLevel().setBlock(this, this);
				}
			}
		}

		return 0;
	}

	@Override
	public boolean place(Item item, Block block, Block target, BlockFace face, double fx, double fy, double fz, Player player){
		Block down = this.down();
		if(down.getId() == SAND || down.getId() == CACTUS){
			Block block0 = north();
			Block block1 = south();
			Block block2 = west();
			Block block3 = east();
			if(block0.canBeFlowedInto() && block1.canBeFlowedInto() && block2.canBeFlowedInto() && block3.canBeFlowedInto()){
				this.getLevel().setBlock(this, this, true);

				return true;
			}
		}
		return false;
	}

	@Override
	public String getName(){
		return "Cactus";
	}

	@Override
	public BlockColor getColor(){
		return BlockColor.FOLIAGE_BLOCK_COLOR;
	}

	@Override
	public Item[] getDrops(Item item){
		return new Item[]{
				Item.get(Item.CACTUS, 0, 1)
		};
	}

}
