package tr.bozkurt.entity.item;

import tr.bozkurt.entity.Entity;
import tr.bozkurt.event.entity.EntityDamageEvent;
import tr.bozkurt.level.Explosion;
import tr.bozkurt.level.GameRule;
import tr.bozkurt.level.Position;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;

/**
 * Created by PetteriM1
 */
public class EntityEndCrystal extends Entity{

	public static final int NETWORK_ID = 71;

	public EntityEndCrystal(FullChunk chunk, CompoundTag nbt){
		super(chunk, nbt);
	}

	@Override
	public int getNetworkId(){
		return NETWORK_ID;
	}

	@Override
	protected void initEntity(){
		super.initEntity();
	}

	@Override
	public float getHeight(){
		return 0.98f;
	}

	@Override
	public float getWidth(){
		return 0.98f;
	}

	public boolean attack(EntityDamageEvent source){
		if(!super.attack(source)){
			return false;
		}

		Position pos = this.getPosition();
		Explosion explode = new Explosion(pos, 6, this);

		close();

		if(this.level.getGameRules().getBoolean(GameRule.TNT_EXPLODES)){
			explode.explodeA();
			explode.explodeB();
		}

		return true;
	}

	@Override
	public boolean canCollideWith(Entity entity){
		return false;
	}

	public boolean showBase(){
		return this.getDataFlag(DATA_FLAGS, DATA_FLAG_SHOWBASE);
	}

	public void setShowBase(boolean value){
		this.setDataFlag(DATA_FLAGS, DATA_FLAG_SHOWBASE, value);
	}

}