package com.nishu.ld28.game.world.tile;

public abstract class Tile {
	
	/*
	 * 0 - void
	 * 1 - grass
	 * 2 - stone
	 * 3 - seed 1
	 * 4 - seed 2
	 * 5 - flower
	 */

	public static Tile Void = new TileVoid();
	public static Tile Grass = new TileGrass();
	public static Tile Stone = new TileStone();
	
	public static Tile Seed1 = new TileSeed1();
	public static Tile Seed2 = new TileSeed2();
	public static Tile Flower = new TileFlower();

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
		case 3:
			return Tile.Seed1;
		case 4:
			return Tile.Seed2;
		case 5:
			return Tile.Flower;
		default:
			return Tile.Void;
		}
	}
}
