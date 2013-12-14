package com.nishu.ld28.game;

import org.lwjgl.input.Keyboard;

import com.nishu.ld28.Main;
import com.nishu.ld28.game.level.Level;
import com.nishu.ld28.game.level.RandomLevel;
import com.nishu.ld28.utilities.Constants;
import com.nishu.ld28.utilities.GameSound;
import com.nishu.utils.Color4f;
import com.nishu.utils.ScreenTools;
import com.nishu.utils.Text;

public class World {

	private Level level;

	public int timer = 1000, score = 0, scoreTimer = timer / 100, playerHealth;
	public static int currentMap = 1, currentZombieCount = 0;

	public World() {
		initGL();
		init();
	}

	private void initGL() {
	}

	private void init() {
		level = new RandomLevel();
		GameSound.Horde.play(true, 0.2f);
	}
	
	public void update() {
		while (Keyboard.next()) {
			if (Keyboard.getEventKeyState()) {
				if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
					Constants.paused = !Constants.paused;
				}
				if (Keyboard.isKeyDown(Keyboard.KEY_E) && !level.isPowerUsed) {
					level.isPowerUsed = true;
					for (int i = 0; i < level.zombies.size(); i++) {
						level.zombies.get(i).setDead(true);
					}
				}
			}
		}
		if (!Constants.paused) {
			if (timer % 100 == 0) {
				score++;
				scoreTimer--;
			} else if (scoreTimer <= 0) {
				playerHealth = level.player.getHealth();
				level.init();
				currentMap++;
				currentZombieCount++;
				timer = 1000;
				scoreTimer = timer / 100;
				level.player.setHealth(playerHealth);
			}
			level.update();
			timer--;
		}
	}

	public void render() {
		level.render();
		render2D();
		renderText();
	}

	private void render2D() {
		ScreenTools.render2D();
	}

	private void renderText() {
		Main.font.bind();
		if(Constants.paused){
			Text.renderString(Main.font, "Paused! Escape to resume", -0.35f, 0, 1, Color4f.WHITE);
		}
		Text.renderString(Main.font, "Time left: " + scoreTimer, -1f, 0.45f, 1,
				Color4f.WHITE);
		Text.renderString(Main.font, "Score: " + score, -1f, 0.40f, 1, Color4f.WHITE);
		Text.renderString(Main.font, "Health: " + level.player.getHealth(), -1f,
				0.35f, 1, Color4f.WHITE);
		if (level.isPowerUsed) {
			Text.renderString(Main.font, "Can't use power up!", -1f, 0.3f, 1,
					Color4f.WHITE);
		} else if (!level.isPowerUsed) {
			Text.renderString(Main.font, "Can use power up!", -1f, 0.3f, 1,
					Color4f.WHITE);
		}
	}

	public void dispose() {
		level.dispose();
	}
}
