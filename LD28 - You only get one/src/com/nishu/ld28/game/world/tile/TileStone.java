package com.nishu.ld28.game.world.tile;

import com.nishu.ld28.utilities.Spritesheet;

public class TileStone extends Tile{

	@Override
	public float[] getTexCoords() {
		return new float[]{0 + (2 * Spritesheet.tiles.uniformSize()), 0};
	}
	
	@Override
	public boolean canWalk() {
		return false;
	}

	@Override
	public byte getID() {
		return 2;
	}
}
