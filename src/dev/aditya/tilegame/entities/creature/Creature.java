package dev.aditya.tilegame.entities.creature;

import dev.aditya.tilegame.entities.Entity;

public abstract class Creature extends Entity {

	protected int health;
	public Creature(float x, float y) {
		super(x, y);
		health=20;
	}
	

}
