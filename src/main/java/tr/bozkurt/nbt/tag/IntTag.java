package tr.bozkurt.nbt.tag;

import tr.bozkurt.nbt.stream.NBTInputStream;
import tr.bozkurt.nbt.stream.NBTOutputStream;

import java.io.IOException;

public class IntTag extends NumberTag<Integer>{

	public int data;

	public IntTag(String name){
		super(name);
	}

	public IntTag(String name, int data){
		super(name);
		this.data = data;
	}

	@Override
	public Integer getData(){
		return data;
	}

	@Override
	public void setData(Integer data){
		this.data = data == null ? 0 : data;
	}

	@Override
	void write(NBTOutputStream dos) throws IOException{
		dos.writeInt(data);
	}

	@Override
	void load(NBTInputStream dis) throws IOException{
		data = dis.readInt();
	}

	@Override
	public byte getId(){
		return TAG_Int;
	}

	@Override
	public String toString(){
		return "IntTag " + this.getName() + "(data: " + data + ")";
	}

	@Override
	public Tag copy(){
		return new IntTag(getName(), data);
	}

	@Override
	public boolean equals(Object obj){
		if(super.equals(obj)){
			IntTag o = (IntTag) obj;
			return data == o.data;
		}
		return false;
	}

}
