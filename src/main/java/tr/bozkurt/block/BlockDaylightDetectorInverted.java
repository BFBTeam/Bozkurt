package tr.bozkurt.block;

/**
 * Created on 2015/11/22 by CreeperFace.
 * Package tr.bozkurt.block in project Bozkurt.
 */
public class BlockDaylightDetectorInverted extends BlockDaylightDetector{

	public BlockDaylightDetectorInverted(){
	}

	@Override
	public int getId(){
		return DAYLIGHT_DETECTOR_INVERTED;
	}

	@Override
	public String getName(){
		return "Daylight Detector Inverted";
	}

	protected boolean invertDetect(){
		return true;
	}

}
