package tr.bozkurt.level.format.leveldb.key;

/**
 * Bozkurt Project
 */
public class TerrainKey extends BaseKey{

	protected TerrainKey(int chunkX, int chunkZ){
		super(chunkX, chunkZ, DATA_TERRAIN);
	}

	public static TerrainKey create(int chunkX, int chunkZ){
		return new TerrainKey(chunkX, chunkZ);
	}

}
