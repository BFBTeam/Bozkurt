package tr.bozkurt.level.biome.impl.extremehills;

/**
 * author: DaPorkchop_
 * Bozkurt Project
 * <p>
 * make sure this is touching another extreme hills type or it'll look dumb
 * <p>
 * vertical cliffs, flat on top and on bottom
 */
public class ExtremeHillsPlusBiome extends ExtremeHillsBiome{

	public ExtremeHillsPlusBiome(){
		this(true);
	}

	public ExtremeHillsPlusBiome(boolean tree){
		super(tree);

		this.setBaseHeight(1f);
		this.setHeightVariation(0.5f);
	}

	@Override
	public String getName(){
		return "Extreme Hills+";
	}

}
