package tr.bozkurt.level.biome.impl.ocean;

/**
 * author: DaPorkchop_
 * Bozkurt Project
 */
public class DeepOceanBiome extends OceanBiome{

	public DeepOceanBiome(){
		super();

		//TODO: ocean monuments
		this.setBaseHeight(-1.8f);
		this.setHeightVariation(0.1f);
	}

	@Override
	public String getName(){
		return "Deep Ocean";
	}

}
