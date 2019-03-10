package tr.bozkurt.level.biome.type;

import tr.bozkurt.block.BlockDoublePlant;
import tr.bozkurt.level.generator.populator.impl.PopulatorDoublePlant;
import tr.bozkurt.level.generator.populator.impl.PopulatorGrass;

/**
 * Bozkurt Project
 */
public abstract class GrassyBiome extends CoveredBiome{

	public GrassyBiome(){
		PopulatorGrass grass = new PopulatorGrass();
		grass.setBaseAmount(30);
		this.addPopulator(grass);

		PopulatorDoublePlant tallGrass = new PopulatorDoublePlant(BlockDoublePlant.TALL_GRASS);
		tallGrass.setBaseAmount(5);
		this.addPopulator(tallGrass);
	}

	@Override
	public int getSurfaceBlock(int y){
		return GRASS;
	}

	@Override
	public int getGroundBlock(int y){
		return DIRT;
	}

}
