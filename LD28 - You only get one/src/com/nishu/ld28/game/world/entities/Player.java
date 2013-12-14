package com.nishu.ld28.game.world.entities;

import org.lwjgl.input.Keyboard;

import com.nishu.ld28.utilities.Constants;

public class Player extends Entity{
	
	public Player(float x, float y) {
		super(x, y, 100);
	}
	
	public void update(){
		if(Keyboard.isKeyDown(Keyboard.KEY_W)){
			move(0, Constants.PLAYER_SPEED);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_S)){
			move(0, -Constants.PLAYER_SPEED);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_D)){
			move(Constants.PLAYER_SPEED, 0);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_A)){
			move(-Constants.PLAYER_SPEED, 0);
		}
	}
}
