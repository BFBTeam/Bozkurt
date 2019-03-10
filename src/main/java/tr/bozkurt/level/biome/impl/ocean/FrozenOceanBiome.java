package tr.bozkurt.level.biome.impl.ocean;

import tr.bozkurt.level.generator.populator.impl.WaterIcePopulator;

/**
 * author: DaPorkchop_
 * Bozkurt Project
 * <p>
 * This biome does not generate naturally
 */
public class FrozenOceanBiome extends OceanBiome{

	public FrozenOceanBiome(){
		super();

		WaterIcePopulator ice = new WaterIcePopulator();
		this.addPopulator(ice);
	}

	@Override
	public String getName(){
		return "Frozen Ocean";
	}

	@Override
	public boolean isFreezing(){
		return true;
	}

}
