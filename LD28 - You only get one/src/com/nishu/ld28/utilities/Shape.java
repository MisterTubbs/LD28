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
	
	public static void createBloodSplatter(float x, float y){
		glTexCoord2f(Sprite.zblood_splatter.x, Sprite.zblood_splatter.y);
		glVertex2f(x, y);
		glTexCoord2f(Sprite.zblood_splatter.x + Spritesheet.tiles.uniformSize(), Sprite.zblood_splatter.y);		
		glVertex2f(x + Constants.SPLATTER_SIZE, y);
		glTexCoord2f(Sprite.zblood_splatter.x + Spritesheet.tiles.uniformSize(), Sprite.zblood_splatter.y + Spritesheet.tiles.uniformSize());		
		glVertex2f(x + Constants.SPLATTER_SIZE, y + Constants.SPLATTER_SIZE);
		glTexCoord2f(Sprite.zblood_splatter.x, Sprite.zblood_splatter.y + Spritesheet.tiles.uniformSize());		
		glVertex2f(x, y + Constants.SPLATTER_SIZE);
	}
	
	public static void createPlayerBloodSplatter(float x, float y){
		glTexCoord2f(Sprite.pblood_splatter.x, Sprite.pblood_splatter.y);
		glVertex2f(x, y);
		glTexCoord2f(Sprite.pblood_splatter.x + Spritesheet.tiles.uniformSize(), Sprite.pblood_splatter.y);		
		glVertex2f(x + Constants.SPLATTER_SIZE, y);
		glTexCoord2f(Sprite.pblood_splatter.x + Spritesheet.tiles.uniformSize(), Sprite.pblood_splatter.y + Spritesheet.tiles.uniformSize());		
		glVertex2f(x + Constants.SPLATTER_SIZE, y + Constants.SPLATTER_SIZE);
		glTexCoord2f(Sprite.pblood_splatter.x, Sprite.pblood_splatter.y + Spritesheet.tiles.uniformSize());		
		glVertex2f(x, y + Constants.SPLATTER_SIZE);
	}
}
