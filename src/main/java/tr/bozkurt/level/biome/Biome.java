package tr.bozkurt.level.biome;

import tr.bozkurt.block.BlockID;
import tr.bozkurt.level.ChunkManager;
import tr.bozkurt.level.format.FullChunk;
import tr.bozkurt.level.generator.populator.type.Populator;
import tr.bozkurt.math.BozkurtRandom;

import java.util.ArrayList;
import java.util.List;

/**
 * Bozkurt Project
 */
public abstract class Biome implements BlockID{

	public static final int MAX_BIOMES = 256;
	public static final Biome[] biomes = new Biome[MAX_BIOMES];
	public static final List<Biome> unorderedBiomes = new ArrayList<>();

	private final ArrayList<Populator> populators = new ArrayList<>();
	private int id;
	private float baseHeight = 0.1f;
	private float heightVariation = 0.3f;

	protected static void register(int id, Biome biome){
		biome.setId(id);
		biomes[id] = biome;
		unorderedBiomes.add(biome);
	}

	static Biome getBiome(int id){
		Biome biome = biomes[id];
		return biome != null ? biome : EnumBiome.OCEAN.biome;
	}

	/**
	 * Get Biome by name.
	 *
	 * @param name Name of biome. Name could contain symbol "_" instead of space
	 * @return Biome. Null - when biome was not found
	 */
	static Biome getBiome(String name){
		for(Biome biome : biomes){
			if(biome != null){
				if(biome.getName().equalsIgnoreCase(name.replace("_", " "))) return biome;
			}
		}
		return null;
	}

	public void clearPopulators(){
		this.populators.clear();
	}

	public void addPopulator(Populator populator){
		this.populators.add(populator);
	}

	public void populateChunk(ChunkManager level, int chunkX, int chunkZ, BozkurtRandom random){
		FullChunk chunk = level.getChunk(chunkX, chunkZ);
		for(Populator populator : populators){
			populator.populate(level, chunkX, chunkZ, random, chunk);
		}
	}

	public ArrayList<Populator> getPopulators(){
		return populators;
	}

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	public abstract String getName();

	public float getBaseHeight(){
		return baseHeight;
	}

	public void setBaseHeight(float baseHeight){
		this.baseHeight = baseHeight;
	}

	public float getHeightVariation(){
		return heightVariation;
	}

	public void setHeightVariation(float heightVariation){
		this.heightVariation = heightVariation;
	}

	@Override
	public int hashCode(){
		return getId();
	}

	@Override
	public boolean equals(Object obj){
		return hashCode() == obj.hashCode();
	}

	//whether or not water should freeze into ice on generation
	public boolean isFreezing(){
		return false;
	}

	/**
	 * Whether or not overhangs should generate in this biome (places where solid blocks generate over air)
	 * <p>
	 * This should probably be used with a custom max elevation or things can look stupid
	 *
	 * @return overhang
	 */
	public boolean doesOverhang(){
		return false;
	}

	/**
	 * How much offset should be added to the min/max heights at this position
	 *
	 * @param x x
	 * @param z z
	 * @return height offset
	 */
	public int getHeightOffset(int x, int z){
		return 0;
	}

}
