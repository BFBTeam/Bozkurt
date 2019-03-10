package tr.bozkurt.level.biome.impl.swamp;

import tr.bozkurt.block.Block;
import tr.bozkurt.block.BlockFlower;
import tr.bozkurt.level.biome.type.GrassyBiome;
import tr.bozkurt.level.generator.populator.impl.MushroomPopulator;
import tr.bozkurt.level.generator.populator.impl.PopulatorFlower;
import tr.bozkurt.level.generator.populator.impl.PopulatorLilyPad;
import tr.bozkurt.level.generator.populator.impl.PopulatorSmallMushroom;
import tr.bozkurt.level.generator.populator.impl.tree.SwampTreePopulator;

/**
 * Bozkurt Project
 */
public class SwampBiome extends GrassyBiome{

	public SwampBiome(){
		super();

		PopulatorLilyPad lilypad = new PopulatorLilyPad();
		lilypad.setBaseAmount(4);
		lilypad.setRandomAmount(2);
		this.addPopulator(lilypad);

		SwampTreePopulator trees = new SwampTreePopulator();
		trees.setBaseAmount(2);
		this.addPopulator(trees);

		PopulatorFlower flower = new PopulatorFlower();
		flower.setBaseAmount(2);
		flower.addType(Block.RED_FLOWER, BlockFlower.TYPE_BLUE_ORCHID);
		this.addPopulator(flower);

		MushroomPopulator mushroom = new MushroomPopulator(1);
		mushroom.setBaseAmount(-5);
		mushroom.setRandomAmount(7);
		this.addPopulator(mushroom);

		PopulatorSmallMushroom smallMushroom = new PopulatorSmallMushroom();
		smallMushroom.setBaseAmount(0);
		smallMushroom.setRandomAmount(2);
		this.addPopulator(smallMushroom);

		this.setBaseHeight(-0.2f);
		this.setHeightVariation(0.1f);
	}

	@Override
	public String getName(){
		return "Swamp";
	}

}
