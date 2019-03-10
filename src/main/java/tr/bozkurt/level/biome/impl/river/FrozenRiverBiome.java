package tr.bozkurt.level.biome.impl.river;

import tr.bozkurt.level.generator.populator.impl.WaterIcePopulator;

/**
 * author: DaPorkchop_
 * Bozkurt Project
 */
public class FrozenRiverBiome extends RiverBiome{

	public FrozenRiverBiome(){
		super();

		WaterIcePopulator ice = new WaterIcePopulator();
		this.addPopulator(ice);
	}

	@Override
	public String getName(){
		return "Frozen River";
	}

	@Override
	public boolean isFreezing(){
		return true;
	}

}
