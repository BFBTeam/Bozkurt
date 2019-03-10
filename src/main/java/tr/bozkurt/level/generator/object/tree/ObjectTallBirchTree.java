package tr.bozkurt.level.generator.object.tree;

import tr.bozkurt.level.ChunkManager;
import tr.bozkurt.math.BozkurtRandom;

/**
 * Bozkurt Project
 */
public class ObjectTallBirchTree extends ObjectBirchTree{

	@Override
	public void placeObject(ChunkManager level, int x, int y, int z, BozkurtRandom random){
		this.treeHeight = random.nextBoundedInt(3) + 10;
		super.placeObject(level, x, y, z, random);
	}

}
