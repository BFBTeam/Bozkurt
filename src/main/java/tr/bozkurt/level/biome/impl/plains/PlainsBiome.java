package tr.bozkurt.level.biome.impl.plains;

import tr.bozkurt.level.biome.type.GrassyBiome;

/**
 * author: DaPorkchop_
 * Bozkurt Project
 */
public class PlainsBiome extends GrassyBiome{

	public PlainsBiome(){
		super();

		this.setBaseHeight(0.125f);
		this.setHeightVariation(0.05f);
	}

	@Override
	public String getName(){
		return "Plains";
	}

}
