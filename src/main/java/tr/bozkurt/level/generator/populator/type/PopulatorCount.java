package tr.bozkurt.level.generator.populator.type;

import tr.bozkurt.level.ChunkManager;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.math.BozkurtRandom;

/**
 * @author DaPorkchop_
 * <p>
 * A populator that generates an object a certain amount of times.
 * This prevents the exact same code from being repeated in nearly every single populator
 */
public abstract class PopulatorCount extends Populator{

	private int randomAmount;
	private int baseAmount;

	public final void setRandomAmount(int randomAmount){
		this.randomAmount = randomAmount + 1;
	}

	public final void setBaseAmount(int baseAmount){
		this.baseAmount = baseAmount;
	}

	@Override
	public final void populate(ChunkManager level, int chunkX, int chunkZ, BozkurtRandom random, FullChunk chunk){
		int count = baseAmount + random.nextBoundedInt(randomAmount);
		for(int i = 0; i < count; i++){
			populateCount(level, chunkX, chunkZ, random, chunk);
		}
	}

	protected abstract void populateCount(ChunkManager level, int chunkX, int chunkZ, BozkurtRandom random, FullChunk chunk);

}
