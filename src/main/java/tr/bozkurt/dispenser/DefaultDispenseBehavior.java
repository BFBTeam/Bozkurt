package tr.bozkurt.dispenser;

import tr.bozkurt.block.BlockDispenser;
import tr.bozkurt.item.Item;
import tr.bozkurt.math.BlockFace;

/**
 * @author CreeperFace
 */
public class DefaultDispenseBehavior implements DispenseBehavior{

	@Override
	public void dispense(BlockDispenser block, Item stack){

	}

	private int getParticleMetadataForFace(BlockFace face){
		return face.getXOffset() + 1 + (face.getZOffset() + 1) * 3;
	}

}
