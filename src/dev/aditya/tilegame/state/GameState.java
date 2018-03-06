package dev.aditya.tilegame.state;

import java.awt.Graphics;

import dev.aditya.tilegame.Game;
import dev.aditya.tilegame.entities.creature.Player;
import dev.aditya.tilegame.gfx.Assets;
import dev.aditya.tilegame.tile.Tile;
import dev.aditya.tilegame.world.World;

public class GameState extends State{
	
	private World world;
	
	private Player player;
	public GameState(Game game)
	{
		super(game);
		player=new Player(game, 200,200);
	}
	@Override
	public void tick() {
		world.tick();
		player.tick();
		
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		player.render(g);
		
	}
	

}
