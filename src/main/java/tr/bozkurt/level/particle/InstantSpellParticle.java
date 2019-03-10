package tr.bozkurt.level.particle;

import tr.bozkurt.math.Vector3;
import tr.bozkurt.utils.BlockColor;

/**
 * Created on 2016/1/4 by xtypr.
 * Package tr.bozkurt.level.particle in project Bozkurt.
 */
public class InstantSpellParticle extends SpellParticle{

	protected int data;

	public InstantSpellParticle(Vector3 pos){
		this(pos, 0);
	}

	public InstantSpellParticle(Vector3 pos, int data){
		super(pos, data);
	}

	public InstantSpellParticle(Vector3 pos, BlockColor blockColor){
		//alpha is ignored
		this(pos, blockColor.getRed(), blockColor.getGreen(), blockColor.getBlue());
	}

	public InstantSpellParticle(Vector3 pos, int r, int g, int b){
		//this 0x01 is the only difference between instant spell and non-instant one
		super(pos, r, g, b, 0x01);
	}

}
