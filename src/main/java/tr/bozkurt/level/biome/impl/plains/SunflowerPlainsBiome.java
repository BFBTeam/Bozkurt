package tr.bozkurt.level.biome.impl.plains;

import tr.bozkurt.block.BlockDoublePlant;
import tr.bozkurt.level.generator.populator.impl.PopulatorDoublePlant;

/**
 * author: DaPorkchop_
 * Bozkurt Project
 */
public class SunflowerPlainsBiome extends PlainsBiome{

	public SunflowerPlainsBiome(){
		super();

		PopulatorDoublePlant sunflower = new PopulatorDoublePlant(BlockDoublePlant.SUNFLOWER);
		sunflower.setBaseAmount(8);
		sunflower.setRandomAmount(5);
		this.addPopulator(sunflower);
	}

	@Override
	public String getName(){
		return "Sunflower Plains";
	}

}
