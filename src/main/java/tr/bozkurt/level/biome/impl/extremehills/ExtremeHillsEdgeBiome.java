package tr.bozkurt.level.biome.impl.extremehills;

/**
 * author: DaPorkchop_
 * Bozkurt Project
 */
public class ExtremeHillsEdgeBiome extends ExtremeHillsBiome{

	public ExtremeHillsEdgeBiome(){
		super();

		this.setBaseHeight(0.8f);
		this.setHeightVariation(0.3f);
	}

	@Override
	public String getName(){
		return "Extreme Hills Edge";
	}

}
