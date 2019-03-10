package tr.bozkurt.level.generator.object;

import tr.bozkurt.block.Block;
import tr.bozkurt.level.ChunkManager;
import tr.bozkurt.math.BozkurtRandom;
import tr.bozkurt.math.Vector3;

/**
 * author: ItsLucas
 * Bozkurt Project
 */
//porktodo: biomes have specific flower types that can grow in them
public class ObjectTallGrass{

	public static void growGrass(ChunkManager level, Vector3 pos, BozkurtRandom random, int count, int radius){
		int[][] arr = {
				{Block.DANDELION, 0},
				{Block.POPPY, 0},
				{Block.TALL_GRASS, 1},
				{Block.TALL_GRASS, 1},
				{Block.TALL_GRASS, 1},
				{Block.TALL_GRASS, 1}
		};
		int arrC = arr.length - 1;
		for(int c = 0; c < count; c++){
			int x = random.nextRange((int) (pos.x - radius), (int) (pos.x + radius));
			int z = random.nextRange((int) (pos.z) - radius, (int) (pos.z + radius));

			if(level.getBlockIdAt(x, (int) (pos.y + 1), z) == Block.AIR && level.getBlockIdAt(x, (int) (pos.y), z) == Block.GRASS){
				int[] t = arr[random.nextRange(0, arrC)];
				level.setBlockAt(x, (int) (pos.y + 1), z, t[0], t[1]);
			}
		}
	}

}
