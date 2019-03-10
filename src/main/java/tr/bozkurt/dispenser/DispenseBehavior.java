package tr.bozkurt.dispenser;

import tr.bozkurt.block.BlockDispenser;
import tr.bozkurt.item.Item;

/**
 * @author CreeperFace
 */
public interface DispenseBehavior{

	void dispense(BlockDispenser block, Item item);

}
