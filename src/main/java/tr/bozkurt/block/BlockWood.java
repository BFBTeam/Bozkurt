package tr.bozkurt.block;

import tr.bozkurt.Player;
import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemBlock;
import tr.bozkurt.item.ItemTool;
import tr.bozkurt.math.BlockFace;
import tr.bozkurt.utils.BlockColor;

/**
 * Bozkurt Project
 */
public class BlockWood extends BlockSolidMeta{

	public static final int OAK = 0;
	public static final int SPRUCE = 1;
	public static final int BIRCH = 2;
	public static final int JUNGLE = 3;


	public BlockWood(){
		this(0);
	}

	public BlockWood(int meta){
		super(meta);
	}

	@Override
	public int getId(){
		return WOOD;
	}

	@Override
	public double getHardness(){
		return 2;
	}

	@Override
	public double getResistance(){
		return 10;
	}

	@Override
	public String getName(){
		String[] names = new String[]{
				"Oak Wood",
				"Spruce Wood",
				"Birch Wood",
				"Jungle Wood"
		};

		return names[this.getDamage() & 0x03];
	}

	@Override
	public int getBurnChance(){
		return 5;
	}

	@Override
	public int getBurnAbility(){
		return 10;
	}

	@Override
	public boolean place(Item item, Block block, Block target, BlockFace face, double fx, double fy, double fz){
		return this.place(item, block, target, face, fx, fy, fz, null);
	}

	@Override
	public boolean place(Item item, Block block, Block target, BlockFace face, double fx, double fy, double fz, Player player){
		short[] faces = new short[]{
				0,
				0,
				0b1000,
				0b1000,
				0b0100,
				0b0100
		};

		this.setDamage(((this.getDamage() & 0x03) | faces[face.getIndex()]));
		this.getLevel().setBlock(block, this, true, true);

		return true;
	}

	@Override
	public Item toItem(){
		return new ItemBlock(this, this.getDamage() & 0x03);
	}

	@Override
	public int getToolType(){
		return ItemTool.TYPE_AXE;
	}

	@Override
	public BlockColor getColor(){
		return BlockColor.WOOD_BLOCK_COLOR;
	}

}
