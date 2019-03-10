package tr.bozkurt.level.biome.impl.taiga;

import tr.bozkurt.level.generator.populator.impl.tree.SpruceBigTreePopulator;

/**
 * author: DaPorkchop_
 * Bozkurt Project
 */
public class MegaSpruceTaigaBiome extends TaigaBiome{

	public MegaSpruceTaigaBiome(){
		super();

		SpruceBigTreePopulator bigTrees = new SpruceBigTreePopulator();
		bigTrees.setBaseAmount(6);
		this.addPopulator(bigTrees);
	}

	@Override
	public String getName(){
		return "Mega Spruce Taiga";
	}

}
