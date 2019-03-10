package tr.bozkurt.level.format.leveldb.key;

/**
 * Bozkurt Project
 */
public class EntitiesKey extends BaseKey{

	protected EntitiesKey(int chunkX, int chunkZ){
		super(chunkX, chunkZ, DATA_ENTITIES);
	}

	public static EntitiesKey create(int chunkX, int chunkZ){
		return new EntitiesKey(chunkX, chunkZ);
	}

}
