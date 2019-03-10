package tr.bozkurt.level.biome.impl.river;

import tr.bozkurt.level.biome.type.WateryBiome;

/**
 * author: DaPorkchop_
 * Bozkurt Project
 */
public class RiverBiome extends WateryBiome{

	public RiverBiome(){
		this.setBaseHeight(-0.5f);
		this.setHeightVariation(0f);
	}

	@Override
	public String getName(){
		return "River";
	}

}
