package tr.bozkurt.level.format.leveldb.key;

/**
 * Bozkurt Project
 */
public class VersionKey extends BaseKey{

	protected VersionKey(int chunkX, int chunkZ){
		super(chunkX, chunkZ, DATA_VERSION);
	}

	public static VersionKey create(int chunkX, int chunkZ){
		return new VersionKey(chunkX, chunkZ);
	}

}
