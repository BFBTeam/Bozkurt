package tr.bozkurt.level.biome.impl.taiga;

/**
 * author: DaPorkchop_
 * Bozkurt Project
 */
//porktodo: this biome has very steep cliffs
public class ColdTaigaMBiome extends ColdTaigaBiome{

	public ColdTaigaMBiome(){
		super();
	}

	@Override
	public String getName(){
		return "Cold Taiga M";
	}

	@Override
	public boolean doesOverhang(){
		return true;
	}

}
