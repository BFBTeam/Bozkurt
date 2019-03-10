package tr.bozkurt.level.biome.impl.taiga;

/**
 * author: DaPorkchop_
 * Bozkurt Project
 */
//porktodo: this should be flat-ish in most places, and upheavals should be steep
public class TaigaMBiome extends TaigaBiome{

	public TaigaMBiome(){
		super();

		this.setBaseHeight(0.3f);
		this.setHeightVariation(0.4f);
	}

	@Override
	public String getName(){
		return "Taiga M";
	}

}
