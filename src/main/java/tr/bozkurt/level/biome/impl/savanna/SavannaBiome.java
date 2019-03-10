package tr.bozkurt.level.biome.impl.savanna;

import tr.bozkurt.block.BlockSapling;
import tr.bozkurt.level.biome.type.GrassyBiome;
import tr.bozkurt.level.generator.populator.impl.tree.SavannaTreePopulator;

/**
 * @author DaPorkchop_
 */
public class SavannaBiome extends GrassyBiome{

	public SavannaBiome(){
		super();

		SavannaTreePopulator tree = new SavannaTreePopulator(BlockSapling.ACACIA);
		tree.setBaseAmount(1);
		this.addPopulator(tree);

		this.setBaseHeight(0.125f);
		this.setHeightVariation(0.05f);
	}

	@Override
	public String getName(){
		return "Savanna";
	}

}
