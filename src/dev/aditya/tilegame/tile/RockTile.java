package dev.aditya.tilegame.tile;

import dev.aditya.tilegame.gfx.Assets;

public class RockTile  extends Tile{

	public RockTile( int id) {
		super(Assets.stone, id);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public boolean isSolid()
	{
		return true;
	}

}