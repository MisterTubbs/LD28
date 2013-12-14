package com.nishu.ld28.game.world.entities;

import static org.lwjgl.opengl.GL11.GL_LINES;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

import java.awt.Rectangle;

import com.nishu.ld28.game.level.Level;
import com.nishu.ld28.game.world.entities.animation.Sprite;
import com.nishu.ld28.game.world.tile.Tile;
import com.nishu.ld28.utilities.Constants;
import com.nishu.ld28.utilities.Shape;
import com.nishu.utils.Vector2f;

public class Entity {
	
	private Vector2f pos;
	private Sprite currentSprite;
	private Level level;
	private Rectangle rectangle;
	protected boolean isDead;
	protected int health;
	
	public Entity(Level level, float x, float y, Sprite currentSprite, int health){
		this(level, new Vector2f(x, y), currentSprite, health);
	}

	public Entity(Level level, Vector2f pos, Sprite currentSprite, int health){
		this.pos = pos;
		this.currentSprite = currentSprite;
		this.level = level;
		this.health = health;
		this.rectangle = new Rectangle((int) getX(), (int) getY(), Constants.TILE_SIZE, Constants.TILE_SIZE);
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

	public Rectangle getRectangle() {
		return rectangle;
	}
	
	public Level getLevel(){
		return level;
	}

	public void update(){
	}
	
	protected void move(float x, float y){
		pos.setPosition(pos.getX() + x, pos.getY() + y);
		if(canMove(pos.getX(), pos.getY())){
		}
		rectangle.setBounds((int) getX(), (int) getY(), Constants.TILE_SIZE, Constants.TILE_SIZE); 
		if(getX() < -8) pos.setX(-8);
		if(getX() > Constants.WIDTH - Constants.TILE_SIZE) pos.setX(Constants.WIDTH - Constants.TILE_SIZE);
		if(getY() < -2) pos.setY(-2);
		if(getY() > Constants.HEIGHT - Constants.TILE_SIZE) pos.setY(Constants.HEIGHT - Constants.TILE_SIZE);
	}
	
	public boolean canMove(float x, float y){
		return Tile.getTile(level.getTile((int) x / Constants.TILE_SIZE, (int) y / Constants.TILE_SIZE)).canWalk();
	}
	
	public void render(){
		glBegin(GL_QUADS);
		Shape.createPlayer(pos.getX(), pos.getY(), currentSprite);
		glEnd();
		
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
	}

	public void dispose(){
	}
}
