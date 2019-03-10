package tr.bozkurt.level.generator;

import tr.bozkurt.block.*;
import tr.bozkurt.level.ChunkManager;
import tr.bozkurt.level.Level;
import tr.bozkurt.level.biome.Biome;
import tr.bozkurt.level.biome.EnumBiome;
import tr.bozkurt.level.format.generic.BaseFullChunk;
import tr.bozkurt.level.generator.noise.bozkurt.f.SimplexF;
import tr.bozkurt.level.generator.object.ore.OreType;
import tr.bozkurt.level.generator.populator.impl.PopulatorGlowStone;
import tr.bozkurt.level.generator.populator.impl.PopulatorGroundFire;
import tr.bozkurt.level.generator.populator.impl.PopulatorLava;
import tr.bozkurt.level.generator.populator.impl.PopulatorOre;
import tr.bozkurt.level.generator.populator.type.Populator;
import tr.bozkurt.math.BozkurtRandom;
import tr.bozkurt.math.Vector3;

public class Nether extends Generator{

	private final List<Populator> populators = new ArrayList<>();
	private ChunkManager level;
	/**
	 * @var Random
	 */
	private BozkurtRandom bozkurtRandom;
	private Random random;
	private double lavaHeight = 32;
	private double bedrockDepth = 5;
	private SimplexF[] noiseGen = new SimplexF[3];
	private List<Populator> generationPopulators = new ArrayList<>();

	private long localSeed1;
	private long localSeed2;

	public Nether(){
		this(new HashMap<>());
	}

	public Nether(Map<String, Object> options){
		//Nothing here. Just used for future update.
	}

	@Override
	public int getId(){
		return Generator.TYPE_NETHER;
	}

	@Override
	public int getDimension(){
		return Level.DIMENSION_NETHER;
	}

	@Override
	public String getName(){
		return "nether";
	}

	@Override
	public Map<String, Object> getSettings(){
		return new HashMap<>();
	}

	@Override
	public ChunkManager getChunkManager(){
		return level;
	}

	@Override
	public void init(ChunkManager level, BozkurtRandom random){
		this.level = level;
		this.bozkurtRandom = random;
		this.random = new Random();
		this.bozkurtRandom.setSeed(this.level.getSeed());

		for(int i = 0; i < noiseGen.length; i++){
			noiseGen[i] = new SimplexF(bozkurtRandom, 4, 1 / 4f, 1 / 64f);
		}

		this.bozkurtRandom.setSeed(this.level.getSeed());
		this.localSeed1 = this.random.nextLong();
		this.localSeed2 = this.random.nextLong();

		PopulatorOre ores = new PopulatorOre(Block.NETHERRACK);

		ores.setOreTypes(new OreType[]{
				new OreType(new BlockOreQuartz(), 20, 16, 0, 128),
				new OreType(new BlockSoulSand(), 5, 64, 0, 128),
				new OreType(new BlockGravel(), 5, 64, 0, 128),
				new OreType(new BlockLava(), 1, 16, 0, (int) this.lavaHeight),
		});
		this.populators.add(ores);

		PopulatorGroundFire groundFire = new PopulatorGroundFire();
		groundFire.setBaseAmount(1);
		groundFire.setRandomAmount(1);
		this.populators.add(groundFire);

		PopulatorLava lava = new PopulatorLava();

		lava.setBaseAmount(1);
		lava.setRandomAmount(2);

		this.populators.add(lava);

		this.populators.add(new PopulatorGlowStone());

		PopulatorOre ore = new PopulatorOre(Block.NETHERRACK);

		ore.setOreTypes(new OreType[]{
				new OreType(new BlockOreQuartz(), 40, 16, 0, 128, NETHERRACK),
				new OreType(new BlockSoulSand(), 1, 64, 30, 35, NETHERRACK),
				new OreType(new BlockLava(), 32, 1, 0, 32, NETHERRACK),
				new OreType(new BlockMagma(), 32, 16, 26, 37, NETHERRACK),
		});

		this.populators.add(ore);
	}

	@Override
	public void generateChunk(int chunkX, int chunkZ){
		int baseX = chunkX << 4;
		int baseZ = chunkZ << 4;
		this.bozkurtRandom.setSeed(chunkX * localSeed1 ^ chunkZ * localSeed2 ^ this.level.getSeed());

		BaseFullChunk chunk = level.getChunk(chunkX, chunkZ);

		for(int x = 0; x < 16; ++x){
			for(int z = 0; z < 16; ++z){
				Biome biome = EnumBiome.HELL.biome;
				chunk.setBiomeId(x, z, biome.getId());

				chunk.setBlockId(x, 0, z, Block.BEDROCK);

				for(int y = 115; y < 127; ++y){
					chunk.setBlockId(x, y, z, Block.NETHERRACK);
				}

				chunk.setBlockId(x, 127, z, Block.BEDROCK);
				for(int y = 1; y < 127; ++y){
					if(getNoise(baseX | x, y, baseZ | z) > 0){
						chunk.setBlockId(x, y, z, Block.NETHERRACK);
					}else if(y <= this.lavaHeight){
						chunk.setBlockId(x, y, z, Block.STILL_LAVA);
						chunk.setBlockLight(x, y + 1, z, 15);
					}
				}
			}
		}
		for(Populator populator : this.generationPopulators){
			populator.populate(this.level, chunkX, chunkZ, this.bozkurtRandom, chunk);
		}
	}

	@Override
	public void populateChunk(int chunkX, int chunkZ){
		BaseFullChunk chunk = level.getChunk(chunkX, chunkZ);
		this.bozkurtRandom.setSeed(0xdeadbeef ^ (chunkX << 8) ^ chunkZ ^ this.level.getSeed());
		for(Populator populator : this.populators){
			populator.populate(this.level, chunkX, chunkZ, this.bozkurtRandom, chunk);
		}

		Biome biome = EnumBiome.getBiome(chunk.getBiomeId(7, 7));
		biome.populateChunk(this.level, chunkX, chunkZ, this.bozkurtRandom);
	}

	public Vector3 getSpawn(){
		return new Vector3(0, 64, 0);
	}

	public float getNoise(int x, int y, int z){
		float val = 0f;
		for(int i = 0; i < noiseGen.length; i++){
			val += noiseGen[i].noise3D(x >> i, y, z >> i, true);
		}
		return val;
	}

}
