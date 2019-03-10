package tr.bozkurt.level.biome.impl.ocean;

import tr.bozkurt.level.biome.type.WateryBiome;

/**
 * Bozkurt Project
 */
public class OceanBiome extends WateryBiome{

	public OceanBiome(){
		this.setBaseHeight(-1f);
		this.setHeightVariation(0.1f);
	}

	@Override
	public String getName(){
		return "Ocean";
	}

}
