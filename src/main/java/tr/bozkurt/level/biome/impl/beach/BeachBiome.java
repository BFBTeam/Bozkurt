package tr.bozkurt.level.biome.impl.beach;

import tr.bozkurt.level.biome.type.SandyBiome;
import tr.bozkurt.level.generator.populator.impl.PopulatorSugarcane;

/**
 * Author: PeratX
 * Bozkurt Project
 */
public class BeachBiome extends SandyBiome{

	public BeachBiome(){
		PopulatorSugarcane sugarcane = new PopulatorSugarcane();
		sugarcane.setBaseAmount(0);
		sugarcane.setRandomAmount(3);
		this.addPopulator(sugarcane);

		this.setBaseHeight(0f);
		this.setHeightVariation(0.025f);
	}

	@Override
	public String getName(){
		return "Beach";
	}

}
