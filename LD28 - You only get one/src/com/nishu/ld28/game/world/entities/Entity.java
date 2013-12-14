package com.nishu.ld28.game.world.entities;

import static org.lwjgl.opengl.GL11.GL_LINES;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

import com.nishu.ld28.game.level.Level;
import com.nishu.ld28.game.world.entities.animation.Sprite;
import com.nishu.ld28.utilities.Constants;
import com.nishu.ld28.utilities.Shape;
import com.nishu.utils.Vector2f;

public class Entity {
	
	private Vector2f pos;
	private Sprite currentSprite;
	private boolean isDead;
	private int health;
	
	public Entity(float x, float y, Sprite currentSprite, int health){
		this(new Vector2f(x, y), currentSprite, health);
	}

	public Entity(Vector2f pos, Sprite currentSprite, int health){
		this.pos = pos;
		this.currentSprite = currentSprite;
		this.health = health;
	}
	
	public Sprite getSprite(){
		return currentSprite;
	}
	
	public void setSprite(Sprite sprite){
		this.currentSprite = sprite;
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

	public void update(Level level){
		if(health <= 0) isDead = true;
	}
	
	protected void move(float x, float y){
		pos.setPosition(pos.getX() + x, pos.getY() + y);
	}
	
	public void render(){
		if(Constants.debug){
			glBegin(GL_LINES);
			glVertex2f(getX(), getY());
			glVertex2f(getX() + Constants.TILE_SIZE, getY());

			glVertex2f(getX() + Constants.TILE_SIZE, getY());
			glVertex2f(getX() + Constants.TILE_SIZE, getY() + Constants.TILE_SIZE);
			
			glVertex2f(getX() + Constants.TILE_SIZE, getY() + Constants.TILE_SIZE);
			glVertex2f(getX(), getY() + Constants.TILE_SIZE);

			glVertex2f(getX(), getY() + Constants.TILE_SIZE);
			glVertex2f(getX(), getY());
			glEnd();
		}
		glBegin(GL_QUADS);
		Shape.createPlayer(pos.getX(), pos.getY(), currentSprite);
		glEnd();
	}

	public void dispose(){
	}
}
