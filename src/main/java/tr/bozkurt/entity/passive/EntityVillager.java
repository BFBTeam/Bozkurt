package tr.bozkurt.entity.passive;

import tr.bozkurt.entity.Entity;
import tr.bozkurt.entity.EntityAgeable;
import tr.bozkurt.entity.EntityCreature;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;

/**
 * Created by Pub4Game on 21.06.2016.
 */
public class EntityVillager extends EntityCreature implements EntityNPC, EntityAgeable{

	public static final int PROFESSION_FARMER = 0;
	public static final int PROFESSION_LIBRARIAN = 1;
	public static final int PROFESSION_PRIEST = 2;
	public static final int PROFESSION_BLACKSMITH = 3;
	public static final int PROFESSION_BUTCHER = 4;
	public static final int PROFESSION_GENERIC = 5;
	public static final int NETWORK_ID = 15;

	public EntityVillager(FullChunk chunk, CompoundTag nbt){
		super(chunk, nbt);
	}

	@Override
	public float getWidth(){
		if(this.isBaby()){
			return 0.3f;
		}
		return 0.6f;
	}

	@Override
	public float getHeight(){
		if(this.isBaby()){
			return 0.975f;
		}
		return 1.95f;
	}

	@Override
	public String getName(){
		return "Villager";
	}

	@Override
	public int getNetworkId(){
		return NETWORK_ID;
	}

	@Override
	public void initEntity(){
		super.initEntity();
		if(!this.namedTag.contains("Profession")){
			this.setProfession(PROFESSION_GENERIC);
		}
	}

	public int getProfession(){
		return this.namedTag.getInt("Profession");
	}

	public void setProfession(int profession){
		this.namedTag.putInt("Profession", profession);
	}

	@Override
	public boolean isBaby(){
		return this.getDataFlag(DATA_FLAGS, Entity.DATA_FLAG_BABY);
	}

}
