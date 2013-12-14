package com.nishu.ld28.game.world.tile;

public class TileVoid extends Tile {

	@Override
	public float[] getTexCoords() {
		return new float[] { 0f, 0f };
	}

	@Override
	public boolean canWalk() {
		return false;
	}

	@Override
	public byte getID() {
		return 0;
	}
}
