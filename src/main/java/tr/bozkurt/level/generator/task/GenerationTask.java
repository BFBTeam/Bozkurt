package tr.bozkurt.level.generator.task;

import tr.bozkurt.Server;
import tr.bozkurt.level.Level;
import tr.bozkurt.level.format.generic.BaseFullChunk;
import tr.bozkurt.level.generator.Generator;
import tr.bozkurt.level.generator.SimpleChunkManager;
import tr.bozkurt.scheduler.AsyncTask;

/**
 * Bozkurt Project
 */
public class GenerationTask extends AsyncTask{

	private final Level level;
	public boolean state;
	private BaseFullChunk chunk;


	public GenerationTask(Level level, BaseFullChunk chunk){
		this.state = true;
		this.chunk = chunk;
		this.level = level;
	}

	@Override
	public void onRun(){
		Generator generator = level.getGenerator();
		this.state = false;
		if(generator == null){
			return;
		}

		SimpleChunkManager manager = (SimpleChunkManager) generator.getChunkManager();

		if(manager == null){
			this.state = false;
			return;
		}

		manager.cleanChunks(level.getSeed());
		synchronized(manager){
			try{
				BaseFullChunk chunk = this.chunk;

				if(chunk == null){
					return;
				}

				synchronized(chunk){
					if(!chunk.isGenerated()){
						manager.setChunk(chunk.getX(), chunk.getZ(), chunk);
						generator.generateChunk(chunk.getX(), chunk.getZ());
						chunk = manager.getChunk(chunk.getX(), chunk.getZ());
						chunk.setGenerated();
					}
				}
				this.chunk = chunk;
				state = true;
			}finally{
				manager.cleanChunks(level.getSeed());
			}
		}

	}

	@Override
	public void onCompletion(Server server){
		if(level != null){
			if(!this.state){
				return;
			}

			BaseFullChunk chunk = this.chunk;

			if(chunk == null){
				return;
			}

			level.generateChunkCallback(chunk.getX(), chunk.getZ(), chunk);
		}
	}

}
