package tr.bozkurt.level.generator.populator.impl;

import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.math.BozkurtRandom;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Niall Lindsay (Niall7459)
 * <p>
 * Bozkurt Project
 * </p>
 */

public class PopulatorTallSugarcane extends PopulatorSugarcane{

	@Override
	protected void placeBlock(int x, int y, int z, int id, FullChunk chunk, BozkurtRandom random){
		int height = ThreadLocalRandom.current().nextInt(3) + 1;
		for(int i = 0; i < height; i++){
			chunk.setFullBlockId(x, y + i, z, id);
		}
	}

}
