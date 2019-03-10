package tr.bozkurt.level.biome.type;

import tr.bozkurt.level.generator.populator.impl.WaterIcePopulator;

/**
 * author: DaPorkchop_
 * Bozkurt Project
 */
public abstract class SnowyBiome extends GrassyBiome{

	public SnowyBiome(){
		super();

		WaterIcePopulator waterIce = new WaterIcePopulator();
		this.addPopulator(waterIce);
	}

	@Override
	public int getCoverBlock(){
		return SNOW_LAYER;
	}

}
