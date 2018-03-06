package dev.aditya.tilegame.state;


import java.awt.Graphics;

import dev.aditya.tilegame.Game;

public abstract class State {
	
	private static State currentstate=null;
	public static void setStat(State state)
	{
		currentstate=state;
	}
	public static State getState()
	{
		return currentstate;
	}
	//class
	protected Game game;
	public State(Game game)
	{
		this.game=game;
	}
	public abstract void tick();
	
	public abstract void render(Graphics g);

}
