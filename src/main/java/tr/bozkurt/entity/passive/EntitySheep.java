package tr.bozkurt.entity.passive;

import tr.bozkurt.Player;
import tr.bozkurt.entity.data.ByteEntityData;
import tr.bozkurt.event.entity.EntityDamageByEntityEvent;
import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemDye;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.nbt.tag.CompoundTag;
import tr.bozkurt.utils.DyeColor;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Author: BeYkeRYkt Bozkurt Project
 */
public class EntitySheep extends EntityAnimal{

	public static final int NETWORK_ID = 13;

	public boolean sheared = false;
	public int color = 0;

	public EntitySheep(FullChunk chunk, CompoundTag nbt){
		super(chunk, nbt);
	}

	@Override
	public float getWidth(){
		if(this.isBaby()){
			return 0.45f;
		}
		return 0.9f;
	}

	@Override
	public float getHeight(){
		if(isBaby()){
			return 0.65f;
		}
		return 1.3f;
	}

	@Override
	public String getName(){
		return "Sheep";
	}

	@Override
	public int getNetworkId(){
		return NETWORK_ID;
	}

	@Override
	public void initEntity(){
		this.setMaxHealth(8);

		if(!this.namedTag.contains("Color")){
			this.setColor(randomColor());
		}else{
			this.setColor(this.namedTag.getByte("Color"));
		}

		if(!this.namedTag.contains("Sheared")){
			this.namedTag.putByte("Sheared", 0);
		}else{
			this.sheared = this.namedTag.getBoolean("Sheared");
		}

		this.setDataFlag(DATA_FLAGS, DATA_FLAG_SHEARED, this.sheared);
	}

	@Override
	public void saveNBT(){
		super.saveNBT();

		this.namedTag.putByte("Color", this.color);
		this.namedTag.putBoolean("Sheared", this.sheared);
	}

	@Override
	public boolean onInteract(Player player, Item item){
		if(item.getId() == Item.DYE){
			this.setColor(((ItemDye) item).getDyeColor().getWoolData());
			return true;
		}

		return item.getId() == Item.SHEARS && shear();
	}

	public boolean shear(){
		if(sheared){
			return false;
		}

		this.sheared = true;
		this.setDataFlag(DATA_FLAGS, DATA_FLAG_SHEARED, true);

		this.level.dropItem(this, Item.get(Item.WOOL, getColor(), ThreadLocalRandom.current().nextInt(2) + 1));
		return true;
	}

	@Override
	public Item[] getDrops(){
		if(this.lastDamageCause instanceof EntityDamageByEntityEvent){
			return new Item[]{Item.get(Item.WOOL, getColor(), 1)};
		}
		return new Item[0];
	}

	public int getColor(){
		return namedTag.getByte("Color");
	}

	public void setColor(int color){
		this.color = color;
		this.setDataProperty(new ByteEntityData(DATA_COLOUR, color));
		this.namedTag.putByte("Color", this.color);
	}

	private int randomColor(){
		ThreadLocalRandom random = ThreadLocalRandom.current();
		double rand = random.nextDouble(1, 100);

		if(rand <= 0.164){
			return DyeColor.PINK.getWoolData();
		}

		if(rand <= 15){
			return random.nextBoolean() ? DyeColor.BLACK.getWoolData() : random.nextBoolean() ? DyeColor.GRAY.getWoolData() : DyeColor.LIGHT_GRAY.getWoolData();
		}

		return DyeColor.WHITE.getWoolData();
	}

}
