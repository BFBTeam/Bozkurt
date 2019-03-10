package tr.bozkurt.level.biome.impl.iceplains;

import tr.bozkurt.block.BlockSapling;
import tr.bozkurt.level.biome.type.SnowyBiome;
import tr.bozkurt.level.generator.populator.impl.PopulatorTree;

/**
 * Bozkurt Project
 */
public class IcePlainsBiome extends SnowyBiome{

	public IcePlainsBiome(){
		super();

		PopulatorTree trees = new PopulatorTree(BlockSapling.SPRUCE);
		trees.setBaseAmount(0);
		trees.setRandomAmount(1);
		this.addPopulator(trees);


		this.setBaseHeight(0.125f);
		this.setHeightVariation(0.05f);
	}

	public String getName(){
		return "Ice Plains";
	}

}
