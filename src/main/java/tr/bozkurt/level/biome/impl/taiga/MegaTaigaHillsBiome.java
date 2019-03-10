package tr.bozkurt.level.biome.impl.taiga;

/**
 * author: DaPorkchop_
 * Bozkurt Project
 */
public class MegaTaigaHillsBiome extends MegaTaigaBiome{

	public MegaTaigaHillsBiome(){
		super();

		this.setBaseHeight(0.45f);
		this.setHeightVariation(0.3f);
	}

	@Override
	public String getName(){
		return "Mega Taiga Hills";
	}

}
