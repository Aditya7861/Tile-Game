package dev.aditya.tilegame.tile;

import java.awt.image.BufferedImage;

import dev.aditya.tilegame.gfx.Assets;

public class GrassTile extends Tile {

	public GrassTile( int id) {
		super(Assets.grass, id);
	}
	public boolean isSolid()
	{
		return true;
	}

}
