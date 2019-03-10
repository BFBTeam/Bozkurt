package tr.bozkurt.level.biome.impl.taiga;

import tr.bozkurt.block.BlockSapling;
import tr.bozkurt.level.biome.type.GrassyBiome;
import tr.bozkurt.level.generator.populator.impl.PopulatorTree;

/**
 * author: DaPorkchop_
 * Bozkurt Project
 */
public class TaigaBiome extends GrassyBiome{

	public TaigaBiome(){
		super();

		PopulatorTree trees = new PopulatorTree(BlockSapling.SPRUCE);
		trees.setBaseAmount(10);
		this.addPopulator(trees);

		this.setBaseHeight(0.2f);
		this.setHeightVariation(0.2f);
	}

	@Override
	public String getName(){
		return "Taiga";
	}

}
