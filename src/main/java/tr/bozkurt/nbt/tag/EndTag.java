package tr.bozkurt.nbt.tag;

import tr.bozkurt.nbt.stream.NBTInputStream;
import tr.bozkurt.nbt.stream.NBTOutputStream;

import java.io.IOException;

public class EndTag extends Tag{

	public EndTag(){
		super(null);
	}

	@Override
	void load(NBTInputStream dis) throws IOException{
	}

	@Override
	void write(NBTOutputStream dos) throws IOException{
	}

	@Override
	public byte getId(){
		return TAG_End;
	}

	@Override
	public String toString(){
		return "EndTag";
	}

	@Override
	public Tag copy(){
		return new EndTag();
	}

}
