package com.nishu.ld28.game.level;

import com.nishu.ld28.game.world.entities.Player;
import com.nishu.ld28.utilities.Constants;

import static org.lwjgl.opengl.GL11.*;

public class Level {
	
	public byte[][] tiles;
	public Player player;
	
	private int mapHandle;
	
	public Level(){
		initGL();
		init();
	}
	
	private void initGL(){
		mapHandle = glGenLists(1);
	}

	public void init(){
		glNewList(mapHandle, GL_COMPILE);
		glBegin(GL_QUADS);
		createWorld();
		glEnd();
		glEndList();
		
		player = new Player(Constants.WIDTH / 2, Constants.HEIGHT / 2);
	}
	
	public void createWorld() {
	}

	public void update(){
		player.update(this);
	}

	public void render(){
		glCallList(mapHandle);
		player.render();
	}

	public void dispose(){
		glDeleteLists(mapHandle, 1);
	}
}
