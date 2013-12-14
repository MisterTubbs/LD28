package com.nishu.ld28.game.world.entities;

import org.lwjgl.input.Keyboard;

import com.nishu.ld28.Main;
import com.nishu.ld28.game.level.Level;
import com.nishu.ld28.game.world.entities.animation.Sprite;
import com.nishu.ld28.utilities.Constants;

public class Player extends Entity{
	
	public Player(Level level, float x, float y) {
		super(level, x, y, Sprite.player_forward, 500);
	}
	
	public void update(){
		if(health <= 0) {
			isDead = true;
			Main.state = Main.MENUSTATE.DEATH;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_W)){
			move(0, Constants.PLAYER_SPEED);
			setSprite(Sprite.player_forward);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_S)){
			move(0, -Constants.PLAYER_SPEED);
			setSprite(Sprite.player_backward);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_D)){
			move(Constants.PLAYER_SPEED, 0);
			setSprite(Sprite.player_left);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_A)){
			move(-Constants.PLAYER_SPEED, 0);
			setSprite(Sprite.player_right);
		}
	}
}
