package tr.bozkurt.level.biome.impl.mushroom;

import tr.bozkurt.block.Block;
import tr.bozkurt.level.biome.type.GrassyBiome;
import tr.bozkurt.level.generator.populator.impl.MushroomPopulator;

public class MushroomIslandBiome extends GrassyBiome{

	public MushroomIslandBiome(){
		MushroomPopulator mushroomPopulator = new MushroomPopulator();
		mushroomPopulator.setBaseAmount(1);
		addPopulator(mushroomPopulator);

		this.setBaseHeight(0.2f);
		this.setHeightVariation(0.3f);
	}

	@Override
	public String getName(){
		return "Mushroom Island";
	}

	@Override
	public int getSurfaceBlock(int y){
		return Block.MYCELIUM;
	}

}
