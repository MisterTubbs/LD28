package com.nishu.ld28.game.world.entities.animation;

import com.nishu.ld28.utilities.Spritesheet;

public class Sprite {
	
	public float x, y;
	
	public static Sprite player_forward = new Sprite(1 * Spritesheet.tiles.uniformSize(), 1 - Spritesheet.tiles.uniformSize());
	public static Sprite player_backward = new Sprite(0, 1 - Spritesheet.tiles.uniformSize());
	public static Sprite player_left = new Sprite(2 * Spritesheet.tiles.uniformSize(), 1 - Spritesheet.tiles.uniformSize());
	public static Sprite player_right = new Sprite(3 * Spritesheet.tiles.uniformSize(), 1 - Spritesheet.tiles.uniformSize());
	
	public static Sprite zombie_forward = new Sprite(1 * Spritesheet.tiles.uniformSize(), 1 - (2 * Spritesheet.tiles.uniformSize()));
	public static Sprite zombie_backward = new Sprite(0, 1 - (2 * Spritesheet.tiles.uniformSize()));
	public static Sprite zombie_left = new Sprite(2 * Spritesheet.tiles.uniformSize(), 1 - (2 * Spritesheet.tiles.uniformSize()));
	public static Sprite zombie_right = new Sprite(3 * Spritesheet.tiles.uniformSize(), 1 - (2 * Spritesheet.tiles.uniformSize()));
	
	//effects
	public static Sprite zblood_splatter = new Sprite(0, 0 + Spritesheet.tiles.uniformSize());
	public static Sprite pblood_splatter = new Sprite(0 + Spritesheet.tiles.uniformSize(), 0 + Spritesheet.tiles.uniformSize());
	
	public Sprite(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}

}
