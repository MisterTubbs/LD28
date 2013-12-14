package com.nishu.ld28;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex2f;
import kuusisto.tinysound.TinySound;

import org.lwjgl.input.Keyboard;

import com.nishu.ld28.game.World;
import com.nishu.ld28.utilities.Constants;
import com.nishu.ld28.utilities.GameSound;
import com.nishu.utils.Color4f;
import com.nishu.utils.Font;
import com.nishu.utils.GameLoop;
import com.nishu.utils.Screen;
import com.nishu.utils.ScreenTools;
import com.nishu.utils.Text;
import com.nishu.utils.Texture;
import com.nishu.utils.Window;

public class Main extends Screen {

	public static enum MENUSTATE {
		INTRO, MAIN, ABOUT, GAME, DEATH
	}

	public static MENUSTATE state = MENUSTATE.INTRO;

	private GameLoop loop;
	private World game;
	private Texture splash;
	public static Font font;

	private int splashTimer = 0;
	private float cx = -0.05f, cy = -0.1f;

	public Main() {
		loop = new GameLoop();
		loop.setScreen(this);
		loop.start(60);
	}

	@Override
	public void init() {
		TinySound.init();
		splash = Texture.loadTexture("textures/splash.png");
	}

	@Override
	public void initGL() {
		ScreenTools.renderOrtho(0, Constants.WIDTH, 0, Constants.HEIGHT);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
	}

	@Override
	public void render() {
		ScreenTools.clearScreen(false, Color4f.BLACK);
		splashTimer++;
		if (splashTimer % 100 == 0 && state == MENUSTATE.INTRO) {
			state = MENUSTATE.MAIN;
			splash.delete();
			font = new Font();
			font.loadFont("Menu Font", "fonts/pixel.png");
		}
		switch (state) {
		case INTRO:
			renderIntro();
			break;
		case GAME:
			game.render();
			break;
		case ABOUT:
			renderAbout();
			break;
		case DEATH:
			renderDeath();
			break;
		case MAIN:
			renderMenu();
			break;
		default:
			break;
		}
	}

	private void renderIntro() {
		splash.bind();
		glBegin(GL_QUADS);
		glTexCoord2f(0, 1);
		glVertex2f(0, 0);
		glTexCoord2f(1, 1);
		glVertex2f(Constants.WIDTH, 0);
		glTexCoord2f(1, 0);
		glVertex2f(Constants.WIDTH, Constants.HEIGHT);
		glTexCoord2f(0, 0);
		glVertex2f(0, Constants.HEIGHT);
		glEnd();
	}

	private void renderMenu() {
		ScreenTools.render2D();
		font.bind();
		while (Keyboard.next()) {
			if (Keyboard.getEventKeyState()) {
				if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
					cy -= 0.05f;
					if (cy <= -0.20f)
						cy = -0.20f;
				}
				if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
					cy += 0.05f;
					if (cy >= -0.1f)
						cy = -0.1f;
				}
				if (Keyboard.isKeyDown(Keyboard.KEY_RETURN)) {
					if (cy == -0.1f) {
						state = MENUSTATE.GAME;
						game = new World();
					}
					if (cy == -0.15f)
						state = MENUSTATE.ABOUT;
					if (cy == -0.20f)
						dispose();
				}
			}
		}
		Text.renderString(font, ">", cx, cy, 1.2f, Color4f.WHITE);
		Text.renderString(font, "Play", 0f, -0.1f, 1.2f, Color4f.WHITE);
		Text.renderString(font, "About", 0f, -0.15f, 1.2f, Color4f.WHITE);
		Text.renderString(font, "Exit", 0f, -0.20f, 1.2f, Color4f.WHITE);
	}
	
	private void renderAbout(){
		ScreenTools.render2D();
		font.bind();
		Text.renderString(font, "This is my Ludum Dare 28 entry.", -0.5f, 0, 1, Color4f.WHITE);
	}
	
	private void renderDeath(){
		ScreenTools.render2D();
		font.bind();
		Text.renderString(font, "You Died!", -0.1f, 0, 1, Color4f.WHITE);
		Text.renderString(font, "Score: " + game.score, -0.1f, -0.05f, 1, Color4f.WHITE);
		Text.renderString(font, "Rounds Survived: " + World.currentMap, -0.1f, -0.10f, 1, Color4f.WHITE);
		Text.renderString(font, "Escape to return to menu", -0.1f, -0.15f, 1, Color4f.WHITE);
		if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
			state = MENUSTATE.MAIN;
		}
	}

	@Override
	public void update() {
		if (state == MENUSTATE.GAME) {
			game.update();
		}
	}

	@Override
	public void dispose() {
		if (state == MENUSTATE.GAME) {
			game.dispose();
		}
		TinySound.shutdown();
		Window.dispose();
		System.exit(0);
	}

	public static void main(String[] args) {
		Window.createWindow(Constants.WIDTH, Constants.HEIGHT,
				"LD28 - You only get one", false);
		new Main();
	}
}
