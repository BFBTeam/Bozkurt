package tr.bozkurt.item;

/**
 * Created by Snake1999 on 2016/1/14.
 * Package tr.bozkurt.item in project bozkurt.
 */
public class ItemRabbitRaw extends ItemEdible{

	public ItemRabbitRaw(){
		this(0, 1);
	}

	public ItemRabbitRaw(Integer meta){
		this(meta, 1);
	}

	public ItemRabbitRaw(Integer meta, int count){
		super(RAW_RABBIT, meta, count, "Raw Rabbit");
	}

}
