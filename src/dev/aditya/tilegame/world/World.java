package dev.aditya.tilegame.world;

import java.awt.Graphics;

import dev.aditya.tilegame.tile.Tile;

public class World {
	private int width,height;
	private int[][] tiles;
	
	public World(String path)
	{
		loadworld(path);
	}
	public void tick(){
		
		
		
		
	}
	public void render(Graphics g)
	{
		for(int y=0;y<height;y++){
			for(int x=0;x<width;x++)
			{
				getTile(x,y).render(g, x*Tile.TileWidth, y*Tile.TileHeight);
			}
		}
	}
	public Tile getTile(int x,int y)
	{
		Tile t=Tile.tiles[tiles[x][y]];
				if(t==null)
					return Tile.dirttile;
				return t;
	}
	private void loadworld(String path)
	{
		width=5;
		height=5;
		tiles=new int[width][height];
		
		for(int x=0;x<width;x++)
		{
			for(int y=0;y<height;y++)
			{
				tiles[x][y]=0;
			}
		}
	}
}
