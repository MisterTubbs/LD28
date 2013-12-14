package com.nishu.ld28.game.level;

import static org.lwjgl.opengl.GL11.GL_COMPILE;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glCallList;
import static org.lwjgl.opengl.GL11.glDeleteLists;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glEndList;
import static org.lwjgl.opengl.GL11.glGenLists;
import static org.lwjgl.opengl.GL11.glNewList;

import java.util.ArrayList;
import java.util.List;

import com.nishu.ld28.game.World;
import com.nishu.ld28.game.world.entities.Blood;
import com.nishu.ld28.game.world.entities.Player;
import com.nishu.ld28.game.world.entities.Zombie;
import com.nishu.ld28.game.world.tile.Tile;
import com.nishu.ld28.utilities.Constants;
import com.nishu.ld28.utilities.Shape;
import com.nishu.ld28.utilities.Spritesheet;
import com.nishu.utils.Font;
import com.nishu.utils.ScreenTools;

public class Level {

	public byte[][] tiles;
	public Player player;
	public List<Zombie> zombies;
	public List<Blood> bloodSplatter;
	public Font font;
	public boolean isPowerUsed = false;

	protected int mapHandle;

	public Level() {
		initGL();
		init();
	}

	private void initGL() {
		mapHandle = glGenLists(1);
	}

	public void init() {
		isPowerUsed = false;
		glNewList(mapHandle, GL_COMPILE);
		glBegin(GL_QUADS);
		createWorld();
		glEnd();
		glEndList();

		bloodSplatter = new ArrayList<Blood>();
		player = new Player(this, Constants.WIDTH / 2, Constants.HEIGHT / 2);
		zombies = new ArrayList<Zombie>();
		for (int i = 0; i <= World.currentZombieCount; i++) {
			zombies.add(new Zombie(this, Constants.rand
					.nextInt(Constants.WIDTH), Constants.rand
					.nextInt(Constants.HEIGHT)));
		}
	}

	public void createWorld() {
	}

	public void update() {
		if (!player.isDead()) {
			player.update();
		}
		for (int i = 0; i < zombies.size(); i++) {
			zombies.get(i).update(zombies, player);
			if(zombies.get(i).isDead()) {
				bloodSplatter.add(new Blood(zombies.get(i).getX(), zombies.get(i).getY(), false));
				zombies.remove(i);
			}
		}
	}

	public void render() {
		Spritesheet.tiles.bind();
		ScreenTools.renderOrtho(0, Constants.WIDTH, 0, Constants.HEIGHT);
		glCallList(mapHandle);
		for(int i = 0; i < bloodSplatter.size(); i++){
			glBegin(GL_QUADS);
			Shape.createBloodSplatter(bloodSplatter.get(i).pos.x, bloodSplatter.get(i).pos.y);
			glEnd();
		}
		if (!player.isDead()) {
			player.render();
		}
		for (int i = 0; i < zombies.size(); i++) {
			zombies.get(i).render();
		}
	}

	public void rebuild() {
	}

	public byte getTile(int x, int y) {
		if (x < 0 || x > Constants.WIDTH || y < 0 || y > Constants.HEIGHT)
			return Tile.Void.getID();
		return tiles[x][y];
	}

	public void setTile(int x, int y, byte id) {
		if (x > 0 || x > Constants.WIDTH || y > 0 || y < Constants.HEIGHT)
			return;
		tiles[x][y] = id;
		rebuild();
	}
	
	public boolean isPowerUsed(){
		return isPowerUsed;
	}

	public void dispose() {
		glDeleteLists(mapHandle, 1);
	}
}
