package tr.bozkurt.block;

import tr.bozkurt.Player;
import tr.bozkurt.event.block.DoorToggleEvent;
import tr.bozkurt.item.Item;
import tr.bozkurt.item.ItemTool;
import tr.bozkurt.level.Level;
import tr.bozkurt.level.Sound;
import tr.bozkurt.math.BlockFace;
import tr.bozkurt.utils.BlockColor;

/**
 * Created on 2015/11/23 by xtypr.
 * Package tr.bozkurt.block in project Bozkurt.
 */
public class BlockFenceGate extends BlockTransparentMeta{

	private static final double[] offMinX = new double[2];
	private static final double[] offMinZ = new double[2];
	private static final double[] offMaxX = new double[2];
	private static final double[] offMaxZ = new double[2];

	static{
		offMinX[0] = 0;
		offMinZ[0] = 0.375;
		offMaxX[0] = 1;
		offMaxZ[0] = 0.625;

		offMinX[1] = 0.375;
		offMinZ[1] = 0;
		offMaxX[1] = 0.625;
		offMaxZ[1] = 1;
	}

	public BlockFenceGate(){
		this(0);
	}

	public BlockFenceGate(int meta){
		super(meta);
	}

	@Override
	public int getId(){
		return FENCE_GATE_OAK;
	}

	@Override
	public String getName(){
		return "Oak Fence Gate";
	}

	@Override
	public double getHardness(){
		return 2;
	}

	@Override
	public double getResistance(){
		return 15;
	}

	@Override
	public boolean canBeActivated(){
		return true;
	}

	@Override
	public int getToolType(){
		return ItemTool.TYPE_AXE;
	}

	private int getOffsetIndex(){
		switch(this.getDamage() & 0x03){
			case 0:
			case 2:
				return 0;
			default:
				return 1;
		}
	}

	@Override
	public double getMinX(){
		return this.x + offMinX[getOffsetIndex()];
	}

	@Override
	public double getMinZ(){
		return this.z + offMinZ[getOffsetIndex()];
	}

	@Override
	public double getMaxX(){
		return this.x + offMaxX[getOffsetIndex()];
	}

	@Override
	public double getMaxZ(){
		return this.z + offMaxZ[getOffsetIndex()];
	}

	@Override
	public boolean place(Item item, Block block, Block target, BlockFace face, double fx, double fy, double fz, Player player){
		this.setDamage(player != null ? player.getDirection().getHorizontalIndex() : 0);
		this.getLevel().setBlock(block, this, true, true);

		return true;
	}

	@Override
	public boolean onActivate(Item item, Player player){
		if(player == null){
			return false;
		}

		if(!this.toggle(player)){
			return false;
		}

		this.level.addSound(this, isOpen() ? Sound.RANDOM_DOOR_OPEN : Sound.RANDOM_DOOR_CLOSE);
		return true;
	}

	@Override
	public BlockColor getColor(){
		return BlockColor.WOOD_BLOCK_COLOR;
	}

	public boolean toggle(Player player){
		DoorToggleEvent event = new DoorToggleEvent(this, player);
		this.getLevel().getServer().getPluginManager().callEvent(event);

		if(event.isCancelled()){
			return false;
		}

		player = event.getPlayer();

		int direction;

		if(player != null){
			double yaw = player.yaw;
			double rotation = (yaw - 90) % 360;

			if(rotation < 0){
				rotation += 360.0;
			}

			int originDirection = this.getDamage() & 0x01;

			if(originDirection == 0){
				if(rotation >= 0 && rotation < 180){
					direction = 2;
				}else{
					direction = 0;
				}
			}else{
				if(rotation >= 90 && rotation < 270){
					direction = 3;
				}else{
					direction = 1;
				}
			}
		}else{
			int originDirection = this.getDamage() & 0x01;

			if(originDirection == 0){
				direction = 0;
			}else{
				direction = 1;
			}
		}

		this.setDamage(direction | ((~this.getDamage()) & 0x04));
		this.level.setBlock(this, this, false, false);
		return true;
	}

	public boolean isOpen(){
		return (this.getDamage() & 0x04) > 0;
	}

	@Override
	public int onUpdate(int type){
		if(type == Level.BLOCK_UPDATE_REDSTONE){
			if((!isOpen() && this.level.isBlockPowered(this.getLocation())) || (isOpen() && !this.level.isBlockPoweredthis.getLocation())){
				this.toggle(null);
				return type;
			}
		}

		return 0;
	}

	@Override
	public Item toItem(){
		return Item.get(Item.FENCE_GATE, 0, 1);
	}

}