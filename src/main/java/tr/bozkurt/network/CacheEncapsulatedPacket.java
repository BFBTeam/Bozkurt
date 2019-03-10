package tr.bozkurt.network;

import tr.bozkurt.raknet.protocol.EncapsulatedPacket;

/**
 * Bozkurt Project
 */
public class CacheEncapsulatedPacket extends EncapsulatedPacket{

	public byte[] internalData = null;

	@Override
	public byte[] toBinary(){
		return this.toBinary(false);
	}

	@Override
	public byte[] toBinary(boolean internal){
		if(this.internalData == null){
			this.internalData = super.toBinary(internal);
		}
		return this.internalData;
	}

}