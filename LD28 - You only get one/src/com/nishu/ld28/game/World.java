package com.nishu.ld28.game;

import com.nishu.ld28.game.level.Level;
import com.nishu.ld28.game.level.RandomLevel;

public class World {

	private Level level;
	
	public World() {
		initGL();
		init();
	}

	private void initGL() {
	}

	private void init() {
		level = new RandomLevel();
	}

	public void update() {
		level.update();
	}

	public void render() {
		level.render();
	}

	public void dispose() {
		level.dispose();
	}
}
