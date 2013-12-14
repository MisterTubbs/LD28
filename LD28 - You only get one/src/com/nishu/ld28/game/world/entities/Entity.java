package com.nishu.ld28.game.world.entities;

import com.nishu.ld28.utilities.Shape;
import com.nishu.utils.Vector2f;

import static org.lwjgl.opengl.GL11.*;

public class Entity {
	
	private Vector2f pos;
	private boolean isDead;
	private int health;
	
	public Entity(float x, float y, int health){
		this(new Vector2f(x, y), health);
	}

	public Entity(Vector2f pos, int health){
		this.pos = pos;
		this.health = health;
	}

	public Vector2f getPos(){
		return pos;
	}
	
	public float getX(){
		return pos.getX();
	}
	
	public float getY(){
		return pos.getY();
	}
	
	public void setPos(float x, float y){
		pos.setPosition(x, y);
	}
	
	public void setPos(Vector2f pos){
		this.pos = pos;
	}
	
	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void update(){
		if(health <= 0) isDead = true;
	}
	
	protected void move(float x, float y){
		pos.setPosition(pos.getX() + x, pos.getY() + y);
	}
	
	public void render(){
		glBegin(GL_QUADS);
		Shape.createPlayer(pos.getX(), pos.getY());
		glEnd();
	}

	public void dispose(){
	}
}
