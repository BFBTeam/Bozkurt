package tr.bozkurt.network.protocol;

import tr.bozkurt.Server;
import tr.bozkurt.raknet.protocol.EncapsulatedPacket;
import tr.bozkurt.utils.Binary;
import tr.bozkurt.utils.BinaryStream;
import tr.bozkurt.utils.Zlib;

/**
 * Bozkurt Project
 */
public abstract class DataPacket extends BinaryStream implements Cloneable{

	public boolean isEncoded = false;
	public EncapsulatedPacket encapsulatedPacket;
	public byte reliability;
	public Integer orderIndex = null;
	public Integer orderChannel = null;
	private int channel = 0;

	public abstract byte pid();

	public abstract void decode();

	public abstract void encode();

	@Override
	public DataPacket reset(){
		super.reset();
		this.putUnsignedVarInt(this.pid());
		return this;
	}

	public int getChannel(){
		return channel;
	}

	public void setChannel(int channel){
		this.channel = channel;
	}

	public DataPacket clean(){
		this.setBuffer(null);
		this.setOffset(0);
		this.isEncoded = false;
		return this;
	}

	@Override
	public DataPacket clone(){
		try{
			return (DataPacket) super.clone();
		}catch(CloneNotSupportedException e){
			return null;
		}
	}

	public BatchPacket compress(){
		return compress(Server.getInstance().networkCompressionLevel);
	}

	public BatchPacket compress(int level){
		BatchPacket batch = new BatchPacket();
		byte[][] batchPayload = new byte[2][];
		byte[] buf = getBuffer();
		batchPayload[0] = Binary.writeUnsignedVarInt(buf.length);
		batchPayload[1] = buf;
		byte[] data = Binary.appendBytes(batchPayload);
		try{
			batch.payload = Zlib.deflate(data, level);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return batch;
	}

}
