package tr.bozkurt.inventory;

import tr.bozkurt.Player;
import tr.bozkurt.item.Item;
import tr.bozkurt.math.BozkurtMath;
import tr.bozkurt.math.Vector3;
import tr.bozkurt.network.protocol.ContainerClosePacket;
import tr.bozkurt.network.protocol.ContainerOpenPacket;

import java.util.Map;

/**
 * Bozkurt Project
 */
public abstract class ContainerInventory extends BaseInventory{

	public ContainerInventory(InventoryHolder holder, InventoryType type){
		super(holder, type);
	}

	public ContainerInventory(InventoryHolder holder, InventoryType type, Map<Integer, Item> items){
		super(holder, type, items);
	}

	public ContainerInventory(InventoryHolder holder, InventoryType type, Map<Integer, Item> items, Integer overrideSize){
		super(holder, type, items, overrideSize);
	}

	public ContainerInventory(InventoryHolder holder, InventoryType type, Map<Integer, Item> items, Integer overrideSize, String overrideTitle){
		super(holder, type, items, overrideSize, overrideTitle);
	}

	public static int calculateRedstone(Inventory inv){
		if(inv == null){
			return 0;
		}else{
			int itemCount = 0;
			float averageCount = 0;

			for(int slot = 0; slot < inv.getSize(); ++slot){
				Item item = inv.getItem(slot);

				if(item.getId() != 0){
					averageCount += (float) item.getCount() / (float) Math.min(inv.getMaxStackSize(), item.getMaxStackSize());
					++itemCount;
				}
			}

			averageCount = averageCount / (float) inv.getSize();
			return BozkurtMath.floorFloat(averageCount * 14) + (itemCount > 0 ? 1 : 0);
		}
	}

	@Override
	public void onOpen(Player who){
		super.onOpen(who);
		ContainerOpenPacket pk = new ContainerOpenPacket();
		pk.windowId = who.getWindowId(this);
		pk.type = this.getType().getNetworkType();
		InventoryHolder holder = this.getHolder();
		if(holder instanceof Vector3){
			pk.x = (int) ((Vector3) holder).getX();
			pk.y = (int) ((Vector3) holder).getY();
			pk.z = (int) ((Vector3) holder).getZ();
		}else{
			pk.x = pk.y = pk.z = 0;
		}

		who.dataPacket(pk);

		this.sendContents(who);
	}

	@Override
	public void onClose(Player who){
		ContainerClosePacket pk = new ContainerClosePacket();
		pk.windowId = who.getWindowId(this);
		who.dataPacket(pk);
		super.onClose(who);
	}

}
