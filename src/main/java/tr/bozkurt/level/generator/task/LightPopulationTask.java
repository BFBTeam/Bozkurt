package tr.bozkurt.level.generator.task;

import tr.bozkurt.Server;
import tr.bozkurt.level.Level;
import tr.bozkurt.level.format.generic.BaseFullChunk;
import tr.bozkurt.scheduler.AsyncTask;

/**
 * Bozkurt Project
 */
public class LightPopulationTask extends AsyncTask{

	public final int levelId;
	public BaseFullChunk chunk;

	public LightPopulationTask(Level level, BaseFullChunk chunk){
		this.levelId = level.getId();
		this.chunk = chunk;
	}

	@Override
	public void onRun(){
		BaseFullChunk chunk = this.chunk.clone();
		if(chunk == null){
			return;
		}

		chunk.recalculateHeightMap();
		chunk.populateSkyLight();
		chunk.setLightPopulated();

		this.chunk = chunk.clone();
	}

	@Override
	public void onCompletion(Server server){
		Level level = server.getLevel(this.levelId);

		BaseFullChunk chunk = this.chunk.clone();
		if(level != null){
			if(chunk == null){
				return;
			}

			level.generateChunkCallback(chunk.getX(), chunk.getZ(), chunk);
		}
	}

}
