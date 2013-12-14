package com.nishu.ld28.game.level;

import static org.lwjgl.opengl.GL11.GL_COMPILE;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glEndList;
import static org.lwjgl.opengl.GL11.glNewList;

import com.nishu.ld28.game.world.tile.Tile;
import com.nishu.ld28.utilities.Constants;
import com.nishu.ld28.utilities.Shape;
import com.nishu.ld28.utilities.Spritesheet;

public class RandomLevel extends Level{
	
	public void rebuild(){
		glNewList(mapHandle, GL_COMPILE);
		glBegin(GL_QUADS);
		for(int x = 0; x < Constants.WIDTH / Constants.TILE_SIZE + 1; x++){
			for(int y = 0; y < Constants.HEIGHT / Constants.TILE_SIZE + 1; y++){
				Shape.createTile(x * Constants.TILE_SIZE, y * Constants.TILE_SIZE, Tile.getTile(tiles[x][y]).getTexCoords());
			}
		}
		glEnd();
		glEndList();
	}
	
	public void createWorld(){
		Spritesheet.tiles.bind();
		tiles = new byte[Constants.WIDTH / Constants.TILE_SIZE + 1][Constants.HEIGHT / Constants.TILE_SIZE + 1];
		for(int x = 0; x < Constants.WIDTH / Constants.TILE_SIZE + 1; x++){
			for(int y = 0; y < Constants.HEIGHT / Constants.TILE_SIZE + 1; y++){
				tiles[x][y] = Tile.Grass.getID();
				if(Constants.rand.nextInt(10) == 0) tiles[x][y] = Tile.Stone.getID();
				if(Constants.rand.nextInt(10) == 0){
					if(Constants.rand.nextInt(3) == 0) tiles[x][y] = Tile.Seed1.getID();
					if(Constants.rand.nextInt(3) == 1) tiles[x][y] = Tile.Seed2.getID();
					if(Constants.rand.nextInt(3) == 2) tiles[x][y] = Tile.Flower.getID();
				}
				Shape.createTile(x * Constants.TILE_SIZE, y * Constants.TILE_SIZE, Tile.getTile(tiles[x][y]).getTexCoords());
			}
		}
	}
}

