package com.nishu.ld28.game.level;

import com.nishu.ld28.game.world.tile.Tile;
import com.nishu.ld28.utilities.Constants;
import com.nishu.ld28.utilities.Shape;
import com.nishu.ld28.utilities.Spritesheet;

public class TestLevel extends Level{
	
	public void createWorld(){
		Spritesheet.tiles.bind();
		tiles = new byte[Constants.WIDTH / Constants.TILE_SIZE][Constants.HEIGHT / Constants.TILE_SIZE + 1];
		for(int x = 0; x < Constants.WIDTH / Constants.TILE_SIZE; x++){
			for(int y = 0; y < Constants.HEIGHT / Constants.TILE_SIZE + 1; y++){
				tiles[x][y] = Tile.Grass.getID();
				if(Constants.rand.nextInt(10) == 0) tiles[x][y] = Tile.Stone.getID();
				Shape.createTile(x * Constants.TILE_SIZE, y * Constants.TILE_SIZE, Tile.getTile(tiles[x][y]).getTexCoords());
			}
		}
	}
}

