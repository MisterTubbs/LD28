package com.nishu.ld28.game.world.tile;

public abstract class Tile {
	
	/*
	 * 0 - void
	 * 1 - grass
	 * 2 - stone
	 */

	public static Tile Void = new TileVoid();
	public static Tile Grass = new TileGrass();
	public static Tile Stone = new TileStone();

	public abstract float[] getTexCoords();

	public abstract boolean canWalk();

	public abstract byte getID();

	public static Tile getTile(byte id) {
		switch (id) {
		case 0:
			return Tile.Void;
		case 1:
			return Tile.Grass;
		case 2:
			return Tile.Stone;
		default:
			return Tile.Void;
		}
	}
}
