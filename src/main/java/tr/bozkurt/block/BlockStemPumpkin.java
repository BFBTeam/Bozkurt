package tr.bozkurt.block;

import tr.bozkurt.Server;
import tr.bozkurt.event.block.BlockGrowEvent;
import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemSeedsPumpkin;
import tr.bozkurt.level.Level;
import tr.bozkurt.math.BlockFace;
import tr.bozkurt.math.BlockFace.Plane;
import tr.bozkurt.math.BozkurtRandom;

/**
 * Created by Pub4Game on 15.01.2016.
 */
public class BlockStemPumpkin extends BlockCrops{

	public BlockStemPumpkin(){
		this(0);
	}

	public BlockStemPumpkin(int meta){
		super(meta);
	}

	@Override
	public int getId(){
		return PUMPKIN_STEM;
	}

	@Override
	public String getName(){
		return "Pumpkin Stem";
	}

	@Override
	public int onUpdate(int type){
		if(type == Level.BLOCK_UPDATE_NORMAL){
			if(this.down().getId() != FARMLAND){
				this.getLevel().useBreakOn(this);
				return Level.BLOCK_UPDATE_NORMAL;
			}
		}else if(type == Level.BLOCK_UPDATE_RANDOM){
			BozkurtRandom random = new BozkurtRandom();
			if(random.nextRange(1, 2) == 1){
				if(this.getDamage() < 0x07){
					Block block = this.clone();
					block.setDamage(block.getDamage() + 1);
					BlockGrowEvent ev = new BlockGrowEvent(this, block);
					Server.getInstance().getPluginManager().callEvent(ev);
					if(!ev.isCancelled()){
						this.getLevel().setBlock(this, ev.getNewState(), true);
					}
					return Level.BLOCK_UPDATE_RANDOM;
				}else{
					for(BlockFace face : Plane.HORIZONTAL){
						Block b = this.getSide(face);
						if(b.getId() == PUMPKIN){
							return Level.BLOCK_UPDATE_RANDOM;
						}
					}
					Block side = this.getSide(Plane.HORIZONTAL.random(random));
					Block d = side.down();
					if(side.getId() == AIR && (d.getId() == FARMLAND || d.getId() == GRASS || d.getId() == DIRT)){
						BlockGrowEvent ev = new BlockGrowEvent(side, new BlockPumpkin());
						Server.getInstance().getPluginManager().callEvent(ev);
						if(!ev.isCancelled()){
							this.getLevel().setBlock(side, ev.getNewState(), true);
						}
					}
				}
			}
			return Level.BLOCK_UPDATE_RANDOM;
		}
		return 0;
	}

	@Override
	public Item[] getDrops(Item item){
		BozkurtRandom random = new BozkurtRandom();
		return new Item[]{
				new ItemSeedsPumpkin(0, random.nextRange(0, 3))
		};
	}

}
