package tr.bozkurt.level.biome.impl.beach;

import tr.bozkurt.level.biome.type.SandyBiome;
import tr.bozkurt.level.generator.populator.impl.WaterIcePopulator;

public class ColdBeachBiome extends SandyBiome{

	public ColdBeachBiome(){
		WaterIcePopulator ice = new WaterIcePopulator();
		this.addPopulator(ice);

		this.setBaseHeight(0f);
		this.setHeightVariation(0.025f);
	}

	@Override
	public int getCoverBlock(){
		return SNOW_LAYER;
	}

	@Override
	public String getName(){
		return "Cold Beach";
	}

	@Override
	public boolean isFreezing(){
		return true;
	}

}
