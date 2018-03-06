package dev.aditya.tilegame.tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	
	// static stu
	
	public static Tile[] tiles=new Tile[256];
	public static  Tile grassTile =new GrassTile(0);
	public static Tile dirttile=new Dirttile(1);
	public static Tile rockTile=new RockTile(2);
	
	//class
	public static final int TileWidth=64, TileHeight=64;
	//define the height of the public variable 
	
	protected BufferedImage texture;
	protected final int id;
	// use to identify the tile id every tile have an seprate id
	public Tile(BufferedImage texture,int id)
	{
		this.texture=texture;
		this.id=id;
		
		tiles[id]=this;
	}
	public void tick()
	{
		
	}
	public void render(Graphics g,int x,int y)
	{
		g.drawImage(texture, x, y, TileWidth,TileHeight,null);
	}
	public boolean isSolid()
	{
		// flase menas no walk thorugh this
		return false;
	}
	public int getId()
	{
		return id;
	}
}
