package dev.aditya.tilegame.tile;

import java.awt.image.BufferedImage;

import dev.aditya.tilegame.gfx.Assets;

public class Dirttile  extends Tile{

	public Dirttile( int id) {
		super(Assets.dirt, id);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean isSolid()
	{
		return true;
	}

}
