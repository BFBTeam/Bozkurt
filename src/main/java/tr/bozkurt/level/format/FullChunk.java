package tr.bozkurt.level.format;

import tr.bozkurt.block.Block;
import tr.bozkurt.blockentity.BlockEntity;
import tr.bozkurt.entity.Entity;
import tr.bozkurt.level.biome.Biome;

import java.io.IOException;
import java.util.Map;

/**
 * Bozkurt Project
 */
public interface FullChunk extends Cloneable{

	int getX();

	void setX(int x);

	int getZ();

	void setZ(int z);

	default void setPosition(int x, int z){
		setX(x);
		setZ(z);
	}

	long getIndex();

	LevelProvider getProvider();

	void setProvider(LevelProvider provider);

	int getFullBlock(int x, int y, int z);

	Block getAndSetBlock(int x, int y, int z, Block block);

	default boolean setFullBlockId(int x, int y, int z, int fullId){
		return setBlock(x, y, z, fullId >> 4, fullId & 0xF);
	}

	boolean setBlock(int x, int y, int z, int blockId);

	boolean setBlock(int x, int y, int z, int blockId, int meta);

	int getBlockId(int x, int y, int z);

	void setBlockId(int x, int y, int z, int id);

	int getBlockData(int x, int y, int z);

	void setBlockData(int x, int y, int z, int data);

	int getBlockExtraData(int x, int y, int z);

	void setBlockExtraData(int x, int y, int z, int data);

	int getBlockSkyLight(int x, int y, int z);

	void setBlockSkyLight(int x, int y, int z, int level);

	int getBlockLight(int x, int y, int z);

	void setBlockLight(int x, int y, int z, int level);

	int getHighestBlockAt(int x, int z);

	int getHighestBlockAt(int x, int z, boolean cache);

	int getHeightMap(int x, int z);

	void setHeightMap(int x, int z, int value);

	void recalculateHeightMap();

	void populateSkyLight();

	int getBiomeId(int x, int z);

	void setBiomeId(int x, int z, byte biomeId);

	default void setBiomeId(int x, int z, int biomeId){
		setBiomeId(x, z, (byte) biomeId);
	}

	default void setBiome(int x, int z, Biome biome){
		setBiomeId(x, z, (byte) biome.getId());
	}

	boolean isLightPopulated();

	void setLightPopulated(boolean value);

	void setLightPopulated();

	boolean isPopulated();

	void setPopulated(boolean value);

	void setPopulated();

	boolean isGenerated();

	void setGenerated(boolean value);

	void setGenerated();

	void addEntity(Entity entity);

	void removeEntity(Entity entity);

	void addBlockEntity(BlockEntity blockEntity);

	void removeBlockEntity(BlockEntity blockEntity);

	Map<Long, Entity> getEntities();

	Map<Long, BlockEntity> getBlockEntities();

	BlockEntity getTile(int x, int y, int z);

	boolean isLoaded();

	boolean load() throws IOException;

	boolean load(boolean generate) throws IOException;

	boolean unload() throws Exception;

	boolean unload(boolean save) throws Exception;

	boolean unload(boolean save, boolean safe) throws Exception;

	void initChunk();

	byte[] getBiomeIdArray();

	byte[] getHeightMapArray();

	byte[] getBlockIdArray();

	byte[] getBlockDataArray();

	Map<Integer, Integer> getBlockExtraDataArray();

	byte[] getBlockSkyLightArray();

	byte[] getBlockLightArray();

	byte[] toBinary();

	byte[] toFastBinary();

	boolean hasChanged();

	void setChanged();

	void setChanged(boolean changed);

}
