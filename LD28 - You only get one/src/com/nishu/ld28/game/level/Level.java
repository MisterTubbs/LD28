package com.nishu.ld28.game.level;

import com.nishu.ld28.game.world.entities.Player;
import com.nishu.ld28.utilities.Constants;

import static org.lwjgl.opengl.GL11.*;

public class Level {
	
	public byte[][] tiles;
	public Player player;
	
	private float ox, oy;
	private float dx, dy;
	
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
		ox = player.getX();
		oy = player.getY();
	}
	
	public void createWorld() {
	}

	public void update(){
		player.update();
		dx = player.getX() - ox;
		dy = player.getY() - oy;
		System.out.println(Constants.WIDTH + dx);
		if(player.getX() > (Constants.WIDTH) + dx) {
		}
		if(player.getX() < (0 + Constants.TILE_SIZE) - dx) {
		}
	}

	public void render(){
		glTranslatef(dx, dy, 0);
		glCallList(mapHandle);
		player.render();
	}

	public void dispose(){
	}
}
