package tr.bozkurt.level.biome.impl.taiga;

/**
 * @author DaPorkchop_
 * Bozkurt Project
 */
public class TaigaHillsBiome extends TaigaBiome{

	public TaigaHillsBiome(){
		super();

		this.setBaseHeight(0.25f);
		this.setHeightVariation(0.8f);
	}

	@Override
	public String getName(){
		return "Taiga Hills";
	}

}
