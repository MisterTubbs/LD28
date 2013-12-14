package com.nishu.ld28.game.world.entities;

import org.lwjgl.util.vector.Vector2f;

import com.nishu.ld28.utilities.Shape;

import static org.lwjgl.opengl.GL11.*;

public class Blood {

	public Vector2f pos;
	public boolean player;

	public Blood(float x, float y, boolean player) {
		this.pos = new Vector2f(x, y);
	}

	public void render() {
		glBegin(GL_QUADS);
		if (player) {
			Shape.createPlayerBloodSplatter(pos.x, pos.y);
		} else if (!player) {
			Shape.createBloodSplatter(pos.x, pos.y);
		}
		glEnd();
	}
}
