package tr.bozkurt.block;

import tr.bozkurt.utils.BlockColor;

/**
 * Created on 2015/11/22 by CreeperFace.
 * Package tr.bozkurt.block in project Bozkurt.
 */
public class BlockDaylightDetector extends BlockTransparent{

	public BlockDaylightDetector(){
	}

	@Override
	public int getId(){
		return DAYLIGHT_DETECTOR;
	}

	@Override
	public String getName(){
		return "Daylight Detector";
	}

	@Override
	public double getHardness(){
		return 0.2;
	}

	@Override
	public BlockColor getColor(){
		return BlockColor.WOOD_BLOCK_COLOR;
	}

	//这个函数提供一个结构的建议，可重命名也可删
	protected boolean invertDetect(){
		return false;
	}

	//todo redstone

}
