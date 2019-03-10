package tr.bozkurt.level.generator.populator.helper;

import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntSet;
import tr.bozkurt.block.BlockID;
import tr.bozkurt.level.format.FullChunk;

/**
 * @author DaPorkchop_
 */
public final class PopulatorHelpers implements BlockID{

	private static final IntSet nonSolidBlocks = new IntOpenHashSet();

	static{
		nonSolidBlocks.add(AIR);
		nonSolidBlocks.add(LEAVES);
		nonSolidBlocks.add(LEAVES2);
		nonSolidBlocks.add(SNOW_LAYER);
	}

	private PopulatorHelpers(){
	}

	public static boolean canGrassStay(int x, int y, int z, FullChunk chunk){
		return EnsureCover.ensureCover(x, y, z, chunk) && EnsureGrassBelow.ensureGrassBelow(x, y, z, chunk);
	}

	public static boolean isNonSolid(int id){
		return nonSolidBlocks.contains(id);
	}

}
