package tr.bozkurt.level;

import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.math.Vector3;

/**
 * Bozkurt Project
 */
public interface ChunkLoader{

	int getLoaderId();

	boolean isLoaderActive();

	Position getPosition();

	double getX();

	double getZ();

	Level getLevel();

	void onChunkChanged(FullChunk chunk);

	void onChunkLoaded(FullChunk chunk);

	void onChunkUnloaded(FullChunk chunk);

	void onChunkPopulated(FullChunk chunk);

	void onBlockChanged(Vector3 block);

}
