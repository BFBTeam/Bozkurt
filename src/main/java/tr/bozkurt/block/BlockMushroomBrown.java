package tr.bozkurt.block;

import tr.bozkurt.Player;
import tr.bozkurt.item.Item;
import tr.bozkurt.level.Level;
import tr.bozkurt.level.generator.object.mushroom.BigMushroom;
import tr.bozkurt.level.particle.BoneMealParticle;
import tr.bozkurt.math.BlockFace;
import tr.bozkurt.math.BozkurtRandom;
import tr.bozkurt.utils.BlockColor;
import tr.bozkurt.utils.DyeColor;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Bozkurt Project Team
 */
public class BlockMushroomBrown extends BlockFlowable{

	public BlockMushroomBrown(){
		this(0);
	}

	public BlockMushroomBrown(int meta){
		super(0);
	}

	@Override
	public String getName(){
		return "Brown Mushroom";
	}

	@Override
	public int getId(){
		return BROWN_MUSHROOM;
	}

	@Override
	public int getLightLevel(){
		return 1;
	}

	@Override
	public int onUpdate(int type){
		if(type == Level.BLOCK_UPDATE_NORMAL){
			if(!canStay()){
				getLevel().useBreakOn(this);

				return Level.BLOCK_UPDATE_NORMAL;
			}
		}
		return 0;
	}

	@Override
	public boolean place(Item item, Block block, Block target, BlockFace face, double fx, double fy, double fz, Player player){
		if(canStay()){
			getLevel().setBlock(block, this, true, true);
			return true;
		}
		return false;
	}

	@Override
	public boolean canBeActivated(){
		return true;
	}

	@Override
	public boolean onActivate(Item item, Player player){
		if(item.getId() == Item.DYE && item.getDamage() == DyeColor.WHITE.getDyeData()){
			if(ThreadLocalRandom.current().nextFloat() < 0.4){
				this.grow();
			}

			this.level.addParticle(new BoneMealParticle(this));
			return true;
		}
		return false;
	}

	public boolean grow(){
		this.level.setBlock(this, new BlockAir(), true, false);

		BigMushroom generator = new BigMushroom(0);

		if(generator.generate(this.level, new BozkurtRandom(), this)){
			return true;
		}else{
			this.level.setBlock(this, this, true, false);
			return false;
		}
	}

	public boolean canStay(){
		Block block = this.down();
		return block.getId() == MYCELIUM || block.getId() == PODZOL || (!block.isTransparent() && this.level.getFullLight(this) < 13);
	}

	@Override
	public BlockColor getColor(){
		return BlockColor.FOLIAGE_BLOCK_COLOR;
	}

	@Override
	public boolean canSilkTouch(){
		return true;
	}

}
