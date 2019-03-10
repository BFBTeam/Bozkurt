package tr.bozkurt.level.format.leveldb.key;

/**
 * Bozkurt Project
 */
public class TilesKey extends BaseKey{

	protected TilesKey(int chunkX, int chunkZ){
		super(chunkX, chunkZ, DATA_TILES);
	}

	public static TilesKey create(int chunkX, int chunkZ){
		return new TilesKey(chunkX, chunkZ);
	}

}
