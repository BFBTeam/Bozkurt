package tr.bozkurt.level.biome.impl.desert;

import tr.bozkurt.level.biome.type.SandyBiome;
import tr.bozkurt.level.generator.populator.impl.PopulatorCactus;
import tr.bozkurt.level.generator.populator.impl.PopulatorDeadBush;

/**
 * Bozkurt Project
 */
public class DesertBiome extends SandyBiome{

	public DesertBiome(){
		PopulatorCactus cactus = new PopulatorCactus();
		cactus.setBaseAmount(2);
		this.addPopulator(cactus);

		PopulatorDeadBush deadbush = new PopulatorDeadBush();
		deadbush.setBaseAmount(2);
		this.addPopulator(deadbush);

		this.setBaseHeight(0.125f);
		this.setHeightVariation(0.05f);
	}

	@Override
	public String getName(){
		return "Desert";
	}

}
