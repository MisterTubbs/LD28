package com.nishu.ld28.utilities;

import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex2f;

import com.nishu.ld28.game.world.entities.animation.Sprite;

public class Shape {
	
	public static void createTile(int x, int y, float[] texCoords){
		glTexCoord2f(texCoords[0], texCoords[1]);
		glVertex2f(x, y);
		glTexCoord2f(texCoords[0] + Spritesheet.tiles.uniformSize(), texCoords[1]);
		glVertex2f(x + Constants.TILE_SIZE, y);
		glTexCoord2f(texCoords[0] + Spritesheet.tiles.uniformSize(), texCoords[1] + Spritesheet.tiles.uniformSize());
		glVertex2f(x + Constants.TILE_SIZE, y + Constants.TILE_SIZE);
		glTexCoord2f(texCoords[0], texCoords[1] + Spritesheet.tiles.uniformSize());
		glVertex2f(x, y + Constants.TILE_SIZE);
	}
	
	public static void createPlayer(float x, float y, Sprite s){
		glTexCoord2f(s.x, s.y);
		glVertex2f(x, y);
		glTexCoord2f(s.x + Spritesheet.tiles.uniformSize(), s.y);		
		glVertex2f(x + Constants.TILE_SIZE, y);
		glTexCoord2f(s.x + Spritesheet.tiles.uniformSize(), s.y + Spritesheet.tiles.uniformSize());		
		glVertex2f(x + Constants.TILE_SIZE, y + Constants.TILE_SIZE);
		glTexCoord2f(s.x, s.y + Spritesheet.tiles.uniformSize());		
		glVertex2f(x, y + Constants.TILE_SIZE);
	}
}
