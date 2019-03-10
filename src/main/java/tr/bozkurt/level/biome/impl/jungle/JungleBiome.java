package tr.bozkurt.level.biome.impl.jungle;

import tr.bozkurt.level.biome.type.GrassyBiome;
import tr.bozkurt.level.generator.populator.impl.PopulatorMelon;
import tr.bozkurt.level.generator.populator.impl.tree.JungleBigTreePopulator;
import tr.bozkurt.level.generator.populator.impl.tree.JungleTreePopulator;

/**
 * @author DaPorkchop_
 */
public class JungleBiome extends GrassyBiome{

	public JungleBiome(){
		super();

		JungleTreePopulator trees = new JungleTreePopulator();
		trees.setBaseAmount(10);
		this.addPopulator(trees);

		JungleBigTreePopulator bigTrees = new JungleBigTreePopulator();
		bigTrees.setBaseAmount(6);
		this.addPopulator(bigTrees);

		PopulatorMelon melon = new PopulatorMelon();
		melon.setBaseAmount(-65);
		melon.setRandomAmount(70);
		this.addPopulator(melon);
	}

	@Override
	public String getName(){
		return "Jungle";
	}

}
