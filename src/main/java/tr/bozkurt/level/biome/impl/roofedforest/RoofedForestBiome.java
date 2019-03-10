package tr.bozkurt.level.biome.impl.roofedforest;

import tr.bozkurt.level.biome.type.GrassyBiome;
import tr.bozkurt.level.generator.populator.impl.MushroomPopulator;
import tr.bozkurt.level.generator.populator.impl.PopulatorFlower;
import tr.bozkurt.level.generator.populator.impl.tree.DarkOakTreePopulator;

public class RoofedForestBiome extends GrassyBiome{

	public RoofedForestBiome(){
		super();

		DarkOakTreePopulator tree = new DarkOakTreePopulator();
		tree.setBaseAmount(20);
		tree.setRandomAmount(10);
		this.addPopulator(tree);

		PopulatorFlower flower = new PopulatorFlower();
		flower.setBaseAmount(2);
		this.addPopulator(flower);

		MushroomPopulator mushroom = new MushroomPopulator();
		mushroom.setBaseAmount(0);
		mushroom.setRandomAmount(1);
		this.addPopulator(mushroom);
	}

	@Override
	public String getName(){
		return "Roofed Forest";
	}

}
